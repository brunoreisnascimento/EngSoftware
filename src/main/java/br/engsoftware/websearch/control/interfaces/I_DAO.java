package br.engsoftware.websearch.control.interfaces;

import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author cleversonc6
 */
public interface I_DAO 
{
    /**
     * Retorna uma instância da EntityManager
     * @return EntityManager 
     */
    EntityManager getEntityManager();
    
    /**
     * Persiste uma instância (da classe passada) no Banco de dados
     * @param object 
     */
    void save(Object object);
    
    
    /**
     * Remove do Banco de dados o objeto correspondente ao ID
     * @param obj
     * @param id 
     */
    public void delete(Object obj, String id);
    
    /**
     * Retorna um objeto (da mesma classe passada por parâmetro)
     * @param obj
     * @param id
     * @return object
     */
    Object getObject(Object obj, String id);
    
    /**
     * Retorna uma lista com todos os objetos
     * @return List<Object>
     */
    List<Object> getObejcts(String query);
    
}
