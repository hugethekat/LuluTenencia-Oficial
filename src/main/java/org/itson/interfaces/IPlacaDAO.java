/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import org.itson.dominio.Persona;
import org.itson.dominio.Placa;
import org.itson.dominio.Vehiculo;
import org.itson.excepciones.PersistenciaException;

/**
 *Interfaz que se implementa en PlacaDAO
 * @author Hugo Navarro (233470)/Jorge Sánchez(233012)
 */
public interface IPlacaDAO {

    /**
     * Método que consulta la placa activa actual del vehículo
     *
     * @param no_serie identificador del vehículo al que se le buscará la placa
     * @return regresa un objeto de tipo Placa que representa la placa con
     * estado activo
     * @throws PersistenciaException Arroja una excepción cuando ocurre un error
     * en el método
     */
    public Placa consultarPlacaActiva(String no_serie);

    /**
     * Método que actualiza el estado de la placa de activa a inactiva
     *
     * @param num número que tiene la placa
     * @throws PersistenciaException Arroja una excepción cuando ocurre un error
     * en el método
     */
    public void actualizarEstadoPlaca(String num) throws PersistenciaException;

    /**
     * Método que registra una placa
     *
     * @param persona persona la cual tramitó la placa
     * @param vehiculo vehículo al que le pertenece la placa
     * @param costo costo de la placa
     * @throws PersistenciaException Arroja una excepción cuando ocurre un error
     * en el método
     */
    public void insertarPlaca(Persona persona, Vehiculo vehiculo, double costo) throws PersistenciaException;

    /**
     * Método que consulta una placa según su id;
     *
     * @param id identificador númerico de la placa
     * @return regresa la placa
     */
    public Placa consultarPlaca(Long id);
}
