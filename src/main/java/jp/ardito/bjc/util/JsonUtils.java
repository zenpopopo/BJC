/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.ardito.bjc.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;

/**
 *
 * @author zempo
 */
public class JsonUtils {

    private JsonUtils() {
        // 繧､繝ｳ繧ｹ繧ｿ繝ｳ繧ｹ蛹也ｦ∵ｭ｢
    }

    /**
     * JSON形式の文字列をパースします。
     *
     * @return
     */
    public static Object parse() {

        return null;
    }


    public static String creatJsonFromString(String str) {

        ObjectMapper om = new ObjectMapper();
        String jsonString = null;

        try {
            jsonString = om.writeValueAsString(str);
            return om.readTree(jsonString).toString();
        } catch(Exception e) {
            System.out.println("creatJsonError");
        }

        return null;
    }

    /**
     * ListをJSON形式にします。
     *
     * @param list
     * @return
     */
    public static String creatJson(List<?> list) {

        ObjectMapper om = new ObjectMapper();

        if (list == null) {
            return null;
        }

        try {
            return om.writeValueAsString(list.get(0));
        } catch(Exception e) {
            System.out.println("creatJsonError");
        }

        return null;
    }

}
