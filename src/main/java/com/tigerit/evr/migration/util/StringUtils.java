package com.tigerit.evr.migration.util;

/**
 * Created by raqib on 06/12/15.
 */
public class StringUtils {
    public static String strip(String str) {
        return str != null ? str.replaceAll(" +", " ").trim() : null;
    }
}
