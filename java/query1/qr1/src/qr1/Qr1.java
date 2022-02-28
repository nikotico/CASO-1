
package qr1;

import com.sun.tools.javac.Main;
import java.sql.*;


public class Qr1 {

    public static Connection c = null;
    
    public static void MainConnect() throws SQLException{
        try {
            conectar();
        } finally {
            cerrar();
        }
    }
    
    public static void conectar() throws SQLException{
        try {
            c = DriverManager.getConnection("jdbc:sqlserver://NIKOF:1433;databaseName=aseni;user=sa;password=admin");
            System.out.println("Conectado a la base de datos");
        } catch (Exception e) {
            System.out.println("Exception 2: "+e);
        }
    }
    
    public static void cerrar() throws SQLException{
        if(c != null)
            c.close();
    }
    
    public static void consulta(String hilo,String canton) throws SQLException{
        Statement sta = c.createStatement();
        ResultSet set = sta.executeQuery("exec qr1 @canton =  "+canton);
        System.out.println(hilo+","+canton+":");
        while (set.next()){
            
            int cantEntreg = set.getInt("Entregables");
            String  part = set.getString("Partido");
            
            System.out.printf("Partido: %s \n Entregables: %d \n",part, cantEntreg);
            System.out.println("");
        }
    
    }
    
    
    public static void main(String[] args) throws SQLException, InterruptedException {
        conectar();
        
        Thread hilo0 = new Hilos("hilo 0","Alajuela");
        Thread hilo1 = new Hilos("hilo 1","Grecia");
        Thread hilo2 = new Hilos("hilo 2","Naranjo");
        Thread hilo3 = new Hilos("hilo 3","Atenas");
        Thread hilo4 = new Hilos("hilo 4","Alajuela");
        Thread hilo5 = new Hilos("hilo 5","Grecia");
        Thread hilo6 = new Hilos("hilo 6","Naranjo");
        Thread hilo7 = new Hilos("hilo 7","Atenas");
        Thread hilo8 = new Hilos("hilo 8","Alajuela");
        Thread hilo9 = new Hilos("hilo 9","Grecia");
        
        //El hilo nueve hace un sleep 2 de segundos para dale chance al procedor de ejecutar todo
        
        long startTime = System.nanoTime();
        hilo0.start();
        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
        hilo5.start();
        hilo6.start();
        hilo7.start();
        hilo8.start();
        hilo9.start();
        
        long endTime = System.nanoTime();
        
        float duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        
        System.out.printf("Duracion de los 10 hilos : %.2f \n", (duration / 1000000));

        //Duracion media de un JBDC + SP en JAVA : 0.56 mili
        /*
            Los datos pueden cambiar ya que al incertar los datos, los entregables se dan aleatorios, el unico que no cambia es grecia
            ese esta forzado a tener 1 solo entregable, esto por efecto de pruebas en el query 2
        
            Duracion de los 10 hilos : 0,53 

            hilo 0,Alajuela:
            Partido: PAC                                                                                                                                                                                                                                                             
             Entregables: 1 

            Partido: PLN                                                                                                                                                                                                                                                             
             Entregables: 1 

            Partido: PSD                                                                                                                                                                                                                                                             
             Entregables: 2 
        
            hilo 1,Grecia:
            Partido: PSD                                                                                                                                                                                                                                                             
             Entregables: 1 

            hilo 9,Grecia:
            Partido: PSD                                                                                                                                                                                                                                                             
             Entregables: 1 

            hilo 2,Naranjo:
            Partido: PAC                                                                                                                                                                                                                                                             
             Entregables: 2 

            Partido: PLN                                                                                                                                                                                                                                                             
             Entregables: 2 

            Partido: PSD                                                                                                                                                                                                                                                             
             Entregables: 1 

            Partido: PUSC                                                                                                                                                                                                                                                            
             Entregables: 2 
            
            hilo 8,Alajuela:
            Partido: PAC                                                                                                                                                                                                                                                             
             Entregables: 1 
        
            Partido: PLN                                                                                                                                                                                                                                                             
             Entregables: 1 

            Partido: PSD                                                                                                                                                                                                                                                             
             Entregables: 2 

            hilo 7,Atenas:
            Partido: PAC                                                                                                                                                                                                                                                             
             Entregables: 1 

            Partido: PLN                                                                                                                                                                                                                                                             
             Entregables: 2 

            Partido: PUSC                                                                                                                                                                                                                                                            
             Entregables: 1 

            hilo 6,Naranjo:
            Partido: PAC                                                                                                                                                                                                                                                             
             Entregables: 2 

            Partido: PLN                                                                                                                                                                                                                                                             
             Entregables: 2 

            Partido: PSD                                                                                                                                                                                                                                                             
             Entregables: 1 

            Partido: PUSC                                                                                                                                                                                                                                                            
             Entregables: 2 

            hilo 5,Grecia:
            Partido: PSD                                                                                                                                                                                                                                                             
             Entregables: 1 

            hilo 3,Atenas:
            Partido: PAC                                                                                                                                                                                                                                                             
             Entregables: 1 

            Partido: PLN                                                                                                                                                                                                                                                             
             Entregables: 2 

            Partido: PUSC                                                                                                                                                                                                                                                            
             Entregables: 1 

            hilo 4,Alajuela:
            Partido: PAC                                                                                                                                                                                                                                                             
             Entregables: 1 

            Partido: PLN                                                                                                                                                                                                                                                             
             Entregables: 1 

            Partido: PSD                                                                                                                                                                                                                                                             
             Entregables: 2 

            BUILD SUCCESSFUL (total time: 3 seconds)


        */
    }
}
