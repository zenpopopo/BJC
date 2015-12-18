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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "tb_inf_account")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbInfAccount.findAll", query = "SELECT t FROM TbInfAccount t"),
    @NamedQuery(name = "TbInfAccount.findByAccountId", query = "SELECT t FROM TbInfAccount t WHERE t.tbInfAccountPK.accountId = :accountId"),
    @NamedQuery(name = "TbInfAccount.findByAccountKndCd", query = "SELECT t FROM TbInfAccount t WHERE t.tbInfAccountPK.accountKndCd = :accountKndCd"),
    @NamedQuery(name = "TbInfAccount.findByEmpCd", query = "SELECT t FROM TbInfAccount t WHERE t.empCd = :empCd"),
    @NamedQuery(name = "TbInfAccount.findByPasswordId", query = "SELECT t FROM TbInfAccount t WHERE t.passwordId = :passwordId"),
    @NamedQuery(name = "TbInfAccount.findByPasswordChgNum", query = "SELECT t FROM TbInfAccount t WHERE t.passwordChgNum = :passwordChgNum"),
    @NamedQuery(name = "TbInfAccount.findByLastPasswordChgDate", query = "SELECT t FROM TbInfAccount t WHERE t.lastPasswordChgDate = :lastPasswordChgDate"),
    @NamedQuery(name = "TbInfAccount.findByUpdateDate", query = "SELECT t FROM TbInfAccount t WHERE t.updateDate = :updateDate"),
    @NamedQuery(name = "TbInfAccount.findByUpdateUser", query = "SELECT t FROM TbInfAccount t WHERE t.updateUser = :updateUser"),
    @NamedQuery(name = "TbInfAccount.findByCreateDate", query = "SELECT t FROM TbInfAccount t WHERE t.createDate = :createDate"),
    @NamedQuery(name = "TbInfAccount.findByCreateUser", query = "SELECT t FROM TbInfAccount t WHERE t.createUser = :createUser"),
    @NamedQuery(name = "TbInfAccount.findByDelFlg", query = "SELECT t FROM TbInfAccount t WHERE t.delFlg = :delFlg")})
public class TbInfAccount implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TbInfAccountPK tbInfAccountPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "EMP_CD")
    private String empCd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "PASSWORD_ID")
    private String passwordId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PASSWORD_CHG_NUM")
    private int passwordChgNum;
    @Column(name = "LAST_PASSWORD_CHG_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastPasswordChgDate;
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

    public TbInfAccount() {
    }

    public TbInfAccount(TbInfAccountPK tbInfAccountPK) {
        this.tbInfAccountPK = tbInfAccountPK;
    }

    public TbInfAccount(TbInfAccountPK tbInfAccountPK, String empCd, String passwordId, int passwordChgNum, Date updateDate, Date createDate, String createUser, String delFlg) {
        this.tbInfAccountPK = tbInfAccountPK;
        this.empCd = empCd;
        this.passwordId = passwordId;
        this.passwordChgNum = passwordChgNum;
        this.updateDate = updateDate;
        this.createDate = createDate;
        this.createUser = createUser;
        this.delFlg = delFlg;
    }

    public TbInfAccount(String accountId, String accountKndCd) {
        this.tbInfAccountPK = new TbInfAccountPK(accountId, accountKndCd);
    }

    public TbInfAccountPK getTbInfAccountPK() {
        return tbInfAccountPK;
    }

    public void setTbInfAccountPK(TbInfAccountPK tbInfAccountPK) {
        this.tbInfAccountPK = tbInfAccountPK;
    }

    public String getEmpCd() {
        return empCd;
    }

    public void setEmpCd(String empCd) {
        this.empCd = empCd;
    }

    public String getPasswordId() {
        return passwordId;
    }

    public void setPasswordId(String passwordId) {
        this.passwordId = passwordId;
    }

    public int getPasswordChgNum() {
        return passwordChgNum;
    }

    public void setPasswordChgNum(int passwordChgNum) {
        this.passwordChgNum = passwordChgNum;
    }

    public Date getLastPasswordChgDate() {
        return lastPasswordChgDate;
    }

    public void setLastPasswordChgDate(Date lastPasswordChgDate) {
        this.lastPasswordChgDate = lastPasswordChgDate;
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
        hash += (tbInfAccountPK != null ? tbInfAccountPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbInfAccount)) {
            return false;
        }
        TbInfAccount other = (TbInfAccount) object;
        if ((this.tbInfAccountPK == null && other.tbInfAccountPK != null) || (this.tbInfAccountPK != null && !this.tbInfAccountPK.equals(other.tbInfAccountPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jp.ardito.bjc.models.TbInfAccount[ tbInfAccountPK=" + tbInfAccountPK + " ]";
    }

}
