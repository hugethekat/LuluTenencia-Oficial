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

    /**
     * Constructor para los paramatros de busqueda que se utilizaran en los filtros del método consultarPersonas de PersonDAO
     * @param rfc filtro para buscar por el rfc
     * @param nombre filtro para buscar por nombre
     * @param fechaNac filtro para buscar por año de nacimiento
     */
    public ParametrosBusquedaPersonas(String rfc, String nombre, Integer fechaNac) {
        this.rfc = rfc;
        this.nombre = nombre;
        this.fechaNac = fechaNac;
    }

    /**
     * Método que regresa el rfc obtenido para filtro
     * @return cadena de texto que regresa un rfc
     */
    public String getRfc() {
        return rfc;
    }

    /**
     * Método que asigna un rfc 
     * @param rfc cadena de texto que se le asigna a la variable rfc
     */
    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    /**
     * Método que regresa el nombre obtenido para el filtro
     * @return cadena de texto que regresa un nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método que asigna un nombre
     * @param nombre cadena de texto que se le asigna a la variable nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método que regresa el año de nacimiento obtenido para el filtro
     * @return número representativo que regresa el año de nacimiento
     */
    public Integer getFechaNac() {
        return fechaNac;
    }

    /**
     * Método que asigna un año de nacimiento 
     * @param fechaNac número que se le asigna a la variable fechaNac
     */
    public void setFechaNac(Integer fechaNac) {
        this.fechaNac = fechaNac;
    }
    
    
    
}
