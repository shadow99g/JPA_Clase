/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entidades.Persona;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ADMINISTRADOR
 */
@Stateless
public class PersonaFacade extends AbstractFacade<Persona> {

    @PersistenceContext(unitName = "com.mycompany_Clase_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonaFacade() {
        super(Persona.class);
    }

    public Persona loginPer(String usu) {
        Query q = em.createNamedQuery("Persona.findByNomper", Persona.class).setParameter("nomper", usu);
        List<Persona> list = q.getResultList();

        if (!list.isEmpty()) {

            return list.get(0);

        }

        return null;
    }

}
