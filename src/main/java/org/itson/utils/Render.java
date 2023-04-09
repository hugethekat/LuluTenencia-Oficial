/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.utils;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *Clase que permite crear un botón en una tabla
 * @author Hugo Navarro (233470)/Jorge Sánchez(233012)
 */
public class Render extends DefaultTableCellRenderer{
    
    /**
     * Método que permite crear un botón en una tabla
     * @param table tabla a la que se le agregará el botón
     * @param value objeto que se le agregará a la tabla
     * @param isSelected boleano que permite saber si el botón es seleccionado
     * @param hasFocus boleno que permite saber si el botón tiene focus
     * @param row fila en la que se insertará el botón
     * @param column columna en la que se insertará el botón
     * @return 
     */
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column){
        if(value instanceof JButton){
            JButton btn = (JButton)value;
            return btn;
        }
        return super.getTableCellRendererComponent(table,value,isSelected,hasFocus,row,column);
    }
}
