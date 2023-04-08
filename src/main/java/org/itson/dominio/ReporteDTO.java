/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dominio;

import java.time.LocalDate;

/**
 *
 * @author xeron
 */
public class ReporteDTO {

    private String nombre, tipo, costo, fechaExpedicion;
    private LocalDate inicio, fin;

    /**
     * Constructor para los paramatros de busqueda que se utilizaran en los
     * filtros del método consultarReporte de TramitesDAO
     *
     * @param nombre
     * @param tipo
     * @param inicio
     * @param fin
     */
    public ReporteDTO(String nombre, String tipo, LocalDate inicio, LocalDate fin) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.inicio = inicio;
        this.fin = fin;
    }

    /**
     * Constructor pa que jalen los reportes ainomas.
     *
     * @param nombre
     * @param tipo
     * @param costo
     * @param fechaExpeidcion
     */
    public ReporteDTO(String nombre, String tipo, String fechaExpedicion, String costo) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.fechaExpedicion = fechaExpedicion;
        this.costo = costo;
    }

    /**
     * Método que regresa el nombre.
     *
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método que asigna el nombre.
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método que regresa el tipo de trámite.
     *
     * @return tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Método que asigna el tipo de trámite.
     *
     * @param tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Método que regresa el inicio del periodo.
     *
     * @return inicio
     */
    public LocalDate getInicio() {
        return inicio;
    }

    /**
     * Método que asigna el inicio del periodo.
     *
     * @param inicio
     */
    public void setInicio(LocalDate inicio) {
        this.inicio = inicio;
    }

    /**
     * Método que regresa el fin del periodo.
     *
     * @return
     */
    public LocalDate getFin() {
        return fin;
    }

    /**
     * Método que asigna el fin del periodo.
     *
     * @param fin
     */
    public void setFin(LocalDate fin) {
        this.fin = fin;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public String getFechaExpedicion() {
        return fechaExpedicion;
    }

    public void setFechaExpedicion(String fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }

}
