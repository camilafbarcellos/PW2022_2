
package br.edu.ifsul.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import br.edu.ifsul.modelo.Estado;

/**
 *
 * @author 20202pf.cc0003
 */
public class TestePersistirEstado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("PW2022_2_ModelPU");
        EntityManager em = emf.createEntityManager();
        
        Estado e = new Estado();
        e.setNome("Rio Grande do Sul");
        e.setUf("RS");
        
        em.getTransaction().begin(); // inicia a transação
        em.persist(e); // persiste o estado
        em.getTransaction().commit(); // commita a transação
        em.close();
        emf.close();
    }
    
}
