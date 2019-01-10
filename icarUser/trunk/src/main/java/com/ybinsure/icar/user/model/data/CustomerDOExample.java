package com.ybinsure.icar.user.model.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class CustomerDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CustomerDOExample() {
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

        public Criteria andSalesmanIdIsNull() {
            addCriterion("salesmanId is null");
            return (Criteria) this;
        }

        public Criteria andSalesmanIdIsNotNull() {
            addCriterion("salesmanId is not null");
            return (Criteria) this;
        }

        public Criteria andSalesmanIdEqualTo(String value) {
            addCriterion("salesmanId =", value, "salesmanId");
            return (Criteria) this;
        }

        public Criteria andSalesmanIdNotEqualTo(String value) {
            addCriterion("salesmanId <>", value, "salesmanId");
            return (Criteria) this;
        }

        public Criteria andSalesmanIdGreaterThan(String value) {
            addCriterion("salesmanId >", value, "salesmanId");
            return (Criteria) this;
        }

        public Criteria andSalesmanIdGreaterThanOrEqualTo(String value) {
            addCriterion("salesmanId >=", value, "salesmanId");
            return (Criteria) this;
        }

        public Criteria andSalesmanIdLessThan(String value) {
            addCriterion("salesmanId <", value, "salesmanId");
            return (Criteria) this;
        }

        public Criteria andSalesmanIdLessThanOrEqualTo(String value) {
            addCriterion("salesmanId <=", value, "salesmanId");
            return (Criteria) this;
        }

        public Criteria andSalesmanIdLike(String value) {
            addCriterion("salesmanId like", value, "salesmanId");
            return (Criteria) this;
        }

        public Criteria andSalesmanIdNotLike(String value) {
            addCriterion("salesmanId not like", value, "salesmanId");
            return (Criteria) this;
        }

        public Criteria andSalesmanIdIn(List<String> values) {
            addCriterion("salesmanId in", values, "salesmanId");
            return (Criteria) this;
        }

        public Criteria andSalesmanIdNotIn(List<String> values) {
            addCriterion("salesmanId not in", values, "salesmanId");
            return (Criteria) this;
        }

        public Criteria andSalesmanIdBetween(String value1, String value2) {
            addCriterion("salesmanId between", value1, value2, "salesmanId");
            return (Criteria) this;
        }

        public Criteria andSalesmanIdNotBetween(String value1, String value2) {
            addCriterion("salesmanId not between", value1, value2, "salesmanId");
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

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(Long value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(Long value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(Long value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(Long value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(Long value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(Long value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<Long> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<Long> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(Long value1, Long value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(Long value1, Long value2) {
            addCriterion("phone not between", value1, value2, "phone");
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

        public Criteria andVinNoIsNull() {
            addCriterion("vinNo is null");
            return (Criteria) this;
        }

        public Criteria andVinNoIsNotNull() {
            addCriterion("vinNo is not null");
            return (Criteria) this;
        }

        public Criteria andVinNoEqualTo(String value) {
            addCriterion("vinNo =", value, "vinNo");
            return (Criteria) this;
        }

        public Criteria andVinNoNotEqualTo(String value) {
            addCriterion("vinNo <>", value, "vinNo");
            return (Criteria) this;
        }

        public Criteria andVinNoGreaterThan(String value) {
            addCriterion("vinNo >", value, "vinNo");
            return (Criteria) this;
        }

        public Criteria andVinNoGreaterThanOrEqualTo(String value) {
            addCriterion("vinNo >=", value, "vinNo");
            return (Criteria) this;
        }

        public Criteria andVinNoLessThan(String value) {
            addCriterion("vinNo <", value, "vinNo");
            return (Criteria) this;
        }

        public Criteria andVinNoLessThanOrEqualTo(String value) {
            addCriterion("vinNo <=", value, "vinNo");
            return (Criteria) this;
        }

        public Criteria andVinNoLike(String value) {
            addCriterion("vinNo like", value, "vinNo");
            return (Criteria) this;
        }

        public Criteria andVinNoNotLike(String value) {
            addCriterion("vinNo not like", value, "vinNo");
            return (Criteria) this;
        }

        public Criteria andVinNoIn(List<String> values) {
            addCriterion("vinNo in", values, "vinNo");
            return (Criteria) this;
        }

        public Criteria andVinNoNotIn(List<String> values) {
            addCriterion("vinNo not in", values, "vinNo");
            return (Criteria) this;
        }

        public Criteria andVinNoBetween(String value1, String value2) {
            addCriterion("vinNo between", value1, value2, "vinNo");
            return (Criteria) this;
        }

        public Criteria andVinNoNotBetween(String value1, String value2) {
            addCriterion("vinNo not between", value1, value2, "vinNo");
            return (Criteria) this;
        }

        public Criteria andModelNameIsNull() {
            addCriterion("modelName is null");
            return (Criteria) this;
        }

        public Criteria andModelNameIsNotNull() {
            addCriterion("modelName is not null");
            return (Criteria) this;
        }

        public Criteria andModelNameEqualTo(String value) {
            addCriterion("modelName =", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameNotEqualTo(String value) {
            addCriterion("modelName <>", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameGreaterThan(String value) {
            addCriterion("modelName >", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameGreaterThanOrEqualTo(String value) {
            addCriterion("modelName >=", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameLessThan(String value) {
            addCriterion("modelName <", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameLessThanOrEqualTo(String value) {
            addCriterion("modelName <=", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameLike(String value) {
            addCriterion("modelName like", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameNotLike(String value) {
            addCriterion("modelName not like", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameIn(List<String> values) {
            addCriterion("modelName in", values, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameNotIn(List<String> values) {
            addCriterion("modelName not in", values, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameBetween(String value1, String value2) {
            addCriterion("modelName between", value1, value2, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameNotBetween(String value1, String value2) {
            addCriterion("modelName not between", value1, value2, "modelName");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("createTime is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("createTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("createTime =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("createTime <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("createTime >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createTime >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("createTime <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("createTime <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("createTime in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("createTime not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("createTime between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("createTime not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andLastCompanyIdIsNull() {
            addCriterion("lastCompanyId is null");
            return (Criteria) this;
        }

        public Criteria andLastCompanyIdIsNotNull() {
            addCriterion("lastCompanyId is not null");
            return (Criteria) this;
        }

        public Criteria andLastCompanyIdEqualTo(Integer value) {
            addCriterion("lastCompanyId =", value, "lastCompanyId");
            return (Criteria) this;
        }

        public Criteria andLastCompanyIdNotEqualTo(Integer value) {
            addCriterion("lastCompanyId <>", value, "lastCompanyId");
            return (Criteria) this;
        }

        public Criteria andLastCompanyIdGreaterThan(Integer value) {
            addCriterion("lastCompanyId >", value, "lastCompanyId");
            return (Criteria) this;
        }

        public Criteria andLastCompanyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("lastCompanyId >=", value, "lastCompanyId");
            return (Criteria) this;
        }

        public Criteria andLastCompanyIdLessThan(Integer value) {
            addCriterion("lastCompanyId <", value, "lastCompanyId");
            return (Criteria) this;
        }

        public Criteria andLastCompanyIdLessThanOrEqualTo(Integer value) {
            addCriterion("lastCompanyId <=", value, "lastCompanyId");
            return (Criteria) this;
        }

        public Criteria andLastCompanyIdIn(List<Integer> values) {
            addCriterion("lastCompanyId in", values, "lastCompanyId");
            return (Criteria) this;
        }

        public Criteria andLastCompanyIdNotIn(List<Integer> values) {
            addCriterion("lastCompanyId not in", values, "lastCompanyId");
            return (Criteria) this;
        }

        public Criteria andLastCompanyIdBetween(Integer value1, Integer value2) {
            addCriterion("lastCompanyId between", value1, value2, "lastCompanyId");
            return (Criteria) this;
        }

        public Criteria andLastCompanyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("lastCompanyId not between", value1, value2, "lastCompanyId");
            return (Criteria) this;
        }

        public Criteria andLatelyQuoteTimeIsNull() {
            addCriterion("latelyQuoteTime is null");
            return (Criteria) this;
        }

        public Criteria andLatelyQuoteTimeIsNotNull() {
            addCriterion("latelyQuoteTime is not null");
            return (Criteria) this;
        }

        public Criteria andLatelyQuoteTimeEqualTo(Long value) {
            addCriterion("latelyQuoteTime =", value, "latelyQuoteTime");
            return (Criteria) this;
        }

        public Criteria andLatelyQuoteTimeNotEqualTo(Long value) {
            addCriterion("latelyQuoteTime <>", value, "latelyQuoteTime");
            return (Criteria) this;
        }

        public Criteria andLatelyQuoteTimeGreaterThan(Long value) {
            addCriterion("latelyQuoteTime >", value, "latelyQuoteTime");
            return (Criteria) this;
        }

        public Criteria andLatelyQuoteTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("latelyQuoteTime >=", value, "latelyQuoteTime");
            return (Criteria) this;
        }

        public Criteria andLatelyQuoteTimeLessThan(Long value) {
            addCriterion("latelyQuoteTime <", value, "latelyQuoteTime");
            return (Criteria) this;
        }

        public Criteria andLatelyQuoteTimeLessThanOrEqualTo(Long value) {
            addCriterion("latelyQuoteTime <=", value, "latelyQuoteTime");
            return (Criteria) this;
        }

        public Criteria andLatelyQuoteTimeIn(List<Long> values) {
            addCriterion("latelyQuoteTime in", values, "latelyQuoteTime");
            return (Criteria) this;
        }

        public Criteria andLatelyQuoteTimeNotIn(List<Long> values) {
            addCriterion("latelyQuoteTime not in", values, "latelyQuoteTime");
            return (Criteria) this;
        }

        public Criteria andLatelyQuoteTimeBetween(Long value1, Long value2) {
            addCriterion("latelyQuoteTime between", value1, value2, "latelyQuoteTime");
            return (Criteria) this;
        }

        public Criteria andLatelyQuoteTimeNotBetween(Long value1, Long value2) {
            addCriterion("latelyQuoteTime not between", value1, value2, "latelyQuoteTime");
            return (Criteria) this;
        }

        public Criteria andComEndDateIsNull() {
            addCriterion("comEndDate is null");
            return (Criteria) this;
        }

        public Criteria andComEndDateIsNotNull() {
            addCriterion("comEndDate is not null");
            return (Criteria) this;
        }

        public Criteria andComEndDateEqualTo(Date value) {
            addCriterionForJDBCDate("comEndDate =", value, "comEndDate");
            return (Criteria) this;
        }

        public Criteria andComEndDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("comEndDate <>", value, "comEndDate");
            return (Criteria) this;
        }

        public Criteria andComEndDateGreaterThan(Date value) {
            addCriterionForJDBCDate("comEndDate >", value, "comEndDate");
            return (Criteria) this;
        }

        public Criteria andComEndDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("comEndDate >=", value, "comEndDate");
            return (Criteria) this;
        }

        public Criteria andComEndDateLessThan(Date value) {
            addCriterionForJDBCDate("comEndDate <", value, "comEndDate");
            return (Criteria) this;
        }

        public Criteria andComEndDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("comEndDate <=", value, "comEndDate");
            return (Criteria) this;
        }

        public Criteria andComEndDateIn(List<Date> values) {
            addCriterionForJDBCDate("comEndDate in", values, "comEndDate");
            return (Criteria) this;
        }

        public Criteria andComEndDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("comEndDate not in", values, "comEndDate");
            return (Criteria) this;
        }

        public Criteria andComEndDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("comEndDate between", value1, value2, "comEndDate");
            return (Criteria) this;
        }

        public Criteria andComEndDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("comEndDate not between", value1, value2, "comEndDate");
            return (Criteria) this;
        }

        public Criteria andForceEndDateIsNull() {
            addCriterion("forceEndDate is null");
            return (Criteria) this;
        }

        public Criteria andForceEndDateIsNotNull() {
            addCriterion("forceEndDate is not null");
            return (Criteria) this;
        }

        public Criteria andForceEndDateEqualTo(Date value) {
            addCriterionForJDBCDate("forceEndDate =", value, "forceEndDate");
            return (Criteria) this;
        }

        public Criteria andForceEndDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("forceEndDate <>", value, "forceEndDate");
            return (Criteria) this;
        }

        public Criteria andForceEndDateGreaterThan(Date value) {
            addCriterionForJDBCDate("forceEndDate >", value, "forceEndDate");
            return (Criteria) this;
        }

        public Criteria andForceEndDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("forceEndDate >=", value, "forceEndDate");
            return (Criteria) this;
        }

        public Criteria andForceEndDateLessThan(Date value) {
            addCriterionForJDBCDate("forceEndDate <", value, "forceEndDate");
            return (Criteria) this;
        }

        public Criteria andForceEndDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("forceEndDate <=", value, "forceEndDate");
            return (Criteria) this;
        }

        public Criteria andForceEndDateIn(List<Date> values) {
            addCriterionForJDBCDate("forceEndDate in", values, "forceEndDate");
            return (Criteria) this;
        }

        public Criteria andForceEndDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("forceEndDate not in", values, "forceEndDate");
            return (Criteria) this;
        }

        public Criteria andForceEndDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("forceEndDate between", value1, value2, "forceEndDate");
            return (Criteria) this;
        }

        public Criteria andForceEndDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("forceEndDate not between", value1, value2, "forceEndDate");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andDelIsNull() {
            addCriterion("del is null");
            return (Criteria) this;
        }

        public Criteria andDelIsNotNull() {
            addCriterion("del is not null");
            return (Criteria) this;
        }

        public Criteria andDelEqualTo(Byte value) {
            addCriterion("del =", value, "del");
            return (Criteria) this;
        }

        public Criteria andDelNotEqualTo(Byte value) {
            addCriterion("del <>", value, "del");
            return (Criteria) this;
        }

        public Criteria andDelGreaterThan(Byte value) {
            addCriterion("del >", value, "del");
            return (Criteria) this;
        }

        public Criteria andDelGreaterThanOrEqualTo(Byte value) {
            addCriterion("del >=", value, "del");
            return (Criteria) this;
        }

        public Criteria andDelLessThan(Byte value) {
            addCriterion("del <", value, "del");
            return (Criteria) this;
        }

        public Criteria andDelLessThanOrEqualTo(Byte value) {
            addCriterion("del <=", value, "del");
            return (Criteria) this;
        }

        public Criteria andDelIn(List<Byte> values) {
            addCriterion("del in", values, "del");
            return (Criteria) this;
        }

        public Criteria andDelNotIn(List<Byte> values) {
            addCriterion("del not in", values, "del");
            return (Criteria) this;
        }

        public Criteria andDelBetween(Byte value1, Byte value2) {
            addCriterion("del between", value1, value2, "del");
            return (Criteria) this;
        }

        public Criteria andDelNotBetween(Byte value1, Byte value2) {
            addCriterion("del not between", value1, value2, "del");
            return (Criteria) this;
        }

        public Criteria andSourceIdIsNull() {
            addCriterion("sourceId is null");
            return (Criteria) this;
        }

        public Criteria andSourceIdIsNotNull() {
            addCriterion("sourceId is not null");
            return (Criteria) this;
        }

        public Criteria andSourceIdEqualTo(String value) {
            addCriterion("sourceId =", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdNotEqualTo(String value) {
            addCriterion("sourceId <>", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdGreaterThan(String value) {
            addCriterion("sourceId >", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdGreaterThanOrEqualTo(String value) {
            addCriterion("sourceId >=", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdLessThan(String value) {
            addCriterion("sourceId <", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdLessThanOrEqualTo(String value) {
            addCriterion("sourceId <=", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdLike(String value) {
            addCriterion("sourceId like", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdNotLike(String value) {
            addCriterion("sourceId not like", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdIn(List<String> values) {
            addCriterion("sourceId in", values, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdNotIn(List<String> values) {
            addCriterion("sourceId not in", values, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdBetween(String value1, String value2) {
            addCriterion("sourceId between", value1, value2, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdNotBetween(String value1, String value2) {
            addCriterion("sourceId not between", value1, value2, "sourceId");
            return (Criteria) this;
        }

        public Criteria andInsureProvinceIsNull() {
            addCriterion("insureProvince is null");
            return (Criteria) this;
        }

        public Criteria andInsureProvinceIsNotNull() {
            addCriterion("insureProvince is not null");
            return (Criteria) this;
        }

        public Criteria andInsureProvinceEqualTo(String value) {
            addCriterion("insureProvince =", value, "insureProvince");
            return (Criteria) this;
        }

        public Criteria andInsureProvinceNotEqualTo(String value) {
            addCriterion("insureProvince <>", value, "insureProvince");
            return (Criteria) this;
        }

        public Criteria andInsureProvinceGreaterThan(String value) {
            addCriterion("insureProvince >", value, "insureProvince");
            return (Criteria) this;
        }

        public Criteria andInsureProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("insureProvince >=", value, "insureProvince");
            return (Criteria) this;
        }

        public Criteria andInsureProvinceLessThan(String value) {
            addCriterion("insureProvince <", value, "insureProvince");
            return (Criteria) this;
        }

        public Criteria andInsureProvinceLessThanOrEqualTo(String value) {
            addCriterion("insureProvince <=", value, "insureProvince");
            return (Criteria) this;
        }

        public Criteria andInsureProvinceLike(String value) {
            addCriterion("insureProvince like", value, "insureProvince");
            return (Criteria) this;
        }

        public Criteria andInsureProvinceNotLike(String value) {
            addCriterion("insureProvince not like", value, "insureProvince");
            return (Criteria) this;
        }

        public Criteria andInsureProvinceIn(List<String> values) {
            addCriterion("insureProvince in", values, "insureProvince");
            return (Criteria) this;
        }

        public Criteria andInsureProvinceNotIn(List<String> values) {
            addCriterion("insureProvince not in", values, "insureProvince");
            return (Criteria) this;
        }

        public Criteria andInsureProvinceBetween(String value1, String value2) {
            addCriterion("insureProvince between", value1, value2, "insureProvince");
            return (Criteria) this;
        }

        public Criteria andInsureProvinceNotBetween(String value1, String value2) {
            addCriterion("insureProvince not between", value1, value2, "insureProvince");
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