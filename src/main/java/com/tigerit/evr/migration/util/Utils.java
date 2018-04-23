package com.tigerit.evr.migration.util;

import org.apache.commons.lang3.StringUtils;
import sun.swing.StringUIClientPropertyKey;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by raqib on 06/12/15.
 */
public class Utils {

    public static String SERVICE_USER = "admin";
    public static String SERVICE_PASS = "bHyjRfY/g1yzU/8VvWxeBS7Ajno=";

    public static final Map<String, Integer> VEHICLE_TYPE_MAP;
    public static final Map<Integer, String> VEHICLE_CLASS_MAP;

    static {
        VEHICLE_TYPE_MAP = new HashMap<>();
        VEHICLE_TYPE_MAP.put("A", 4);
        VEHICLE_TYPE_MAP.put("B", 2);
        VEHICLE_TYPE_MAP.put("C", 3);
        VEHICLE_TYPE_MAP.put("D", 3);
        VEHICLE_TYPE_MAP.put("E", 2);
        VEHICLE_TYPE_MAP.put("F", 2);
        VEHICLE_TYPE_MAP.put("G", 1);
        VEHICLE_TYPE_MAP.put("H", 1);
        VEHICLE_TYPE_MAP.put("I", 1);
        VEHICLE_TYPE_MAP.put("J", 2);
        VEHICLE_TYPE_MAP.put("K", 1);

        VEHICLE_CLASS_MAP = new HashMap<>();
        VEHICLE_CLASS_MAP.put(1, "TYPE 1");
        VEHICLE_CLASS_MAP.put(2, "TYPE 2");
        VEHICLE_CLASS_MAP.put(3, "TYPE 3");
        VEHICLE_CLASS_MAP.put(4, "TYPE 4");

    }
    public static String strip(String str) {
        return str != null ? str.replaceAll(" +", " ").trim() : null;
    }

    public static int getVehicleClass(String code) {
        return StringUtils.isNotEmpty(code.trim()) ? VEHICLE_TYPE_MAP.get(code) : null;
    }

    public static Timestamp currentTimestamp() {
        return new Timestamp(Calendar.getInstance().getTimeInMillis());
    }
}
