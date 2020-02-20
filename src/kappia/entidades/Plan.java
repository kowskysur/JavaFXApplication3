/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kappia.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author usuario pc
 */
@Entity
@Table(name = "plan")

public class Plan implements Serializable {

    @Id
    @Column(name = "idPlan")
    private Integer idPlan;
    @Column(name = "nombrePlan")
    private String nombrePlan;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "estado")
    private short estado;

    public Plan() {
    }

    public Plan(Integer idPlan) {
        this.idPlan = idPlan;
    }

    public Plan(Integer idPlan, String nombrePlan, String descripcion, short estado) {
        this.idPlan = idPlan;
        this.nombrePlan = nombrePlan;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public Integer getIdPlan() {
        return idPlan;
    }

    public void setIdPlan(Integer idPlan) {
        this.idPlan = idPlan;
    }

    public String getNombrePlan() {
        return nombrePlan;
    }

    public void setNombrePlan(String nombrePlan) {
        this.nombrePlan = nombrePlan;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public short getEstado() {
        return estado;
    }

    public void setEstado(short estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPlan != null ? idPlan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Plan)) {
            return false;
        }
        Plan other = (Plan) object;
        if ((this.idPlan == null && other.idPlan != null) || (this.idPlan != null && !this.idPlan.equals(other.idPlan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "kappia.entidades.Plan[ idPlan=" + idPlan + " ]";
    }
    
}
