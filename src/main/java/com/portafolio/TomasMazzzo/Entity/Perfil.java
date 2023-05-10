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
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String nombreP;
    private String apellidoP;
    private String apodoP;
    private String imgP;

    // CONSTRUCTORES
    public Perfil() {
    }

    public Perfil(String nombreP, String apellidoP, String apodoP, String imgP) {
        this.nombreP = nombreP;
        this.apellidoP = apellidoP;
        this.apodoP = apodoP;
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

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApodoP() {
        return apodoP;
    }

    public void setApodoP(String apodoP) {
        this.apodoP = apodoP;
    }

    public String getImgP() {
        return imgP;
    }

    public void setImgP(String imgP) {
        this.imgP = imgP;
    }
    
    
    
    
}



