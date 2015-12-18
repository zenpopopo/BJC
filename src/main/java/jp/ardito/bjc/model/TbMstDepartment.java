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
@Table(name = "tb_mst_department")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbMstDepartment.findAll", query = "SELECT t FROM TbMstDepartment t"),
    @NamedQuery(name = "TbMstDepartment.findByDepCd", query = "SELECT t FROM TbMstDepartment t WHERE t.depCd = :depCd"),
    @NamedQuery(name = "TbMstDepartment.findByDepNm", query = "SELECT t FROM TbMstDepartment t WHERE t.depNm = :depNm"),
    @NamedQuery(name = "TbMstDepartment.findByUpdateDate", query = "SELECT t FROM TbMstDepartment t WHERE t.updateDate = :updateDate"),
    @NamedQuery(name = "TbMstDepartment.findByUpdateUser", query = "SELECT t FROM TbMstDepartment t WHERE t.updateUser = :updateUser"),
    @NamedQuery(name = "TbMstDepartment.findByCreateDate", query = "SELECT t FROM TbMstDepartment t WHERE t.createDate = :createDate"),
    @NamedQuery(name = "TbMstDepartment.findByCreateUser", query = "SELECT t FROM TbMstDepartment t WHERE t.createUser = :createUser"),
    @NamedQuery(name = "TbMstDepartment.findByDelFlg", query = "SELECT t FROM TbMstDepartment t WHERE t.delFlg = :delFlg")})
public class TbMstDepartment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "DEP_CD")
    private String depCd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "DEP_NM")
    private String depNm;
    @Basic(optional = false)
    @NotNull
    @Column(name = "UPDATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
    @Size(max = 10)
    @Column(name = "UPDATE_USER")
    private String updateUser;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "CREATE_USER")
    private String createUser;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "DEL_FLG")
    private String delFlg;

    public TbMstDepartment() {
    }

    public TbMstDepartment(String depCd) {
        this.depCd = depCd;
    }

    public TbMstDepartment(String depCd, String depNm, Date updateDate, Date createDate, String createUser, String delFlg) {
        this.depCd = depCd;
        this.depNm = depNm;
        this.updateDate = updateDate;
        this.createDate = createDate;
        this.createUser = createUser;
        this.delFlg = delFlg;
    }

    public String getDepCd() {
        return depCd;
    }

    public void setDepCd(String depCd) {
        this.depCd = depCd;
    }

    public String getDepNm() {
        return depNm;
    }

    public void setDepNm(String depNm) {
        this.depNm = depNm;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
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
        hash += (depCd != null ? depCd.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbMstDepartment)) {
            return false;
        }
        TbMstDepartment other = (TbMstDepartment) object;
        if ((this.depCd == null && other.depCd != null) || (this.depCd != null && !this.depCd.equals(other.depCd))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jp.ardito.bjc.models.TbMstDepartment[ depCd=" + depCd + " ]";
    }

}
