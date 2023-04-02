/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.daos;

import java.time.LocalDate;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.itson.dominio.Licencia;
import org.itson.dominio.Persona;
import org.itson.excepciones.PersistenciaException;
import org.itson.interfaces.ILicenciaDAO;

/**
 *
 * @author xeron
 */
public class LicenciaDAO implements ILicenciaDAO {

    LocalDate now = LocalDate.now();

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.itson_LuluTenencia_jar_1.0-SNAPSHOTPU");
    EntityManager em = emf.createEntityManager();
@Override
    public void insertarLicencia(String RFC, String nombres, String APaterno, String AMaterno, String FechaNac, String Telefono, boolean discapacidad, double costo, int vigencia) throws PersistenciaException {

        try {
            em.getTransaction().begin();
            Persona persona = new Persona(RFC, LocalDate.parse(FechaNac), nombres, APaterno, AMaterno, Telefono);

            Licencia licencia = new Licencia(true, discapacidad, vigencia, now, costo, persona);

            em.persist(licencia);

            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Hubo un error al insertar la licencia");
        } finally {
            em.close();
        }

    }

}
