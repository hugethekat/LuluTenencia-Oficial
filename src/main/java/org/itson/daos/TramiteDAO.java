/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.daos;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import org.itson.dominio.Tramite;
import org.itson.excepciones.PersistenciaException;
import org.itson.interfaces.ITramiteDAO;

/**
 *
 * @author JORGE
 */
public class TramiteDAO implements ITramiteDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.itson_LuluTenencia_jar_1.0-SNAPSHOTPU");
    EntityManager em = emf.createEntityManager();
    
    /**
     * Método que consulta los trámites hechos por una persona según su rfc
     * @param rfc identificador de la persona a la que se le buscaran los trámites
     * @return regresa una lista de todos los trámites hechos por la persona 
     */
    @Override
    public List<Tramite> consultarTramites(String rfc){
        try {
            String jpqlQuery = "SELECT t.Fecha_expedicion, t.costo FROM Tramite t WHERE t.rfc_persona LIKE :rfc";
            TypedQuery<Tramite> query = em.createQuery(jpqlQuery, Tramite.class);
            query.setParameter("rfc", rfc);
            return query.getResultList();
        } catch (NoResultException ex) {
            return null;
        }
    }
    
}
