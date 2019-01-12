package com.ybinsure.auth.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * 缓存的key
 */
public interface CacheKey {

    // time
    long HALF_DAY = 60 * 60 *12L;

    // 缓存key值
    String propertyTypeQueryAll = "auth_server_property_type_query-qll";
    String propertyQueryByType = "auth_server_property_query_by_type";
    String companyQueryAllWithTree = "auth_server_company_query_all_with_tree_v2";
    String companyQueryCompanyTree = "auth_server_company_query_company_tree_v2";
    String districtQueryProvince = "auth_server_district_query_province";
    String channelQueryAll = "auth_server_channel_query_all_V2";
    String policyAreaQueryAll = "auth_server_policy_area_query_all";
    String districtWithProvinceAndCity = "auth_server_district_query_with_province_and_city";
    String districtQueryTreeWithProvinceAndCity = "auth_server_district_query_tree_with_province_and_city";
    String defaultEmptyPassword = "auth_server_default_empty_password:";
    String verificationCode = "auth_server_verification_code:";
    String verificationCodeCD = "auth_server_verification_code_cd:";
    String timeSequence = "auth_server_time_sequence:";

    // 特定缓存时间
    static Map<String, Long> getSpecialExpires() {
        Map<String, Long> specialExpires = new HashMap<>();
        specialExpires.put(propertyTypeQueryAll, HALF_DAY * 2);
        specialExpires.put(propertyQueryByType, HALF_DAY * 2);
        specialExpires.put(companyQueryAllWithTree, HALF_DAY * 2);
        specialExpires.put(companyQueryCompanyTree, HALF_DAY * 2);
        specialExpires.put(districtQueryProvince, HALF_DAY * 2);
        specialExpires.put(channelQueryAll, HALF_DAY * 2);
        specialExpires.put(policyAreaQueryAll, HALF_DAY * 2);
        specialExpires.put(districtWithProvinceAndCity, HALF_DAY * 2);
        specialExpires.put(districtQueryTreeWithProvinceAndCity, HALF_DAY * 2);
        return specialExpires;
    }

}
