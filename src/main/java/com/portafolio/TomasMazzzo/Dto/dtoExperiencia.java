/**
 *
 * @author sirM
 */
package com.portafolio.TomasMazzzo.Dto;

import jakarta.validation.constraints.NotBlank;


public class dtoExperiencia extends Object {
    
    @NotBlank
    private String anioE;
    @NotBlank
    private String nombreE;
    @NotBlank
    private String localidadE;
    @NotBlank
    private String descripcionE;
    
    
    // CONSTRUCTORES

    public dtoExperiencia() {
    }

    public dtoExperiencia(String anioE, String nombreE, String localidadE, String descripcionE) {
        this.anioE = anioE;
        this.nombreE = nombreE;
        this.localidadE = localidadE;
        this.descripcionE = descripcionE;
    }
    
    // GETTERS AND SETTERS

    public String getAnioE() {
        return anioE;
    }

    public void setAnioE(String anioE) {
        this.anioE = anioE;
    }

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getLocalidadE() {
        return localidadE;
    }

    public void setLocalidadE(String localidadE) {
        this.localidadE = localidadE;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }

    
    
    
}