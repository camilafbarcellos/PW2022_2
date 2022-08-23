
package testes;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Estado;

/**
 *
 * @author 20202pf.cc0003
 */
public class TesteListarEstado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("PW2022_2_ModelPU");
        EntityManager em = emf.createEntityManager();
        
        List<Estado> lista = 
                em.createQuery("from Estado order by nome").getResultList(); // comando da operação
                                    // Estado é o nome da classe em Java, pois no BD está "estado"
        
        for (Estado e : lista) {
            System.out.println("ID: "+e.getId()+" Nome: "+e.getNome()+" UF: "+e.getUf());
        }
        
        em.close();
        emf.close();
    }
    
}
