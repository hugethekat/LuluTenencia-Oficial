/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import java.util.List;
import org.itson.dominio.ParametrosBusquedaPersonas;
import org.itson.dominio.Persona;
import org.itson.utils.ConfiguracionPaginado;

/**
 *Interfaz que se implementa en PersonaDAO
 * @author Hugo Navarro (233470)/Jorge Sánchez(233012)
 */
public interface IPersonaDAO {
     /**
     * Método que inserta 20 personas a la base de datos para fines de prueba
     */
    public void insertarPersonas();
    
    /**
     * Método que consulta la existencia de una persona mediante su rfc
     *
     * @param RFC cadena de caracteres identificadores de la persona
     * @return regresa un objeto de tipo persona a la que le corresonde ese rfc
     * @throws NoResultException Arroja una excepción si no se encontró ninguna
     * persona con ese RFC
     */
    public Persona consultar(String RFC);
    
    /**
     * Método que consulta personas con base a filtros
     *
     * @param params parametros que se obtienen para seleccionar los filtros
     * para la busqueda
     * @return regresa una lista de personas que coincidan con la informacion
     * recibida para los filtros
     * @throws NoResultException Arroja null por que no hubo resultados.
     */
    public List<Persona> consultarPersonas(ParametrosBusquedaPersonas params, ConfiguracionPaginado configuracionPaginado);
}
