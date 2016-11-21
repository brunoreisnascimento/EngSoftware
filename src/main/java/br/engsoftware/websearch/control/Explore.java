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
 * @since 10/11/2016
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
    {   
        listNews = new ArrayList<>();
    }
    
    
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
     * Retorna uma lista<News>
     * @see News
     * @param site
     * @return lista<News>
     */
    private List<News> makeNews(Site site)
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
            n.setUrl(e.select(Explore.link).toString());
            n.setDataNoticia(el.getElementsByClass(tagData).text());        
            
            this.listNews.add(n);
        }
        return this.listNews;
    }
    
    private List<News> olharDigital()
    {
        String u = null;
        List<News> lista = null;
        for (int i = 1; i < 11; i++) 
        {
            u = "http://olhardigital.uol.com.br/noticias/";
            u = u+i;        
        Site s = new Site(u);
        s.setTags("div.post-meta");
        s.setTags("h3");
        s.setTags("date");
        
        lista = this.makeNews(s);
        }
        return lista;
    }    
  
    
    public List<News> getNews(Site site)
    {
        if(site.getUrl().equalsIgnoreCase("http://olhardigital.uol.com.br/noticias/") )
            return this.olharDigital();
        else
            return this.makeNews(site);
    }
  
        
        
}//fim class