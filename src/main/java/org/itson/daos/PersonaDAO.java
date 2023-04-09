/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.daos;

import java.time.LocalDate;
import java.time.Period;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.swing.JOptionPane;
import org.itson.dominio.ParametrosBusquedaPersonas;
import org.itson.dominio.Persona;
import org.itson.interfaces.IPersonaDAO;
import org.itson.utils.ConfiguracionPaginado;
import org.itson.utils.Encriptador;

/**
 *Clase que implementa todos los métodos de IPersonaDAO y contiene todo lo necesario para Persona
 * @author Hugo Navarro (233470)/Jorge Sánchez(233012)
 */
public class PersonaDAO implements IPersonaDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.itson_LuluTenencia_jar_1.0-SNAPSHOTPU");
    EntityManager em = emf.createEntityManager();
    Encriptador e = new Encriptador();

    int i = 0;

    /**
     * Método que valida si una persona es mayor de edad para poder ser registrada en la base de datos 
     * @param persona Persona a la que se le hará la validación de edad
     * @return true si la persona es mayor a 18 años, falso si no
     */
    public Boolean edad(Persona persona) {
        LocalDate anio = persona.getFechaNacimiento();
        LocalDate hoy = LocalDate.now();

        int edad = Period.between(anio, hoy).getYears();

        if (edad <= 17) {
            return false;
        } else {
            JOptionPane.showMessageDialog(null, "La persona de RFC: " + persona.getRfc() + " Tiene una edad inválida", "Alerta", JOptionPane.ERROR_MESSAGE);
            return true;
        }

    }

    /**
     * Método que inserta 20 personas a la base de datos para fines de prueba
     */
    @Override
    public void insertarPersonas() {
        try {

            em.getTransaction().begin();

            Persona persona1 = new Persona("MGM567", LocalDate.of(1987, 1, 3), "Mario", "García", "Mendoza", "5551234567");
            if (edad(persona1)) {
                em.persist(persona1);
                i++;
            } 

            Persona persona2 = new Persona("LGC678", LocalDate.of(1991, 7, 9), "Laura", "Gaxiola", "Castillo", "5552345678");
            if (edad(persona2)) {
                em.persist(persona2);
                i++;
            } 

            Persona persona3 = new Persona("GJM628", LocalDate.of(1998, 2, 15), "Gabriela", "Jiménez", "Mendoza", "6441392628");
            if (edad(persona3)) {
                em.persist(persona3);
                i++;
            } 

            Persona persona4 = new Persona("EDQ376", LocalDate.of(2003, 11, 2), "Esteban", "Durán", "Quintanar", "6444609376");
            if (edad(persona4)) {
                em.persist(persona4);
                i++;
            } 

            Persona persona5 = new Persona("HMP888", LocalDate.of(1984, 7, 27), "Humberto", "Marchena", "Salazar", "6442322888");
            if (edad(persona5)) {
                em.persist(persona5);
                i++;
            } 

            Persona persona6 = new Persona("DRL766", LocalDate.of(1968, 6, 28), "Daniel", "Ramírez", "Lapizco", "6444301766");
            if (edad(persona6)) {
                em.persist(persona6);
                i++;
            } 

            Persona persona7 = new Persona("ILR804", LocalDate.of(1999, 12, 6), "Ilde", "Lares", "Rangel", "6442343804");
            if (edad(persona7)) {
                em.persist(persona7);
                i++;
            } 

            Persona persona8 = new Persona("RVG100", LocalDate.of(2000, 1, 31), "Rúben", "Valenzuela", "Gonzáles", "6441020100");
            if (edad(persona8)) {
                em.persist(persona8);
                i++;
            } 

            Persona persona9 = new Persona("HNR088", LocalDate.of(2003, 7, 25), "Hugo", "Navarro", "Ramírez", "6442740088");
            if (edad(persona9)) {
                em.persist(persona9);
                i++;
            } 
            Persona persona10 = new Persona("JNR400", LocalDate.of(1996, 2, 15), "Julio", "Navarro", "Ramírez", "642949400");
            if (edad(persona10)) {
                em.persist(persona10);
                i++;
            } 

            Persona persona11 = new Persona("EAV292", LocalDate.of(1992, 10, 18), "Elmer", "Arredondo", "Vaca", "6442441292");
            if (edad(persona11)) {
                em.persist(persona11);
                i++;
            } 

            Persona persona12 = new Persona("ANR947", LocalDate.of(1987, 1, 24), "Alejandro", "Navarro", "Rábago", "6441724947");
            if (edad(persona12)) {
                em.persist(persona12);
                i++;
            } 

            Persona persona13 = new Persona("GDS509", LocalDate.of(1976, 8, 3), "Gibrán", "Durán", "Solano", "6442554509");
            if (edad(persona13)) {
                em.persist(persona13);
                i++;
            } 

            Persona persona14 = new Persona("MJG618", LocalDate.of(1981, 6, 16), "Martin", "Joestar", "Gómez", "6442262618");
            if (edad(persona14)) {
                em.persist(persona14);
                i++;
            } 

            Persona persona15 = new Persona("DTA316", LocalDate.of(1991, 10, 20), "Diego", "Torres", "Álvarez", "6442598316");
            if (edad(persona15)) {
                em.persist(persona15);
                i++;
            } 

            Persona persona16 = new Persona("LGL738", LocalDate.of(1958, 6, 16), "Lulu", "Gómez", "López", "6672151738");
            if (edad(persona16)) {
                em.persist(persona16);
                i++;
            } 

            Persona persona17 = new Persona("MLH969", LocalDate.of(1985, 9, 30), "Martha", "Larrínaga", "Hernandez", "6442587969");
            if (edad(persona17)) {
                em.persist(persona17);
                i++;
            } 

            Persona persona18 = new Persona("JAC228", LocalDate.of(1970, 5, 4), "José", "Amado", "Castro", "6442125228");
            if (edad(persona18)) {
                em.persist(persona18);
                i++;
            } 

            Persona persona19 = new Persona("JSQ385", LocalDate.of(2003, 3, 14), "Jorge", "Sánchez", "Quezada", "6442463385");
            if (edad(persona19)) {
                em.persist(persona19);
                i++;
            } 

            Persona persona20 = new Persona("JAV006", LocalDate.of(1983, 4, 1), "Julión", "Alvarez", "Velasquez", "5584130006");
            if (edad(persona20)) {
                em.persist(persona20);
                i++;
            } 

            em.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Se insertaron " + i + " persona(s) correctamente, ahitamos al tiro");
        } catch (PersistenceException ex) {
            em.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Hubo un error al guardar las personas, intente de nuevo.");
        }
    }

    /**
     * Método que consulta la existencia de una persona mediante su rfc
     *
     * @param RFC cadena de caracteres identificadores de la persona
     * @return regresa un objeto de tipo persona a la que le corresonde ese rfc
     * @throws NoResultException Arroja una excepción si no se encontró ninguna
     * persona con ese RFC
     */
    @Override
    public Persona consultar(String RFC) {
        try {
            //Aquí consulta con un dato desencriptado
            //Y regresa toda la fila con datos desencriptados
            return em.find(Persona.class, RFC);
        } catch (NoResultException ex) {
            return null;
        }

    }

    /**
     * Método que consulta personas con base a filtros
     *
     * @param params parametros que se obtienen para seleccionar los filtros
     * para la busqueda
     * @return regresa una lista de personas que coincidan con la informacion
     * recibida para los filtros
     * @throws NoResultException Arroja null por que no hubo resultados.
     */
    @Override
    public List<Persona> consultarPersonas(ParametrosBusquedaPersonas params, ConfiguracionPaginado configuracionPaginado) throws NoResultException {

        CriteriaBuilder builder = em.getCriteriaBuilder();

        CriteriaQuery<Persona> criteria = builder.createQuery(Persona.class);
        Root<Persona> root = criteria.from(Persona.class);

        List<Predicate> filtros = new LinkedList<>();

        if (params.getRfc() != null && !params.getRfc().isEmpty()) {
            filtros.add(builder.like(root.get("rfc"), "%" + params.getRfc() + "%"));
        }
        if (params.getNombre() != null && !params.getNombre().isEmpty()) {
            filtros.add(builder.like(
                    builder.concat(
                            builder.concat(root.get("nombres"), root.get("apellidoPaterno")),
                            root.get("apellidoMaterno")
                    ), "%" + params.getNombre() + "%")
            );
        }
        if (params.getFechaNac() != null && !params.getFechaNac().equals(0)) {
            filtros.add(builder.equal(builder.function("year", Integer.class, root.get("fechaNacimiento")), params.getFechaNac()));

        }

        try {
            criteria = criteria.select(root).where(builder.or(filtros.toArray(new Predicate[0])));

            TypedQuery<Persona> query;
            if (configuracionPaginado != null) {
                query = em.createQuery(criteria).setFirstResult(configuracionPaginado.getElementosASaltar())
                        .setMaxResults(configuracionPaginado.getElementosPagina());
            } else {
                query = em.createQuery(criteria);
            }
            List<Persona> personas = query.getResultList();
            return personas;
        } catch (NoResultException ex) {
            return null;
        }
    }

}
