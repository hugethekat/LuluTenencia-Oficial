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
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.itson.utils.Encriptador;

/**
 *
 * @author Hugo Navarro (233470)/Jorge Sánchez(233012)
 */
//Pirata de Culiacán.
@NamedQuery(
        name = "Persona.buscarPorFiltros",
        query = "SELECT p FROM Persona p WHERE (:rfc IS NULL OR p.rfc = :rfc) AND "
        + "(:nombre IS NULL OR (p.nombres LIKE CONCAT('%', :nombre, '%') OR "
        + "p.apellidoPaterno LIKE CONCAT('%', :nombre, '%') OR "
        + "p.apellidoMaterno LIKE CONCAT('%', :nombre, '%'))) AND "
        + "(:anioNacimiento IS NULL OR FUNCTION('YEAR', p.fechaNacimiento) = :anioNacimiento)"
)

@Entity
@Table(name = "Personas")
public class Persona implements Serializable {

    @Id
    @Column(name = "RFC")
    public String rfc;

    @Column(name = "Nombres", nullable = false)
//    @Convert(converter = Encriptador.class)
    private String nombres;

    @Column(name = "Apellido_paterno", nullable = false)
//    @Convert(converter = Encriptador.class)
    private String apellidoPaterno;

    @Column(name = "Apellido_materno", nullable = false)
//    @Convert(converter = Encriptador.class)
    private String apellidoMaterno;

    @Column(name = "Telefono", nullable = false)
    private String telefono;

    @Column(name = "Fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    @OneToMany(mappedBy = "persona", cascade = {CascadeType.REMOVE})
    private List<Tramite> tramites;

    @OneToMany(mappedBy = "persona", cascade = {CascadeType.REMOVE})
    private List<Vehiculo> vehiculos;

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Tramite> getTramites() {
        return tramites;
    }

    public void setTramites(List<Tramite> tramites) {
        this.tramites = tramites;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.rfc);
        return hash;
    }

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

    public Persona(String rfc, LocalDate fechaNacimiento, String nombres, String apellidoPaterno, String apellidoMaterno, String telefono) {
        this.rfc = rfc;
        this.fechaNacimiento = fechaNacimiento;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.telefono = telefono;
    }

    public Persona() {
    }

    public Persona(String rfc) {
        this.rfc = rfc;
    }

    @Override
    public String toString() {
        return "Persona{" + "rfc=" + rfc + ", fechaNacimiento=" + fechaNacimiento + ", nombres=" + nombres + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", telefono=" + telefono + '}';
    }

}
