package com.example.ComercioAPP.modelos;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {

    //id nombres correo contraseña
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nombres;
    private String correo; 
    private String contarseña;
    
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public String getNombres() {
        return nombres;
    }
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getContarseña() {
        return contarseña;
    }
    public void setContarseña(String contarseña) {
        this.contarseña = contarseña;
    }

    

}
