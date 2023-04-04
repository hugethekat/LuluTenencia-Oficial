/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.daos;

import java.time.LocalDate;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.swing.JOptionPane;
import org.itson.dominio.Persona;
import org.itson.dominio.Vehiculo;
import org.itson.excepciones.PersistenciaException;
import org.itson.interfaces.IVehiculoDAO;

/**
 *
 * @author JORGE
 */
public class VehiculoDAO implements IVehiculoDAO{

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.itson_LuluTenencia_jar_1.0-SNAPSHOTPU");
    EntityManager em = emf.createEntityManager();
    
    /**
     * Método que consulta la existencia de un vehículo mediante su número de serie
     * @param no_serie cadena de caracteres identificadores del vehículo
     * @return regresa un objeto de tipo vehículo al que le corresponde ese número de serie
     * @throws PersistenciaException Arroja una excepción cuando ocurre un error en el método
     */
    @Override
    public Vehiculo consultar(String no_serie) throws PersistenciaException {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery consulta = cb.createQuery(Vehiculo.class);
        Root<Vehiculo> root = consulta.from(Vehiculo.class);
        consulta.where(cb.equal(root.get("no_serie"), no_serie));
        TypedQuery<Vehiculo> query = em.createQuery(consulta);
        return query.getSingleResult();
    }

    /**
     * Método que registra un vehículo perteneciente a la persona que recibe el parámetro
     * @param no_serie cadena de caracteres identificadores del vehículo
     * @param color color representativo del vehículo
     * @param linea linea representativa del vehículo
     * @param marca marca representativa del vehículo
     * @param modelo modelo representativo del vehículo
     * @param persona persona a la que le pertenece el vehículo
     * @throws PersistenciaException Arroja una excepción cuando ocurre un error en el método
     */
    @Override
    public void insertarVehiculo(String no_serie, String color, String linea, String marca, String modelo, Persona persona) throws PersistenciaException {
        try {
            em.getTransaction().begin();
            Vehiculo vehiculo = new Vehiculo(no_serie, color, linea, marca, modelo, persona);
            em.persist(vehiculo);
        } catch (Exception ex) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Hubo un error al regsitrar el vehículo");
        } finally {
            em.close();
        }
    }

}
