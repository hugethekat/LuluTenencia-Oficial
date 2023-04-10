/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.excepciones;

/**
 * Clase que crea una excepción para los errores de los métodos
 *
 * @author Hugo Navarro (233470)/Jorge Sánchez(233012)
 */
public class PersistenciaException extends Exception {

    /**
     * Constructor de la clase PersistenciaException
     */
    public PersistenciaException() {
    }

    /**
     *
     * Crea una nueva instancia de PersistenciaException con el detalle del
     * mensaje especificado.
     *
     * @param string Detalle del mensaje de la excepción.
     */
    public PersistenciaException(String string) {
        super(string);
    }

    /**
     *
     * Crea una nueva instancia de PersistenciaException con el detalle del
     * mensaje y la causa especificados.
     *
     * @param string Detalle del mensaje de la excepción.
     * @param thrwbl Causa de la excepción.
     */
    public PersistenciaException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    /**
     *
     * Crea una nueva instancia de PersistenciaException con la causa
     * especificada y el detalle del mensaje predeterminado.
     *
     * @param thrwbl Causa de la excepción.
     */
    public PersistenciaException(Throwable thrwbl) {
        super(thrwbl);
    }

    /**
     *
     * Crea una nueva instancia de PersistenciaException con el detalle del
     * mensaje, la causa, habilitando o no la supresión de mensajes y
     * habilitando o no la escritura en el registro de la pila.
     *
     * @param string Detalle del mensaje de la excepción.
     * @param thrwbl Causa de la excepción.
     * @param bln Si se debe habilitar la supresión de mensajes o no.
     * @param bln1 Si se debe habilitar la escritura en el registro de la pila o
     * no.
     */
    public PersistenciaException(String string, Throwable thrwbl, boolean bln, boolean bln1) {
        super(string, thrwbl, bln, bln1);
    }
}
