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
 *Clase de tipo entity
 * @author Hugo Navarro (233470)/Jorge Sánchez(233012)
 */
@Entity
@Table(name = "Tramites")
@Inheritance(strategy = InheritanceType.JOINED)
public class Tramite implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Long id;

    @Column(name = "Fecha_expedicion", nullable = false)
    private Date fechaExpedicion;

    @Column(name = "Costo", nullable = false)
    private double costo;

    @ManyToOne
    @JoinColumn(name = "rfc_persona", referencedColumnName = "RFC", nullable = false)
    private Persona persona;

    public Date getFechaExpedicion() {
        return fechaExpedicion;
    }

    public void setFechaExpedicion(Date fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

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

    public Tramite(Long id, Date fechaExpedicion, double costo, Persona persona) {
        this.id = id;
        this.fechaExpedicion = fechaExpedicion;
        this.costo = costo;
        this.persona = persona;
    }

    public Tramite(Date fechaExpedicion, double costo, Persona persona) {
        this.fechaExpedicion = fechaExpedicion;
        this.costo = costo;
        this.persona = persona;
    }

    public Tramite(String nombre, String tipo, String fechaExpedicion, String costo) {
    }

    public Tramite() {
    }

    @Override
    public String toString() {
        return "org.itson.dominio.Tramite[ id=" + id + " ]";
    }

}
