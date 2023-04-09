/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

/**
 *Interfaz que se implementa en VehiculoDAO
 * @author Hugo Navarro (233470)/Jorge Sánchez(233012)
 */
public interface IVehiculoDAO {

    /**
     * Método que regresa el tipo de un vehiculo en específico
     * @param noSerie identificador del vehiculo al que se le obtendrá el título
     * @return regresa una cadena de texto con el tipo del vehículo buscado
     */
    public String consultarTipo(String noSerie);
}
