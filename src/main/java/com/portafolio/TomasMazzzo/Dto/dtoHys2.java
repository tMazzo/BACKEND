/**
 *
 * @author sirM
 */
package com.portafolio.TomasMazzzo.Dto;

import jakarta.validation.constraints.NotBlank;

public class dtoHys2 extends Object {

    @NotBlank
    private String nombreS;
    @NotBlank
    private String colorS;
    @NotBlank
    private int porcentajeS;

    // CONSTRUCTORES
    public dtoHys2() {
    }
        public dtoHys2(String nombreS, String logoS, int porcentajeS) {
        this.nombreS = nombreS;
        this.colorS = logoS;
        this.porcentajeS = porcentajeS;
    }
    
    // GETTERS AND SETTERS

    public String getNombreS() {
        return nombreS;
    }

    public void setNombreS(String nombreS) {
        this.nombreS = nombreS;
    }

    public String getColorS() {
        return colorS;
    }

    public void setColorS(String logoS) {
        this.colorS = logoS;
    }

    public int getPorcentajeS() {
        return porcentajeS;
    }

    public void setPorcentajeS(int porcentajeS) {
        this.porcentajeS = porcentajeS;
    }

    

    

}
