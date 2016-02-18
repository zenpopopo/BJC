/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.ardito.bjc.dto;

import java.util.Map;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author zempo
 */
public class CreateIssueDto {

    @Getter
    @Setter
    public String subject;

    @Getter
    @Setter
    private Integer priorityId;

    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    private String petitionCategoryId;

    @Getter
    @Setter
    private String amount;

    @Getter
    @Setter
    private String referenceUrl;

    @Getter
    @Setter
    private String authorizerId;

    @Getter
    @Setter
    private Map<String, String> CustomFields;
}
