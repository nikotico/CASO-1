
package qr2;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Hilos  extends Thread  {
    
    public String name;
    
    public Hilos (String name) throws InterruptedException{
        this.name = name;
        if(this.name == "hilo 9")
            sleep(2000);
            //Cuando sea el ultimo hilo creado haga un sleep para dale chance al codigo ejecutarse
    }
    
    public void Thconsulta() throws SQLException{
        qr2Pool c = new qr2Pool();
        c.consulta();
    }
    
    public void run(){
        try {
            Thconsulta();
        } catch (SQLException ex) {
            Logger.getLogger(Hilos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
