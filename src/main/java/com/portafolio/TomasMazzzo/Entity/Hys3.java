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
public class Hys3 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int id;
    private String nombreS;
    private String colorS;
    private int porcentajeS;

    // CONSTRUCTORES
    public Hys3() {
    }

    public Hys3(String nombreS, String logoS, int porcentajeS) {
        this.nombreS = nombreS;
        this.colorS = logoS;
        this.porcentajeS = porcentajeS;
    }

    // GETTERS AND SETTERS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreS() {
        return nombreS;
    }

    public void setNombreS(String nombreS) {
        this.nombreS = nombreS;
    }

    public String getColorS() {
        return colorS;
    }

    public void setColorS(String colorS) {
        this.colorS = colorS;
    }

    public int getPorcentajeS() {
        return porcentajeS;
    }

    public void setPorcentajeS(int porcentajeS) {
        this.porcentajeS = porcentajeS;
    }

}
