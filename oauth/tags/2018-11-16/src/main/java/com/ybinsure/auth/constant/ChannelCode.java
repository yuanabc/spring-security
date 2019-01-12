package com.ybinsure.auth.constant;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

public interface ChannelCode {

    String YUEBAO = "yuebao-001";
    String YUEBAO_MANAGER = "yuebao-002";
    String YUEBAO_SERVER = "yuebao-003";
    String YI_AN = "122"; // 东方懿安
    String SHI_YOU = "123"; // 中石油
    String DA_TONG = "001"; // 大童
    String EMPTY = "empty";

    static List<String> managerChannels = Arrays.asList(
            YUEBAO_MANAGER,
            YUEBAO_SERVER
    );

    static boolean isRootAdminChannel(String channelCode) {
        return StringUtils.equals(channelCode, YUEBAO);
    }

    static boolean isManagerAdminChannel(String channelCode) {
         return managerChannels.contains(channelCode);
    }

    static boolean isAnyAdminChannel(String channelCode) {
        return isRootAdminChannel(channelCode) || isManagerAdminChannel(channelCode);
    }

}
