/**
 *
 * @author sirM
 */
package com.portafolio.TomasMazzzo.Dto;

import jakarta.validation.constraints.NotBlank;

public class dtoPerfil extends Object {

    @NotBlank
    private String nombreP;
    @NotBlank
    private String apellidoP;
    @NotBlank
    private String apodoP;
    @NotBlank
    private String imgP;

    // CONSTRUCTORES
    public dtoPerfil() {
    }

    public dtoPerfil(String nombreP, String apellidoP, String apodoP, String imgP) {
        this.nombreP = nombreP;
        this.apellidoP = apellidoP;
        this.apodoP = apodoP;
        this.imgP = imgP;
    }

    // GETTERS AND SETTERS
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

    public CharSequence getNombreE() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
