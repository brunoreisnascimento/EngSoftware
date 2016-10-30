package br.engsoftware.websearch.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

/**
 * @author cleversonc6
 * @since 25/10/2016
 * @version 0.0.1
 */
public class Site implements Serializable
{
    private static final long serialVersionUID = 1125166136079916766L;
    private long id;
    private String url;
    private Set<String> tags;

    public Site() 
    {    }

    public Site(long id, String url, String tag) 
    {
        this.id = id;
        this.url = url;
        this.tags.add(tag);
    }

    public void setUrl(String url) 
    {
        this.url = url;
    }

    public String getUrl() 
    {
        return url;
    }

    public void setTags(String tag) 
    {
       this.tags.add(tag);
    }

    public Set<String> getTags() 
    {
        return tags;
    }

    @Override
    public boolean equals(Object obj) 
    {
        if((obj == null) || !(obj instanceof Site))
            return false;
        
        Site other = (Site) obj;
        
        return other.url.equalsIgnoreCase(this.url);
    }

    @Override
    public int hashCode() {
        int hash = 59;
        hash = 27 * hash + Objects.hashCode(this.url);
        return hash;
    }
    
    
    
}//fim class
