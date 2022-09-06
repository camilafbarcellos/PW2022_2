
package br.edu.ifsul.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Estado;

/**
 *
 * @author 20202pf.cc0003
 */
public class TestePersistirCidade {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        EntityManagerFactory emf = 
                Persistence.createEntityManagerFactory("PW2022_2_ModelPU");
        EntityManager em = emf.createEntityManager();
        
        Estado e = em.find(Estado.class, 2); // encontra o estado para setar na cidade
        Cidade c = new Cidade();
        c.setNome("Passo Fundo");
        c.setEstado(e); // seta o estado retornado pelo find
        
        em.getTransaction().begin(); // inicia a transação
        em.persist(c); // persiste a cidade
        em.getTransaction().commit(); // commita a transação
        em.close();
        emf.close();
    }
    
}
