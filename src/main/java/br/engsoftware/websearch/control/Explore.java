package br.engsoftware.websearch.control;

import br.engsoftware.websearch.control.interfaces.I_Explorer;
import br.engsoftware.websearch.model.News;
import br.engsoftware.websearch.model.Site;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @author cleverson
 * @since 04/11/2016
 * @version 1.0.0
 */
public class Explore implements I_Explorer
{

    private List<Site> listSite;
    private List<News> listNews;
    private News news;
    private String key;
    private String tagContainer;
    private String tagPost;
    private String tagData;
    private static final String link = "a[href]";

    public Explore() 
    {    }
    
    
    public Explore(String keySearch)
    {   this.key = keySearch;   }   
    
                
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
    
    /**
     * Retorna uma lista<News> de determinado site
     * @param site
     * @return 
     */
    public List<News> makeNews(Site site)
    {                
        Document doc = this.getDocument(site);
        
        this.tagContainer = site.getTags().get(0);
        this.tagPost = site.getTags().get(1);
        this.tagData = site.getTags().get(2);
        
        
        Elements els = doc.select(tagContainer);
        
         for (Element el : els) 
         {
            News n = new News();
            Element e = el.select(tagPost).first();   
            n.setTitulo(e.text());           
            n.setUrl(e.select(this.link).toString());
            n.setDataNoticia(el.getElementsByClass(tagData).text());        
            
            this.listNews.add(n);
        }
        return this.listNews;
    }
        
    
}//fim class