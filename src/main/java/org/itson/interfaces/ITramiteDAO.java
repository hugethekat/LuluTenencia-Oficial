/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import java.util.List;
import org.itson.dominio.ReporteDTO;
import org.itson.dominio.Tramite;
import org.itson.utils.ConfiguracionPaginado;

/**
 *Interfaz que se implementa en TramiteDAO
 * @author Hugo Navarro (233470)/Jorge Sánchez(233012)
 */
public interface ITramiteDAO {

    /**
     * Método que consulta los trámites hechos por una persona según su rfc
     *
     * @param rfc identificador de la persona a la que se le buscaran los
     * trámites
     * @param configPaginado Configuración del paginado.
     * @return regresa una lista de todos los trámites hechos por la persona
     */
    public List<Tramite> consultarTramites(String rfc, ConfiguracionPaginado configPaginado);

    /**
     * Método que busca los trámites dependiendo de ciertos filtros ya sea hechos por una persona con 
     * un nombre o un periodo de tiempo, tambien configura el paginado de la tabla en donde se 
     * presentaran los datos
     * @param params parametros por los cuales se aplicaran los filtros
     * @param configPaginado configuración que seguirá el paginado de la tabla y tambien 
     * para establecer cuantos resultados se obtendran en la consulta
     * @return una lista de tramites con las características dadas
     */
    public List<Tramite> buscarTramites(ReporteDTO params, ConfiguracionPaginado configPaginado);
}
