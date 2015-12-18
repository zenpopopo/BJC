/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.ardito.bjc.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author zempo
 */
@Embeddable
public class TbInfEmployeePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "EMP_CD")
    private String empCd;
    @Basic(optional = false)
    @NotNull
    @Column(name = "REVISION")
    private int revision;

    public TbInfEmployeePK() {
    }

    public TbInfEmployeePK(String empCd, int revision) {
        this.empCd = empCd;
        this.revision = revision;
    }

    public String getEmpCd() {
        return empCd;
    }

    public void setEmpCd(String empCd) {
        this.empCd = empCd;
    }

    public int getRevision() {
        return revision;
    }

    public void setRevision(int revision) {
        this.revision = revision;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empCd != null ? empCd.hashCode() : 0);
        hash += (int) revision;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbInfEmployeePK)) {
            return false;
        }
        TbInfEmployeePK other = (TbInfEmployeePK) object;
        if ((this.empCd == null && other.empCd != null) || (this.empCd != null && !this.empCd.equals(other.empCd))) {
            return false;
        }
        if (this.revision != other.revision) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jp.ardito.bjc.models.TbInfEmployeePK[ empCd=" + empCd + ", revision=" + revision + " ]";
    }

}
