package com.laoxu.util;

/**
 * 
 * @author：Dylan
 * @date：2018年12月23日
 * @description：
 */
public class StringUtil {
    public static boolean isEmpty(String str) {
        if ("".equals(str) || str == null) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isNotEmpty(String str) {
        if (!"".equals(str) && str != null) {
            return true;
        } else {
            return false;
        }
    }

    public static String nullString(Object object){
        if(object==null){
            return "";
        }else {
            return object.toString();
        }
    }
}
