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
 * Clase de tipo entity que mapea los atributos de vehículo
 *
 * @author Hugo Navarro (233470)/Jorge Sánchez(233012)
 */
@Entity
@Table(name = "Vehiculos")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_vehiculo")
public class Vehiculo implements Serializable {

    /**
     * Identificador del vehículo representado por el número de serie.
     */
    @Id
    @Column(name = "No_serie", nullable = false)
    private String noSerie;

    /**
     * Color del vehículo.
     */
    @Column(name = "Color", nullable = false)
    private String color;

    /**
     * Línea del vehículo.
     */
    @Column(name = "Linea", nullable = false)
    private String linea;

    /**
     * Marca del vehículo.
     */
    @Column(name = "Marca", nullable = false)
    private String marca;

    /**
     * Modelo del vehículo.
     */
    @Column(name = "Modelo", nullable = false)
    private String modelo;

    /**
     * RFC de la persona a la que le pertenece el vehículo.-
     */
    @ManyToOne
    @JoinColumn(name = "rfc_persona", referencedColumnName = "RFC", nullable = false)
    private Persona persona;

    /**
     * Lista de placas que ha tenido el vehículo.
     */
    @OneToMany(mappedBy = "vehiculo")
    private List<Placa> placas;

    /**
     * Obtiene el número de serie del vehículo
     *
     * @return el número de serie del vehículo
     */
    public String getNoSerie() {
        return noSerie;
    }

    /**
     * Asigna un número de serie al vehículo
     *
     * @param noSerie número de serie de vehículo
     */
    public void setNoSerie(String noSerie) {
        this.noSerie = noSerie;
    }

    /**
     * Obtiene el color representativo del vehículo
     *
     * @return color del vehículo
     */
    public String getColor() {
        return color;
    }

    /**
     * Asigna el color representativo del vehículo
     *
     * @param color cadena de texto que representa el color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     *
     * Obtiene la línea del vehículo
     *
     * @return la línea del vehículo
     */
    public String getLinea() {
        return linea;
    }

    /**
     *
     * Asigna la línea del vehículo
     *
     * @param linea cadena de texto que representa la línea del vehículo
     */
    public void setLinea(String linea) {
        this.linea = linea;
    }

    /**
     *
     * Obtiene la marca del vehículo
     *
     * @return la marca del vehículo
     */
    public String getMarca() {
        return marca;
    }

    /**
     *
     * Asigna la marca del vehículo
     *
     * @param marca cadena de texto que representa la marca del vehículo
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     *
     * Obtiene el modelo del vehículo
     *
     * @return el modelo del vehículo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     *
     * Asigna el modelo del vehículo
     *
     * @param modelo cadena de texto que representa el modelo del vehículo
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     *
     * Obtiene la persona dueña del vehículo
     *
     * @return la persona dueña del vehículo
     */
    public Persona getPersona() {
        return persona;
    }

    /**
     *
     * Asigna la persona dueña del vehículo
     *
     * @param persona persona dueña del vehículo
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    /**
     *
     * Obtiene la lista de placas que ha tenido el vehículo
     *
     * @return lista de placas que ha tenido el vehículo
     */
    public List<Placa> getPlacas() {
        return placas;
    }

    /**
     *
     * Asigna la lista de placas que ha tenido el vehículo
     *
     * @param placas lista de placas que ha tenido el vehículo
     */
    public void setPlacas(List<Placa> placas) {
        this.placas = placas;
    }

    /**
     *
     * Calcula el hashcode del objeto
     *
     * @return hashcode del objeto
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.noSerie);
        return hash;
    }

    /**
     *
     * Compara si el objeto es igual a otro objeto
     *
     * @param obj objeto a comparar
     * @return true si los objetos son iguales, false en caso contrario
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
        final Vehiculo other = (Vehiculo) obj;
        return Objects.equals(this.noSerie, other.noSerie);
    }

    /**
     *
     * Constructor que crea un nuevo objeto Vehiculo con número de serie, color,
     * línea, marca, modelo y persona asignados.
     *
     * @param noSerie número de serie del vehículo
     * @param color color del vehículo
     * @param linea línea del vehículo
     * @param marca marca del vehículo
     * @param modelo modelo del vehículo
     * @param persona persona propietaria del vehículo
     */
    public Vehiculo(String noSerie, String color, String linea, String marca, String modelo, Persona persona) {
        this.noSerie = noSerie;
        this.color = color;
        this.linea = linea;
        this.marca = marca;
        this.modelo = modelo;
        this.persona = persona;
    }

    /**
     *
     * Constructor que crea un nuevo objeto Vehiculo con color, línea, marca,
     * modelo y persona asignados.
     *
     * @param color color del vehículo
     * @param linea línea del vehículo
     * @param marca marca del vehículo
     * @param modelo modelo del vehículo
     * @param persona persona propietaria del vehículo
     */
    public Vehiculo(String color, String linea, String marca, String modelo, Persona persona) {
        this.color = color;
        this.linea = linea;
        this.marca = marca;
        this.modelo = modelo;
        this.persona = persona;
    }

    /**
     * Constructor por omisión de la clase Vehiculo
     */
    public Vehiculo() {
    }
}
