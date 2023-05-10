/**
 *
 * @author sirM
 */
package com.portafolio.TomasMazzzo.Dto;

import jakarta.validation.constraints.NotBlank;

public class dtoContacto extends Object{

    @NotBlank
    private String telefonoC;
    @NotBlank
    private String emailC;

    // CONSTRUCTORES
    public dtoContacto() {
    }

    public dtoContacto(String telefonoC, String emailC) {
        this.telefonoC = telefonoC;
        this.emailC = emailC;
    }
    // GETTERS AND SETTERS

    public String getTelefonoC() {
        return telefonoC;
    }

    public void setTelefonoC(String telefonoC) {
        this.telefonoC = telefonoC;
    }

    public String getEmailC() {
        return emailC;
    }

    public void setEmailC(String emailC) {
        this.emailC = emailC;
    }

}
