package com.ybinsure.icar.user.model.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class PolicyVehicleDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PolicyVehicleDOExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andPolicyIdIsNull() {
            addCriterion("policy_id is null");
            return (Criteria) this;
        }

        public Criteria andPolicyIdIsNotNull() {
            addCriterion("policy_id is not null");
            return (Criteria) this;
        }

        public Criteria andPolicyIdEqualTo(String value) {
            addCriterion("policy_id =", value, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdNotEqualTo(String value) {
            addCriterion("policy_id <>", value, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdGreaterThan(String value) {
            addCriterion("policy_id >", value, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdGreaterThanOrEqualTo(String value) {
            addCriterion("policy_id >=", value, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdLessThan(String value) {
            addCriterion("policy_id <", value, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdLessThanOrEqualTo(String value) {
            addCriterion("policy_id <=", value, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdLike(String value) {
            addCriterion("policy_id like", value, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdNotLike(String value) {
            addCriterion("policy_id not like", value, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdIn(List<String> values) {
            addCriterion("policy_id in", values, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdNotIn(List<String> values) {
            addCriterion("policy_id not in", values, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdBetween(String value1, String value2) {
            addCriterion("policy_id between", value1, value2, "policyId");
            return (Criteria) this;
        }

        public Criteria andPolicyIdNotBetween(String value1, String value2) {
            addCriterion("policy_id not between", value1, value2, "policyId");
            return (Criteria) this;
        }

        public Criteria andLicenseNoIsNull() {
            addCriterion("license_no is null");
            return (Criteria) this;
        }

        public Criteria andLicenseNoIsNotNull() {
            addCriterion("license_no is not null");
            return (Criteria) this;
        }

        public Criteria andLicenseNoEqualTo(String value) {
            addCriterion("license_no =", value, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoNotEqualTo(String value) {
            addCriterion("license_no <>", value, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoGreaterThan(String value) {
            addCriterion("license_no >", value, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoGreaterThanOrEqualTo(String value) {
            addCriterion("license_no >=", value, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoLessThan(String value) {
            addCriterion("license_no <", value, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoLessThanOrEqualTo(String value) {
            addCriterion("license_no <=", value, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoLike(String value) {
            addCriterion("license_no like", value, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoNotLike(String value) {
            addCriterion("license_no not like", value, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoIn(List<String> values) {
            addCriterion("license_no in", values, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoNotIn(List<String> values) {
            addCriterion("license_no not in", values, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoBetween(String value1, String value2) {
            addCriterion("license_no between", value1, value2, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoNotBetween(String value1, String value2) {
            addCriterion("license_no not between", value1, value2, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andBrandNameIsNull() {
            addCriterion("brand_name is null");
            return (Criteria) this;
        }

        public Criteria andBrandNameIsNotNull() {
            addCriterion("brand_name is not null");
            return (Criteria) this;
        }

        public Criteria andBrandNameEqualTo(String value) {
            addCriterion("brand_name =", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameNotEqualTo(String value) {
            addCriterion("brand_name <>", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameGreaterThan(String value) {
            addCriterion("brand_name >", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameGreaterThanOrEqualTo(String value) {
            addCriterion("brand_name >=", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameLessThan(String value) {
            addCriterion("brand_name <", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameLessThanOrEqualTo(String value) {
            addCriterion("brand_name <=", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameLike(String value) {
            addCriterion("brand_name like", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameNotLike(String value) {
            addCriterion("brand_name not like", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameIn(List<String> values) {
            addCriterion("brand_name in", values, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameNotIn(List<String> values) {
            addCriterion("brand_name not in", values, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameBetween(String value1, String value2) {
            addCriterion("brand_name between", value1, value2, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameNotBetween(String value1, String value2) {
            addCriterion("brand_name not between", value1, value2, "brandName");
            return (Criteria) this;
        }

        public Criteria andModelCodeIsNull() {
            addCriterion("model_code is null");
            return (Criteria) this;
        }

        public Criteria andModelCodeIsNotNull() {
            addCriterion("model_code is not null");
            return (Criteria) this;
        }

        public Criteria andModelCodeEqualTo(String value) {
            addCriterion("model_code =", value, "modelCode");
            return (Criteria) this;
        }

        public Criteria andModelCodeNotEqualTo(String value) {
            addCriterion("model_code <>", value, "modelCode");
            return (Criteria) this;
        }

        public Criteria andModelCodeGreaterThan(String value) {
            addCriterion("model_code >", value, "modelCode");
            return (Criteria) this;
        }

        public Criteria andModelCodeGreaterThanOrEqualTo(String value) {
            addCriterion("model_code >=", value, "modelCode");
            return (Criteria) this;
        }

        public Criteria andModelCodeLessThan(String value) {
            addCriterion("model_code <", value, "modelCode");
            return (Criteria) this;
        }

        public Criteria andModelCodeLessThanOrEqualTo(String value) {
            addCriterion("model_code <=", value, "modelCode");
            return (Criteria) this;
        }

        public Criteria andModelCodeLike(String value) {
            addCriterion("model_code like", value, "modelCode");
            return (Criteria) this;
        }

        public Criteria andModelCodeNotLike(String value) {
            addCriterion("model_code not like", value, "modelCode");
            return (Criteria) this;
        }

        public Criteria andModelCodeIn(List<String> values) {
            addCriterion("model_code in", values, "modelCode");
            return (Criteria) this;
        }

        public Criteria andModelCodeNotIn(List<String> values) {
            addCriterion("model_code not in", values, "modelCode");
            return (Criteria) this;
        }

        public Criteria andModelCodeBetween(String value1, String value2) {
            addCriterion("model_code between", value1, value2, "modelCode");
            return (Criteria) this;
        }

        public Criteria andModelCodeNotBetween(String value1, String value2) {
            addCriterion("model_code not between", value1, value2, "modelCode");
            return (Criteria) this;
        }

        public Criteria andFrameNoIsNull() {
            addCriterion("frame_no is null");
            return (Criteria) this;
        }

        public Criteria andFrameNoIsNotNull() {
            addCriterion("frame_no is not null");
            return (Criteria) this;
        }

        public Criteria andFrameNoEqualTo(String value) {
            addCriterion("frame_no =", value, "frameNo");
            return (Criteria) this;
        }

        public Criteria andFrameNoNotEqualTo(String value) {
            addCriterion("frame_no <>", value, "frameNo");
            return (Criteria) this;
        }

        public Criteria andFrameNoGreaterThan(String value) {
            addCriterion("frame_no >", value, "frameNo");
            return (Criteria) this;
        }

        public Criteria andFrameNoGreaterThanOrEqualTo(String value) {
            addCriterion("frame_no >=", value, "frameNo");
            return (Criteria) this;
        }

        public Criteria andFrameNoLessThan(String value) {
            addCriterion("frame_no <", value, "frameNo");
            return (Criteria) this;
        }

        public Criteria andFrameNoLessThanOrEqualTo(String value) {
            addCriterion("frame_no <=", value, "frameNo");
            return (Criteria) this;
        }

        public Criteria andFrameNoLike(String value) {
            addCriterion("frame_no like", value, "frameNo");
            return (Criteria) this;
        }

        public Criteria andFrameNoNotLike(String value) {
            addCriterion("frame_no not like", value, "frameNo");
            return (Criteria) this;
        }

        public Criteria andFrameNoIn(List<String> values) {
            addCriterion("frame_no in", values, "frameNo");
            return (Criteria) this;
        }

        public Criteria andFrameNoNotIn(List<String> values) {
            addCriterion("frame_no not in", values, "frameNo");
            return (Criteria) this;
        }

        public Criteria andFrameNoBetween(String value1, String value2) {
            addCriterion("frame_no between", value1, value2, "frameNo");
            return (Criteria) this;
        }

        public Criteria andFrameNoNotBetween(String value1, String value2) {
            addCriterion("frame_no not between", value1, value2, "frameNo");
            return (Criteria) this;
        }

        public Criteria andEngineNoIsNull() {
            addCriterion("engine_no is null");
            return (Criteria) this;
        }

        public Criteria andEngineNoIsNotNull() {
            addCriterion("engine_no is not null");
            return (Criteria) this;
        }

        public Criteria andEngineNoEqualTo(String value) {
            addCriterion("engine_no =", value, "engineNo");
            return (Criteria) this;
        }

        public Criteria andEngineNoNotEqualTo(String value) {
            addCriterion("engine_no <>", value, "engineNo");
            return (Criteria) this;
        }

        public Criteria andEngineNoGreaterThan(String value) {
            addCriterion("engine_no >", value, "engineNo");
            return (Criteria) this;
        }

        public Criteria andEngineNoGreaterThanOrEqualTo(String value) {
            addCriterion("engine_no >=", value, "engineNo");
            return (Criteria) this;
        }

        public Criteria andEngineNoLessThan(String value) {
            addCriterion("engine_no <", value, "engineNo");
            return (Criteria) this;
        }

        public Criteria andEngineNoLessThanOrEqualTo(String value) {
            addCriterion("engine_no <=", value, "engineNo");
            return (Criteria) this;
        }

        public Criteria andEngineNoLike(String value) {
            addCriterion("engine_no like", value, "engineNo");
            return (Criteria) this;
        }

        public Criteria andEngineNoNotLike(String value) {
            addCriterion("engine_no not like", value, "engineNo");
            return (Criteria) this;
        }

        public Criteria andEngineNoIn(List<String> values) {
            addCriterion("engine_no in", values, "engineNo");
            return (Criteria) this;
        }

        public Criteria andEngineNoNotIn(List<String> values) {
            addCriterion("engine_no not in", values, "engineNo");
            return (Criteria) this;
        }

        public Criteria andEngineNoBetween(String value1, String value2) {
            addCriterion("engine_no between", value1, value2, "engineNo");
            return (Criteria) this;
        }

        public Criteria andEngineNoNotBetween(String value1, String value2) {
            addCriterion("engine_no not between", value1, value2, "engineNo");
            return (Criteria) this;
        }

        public Criteria andEnrollDateIsNull() {
            addCriterion("enroll_date is null");
            return (Criteria) this;
        }

        public Criteria andEnrollDateIsNotNull() {
            addCriterion("enroll_date is not null");
            return (Criteria) this;
        }

        public Criteria andEnrollDateEqualTo(Date value) {
            addCriterionForJDBCDate("enroll_date =", value, "enrollDate");
            return (Criteria) this;
        }

        public Criteria andEnrollDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("enroll_date <>", value, "enrollDate");
            return (Criteria) this;
        }

        public Criteria andEnrollDateGreaterThan(Date value) {
            addCriterionForJDBCDate("enroll_date >", value, "enrollDate");
            return (Criteria) this;
        }

        public Criteria andEnrollDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("enroll_date >=", value, "enrollDate");
            return (Criteria) this;
        }

        public Criteria andEnrollDateLessThan(Date value) {
            addCriterionForJDBCDate("enroll_date <", value, "enrollDate");
            return (Criteria) this;
        }

        public Criteria andEnrollDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("enroll_date <=", value, "enrollDate");
            return (Criteria) this;
        }

        public Criteria andEnrollDateIn(List<Date> values) {
            addCriterionForJDBCDate("enroll_date in", values, "enrollDate");
            return (Criteria) this;
        }

        public Criteria andEnrollDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("enroll_date not in", values, "enrollDate");
            return (Criteria) this;
        }

        public Criteria andEnrollDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("enroll_date between", value1, value2, "enrollDate");
            return (Criteria) this;
        }

        public Criteria andEnrollDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("enroll_date not between", value1, value2, "enrollDate");
            return (Criteria) this;
        }

        public Criteria andIssueYearIsNull() {
            addCriterion("issue_year is null");
            return (Criteria) this;
        }

        public Criteria andIssueYearIsNotNull() {
            addCriterion("issue_year is not null");
            return (Criteria) this;
        }

        public Criteria andIssueYearEqualTo(String value) {
            addCriterion("issue_year =", value, "issueYear");
            return (Criteria) this;
        }

        public Criteria andIssueYearNotEqualTo(String value) {
            addCriterion("issue_year <>", value, "issueYear");
            return (Criteria) this;
        }

        public Criteria andIssueYearGreaterThan(String value) {
            addCriterion("issue_year >", value, "issueYear");
            return (Criteria) this;
        }

        public Criteria andIssueYearGreaterThanOrEqualTo(String value) {
            addCriterion("issue_year >=", value, "issueYear");
            return (Criteria) this;
        }

        public Criteria andIssueYearLessThan(String value) {
            addCriterion("issue_year <", value, "issueYear");
            return (Criteria) this;
        }

        public Criteria andIssueYearLessThanOrEqualTo(String value) {
            addCriterion("issue_year <=", value, "issueYear");
            return (Criteria) this;
        }

        public Criteria andIssueYearLike(String value) {
            addCriterion("issue_year like", value, "issueYear");
            return (Criteria) this;
        }

        public Criteria andIssueYearNotLike(String value) {
            addCriterion("issue_year not like", value, "issueYear");
            return (Criteria) this;
        }

        public Criteria andIssueYearIn(List<String> values) {
            addCriterion("issue_year in", values, "issueYear");
            return (Criteria) this;
        }

        public Criteria andIssueYearNotIn(List<String> values) {
            addCriterion("issue_year not in", values, "issueYear");
            return (Criteria) this;
        }

        public Criteria andIssueYearBetween(String value1, String value2) {
            addCriterion("issue_year between", value1, value2, "issueYear");
            return (Criteria) this;
        }

        public Criteria andIssueYearNotBetween(String value1, String value2) {
            addCriterion("issue_year not between", value1, value2, "issueYear");
            return (Criteria) this;
        }

        public Criteria andPurchasePriceIsNull() {
            addCriterion("purchase_price is null");
            return (Criteria) this;
        }

        public Criteria andPurchasePriceIsNotNull() {
            addCriterion("purchase_price is not null");
            return (Criteria) this;
        }

        public Criteria andPurchasePriceEqualTo(Integer value) {
            addCriterion("purchase_price =", value, "purchasePrice");
            return (Criteria) this;
        }

        public Criteria andPurchasePriceNotEqualTo(Integer value) {
            addCriterion("purchase_price <>", value, "purchasePrice");
            return (Criteria) this;
        }

        public Criteria andPurchasePriceGreaterThan(Integer value) {
            addCriterion("purchase_price >", value, "purchasePrice");
            return (Criteria) this;
        }

        public Criteria andPurchasePriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("purchase_price >=", value, "purchasePrice");
            return (Criteria) this;
        }

        public Criteria andPurchasePriceLessThan(Integer value) {
            addCriterion("purchase_price <", value, "purchasePrice");
            return (Criteria) this;
        }

        public Criteria andPurchasePriceLessThanOrEqualTo(Integer value) {
            addCriterion("purchase_price <=", value, "purchasePrice");
            return (Criteria) this;
        }

        public Criteria andPurchasePriceIn(List<Integer> values) {
            addCriterion("purchase_price in", values, "purchasePrice");
            return (Criteria) this;
        }

        public Criteria andPurchasePriceNotIn(List<Integer> values) {
            addCriterion("purchase_price not in", values, "purchasePrice");
            return (Criteria) this;
        }

        public Criteria andPurchasePriceBetween(Integer value1, Integer value2) {
            addCriterion("purchase_price between", value1, value2, "purchasePrice");
            return (Criteria) this;
        }

        public Criteria andPurchasePriceNotBetween(Integer value1, Integer value2) {
            addCriterion("purchase_price not between", value1, value2, "purchasePrice");
            return (Criteria) this;
        }

        public Criteria andActualPriceIsNull() {
            addCriterion("actual_price is null");
            return (Criteria) this;
        }

        public Criteria andActualPriceIsNotNull() {
            addCriterion("actual_price is not null");
            return (Criteria) this;
        }

        public Criteria andActualPriceEqualTo(Double value) {
            addCriterion("actual_price =", value, "actualPrice");
            return (Criteria) this;
        }

        public Criteria andActualPriceNotEqualTo(Double value) {
            addCriterion("actual_price <>", value, "actualPrice");
            return (Criteria) this;
        }

        public Criteria andActualPriceGreaterThan(Double value) {
            addCriterion("actual_price >", value, "actualPrice");
            return (Criteria) this;
        }

        public Criteria andActualPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("actual_price >=", value, "actualPrice");
            return (Criteria) this;
        }

        public Criteria andActualPriceLessThan(Double value) {
            addCriterion("actual_price <", value, "actualPrice");
            return (Criteria) this;
        }

        public Criteria andActualPriceLessThanOrEqualTo(Double value) {
            addCriterion("actual_price <=", value, "actualPrice");
            return (Criteria) this;
        }

        public Criteria andActualPriceIn(List<Double> values) {
            addCriterion("actual_price in", values, "actualPrice");
            return (Criteria) this;
        }

        public Criteria andActualPriceNotIn(List<Double> values) {
            addCriterion("actual_price not in", values, "actualPrice");
            return (Criteria) this;
        }

        public Criteria andActualPriceBetween(Double value1, Double value2) {
            addCriterion("actual_price between", value1, value2, "actualPrice");
            return (Criteria) this;
        }

        public Criteria andActualPriceNotBetween(Double value1, Double value2) {
            addCriterion("actual_price not between", value1, value2, "actualPrice");
            return (Criteria) this;
        }

        public Criteria andSeatCountIsNull() {
            addCriterion("seat_count is null");
            return (Criteria) this;
        }

        public Criteria andSeatCountIsNotNull() {
            addCriterion("seat_count is not null");
            return (Criteria) this;
        }

        public Criteria andSeatCountEqualTo(Byte value) {
            addCriterion("seat_count =", value, "seatCount");
            return (Criteria) this;
        }

        public Criteria andSeatCountNotEqualTo(Byte value) {
            addCriterion("seat_count <>", value, "seatCount");
            return (Criteria) this;
        }

        public Criteria andSeatCountGreaterThan(Byte value) {
            addCriterion("seat_count >", value, "seatCount");
            return (Criteria) this;
        }

        public Criteria andSeatCountGreaterThanOrEqualTo(Byte value) {
            addCriterion("seat_count >=", value, "seatCount");
            return (Criteria) this;
        }

        public Criteria andSeatCountLessThan(Byte value) {
            addCriterion("seat_count <", value, "seatCount");
            return (Criteria) this;
        }

        public Criteria andSeatCountLessThanOrEqualTo(Byte value) {
            addCriterion("seat_count <=", value, "seatCount");
            return (Criteria) this;
        }

        public Criteria andSeatCountIn(List<Byte> values) {
            addCriterion("seat_count in", values, "seatCount");
            return (Criteria) this;
        }

        public Criteria andSeatCountNotIn(List<Byte> values) {
            addCriterion("seat_count not in", values, "seatCount");
            return (Criteria) this;
        }

        public Criteria andSeatCountBetween(Byte value1, Byte value2) {
            addCriterion("seat_count between", value1, value2, "seatCount");
            return (Criteria) this;
        }

        public Criteria andSeatCountNotBetween(Byte value1, Byte value2) {
            addCriterion("seat_count not between", value1, value2, "seatCount");
            return (Criteria) this;
        }

        public Criteria andTransferDateIsNull() {
            addCriterion("transfer_date is null");
            return (Criteria) this;
        }

        public Criteria andTransferDateIsNotNull() {
            addCriterion("transfer_date is not null");
            return (Criteria) this;
        }

        public Criteria andTransferDateEqualTo(Date value) {
            addCriterionForJDBCDate("transfer_date =", value, "transferDate");
            return (Criteria) this;
        }

        public Criteria andTransferDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("transfer_date <>", value, "transferDate");
            return (Criteria) this;
        }

        public Criteria andTransferDateGreaterThan(Date value) {
            addCriterionForJDBCDate("transfer_date >", value, "transferDate");
            return (Criteria) this;
        }

        public Criteria andTransferDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("transfer_date >=", value, "transferDate");
            return (Criteria) this;
        }

        public Criteria andTransferDateLessThan(Date value) {
            addCriterionForJDBCDate("transfer_date <", value, "transferDate");
            return (Criteria) this;
        }

        public Criteria andTransferDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("transfer_date <=", value, "transferDate");
            return (Criteria) this;
        }

        public Criteria andTransferDateIn(List<Date> values) {
            addCriterionForJDBCDate("transfer_date in", values, "transferDate");
            return (Criteria) this;
        }

        public Criteria andTransferDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("transfer_date not in", values, "transferDate");
            return (Criteria) this;
        }

        public Criteria andTransferDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("transfer_date between", value1, value2, "transferDate");
            return (Criteria) this;
        }

        public Criteria andTransferDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("transfer_date not between", value1, value2, "transferDate");
            return (Criteria) this;
        }

        public Criteria andDisplacementIsNull() {
            addCriterion("displacement is null");
            return (Criteria) this;
        }

        public Criteria andDisplacementIsNotNull() {
            addCriterion("displacement is not null");
            return (Criteria) this;
        }

        public Criteria andDisplacementEqualTo(Double value) {
            addCriterion("displacement =", value, "displacement");
            return (Criteria) this;
        }

        public Criteria andDisplacementNotEqualTo(Double value) {
            addCriterion("displacement <>", value, "displacement");
            return (Criteria) this;
        }

        public Criteria andDisplacementGreaterThan(Double value) {
            addCriterion("displacement >", value, "displacement");
            return (Criteria) this;
        }

        public Criteria andDisplacementGreaterThanOrEqualTo(Double value) {
            addCriterion("displacement >=", value, "displacement");
            return (Criteria) this;
        }

        public Criteria andDisplacementLessThan(Double value) {
            addCriterion("displacement <", value, "displacement");
            return (Criteria) this;
        }

        public Criteria andDisplacementLessThanOrEqualTo(Double value) {
            addCriterion("displacement <=", value, "displacement");
            return (Criteria) this;
        }

        public Criteria andDisplacementIn(List<Double> values) {
            addCriterion("displacement in", values, "displacement");
            return (Criteria) this;
        }

        public Criteria andDisplacementNotIn(List<Double> values) {
            addCriterion("displacement not in", values, "displacement");
            return (Criteria) this;
        }

        public Criteria andDisplacementBetween(Double value1, Double value2) {
            addCriterion("displacement between", value1, value2, "displacement");
            return (Criteria) this;
        }

        public Criteria andDisplacementNotBetween(Double value1, Double value2) {
            addCriterion("displacement not between", value1, value2, "displacement");
            return (Criteria) this;
        }

        public Criteria andCurbWeightIsNull() {
            addCriterion("curb_weight is null");
            return (Criteria) this;
        }

        public Criteria andCurbWeightIsNotNull() {
            addCriterion("curb_weight is not null");
            return (Criteria) this;
        }

        public Criteria andCurbWeightEqualTo(Double value) {
            addCriterion("curb_weight =", value, "curbWeight");
            return (Criteria) this;
        }

        public Criteria andCurbWeightNotEqualTo(Double value) {
            addCriterion("curb_weight <>", value, "curbWeight");
            return (Criteria) this;
        }

        public Criteria andCurbWeightGreaterThan(Double value) {
            addCriterion("curb_weight >", value, "curbWeight");
            return (Criteria) this;
        }

        public Criteria andCurbWeightGreaterThanOrEqualTo(Double value) {
            addCriterion("curb_weight >=", value, "curbWeight");
            return (Criteria) this;
        }

        public Criteria andCurbWeightLessThan(Double value) {
            addCriterion("curb_weight <", value, "curbWeight");
            return (Criteria) this;
        }

        public Criteria andCurbWeightLessThanOrEqualTo(Double value) {
            addCriterion("curb_weight <=", value, "curbWeight");
            return (Criteria) this;
        }

        public Criteria andCurbWeightIn(List<Double> values) {
            addCriterion("curb_weight in", values, "curbWeight");
            return (Criteria) this;
        }

        public Criteria andCurbWeightNotIn(List<Double> values) {
            addCriterion("curb_weight not in", values, "curbWeight");
            return (Criteria) this;
        }

        public Criteria andCurbWeightBetween(Double value1, Double value2) {
            addCriterion("curb_weight between", value1, value2, "curbWeight");
            return (Criteria) this;
        }

        public Criteria andCurbWeightNotBetween(Double value1, Double value2) {
            addCriterion("curb_weight not between", value1, value2, "curbWeight");
            return (Criteria) this;
        }

        public Criteria andTonnageIsNull() {
            addCriterion("tonnage is null");
            return (Criteria) this;
        }

        public Criteria andTonnageIsNotNull() {
            addCriterion("tonnage is not null");
            return (Criteria) this;
        }

        public Criteria andTonnageEqualTo(Double value) {
            addCriterion("tonnage =", value, "tonnage");
            return (Criteria) this;
        }

        public Criteria andTonnageNotEqualTo(Double value) {
            addCriterion("tonnage <>", value, "tonnage");
            return (Criteria) this;
        }

        public Criteria andTonnageGreaterThan(Double value) {
            addCriterion("tonnage >", value, "tonnage");
            return (Criteria) this;
        }

        public Criteria andTonnageGreaterThanOrEqualTo(Double value) {
            addCriterion("tonnage >=", value, "tonnage");
            return (Criteria) this;
        }

        public Criteria andTonnageLessThan(Double value) {
            addCriterion("tonnage <", value, "tonnage");
            return (Criteria) this;
        }

        public Criteria andTonnageLessThanOrEqualTo(Double value) {
            addCriterion("tonnage <=", value, "tonnage");
            return (Criteria) this;
        }

        public Criteria andTonnageIn(List<Double> values) {
            addCriterion("tonnage in", values, "tonnage");
            return (Criteria) this;
        }

        public Criteria andTonnageNotIn(List<Double> values) {
            addCriterion("tonnage not in", values, "tonnage");
            return (Criteria) this;
        }

        public Criteria andTonnageBetween(Double value1, Double value2) {
            addCriterion("tonnage between", value1, value2, "tonnage");
            return (Criteria) this;
        }

        public Criteria andTonnageNotBetween(Double value1, Double value2) {
            addCriterion("tonnage not between", value1, value2, "tonnage");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeIsNull() {
            addCriterion("vehicle_type is null");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeIsNotNull() {
            addCriterion("vehicle_type is not null");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeEqualTo(String value) {
            addCriterion("vehicle_type =", value, "vehicleType");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeNotEqualTo(String value) {
            addCriterion("vehicle_type <>", value, "vehicleType");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeGreaterThan(String value) {
            addCriterion("vehicle_type >", value, "vehicleType");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeGreaterThanOrEqualTo(String value) {
            addCriterion("vehicle_type >=", value, "vehicleType");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeLessThan(String value) {
            addCriterion("vehicle_type <", value, "vehicleType");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeLessThanOrEqualTo(String value) {
            addCriterion("vehicle_type <=", value, "vehicleType");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeLike(String value) {
            addCriterion("vehicle_type like", value, "vehicleType");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeNotLike(String value) {
            addCriterion("vehicle_type not like", value, "vehicleType");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeIn(List<String> values) {
            addCriterion("vehicle_type in", values, "vehicleType");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeNotIn(List<String> values) {
            addCriterion("vehicle_type not in", values, "vehicleType");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeBetween(String value1, String value2) {
            addCriterion("vehicle_type between", value1, value2, "vehicleType");
            return (Criteria) this;
        }

        public Criteria andVehicleTypeNotBetween(String value1, String value2) {
            addCriterion("vehicle_type not between", value1, value2, "vehicleType");
            return (Criteria) this;
        }

        public Criteria andVehicleCategoryIsNull() {
            addCriterion("vehicle_category is null");
            return (Criteria) this;
        }

        public Criteria andVehicleCategoryIsNotNull() {
            addCriterion("vehicle_category is not null");
            return (Criteria) this;
        }

        public Criteria andVehicleCategoryEqualTo(String value) {
            addCriterion("vehicle_category =", value, "vehicleCategory");
            return (Criteria) this;
        }

        public Criteria andVehicleCategoryNotEqualTo(String value) {
            addCriterion("vehicle_category <>", value, "vehicleCategory");
            return (Criteria) this;
        }

        public Criteria andVehicleCategoryGreaterThan(String value) {
            addCriterion("vehicle_category >", value, "vehicleCategory");
            return (Criteria) this;
        }

        public Criteria andVehicleCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("vehicle_category >=", value, "vehicleCategory");
            return (Criteria) this;
        }

        public Criteria andVehicleCategoryLessThan(String value) {
            addCriterion("vehicle_category <", value, "vehicleCategory");
            return (Criteria) this;
        }

        public Criteria andVehicleCategoryLessThanOrEqualTo(String value) {
            addCriterion("vehicle_category <=", value, "vehicleCategory");
            return (Criteria) this;
        }

        public Criteria andVehicleCategoryLike(String value) {
            addCriterion("vehicle_category like", value, "vehicleCategory");
            return (Criteria) this;
        }

        public Criteria andVehicleCategoryNotLike(String value) {
            addCriterion("vehicle_category not like", value, "vehicleCategory");
            return (Criteria) this;
        }

        public Criteria andVehicleCategoryIn(List<String> values) {
            addCriterion("vehicle_category in", values, "vehicleCategory");
            return (Criteria) this;
        }

        public Criteria andVehicleCategoryNotIn(List<String> values) {
            addCriterion("vehicle_category not in", values, "vehicleCategory");
            return (Criteria) this;
        }

        public Criteria andVehicleCategoryBetween(String value1, String value2) {
            addCriterion("vehicle_category between", value1, value2, "vehicleCategory");
            return (Criteria) this;
        }

        public Criteria andVehicleCategoryNotBetween(String value1, String value2) {
            addCriterion("vehicle_category not between", value1, value2, "vehicleCategory");
            return (Criteria) this;
        }

        public Criteria andUseNatureIsNull() {
            addCriterion("use_nature is null");
            return (Criteria) this;
        }

        public Criteria andUseNatureIsNotNull() {
            addCriterion("use_nature is not null");
            return (Criteria) this;
        }

        public Criteria andUseNatureEqualTo(String value) {
            addCriterion("use_nature =", value, "useNature");
            return (Criteria) this;
        }

        public Criteria andUseNatureNotEqualTo(String value) {
            addCriterion("use_nature <>", value, "useNature");
            return (Criteria) this;
        }

        public Criteria andUseNatureGreaterThan(String value) {
            addCriterion("use_nature >", value, "useNature");
            return (Criteria) this;
        }

        public Criteria andUseNatureGreaterThanOrEqualTo(String value) {
            addCriterion("use_nature >=", value, "useNature");
            return (Criteria) this;
        }

        public Criteria andUseNatureLessThan(String value) {
            addCriterion("use_nature <", value, "useNature");
            return (Criteria) this;
        }

        public Criteria andUseNatureLessThanOrEqualTo(String value) {
            addCriterion("use_nature <=", value, "useNature");
            return (Criteria) this;
        }

        public Criteria andUseNatureLike(String value) {
            addCriterion("use_nature like", value, "useNature");
            return (Criteria) this;
        }

        public Criteria andUseNatureNotLike(String value) {
            addCriterion("use_nature not like", value, "useNature");
            return (Criteria) this;
        }

        public Criteria andUseNatureIn(List<String> values) {
            addCriterion("use_nature in", values, "useNature");
            return (Criteria) this;
        }

        public Criteria andUseNatureNotIn(List<String> values) {
            addCriterion("use_nature not in", values, "useNature");
            return (Criteria) this;
        }

        public Criteria andUseNatureBetween(String value1, String value2) {
            addCriterion("use_nature between", value1, value2, "useNature");
            return (Criteria) this;
        }

        public Criteria andUseNatureNotBetween(String value1, String value2) {
            addCriterion("use_nature not between", value1, value2, "useNature");
            return (Criteria) this;
        }

        public Criteria andAttachNatureIsNull() {
            addCriterion("attach_nature is null");
            return (Criteria) this;
        }

        public Criteria andAttachNatureIsNotNull() {
            addCriterion("attach_nature is not null");
            return (Criteria) this;
        }

        public Criteria andAttachNatureEqualTo(String value) {
            addCriterion("attach_nature =", value, "attachNature");
            return (Criteria) this;
        }

        public Criteria andAttachNatureNotEqualTo(String value) {
            addCriterion("attach_nature <>", value, "attachNature");
            return (Criteria) this;
        }

        public Criteria andAttachNatureGreaterThan(String value) {
            addCriterion("attach_nature >", value, "attachNature");
            return (Criteria) this;
        }

        public Criteria andAttachNatureGreaterThanOrEqualTo(String value) {
            addCriterion("attach_nature >=", value, "attachNature");
            return (Criteria) this;
        }

        public Criteria andAttachNatureLessThan(String value) {
            addCriterion("attach_nature <", value, "attachNature");
            return (Criteria) this;
        }

        public Criteria andAttachNatureLessThanOrEqualTo(String value) {
            addCriterion("attach_nature <=", value, "attachNature");
            return (Criteria) this;
        }

        public Criteria andAttachNatureLike(String value) {
            addCriterion("attach_nature like", value, "attachNature");
            return (Criteria) this;
        }

        public Criteria andAttachNatureNotLike(String value) {
            addCriterion("attach_nature not like", value, "attachNature");
            return (Criteria) this;
        }

        public Criteria andAttachNatureIn(List<String> values) {
            addCriterion("attach_nature in", values, "attachNature");
            return (Criteria) this;
        }

        public Criteria andAttachNatureNotIn(List<String> values) {
            addCriterion("attach_nature not in", values, "attachNature");
            return (Criteria) this;
        }

        public Criteria andAttachNatureBetween(String value1, String value2) {
            addCriterion("attach_nature between", value1, value2, "attachNature");
            return (Criteria) this;
        }

        public Criteria andAttachNatureNotBetween(String value1, String value2) {
            addCriterion("attach_nature not between", value1, value2, "attachNature");
            return (Criteria) this;
        }

        public Criteria andPlateTypeIsNull() {
            addCriterion("plate_type is null");
            return (Criteria) this;
        }

        public Criteria andPlateTypeIsNotNull() {
            addCriterion("plate_type is not null");
            return (Criteria) this;
        }

        public Criteria andPlateTypeEqualTo(String value) {
            addCriterion("plate_type =", value, "plateType");
            return (Criteria) this;
        }

        public Criteria andPlateTypeNotEqualTo(String value) {
            addCriterion("plate_type <>", value, "plateType");
            return (Criteria) this;
        }

        public Criteria andPlateTypeGreaterThan(String value) {
            addCriterion("plate_type >", value, "plateType");
            return (Criteria) this;
        }

        public Criteria andPlateTypeGreaterThanOrEqualTo(String value) {
            addCriterion("plate_type >=", value, "plateType");
            return (Criteria) this;
        }

        public Criteria andPlateTypeLessThan(String value) {
            addCriterion("plate_type <", value, "plateType");
            return (Criteria) this;
        }

        public Criteria andPlateTypeLessThanOrEqualTo(String value) {
            addCriterion("plate_type <=", value, "plateType");
            return (Criteria) this;
        }

        public Criteria andPlateTypeLike(String value) {
            addCriterion("plate_type like", value, "plateType");
            return (Criteria) this;
        }

        public Criteria andPlateTypeNotLike(String value) {
            addCriterion("plate_type not like", value, "plateType");
            return (Criteria) this;
        }

        public Criteria andPlateTypeIn(List<String> values) {
            addCriterion("plate_type in", values, "plateType");
            return (Criteria) this;
        }

        public Criteria andPlateTypeNotIn(List<String> values) {
            addCriterion("plate_type not in", values, "plateType");
            return (Criteria) this;
        }

        public Criteria andPlateTypeBetween(String value1, String value2) {
            addCriterion("plate_type between", value1, value2, "plateType");
            return (Criteria) this;
        }

        public Criteria andPlateTypeNotBetween(String value1, String value2) {
            addCriterion("plate_type not between", value1, value2, "plateType");
            return (Criteria) this;
        }

        public Criteria andPlateColorIsNull() {
            addCriterion("plate_color is null");
            return (Criteria) this;
        }

        public Criteria andPlateColorIsNotNull() {
            addCriterion("plate_color is not null");
            return (Criteria) this;
        }

        public Criteria andPlateColorEqualTo(String value) {
            addCriterion("plate_color =", value, "plateColor");
            return (Criteria) this;
        }

        public Criteria andPlateColorNotEqualTo(String value) {
            addCriterion("plate_color <>", value, "plateColor");
            return (Criteria) this;
        }

        public Criteria andPlateColorGreaterThan(String value) {
            addCriterion("plate_color >", value, "plateColor");
            return (Criteria) this;
        }

        public Criteria andPlateColorGreaterThanOrEqualTo(String value) {
            addCriterion("plate_color >=", value, "plateColor");
            return (Criteria) this;
        }

        public Criteria andPlateColorLessThan(String value) {
            addCriterion("plate_color <", value, "plateColor");
            return (Criteria) this;
        }

        public Criteria andPlateColorLessThanOrEqualTo(String value) {
            addCriterion("plate_color <=", value, "plateColor");
            return (Criteria) this;
        }

        public Criteria andPlateColorLike(String value) {
            addCriterion("plate_color like", value, "plateColor");
            return (Criteria) this;
        }

        public Criteria andPlateColorNotLike(String value) {
            addCriterion("plate_color not like", value, "plateColor");
            return (Criteria) this;
        }

        public Criteria andPlateColorIn(List<String> values) {
            addCriterion("plate_color in", values, "plateColor");
            return (Criteria) this;
        }

        public Criteria andPlateColorNotIn(List<String> values) {
            addCriterion("plate_color not in", values, "plateColor");
            return (Criteria) this;
        }

        public Criteria andPlateColorBetween(String value1, String value2) {
            addCriterion("plate_color between", value1, value2, "plateColor");
            return (Criteria) this;
        }

        public Criteria andPlateColorNotBetween(String value1, String value2) {
            addCriterion("plate_color not between", value1, value2, "plateColor");
            return (Criteria) this;
        }

        public Criteria andEnergyTypeIsNull() {
            addCriterion("energy_type is null");
            return (Criteria) this;
        }

        public Criteria andEnergyTypeIsNotNull() {
            addCriterion("energy_type is not null");
            return (Criteria) this;
        }

        public Criteria andEnergyTypeEqualTo(String value) {
            addCriterion("energy_type =", value, "energyType");
            return (Criteria) this;
        }

        public Criteria andEnergyTypeNotEqualTo(String value) {
            addCriterion("energy_type <>", value, "energyType");
            return (Criteria) this;
        }

        public Criteria andEnergyTypeGreaterThan(String value) {
            addCriterion("energy_type >", value, "energyType");
            return (Criteria) this;
        }

        public Criteria andEnergyTypeGreaterThanOrEqualTo(String value) {
            addCriterion("energy_type >=", value, "energyType");
            return (Criteria) this;
        }

        public Criteria andEnergyTypeLessThan(String value) {
            addCriterion("energy_type <", value, "energyType");
            return (Criteria) this;
        }

        public Criteria andEnergyTypeLessThanOrEqualTo(String value) {
            addCriterion("energy_type <=", value, "energyType");
            return (Criteria) this;
        }

        public Criteria andEnergyTypeLike(String value) {
            addCriterion("energy_type like", value, "energyType");
            return (Criteria) this;
        }

        public Criteria andEnergyTypeNotLike(String value) {
            addCriterion("energy_type not like", value, "energyType");
            return (Criteria) this;
        }

        public Criteria andEnergyTypeIn(List<String> values) {
            addCriterion("energy_type in", values, "energyType");
            return (Criteria) this;
        }

        public Criteria andEnergyTypeNotIn(List<String> values) {
            addCriterion("energy_type not in", values, "energyType");
            return (Criteria) this;
        }

        public Criteria andEnergyTypeBetween(String value1, String value2) {
            addCriterion("energy_type between", value1, value2, "energyType");
            return (Criteria) this;
        }

        public Criteria andEnergyTypeNotBetween(String value1, String value2) {
            addCriterion("energy_type not between", value1, value2, "energyType");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}