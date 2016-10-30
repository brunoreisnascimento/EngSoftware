package br.engsoftware.websearch.control;

import br.engsoftware.websearch.control.interfaces.I_Explorer;
import br.engsoftware.websearch.model.News;
import br.engsoftware.websearch.model.Site;
import java.util.List;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * @author cleversonc6
 * @since 25/10/2016
 * @version 0.0.1
 */
public class Explore implements I_Explorer
{

    private List<Site> listSite;
    private News news;
    private String key;
    
    public Explore(String keySearch)
    {   }
    

    @Override
    public Document getDocument(Site site) 
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Elements getContent(Document doc, Site site) 
    {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
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
    
    
    public News getNews()
    { return this.news;   }
    
}