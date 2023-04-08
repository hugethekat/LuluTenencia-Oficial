/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.daos;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.itson.dominio.Persona;
import org.itson.dominio.ReporteDTO;
import org.itson.dominio.Tramite;
import org.itson.excepciones.PersistenciaException;
import org.itson.interfaces.ITramiteDAO;
import org.itson.utils.ConfiguracionPaginado;

/**
 *
 * @author JORGE
 */
public class TramiteDAO implements ITramiteDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.itson_LuluTenencia_jar_1.0-SNAPSHOTPU");
    EntityManager em = emf.createEntityManager();

    /**
     * Método que consulta los trámites hechos por una persona según su rfc
     *
     * @param rfc identificador de la persona a la que se le buscaran los
     * trámites
     * @return regresa una lista de todos los trámites hechos por la persona
     */
    @Override
    public List<Tramite> consultarTramites(String rfc, ConfiguracionPaginado configPaginado) {
        try {
            String jpqlQuery = "SELECT t FROM Tramite t WHERE t.persona.rfc = :rfc";
            TypedQuery<Tramite> query = em.createQuery(jpqlQuery, Tramite.class);
            query.setParameter("rfc", rfc);

            query.setFirstResult(configPaginado.getElementosASaltar());
            query.setMaxResults(configPaginado.getElementosPagina());

            return query.getResultList();
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public List<Tramite> buscarTramites(ReporteDTO params, ConfiguracionPaginado configPaginado) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Tramite> query = cb.createQuery(Tramite.class
        );
        Root<Tramite> root = query.from(Tramite.class
        );
        List<Predicate> filtros = new ArrayList<>();
        if (params.getNombre() != null && !params.getNombre().isEmpty()) {
            filtros.add(cb.like(cb.lower(root.get("persona").get("nombres")), "%" + params.getNombre() + "%"));
        }
        if (params.getInicio() != null && params.getFin() != null) {
            Date inicio = Date.from(params.getInicio().atStartOfDay(ZoneId.systemDefault()).toInstant());
            Date fin = Date.from(params.getFin().atStartOfDay(ZoneId.systemDefault()).toInstant());
            filtros.add(cb.between(root.get("fechaExpedicion"), inicio, fin));
        }
        if (filtros.isEmpty()) {
            query.select(root);
        } else {
            query.where(cb.and(filtros.toArray(new Predicate[0])));
        }
        TypedQuery<Tramite> typedQuery;
        if (configPaginado != null) {
            typedQuery = em.createQuery(query)
                    .setFirstResult(configPaginado.getElementosASaltar())
                    .setMaxResults(configPaginado.getElementosPagina());
        } else {
            typedQuery = em.createQuery(query);
        }
        return typedQuery.getResultList();
    }
}
