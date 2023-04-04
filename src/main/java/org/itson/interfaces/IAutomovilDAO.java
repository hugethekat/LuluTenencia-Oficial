/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import org.itson.dominio.Automovil;

/**
 *
 * @author xeron
 */
public interface IAutomovilDAO {
    public void registrarAutomovil(Automovil automovil);
    public Automovil buscarAutomovil(String noSerie);
    public boolean automovilExistencia(String noSerie);
}
