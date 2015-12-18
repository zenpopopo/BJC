/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.ardito.bjc.logic;

import java.util.List;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import jp.ardito.bjc.model.TbMstMgRank;

/**
 *
 * @author zempo
 */
@Named
@Dependent
public class TbMstMgRankLogic {

    @Inject
    EntityManager em;

    public List<TbMstMgRank> selectMgRank(String mgRankCd) {

        if (em == null) {
            return null;
        }

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(TbMstMgRank.class);
        Root<TbMstMgRank> r = cq.from(TbMstMgRank.class);
        cq.select(r).where(cb.equal(r.get("mgRankCd"), mgRankCd));

        return em.createQuery(cq).getResultList();
    }

    public List<TbMstMgRank> selectAllMgRank() {

        if (em == null) {
            return null;
        }

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(TbMstMgRank.class);

        return em.createQuery(cq).getResultList();
    }

}
