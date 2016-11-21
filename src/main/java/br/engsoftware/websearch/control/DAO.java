package br.engsoftware.websearch.control;

import br.engsoftware.websearch.control.interfaces.I_DAO;
import br.engsoftware.websearch.model.News;
import br.engsoftware.websearch.model.Site;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * @author cleversonc6
 * @since 08/11/2016
 * @version 1.0.0
 */
public class DAO implements I_DAO
{
    public DAO() 
    {   }    

    @Override
    public EntityManager getEntityManager() 
    {
        return JpaUtil.getEntityManager();
    }
        
    @Override
    public Object getObject(Object obj, String id) 
    {
        EntityManager em = this.getEntityManager();  
        
        return em.getReference(obj.getClass(), id);      
    }        
    
    @Override
    public void delete(Object object, String id)
    {
        EntityManager em = this.getEntityManager();
        try 
        {
            em.getTransaction().begin();
                Object obj = em.find(object.getClass(), id);
                if(obj != null)
                    em.remove(obj);
            em.getTransaction().commit();
        }
        catch (Exception e) 
        {
            System.err.println("ERROR!");
            em.getTransaction().rollback();
        }
        finally
        {
            em.close();
        }
    }   
    
    @Override
    public List<Object> getObejcts(String query)
    {
        EntityManager em = this.getEntityManager();
        
        Query q = em.createQuery(query);
        
        return q.getResultList();        
    }    
    
    @Override
    public void save(Object object)
    {
        EntityManager em = this.getEntityManager();
        try 
        {
            em.getTransaction().begin();
                if(object instanceof Site)
                {
                    Site s = (Site) object;
                    this.saveSite(s, em);
                }
                else
                    if(object instanceof News)
                    {
                        News n = (News) object;
                        this.saveNews(n, em);
                    }
            em.getTransaction().commit();
        } catch (Exception e) 
        {
            System.out.println("ERROR!");
            em.getTransaction().rollback();
        }
        finally
        {
            em.close();
        }
    }    
    
    private void saveNews(News news, EntityManager em) 
    {
        if(this.getObject(news, news.getUrl()) == null)
            em.persist(news);
        else
            em.merge(news);          
    }
    
    private void saveSite(Site site, EntityManager em) 
    {
        if(this.getObject(site, site.getUrl()) == null)
            em.persist(site);
        else
            em.merge(site);
    }      
            
}//fim class
