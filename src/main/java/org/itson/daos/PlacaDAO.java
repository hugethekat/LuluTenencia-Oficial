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
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.itson.dominio.Placa;
import org.itson.excepciones.PersistenciaException;
import org.itson.interfaces.IPlacaDAO;

/**
 *
 * @author JORGE
 */
public class PlacaDAO implements IPlacaDAO{


    EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.itson_LuluTenencia_jar_1.0-SNAPSHOTPU");
    EntityManager em = emf.createEntityManager();
    
    
    /**
     * Método que consulta la placa activa actual del vehículo
     * @param no_serie identificador del vehículo al que se le buscará la placa
     * @return regresa un objeto de tipo Placa que representa la placa con estado activo
     * @throws PersistenciaException Arroja una excepción cuando ocurre un error en el método
     */
    @Override
    public Placa consultarPlacaActiva(String no_serie) throws PersistenciaException {
//        List<Placa> placas = (List<Placa>)em.createQuery("SELECT P FROM Placa P WHERE p.vehiculo.noSerie=:noSerie", Placa.class).setParameter("no_serie", no_serie).getResultList();
//        
//        for(Placa placa : placas){
//            if(placa.getEstado()==true){
//                actualizarEstadoPlaca(placa.getId());
//            }
//        }
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Placa> consulta = cb.createQuery(Placa.class);
        Root<Placa> root = consulta.from(Placa.class);
        consulta = consulta.select(root).where(
                cb.and(
                cb.equal(root.get("estado"), true),
                        cb.equal(root.get("no_serie"),no_serie)
                         )              
                );
        TypedQuery<Placa> query = em.createQuery(consulta);
        
        Placa placaActiva = query.getSingleResult();
        return placaActiva;
    }

    /**
     * Método que actualiza el estado de la placa de activa a inactiva
     * @param idPlaca Identificador de la placa a la que se le cambiara el estado
     * @throws PersistenciaException Arroja una excepción cuando ocurre un error en el método
     */
    @Override
    public void actualizarEstadoPlaca(Long idPlaca) throws PersistenciaException {
        Placa placa = em.find(Placa.class, idPlaca);
        if(placa != null && placa.getEstado()){
            em.getTransaction().begin();
            placa.setEstado(false);
            placa.setFechaRecepcion(new Date());
            em.merge(placa);
            em.getTransaction().commit();
        }
    }
    
}
