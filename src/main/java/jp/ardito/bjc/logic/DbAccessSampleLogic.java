package jp.ardito.bjc.logic;

import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import jp.ardito.bjc.model.TbMstDepartment;
import jp.ardito.bjc.model.TbMstMgRank;
import jp.ardito.bjc.model.TbMstPgRank;

@Named
@Dependent
public class DbAccessSampleLogic {

    @Inject
    EntityManager em;

    public List<TbMstPgRank> getPgRank() {

        List<TbMstPgRank> list = new ArrayList<>();
        if (em != null) {
                list = em.createNativeQuery("SELECT * FROM tb_mst_pg_rank", TbMstPgRank.class).getResultList();
        }
        return list;
    }

    public List<TbMstMgRank> getMgRank() {

        List<TbMstMgRank> list = new ArrayList<>();
        if (em != null) {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<TbMstMgRank> cq = cb.createQuery(TbMstMgRank.class);
            Root<TbMstMgRank> r = cq.from(TbMstMgRank.class);

            cq.select(r);
            list = em.createQuery(cq).getResultList();
        }
        return list;
    }

    public List<TbMstDepartment> getDepartments() {

        List<TbMstDepartment> list = new ArrayList<>();
        if (em != null) {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<TbMstDepartment> cq = cb.createQuery(TbMstDepartment.class);
            Root<TbMstDepartment> r = cq.from(TbMstDepartment.class);

            cq.select(r);
            list = em.createQuery(cq).getResultList();
        }
        return list;
    }

    public List<TbMstPgRank> getPgRank(String pgRankCd) {

        if (em != null) {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<TbMstPgRank> cq = cb.createQuery(TbMstPgRank.class);
            Root<TbMstPgRank> r = cq.from(TbMstPgRank.class);
            cq.select(r).where(cb.equal(r.get("pgRankCd"), pgRankCd));

            return em.createQuery(cq).getResultList();
        }
        return null;
    }

    public List<TbMstMgRank> getMgRank(String mgRankCd) {

        if (em != null) {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<TbMstMgRank> cq = cb.createQuery(TbMstMgRank.class);
            Root<TbMstMgRank> r = cq.from(TbMstMgRank.class);
            cq.select(r).where(cb.equal(r.get("mgRankCd"), mgRankCd));

            return em.createQuery(cq).getResultList();
        }
        return null;
    }

    public List<TbMstPgRank> getPgRankList() {

        List<TbMstPgRank> list = new ArrayList<>();

        if (em != null) {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<TbMstPgRank> cq = cb.createQuery(TbMstPgRank.class);
            Root<TbMstPgRank> r = cq.from(TbMstPgRank.class);
            cq.select(r);
            list = em.createQuery(cq).getResultList();
        }

        return list;
    }
}
