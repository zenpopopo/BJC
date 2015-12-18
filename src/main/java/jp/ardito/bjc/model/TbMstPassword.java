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
@Table(name = "tb_mst_password")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbMstPassword.findAll", query = "SELECT t FROM TbMstPassword t"),
    @NamedQuery(name = "TbMstPassword.findByPasswordId", query = "SELECT t FROM TbMstPassword t WHERE t.passwordId = :passwordId"),
    @NamedQuery(name = "TbMstPassword.findByPassword", query = "SELECT t FROM TbMstPassword t WHERE t.password = :password"),
    @NamedQuery(name = "TbMstPassword.findByPasswordKndCd", query = "SELECT t FROM TbMstPassword t WHERE t.passwordKndCd = :passwordKndCd"),
    @NamedQuery(name = "TbMstPassword.findByUpdateDate", query = "SELECT t FROM TbMstPassword t WHERE t.updateDate = :updateDate"),
    @NamedQuery(name = "TbMstPassword.findByUpdateUser", query = "SELECT t FROM TbMstPassword t WHERE t.updateUser = :updateUser"),
    @NamedQuery(name = "TbMstPassword.findByCreateDate", query = "SELECT t FROM TbMstPassword t WHERE t.createDate = :createDate"),
    @NamedQuery(name = "TbMstPassword.findByCreateUser", query = "SELECT t FROM TbMstPassword t WHERE t.createUser = :createUser"),
    @NamedQuery(name = "TbMstPassword.findByDelFlg", query = "SELECT t FROM TbMstPassword t WHERE t.delFlg = :delFlg")})
public class TbMstPassword implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "PASSWORD_ID")
    private String passwordId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "PASSWORD")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "PASSWORD_KND_CD")
    private String passwordKndCd;
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

    public TbMstPassword() {
    }

    public TbMstPassword(String passwordId) {
        this.passwordId = passwordId;
    }

    public TbMstPassword(String passwordId, String password, String passwordKndCd, Date updateDate, Date createDate, String createUser, String delFlg) {
        this.passwordId = passwordId;
        this.password = password;
        this.passwordKndCd = passwordKndCd;
        this.updateDate = updateDate;
        this.createDate = createDate;
        this.createUser = createUser;
        this.delFlg = delFlg;
    }

    public String getPasswordId() {
        return passwordId;
    }

    public void setPasswordId(String passwordId) {
        this.passwordId = passwordId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordKndCd() {
        return passwordKndCd;
    }

    public void setPasswordKndCd(String passwordKndCd) {
        this.passwordKndCd = passwordKndCd;
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
        hash += (passwordId != null ? passwordId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbMstPassword)) {
            return false;
        }
        TbMstPassword other = (TbMstPassword) object;
        if ((this.passwordId == null && other.passwordId != null) || (this.passwordId != null && !this.passwordId.equals(other.passwordId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jp.ardito.bjc.models.TbMstPassword[ passwordId=" + passwordId + " ]";
    }

}
