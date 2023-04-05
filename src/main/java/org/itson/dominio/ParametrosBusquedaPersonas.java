/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dominio;

import java.time.LocalDate;

/**
 *
 * @author JORGE
 */
public class ParametrosBusquedaPersonas {
    private String rfc;
    private String nombre;
    private Integer fechaNac;

    public ParametrosBusquedaPersonas(String rfc, String nombre, Integer fechaNac) {
        this.rfc = rfc;
        this.nombre = nombre;
        this.fechaNac = fechaNac;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Integer fechaNac) {
        this.fechaNac = fechaNac;
    }
    
    
    
}
