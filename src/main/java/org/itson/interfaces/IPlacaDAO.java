/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import java.util.List;
import org.itson.dominio.Placa;
import org.itson.excepciones.PersistenciaException;

/**
 *
 * @author JORGE
 */
public interface IPlacaDAO {
    public Placa consultarPlacaActiva(String no_serie) throws PersistenciaException;
    public void actualizarEstadoPlaca(Long idPlaca) throws PersistenciaException;
}
