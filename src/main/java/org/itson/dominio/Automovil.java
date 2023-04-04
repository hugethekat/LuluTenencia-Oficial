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
 *
 * @author xeron
 */
@Entity
@Table(name = "Automovil")
@DiscriminatorValue("Automovil")
public class Automovil extends Vehiculo implements Serializable {

    public Automovil() {
    }

    public Automovil(String noSerie, String color, String linea, String marca, String modelo, Persona persona) {
        super(noSerie, color, linea, marca, modelo, persona);
    }

}
