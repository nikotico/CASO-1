
package qr2;

import java.sql.*;
import javax.sql.PooledConnection;
import com.microsoft.sqlserver.jdbc.SQLServerXADataSource;

public class Qr2 {

    public static SQLServerXADataSource ds = new SQLServerXADataSource();
    public static PooledConnection pc = null;
    
    public static void consultaPool() throws SQLException {
        String sql1 =                 
                "use aseni declare "
        + "	@total int"
        + "            set @total = (select count(Party.id) as id from Party)"
        + "        begin"
        + "            Select c.name as 'Canton',COUNT( DISTINCT dc.id) as 'Entregables'"
        + "            FROM DelivPerCant as dc"
        + "            INNER JOIN Canton as c ON dc.canton_id = c.id"
        + "            INNER JOIN Deliverable as d ON dc.deli_id = d.id"
        + "            group by c.name"
        + "            Having @total*0.25 = COUNT( DISTINCT dc.id)"
        + "        end";
        pc = ds.getPooledConnection();
        try (Connection con = pc.getConnection(); Statement statement = con.createStatement()) {
            ResultSet set = statement.executeQuery(sql1);
            while (set.next()){
                String  cant = set.getString("Canton");
                int cantEntreg = set.getInt("Entregables");

                System.out.printf("Canton: %s \n Entregables: %d \n",cant, cantEntreg);
                System.out.println("");
            }
            
            con.clearWarnings();
            
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    public static void connect() throws SQLException{
        try{
            ds.setURL("jdbc:sqlserver://NIKOF:1433;databaseName=aseni;user=sa;password=admin");

        }catch (Exception e) {
            e.getMessage();
        }
    
    }
    
    
    public static void main(String[] args) throws SQLException, InterruptedException {
        connect();
        
        Thread hilo0 = new Hilos("hilo 0");
        Thread hilo1 = new Hilos("hilo 1");
        Thread hilo2 = new Hilos("hilo 2");
        Thread hilo3 = new Hilos("hilo 3");
        Thread hilo4 = new Hilos("hilo 4");
        Thread hilo5 = new Hilos("hilo 5");
        Thread hilo6 = new Hilos("hilo 6");
        Thread hilo7 = new Hilos("hilo 7");
        Thread hilo8 = new Hilos("hilo 8");
        Thread hilo9 = new Hilos("hilo 9");
        
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

        //Duracion media de un JBDC + inline query + pool en JAVA : 0.55 mili
        
        
        /*
            Los datos pueden cambiar ya que al incertar los datos, los entregables se dan aleatorios, el unico que no cambia es grecia
            ese esta forzado a tener 1 solo entregable, esto por efecto de pruebas en el query 2

            Duracion de los 10 hilos : 0,57
            Canton: Grecia                                                                                                                                                                                                                                                          
             Entregables: 1 
            Canton: Grecia                                                                                                                                                                                                                                                          
             Entregables: 1 

            Canton: Grecia                                                                                                                                                                                                                                                          
             Entregables: 1 

            Canton: Grecia                                                                                                                                                                                                                                                          
             Entregables: 1 

            Canton: Grecia                                                                                                                                                                                                                                                          
             Entregables: 1 

            Canton: Grecia                                                                                                                                                                                                                                                          
             Entregables: 1 

            Canton: Grecia                                                                                                                                                                                                                                                          
             Entregables: 1 

            Canton: Grecia                                                                                                                                                                                                                                                          
             Entregables: 1 

            Canton: Grecia                                                                                                                                                                                                                                                          
             Entregables: 1 

            Canton: Grecia                                                                                                                                                                                                                                                          
             Entregables: 1 
        */
    }
}
