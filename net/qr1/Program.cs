// See https://aka.ms/new-console-template for more information

/*
https://dotnet.microsoft.com/en-us/learn/dotnet/hello-world-tutorial/create
https://www.youtube.com/watch?v=AY--cwVJk24&ab_channel=hdeleon.net
https://www.mssqltips.com/sqlservertip/5677/how-to-get-started-with-sql-server-and-net/

dotnet add package Microsoft.Data.SqlClient

dotnet run

*/
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Microsoft.Data.SqlClient ;
using System.Data;  

//"Server=***;Initial Catalog=***;Persist Security Info=False;User  ID=***;Password=***;MultipleActiveResultSets=False;Encrypt=False;TrustServerCertificate=False;Connection Timeout=30;";
string connString =@"Server=NIKOF;Initial Catalog=aseni;Persist Security Info=False;User ID=sa;Password=admin;MultipleActiveResultSets=False;Encrypt=False;TrustServerCertificate=False;Connection Timeout=30;";

try
{
    using (SqlConnection conn = new SqlConnection(connString))
    {
        //retrieve the SQL Server instance version
        string query = @"SELECT * FROM qr3Min";

        SqlCommand cmd = new SqlCommand(query, conn);

        //open connection
        conn.Open();

        //execute the SQLCommand
        SqlDataReader dr = cmd.ExecuteReader();

        //check if there are records
        if (dr.HasRows)
        {
            while (dr.Read())
            {
                //display retrieved record (first column only/string value)
                String partido = ( dr.GetString(0).Trim()  );
                String accion = ( dr.GetString(1).Trim() );
                String canton = ( dr.GetString(2).Trim() );
                Console.WriteLine(partido+" \t"+accion+" \t"+canton+" "+dr.GetInt32(3));
            }
        }
        else
        {
            Console.WriteLine("No data found.");
        }
        dr.Close();
    }
}
catch (Exception ex)
{
    //display error message
    Console.WriteLine("Exception: " + ex.Message);
}
