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
 *
 * @author xeron
 */
public class AutomovilDAO implements IAutomovilDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.itson_LuluTenencia_jar_1.0-SNAPSHOTPU");
    EntityManager em = emf.createEntityManager();

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

    @Override
    public Automovil buscarAutomovil(String noSerie) {

        try {
            return em.find(Automovil.class, noSerie);
        } catch (NoResultException ex) {
            return null;
        }
    }

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
