/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.daos;

import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.itson.dominio.Persona;

/**
 *
 * @author JORGE
 */
public class PersonasDAO {
    
    public void insertarPersonas(){
       try{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("tu-unidad-de-persistencia");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Persona persona1 = new Persona("MGM567", new Date(1987, 1, 3), "Mario", "García", "Mendoza", "5551234567");
        em.persist(persona1);

        Persona persona2 = new Persona("LGC678", new Date(1991, 7, 9), "Laura", "Gaxiola", "Castillo", "5552345678");
        em.persist(persona2);

        Persona persona3 = new Persona("GJM628", new Date(1998, 2, 15), "Gabriela", "Jiménez", "Mendoza", "6441392628");
        em.persist(persona3);
        
        Persona persona4 = new Persona("EDQ376", new Date(2003, 11, 2), "Esteban", "Durán", "Quintanar", "6444609376");
        em.persist(persona4);
        
        Persona persona5 = new Persona("HMP888", new Date(1984, 7, 27), "Humberto", "Marchena", "Salazar", "6442322888");
        em.persist(persona5);
        
        Persona persona6 = new Persona("DRL766", new Date(1968, 6, 28), "Daniel", "Ramírez", "Lapizco", "6444301766");
        em.persist(persona6);
        
        Persona persona7 = new Persona("ILR804", new Date(1999, 12, 6), "Ilde", "Lares", "Rangel", "6442343804");
        em.persist(persona7);
        
        Persona persona8 = new Persona("RVG100", new Date(2000, 1, 31), "Rúben", "Valenzuela", "Gonzáles", "6441020100");
        em.persist(persona8);
        
        Persona persona9 = new Persona("HNR088", new Date(2003, 7, 25), "Hugo", "Navarro", "Ramírez", "6442740088");
        em.persist(persona9);
        
        Persona persona10 = new Persona("JNR400", new Date(1996, 2, 15), "Julio", "Navarro", "Ramírez", "642949400");
        em.persist(persona10);
        
        Persona persona11 = new Persona("EAV292", new Date(1992, 10, 18), "Elmer", "Arredondo", "Vaca", "6442441292");
        em.persist(persona11);
        
        Persona persona12 = new Persona("ANR947", new Date(1987, 1, 24), "Alejandro", "Navarro", "Rábago", "6441724947");
        em.persist(persona12);
        
        Persona persona13 = new Persona("GDS509", new Date(1976, 8, 3), "Gibrán", "Durán", "Solano", "6442554509");
        em.persist(persona13);
        
        Persona persona14 = new Persona("MJG618", new Date(1981, 6, 16), "Martin", "Joestar", "Gómez", "6442262618");
        em.persist(persona14);
        
        Persona persona15 = new Persona("DTA316", new Date(1991, 10, 20), "Diego", "Torres", "Álvarez", "6442598316");
        em.persist(persona15);
        
        Persona persona16 = new Persona("LGL738", new Date(1958, 6, 16), "Lulu", "Gómez", "López", "6672151738");
        em.persist(persona16);
        
        Persona persona17 = new Persona("MLH969", new Date(1985, 9, 30), "Martha", "Larrínaga", "Hernandez", "6442587969");
        em.persist(persona17);
        
        Persona persona18 = new Persona("JAC228", new Date(1970, 5, 4), "José", "Amado", "Castro", "6442125228");
        em.persist(persona18);
        
        Persona persona19 = new Persona("JSQ385", new Date(2003, 3, 14), "Jorge", "Sánchez", "Quezada", "6442463385");
        em.persist(persona19);
        
        Persona persona20 = new Persona("JAV006", new Date(1983, 4, 1), "Julión", "Alvarez", "Velasquez", "5584130006");
        em.persist(persona20);
        
        em.getTransaction().commit();
        em.close();
        emf.close();
        
       }catch(Exception ex){
           
           
       }
        
    }
}
