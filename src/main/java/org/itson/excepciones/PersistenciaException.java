/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.excepciones;

/**
 *Clase que crea una excepción para los errores de los métodos
 * @author Hugo Navarro (233470)/Jorge Sánchez(233012)
 */
public class PersistenciaException extends Exception{

    public PersistenciaException() {
    }

    public PersistenciaException(String string) {
        super(string);
    }

    public PersistenciaException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public PersistenciaException(Throwable thrwbl) {
        super(thrwbl);
    }

    public PersistenciaException(String string, Throwable thrwbl, boolean bln, boolean bln1) {
        super(string, thrwbl, bln, bln1);
    }
}
