/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dominio;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author xeron
 */
@Entity
@Table(name = "Placa")
public class Placa extends Tramite implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "Estado", nullable = false)
    private boolean estado;

    @Column(name = "Numero", nullable = false)
    private String numero;

    @Column(name = "Fecha_recepcion", nullable = false)
    private Date fechaRecepcion;

    @ManyToOne
    @JoinColumn(name = "No_serie", referencedColumnName = "No_serie")
    private Vehiculo vehiculo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Placa(Long id, boolean estado, String numero, Date fechaRecepcion, Vehiculo vehiculo, Long TramiteId, LocalDate fechaExpedicion, double costo, Persona persona) {
        super(TramiteId, fechaExpedicion, costo, persona);
        this.id = id;
        this.estado = estado;
        this.numero = numero;
        this.fechaRecepcion = fechaRecepcion;
        this.vehiculo = vehiculo;
    }

    public Placa(boolean estado, String numero, Date fechaRecepcion, Vehiculo vehiculo, LocalDate fechaExpedicion, double costo, Persona persona) {
        super(fechaExpedicion, costo, persona);
        this.estado = estado;
        this.numero = numero;
        this.fechaRecepcion = fechaRecepcion;
        this.vehiculo = vehiculo;
    }

    public Placa() {
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
        if (!(object instanceof Placa)) {
            return false;
        }
        Placa other = (Placa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.itson.dominio.Placa[ id=" + id + " ]";
    }

}
