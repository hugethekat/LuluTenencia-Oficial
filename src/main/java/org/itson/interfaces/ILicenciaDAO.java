/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import org.itson.excepciones.PersistenciaException;

/**
 *Interfaz que se implementa en LicenciaDAO
 * @author Hugo Navarro (233470)/Jorge Sánchez(233012)
 */
public interface ILicenciaDAO {

    /**
     * Método que registra una licencia a una persona
     *
     * @param RFC cadena de caracteres identificadores de la persona
     * @param nombres nombre de la persona
     * @param APaterno apellido paterno de la persona
     * @param AMaterno apellido materno de la persona
     * @param FechaNac fecha de nacimiento de la persona
     * @param Telefono teléfono de la persona
     * @param discapacidad boleano que representa si la persona tiene alguna
     * discapacidad o no
     * @param costo costo de la licencia
     * @param vigencia vigencia en años de la licencia
     * @throws PersistenciaException Arroja una excepción cuando ocurre un error
     * en el método
     */
    public void insertarLicencia(String RFC, String nombres, String APaterno, String AMaterno, String FechaNac, String Telefono, boolean discapacidad, double costo, int vigencia) throws PersistenciaException;
    
    /**
     * Método que consulta una licencia vigente metiande el rfc de la persona a
     * la que le pertenece la licencia
     *
     * @param RFC Identificador de la persona a la que se le consultarán las
     * licencias
     * @return Regresa un boleano, true si encuentra una licencia vigente, false
     * si no hay una vigente
     */
    public boolean consultarLicencia(String RFC);
}
