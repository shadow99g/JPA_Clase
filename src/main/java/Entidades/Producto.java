/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p")
    , @NamedQuery(name = "Producto.findByCodpro", query = "SELECT p FROM Producto p WHERE p.codpro = :codpro")
    , @NamedQuery(name = "Producto.findByDespro", query = "SELECT p FROM Producto p WHERE p.despro = :despro")
    , @NamedQuery(name = "Producto.findByCospro", query = "SELECT p FROM Producto p WHERE p.cospro = :cospro")
    , @NamedQuery(name = "Producto.findByStopro", query = "SELECT p FROM Producto p WHERE p.stopro = :stopro")
    , @NamedQuery(name = "Producto.findByEstpro", query = "SELECT p FROM Producto p WHERE p.estpro = :estpro")})
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false, precision = 38, scale = 0)
    private BigDecimal codpro;
    @Size(max = 50)
    @Column(length = 50)
    private String despro;
    @Size(max = 4)
    @Column(length = 4)
    private String cospro;
    private BigInteger stopro;
    private Character estpro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codpro")
    private List<DetalleVenta> detalleVentaList;

    public Producto() {
    }

    public Producto(BigDecimal codpro) {
        this.codpro = codpro;
    }

    public BigDecimal getCodpro() {
        return codpro;
    }

    public void setCodpro(BigDecimal codpro) {
        this.codpro = codpro;
    }

    public String getDespro() {
        return despro;
    }

    public void setDespro(String despro) {
        this.despro = despro;
    }

    public String getCospro() {
        return cospro;
    }

    public void setCospro(String cospro) {
        this.cospro = cospro;
    }

    public BigInteger getStopro() {
        return stopro;
    }

    public void setStopro(BigInteger stopro) {
        this.stopro = stopro;
    }

    public Character getEstpro() {
        return estpro;
    }

    public void setEstpro(Character estpro) {
        this.estpro = estpro;
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
        hash += (codpro != null ? codpro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.codpro == null && other.codpro != null) || (this.codpro != null && !this.codpro.equals(other.codpro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.clase.Producto[ codpro=" + codpro + " ]";
    }
    
}
