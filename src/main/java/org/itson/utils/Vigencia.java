/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.utils;

/**
 *
 * @author xeron
 */
public class Vigencia {

    private String[] vigencia = {"Seleccione Vigencia", "1_Anio", "2_Anios", "3_Anios"};

    /**
     * Constructor por defecto del objeto Vigencia
     */
    public Vigencia() {
    }

    /**
     * Método que regresa las vigencias previamente instanciadas para llenar una
     * combo box
     *
     * @return regresa un arreglo de Strings que contiene las diferentes
     * vigencias
     */
    public String[] mandarVigencias() {
        return vigencia;
    }

    /**
     * Método que calcula el costo de las licencias dependiendo de la vigencia
     * seleccionada y de si la persona presenta una discapacidad o no
     *
     * @param vigencia vigencia seleccionada
     * @param discapacidad boleano que representa la discapacidad, true si la
     * persona es discapacitada, false si no
     * @return entero que representa el costo de la licencia
     */
    public int mandarCosto(String vigencia, boolean discapacidad) {
        int costo = 0;
        if (vigencia.equals("1_Anio") && discapacidad == false) {
            costo = 600;
        } else if (vigencia.equals("1_Anio") && discapacidad == true) {
            costo = 200;
        } else if (vigencia.equals("2_Anios") && discapacidad == false) {
            costo = 900;
        } else if (vigencia.equals("2_Anios") && discapacidad == true) {
            costo = 500;
        } else if (vigencia.equals("3_Anios") && discapacidad == false) {
            costo = 1100;
        } else if (vigencia.equals("3_Anios") && discapacidad == true) {
            costo = 700;
        }
        return costo;
    }
}
