/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.itson.lulutenencia;

import org.itson.presentacion.MenuForm;

/**
 *Clase principal para que el proyecto se ejecute 
 * @author Hugo Navarro (233470)/Jorge Sánchez(233012)
 */
public class LuluTenencia {

    /**
     * Constructor por omisión de la clase LuluTenencia
     */
    public LuluTenencia() {
    }

    
    /**
     * Método que ejecuta la ventana de menu
     * @param args Lineas que se ejecutarán
     */
    public static void main(String[] args) {
      new MenuForm().setVisible(true);
    }
}
