package br.engsoftware.websearch.control;

import br.engsoftware.websearch.control.interfaces.I_Explorer;
import br.engsoftware.websearch.model.News;
import br.engsoftware.websearch.model.Site;
import java.io.IOException;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * @author cleverson
 * @since 04/11/2016
 * @version 1.0.0
 */
public class Explore implements I_Explorer
{

    private List<Site> listSite;
    private News news;
    private String key;

    public Explore() 
    {    }
    
    
    public Explore(String keySearch)
    {   this.key = keySearch;   }   
    
    
    /**
     * Verifica se determinada noticia determinada pela chava existe nos sites cadastrados
     * @param ele
     * @param key
     * @return boolean
     */
    public boolean existsNews(Elements ele, String key)
    {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    /**
     * Cria o objeto News 
     * @param ele
     * @param tag
     * @return 
     */
    public News makeNews(Elements ele, String tag)
    {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    public void setKey(String key) 
    {
        this.key = key;
    }

    public String getKey() 
    {
        return key;
    }   
    
    
    public News getNews()
    { return this.news;   }
    

    /**
     * Verifica se a url e a conexão estão corretas e se estiver retorna o html do site
     * @param site
     * @return 
     */
    @Override
    public Document getDocument(Site site) 
    {
        Document doc = null; 
        try 
        {
            doc = Jsoup.connect(site.getUrl()).get();
        } 
        catch (IOException ex) 
        {
            System.err.println(ex.getMessage());
        }        
         
         return doc;
    }

    @Override
    public Elements getContent(Document doc, Site site) 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}