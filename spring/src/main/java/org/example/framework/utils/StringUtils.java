package org.example.framework.utils;

/**
 * @Title: StringUtils
 * @Author Hannibal
 * @Package org.example.framework.utils
 * @Date 07/08/2023 20:53
 * @Description: TODO
 */
public class StringUtils {
    public static String getSetterMethodByFieldName(String fieldName) {
        StringBuilder sb = new StringBuilder("set");
        sb.append(Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1));
        return sb.toString();
    }

    private StringUtils() {

    }
}
