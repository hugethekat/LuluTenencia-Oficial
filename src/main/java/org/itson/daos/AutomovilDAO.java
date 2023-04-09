/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import org.itson.dominio.Automovil;
import org.itson.interfaces.IAutomovilDAO;

/**
 *Clase donde implementa los métodos de la interfaz IAutomovilDAO y contiene todo lo que necesita automovil
 * @author Hugo Navarro (233470)/Jorge Sánchez(233012)
 */
public class AutomovilDAO implements IAutomovilDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.itson_LuluTenencia_jar_1.0-SNAPSHOTPU");
    EntityManager em = emf.createEntityManager();

    /**
     * Método que registra un automovil
     * @param automovil automovil que será registrado
     */
    @Override
    public void registrarAutomovil(Automovil automovil) {

        try {
            em.getTransaction().begin();
            em.persist(automovil);
            em.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "El automóvil fue registrado con éxito.");
        } catch (Exception ex) {
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Hubo un error al guardar el automóvil, intente de nuevo.");
        }
    }

    /**
     * Método que busca un automovil por su número de serie
     * @param noSerie identificador del automovil a ser buscado
     * @return regresa un objeto de tipo automovil si lo encuentra, nulo si no
     */
    @Override
    public Automovil buscarAutomovil(String noSerie) {
        try {
            return em.find(Automovil.class, noSerie);
        } catch (NoResultException ex) {
            return null;
        }
    }

    /**
     * Método para saber si un automovil existe
     * @param noSerie identificador del automovil a ser buscado en existencia
     * @return regresa un booleano, true si existe, false si no
     */
    @Override
    public boolean automovilExistencia(String noSerie) {
        boolean existe = false;

        try {
            Automovil automovil = em.find(Automovil.class, noSerie);
            if (automovil != null) {
                existe = true;
            }
        } catch (Exception ex) {

        }
        return existe;
    }

}
