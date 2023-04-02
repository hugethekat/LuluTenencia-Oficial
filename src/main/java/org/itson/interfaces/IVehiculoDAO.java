/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import org.itson.dominio.Persona;
import org.itson.dominio.Vehiculo;
import org.itson.excepciones.PersistenciaException;

/**
 *
 * @author JORGE
 */
public interface IVehiculoDAO {
    public Vehiculo consultar(String no_serie) throws PersistenciaException;
    public void insertarVehiculo(String no_serie, String color, String linea, String marca, String modelo,  Persona persona) throws PersistenciaException;
}
