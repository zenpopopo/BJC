/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.ardito.bjc.service;

import java.util.List;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import jp.ardito.bjc.logic.TbMstMgRankLogic;
import jp.ardito.bjc.logic.TbMstPgRankLogic;

/**
 *
 * @author zempo
 */
@Named
@Dependent
public class ShowAnyDataService {

    @Inject
    TbMstPgRankLogic tbMstPgRankLogic;

    @Inject
    TbMstMgRankLogic tbMstMgRankLogic;

    public List<?> getDataList(String key, String value) {

        if (!key.isEmpty()) {
            switch (key) {
                case "pgRankCd" :
                    return tbMstPgRankLogic.selectPgRank(value);
                case "mgRankCd" :
                    return tbMstMgRankLogic.selectMgRank(value);
                default :
                    break;
            }
        }
        return null;
    }
}
