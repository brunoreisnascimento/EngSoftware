package br.engsoftware.websearch.control.interfaces;

import br.engsoftware.websearch.model.Site;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * @author cleverson
 * @since 25/10/2016
 * @version 1.0.0
 */
public interface I_Explorer 
{
  /**
  * Retorna o html de uma url passada
 * @author cleversonc6
     * @param site
 * @since 04/11/2016
 * @return Document
 */
    Document getDocument(Site site);
    
 /**
  * Retorna os elementos, do documento, que constam na lista de atributos do site
 * @author cleversonc6
     * @param doc
     * @param site
 * @since 04/11/2016
 * @version 0.0.1
 * @return Document
 */
    Elements getContent(Document doc, Site site);
    
}//fim interface