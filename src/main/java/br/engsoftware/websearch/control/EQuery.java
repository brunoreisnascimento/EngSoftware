/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.engsoftware.websearch.control;

/**
 *
 * @author cleversonc6
 */
public class EQuery 
{
    public enum SITE
    {
        FindAll("SELECT s FROM Site s"),
        FindByUrl("SELECT s FROM Site s WHERE s.url = :url"),
        FindByTags("SELECT s FROM Site s WHERE s.tags = :tags");        
        
        private final String query;
        
        SITE(String query)
        { this.query = query;  }
        
        public String getString()
        { return this.query; }        
    }//fim SITE
    
    public enum NEWS
    {
        FindAll("SELECT n FROM News n"),
        FindByUrl("SELECT n FROM News n WHERE n.url = :url"),
        FindByTitulo("SELECT n FROM News n WHERE n.titulo = :titulo"),
        FindByDataNoticia("SELECT n FROM News n WHERE n.dataNoticia = :dataNoticia");
        
        private final String query;
        
        NEWS(String query)
        { this.query = query; }

        public String getQuery() 
        {  return query;   }
        
        
    }
}
