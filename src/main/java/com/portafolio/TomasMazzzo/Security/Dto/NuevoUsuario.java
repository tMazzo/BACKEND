/**
 *
 * @author sirM
 */
package com.portafolio.TomasMazzzo.Security.Dto;

import java.util.HashSet;
import java.util.Set;

public class NuevoUsuario {

    private String nombre;
    private String nombreUsuario;
    private String mail;
    private String password;
    private Set<String> roles = new HashSet<>();

    // GETTERS AND SETTERS
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

}
