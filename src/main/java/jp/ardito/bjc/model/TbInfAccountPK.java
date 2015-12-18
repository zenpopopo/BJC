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
public class TbInfAccountPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ACCOUNT_ID")
    private String accountId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "ACCOUNT_KND_CD")
    private String accountKndCd;

    public TbInfAccountPK() {
    }

    public TbInfAccountPK(String accountId, String accountKndCd) {
        this.accountId = accountId;
        this.accountKndCd = accountKndCd;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountKndCd() {
        return accountKndCd;
    }

    public void setAccountKndCd(String accountKndCd) {
        this.accountKndCd = accountKndCd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accountId != null ? accountId.hashCode() : 0);
        hash += (accountKndCd != null ? accountKndCd.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbInfAccountPK)) {
            return false;
        }
        TbInfAccountPK other = (TbInfAccountPK) object;
        if ((this.accountId == null && other.accountId != null) || (this.accountId != null && !this.accountId.equals(other.accountId))) {
            return false;
        }
        if ((this.accountKndCd == null && other.accountKndCd != null) || (this.accountKndCd != null && !this.accountKndCd.equals(other.accountKndCd))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jp.ardito.bjc.models.TbInfAccountPK[ accountId=" + accountId + ", accountKndCd=" + accountKndCd + " ]";
    }

}
