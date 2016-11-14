package br.engsoftware.websearch.control;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author cleversonc6
 */
public class JpaUtil 
{
    private static final String PERSISTENCE_UNIT_NAME = "weabsearch";
    
    private static final EntityManagerFactory emf = 
            Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    
    public static EntityManager getEntityManager()
    {
        return emf.createEntityManager();
    }
}// fim class
