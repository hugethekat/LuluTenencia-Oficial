/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import org.itson.dominio.Automovil;

/**
 *Interfaz que se implementa en AutomovilDAO
 * @author Hugo Navarro (233470)/Jorge Sánchez(233012)
 */
public interface IAutomovilDAO {
    
    /**
     * Método que registra un automovil
     * @param automovil automovil que será registrado
     */
    public void registrarAutomovil(Automovil automovil);
    
    /**
     * Método que busca un automovil por su número de serie
     * @param noSerie identificador del automovil a ser buscado
     * @return regresa un objeto de tipo automovil si lo encuentra, nulo si no
     */
    public Automovil buscarAutomovil(String noSerie);
    
    /**
     * Método para saber si un automovil existe
     * @param noSerie identificador del automovil a ser buscado en existencia
     * @return regresa un booleano, true si existe, false si no
     */
    public boolean automovilExistencia(String noSerie);
}
