/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.ardito.bjc.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author zempo
 */
@Entity
@Table(name = "tb_mst_employee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbMstEmployee.findAll", query = "SELECT t FROM TbMstEmployee t"),
    @NamedQuery(name = "TbMstEmployee.findByEmpCd", query = "SELECT t FROM TbMstEmployee t WHERE t.empCd = :empCd"),
    @NamedQuery(name = "TbMstEmployee.findByEmpNmSei", query = "SELECT t FROM TbMstEmployee t WHERE t.empNmSei = :empNmSei"),
    @NamedQuery(name = "TbMstEmployee.findByEmpNmMei", query = "SELECT t FROM TbMstEmployee t WHERE t.empNmMei = :empNmMei"),
    @NamedQuery(name = "TbMstEmployee.findByEmpNmSeiKn", query = "SELECT t FROM TbMstEmployee t WHERE t.empNmSeiKn = :empNmSeiKn"),
    @NamedQuery(name = "TbMstEmployee.findByEmpNmMeiKn", query = "SELECT t FROM TbMstEmployee t WHERE t.empNmMeiKn = :empNmMeiKn"),
    @NamedQuery(name = "TbMstEmployee.findByJoinedDate", query = "SELECT t FROM TbMstEmployee t WHERE t.joinedDate = :joinedDate"),
    @NamedQuery(name = "TbMstEmployee.findByLeavingDate", query = "SELECT t FROM TbMstEmployee t WHERE t.leavingDate = :leavingDate"),
    @NamedQuery(name = "TbMstEmployee.findByUpdDate", query = "SELECT t FROM TbMstEmployee t WHERE t.updDate = :updDate"),
    @NamedQuery(name = "TbMstEmployee.findByUpdUser", query = "SELECT t FROM TbMstEmployee t WHERE t.updUser = :updUser"),
    @NamedQuery(name = "TbMstEmployee.findByCreDate", query = "SELECT t FROM TbMstEmployee t WHERE t.creDate = :creDate"),
    @NamedQuery(name = "TbMstEmployee.findByCreUser", query = "SELECT t FROM TbMstEmployee t WHERE t.creUser = :creUser"),
    @NamedQuery(name = "TbMstEmployee.findByDelFlg", query = "SELECT t FROM TbMstEmployee t WHERE t.delFlg = :delFlg")})
public class TbMstEmployee implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "EMP_CD")
    private String empCd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "EMP_NM_SEI")
    private String empNmSei;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "EMP_NM_MEI")
    private String empNmMei;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "EMP_NM_SEI_KN")
    private String empNmSeiKn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "EMP_NM_MEI_KN")
    private String empNmMeiKn;
    @Basic(optional = false)
    @NotNull
    @Column(name = "JOINED_DATE")
    @Temporal(TemporalType.DATE)
    private Date joinedDate;
    @Column(name = "LEAVING_DATE")
    @Temporal(TemporalType.DATE)
    private Date leavingDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "UPD_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updDate;
    @Size(max = 10)
    @Column(name = "UPD_USER")
    private String updUser;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CRE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "CRE_USER")
    private String creUser;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "DEL_FLG")
    private String delFlg;

    public TbMstEmployee() {
    }

    public TbMstEmployee(String empCd) {
        this.empCd = empCd;
    }

    public TbMstEmployee(String empCd, String empNmSei, String empNmMei, String empNmSeiKn, String empNmMeiKn, Date joinedDate, Date updDate, Date creDate, String creUser, String delFlg) {
        this.empCd = empCd;
        this.empNmSei = empNmSei;
        this.empNmMei = empNmMei;
        this.empNmSeiKn = empNmSeiKn;
        this.empNmMeiKn = empNmMeiKn;
        this.joinedDate = joinedDate;
        this.updDate = updDate;
        this.creDate = creDate;
        this.creUser = creUser;
        this.delFlg = delFlg;
    }

    public String getEmpCd() {
        return empCd;
    }

    public void setEmpCd(String empCd) {
        this.empCd = empCd;
    }

    public String getEmpNmSei() {
        return empNmSei;
    }

    public void setEmpNmSei(String empNmSei) {
        this.empNmSei = empNmSei;
    }

    public String getEmpNmMei() {
        return empNmMei;
    }

    public void setEmpNmMei(String empNmMei) {
        this.empNmMei = empNmMei;
    }

    public String getEmpNmSeiKn() {
        return empNmSeiKn;
    }

    public void setEmpNmSeiKn(String empNmSeiKn) {
        this.empNmSeiKn = empNmSeiKn;
    }

    public String getEmpNmMeiKn() {
        return empNmMeiKn;
    }

    public void setEmpNmMeiKn(String empNmMeiKn) {
        this.empNmMeiKn = empNmMeiKn;
    }

    public Date getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(Date joinedDate) {
        this.joinedDate = joinedDate;
    }

    public Date getLeavingDate() {
        return leavingDate;
    }

    public void setLeavingDate(Date leavingDate) {
        this.leavingDate = leavingDate;
    }

    public Date getUpdDate() {
        return updDate;
    }

    public void setUpdDate(Date updDate) {
        this.updDate = updDate;
    }

    public String getUpdUser() {
        return updUser;
    }

    public void setUpdUser(String updUser) {
        this.updUser = updUser;
    }

    public Date getCreDate() {
        return creDate;
    }

    public void setCreDate(Date creDate) {
        this.creDate = creDate;
    }

    public String getCreUser() {
        return creUser;
    }

    public void setCreUser(String creUser) {
        this.creUser = creUser;
    }

    public String getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(String delFlg) {
        this.delFlg = delFlg;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empCd != null ? empCd.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbMstEmployee)) {
            return false;
        }
        TbMstEmployee other = (TbMstEmployee) object;
        if ((this.empCd == null && other.empCd != null) || (this.empCd != null && !this.empCd.equals(other.empCd))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jp.ardito.bjc.models.TbMstEmployee[ empCd=" + empCd + " ]";
    }

}
