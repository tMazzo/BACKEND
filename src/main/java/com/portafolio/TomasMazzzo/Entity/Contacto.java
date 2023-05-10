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
public class Contacto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int id;
    private String telefonoC;
    private String emailC;

    
    // CONSTRUCTORES
    public Contacto() {
    }
    public Contacto(String telefonoC, String emailC) {
        this.telefonoC = telefonoC;
        this.emailC = emailC;
    }

    // GETTERS AND SETTERS

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
