/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ADMINISTRADOR
 */
@Entity
@Table(name = "DETALLE_VENTA", catalog = "", schema = "demo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleVenta.findAll", query = "SELECT d FROM DetalleVenta d")
    , @NamedQuery(name = "DetalleVenta.findByCoddetven", query = "SELECT d FROM DetalleVenta d WHERE d.coddetven = :coddetven")
    , @NamedQuery(name = "DetalleVenta.findByCanven", query = "SELECT d FROM DetalleVenta d WHERE d.canven = :canven")
    , @NamedQuery(name = "DetalleVenta.findBySbtven", query = "SELECT d FROM DetalleVenta d WHERE d.sbtven = :sbtven")})
public class DetalleVenta implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false, precision = 38, scale = 0)
    private BigDecimal coddetven;
    private BigInteger canven;
    private BigInteger sbtven;
    @JoinColumn(name = "CODPRO", referencedColumnName = "CODPRO", nullable = false)
    @ManyToOne(optional = false)
    private Producto codpro;
    @JoinColumn(name = "CODVEN", referencedColumnName = "CODVEN", nullable = false)
    @ManyToOne(optional = false)
    private Venta codven;

    public DetalleVenta() {
    }

    public DetalleVenta(BigDecimal coddetven) {
        this.coddetven = coddetven;
    }

    public BigDecimal getCoddetven() {
        return coddetven;
    }

    public void setCoddetven(BigDecimal coddetven) {
        this.coddetven = coddetven;
    }

    public BigInteger getCanven() {
        return canven;
    }

    public void setCanven(BigInteger canven) {
        this.canven = canven;
    }

    public BigInteger getSbtven() {
        return sbtven;
    }

    public void setSbtven(BigInteger sbtven) {
        this.sbtven = sbtven;
    }

    public Producto getCodpro() {
        return codpro;
    }

    public void setCodpro(Producto codpro) {
        this.codpro = codpro;
    }

    public Venta getCodven() {
        return codven;
    }

    public void setCodven(Venta codven) {
        this.codven = codven;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (coddetven != null ? coddetven.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleVenta)) {
            return false;
        }
        DetalleVenta other = (DetalleVenta) object;
        if ((this.coddetven == null && other.coddetven != null) || (this.coddetven != null && !this.coddetven.equals(other.coddetven))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.clase.DetalleVenta[ coddetven=" + coddetven + " ]";
    }
    
}
