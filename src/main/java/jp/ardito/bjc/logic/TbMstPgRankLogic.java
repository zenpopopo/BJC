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
import jp.ardito.bjc.model.TbMstPgRank;

/**
 *
 * @author zempo
 */
@Named
@Dependent
public class TbMstPgRankLogic {

    /** EntityManager. */
    @Inject
    EntityManager em;

    /**
     *
     * プログラマランクコードに紐づくエンティティのリストを１件のみ取得します。
     *
     * @param pgRankCd プログラマランクコード
     * @return エンティティのリスト
     */
    public List<TbMstPgRank> selectPgRank(String pgRankCd) {

        if (em == null) {
            return null;
        }

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<TbMstPgRank> cq = cb.createQuery(TbMstPgRank.class);
        Root<TbMstPgRank> r = cq.from(TbMstPgRank.class);
        cq.select(r).where(cb.equal(r.get("pgRankCd"), pgRankCd));

        return em.createQuery(cq).getResultList();
    }

    /**
     *
     * プログラマランクを全件取得します。
     *
     * @return エンティティのリスト
     */
    public List<TbMstPgRank> selectAllPgRak() {

        if (em == null) {
            return null;
        }

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(TbMstPgRank.class);

        return em.createQuery(cq).getResultList();
    }

}
