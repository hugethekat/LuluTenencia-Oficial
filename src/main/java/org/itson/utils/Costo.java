/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.utils;

/**
 *
 * @author xeron
 */
public class Costo {

    /**
     * Constructor por defecto del objeto Costo
     */
    public Costo() {
    }

    /**
     * Método que regresa el costo de una placa dependiendo de si el vehículo es usado o no
     * @param tipo representa si el vehículo es usado o es nuevo
     * @return regresa el costo de una placa dependiendo de su tipo
     */
    public double mandarCosto(String tipo) {
        double costo;

        if (tipo.equals("Usado")) {
            return costo = 1000;
        } else {
            return costo = 1500;
        }
    }

}
