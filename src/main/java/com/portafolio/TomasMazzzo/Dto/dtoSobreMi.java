/**
 *
 * @author sirM
 */
package com.portafolio.TomasMazzzo.Dto;

import jakarta.validation.constraints.NotBlank;

public class dtoSobreMi extends Object {

    @NotBlank
    private String textoSM;
    // CONSTRUCTORES

    public dtoSobreMi() {
    }

    public dtoSobreMi(String textoSM) {
        this.textoSM = textoSM;
    }

    // GETTERS AND SETTERS
    public String getTextoSM() {
        return textoSM;
    }

    public void setTextoSM(String textoSM) {
        this.textoSM = textoSM;
    }

}
