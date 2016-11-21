/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.engsoftware.websearch.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author cleverson
 * @version 1.0.0
 * @since 05/11/2016
 */
@Entity
@Table(name = "site", catalog = "websearch", schema = "")
public class Site implements Serializable 
{

    private static final long serialVersionUID = 5738899195111394770L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "url")    
    private String url;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "tags")
    private List<String> tags;

    public Site() 
    { 
        tags = new ArrayList<>();
    }

    public Site(String url) 
    {
        this.url = url;
        tags = new ArrayList<>();
    }

    public Site(String url, String tag) 
    {
        this.url = url;
        this.tags.add(tag);
        tags = new ArrayList<>();
    }

    public String getUrl() 
    {    return url;   }

    public void setUrl(String url) 
    {    this.url = url;   }

    public List<String> getTags() 
    {    return tags;    }

    public void setTags(String tag) 
    {    this.tags.add(tag);   }

    @Override
    public int hashCode() 
    {
        int hash = 59;
        hash = 63 * hash + Objects.hashCode(this.url);
        return hash;
    }

    @Override
    public boolean equals(Object obj) 
    {
        if(obj == null || !(obj instanceof Site))
            return false;        
        Site other = (Site) obj;
        
        return other.url.equalsIgnoreCase(this.url);
    }
    
    @Override
    public String toString()
    {
        String tgs = "";
        
        this.tags.stream().forEach((tag) -> tgs.concat(tag+";"));
        
        return ("Site : " + this.url + "\n" + "Tags: " + tgs);
    }
        
}//fim class
