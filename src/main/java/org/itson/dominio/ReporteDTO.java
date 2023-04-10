/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dominio;

import java.time.LocalDate;

/**
 *
 * clase DTO utilizada para consultar reportes.
 *
 * @author Hugo Navarro (233470)/Jorge Sanchez(233012)
 */
public class ReporteDTO {

    private String nombre, tipo, costo, fechaExpedicion;
    private LocalDate inicio, fin;

    /**
     * Constructor para los paramatros de busqueda que se utilizaran en los
     * filtros del método consultarReporte de TramitesDAO
     *
     * @param nombre nombre de la persona
     * @param tipo tipo del trámite
     * @param inicio inicio periodo ingresado
     * @param fin fin periodo ingresado
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
     * @param nombre nombre de la persona
     * @param tipo tipo del trámite
     * @param costo costo del trámite
     * @param fechaExpedicion fecha de expedición del trámite
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
     * @param nombre nombre de la persona
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
     * @param tipo tipo de trámite.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Método que regresa el inicio del periodo.
     *
     * @return inicio inicio del periodo.
     */
    public LocalDate getInicio() {
        return inicio;
    }

    /**
     * Método que asigna el inicio del periodo.
     *
     * @param inicio inicio del periodo.
     */
    public void setInicio(LocalDate inicio) {
        this.inicio = inicio;
    }

    /**
     * Método que regresa el fin del periodo.
     *
     * @return fin del periodo.
     */
    public LocalDate getFin() {
        return fin;
    }

    /**
     * Método que asigna el fin del periodo.
     *
     * @param fin fin del periodo.
     */
    public void setFin(LocalDate fin) {
        this.fin = fin;
    }

    /**
     *
     * Devuelve el costo del objeto.
     *
     * @return El costo del objeto como un String.
     */
    public String getCosto() {
        return costo;
    }

    /**
     *
     * Establece el costo del objeto.
     *
     * @param costo El costo del objeto como un String.
     */
    public void setCosto(String costo) {
        this.costo = costo;
    }

    /**
     *
     * Devuelve la fecha de expedición del objeto.
     *
     * @return La fecha de expedición del objeto como un String.
     */
    public String getFechaExpedicion() {
        return fechaExpedicion;
    }

    /**
     *
     * Establece la fecha de expedición del objeto.
     *
     * @param fechaExpedicion La fecha de expedición del objeto como un String.
     */
    public void setFechaExpedicion(String fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }

}
