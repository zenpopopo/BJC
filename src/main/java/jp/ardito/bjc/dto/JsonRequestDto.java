/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.ardito.bjc.dto;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author zempo
 */
public class JsonRequestDto extends BaseDto {

    @Getter
    @Setter
    private String key;

    @Getter
    @Setter
    private String value;

}
