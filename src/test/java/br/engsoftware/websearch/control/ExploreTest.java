package br.engsoftware.websearch.control;

import br.engsoftware.websearch.model.News;
import br.engsoftware.websearch.model.Site;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author cleversonc6
 * @see News
 * @version 0.0.1
 */
public class ExploreTest 
{
    /**
     * Testes do getDocument()
     */
    @Test
    public void testGetDocument() 
    {
        System.out.println("getDocument");
        Site site = null;
        Explore instance = null;
        Document expResult = null;
        Document result = instance.getDocument(site);
        assertEquals(expResult, result);
        fail("Falhou!");
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
