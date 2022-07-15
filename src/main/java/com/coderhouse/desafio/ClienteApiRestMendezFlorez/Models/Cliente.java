package com.coderhouse.desafio.ClienteApiRestMendezFlorez.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table (name = "CLIENTE")
public class Cliente {


    // Constructores
    public Cliente() {
    }

    public Cliente(Integer dni, String nombre, String apellido, String fechaNacimiento) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;

    }

    // Columas de la tabla
    @Id
    @Column (name = "DNI")
    private Integer dni;
    @Column (name = "NOMBRE")
    private String nombre;

    @Column (name = "APELLIDO")
    private String apellido;

    @Column (name = "FECHANACIMIENTO")
    private String fechaNacimiento;


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


    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
