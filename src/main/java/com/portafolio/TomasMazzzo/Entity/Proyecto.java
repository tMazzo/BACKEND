/**
 *
 * @author sirM
 */
package com.portafolio.TomasMazzzo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String nombreP;
    private String descripcionP;
    private String linkP;
    private String imgP;

    // CONSTRUCTORES
    public Proyecto() {
    }

    public Proyecto(String nombreP, String descripcionP, String linkP, String imgP) {
        this.nombreP = nombreP;
        this.descripcionP = descripcionP;
        this.linkP = linkP;
        this.imgP = imgP;
    }
    
    // GETTERS AND SETTERS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public String getDescripcionP() {
        return descripcionP;
    }

    public void setDescripcionP(String descripcionP) {
        this.descripcionP = descripcionP;
    }

    public String getLinkP() {
        return linkP;
    }

    public void setLinkP(String linkP) {
        this.linkP = linkP;
    }

    public String getImgP() {
        return imgP;
    }

    public void setImgP(String imgP) {
        this.imgP = imgP;
    }

}
