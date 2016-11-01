package br.engsoftware.websearch.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * @author cleversonc6
 * @since 25/10/2016
 * @version 0.0.1
 */
public class News implements Serializable
{

    private static final long serialVersionUID = -734547113339582812L;
    private long id;
    private String url;
    private String titulo;
    private Date dataNoticia;

    public News() 
    {    }

    public News(String url, String titulo, Date dataNoticia) 
    {
        this.url = url;
        this.titulo = titulo;
        this.dataNoticia = dataNoticia;
    }

    public void setUrl(String url) 
    {
        this.url = url;
    }

    public void setTitulo(String titulo) 
    {
        this.titulo = titulo;
    }

    public void setDataNoticia(Date dataNoticia) 
    {
        this.dataNoticia = dataNoticia;
    }
   
    @Override
    public boolean equals(Object obj) 
    {
        if(obj == null || !(obj instanceof News)) {
            return false;
        } else {
        }
        
        News other = (News) obj;
        
        return other.url.equalsIgnoreCase(this.url);
    }

    @Override
    public int hashCode() 
    {
        int hash = 27;
        hash = 59 * hash + Objects.hashCode(this.url);
        return hash;
    }
    
    
    
    
    
    
}//fim class