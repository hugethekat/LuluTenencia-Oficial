/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.daos;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.swing.JOptionPane;
import org.itson.dominio.Persona;
import org.itson.excepciones.PersistenciaException;
import org.itson.interfaces.IPersonaDAO;

/**
 *
 * @author JORGE
 */
public class PersonaDAO implements IPersonaDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.itson_LuluTenencia_jar_1.0-SNAPSHOTPU");
    EntityManager em = emf.createEntityManager();

    int i = 0;

    /*
    Insercción masiva de 20 personas a la base de datos para que pueda funcionar correctamente el programa.
     */
    @Override
    public void insertarPersonas() {
        try {

            em.getTransaction().begin();

            Persona persona1 = new Persona("MGM567", LocalDate.of(1987, 1, 3), "Mario", "García", "Mendoza", "5551234567");
            em.persist(persona1);
            i++;

            Persona persona2 = new Persona("LGC678", LocalDate.of(1991, 7, 9), "Laura", "Gaxiola", "Castillo", "5552345678");
            em.persist(persona2);
            i++;

            Persona persona3 = new Persona("GJM628", LocalDate.of(1998, 2, 15), "Gabriela", "Jiménez", "Mendoza", "6441392628");
            em.persist(persona3);
            i++;

            Persona persona4 = new Persona("EDQ376", LocalDate.of(2003, 11, 2), "Esteban", "Durán", "Quintanar", "6444609376");
            em.persist(persona4);
            i++;

            Persona persona5 = new Persona("HMP888", LocalDate.of(1984, 7, 27), "Humberto", "Marchena", "Salazar", "6442322888");
            em.persist(persona5);
            i++;

            Persona persona6 = new Persona("DRL766", LocalDate.of(1968, 6, 28), "Daniel", "Ramírez", "Lapizco", "6444301766");
            em.persist(persona6);
            i++;

            Persona persona7 = new Persona("ILR804", LocalDate.of(1999, 12, 6), "Ilde", "Lares", "Rangel", "6442343804");
            em.persist(persona7);
            i++;

            Persona persona8 = new Persona("RVG100", LocalDate.of(2000, 1, 31), "Rúben", "Valenzuela", "Gonzáles", "6441020100");
            em.persist(persona8);
            i++;

            Persona persona9 = new Persona("HNR088", LocalDate.of(2003, 7, 25), "Hugo", "Navarro", "Ramírez", "6442740088");
            em.persist(persona9);
            i++;

            Persona persona10 = new Persona("JNR400", LocalDate.of(1996, 2, 15), "Julio", "Navarro", "Ramírez", "642949400");
            em.persist(persona10);
            i++;

            Persona persona11 = new Persona("EAV292", LocalDate.of(1992, 10, 18), "Elmer", "Arredondo", "Vaca", "6442441292");
            em.persist(persona11);
            i++;

            Persona persona12 = new Persona("ANR947", LocalDate.of(1987, 1, 24), "Alejandro", "Navarro", "Rábago", "6441724947");
            em.persist(persona12);
            i++;

            Persona persona13 = new Persona("GDS509", LocalDate.of(1976, 8, 3), "Gibrán", "Durán", "Solano", "6442554509");
            em.persist(persona13);
            i++;

            Persona persona14 = new Persona("MJG618", LocalDate.of(1981, 6, 16), "Martin", "Joestar", "Gómez", "6442262618");
            em.persist(persona14);
            i++;

            Persona persona15 = new Persona("DTA316", LocalDate.of(1991, 10, 20), "Diego", "Torres", "Álvarez", "6442598316");
            em.persist(persona15);
            i++;

            Persona persona16 = new Persona("LGL738", LocalDate.of(1958, 6, 16), "Lulu", "Gómez", "López", "6672151738");
            em.persist(persona16);
            i++;

            Persona persona17 = new Persona("MLH969", LocalDate.of(1985, 9, 30), "Martha", "Larrínaga", "Hernandez", "6442587969");
            em.persist(persona17);
            i++;

            Persona persona18 = new Persona("JAC228", LocalDate.of(1970, 5, 4), "José", "Amado", "Castro", "6442125228");
            em.persist(persona18);
            i++;

            Persona persona19 = new Persona("JSQ385", LocalDate.of(2003, 3, 14), "Jorge", "Sánchez", "Quezada", "6442463385");
            em.persist(persona19);
            i++;

            Persona persona20 = new Persona("JAV006", LocalDate.of(1983, 4, 1), "Julión", "Alvarez", "Velasquez", "5584130006");
            em.persist(persona20);
            i++;

            em.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Se insertaron " + i + " persona(s) correctamente, ahitamos al tiro");
        } catch (PersistenceException ex) {
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Hubo un error al guardar las personas, intente de nuevo.");
        } finally {
            em.close();
            emf.close();
        }
    }

    @Override
    public Persona consultar(String RFC) throws PersistenciaException {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery consulta = cb.createQuery(Persona.class);
        Root<Persona> root = consulta.from(Persona.class);
        consulta.where(cb.equal(root.get("rfc"), RFC));
        TypedQuery<Persona> query = em.createQuery(consulta);
        return query.getSingleResult();
    }
}
