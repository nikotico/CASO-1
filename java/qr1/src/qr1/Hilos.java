/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qr1;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fgm_o
 */
public class Hilos  extends Thread  {
    
    public String canton;
    public String name;
    
    public Hilos (String name,String canton) throws InterruptedException{
        this.name = name;
        this.canton = canton;
        if(this.name == "hilo 9")
            sleep(2000);
            //Cuando sea el ultimo hilo creado haga un sleep para dale chance al codigo ejecutarse
    }
    
    public void Thconsulta() throws SQLException{
        Qr1.consulta(this.name,this.canton);
    }
    
    public void run(){
        try {
            Thconsulta();
        } catch (SQLException ex) {
            Logger.getLogger(Hilos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
