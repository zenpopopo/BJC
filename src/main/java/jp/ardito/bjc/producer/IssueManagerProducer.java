/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.ardito.bjc.producer;

import com.taskadapter.redmineapi.IssueManager;
import com.taskadapter.redmineapi.RedmineManagerFactory;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;

/**
 *
 * @author zempo
 */
@SessionScoped
public class IssueManagerProducer implements Serializable{

    /** Redmineのホスト */
    private static final String REDMINE_HOST = "https://deadmine.herokuapp.com";

    // TODO アクセスキーはシステム利用固有にする？
    /** アクセスキー */
    private static final String API_ACCESS_KEY = "f79b6dfe4615bc53ef67a30a4349359464c4065e";

    @Produces
    public IssueManager newIssueManager() {
        return RedmineManagerFactory.createWithApiKey(
                REDMINE_HOST, API_ACCESS_KEY).getIssueManager();
    }
}
