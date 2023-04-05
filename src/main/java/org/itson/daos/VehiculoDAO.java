/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.daos;

import javax.persistence.DiscriminatorValue;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import org.itson.dominio.Vehiculo;
import org.itson.interfaces.IVehiculoDAO;

/**
 *
 * @author JORGE
 */
public class VehiculoDAO implements IVehiculoDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.itson_LuluTenencia_jar_1.0-SNAPSHOTPU");
    EntityManager em = emf.createEntityManager();

    /**
     * Método que regresa el tipo de un vehiculo en específico
     * @param noSerie identificador del vehiculo al que se le obtendrá el título
     * @return regresa una cadena de texto con el tipo del vehículo buscado
     */
    @Override
    public String consultarTipo(String noSerie) {

        try {
            Vehiculo vehiculo = em.find(Vehiculo.class, noSerie);
            if (vehiculo != null) {
                return vehiculo.getClass().getAnnotation(DiscriminatorValue.class).value();
            } else {
                return null;
            }
        } catch (NoResultException ex) {
            return null;
        }

    }

}
