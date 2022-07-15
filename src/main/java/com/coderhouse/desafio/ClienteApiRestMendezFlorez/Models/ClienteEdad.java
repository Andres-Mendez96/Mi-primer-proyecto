package com.coderhouse.desafio.ClienteApiRestMendezFlorez.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "CLIENTEEDAD")
public class ClienteEdad {


    // Constructores
    public ClienteEdad() {
    }

    public ClienteEdad(Integer dni, String nombre, String apellido, Integer edad) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;

    }

    // Columas de la tabla
    @Id
    @Column (name = "DNI")
    private Integer dni;
    @Column (name = "NOMBRE")
    private String nombre;

    @Column (name = "APELLIDO")
    private String apellido;

    @Column (name = "EDAD")
    private Integer edad;


    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }
}
