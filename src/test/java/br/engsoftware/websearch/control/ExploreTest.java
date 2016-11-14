package br.engsoftware.websearch.control;

import br.engsoftware.websearch.model.News;
import br.engsoftware.websearch.model.Site;
import java.io.IOException;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cleversonc6
 */
public class ExploreTest {
    
    public ExploreTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getDocument method, of class Explore.
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
     * Test of makeNews method, of class Explore.
     */
    @Test
    public void testMakeNews() 
    {
        System.out.println("makeNews");
        Site site = null;
        Explore instance = new Explore();
        List<News> expResult = null;
        List<News> result = instance.makeNews(site);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
