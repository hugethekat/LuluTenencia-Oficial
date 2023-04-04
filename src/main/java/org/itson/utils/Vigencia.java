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
    private String [] vigencia = {"Seleccione Vigencia", "1_Anio", "2_Anios", "3_Anios"};

    public Vigencia() {
    }
    
    public String[] mandarVigencias(){
        return vigencia;
    }
    
    public int mandarCosto(String vigencia, boolean discapacidad){
        int costo = 0;
        if(vigencia.equals("1_Anio") && discapacidad == false){
            costo = 600;
        } else if (vigencia.equals("1_Anio") && discapacidad == true){
            costo = 200;
        } else if (vigencia.equals("2_Anios") && discapacidad == false){
            costo = 900;
        } else if (vigencia.equals("2_Anios") && discapacidad == true){
            costo = 500;
        } else if (vigencia.equals("3_Anios") && discapacidad == false){
            costo = 1100;
        }else if (vigencia.equals("3_Anios") && discapacidad == true){
            costo = 700;
        } 
        return costo;
    }
    
}
