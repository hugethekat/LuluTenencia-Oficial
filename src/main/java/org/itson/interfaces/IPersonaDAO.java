/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import java.util.List;
import org.itson.dominio.Licencia;
import org.itson.dominio.ParametrosBusquedaPersonas;
import org.itson.dominio.Persona;
import org.itson.dominio.Tramite;
import org.itson.excepciones.PersistenciaException;

/**
 *
 * @author xeron
 */
public interface IPersonaDAO {
    public void insertarPersonas();
    public Persona consultar(String RFC) throws PersistenciaException;
    public List<Persona> consultarPersonas(ParametrosBusquedaPersonas params) throws PersistenciaException;
}
