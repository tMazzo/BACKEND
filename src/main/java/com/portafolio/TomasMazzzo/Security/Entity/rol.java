/**
 *
 * @author sirM
 */
package com.portafolio.TomasMazzzo.Security.Entity;

import jakarta.persistence.Entity;
import com.portafolio.TomasMazzzo.Security.Enums.RolNombre;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
        
@Entity
public class rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    @Enumerated(EnumType.STRING)
    private RolNombre rolNombre;
    
    
    // CONSTRUCTORES
    public rol() {
    }

    public rol(RolNombre rolNombre) {
        this.rolNombre = rolNombre;
    }
    
    
    // GETTERS AND SETTERS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RolNombre getRolNombre() {
        return rolNombre;
    }

    public void setRolNombre(RolNombre rolNombre) {
        this.rolNombre = rolNombre;
    }
    
}
