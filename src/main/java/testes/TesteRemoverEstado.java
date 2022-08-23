
package testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Estado;

/**
 *
 * @author 20202pf.cc0003
 */
public class TesteRemoverEstado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("PW2022_2_ModelPU");
        EntityManager em = emf.createEntityManager();
        
        Estado e = em.find(Estado.class, 2);
        
        em.getTransaction().begin(); // inicia a transação
        em.remove(e); // método para realizar delete
        em.getTransaction().commit(); // commita a transação
        em.close();
        emf.close();
    }
    
}
