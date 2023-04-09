/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.daos;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import org.itson.dominio.Licencia;
import org.itson.dominio.Persona;
import org.itson.excepciones.PersistenciaException;
import org.itson.interfaces.ILicenciaDAO;

/**
 *Clase donde implementa los métodos de la interfaz ILicenciaDAO y contiene todo lo que necesita licencia
 * @author Hugo Navarro (233470)/Jorge Sánchez(233012)
 */
public class LicenciaDAO implements ILicenciaDAO {

    Date now = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    String formattedDate = sdf.format(now);

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.itson_LuluTenencia_jar_1.0-SNAPSHOTPU");
    EntityManager em = emf.createEntityManager();

    /**
     * Método que registra una licencia a una persona
     *
     * @param RFC cadena de caracteres identificadores de la persona
     * @param nombres nombre de la persona
     * @param APaterno apellido paterno de la persona
     * @param AMaterno apellido materno de la persona
     * @param FechaNac fecha de nacimiento de la persona
     * @param Telefono teléfono de la persona
     * @param discapacidad boleano que representa si la persona tiene alguna
     * discapacidad o no
     * @param costo costo de la licencia
     * @param vigencia vigencia en años de la licencia
     * @throws PersistenciaException Arroja una excepción cuando ocurre un error
     * en el método
     */
    @Override
    public void insertarLicencia(String RFC, String nombres, String APaterno, String AMaterno, String FechaNac, String Telefono, boolean discapacidad, double costo, int vigencia) throws PersistenciaException {

        try {
            Date fechaChila = sdf.parse(formattedDate);
            em.getTransaction().begin();
            Persona persona = new Persona(RFC, LocalDate.parse(FechaNac), nombres, APaterno, AMaterno, Telefono);

            Licencia licencia = new Licencia(true, discapacidad, vigencia, fechaChila, costo, persona);

            em.persist(licencia);

            em.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Se insertó correctamente la licencia.");
        } catch (Exception ex) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Hubo un error al insertar la licencia");
        } finally {
            em.close();
        }

    }

    /**
     * Método que actualiza el estado de la licencia a una sin vigencia
     *
     * @param idLicencia Identificador de la licencia a la que se le cambiara el
     * estado
     */
    public void actualizarEstadoLicencia(Long idLicencia) {
        Licencia licencia = em.find(Licencia.class, idLicencia);
        if (licencia != null && licencia.isEstado()) {
            em.getTransaction().begin();
            licencia.setEstado(false);
            em.merge(licencia);
            em.getTransaction().commit();
        }
    }

    /**
     * Método que consulta una licencia vigente metiande el rfc de la persona a
     * la que le pertenece la licencia
     *
     * @param RFC Identificador de la persona a la que se le consultarán las
     * licencias
     * @return Regresa un boleano, true si encuentra una licencia vigente, false
     * si no hay una vigente
     */
    @Override
    public boolean consultarLicencia(String RFC){
        List<Licencia> licencias = (List<Licencia>) em.createQuery("SELECT l FROM Licencia l  WHERE l.persona.rfc = :rfc", Licencia.class).setParameter("rfc", RFC).getResultList();

        for (Licencia licencia : licencias) {
            if (licencia.getFechaExpedicion().getTime() + TimeUnit.DAYS.toMillis(licencia.getVigencia() * 365) > now.getTime()) {
                return true;
            } else {
                actualizarEstadoLicencia(licencia.getId());
            }
        }
        return false;
    }

}
