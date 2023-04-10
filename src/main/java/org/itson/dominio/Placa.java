/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dominio;

import java.io.Serializable;
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
 * La clase Placa representa un trámite de expedición o renovación de una placa
 * de vehículo.
 *
 * Hereda de la clase Tramite y es una entidad de la base de datos.
 *
 * @author Hugo Navarro (233470)/Jorge Sánchez(233012)
 */
@Entity
@Table(name = "Placa")
public class Placa extends Tramite implements Serializable {

    /**
     * Identificador único de la placa, generado automáticamente por la base de
     * datos.
     */
    private static final long serialVersionUID = 1L;
    /**
     * Identificador único de la placa, generado automáticamente por la base de
     * datos.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Estado actual de la placa, si está vigente o no.
     */
    @Column(name = "Estado", nullable = false)
    private boolean estado;

    /**
     * Estado actual de la placa, si está vigente o no.
     */
    @Column(name = "Numero", nullable = false)
    private String numero;

    /**
     * Fecha en que se recibió la solicitud de trámite de la placa.
     */
    @Column(name = "Fecha_recepcion", nullable = false)
    private Date fechaRecepcion;

    /**
     * Vehículo al que se le asignará la placa.
     */
    @ManyToOne
    @JoinColumn(name = "No_serie", referencedColumnName = "No_serie")
    private Vehiculo vehiculo;

    /**
     * Retorna el identificador único de la placa.
     *
     * @return El identificador único de la placa.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador único de la placa.
     *
     * @param id El identificador único de la placa.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retorna el estado de la placa.
     *
     * @return El estado de la placa.
     */
    public boolean getEstado() {
        return estado;
    }

    /**
     * Establece el estado de la placa.
     *
     * @param estado El estado de la placa.
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    /**
     * Retorna el número de la placa.
     *
     * @return El número de la placa.
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Establece el número de la placa.
     *
     * @param numero El número de la placa.
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * Retorna la fecha de recepción de la placa.
     *
     * @return La fecha de recepción de la placa.
     */
    public Date getFechaRecepcion() {
        return fechaRecepcion;
    }

    /**
     * Establece la fecha de recepción de la placa.
     *
     * @param fechaRecepcion La fecha de recepción de la placa.
     */
    public void setFechaRecepcion(Date fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    /**
     * Retorna el vehículo asociado a la placa.
     *
     * @return El vehículo asociado a la placa.
     */
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    /**
     * Establece el vehículo asociado a la placa.
     *
     * @param vehiculo El vehículo asociado a la placa.
     */
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    /**
     *
     * Constructor de la clase Placa que recibe todos los atributos como
     * parámetros.
     *
     * @param id Identificador único de la placa.
     * @param estado Estado actual de la placa.
     * @param numero Número de la placa.
     * @param fechaRecepcion Fecha de recepción de la solicitud de trámite.
     * @param vehiculo Vehículo al que se asignará la placa.
     * @param TramiteId Identificador del trámite.
     * @param fechaExpedicion Fecha de expedición del trámite.
     * @param costo Costo del trámite.
     * @param persona Persona que solicita el trámite.
     */
    public Placa(Long id, boolean estado, String numero, Date fechaRecepcion, Vehiculo vehiculo, Long TramiteId, Date fechaExpedicion, double costo, Persona persona) {
        super(TramiteId, fechaExpedicion, costo, persona);
        this.id = id;
        this.estado = estado;
        this.numero = numero;
        this.fechaRecepcion = fechaRecepcion;
        this.vehiculo = vehiculo;
    }

    /**
     *
     * Constructor de la clase Placa que recibe algunos atributos como
     * parámetros.
     *
     * @param estado Estado actual de la placa.
     * @param numero Número de la placa.
     * @param fechaRecepcion Fecha de recepción de la solicitud de trámite.
     * @param vehiculo Vehículo al que se asignará la placa.
     * @param fechaExpedicion Fecha de expedición del trámite.
     * @param costo Costo del trámite.
     * @param persona Persona que solicita el trámite.
     */
    public Placa(boolean estado, String numero, Date fechaRecepcion, Vehiculo vehiculo, Date fechaExpedicion, double costo, Persona persona) {
        super(fechaExpedicion, costo, persona);
        this.estado = estado;
        this.numero = numero;
        this.fechaRecepcion = fechaRecepcion;
        this.vehiculo = vehiculo;
    }

    /**
     *
     * Crea una instancia de la clase Placa con el estado, número y vehículo
     * dados, junto con la fecha de expedición, costo y persona asociados al
     * trámite.
     *
     * @param estado el estado de la placa
     * @param numero el número de la placa
     * @param vehiculo el vehículo asociado a la placa
     * @param fechaExpedicion la fecha de expedición del trámite
     * @param costo el costo del trámite
     * @param persona la persona asociada al trámite
     */
    public Placa(boolean estado, String numero, Vehiculo vehiculo, Date fechaExpedicion, double costo, Persona persona) {
        super(fechaExpedicion, costo, persona);
        this.estado = estado;
        this.numero = numero;
        this.vehiculo = vehiculo;
    }

    /**
     * Constructor por omisión de la clase Placa.
     */
    public Placa() {
    }

    /**
     * Método que genera el hashcode de la instancia actual.
     *
     * @return el hashcode de la instancia actual.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /**
     * Método que genera el hashcode de la instancia actual.
     *
     * @return el hashcode de la instancia actual.
     */
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

    /**
     * Método que devuelve una cadena que representa a la instancia actual.
     *
     * @return una cadena que representa a la instancia actual.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Placa{");
        sb.append("id=").append(id);
        sb.append(", estado=").append(estado);
        sb.append(", numero=").append(numero);
        sb.append(", fechaRecepcion=").append(fechaRecepcion);
        sb.append(", vehiculo=").append(vehiculo);
        sb.append('}');
        return sb.toString();
    }

}
