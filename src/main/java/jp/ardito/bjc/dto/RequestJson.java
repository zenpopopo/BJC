/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.ardito.bjc.dto;

import lombok.Getter;

/**
 *
 * @author zempo
 */
public class RequestJson {

    @Getter
    public RequestJsonHeader header;

    @Getter
    public RequestJsonBody body;

}
