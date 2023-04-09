/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dominio;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *Clase tipo Entity que mapea los atributos de Automovil que extiende de Vehiculo
 * @author Hugo Navarro (233470)/Jorge Sánchez(233012)
 */
@Entity
@Table(name = "Automovil")
@DiscriminatorValue("Automovil")
public class Automovil extends Vehiculo implements Serializable {

    /**
     * Constructor por omisión
     */
    public Automovil() {
    }

    /**
     * Constructor de Automovil que obtiene todos los atributos obtenidos de Vehiculo
     * @param noSerie identificador de un vehículo
     * @param color color representativo del automovil
     * @param linea linea representativa del automovil
     * @param marca marca representativa del automovil
     * @param modelo modelo representativo del automovil
     * @param persona persona a la que le pertenece el automovil
     */
    public Automovil(String noSerie, String color, String linea, String marca, String modelo, Persona persona) {
        super(noSerie, color, linea, marca, modelo, persona);
    }

}
