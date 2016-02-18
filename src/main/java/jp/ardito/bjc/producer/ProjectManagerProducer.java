/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.ardito.bjc.producer;

import com.taskadapter.redmineapi.ProjectManager;
import com.taskadapter.redmineapi.RedmineManager;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

/**
 *
 * @author zempo
 */
@SessionScoped
public class ProjectManagerProducer implements Serializable{

    // TODO 操作するプロジェクトは用途によって分けられるように。
    /** プロジェクトキー */
    private static final String PROJECT_KEY = "ardito_order";

    @Inject
    protected RedmineManager redmineManager;

    @Produces
    public ProjectManager newProjectManager() {
        return redmineManager.getProjectManager();
    }
}
