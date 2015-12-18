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
@Table(name = "tb_inf_employee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbInfEmployee.findAll", query = "SELECT t FROM TbInfEmployee t"),
    @NamedQuery(name = "TbInfEmployee.findByEmpCd", query = "SELECT t FROM TbInfEmployee t WHERE t.tbInfEmployeePK.empCd = :empCd"),
    @NamedQuery(name = "TbInfEmployee.findByRevision", query = "SELECT t FROM TbInfEmployee t WHERE t.tbInfEmployeePK.revision = :revision"),
    @NamedQuery(name = "TbInfEmployee.findByMailAddress", query = "SELECT t FROM TbInfEmployee t WHERE t.mailAddress = :mailAddress"),
    @NamedQuery(name = "TbInfEmployee.findByDepCd", query = "SELECT t FROM TbInfEmployee t WHERE t.depCd = :depCd"),
    @NamedQuery(name = "TbInfEmployee.findByMgRankCd", query = "SELECT t FROM TbInfEmployee t WHERE t.mgRankCd = :mgRankCd"),
    @NamedQuery(name = "TbInfEmployee.findByPgRankCd", query = "SELECT t FROM TbInfEmployee t WHERE t.pgRankCd = :pgRankCd"),
    @NamedQuery(name = "TbInfEmployee.findByUpdateDate", query = "SELECT t FROM TbInfEmployee t WHERE t.updateDate = :updateDate"),
    @NamedQuery(name = "TbInfEmployee.findByUpdateUser", query = "SELECT t FROM TbInfEmployee t WHERE t.updateUser = :updateUser"),
    @NamedQuery(name = "TbInfEmployee.findByCreateDate", query = "SELECT t FROM TbInfEmployee t WHERE t.createDate = :createDate"),
    @NamedQuery(name = "TbInfEmployee.findByCreateUser", query = "SELECT t FROM TbInfEmployee t WHERE t.createUser = :createUser"),
    @NamedQuery(name = "TbInfEmployee.findByDelFlg", query = "SELECT t FROM TbInfEmployee t WHERE t.delFlg = :delFlg")})
public class TbInfEmployee implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TbInfEmployeePK tbInfEmployeePK;
    @Size(max = 50)
    @Column(name = "MAIL_ADDRESS")
    private String mailAddress;
    @Size(max = 2)
    @Column(name = "DEP_CD")
    private String depCd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "MG_RANK_CD")
    private String mgRankCd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "PG_RANK_CD")
    private String pgRankCd;
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

    public TbInfEmployee() {
    }

    public TbInfEmployee(TbInfEmployeePK tbInfEmployeePK) {
        this.tbInfEmployeePK = tbInfEmployeePK;
    }

    public TbInfEmployee(TbInfEmployeePK tbInfEmployeePK, String mgRankCd, String pgRankCd, Date updateDate, Date createDate, String createUser, String delFlg) {
        this.tbInfEmployeePK = tbInfEmployeePK;
        this.mgRankCd = mgRankCd;
        this.pgRankCd = pgRankCd;
        this.updateDate = updateDate;
        this.createDate = createDate;
        this.createUser = createUser;
        this.delFlg = delFlg;
    }

    public TbInfEmployee(String empCd, int revision) {
        this.tbInfEmployeePK = new TbInfEmployeePK(empCd, revision);
    }

    public TbInfEmployeePK getTbInfEmployeePK() {
        return tbInfEmployeePK;
    }

    public void setTbInfEmployeePK(TbInfEmployeePK tbInfEmployeePK) {
        this.tbInfEmployeePK = tbInfEmployeePK;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public String getDepCd() {
        return depCd;
    }

    public void setDepCd(String depCd) {
        this.depCd = depCd;
    }

    public String getMgRankCd() {
        return mgRankCd;
    }

    public void setMgRankCd(String mgRankCd) {
        this.mgRankCd = mgRankCd;
    }

    public String getPgRankCd() {
        return pgRankCd;
    }

    public void setPgRankCd(String pgRankCd) {
        this.pgRankCd = pgRankCd;
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
        hash += (tbInfEmployeePK != null ? tbInfEmployeePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbInfEmployee)) {
            return false;
        }
        TbInfEmployee other = (TbInfEmployee) object;
        if ((this.tbInfEmployeePK == null && other.tbInfEmployeePK != null) || (this.tbInfEmployeePK != null && !this.tbInfEmployeePK.equals(other.tbInfEmployeePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jp.ardito.bjc.models.TbInfEmployee[ tbInfEmployeePK=" + tbInfEmployeePK + " ]";
    }

}
