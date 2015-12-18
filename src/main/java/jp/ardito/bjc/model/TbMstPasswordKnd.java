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
@Table(name = "tb_mst_password_knd")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbMstPasswordKnd.findAll", query = "SELECT t FROM TbMstPasswordKnd t"),
    @NamedQuery(name = "TbMstPasswordKnd.findByPasswordKndCd", query = "SELECT t FROM TbMstPasswordKnd t WHERE t.passwordKndCd = :passwordKndCd"),
    @NamedQuery(name = "TbMstPasswordKnd.findByPasswordKndNm", query = "SELECT t FROM TbMstPasswordKnd t WHERE t.passwordKndNm = :passwordKndNm"),
    @NamedQuery(name = "TbMstPasswordKnd.findByUpdateDate", query = "SELECT t FROM TbMstPasswordKnd t WHERE t.updateDate = :updateDate"),
    @NamedQuery(name = "TbMstPasswordKnd.findByUpdateUser", query = "SELECT t FROM TbMstPasswordKnd t WHERE t.updateUser = :updateUser"),
    @NamedQuery(name = "TbMstPasswordKnd.findByCreateDate", query = "SELECT t FROM TbMstPasswordKnd t WHERE t.createDate = :createDate"),
    @NamedQuery(name = "TbMstPasswordKnd.findByCreateUser", query = "SELECT t FROM TbMstPasswordKnd t WHERE t.createUser = :createUser"),
    @NamedQuery(name = "TbMstPasswordKnd.findByDelFlg", query = "SELECT t FROM TbMstPasswordKnd t WHERE t.delFlg = :delFlg")})
public class TbMstPasswordKnd implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "PASSWORD_KND_CD")
    private String passwordKndCd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PASSWORD_KND_NM")
    private String passwordKndNm;
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

    public TbMstPasswordKnd() {
    }

    public TbMstPasswordKnd(String passwordKndCd) {
        this.passwordKndCd = passwordKndCd;
    }

    public TbMstPasswordKnd(String passwordKndCd, String passwordKndNm, Date updateDate, Date createDate, String createUser, String delFlg) {
        this.passwordKndCd = passwordKndCd;
        this.passwordKndNm = passwordKndNm;
        this.updateDate = updateDate;
        this.createDate = createDate;
        this.createUser = createUser;
        this.delFlg = delFlg;
    }

    public String getPasswordKndCd() {
        return passwordKndCd;
    }

    public void setPasswordKndCd(String passwordKndCd) {
        this.passwordKndCd = passwordKndCd;
    }

    public String getPasswordKndNm() {
        return passwordKndNm;
    }

    public void setPasswordKndNm(String passwordKndNm) {
        this.passwordKndNm = passwordKndNm;
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
        hash += (passwordKndCd != null ? passwordKndCd.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbMstPasswordKnd)) {
            return false;
        }
        TbMstPasswordKnd other = (TbMstPasswordKnd) object;
        if ((this.passwordKndCd == null && other.passwordKndCd != null) || (this.passwordKndCd != null && !this.passwordKndCd.equals(other.passwordKndCd))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jp.ardito.bjc.models.TbMstPasswordKnd[ passwordKndCd=" + passwordKndCd + " ]";
    }

}
