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
import javax.persistence.Table;

/**
 * Esta clase representa la entidad Licencia, que hereda de la clase abstracta
 * tramite y es utilizada para modelar la información de una licencia en el
 * sistema.
 *
 * @author Hugo Navarro (233470)/Jorge Sánchez(233012)
 */
@Entity
@Table(name = "Licencias")
public class Licencia extends Tramite implements Serializable {

    /**
     * Identificador de una licencia.
     */
    private static final long serialVersionUID = 1L;
    /**
     * Identificador de una licencia.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Estado de una licencia representando si ésta se encuentra activa o no.
     */
    @Column(name = "Estado", nullable = false)
    private boolean estado;

    /**
     * Columna que representa si la licencia se está brindando a una persona
     * discapacitada.
     */
    @Column(name = "Discapacitado", nullable = false)
    private boolean discapacitado;

    /**
     * Columna que representa la vigencia de una Licencia
     */
    @Column(name = "Vigencia", nullable = false)
    private int vigencia;

    /**
     * Devuelve el estado de la Licencia.
     *
     * @return true si la Licencia está activa, false si está inactiva.
     */
    public boolean isEstado() {
        return estado;
    }

    /**
     * Establece el estado de la Licencia.
     *
     * @param estado true si la Licencia está activa, false si está inactiva.
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    /**
     * Devuelve true si la Licencia pertenece a una persona con discapacidad.
     *
     * @return true si la Licencia pertenece a una persona con discapacidad,
     * false en caso contrario.
     */
    public boolean isDiscapacitado() {
        return discapacitado;
    }

    /**
     * Establece si la Licencia pertenece a una persona con discapacidad.
     *
     * @param discapacitado true si la Licencia pertenece a una persona con
     * discapacidad, false en caso contrario.
     */
    public void setDiscapacitado(boolean discapacitado) {
        this.discapacitado = discapacitado;
    }

    /**
     * Devuelve la vigencia de la Licencia.
     *
     * @return la vigencia de la Licencia en meses.
     */
    public int getVigencia() {
        return vigencia;
    }

    /**
     * Establece la vigencia de la Licencia.
     *
     * @param vigencia la vigencia de la Licencia en meses.
     */
    public void setVigencia(int vigencia) {
        this.vigencia = vigencia;
    }

    /**
     * Calcula y devuelve el valor hash de la Licencia.
     *
     * @return el valor hash de la Licencia.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /**
     * Compara la Licencia con otro objeto dado.
     *
     * @param object el objeto a comparar.
     * @return true si los objetos son iguales, false en caso contrario.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Licencia)) {
            return false;
        }
        Licencia other = (Licencia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    /**
     *
     * Devuelve una representación en cadena de la Licencia.
     *
     * @return una representación en cadena de la Licencia.
     */
    @Override
    public String toString() {
        return "Licencia{" + "id=" + id + ", estado=" + estado + ", discapacitado=" + discapacitado + ", vigencia=" + vigencia + '}';
    }

    /**
     *
     * Constructor de la clase Licencia que recibe todos los atributos
     * necesarios para inicializar un objeto Licencia.
     *
     * @param id Identificador único de la licencia.
     * @param estado Estado actual de la licencia.
     * @param discapacitado Indica si la persona posee algún tipo de
     * discapacidad.
     * @param vigencia Tiempo de vigencia de la licencia.
     * @param TramiteId Identificador del trámite.
     * @param fechaExpedicion Fecha de expedición de la licencia.
     * @param costo Costo de la licencia.
     * @param persona Objeto de la clase Persona que representa a la persona a
     * la que se le otorgó la licencia.
     */
    public Licencia(Long id, boolean estado, boolean discapacitado, int vigencia, Long TramiteId, Date fechaExpedicion, double costo, Persona persona) {
        super(TramiteId, fechaExpedicion, costo, persona);
        this.id = id;
        this.estado = estado;
        this.discapacitado = discapacitado;
        this.vigencia = vigencia;
    }

    /**
     *
     * Constructor de la clase Licencia que recibe los parámetros básicos para
     * crear un objeto de tipo Licencia.
     *
     * @param estado boolean que representa el estado de la licencia.
     * @param discapacitado boolean que indica si la persona que obtiene la
     * licencia es discapacitada.
     * @param vigencia int que representa la vigencia de la licencia en años.
     * @param fechaExpedicion Date que indica la fecha de expedición de la
     * licencia.
     * @param costo double que representa el costo de la licencia.
     * @param persona Persona a la que se le está otorgando la licencia.
     */
    public Licencia(boolean estado, boolean discapacitado, int vigencia, Date fechaExpedicion, double costo, Persona persona) {
        super(fechaExpedicion, costo, persona);
        this.estado = estado;
        this.discapacitado = discapacitado;
        this.vigencia = vigencia;
    }

    /**
     * Constructor por omisión de la clase Licencia
     */
    public Licencia() {
    }

}
