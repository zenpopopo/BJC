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
@Table(name = "tb_mst_mail_address")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbMstMailAddress.findAll", query = "SELECT t FROM TbMstMailAddress t"),
    @NamedQuery(name = "TbMstMailAddress.findByMailAddress", query = "SELECT t FROM TbMstMailAddress t WHERE t.mailAddress = :mailAddress"),
    @NamedQuery(name = "TbMstMailAddress.findByMailAddressKndCd", query = "SELECT t FROM TbMstMailAddress t WHERE t.mailAddressKndCd = :mailAddressKndCd"),
    @NamedQuery(name = "TbMstMailAddress.findByUpdateDate", query = "SELECT t FROM TbMstMailAddress t WHERE t.updateDate = :updateDate"),
    @NamedQuery(name = "TbMstMailAddress.findByUpdateUser", query = "SELECT t FROM TbMstMailAddress t WHERE t.updateUser = :updateUser"),
    @NamedQuery(name = "TbMstMailAddress.findByCreateDate", query = "SELECT t FROM TbMstMailAddress t WHERE t.createDate = :createDate"),
    @NamedQuery(name = "TbMstMailAddress.findByCreateUser", query = "SELECT t FROM TbMstMailAddress t WHERE t.createUser = :createUser"),
    @NamedQuery(name = "TbMstMailAddress.findByDelFlg", query = "SELECT t FROM TbMstMailAddress t WHERE t.delFlg = :delFlg")})
public class TbMstMailAddress implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "MAIL_ADDRESS")
    private String mailAddress;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "MAIL_ADDRESS_KND_CD")
    private String mailAddressKndCd;
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

    public TbMstMailAddress() {
    }

    public TbMstMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public TbMstMailAddress(String mailAddress, String mailAddressKndCd, Date updateDate, Date createDate, String createUser, String delFlg) {
        this.mailAddress = mailAddress;
        this.mailAddressKndCd = mailAddressKndCd;
        this.updateDate = updateDate;
        this.createDate = createDate;
        this.createUser = createUser;
        this.delFlg = delFlg;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public String getMailAddressKndCd() {
        return mailAddressKndCd;
    }

    public void setMailAddressKndCd(String mailAddressKndCd) {
        this.mailAddressKndCd = mailAddressKndCd;
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
        hash += (mailAddress != null ? mailAddress.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbMstMailAddress)) {
            return false;
        }
        TbMstMailAddress other = (TbMstMailAddress) object;
        if ((this.mailAddress == null && other.mailAddress != null) || (this.mailAddress != null && !this.mailAddress.equals(other.mailAddress))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jp.ardito.bjc.models.TbMstMailAddress[ mailAddress=" + mailAddress + " ]";
    }

}
