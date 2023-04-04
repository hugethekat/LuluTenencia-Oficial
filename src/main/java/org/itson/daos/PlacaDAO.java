/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.daos;

import java.time.LocalDate;
import static java.time.LocalDate.now;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.swing.JOptionPane;
import org.itson.dominio.Persona;
import org.itson.dominio.Placa;
import org.itson.dominio.Vehiculo;
import org.itson.excepciones.PersistenciaException;
import org.itson.interfaces.IPlacaDAO;
import org.apache.commons.lang3.RandomStringUtils;

/**
 *
 * @author JORGE
 */
public class PlacaDAO implements IPlacaDAO {

    LocalDate now = LocalDate.now();
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.itson_LuluTenencia_jar_1.0-SNAPSHOTPU");
    EntityManager em = emf.createEntityManager();

    /**
     * Método que consulta la placa activa actual del vehículo
     *
     * @param no_serie identificador del vehículo al que se le buscará la placa
     * @return regresa un objeto de tipo Placa que representa la placa con
     * estado activo
     * @throws PersistenciaException Arroja una excepción cuando ocurre un error
     * en el método
     */
    @Override
    public Placa consultarPlacaActiva(String no_serie) throws PersistenciaException {
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Placa> consulta = cb.createQuery(Placa.class);
            Root<Placa> root = consulta.from(Placa.class);
            Join<Placa, Vehiculo> vehiculoJoin = root.join("vehiculo");
            Predicate predicado = cb.and(cb.equal(root.get("estado"), true), cb.equal(vehiculoJoin.get("noSerie"), no_serie));
            consulta.where(predicado);
            TypedQuery<Placa> query = em.createQuery(consulta);
            Placa placaActiva = query.getSingleResult();
            return placaActiva;
        } catch (NoResultException ex) {
            return null;
        }
    }

    /**
     * Método que actualiza el estado de la placa de activa a inactiva
     *
     * @param idPlaca Identificador de la placa a la que se le cambiara el
     * estado
     * @throws PersistenciaException Arroja una excepción cuando ocurre un error
     * en el método
     */
    @Override
    public void actualizarEstadoPlaca(Long idPlaca) throws PersistenciaException {
        Placa placa = em.find(Placa.class, idPlaca);
        if (placa != null && placa.getEstado()) {
            em.getTransaction().begin();
            placa.setEstado(false);
            placa.setFechaRecepcion(new Date());
            em.merge(placa);
            em.getTransaction().commit();
        }
    }

    /**
     * Método que registra una placa
     *
     * @param persona persona la cual tramitó la placa
     * @param vehiculo vehículo al que le pertenece la placa
     * @param costo costo de la placa
     * @throws PersistenciaException Arroja una excepción cuando ocurre un error
     * en el método
     */
    @Override
    public void insertarPlaca(Persona persona, Vehiculo vehiculo, double costo) throws PersistenciaException {
        String c = RandomStringUtils.randomAlphabetic(3).toUpperCase();
        String b = RandomStringUtils.randomNumeric(3);
        String numero = c + "-" + b;

        try {
            em.getTransaction().begin();
            Placa placa = new Placa(true, numero, vehiculo, now, costo, persona);

            em.persist(placa);

            em.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Se insertó correctamente la placa");
        } catch (Exception ex) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Hubo un error al insertar la placa");
        } finally {
            em.close();
        }

    }

}
