/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ADMINISTRADOR
 */
@Entity
@Table(catalog = "", schema = "demo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p")
    , @NamedQuery(name = "Persona.findByCodper", query = "SELECT p FROM Persona p WHERE p.codper = :codper")
    , @NamedQuery(name = "Persona.findByNomper", query = "SELECT p FROM Persona p WHERE p.nomper = :nomper")
    , @NamedQuery(name = "Persona.findByApeper", query = "SELECT p FROM Persona p WHERE p.apeper = :apeper")
    , @NamedQuery(name = "Persona.findByDniper", query = "SELECT p FROM Persona p WHERE p.dniper = :dniper")
    , @NamedQuery(name = "Persona.findByFecnacper", query = "SELECT p FROM Persona p WHERE p.fecnacper = :fecnacper")
    , @NamedQuery(name = "Persona.findByDirper", query = "SELECT p FROM Persona p WHERE p.dirper = :dirper")
    , @NamedQuery(name = "Persona.findByTelper", query = "SELECT p FROM Persona p WHERE p.telper = :telper")
    , @NamedQuery(name = "Persona.findByEstper", query = "SELECT p FROM Persona p WHERE p.estper = :estper")
})
public class Persona implements Serializable {

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false, precision = 38, scale = 0)
    private BigDecimal codper;
    @Size(max = 50)
    @Column(length = 50)
    private String nomper;
    @Size(max = 50)
    @Column(length = 50)
    private String apeper;
    @Size(max = 8)
    @Column(length = 8)
    private String dniper;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecnacper;
    @Size(max = 50)
    @Column(length = 50)
    private String dirper;
    @Size(max = 9)
    @Column(length = 9)
    private String telper;
    private Character estper;
    @Size(max = 20)
    @Column(length = 20)
    private String passwd;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codper")
    private List<Venta> ventaList;

    public Persona() {
    }

    public Persona(BigDecimal codper) {
        this.codper = codper;
    }

    public BigDecimal getCodper() {
        return codper;
    }

    public void setCodper(BigDecimal codper) {
        this.codper = codper;
    }

    public String getNomper() {
        return nomper;
    }

    public void setNomper(String nomper) {
        this.nomper = nomper;
    }

    public String getApeper() {
        return apeper;
    }

    public void setApeper(String apeper) {
        this.apeper = apeper;
    }

    public String getDniper() {
        return dniper;
    }

    public void setDniper(String dniper) {
        this.dniper = dniper;
    }

    public String getDirper() {
        return dirper;
    }

    public void setDirper(String dirper) {
        this.dirper = dirper;
    }

    public String getTelper() {
        return telper;
    }

    public void setTelper(String telper) {
        this.telper = telper;
    }

    public Character getEstper() {
        return estper;
    }

    public void setEstper(Character estper) {
        this.estper = estper;
    }

    @XmlTransient
    public List<Venta> getVentaList() {
        return ventaList;
    }

    public void setVentaList(List<Venta> ventaList) {
        this.ventaList = ventaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codper != null ? codper.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.codper == null && other.codper != null) || (this.codper != null && !this.codper.equals(other.codper))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.clase.Persona[ codper=" + codper + " ]";
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public Date getFecnacper() {
        return fecnacper;
    }

    public void setFecnacper(Date fecnacper) {
        this.fecnacper = fecnacper;
    }

}
