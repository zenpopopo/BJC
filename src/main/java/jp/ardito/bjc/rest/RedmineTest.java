/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.ardito.bjc.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.taskadapter.redmineapi.RedmineException;
import com.taskadapter.redmineapi.RedmineManager;
import com.taskadapter.redmineapi.RedmineManagerFactory;
import com.taskadapter.redmineapi.bean.Issue;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;
import jp.ardito.bjc.annotation.BjcLogger;
import jp.ardito.bjc.dto.RequestJson;
import jp.ardito.bjc.logic.DbAccessSampleLogic;
import jp.ardito.bjc.service.ShowAnyDataService;
import jp.ardito.bjc.util.JsonUtils;

/**
 *
 * @author zempo
 */
@Path("/redmineTest")
public class RedmineTest {

    private static final String REDMINE_HOST = "https://deadmine.herokuapp.com";
    private static final String API_ACCESS_KEY = "f79b6dfe4615bc53ef67a30a4349359464c4065e";
    private static final String PROJECT_KEY = "blankey-jet-city";
    private static final Integer QUERY_ID = null;

    @Inject
    private DbAccessSampleLogic ds;

    @Inject
    private ShowAnyDataService showAnyDataService;

    @POST
    @Path("/searchData")
    @Produces("application/json")
    @Consumes("application/json")
    @BjcLogger
    public String searchData (String data) {

        ObjectMapper om = new ObjectMapper();
        RequestJson requestJson = new RequestJson();
        try {
            requestJson = om.readValue(data, RequestJson.class);
        } catch(Exception e) {
            System.out.println("ParseError");
        }

        System.out.println(requestJson);

        return JsonUtils.creatJson(
                showAnyDataService.getDataList(
                        requestJson.getBody().getFunctionKey(),
                        requestJson.getBody().getFunctionValue()
                )
        );
    }

    @POST
    @Path("/searchTicket")
    @Produces("application/json;charset=UTF-8")
    @Consumes("application/json;charset=UTF-8")
    public String searchTicket(String data) {

        System.out.println(data);

        ObjectMapper om = new ObjectMapper();
        RequestJson requestJson = new RequestJson();

        try {
            requestJson = om.readValue(data, RequestJson.class);
        } catch(Exception e) {
            System.out.println("ParseError");
        }

        System.out.println("requestJson : " + requestJson.body.functionValue);

        Client client = ClientBuilder.newBuilder().build();

        StringBuilder builder = new StringBuilder();
        builder.append("https://deadmine.herokuapp.com/issues/");
        builder.append(requestJson.body.functionValue);
        builder.append(".json?key=f79b6dfe4615bc53ef67a30a4349359464c4065e");

        Response res =
                client
                .target(builder.toString())
                .request()
                .get();

        String str = "aaa";
        if (res.getStatus() == Response.Status.OK.getStatusCode()) {
            str = res.readEntity(String.class);
            System.out.println(JsonUtils.creatJsonFromString(str));
        }

        res.close();
        client.close();

        System.out.println(str);

        return str;
    }

    @POST
    @Path("/getIssues")
    @Produces("application/json;charset=UTF-8")
    @Consumes("application/json;charset=UTF-8")
    public String getIssues() {

        RedmineManager rm = RedmineManagerFactory.createWithApiKey(REDMINE_HOST, API_ACCESS_KEY);
        try {
            List<Issue> issues = rm.getIssueManager().getIssues(PROJECT_KEY, QUERY_ID);
            for (Issue issue : issues) {
                System.out.println(issue.toString());
            }
        } catch (RedmineException ex) {
            System.out.println("RedmineError");
            ex.printStackTrace();
        }
        return "aaa";
    }
}
