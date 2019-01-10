package com.ybinsure.icar.user.model.data;

import java.util.ArrayList;
import java.util.List;

public class PingAnOrderDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PingAnOrderDOExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("userId is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("userId is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("userId =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("userId <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("userId >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("userId >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("userId <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("userId <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("userId like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("userId not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("userId in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("userId not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("userId between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("userId not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andLicenseNoIsNull() {
            addCriterion("licenseNo is null");
            return (Criteria) this;
        }

        public Criteria andLicenseNoIsNotNull() {
            addCriterion("licenseNo is not null");
            return (Criteria) this;
        }

        public Criteria andLicenseNoEqualTo(String value) {
            addCriterion("licenseNo =", value, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoNotEqualTo(String value) {
            addCriterion("licenseNo <>", value, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoGreaterThan(String value) {
            addCriterion("licenseNo >", value, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoGreaterThanOrEqualTo(String value) {
            addCriterion("licenseNo >=", value, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoLessThan(String value) {
            addCriterion("licenseNo <", value, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoLessThanOrEqualTo(String value) {
            addCriterion("licenseNo <=", value, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoLike(String value) {
            addCriterion("licenseNo like", value, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoNotLike(String value) {
            addCriterion("licenseNo not like", value, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoIn(List<String> values) {
            addCriterion("licenseNo in", values, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoNotIn(List<String> values) {
            addCriterion("licenseNo not in", values, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoBetween(String value1, String value2) {
            addCriterion("licenseNo between", value1, value2, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoNotBetween(String value1, String value2) {
            addCriterion("licenseNo not between", value1, value2, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNull() {
            addCriterion("orderNo is null");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNotNull() {
            addCriterion("orderNo is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNoEqualTo(String value) {
            addCriterion("orderNo =", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotEqualTo(String value) {
            addCriterion("orderNo <>", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThan(String value) {
            addCriterion("orderNo >", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("orderNo >=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThan(String value) {
            addCriterion("orderNo <", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThanOrEqualTo(String value) {
            addCriterion("orderNo <=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLike(String value) {
            addCriterion("orderNo like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotLike(String value) {
            addCriterion("orderNo not like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoIn(List<String> values) {
            addCriterion("orderNo in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotIn(List<String> values) {
            addCriterion("orderNo not in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoBetween(String value1, String value2) {
            addCriterion("orderNo between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotBetween(String value1, String value2) {
            addCriterion("orderNo not between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andTciPolicyNoIsNull() {
            addCriterion("tciPolicyNo is null");
            return (Criteria) this;
        }

        public Criteria andTciPolicyNoIsNotNull() {
            addCriterion("tciPolicyNo is not null");
            return (Criteria) this;
        }

        public Criteria andTciPolicyNoEqualTo(String value) {
            addCriterion("tciPolicyNo =", value, "tciPolicyNo");
            return (Criteria) this;
        }

        public Criteria andTciPolicyNoNotEqualTo(String value) {
            addCriterion("tciPolicyNo <>", value, "tciPolicyNo");
            return (Criteria) this;
        }

        public Criteria andTciPolicyNoGreaterThan(String value) {
            addCriterion("tciPolicyNo >", value, "tciPolicyNo");
            return (Criteria) this;
        }

        public Criteria andTciPolicyNoGreaterThanOrEqualTo(String value) {
            addCriterion("tciPolicyNo >=", value, "tciPolicyNo");
            return (Criteria) this;
        }

        public Criteria andTciPolicyNoLessThan(String value) {
            addCriterion("tciPolicyNo <", value, "tciPolicyNo");
            return (Criteria) this;
        }

        public Criteria andTciPolicyNoLessThanOrEqualTo(String value) {
            addCriterion("tciPolicyNo <=", value, "tciPolicyNo");
            return (Criteria) this;
        }

        public Criteria andTciPolicyNoLike(String value) {
            addCriterion("tciPolicyNo like", value, "tciPolicyNo");
            return (Criteria) this;
        }

        public Criteria andTciPolicyNoNotLike(String value) {
            addCriterion("tciPolicyNo not like", value, "tciPolicyNo");
            return (Criteria) this;
        }

        public Criteria andTciPolicyNoIn(List<String> values) {
            addCriterion("tciPolicyNo in", values, "tciPolicyNo");
            return (Criteria) this;
        }

        public Criteria andTciPolicyNoNotIn(List<String> values) {
            addCriterion("tciPolicyNo not in", values, "tciPolicyNo");
            return (Criteria) this;
        }

        public Criteria andTciPolicyNoBetween(String value1, String value2) {
            addCriterion("tciPolicyNo between", value1, value2, "tciPolicyNo");
            return (Criteria) this;
        }

        public Criteria andTciPolicyNoNotBetween(String value1, String value2) {
            addCriterion("tciPolicyNo not between", value1, value2, "tciPolicyNo");
            return (Criteria) this;
        }

        public Criteria andVciPolicyNoIsNull() {
            addCriterion("vciPolicyNo is null");
            return (Criteria) this;
        }

        public Criteria andVciPolicyNoIsNotNull() {
            addCriterion("vciPolicyNo is not null");
            return (Criteria) this;
        }

        public Criteria andVciPolicyNoEqualTo(String value) {
            addCriterion("vciPolicyNo =", value, "vciPolicyNo");
            return (Criteria) this;
        }

        public Criteria andVciPolicyNoNotEqualTo(String value) {
            addCriterion("vciPolicyNo <>", value, "vciPolicyNo");
            return (Criteria) this;
        }

        public Criteria andVciPolicyNoGreaterThan(String value) {
            addCriterion("vciPolicyNo >", value, "vciPolicyNo");
            return (Criteria) this;
        }

        public Criteria andVciPolicyNoGreaterThanOrEqualTo(String value) {
            addCriterion("vciPolicyNo >=", value, "vciPolicyNo");
            return (Criteria) this;
        }

        public Criteria andVciPolicyNoLessThan(String value) {
            addCriterion("vciPolicyNo <", value, "vciPolicyNo");
            return (Criteria) this;
        }

        public Criteria andVciPolicyNoLessThanOrEqualTo(String value) {
            addCriterion("vciPolicyNo <=", value, "vciPolicyNo");
            return (Criteria) this;
        }

        public Criteria andVciPolicyNoLike(String value) {
            addCriterion("vciPolicyNo like", value, "vciPolicyNo");
            return (Criteria) this;
        }

        public Criteria andVciPolicyNoNotLike(String value) {
            addCriterion("vciPolicyNo not like", value, "vciPolicyNo");
            return (Criteria) this;
        }

        public Criteria andVciPolicyNoIn(List<String> values) {
            addCriterion("vciPolicyNo in", values, "vciPolicyNo");
            return (Criteria) this;
        }

        public Criteria andVciPolicyNoNotIn(List<String> values) {
            addCriterion("vciPolicyNo not in", values, "vciPolicyNo");
            return (Criteria) this;
        }

        public Criteria andVciPolicyNoBetween(String value1, String value2) {
            addCriterion("vciPolicyNo between", value1, value2, "vciPolicyNo");
            return (Criteria) this;
        }

        public Criteria andVciPolicyNoNotBetween(String value1, String value2) {
            addCriterion("vciPolicyNo not between", value1, value2, "vciPolicyNo");
            return (Criteria) this;
        }

        public Criteria andTotalPremiumIsNull() {
            addCriterion("totalPremium is null");
            return (Criteria) this;
        }

        public Criteria andTotalPremiumIsNotNull() {
            addCriterion("totalPremium is not null");
            return (Criteria) this;
        }

        public Criteria andTotalPremiumEqualTo(Double value) {
            addCriterion("totalPremium =", value, "totalPremium");
            return (Criteria) this;
        }

        public Criteria andTotalPremiumNotEqualTo(Double value) {
            addCriterion("totalPremium <>", value, "totalPremium");
            return (Criteria) this;
        }

        public Criteria andTotalPremiumGreaterThan(Double value) {
            addCriterion("totalPremium >", value, "totalPremium");
            return (Criteria) this;
        }

        public Criteria andTotalPremiumGreaterThanOrEqualTo(Double value) {
            addCriterion("totalPremium >=", value, "totalPremium");
            return (Criteria) this;
        }

        public Criteria andTotalPremiumLessThan(Double value) {
            addCriterion("totalPremium <", value, "totalPremium");
            return (Criteria) this;
        }

        public Criteria andTotalPremiumLessThanOrEqualTo(Double value) {
            addCriterion("totalPremium <=", value, "totalPremium");
            return (Criteria) this;
        }

        public Criteria andTotalPremiumIn(List<Double> values) {
            addCriterion("totalPremium in", values, "totalPremium");
            return (Criteria) this;
        }

        public Criteria andTotalPremiumNotIn(List<Double> values) {
            addCriterion("totalPremium not in", values, "totalPremium");
            return (Criteria) this;
        }

        public Criteria andTotalPremiumBetween(Double value1, Double value2) {
            addCriterion("totalPremium between", value1, value2, "totalPremium");
            return (Criteria) this;
        }

        public Criteria andTotalPremiumNotBetween(Double value1, Double value2) {
            addCriterion("totalPremium not between", value1, value2, "totalPremium");
            return (Criteria) this;
        }

        public Criteria andTciPremiumIsNull() {
            addCriterion("tciPremium is null");
            return (Criteria) this;
        }

        public Criteria andTciPremiumIsNotNull() {
            addCriterion("tciPremium is not null");
            return (Criteria) this;
        }

        public Criteria andTciPremiumEqualTo(Double value) {
            addCriterion("tciPremium =", value, "tciPremium");
            return (Criteria) this;
        }

        public Criteria andTciPremiumNotEqualTo(Double value) {
            addCriterion("tciPremium <>", value, "tciPremium");
            return (Criteria) this;
        }

        public Criteria andTciPremiumGreaterThan(Double value) {
            addCriterion("tciPremium >", value, "tciPremium");
            return (Criteria) this;
        }

        public Criteria andTciPremiumGreaterThanOrEqualTo(Double value) {
            addCriterion("tciPremium >=", value, "tciPremium");
            return (Criteria) this;
        }

        public Criteria andTciPremiumLessThan(Double value) {
            addCriterion("tciPremium <", value, "tciPremium");
            return (Criteria) this;
        }

        public Criteria andTciPremiumLessThanOrEqualTo(Double value) {
            addCriterion("tciPremium <=", value, "tciPremium");
            return (Criteria) this;
        }

        public Criteria andTciPremiumIn(List<Double> values) {
            addCriterion("tciPremium in", values, "tciPremium");
            return (Criteria) this;
        }

        public Criteria andTciPremiumNotIn(List<Double> values) {
            addCriterion("tciPremium not in", values, "tciPremium");
            return (Criteria) this;
        }

        public Criteria andTciPremiumBetween(Double value1, Double value2) {
            addCriterion("tciPremium between", value1, value2, "tciPremium");
            return (Criteria) this;
        }

        public Criteria andTciPremiumNotBetween(Double value1, Double value2) {
            addCriterion("tciPremium not between", value1, value2, "tciPremium");
            return (Criteria) this;
        }

        public Criteria andTaxIsNull() {
            addCriterion("tax is null");
            return (Criteria) this;
        }

        public Criteria andTaxIsNotNull() {
            addCriterion("tax is not null");
            return (Criteria) this;
        }

        public Criteria andTaxEqualTo(Double value) {
            addCriterion("tax =", value, "tax");
            return (Criteria) this;
        }

        public Criteria andTaxNotEqualTo(Double value) {
            addCriterion("tax <>", value, "tax");
            return (Criteria) this;
        }

        public Criteria andTaxGreaterThan(Double value) {
            addCriterion("tax >", value, "tax");
            return (Criteria) this;
        }

        public Criteria andTaxGreaterThanOrEqualTo(Double value) {
            addCriterion("tax >=", value, "tax");
            return (Criteria) this;
        }

        public Criteria andTaxLessThan(Double value) {
            addCriterion("tax <", value, "tax");
            return (Criteria) this;
        }

        public Criteria andTaxLessThanOrEqualTo(Double value) {
            addCriterion("tax <=", value, "tax");
            return (Criteria) this;
        }

        public Criteria andTaxIn(List<Double> values) {
            addCriterion("tax in", values, "tax");
            return (Criteria) this;
        }

        public Criteria andTaxNotIn(List<Double> values) {
            addCriterion("tax not in", values, "tax");
            return (Criteria) this;
        }

        public Criteria andTaxBetween(Double value1, Double value2) {
            addCriterion("tax between", value1, value2, "tax");
            return (Criteria) this;
        }

        public Criteria andTaxNotBetween(Double value1, Double value2) {
            addCriterion("tax not between", value1, value2, "tax");
            return (Criteria) this;
        }

        public Criteria andVciPremiumIsNull() {
            addCriterion("vciPremium is null");
            return (Criteria) this;
        }

        public Criteria andVciPremiumIsNotNull() {
            addCriterion("vciPremium is not null");
            return (Criteria) this;
        }

        public Criteria andVciPremiumEqualTo(Double value) {
            addCriterion("vciPremium =", value, "vciPremium");
            return (Criteria) this;
        }

        public Criteria andVciPremiumNotEqualTo(Double value) {
            addCriterion("vciPremium <>", value, "vciPremium");
            return (Criteria) this;
        }

        public Criteria andVciPremiumGreaterThan(Double value) {
            addCriterion("vciPremium >", value, "vciPremium");
            return (Criteria) this;
        }

        public Criteria andVciPremiumGreaterThanOrEqualTo(Double value) {
            addCriterion("vciPremium >=", value, "vciPremium");
            return (Criteria) this;
        }

        public Criteria andVciPremiumLessThan(Double value) {
            addCriterion("vciPremium <", value, "vciPremium");
            return (Criteria) this;
        }

        public Criteria andVciPremiumLessThanOrEqualTo(Double value) {
            addCriterion("vciPremium <=", value, "vciPremium");
            return (Criteria) this;
        }

        public Criteria andVciPremiumIn(List<Double> values) {
            addCriterion("vciPremium in", values, "vciPremium");
            return (Criteria) this;
        }

        public Criteria andVciPremiumNotIn(List<Double> values) {
            addCriterion("vciPremium not in", values, "vciPremium");
            return (Criteria) this;
        }

        public Criteria andVciPremiumBetween(Double value1, Double value2) {
            addCriterion("vciPremium between", value1, value2, "vciPremium");
            return (Criteria) this;
        }

        public Criteria andVciPremiumNotBetween(Double value1, Double value2) {
            addCriterion("vciPremium not between", value1, value2, "vciPremium");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("createDate is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("createDate is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Long value) {
            addCriterion("createDate =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Long value) {
            addCriterion("createDate <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Long value) {
            addCriterion("createDate >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Long value) {
            addCriterion("createDate >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Long value) {
            addCriterion("createDate <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Long value) {
            addCriterion("createDate <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Long> values) {
            addCriterion("createDate in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Long> values) {
            addCriterion("createDate not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Long value1, Long value2) {
            addCriterion("createDate between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Long value1, Long value2) {
            addCriterion("createDate not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("status not between", value1, value2, "status");
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