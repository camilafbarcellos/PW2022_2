
package br.edu.ifsul.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import br.edu.ifsul.modelo.Estado;

/**
 *
 * @author 20202pf.cc0003
 */
public class TesteAlterarEstado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("PW2022_2_ModelPU");
        EntityManager em = emf.createEntityManager();
        
        Estado e = em.find(Estado.class, 2);
        e.setNome("Santa Catarina");
        e.setUf("SC");
        
        em.getTransaction().begin(); // inicia a transação
        em.merge(e); // método para realizar update
        em.getTransaction().commit(); // commita a transação
        em.close();
        emf.close();
    }
    
}
