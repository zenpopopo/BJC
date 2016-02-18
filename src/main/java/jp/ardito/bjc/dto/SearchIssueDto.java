package jp.ardito.bjc.dto;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author zempo
 */
public class SearchIssueDto {

    @Getter
    @Setter
    private Integer id;

    @Getter
    @Setter
    private String subject;

    @Getter
    @Setter
    private Integer priority;

    @Getter
    @Setter
    private String petitionCategory;

    @Getter
    @Setter
    private String amount;

    @Getter
    @Setter
    private String authorizer;

    @Getter
    @Setter
    private Date createDate;

    @Getter
    @Setter
    private Date updateDate;


}
