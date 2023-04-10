/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dominio;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Clase de tipo Entity que representa un Tramite.
 *
 * Esta clase representa un trámite, es la clase padre de Licencia y Placa.
 * clase mediante
 *
 * @author Hugo Navarro (233470)/Jorge Sánchez(233012)
 */
@Entity
@Table(name = "Tramites")
@Inheritance(strategy = InheritanceType.JOINED)
public class Tramite implements Serializable {

    /**
     * Identificador del trámite.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Long id;

    /**
     * Fecha de expedición del trámite.
     */
    @Column(name = "Fecha_expedicion", nullable = false)
    private Date fechaExpedicion;

    /**
     * Costo del trámite.
     */
    @Column(name = "Costo", nullable = false)
    private double costo;

    /**
     * RFC de la persona de la que se saca el trámite.
     */
    @ManyToOne
    @JoinColumn(name = "rfc_persona", referencedColumnName = "RFC", nullable = false)
    private Persona persona;

    /**
     *
     * Método que retorna la fecha en la que se expidió el Tramite.
     *
     * @return La fecha de expedición del Tramite
     */
    public Date getFechaExpedicion() {
        return fechaExpedicion;
    }

    /**
     *
     * Método que modifica la fecha de expedición del Tramite.
     *
     * @param fechaExpedicion La nueva fecha de expedición del Tramite
     */
    public void setFechaExpedicion(Date fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }

    /**
     *
     * Obtiene el costo asociado a este trámite.
     *
     * @return El costo asociado a este trámite.
     */
    public double getCosto() {
        return costo;
    }

    /**
     * Establece el costo asociado a este trámite.
     *
     * @param costo El nuevo costo a establecer.
     */
    public void setCosto(double costo) {
        this.costo = costo;
    }

    /**
     *
     * Obtiene la persona que realizó este trámite.
     *
     * @return La persona que realizó este trámite.
     */
    public Persona getPersona() {
        return persona;
    }

    /**
     * Establece la persona que realizó este trámite.
     *
     * @param persona La nueva persona a establecer como realizadora del
     * trámite.
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    /**
     * Obtiene el ID único de este trámite.
     *
     * @return El ID único de este trámite.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID único para este trámite
     *
     * @param id El ID único de este trámite.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * Método que genera el código hash de la instancia de la clase Tramite.
     *
     * @return el código hash de la instancia de la clase Tramite.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /**
     *
     * Método que compara la instancia de la clase Tramite con otro objeto.
     *
     * @param object el objeto a comparar con la instancia de la clase Tramite.
     * @return true si son iguales, false si son diferentes.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tramite)) {
            return false;
        }
        Tramite other = (Tramite) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    /**
     *
     * Constructor de la clase Tramite que recibe como parámetros el id, fecha
     * de expedición, costo y persona.
     *
     * @param id el id del tramite.
     * @param fechaExpedicion la fecha de expedición del tramite.
     * @param costo el costo del tramite.
     * @param persona la persona relacionada con el tramite.
     */
    public Tramite(Long id, Date fechaExpedicion, double costo, Persona persona) {
        this.id = id;
        this.fechaExpedicion = fechaExpedicion;
        this.costo = costo;
        this.persona = persona;
    }

    /**
     *
     * Constructor de la clase Tramite que recibe como parámetros la fecha de
     * expedición, costo y persona.
     *
     * @param fechaExpedicion la fecha de expedición del tramite.
     * @param costo el costo del tramite.
     * @param persona la persona relacionada con el tramite.
     */
    public Tramite(Date fechaExpedicion, double costo, Persona persona) {
        this.fechaExpedicion = fechaExpedicion;
        this.costo = costo;
        this.persona = persona;
    }

    /**
     *
     * Crea una nueva instancia de Tramite con los valores especificados para
     * sus atributos.
     *
     * @param nombre nombre del Tramite (no utilizado)
     * @param tipo tipo del Tramite (no utilizado)
     * @param fechaExpedicion la fecha en la que se expedido el Tramite
     * @param costo el costo del Tramite
     */
    public Tramite(String nombre, String tipo, String fechaExpedicion, String costo) {
    }

    /**
     * Constructor por omisión.
     */
    public Tramite() {
    }

    /**
     *
     * Retorna una representación en String de esta instancia de Tramite.
     *
     * @return una representación en String de esta instancia de Tramite
     */
    @Override
    public String toString() {
        return "org.itson.dominio.Tramite[ id=" + id + " ]";
    }

}
