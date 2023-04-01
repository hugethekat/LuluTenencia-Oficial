/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dominio;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author xeron
 */
@Entity
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

    public String getNoSerie() {
        return noSerie;
    }

    public void setNoSerie(String noSerie) {
        this.noSerie = noSerie;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

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





}
