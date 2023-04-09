/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dominio;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *Clase de tipo entity que mapea los atributos de vehículo
 * @author Hugo Navarro (233470)/Jorge Sánchez(233012)
 */
@Entity
@Table(name = "Vehiculos")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_vehiculo")
public class Vehiculo implements Serializable {

    
    @Id
    @Column(name = "No_serie", nullable = false)
    private String noSerie;

    @Column(name = "Color", nullable = false)
    private String color;

    @Column(name = "Linea", nullable = false)
    private String linea;

    @Column(name = "Marca", nullable = false)
    private String marca;

    @Column(name = "Modelo", nullable = false)
    private String modelo;

    @ManyToOne
    @JoinColumn(name = "rfc_persona", referencedColumnName = "RFC", nullable = false)
    private Persona persona;

    @OneToMany(mappedBy = "vehiculo")
    private List<Placa> placas;

    /**
     * Obtiene el número de serie del vehículo
     * @return el número de serie del vehículo
     */
    public String getNoSerie() {
        return noSerie;
    }

    /**
     * Asigna un número de serie al vehículo
     * @param noSerie número de serie de vehículo
     */
    public void setNoSerie(String noSerie) {
        this.noSerie = noSerie;
    }

    /**
     * Obtiene el color representativo del vehículo
     * @return color del vehículo
     */
    public String getColor() {
        return color;
    }

    /**
     * Asigna el color representativo del vehículo
     * @param color cadena de texto que representa el color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * 
     * @return 
     */
    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<Placa> getPlacas() {
        return placas;
    }

    public void setPlacas(List<Placa> placas) {
        this.placas = placas;
    } 
    
    /**
     * 
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.noSerie);
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
        final Vehiculo other = (Vehiculo) obj;
        return Objects.equals(this.noSerie, other.noSerie);
    }

    public Vehiculo(String noSerie, String color, String linea, String marca, String modelo, Persona persona) {
        this.noSerie = noSerie;
        this.color = color;
        this.linea = linea;
        this.marca = marca;
        this.modelo = modelo;
        this.persona = persona;
    }

    public Vehiculo(String color, String linea, String marca, String modelo, Persona persona) {
        this.color = color;
        this.linea = linea;
        this.marca = marca;
        this.modelo = modelo;
        this.persona = persona;
    }

    public Vehiculo() {
    }
}
