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
public class Titulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String nombreT;

    // CONSTRUCTORES
    public Titulo() {
    }

    public Titulo(String nombreT) {
        this.nombreT = nombreT;
    }

    // GETTERS AND SETTERS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreT() {
        return nombreT;
    }

    public void setNombreT(String nombreT) {
        this.nombreT = nombreT;
    }

}
