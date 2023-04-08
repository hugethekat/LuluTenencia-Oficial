/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import org.itson.dominio.Licencia;
import org.itson.excepciones.PersistenciaException;

/**
 *
 * @author xeron
 */
public interface ILicenciaDAO {

    public void insertarLicencia(String RFC, String nombres, String APaterno, String AMaterno, String FechaNac, String Telefono, boolean discapacidad, double costo, int vigencia) throws PersistenciaException;
    public boolean consultarLicencia(String RFC);
}
