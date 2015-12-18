/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.ardito.bjc.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import jp.ardito.bjc.annotation.BjcLogger;
import jp.ardito.bjc.dto.RequestJson;
import jp.ardito.bjc.logic.DbAccessSampleLogic;
import jp.ardito.bjc.model.TbMstDepartment;
import jp.ardito.bjc.model.TbMstMgRank;
import jp.ardito.bjc.model.TbMstPgRank;
import jp.ardito.bjc.service.ShowAnyDataService;
import jp.ardito.bjc.util.JsonUtils;

/**
 *
 * @author zempo
 */
@Path("/sample")
public class Sample {

    @Inject
    private DbAccessSampleLogic ds;

    @Inject
    private ShowAnyDataService showAnyDataService;

    @GET
    @Path("/resA")
    @Produces("text/plain")
    public String getResA() {

        String message = "aaa";
        List<TbMstPgRank> list = ds.getPgRank();

        if (list.size() > 0) {
            message = list.get(1).getPgRankNm();
        }

        return message;
    }

    @GET
    @Path("/resB/{name}")
    @Produces("text/plain")
    public String getResB(@PathParam("name") String name) {

        StringBuffer message = new StringBuffer();
        List<TbMstMgRank> list = ds.getMgRank();
        if (!list.isEmpty()) {
            for (TbMstMgRank tbMstMgRank : list) {
                message.append(tbMstMgRank.getMgRankNm());
                message.append(" と ");
            }
            message.append(name);
            message.append("　だ");
        }
        return message.toString();
    }

    @GET
    @Path("/resC")
    @Produces("application/json")
    public String getResC(@QueryParam("q") String name) {

        JsonArrayBuilder jab = Json.createArrayBuilder();

        List<TbMstDepartment> list = ds.getDepartments();
        if (!list.isEmpty()) {
            for (TbMstDepartment tbMstDepartment : list) {
                jab.add(tbMstDepartment.getDepNm());
            }
        }

        JsonObject jo = Json.createObjectBuilder()
                .add(name, jab).build();

        return jo.toString();
    }

    @POST
    @Path("/resD")
    @Produces("text/plain")
    public String getResD(@FormParam("test") String test) {

        System.out.println(test);
        String message = test + "gagaga";

        return message;
    }

    @POST
    @Path("/resE")
    @Produces("text/plain")
    public String getResE(@FormParam("test") String test) {

        System.out.println(test);

        List<TbMstPgRank> tbMstPgRank = ds.getPgRank(test);

        String message = "init";
        if (tbMstPgRank != null) {
            message = tbMstPgRank.get(0).getPgRankNm();
        }

        return message;
    }


    @POST
    @Path("/resF")
    @Produces("application/json")
    @BjcLogger
    public String getResF() {

        List<TbMstPgRank> list = ds.getPgRankList();

        JsonObjectBuilder job = Json.createObjectBuilder();
        String message = "init";
        if (!list.isEmpty()) {
            for (TbMstPgRank tbMstPgRank : list) {
                job.add(tbMstPgRank.getPgRankNm(), Json.createArrayBuilder()
                        .add(tbMstPgRank.getPgRankCd())
                        .add(tbMstPgRank.getPgRankNm())
                        .add(tbMstPgRank.getCreateUser())
                        );

            }
            JsonObject jo = Json.createObjectBuilder()
                    .add("TbMstPgRank", job).build();
            message = jo.toString();
        }

        return message;
    }

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
}
