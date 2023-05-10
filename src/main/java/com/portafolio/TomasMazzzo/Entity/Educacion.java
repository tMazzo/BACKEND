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
public class Educacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String anioE;
    private String nombreE;
    private String localidadE;
    private String descripcionE;

    // CONSTRUCTORES
    public Educacion() {
    }

    public Educacion(String anioE, String nombreE, String localidadE, String descripcionE) {
        this.anioE = anioE;
        this.nombreE = nombreE;
        this.localidadE = localidadE;
        this.descripcionE = descripcionE;
    }

    // GETTERS AND SETTERS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
