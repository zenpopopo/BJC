package jp.ardito.bjc.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.jdbc.StringUtils;
import com.taskadapter.redmineapi.RedmineException;
import com.taskadapter.redmineapi.bean.Issue;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import jp.ardito.bjc.Constants;
import jp.ardito.bjc.dto.CreateIssueDto;
import jp.ardito.bjc.dto.SearchIssueDto;
import jp.ardito.bjc.service.RedmineService;
import jp.ardito.bjc.util.JsonUtils;

/**
 *
 * @author zempo
 */
@Path("/issues")
public class IssueResource {

    @Inject
    RedmineService redmineService;

    /**
     *
     * 全件取得。
     *
     * @return Httpレスポンス
     */
    @GET
    @Produces("application/json;charset=UTF-8")
    public Response searchIssues() {

        String response = null;
        try {
            response = JsonUtils.creatJsonFromList(redmineService.getIssues());
        } catch (RedmineException re) {
            // TODO Issueを取得できない以外の例外を精査する必要あり。
            Response.status(Response.Status.NO_CONTENT).entity("No Data.").build();
        }

        if (StringUtils.isNullOrEmpty(response)) {
            Response.status(Response.Status.NO_CONTENT).entity("No Data.").build();
        }

        return Response.status(Response.Status.OK).entity(response).build();
    }

    /**
     * 詳細取得。
     *
     * @param id チケットID
     * @return Httpレスポンス
     */
    @GET
    @Path("/{id}")
    @Produces("application/json;charset=UTF-8")
    public Response searchIssue(@PathParam("id") Integer id) {

        if (id == null) {
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Parameter is null")
                    .build();
        }

        List<SearchIssueDto> list = new ArrayList<>();
        try {
            list.add(redmineService.getIssue(id));
        } catch (RedmineException re) {
            return Response.status(Response.Status.NO_CONTENT).entity("No Data.").build();
        }
        String response = JsonUtils.creatJsonFromList(list);

        return Response.status(Response.Status.OK).entity(response).build();
    }

    /**
     * 更新。
     *
     * @param id ID
     * @param json Json形式のリクエストパラメータ
     * @return Httpレスポンス
     */
    @PUT
    @Path("/{id}/statuses")
    @Produces("application/json;charset=UTF-8")
    @Consumes("application/json;charset=UTF-8")
    public Response updateIssueStatus(@PathParam ("id") Integer id, String json) {

        ObjectMapper om = new ObjectMapper();
        Map<String, Object> reqMap = new HashMap<>();
        try {
            reqMap = om.readValue(json, HashMap.class);
        } catch (IOException ex) {
            System.out.println("parase error");
        }

        String response = null;
        try {
            if (Constants.PetitionStatus.APPROVAL.getId().equals(reqMap.get("updateKnd"))) {
                response = approbal(id);
            } else if (Constants.PetitionStatus.DISSMISSAL.getId().equals(reqMap.get("updateKnd"))) {
                response = dissmissal(id);
            } else if (Constants.PetitionStatus.REVIEW.getId().equals(reqMap.get("updateKnd"))) {
                response = review(id);
            } else {
                return Response.status(Response.Status.BAD_REQUEST).entity("aho").build();
            }
        } catch (RedmineException ex) {
            System.out.println(ex.getMessage());
            Response.status(Response.Status.NO_CONTENT).entity("No Data.").build();
        }

        return Response.status(Response.Status.OK).entity(response).build();
    }

    /**
     *
     * 承認。
     *
     * @param id
     * @return
     * @throws RedmineException
     */
    private String approbal(Integer id)  throws RedmineException{

        return redmineService.updateApproval(id);
    }

    /**
     *
     * 否認。
     *
     * @param id
     * @return
     * @throws RedmineException
     */
    private String dissmissal(Integer id)  throws RedmineException{

        return redmineService.updateDissmissal(id);
    }

    /**
     *
     * 検討中。
     *
     * @param id
     * @return
     * @throws RedmineException
     */
    private String review(Integer id)  throws RedmineException{

        return redmineService.updateReview(id);
    }

    /**
     * 更新。
     *
     * @param id ID
     * @param String json
     * @return Httpレスポンス
     */
    @PUT
    @Path("/{id}/parameters")
    @Produces("application/json;charset=UTF-8")
    @Consumes("application/json;charset=UTF-8")
    private Response updateIssueParameter(@PathParam ("id") Integer id, String json){

        ObjectMapper om = new ObjectMapper();
        Map<String, Object> paramMap = new HashMap<>();
        try {
            paramMap = om.readValue(json, HashMap.class);
        } catch (IOException ex) {
            System.out.println("parase error");
        }

        List<SearchIssueDto> list = new ArrayList<>();
        String response = null;
        try {
            response = redmineService.updateParameter(id, paramMap);
        } catch(RedmineException re) {
            System.out.println(re.getMessage());
            Response.status(Response.Status.NO_CONTENT).entity("No Data.").build();
        }

        return Response.status(Response.Status.OK).entity(response).build();
    }

    /**
     * 画像アップロード。
     */
    @PUT
    @Path("/{id}/image")
    @Produces("application/json;charset=UTF-8")
    @Consumes("application/json;charset=UTF-8")
    public String updateImage(@PathParam("id") Integer id, File image) {

        String response = null;

        return response;
    }

    /**
     * ファイルアップロード。
     */
    @PUT
    @Path("/{id}/file")
    @Produces("application/json;charset=UTF-8")
    @Consumes("application/json;charset=UTF-8")
    public String uploadFile(@PathParam("id") Integer id, File file) {

        String response = null;

        return response;
    }

    /**
     * ファイルダウンロード。
     */
    @GET
    @Path("/{id}/file")
    @Produces("application/json;charset=UTF-8")
    @Consumes("application/json;charset=UTF-8")
    public String downloadFile(@PathParam("id") Integer id) {

        String response = null;

        return response;
    }

    /**
     * 作成。
     */
    @POST
    @Produces("application/json;charset=UTF-8")
    @Consumes("application/json;charset=UTF-8")
    public String createIssue(String reqJson) {

        ObjectMapper om = new ObjectMapper();
        CreateIssueDto dto = new CreateIssueDto();
        try {
            dto = om.readValue(reqJson,  CreateIssueDto.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("json parse error");
        }

        Issue newIssue = null;
        newIssue = redmineService.createIssue(dto);

        return newIssue.getId().toString();
    }
}
