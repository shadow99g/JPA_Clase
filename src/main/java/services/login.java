/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Controller.PersonaFacade;
import Entidades.Persona;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author ADMINISTRADOR
 */
@Named(value = "login")
@SessionScoped
public class login implements Serializable {

    private String us, pass;

    @EJB
    private PersonaFacade usuFacade;
    private Persona usu;
//    private List<Persona> onemenu = null;

    public login() {
    }

    public String autentificar() {

        usu = usuFacade.loginPer(us);
        if (usu != null) {
            if (usu.getDniper().equals(pass)) {
                limpiar();
                return "ingresar";

            }
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "passwoid no existe", "password no existe"));
            return null;
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "usuario no existe", "usuario no existe"));
        return null;

    }
//
//    public void lts() throws Exception {
//
//        try {
//            onemenu = usuFacade.selectone();
//        } catch (Exception e) {
//            throw e ;
//        }
//
//    }

    public void limpiar() {

        us = null;
        pass = null;

    }

//    public List<Persona> getOnemenu() {
//        if (onemenu == null) {
//            onemenu = usuFacade.selectone();
//        }
//        return onemenu;
//    }

    public Persona getUsu() {
        return usu;
    }

    public void setUsu(Persona usu) {
        this.usu = usu;
    }

    public String getUs() {
        return us;
    }

    public void setUs(String us) {
        this.us = us;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

}
