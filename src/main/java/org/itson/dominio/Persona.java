/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dominio;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.itson.utils.Encriptador;

/**
 * Esta clase representa la entidad Persona.
 *
 * @author Hugo Navarro (233470)/Jorge Sánchez(233012)
 */
//Pirata de Culiacán.
@Entity
@Table(name = "Personas")
public class Persona implements Serializable {

    /**
     * Identificador de una persona representado por su RFC.
     */
    @Id
    @Column(name = "RFC")
    public String rfc;

    /**
     * Nombres de la persona.
     */
    @Column(name = "Nombres", nullable = false)
//    @Convert(converter = Encriptador.class)
    private String nombres;

    /**
     * Apellido paterno de la persona.
     */
    @Column(name = "Apellido_paterno", nullable = false)
//    @Convert(converter = Encriptador.class)
    private String apellidoPaterno;

    /**
     * Apellido materno de la persona.
     */
    @Column(name = "Apellido_materno", nullable = false)
//    @Convert(converter = Encriptador.class)
    private String apellidoMaterno;

    /**
     * Teléfono de la persona.
     */
    @Column(name = "Telefono", nullable = false)
    private String telefono;

    /**
     * Fecha de nacimiento de la persona.
     */
    @Column(name = "Fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    /**
     * Lista de trámites asociados a la persona.
     */
    @OneToMany(mappedBy = "persona", cascade = {CascadeType.REMOVE})
    private List<Tramite> tramites;

    /**
     * Lista de vehículos asociados a la persona.
     */
    @OneToMany(mappedBy = "persona", cascade = {CascadeType.REMOVE})
    private List<Vehiculo> vehiculos;

    /**
     * Método getter para el atributo rfc.
     *
     * @return Identificador único de la persona en el sistema, correspondiente
     * a su RFC.
     */
    public String getRfc() {
        return rfc;
    }

    /**
     * Método setter para el atributo rfc.
     *
     * @param rfc Identificador único de la persona en el sistema,
     * correspondiente a su RFC.
     */
    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    /**
     * Método getter para el atributo fechaNacimiento.
     *
     * @return Fecha de nacimiento de la persona.
     */
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Setter de la fecha de nacimiento de la persona.
     *
     * @param fechaNacimiento Fecha de nacimiento de la persona.
     */
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Getter de los nombres de la persona.
     *
     * @return Nombres de la persona.
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * Setter de los nombres de la persona.
     *
     * @param nombres Nombres de la persona.
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * Getter del apellido paterno de la persona.
     *
     * @return Apellido paterno de la persona.
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Establece el apellido paterno de la persona.
     *
     * @param apellidoPaterno el apellido paterno de la persona.
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * Devuelve el apellido materno de la persona.
     *
     * @return el apellido materno de la persona.
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Establece el apellido materno de la persona.
     *
     * @param apellidoMaterno el apellido materno de la persona.
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * Devuelve el teléfono de la persona.
     *
     * @return el teléfono de la persona.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el teléfono de la persona.
     *
     * @param telefono el teléfono de la persona.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     *
     * Devuelve la lista de trámites realizados por la persona.
     *
     * @return la lista de trámites realizados por la persona.
     */
    public List<Tramite> getTramites() {
        return tramites;
    }

    /**
     *
     * Establece la lista de trámites realizados por la persona.
     *
     * @param tramites la nueva lista de trámites realizados por la persona.
     */
    public void setTramites(List<Tramite> tramites) {
        this.tramites = tramites;
    }

    /**
     *
     * Devuelve la lista de vehículos propiedad de la persona.
     *
     * @return la lista de vehículos propiedad de la persona.
     */
    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    /**
     *
     * Establece la lista de vehículos propiedad de la persona.
     *
     * @param vehiculos la nueva lista de vehículos propiedad de la persona.
     */
    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    /**
     * Devuelve un valor de hash para la persona basado en su RFC.
     *
     * @return un valor de hash para la persona.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.rfc);
        return hash;
    }

    /**
     * Compara esta persona con otro objeto para determinar si son iguales.
     *
     * @param obj el objeto a comparar con esta persona.
     * @return true si el objeto dado es igual a esta persona; false de lo
     * contrario.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Persona other = (Persona) obj;
        return Objects.equals(this.rfc, other.rfc);
    }

    /**
     * Constructor de la clase Persona.
     *
     * @param rfc RFC de la persona.
     * @param fechaNacimiento Fecha de nacimiento de la persona.
     * @param nombres Nombres de la persona.
     * @param apellidoPaterno Apellido paterno de la persona.
     * @param apellidoMaterno Apellido materno de la persona.
     * @param telefono Teléfono de la persona.
     */
    public Persona(String rfc, LocalDate fechaNacimiento, String nombres, String apellidoPaterno, String apellidoMaterno, String telefono) {
        this.rfc = rfc;
        this.fechaNacimiento = fechaNacimiento;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.telefono = telefono;
    }

    /**
     * Constructor por omisión de la clase Persona.
     */
    public Persona() {
    }

    /**
     * Constructor de la clase Persona que recibe únicamente el RFC.
     *
     * @param rfc RFC de la persona.
     */
    public Persona(String rfc) {
        this.rfc = rfc;
    }

    /**
     * Devuelve una cadena que representa el estado actual del objeto Persona.
     *
     * @return una cadena que representa el estado actual del objeto Persona
     */
    @Override
    public String toString() {
        return "Persona{" + "rfc=" + rfc + ", fechaNacimiento=" + fechaNacimiento + ", nombres=" + nombres + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", telefono=" + telefono + '}';
    }

}
