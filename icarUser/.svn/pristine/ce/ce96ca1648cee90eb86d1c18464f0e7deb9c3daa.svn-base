package com.ybinsure.icar.user.util;

/**
 * 保监地区编码
 *
 * @author HANHT
 * @version 2018/6/27 19:47
 */
public final class AreaUtil {

    /**
     * 通过车牌，找到车牌所在地区的地址
     * 返回车牌的所在的地区单位 ，地区代码
     *
     * @return lic
     */
    public static String getAreaCode(String licenseNo) {
        if (licenseNo == null || licenseNo.length() != 7) {
            return null;
        }

        String areaCode = null;
        if (licenseNo.contains("京")) {
            areaCode = "10000";
        } else if (licenseNo.contains("沪")) {
            areaCode = "10001";
        } else if (licenseNo.contains("津")) {
            areaCode = "10003";
        } else if (licenseNo.contains("渝")) {
            areaCode = "10009";
        } else if (licenseNo.contains("皖")) {
            areaCode = "10010";
        } else if (licenseNo.contains("闽")) {
            areaCode = "10011";
        } else if (licenseNo.contains("甘")) {
            areaCode = "10012";
        } else if (licenseNo.contains("粤")) {
            areaCode = "10013";
        } else if (licenseNo.contains("桂")) {
            areaCode = "10014";
        } else if (licenseNo.contains("贵")) {
            areaCode = "10015";
        } else if (licenseNo.contains("琼")) {
            areaCode = "10016";
        } else if (licenseNo.contains("冀")) {
            areaCode = "10017";
        } else if (licenseNo.contains("豫")) {
            areaCode = "10018";
        } else if (licenseNo.contains("黑")) {
            areaCode = "10019";
        } else if (licenseNo.contains("鄂")) {
            areaCode = "10020";
        } else if (licenseNo.contains("湘")) {
            areaCode = "10021";
        } else if (licenseNo.contains("吉")) {
            areaCode = "10022";
        } else if (licenseNo.contains("苏")) {
            areaCode = "10023";
        } else if (licenseNo.contains("赣")) {
            areaCode = "10024";
        } else if (licenseNo.contains("辽")) {
            areaCode = "10025";
        } else if (licenseNo.contains("蒙")) {
            areaCode = "10026";
        } else if (licenseNo.contains("宁")) {
            areaCode = "10027";
        } else if (licenseNo.contains("青")) {
            areaCode = "10028";
        } else if (licenseNo.contains("鲁")) {
            areaCode = "10029";
        } else if (licenseNo.contains("晋")) {
            areaCode = "10030";
        } else if (licenseNo.contains("陕")) {
            areaCode = "10031";
        } else if (licenseNo.contains("川")) {
            areaCode = "10032";
        } else if (licenseNo.contains("藏")) {
            areaCode = "10033";
        } else if (licenseNo.contains("新")) {
            areaCode = "10034";
        } else if (licenseNo.contains("云")) {
            areaCode = "10035";
        } else if (licenseNo.contains("浙")) {
            areaCode = "10036";
        }

        return areaCode;
    }

    /**
     * 查询特殊地区编码
     */
    public static String getSpecialAreaCode(String licenseNo) {
        if (licenseNo == null || licenseNo.length() != 7) {

            return null;
        }

        String areaCode = null;
        //特殊地区的
        String temp = licenseNo.substring(0, 1);
        switch (temp) {
            case "粤":
                areaCode = "10002";
                break;
            case "辽":
                areaCode = "10006";
                break;
            case "鲁":
                areaCode = "10004";
                break;
            case "浙":
                areaCode = "10007";
                break;
            case "闽":
                areaCode = "10008";
                break;
            default:
        }

        return areaCode;
    }
}
