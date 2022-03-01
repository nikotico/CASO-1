// See https://aka.ms/new-console-template for more information

/*
https://dotnet.microsoft.com/en-us/learn/dotnet/hello-world-tutorial/create
https://www.youtube.com/watch?v=AY--cwVJk24&ab_channel=hdeleon.net
https://www.mssqltips.com/sqlservertip/5677/how-to-get-started-with-sql-server-and-net/

dotnet add package Microsoft.Data.SqlClient

dotnet run

*/
using System;
using System.Diagnostics;
using System.Threading;
using Microsoft.Data.SqlClient;

//"Server=***;Initial Catalog=***;Persist Security Info=False;User  ID=***;Password=***;MultipleActiveResultSets=False;Encrypt=False;TrustServerCertificate=False;Connection Timeout=30;";
function.Main();
public class Globals
{
    public string connString = @"Server=NIKOF;Initial Catalog=aseni;Persist Security Info=False;
    User ID=sa;Password=admin;
    MultipleActiveResultSets=False;Encrypt=False;TrustServerCertificate=False;
    Connection Timeout=30;Connection Lifetime=0;Min Pool Size=2;Max Pool Size=20;Pooling=true";
    //Linea 26: Ajusto los pooling, tamanios y tiempos de ejecucion
    public SqlConnection conn = null;
    public SqlCommand cmd = null;
}
/*
Explicacion al final
El tiempo promedio es de 1,3 ms
Los tiempos me dan muy parecidos, pero comprobe con el uso del pooling a gran escala de ve mejor la diferencia
*/
public static class function
{
    public static void Main()
    {

        Thread t0 = new Thread(new ThreadStart(consulta));
        Thread t1 = new Thread(new ThreadStart(consulta));
        Thread t2 = new Thread(new ThreadStart(consulta));
        Thread t3 = new Thread(new ThreadStart(consulta));
        Thread t4 = new Thread(new ThreadStart(consulta));
        Thread t5 = new Thread(new ThreadStart(consulta));
        Thread t6 = new Thread(new ThreadStart(consulta));
        Thread t7 = new Thread(new ThreadStart(consulta));
        Thread t8 = new Thread(new ThreadStart(consulta));
        Thread t9 = new Thread(new ThreadStart(consulta));
        
        Thread.Sleep(2000);//Tiempo para el procesador para ejecutar todo

        Stopwatch timeMeasure = new Stopwatch();
        timeMeasure.Start();
        /*
            Este codigo es solo para pruebas, ya que note que el uso del pooling se ve mejor reflejado a gran escala
            
            for (int i = 0; i < 1000; i++){consulta();}
         */

        t0.Start();
        t1.Start();
        t2.Start();
        t3.Start();
        t4.Start();
        t5.Start();
        t6.Start();
        t7.Start();
        t8.Start();
        t9.Start();

        timeMeasure.Stop();
        Console.WriteLine($"Tiempo: {timeMeasure.Elapsed.TotalMilliseconds} ms");
        Console.WriteLine("Canton \t Entregables");

    }

    public static void consulta()
    {

        Globals instance = new Globals();
        try
        {
            using (instance.conn = new SqlConnection(instance.connString))//Se habre la connection)
            {
                //retrieve the SQL Server instance version
                string query = @"exec qr2";

                instance.cmd = new SqlCommand(query, instance.conn);

                //open connection
                instance.conn.Open();

                //execute the SQLCommand
                SqlDataReader dr = instance.cmd.ExecuteReader();

                //check if there are records
                if (dr.HasRows)
                {
                    while (dr.Read())
                    {
                        //display retrieved record
                        String canton = (dr.GetString(0).Trim());
                        Console.WriteLine(canton + " \t" + dr.GetInt32(1));
                    }
                }
                else
                {
                    Console.WriteLine("No data found.");
                }
                instance.conn.Close();
                dr.Close();
            }
        }
        catch (Exception ex)
        {
            //display error message
            Console.WriteLine("ERROR: ");
            Console.WriteLine("Exception: " + ex.Message);
        }
    }
    /*

    Ya que al los entregables se dan de forma aletaria, force que
        Tiempo: 1,2277 ms
        Canton   Entregables
        Grecia  1
        Grecia  1
        Grecia  1
        Grecia  1
        Grecia  1
        Grecia  1
        Grecia  1
        Grecia  1
        Grecia  1
        Grecia  1

    */
}