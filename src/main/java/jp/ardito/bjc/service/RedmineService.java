package jp.ardito.bjc.service;

import com.taskadapter.redmineapi.IssueManager;
import com.taskadapter.redmineapi.RedmineException;
import com.taskadapter.redmineapi.RedmineManager;
import com.taskadapter.redmineapi.bean.CustomField;
import com.taskadapter.redmineapi.bean.CustomFieldFactory;
import com.taskadapter.redmineapi.bean.Issue;
import com.taskadapter.redmineapi.bean.IssueFactory;
import com.taskadapter.redmineapi.bean.TrackerFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import jp.ardito.bjc.Constants;
import jp.ardito.bjc.dto.CreateIssueDto;
import jp.ardito.bjc.dto.SearchIssueDto;
import jp.ardito.bjc.util.JsonUtils;

/**
 *
 * Redmine連携クラス。
 *
 * @author zempo
 */
@Named
@Dependent
public class RedmineService {

    /** Redmineのホスト */
    private static final String REDMINE_HOST = "https://deadmine.herokuapp.com";

    // TODO アクセスキーはシステム利用固有にする？
    /** アクセスキー */
    private static final String API_ACCESS_KEY = "f79b6dfe4615bc53ef67a30a4349359464c4065e";

    // TODO 操作するプロジェクトは用途によって分けられるように。
    /** プロジェクトキー */
    private static final String PROJECT_KEY = "ardito_order";

    /** クエリID */
    private static final Integer QUERY_ID = null;

    /** 申請カテゴリ。 */
    private static final String PETITION_CATEGORY = "petitionCategory";

    /** 金額。 */
    private static final String AMOUNT = "amount";

    /** 参考URL。 */
    private static final String REFERENCE_URL = "referenceUrl";

    /** 承認者。 */
    private static final String AUTHORIZER = "authorizer";

    /** トラッカーID-申請 */
    private static final Integer TRACKER_ID_PETITON = 3;

//    @Inject
//    protected RedmineManager redmineManager;
//
//    @Inject
//    protected ProjectManager projectManager;

    @Inject
    protected IssueManager issueManager;

    /**
     *
     * Issueを全件検索します。
     *
     * @return
     * @throws RedmineException
     */
    public List<SearchIssueDto> getIssues() throws RedmineException{

        List<Issue> issues = new ArrayList<>();

        issues = issueManager.getIssues(PROJECT_KEY, QUERY_ID);

        List<SearchIssueDto> issueDtoList = new ArrayList<>();
        for (Issue issue : issues) {
            SearchIssueDto searchIssueDto = new SearchIssueDto();
            searchIssueDto.setId(issue.getId());
            searchIssueDto.setSubject(issue.getSubject());
            searchIssueDto.setPriority(issue.getPriorityId());
            searchIssueDto.setPetitionCategory(
                    issue.getCustomFieldById(
                            Constants.CustomFields.PETITION_CATEGORY.getid()).getName());
            searchIssueDto.setAmount(
                    issue.getCustomFieldById(
                            Constants.CustomFields.AMOUNT.getid()).getValue());
            searchIssueDto.setAuthorizer(
                    issue.getCustomFieldById(
                            Constants.CustomFields.AUTHORIZER.getid()).getValue());
            searchIssueDto.setCreateDate(issue.getCreatedOn());
            searchIssueDto.setUpdateDate(issue.getUpdatedOn());

            issueDtoList.add(searchIssueDto);
        }

        return issueDtoList;
    }

    /**
     *
     * Issueを1件だけ検索します。
     *
     * @param id
     * @return
     * @throws RedmineException
     */
    public SearchIssueDto getIssue(Integer id) throws RedmineException{

        Issue issue = issueManager.getIssueById(id);

        SearchIssueDto searchIssueDto = new SearchIssueDto();
        searchIssueDto.setId(issue.getId());
        searchIssueDto.setSubject(issue.getSubject());
        searchIssueDto.setPriority(issue.getPriorityId());
        searchIssueDto.setPetitionCategory(
                issue.getCustomFieldById(
                        Constants.CustomFields.PETITION_CATEGORY.getid()).getName());
        searchIssueDto.setAmount(
                issue.getCustomFieldById(
                        Constants.CustomFields.AMOUNT.getid()).getValue());
        searchIssueDto.setAuthorizer(
                issue.getCustomFieldById(
                        Constants.CustomFields.AUTHORIZER.getid()).getValue());
        searchIssueDto.setCreateDate(issue.getCreatedOn());
        searchIssueDto.setUpdateDate(issue.getUpdatedOn());

        return searchIssueDto;
    }

    /**
     *
     * @param id
     * @param params
     * @return
     */
    public String updateApproval(Integer id) throws RedmineException{

        Issue currentIssue = issueManager.getIssueById(id);
        currentIssue.setStatusId(Constants.PetitionStatus.APPROVAL.getId());
        issueManager.update(currentIssue);

        List<Issue> list = new ArrayList<>();
        list.add(issueManager.getIssueById(id));

        return JsonUtils.creatJsonFromList(list);
    }

    /**
     *
     * @param id
     * @return
     */
    public String updateDissmissal(Integer id) throws RedmineException{

        Issue currentIssue = issueManager.getIssueById(id);
        currentIssue.setStatusId(Constants.PetitionStatus.DISSMISSAL.getId());
        issueManager.update(currentIssue);

        List<Issue> list = new ArrayList<>();
        list.add(issueManager.getIssueById(id));

        return JsonUtils.creatJsonFromList(list);
    }

    /**
     *
     * @param id
     * @return
     */
    public String updateReview(Integer id) throws RedmineException{

        Issue currentIssue = issueManager.getIssueById(id);
        currentIssue.setStatusId(Constants.PetitionStatus.REVIEW.getId());
        issueManager.update(currentIssue);

        List<Issue> list = new ArrayList<>();
        list.add(issueManager.getIssueById(id));

        return JsonUtils.creatJsonFromList(list);
    }

    public String updateParameter(Integer id, Map<String, Object> paramMap) throws RedmineException{

        return null;
    }



    /**
     *
     * Issueを新規作成します。
     *
     * @param dto
     * @throws RedmineException
     */
    public Issue createIssue(CreateIssueDto dto) {

//        Issue issue = createIssueTemplate(redmineManager);
        Issue newIssue = getNewIssue(null);

//        try {
//            newIssue = issueManager.createIssue(getIssue(issue, dto));
//        } catch (RedmineException re) {
//            System.out.println("redmine error");
//        }

        return newIssue;
    }

    private Issue createIssueTemplate(RedmineManager redmineManager) {

        Issue issue = getNewIssue(null);
//        try {
//            issue.setProject(projectManager.getProjectByKey(PROJECT_KEY));
//        } catch(RedmineException re) {
//            System.out.println("redmine error");
//        }
        return issue;
    }

    private Issue getNewIssue(Integer id) {
        if (id == null) {
            return IssueFactory.create(null);
        }
        return IssueFactory.create(id);
    }

    private Issue getIssue(Issue issue, CreateIssueDto dto) {

        Map<String, String> map = new HashMap<>();
        map.put(PETITION_CATEGORY, dto.getPetitionCategoryId());
        map.put(AMOUNT, dto.getAmount());
        map.put(REFERENCE_URL, dto.getReferenceUrl());
        map.put(AUTHORIZER, dto.getAuthorizerId());
        dto.setCustomFields(map);

        issue.setTracker(TrackerFactory.create(TRACKER_ID_PETITON, null));
        issue.setSubject(dto.getSubject());
        issue.setPriorityId(dto.getPriorityId());
        issue.setDescription(dto.getDescription());
        issue.addCustomFields(getCustomFieldCollection(dto.getCustomFields()));

        return issue;
    }

    /**
     *
     * CustomFieldのCollectionを返却します。
     *
     * @param customParams
     * @return
     */
    private Collection<CustomField> getCustomFieldCollection (Map<String, String> customParams) {

        Map<String, Integer> customFieldsNameMap = new HashMap<>();
        customFieldsNameMap.put(PETITION_CATEGORY, Constants.CustomFields.PETITION_CATEGORY.getid());
        customFieldsNameMap.put(AMOUNT, Constants.CustomFields.AMOUNT.getid());
        customFieldsNameMap.put(REFERENCE_URL, Constants.CustomFields.REFERENCE_URL.getid());
        customFieldsNameMap.put(AUTHORIZER, Constants.CustomFields.AUTHORIZER.getid());

        List<CustomField> list = new ArrayList<>();
        for (Entry<String, Integer> e : customFieldsNameMap.entrySet()) {
            list.add(CustomFieldFactory.create(
                            e.getValue(),
                            null,
                            customParams.get(e.getKey())));
        }

        return (Collection)list;
    }
}
