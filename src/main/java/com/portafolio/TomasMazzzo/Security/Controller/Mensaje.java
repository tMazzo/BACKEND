/**
 *
 * @author sirM
 */
package com.portafolio.TomasMazzzo.Security.Controller;


public class Mensaje {
    private String mensaje;
    
    // CONSTRUCTORES

    public Mensaje() {
    }

    public Mensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    
    // GETTERS AND SETTERS

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
}
