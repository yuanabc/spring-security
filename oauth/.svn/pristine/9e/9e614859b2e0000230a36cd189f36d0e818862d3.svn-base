package com.ybinsure.auth.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * 缓存的key
 */
public class CacheKey {

    // time
    public static final long HALF_DAY = 60 * 60 *12L;

    // 缓存key值
    public static final String propertyTypeQueryAll = "authPropertyTypeQueryAll";
    public static final String propertyQueryByType = "authPropertyQueryByType";
    public static final String companyQueryAllWithTree = "authCompanyQueryAllWithTree";
    public static final String companyQueryCompanyTree = "authCompanyQueryCompanyTree";
    public static final String districtQueryProvince = "authDistrictQueryProvince";
    public static final String channelQueryAll = "authChannelQueryAll";
    public static final String policyAreaQueryAll = "authPolicyAreaQueryAll";
    public static final String districtWithProvinceAndCity = "authDistrictQueryWithProvinceAndCity";
    public static final String districtQueryTreeWithProvinceAndCity = "authDistrictQueryTreeWithProvinceAndCity";

    // 特定缓存时间
    public static Map<String, Long> getSpecialExpires() {
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
