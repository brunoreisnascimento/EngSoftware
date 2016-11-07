package br.engsoftware.websearch.control;

import br.engsoftware.websearch.model.News;
import br.engsoftware.websearch.model.Site;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author cleverson
 * @version 1.0.0
 */
public class ExploreTest 
{
    
    
    /**
     * Testes do getDocument()
     */
    @Test
    public void testGetDocument() 
    {
        try 
        {
            System.out.println("getDocument");
            Explore instance = new Explore();
            Document expResult;       
                    
            Site site = new Site("http://br-linux.org");                    
            expResult = Jsoup.connect("http://br-linux.org").get();            
            
            assertEquals(expResult, instance.getDocument(site));
            fail("Falhou!");
        } 
        catch (IOException ex) 
        {
            System.err.println(ex.getMessage());
        }
    }

    /**
     * Teste do getContent()
     */
    @Test
    public void testGetContent() 
    {
        System.out.println("getContent");
        Document doc = null;
        Site site = null;
        Explore instance = null;
        Elements expResult = null;
        Elements result = instance.getContent(doc, site);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Teste do existNews
     */
    @Test
    public void testExistsNews() 
    {
        System.out.println("existsNews");
        Elements ele = null;
        String key = "";
        Explore instance = null;
        boolean expResult = false;
        boolean result = instance.existsNews(ele, key);
        assertEquals(expResult, result);
        fail("Falhou!");
    }

    /**
     * Teste do makeNews()
     */
    @Test
    public void testMakeNews() 
    {
        System.out.println("makeNews");
        Elements ele = null;
        String tag = "";
        Explore instance = null;
        News expResult = null;
        News result = instance.makeNews(ele, tag);
        assertEquals(expResult, result);
       fail("Falhou!");
       
    }

    /**
     * Teste getNews()
     */
    @Test
    public void testGetNews() {
        System.out.println("getNews");
        Explore instance = null;
        News expResult = null;
        News result = instance.getNews();
        assertEquals(expResult, result);
        fail("Falhou!");
    }
    
}
