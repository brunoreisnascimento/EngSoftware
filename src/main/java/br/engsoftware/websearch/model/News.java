/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.engsoftware.websearch.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author cleverson
 * @version 1.0.0
 * @since 05/11/2016
 */
@Entity
@Table(name = "news", catalog = "websearch", schema = "")
public class News implements Serializable 
{
    private static final long serialVersionUID = -734547113339582812L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "url")
    private String url;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "titulo")
    private String titulo;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "dataNoticia")    
    private String dataNoticia;

    public News()
    {    }

    public News(String url) 
    {
        this.url = url;
    }

    public News(String url, String titulo, String dataNoticia) 
    {
        this.url = url;
        this.titulo = titulo;
        this.dataNoticia = dataNoticia;
    }

    public String getUrl() 
    {
        return url;
    }

    public void setUrl(String url) 
    {
        this.url = url;
    }

    public String getTitulo() 
    {
        return titulo;
    }

    public void setTitulo(String titulo) 
    {
        this.titulo = titulo;
    }

    public String getDataNoticia() 
    {
        return dataNoticia;
    }

    public void setDataNoticia(String dataNoticia) 
    {
        this.dataNoticia = dataNoticia;
    }

    @Override
    public boolean equals(Object obj) 
    {
        if(obj == null || !(obj instanceof News))
            return false;        
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
    
    
}
