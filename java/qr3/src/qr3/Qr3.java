/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qr3;
/**
 *
 * @author fgm_o
 */
import relation.*;
import java.util.List;
import javax.persistence.*;

public class Qr3 {

    /**
     * @param args the command line arguments
     */
    private static EntityManager man;
    private static EntityManagerFactory emf;
    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("Persis");
        man = emf.createEntityManager();
        List<Userr> user;
        user = (List<Userr> )man.createQuery("SELECT * FROM Userr ").getResultList();
        System.out.println(user.size());
    }
    
}
