/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.utils;

/**
 *Clase que permite establecer un paginado a la tabla a la que se le asigne 
 * @author Hugo Navarro (233470)/Jorge Sánchez(233012)
 */
public class ConfiguracionPaginado {

    private int numPagina;
    private int elementosPagina;

    /**
     * Constructor con valores por defecto para el paginado
     */
    public ConfiguracionPaginado() {
        this.numPagina = 0;
        this.elementosPagina = 5;
    }

    /**
     * Constructor que recibe un numero de página y los elementos que se permitiran mostrar por página
     * @param numPagina indicador para saber en que página se encuentra
     * @param elementosPagina elementos que se mostrarán por página 
     */
    public ConfiguracionPaginado(int numPagina, int elementosPagina) {
        this.numPagina = numPagina;
        this.elementosPagina = elementosPagina;
    }

    /**
     * Método que obtiene el número de página
     * @return regresa el número de página
     */
    public int getNumPagina() {
        return numPagina;
    }

    /**
     * Método que asigna un número de página
     * @param numPagina numero de página en la que estará la tabla
     */
    public void setNumPagina(int numPagina) {
        this.numPagina = numPagina;
    }

    /**
     * Método que obtiene los elementos por pagina que se verán
     * @return numero de elementos que se verán por página
     */
    public int getElementosPagina() {
        return elementosPagina;
    }

    /**
     * Método que asigna los emenetos que se verán en cada página
     * @param elementosPagina elementos que se verán por página
     */
    public void setElementosPagina(int elementosPagina) {
        this.elementosPagina = elementosPagina;
    }

    /**
     * Método que obtiene los elementos que saltarán en la tabla
     * @return regresa el resultado de una multiplicación entre el número de página y los elementos que se 
     * verán en cada una
     */
    public int getElementosASaltar() {
        return this.numPagina * this.elementosPagina;
    }

    /**
     * Método que hace avanzar las páginas una unidad
     */
    public void avanzarPagina() {
        this.numPagina++;
    }

    /**
     * Método que hace retroceder una página una unidad si es que esta no es 0
     */
    public void retrocederPagina() {
        if (this.numPagina > 0) {
            this.numPagina--;
        }
    }
}
