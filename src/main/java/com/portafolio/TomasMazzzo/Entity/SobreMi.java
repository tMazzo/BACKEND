
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
public class SobreMi {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int id;
    private String textoSM;
    
    // CONSTRUCTORES

    public SobreMi() {
    }

    public SobreMi(String textoSM) {
        this.textoSM = textoSM;
    }
    
    // GETTERS AND SETTERS

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTextoSM() {
        return textoSM;
    }

    public void setTextoSM(String textoSM) {
        this.textoSM = textoSM;
    }
    
}
