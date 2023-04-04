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

    public Costo() {
    }

    public double mandarCosto(String tipo) {
        double costo;

        if (tipo.equals("Usado")) {
            return costo = 1000;
        } else {
            return costo = 1500;
        }
    }

}
