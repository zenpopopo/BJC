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
@Table(name = "tb_mst_pg_rank")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbMstPgRank.findAll", query = "SELECT t FROM TbMstPgRank t"),
    @NamedQuery(name = "TbMstPgRank.findByPgRankCd", query = "SELECT t FROM TbMstPgRank t WHERE t.pgRankCd = :pgRankCd"),
    @NamedQuery(name = "TbMstPgRank.findByPgRankNm", query = "SELECT t FROM TbMstPgRank t WHERE t.pgRankNm = :pgRankNm"),
    @NamedQuery(name = "TbMstPgRank.findByUpdateDate", query = "SELECT t FROM TbMstPgRank t WHERE t.updateDate = :updateDate"),
    @NamedQuery(name = "TbMstPgRank.findByUpdateUser", query = "SELECT t FROM TbMstPgRank t WHERE t.updateUser = :updateUser"),
    @NamedQuery(name = "TbMstPgRank.findByCreateDate", query = "SELECT t FROM TbMstPgRank t WHERE t.createDate = :createDate"),
    @NamedQuery(name = "TbMstPgRank.findByCreateUser", query = "SELECT t FROM TbMstPgRank t WHERE t.createUser = :createUser"),
    @NamedQuery(name = "TbMstPgRank.findByDelFlg", query = "SELECT t FROM TbMstPgRank t WHERE t.delFlg = :delFlg")})
public class TbMstPgRank implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "PG_RANK_CD")
    private String pgRankCd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PG_RANK_NM")
    private String pgRankNm;
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

    public TbMstPgRank() {
    }

    public TbMstPgRank(String pgRankCd) {
        this.pgRankCd = pgRankCd;
    }

    public TbMstPgRank(String pgRankCd, String pgRankNm, Date updateDate, Date createDate, String createUser, String delFlg) {
        this.pgRankCd = pgRankCd;
        this.pgRankNm = pgRankNm;
        this.updateDate = updateDate;
        this.createDate = createDate;
        this.createUser = createUser;
        this.delFlg = delFlg;
    }

    public String getPgRankCd() {
        return pgRankCd;
    }

    public void setPgRankCd(String pgRankCd) {
        this.pgRankCd = pgRankCd;
    }

    public String getPgRankNm() {
        return pgRankNm;
    }

    public void setPgRankNm(String pgRankNm) {
        this.pgRankNm = pgRankNm;
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
        hash += (pgRankCd != null ? pgRankCd.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbMstPgRank)) {
            return false;
        }
        TbMstPgRank other = (TbMstPgRank) object;
        if ((this.pgRankCd == null && other.pgRankCd != null) || (this.pgRankCd != null && !this.pgRankCd.equals(other.pgRankCd))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jp.ardito.bjc.models.TbMstPgRank[ pgRankCd=" + pgRankCd + " ]";
    }

}
