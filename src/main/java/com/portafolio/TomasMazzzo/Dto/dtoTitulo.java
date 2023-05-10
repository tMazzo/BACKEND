/**
 *
 * @author sirM
 */
package com.portafolio.TomasMazzzo.Dto;

import jakarta.validation.constraints.NotBlank;


public class dtoTitulo extends Object {
    @NotBlank
    private String nombreT;
    
    // CONSTRUCTORES

    public dtoTitulo() {
    }

    public dtoTitulo(String nombreT) {
        this.nombreT = nombreT;
    }
    
     // GETTERS AND SETTERS

    public String getNombreT() {
        return nombreT;
    }

    public void setNombreT(String nombreT) {
        this.nombreT = nombreT;
    }
    
}
