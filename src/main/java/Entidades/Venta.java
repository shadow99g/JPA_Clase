/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
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
    @NamedQuery(name = "Venta.findAll", query = "SELECT v FROM Venta v")
    , @NamedQuery(name = "Venta.findByCodven", query = "SELECT v FROM Venta v WHERE v.codven = :codven")
    , @NamedQuery(name = "Venta.findByFecven", query = "SELECT v FROM Venta v WHERE v.fecven = :fecven")
    , @NamedQuery(name = "Venta.findByTotven", query = "SELECT v FROM Venta v WHERE v.totven = :totven")})
public class Venta implements Serializable {

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false, precision = 38, scale = 0)
    private BigDecimal codven;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecven;
    private BigInteger totven;

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation

    @JoinColumn(name = "CODPER", referencedColumnName = "CODPER", nullable = false)
    @ManyToOne(optional = false)
    private Persona codper;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codven")
    private List<DetalleVenta> detalleVentaList;

    @Transient
    private int nroventa;

    public Venta() {
    }

    public int getNroventa() {
        nroventa = detalleVentaList.size();
        return nroventa;
    }

    public Venta(BigDecimal codven) {
        this.codven = codven;
    }

    public BigDecimal getCodven() {
        return codven;
    }

    public void setCodven(BigDecimal codven) {
        this.codven = codven;
    }

    public Date getFecven() {
        return fecven;
    }

    public void setFecven(Date fecven) {
        this.fecven = fecven;
    }

    public BigInteger getTotven() {
        return totven;
    }

    public void setTotven(BigInteger totven) {
        this.totven = totven;
    }

    public Persona getCodper() {
        return codper;
    }

    public void setCodper(Persona codper) {
        this.codper = codper;
    }

    @XmlTransient
    public List<DetalleVenta> getDetalleVentaList() {
        return detalleVentaList;
    }

    public void setDetalleVentaList(List<DetalleVenta> detalleVentaList) {
        this.detalleVentaList = detalleVentaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codven != null ? codven.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Venta)) {
            return false;
        }
        Venta other = (Venta) object;
        if ((this.codven == null && other.codven != null) || (this.codven != null && !this.codven.equals(other.codven))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.clase.Venta[ codven=" + codven + " ]";
    }

}
