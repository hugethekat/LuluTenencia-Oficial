/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dominio;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.OneToMany;

/**
 *
 * @author xeron
 */
@Entity
public class Persona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RFC")
    private String rfc;

    @Column(name = "Fecha_nacimiento", nullable = false)
    private Date fechaNacimiento;

    @Column(name = "Nombres", nullable = false)
    private String nombres;

    @Column(name = "Apellido_paterno", nullable = false)
    private String apellidoPaterno;

    @Column(name = "Apellido_materno", nullable = false)
    private String apellidoMaterno;

    @Column(name = "Telefono", nullable = false)
    private String telefono;

    @OneToMany(mappedBy = "persona", cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    private List<Tramite> tramites;
    
    @OneToMany(mappedBy = "persona", cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    private List<Vehiculo> vehiculos;
    
    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
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

    public Persona(String rfc, Date fechaNacimiento, String nombres, String apellidoPaterno, String apellidoMaterno, String telefono) {
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
