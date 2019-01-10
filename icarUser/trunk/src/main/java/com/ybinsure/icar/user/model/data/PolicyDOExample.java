package com.ybinsure.icar.user.model.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class PolicyDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PolicyDOExample() {
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

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(String value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(String value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(String value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(String value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(String value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLike(String value) {
            addCriterion("order_id like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotLike(String value) {
            addCriterion("order_id not like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<String> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<String> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(String value1, String value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(String value1, String value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andSourceCodeIsNull() {
            addCriterion("source_code is null");
            return (Criteria) this;
        }

        public Criteria andSourceCodeIsNotNull() {
            addCriterion("source_code is not null");
            return (Criteria) this;
        }

        public Criteria andSourceCodeEqualTo(String value) {
            addCriterion("source_code =", value, "sourceCode");
            return (Criteria) this;
        }

        public Criteria andSourceCodeNotEqualTo(String value) {
            addCriterion("source_code <>", value, "sourceCode");
            return (Criteria) this;
        }

        public Criteria andSourceCodeGreaterThan(String value) {
            addCriterion("source_code >", value, "sourceCode");
            return (Criteria) this;
        }

        public Criteria andSourceCodeGreaterThanOrEqualTo(String value) {
            addCriterion("source_code >=", value, "sourceCode");
            return (Criteria) this;
        }

        public Criteria andSourceCodeLessThan(String value) {
            addCriterion("source_code <", value, "sourceCode");
            return (Criteria) this;
        }

        public Criteria andSourceCodeLessThanOrEqualTo(String value) {
            addCriterion("source_code <=", value, "sourceCode");
            return (Criteria) this;
        }

        public Criteria andSourceCodeLike(String value) {
            addCriterion("source_code like", value, "sourceCode");
            return (Criteria) this;
        }

        public Criteria andSourceCodeNotLike(String value) {
            addCriterion("source_code not like", value, "sourceCode");
            return (Criteria) this;
        }

        public Criteria andSourceCodeIn(List<String> values) {
            addCriterion("source_code in", values, "sourceCode");
            return (Criteria) this;
        }

        public Criteria andSourceCodeNotIn(List<String> values) {
            addCriterion("source_code not in", values, "sourceCode");
            return (Criteria) this;
        }

        public Criteria andSourceCodeBetween(String value1, String value2) {
            addCriterion("source_code between", value1, value2, "sourceCode");
            return (Criteria) this;
        }

        public Criteria andSourceCodeNotBetween(String value1, String value2) {
            addCriterion("source_code not between", value1, value2, "sourceCode");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIsNull() {
            addCriterion("company_id is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIsNotNull() {
            addCriterion("company_id is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdEqualTo(Byte value) {
            addCriterion("company_id =", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotEqualTo(Byte value) {
            addCriterion("company_id <>", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThan(Byte value) {
            addCriterion("company_id >", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThanOrEqualTo(Byte value) {
            addCriterion("company_id >=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThan(Byte value) {
            addCriterion("company_id <", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThanOrEqualTo(Byte value) {
            addCriterion("company_id <=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIn(List<Byte> values) {
            addCriterion("company_id in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotIn(List<Byte> values) {
            addCriterion("company_id not in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdBetween(Byte value1, Byte value2) {
            addCriterion("company_id between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotBetween(Byte value1, Byte value2) {
            addCriterion("company_id not between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andChannelIdIsNull() {
            addCriterion("channel_id is null");
            return (Criteria) this;
        }

        public Criteria andChannelIdIsNotNull() {
            addCriterion("channel_id is not null");
            return (Criteria) this;
        }

        public Criteria andChannelIdEqualTo(Integer value) {
            addCriterion("channel_id =", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotEqualTo(Integer value) {
            addCriterion("channel_id <>", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdGreaterThan(Integer value) {
            addCriterion("channel_id >", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("channel_id >=", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdLessThan(Integer value) {
            addCriterion("channel_id <", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdLessThanOrEqualTo(Integer value) {
            addCriterion("channel_id <=", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdIn(List<Integer> values) {
            addCriterion("channel_id in", values, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotIn(List<Integer> values) {
            addCriterion("channel_id not in", values, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdBetween(Integer value1, Integer value2) {
            addCriterion("channel_id between", value1, value2, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotBetween(Integer value1, Integer value2) {
            addCriterion("channel_id not between", value1, value2, "channelId");
            return (Criteria) this;
        }

        public Criteria andTciStartDateIsNull() {
            addCriterion("tci_start_date is null");
            return (Criteria) this;
        }

        public Criteria andTciStartDateIsNotNull() {
            addCriterion("tci_start_date is not null");
            return (Criteria) this;
        }

        public Criteria andTciStartDateEqualTo(Date value) {
            addCriterionForJDBCDate("tci_start_date =", value, "tciStartDate");
            return (Criteria) this;
        }

        public Criteria andTciStartDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("tci_start_date <>", value, "tciStartDate");
            return (Criteria) this;
        }

        public Criteria andTciStartDateGreaterThan(Date value) {
            addCriterionForJDBCDate("tci_start_date >", value, "tciStartDate");
            return (Criteria) this;
        }

        public Criteria andTciStartDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("tci_start_date >=", value, "tciStartDate");
            return (Criteria) this;
        }

        public Criteria andTciStartDateLessThan(Date value) {
            addCriterionForJDBCDate("tci_start_date <", value, "tciStartDate");
            return (Criteria) this;
        }

        public Criteria andTciStartDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("tci_start_date <=", value, "tciStartDate");
            return (Criteria) this;
        }

        public Criteria andTciStartDateIn(List<Date> values) {
            addCriterionForJDBCDate("tci_start_date in", values, "tciStartDate");
            return (Criteria) this;
        }

        public Criteria andTciStartDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("tci_start_date not in", values, "tciStartDate");
            return (Criteria) this;
        }

        public Criteria andTciStartDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("tci_start_date between", value1, value2, "tciStartDate");
            return (Criteria) this;
        }

        public Criteria andTciStartDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("tci_start_date not between", value1, value2, "tciStartDate");
            return (Criteria) this;
        }

        public Criteria andTciEndDateIsNull() {
            addCriterion("tci_end_date is null");
            return (Criteria) this;
        }

        public Criteria andTciEndDateIsNotNull() {
            addCriterion("tci_end_date is not null");
            return (Criteria) this;
        }

        public Criteria andTciEndDateEqualTo(Date value) {
            addCriterionForJDBCDate("tci_end_date =", value, "tciEndDate");
            return (Criteria) this;
        }

        public Criteria andTciEndDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("tci_end_date <>", value, "tciEndDate");
            return (Criteria) this;
        }

        public Criteria andTciEndDateGreaterThan(Date value) {
            addCriterionForJDBCDate("tci_end_date >", value, "tciEndDate");
            return (Criteria) this;
        }

        public Criteria andTciEndDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("tci_end_date >=", value, "tciEndDate");
            return (Criteria) this;
        }

        public Criteria andTciEndDateLessThan(Date value) {
            addCriterionForJDBCDate("tci_end_date <", value, "tciEndDate");
            return (Criteria) this;
        }

        public Criteria andTciEndDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("tci_end_date <=", value, "tciEndDate");
            return (Criteria) this;
        }

        public Criteria andTciEndDateIn(List<Date> values) {
            addCriterionForJDBCDate("tci_end_date in", values, "tciEndDate");
            return (Criteria) this;
        }

        public Criteria andTciEndDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("tci_end_date not in", values, "tciEndDate");
            return (Criteria) this;
        }

        public Criteria andTciEndDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("tci_end_date between", value1, value2, "tciEndDate");
            return (Criteria) this;
        }

        public Criteria andTciEndDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("tci_end_date not between", value1, value2, "tciEndDate");
            return (Criteria) this;
        }

        public Criteria andVciStartDateIsNull() {
            addCriterion("vci_start_date is null");
            return (Criteria) this;
        }

        public Criteria andVciStartDateIsNotNull() {
            addCriterion("vci_start_date is not null");
            return (Criteria) this;
        }

        public Criteria andVciStartDateEqualTo(Date value) {
            addCriterionForJDBCDate("vci_start_date =", value, "vciStartDate");
            return (Criteria) this;
        }

        public Criteria andVciStartDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("vci_start_date <>", value, "vciStartDate");
            return (Criteria) this;
        }

        public Criteria andVciStartDateGreaterThan(Date value) {
            addCriterionForJDBCDate("vci_start_date >", value, "vciStartDate");
            return (Criteria) this;
        }

        public Criteria andVciStartDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("vci_start_date >=", value, "vciStartDate");
            return (Criteria) this;
        }

        public Criteria andVciStartDateLessThan(Date value) {
            addCriterionForJDBCDate("vci_start_date <", value, "vciStartDate");
            return (Criteria) this;
        }

        public Criteria andVciStartDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("vci_start_date <=", value, "vciStartDate");
            return (Criteria) this;
        }

        public Criteria andVciStartDateIn(List<Date> values) {
            addCriterionForJDBCDate("vci_start_date in", values, "vciStartDate");
            return (Criteria) this;
        }

        public Criteria andVciStartDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("vci_start_date not in", values, "vciStartDate");
            return (Criteria) this;
        }

        public Criteria andVciStartDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("vci_start_date between", value1, value2, "vciStartDate");
            return (Criteria) this;
        }

        public Criteria andVciStartDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("vci_start_date not between", value1, value2, "vciStartDate");
            return (Criteria) this;
        }

        public Criteria andVciEndDateIsNull() {
            addCriterion("vci_end_date is null");
            return (Criteria) this;
        }

        public Criteria andVciEndDateIsNotNull() {
            addCriterion("vci_end_date is not null");
            return (Criteria) this;
        }

        public Criteria andVciEndDateEqualTo(Date value) {
            addCriterionForJDBCDate("vci_end_date =", value, "vciEndDate");
            return (Criteria) this;
        }

        public Criteria andVciEndDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("vci_end_date <>", value, "vciEndDate");
            return (Criteria) this;
        }

        public Criteria andVciEndDateGreaterThan(Date value) {
            addCriterionForJDBCDate("vci_end_date >", value, "vciEndDate");
            return (Criteria) this;
        }

        public Criteria andVciEndDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("vci_end_date >=", value, "vciEndDate");
            return (Criteria) this;
        }

        public Criteria andVciEndDateLessThan(Date value) {
            addCriterionForJDBCDate("vci_end_date <", value, "vciEndDate");
            return (Criteria) this;
        }

        public Criteria andVciEndDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("vci_end_date <=", value, "vciEndDate");
            return (Criteria) this;
        }

        public Criteria andVciEndDateIn(List<Date> values) {
            addCriterionForJDBCDate("vci_end_date in", values, "vciEndDate");
            return (Criteria) this;
        }

        public Criteria andVciEndDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("vci_end_date not in", values, "vciEndDate");
            return (Criteria) this;
        }

        public Criteria andVciEndDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("vci_end_date between", value1, value2, "vciEndDate");
            return (Criteria) this;
        }

        public Criteria andVciEndDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("vci_end_date not between", value1, value2, "vciEndDate");
            return (Criteria) this;
        }

        public Criteria andTotalPremiumIsNull() {
            addCriterion("total_premium is null");
            return (Criteria) this;
        }

        public Criteria andTotalPremiumIsNotNull() {
            addCriterion("total_premium is not null");
            return (Criteria) this;
        }

        public Criteria andTotalPremiumEqualTo(Double value) {
            addCriterion("total_premium =", value, "totalPremium");
            return (Criteria) this;
        }

        public Criteria andTotalPremiumNotEqualTo(Double value) {
            addCriterion("total_premium <>", value, "totalPremium");
            return (Criteria) this;
        }

        public Criteria andTotalPremiumGreaterThan(Double value) {
            addCriterion("total_premium >", value, "totalPremium");
            return (Criteria) this;
        }

        public Criteria andTotalPremiumGreaterThanOrEqualTo(Double value) {
            addCriterion("total_premium >=", value, "totalPremium");
            return (Criteria) this;
        }

        public Criteria andTotalPremiumLessThan(Double value) {
            addCriterion("total_premium <", value, "totalPremium");
            return (Criteria) this;
        }

        public Criteria andTotalPremiumLessThanOrEqualTo(Double value) {
            addCriterion("total_premium <=", value, "totalPremium");
            return (Criteria) this;
        }

        public Criteria andTotalPremiumIn(List<Double> values) {
            addCriterion("total_premium in", values, "totalPremium");
            return (Criteria) this;
        }

        public Criteria andTotalPremiumNotIn(List<Double> values) {
            addCriterion("total_premium not in", values, "totalPremium");
            return (Criteria) this;
        }

        public Criteria andTotalPremiumBetween(Double value1, Double value2) {
            addCriterion("total_premium between", value1, value2, "totalPremium");
            return (Criteria) this;
        }

        public Criteria andTotalPremiumNotBetween(Double value1, Double value2) {
            addCriterion("total_premium not between", value1, value2, "totalPremium");
            return (Criteria) this;
        }

        public Criteria andTciPremiumIsNull() {
            addCriterion("tci_premium is null");
            return (Criteria) this;
        }

        public Criteria andTciPremiumIsNotNull() {
            addCriterion("tci_premium is not null");
            return (Criteria) this;
        }

        public Criteria andTciPremiumEqualTo(Double value) {
            addCriterion("tci_premium =", value, "tciPremium");
            return (Criteria) this;
        }

        public Criteria andTciPremiumNotEqualTo(Double value) {
            addCriterion("tci_premium <>", value, "tciPremium");
            return (Criteria) this;
        }

        public Criteria andTciPremiumGreaterThan(Double value) {
            addCriterion("tci_premium >", value, "tciPremium");
            return (Criteria) this;
        }

        public Criteria andTciPremiumGreaterThanOrEqualTo(Double value) {
            addCriterion("tci_premium >=", value, "tciPremium");
            return (Criteria) this;
        }

        public Criteria andTciPremiumLessThan(Double value) {
            addCriterion("tci_premium <", value, "tciPremium");
            return (Criteria) this;
        }

        public Criteria andTciPremiumLessThanOrEqualTo(Double value) {
            addCriterion("tci_premium <=", value, "tciPremium");
            return (Criteria) this;
        }

        public Criteria andTciPremiumIn(List<Double> values) {
            addCriterion("tci_premium in", values, "tciPremium");
            return (Criteria) this;
        }

        public Criteria andTciPremiumNotIn(List<Double> values) {
            addCriterion("tci_premium not in", values, "tciPremium");
            return (Criteria) this;
        }

        public Criteria andTciPremiumBetween(Double value1, Double value2) {
            addCriterion("tci_premium between", value1, value2, "tciPremium");
            return (Criteria) this;
        }

        public Criteria andTciPremiumNotBetween(Double value1, Double value2) {
            addCriterion("tci_premium not between", value1, value2, "tciPremium");
            return (Criteria) this;
        }

        public Criteria andVciPremiumIsNull() {
            addCriterion("vci_premium is null");
            return (Criteria) this;
        }

        public Criteria andVciPremiumIsNotNull() {
            addCriterion("vci_premium is not null");
            return (Criteria) this;
        }

        public Criteria andVciPremiumEqualTo(Double value) {
            addCriterion("vci_premium =", value, "vciPremium");
            return (Criteria) this;
        }

        public Criteria andVciPremiumNotEqualTo(Double value) {
            addCriterion("vci_premium <>", value, "vciPremium");
            return (Criteria) this;
        }

        public Criteria andVciPremiumGreaterThan(Double value) {
            addCriterion("vci_premium >", value, "vciPremium");
            return (Criteria) this;
        }

        public Criteria andVciPremiumGreaterThanOrEqualTo(Double value) {
            addCriterion("vci_premium >=", value, "vciPremium");
            return (Criteria) this;
        }

        public Criteria andVciPremiumLessThan(Double value) {
            addCriterion("vci_premium <", value, "vciPremium");
            return (Criteria) this;
        }

        public Criteria andVciPremiumLessThanOrEqualTo(Double value) {
            addCriterion("vci_premium <=", value, "vciPremium");
            return (Criteria) this;
        }

        public Criteria andVciPremiumIn(List<Double> values) {
            addCriterion("vci_premium in", values, "vciPremium");
            return (Criteria) this;
        }

        public Criteria andVciPremiumNotIn(List<Double> values) {
            addCriterion("vci_premium not in", values, "vciPremium");
            return (Criteria) this;
        }

        public Criteria andVciPremiumBetween(Double value1, Double value2) {
            addCriterion("vci_premium between", value1, value2, "vciPremium");
            return (Criteria) this;
        }

        public Criteria andVciPremiumNotBetween(Double value1, Double value2) {
            addCriterion("vci_premium not between", value1, value2, "vciPremium");
            return (Criteria) this;
        }

        public Criteria andVehicleTaxIsNull() {
            addCriterion("vehicle_tax is null");
            return (Criteria) this;
        }

        public Criteria andVehicleTaxIsNotNull() {
            addCriterion("vehicle_tax is not null");
            return (Criteria) this;
        }

        public Criteria andVehicleTaxEqualTo(Double value) {
            addCriterion("vehicle_tax =", value, "vehicleTax");
            return (Criteria) this;
        }

        public Criteria andVehicleTaxNotEqualTo(Double value) {
            addCriterion("vehicle_tax <>", value, "vehicleTax");
            return (Criteria) this;
        }

        public Criteria andVehicleTaxGreaterThan(Double value) {
            addCriterion("vehicle_tax >", value, "vehicleTax");
            return (Criteria) this;
        }

        public Criteria andVehicleTaxGreaterThanOrEqualTo(Double value) {
            addCriterion("vehicle_tax >=", value, "vehicleTax");
            return (Criteria) this;
        }

        public Criteria andVehicleTaxLessThan(Double value) {
            addCriterion("vehicle_tax <", value, "vehicleTax");
            return (Criteria) this;
        }

        public Criteria andVehicleTaxLessThanOrEqualTo(Double value) {
            addCriterion("vehicle_tax <=", value, "vehicleTax");
            return (Criteria) this;
        }

        public Criteria andVehicleTaxIn(List<Double> values) {
            addCriterion("vehicle_tax in", values, "vehicleTax");
            return (Criteria) this;
        }

        public Criteria andVehicleTaxNotIn(List<Double> values) {
            addCriterion("vehicle_tax not in", values, "vehicleTax");
            return (Criteria) this;
        }

        public Criteria andVehicleTaxBetween(Double value1, Double value2) {
            addCriterion("vehicle_tax between", value1, value2, "vehicleTax");
            return (Criteria) this;
        }

        public Criteria andVehicleTaxNotBetween(Double value1, Double value2) {
            addCriterion("vehicle_tax not between", value1, value2, "vehicleTax");
            return (Criteria) this;
        }

        public Criteria andTciLossOccurredCountIsNull() {
            addCriterion("tci_loss_occurred_count is null");
            return (Criteria) this;
        }

        public Criteria andTciLossOccurredCountIsNotNull() {
            addCriterion("tci_loss_occurred_count is not null");
            return (Criteria) this;
        }

        public Criteria andTciLossOccurredCountEqualTo(Byte value) {
            addCriterion("tci_loss_occurred_count =", value, "tciLossOccurredCount");
            return (Criteria) this;
        }

        public Criteria andTciLossOccurredCountNotEqualTo(Byte value) {
            addCriterion("tci_loss_occurred_count <>", value, "tciLossOccurredCount");
            return (Criteria) this;
        }

        public Criteria andTciLossOccurredCountGreaterThan(Byte value) {
            addCriterion("tci_loss_occurred_count >", value, "tciLossOccurredCount");
            return (Criteria) this;
        }

        public Criteria andTciLossOccurredCountGreaterThanOrEqualTo(Byte value) {
            addCriterion("tci_loss_occurred_count >=", value, "tciLossOccurredCount");
            return (Criteria) this;
        }

        public Criteria andTciLossOccurredCountLessThan(Byte value) {
            addCriterion("tci_loss_occurred_count <", value, "tciLossOccurredCount");
            return (Criteria) this;
        }

        public Criteria andTciLossOccurredCountLessThanOrEqualTo(Byte value) {
            addCriterion("tci_loss_occurred_count <=", value, "tciLossOccurredCount");
            return (Criteria) this;
        }

        public Criteria andTciLossOccurredCountIn(List<Byte> values) {
            addCriterion("tci_loss_occurred_count in", values, "tciLossOccurredCount");
            return (Criteria) this;
        }

        public Criteria andTciLossOccurredCountNotIn(List<Byte> values) {
            addCriterion("tci_loss_occurred_count not in", values, "tciLossOccurredCount");
            return (Criteria) this;
        }

        public Criteria andTciLossOccurredCountBetween(Byte value1, Byte value2) {
            addCriterion("tci_loss_occurred_count between", value1, value2, "tciLossOccurredCount");
            return (Criteria) this;
        }

        public Criteria andTciLossOccurredCountNotBetween(Byte value1, Byte value2) {
            addCriterion("tci_loss_occurred_count not between", value1, value2, "tciLossOccurredCount");
            return (Criteria) this;
        }

        public Criteria andVciLossOccurredCountIsNull() {
            addCriterion("vci_loss_occurred_count is null");
            return (Criteria) this;
        }

        public Criteria andVciLossOccurredCountIsNotNull() {
            addCriterion("vci_loss_occurred_count is not null");
            return (Criteria) this;
        }

        public Criteria andVciLossOccurredCountEqualTo(Byte value) {
            addCriterion("vci_loss_occurred_count =", value, "vciLossOccurredCount");
            return (Criteria) this;
        }

        public Criteria andVciLossOccurredCountNotEqualTo(Byte value) {
            addCriterion("vci_loss_occurred_count <>", value, "vciLossOccurredCount");
            return (Criteria) this;
        }

        public Criteria andVciLossOccurredCountGreaterThan(Byte value) {
            addCriterion("vci_loss_occurred_count >", value, "vciLossOccurredCount");
            return (Criteria) this;
        }

        public Criteria andVciLossOccurredCountGreaterThanOrEqualTo(Byte value) {
            addCriterion("vci_loss_occurred_count >=", value, "vciLossOccurredCount");
            return (Criteria) this;
        }

        public Criteria andVciLossOccurredCountLessThan(Byte value) {
            addCriterion("vci_loss_occurred_count <", value, "vciLossOccurredCount");
            return (Criteria) this;
        }

        public Criteria andVciLossOccurredCountLessThanOrEqualTo(Byte value) {
            addCriterion("vci_loss_occurred_count <=", value, "vciLossOccurredCount");
            return (Criteria) this;
        }

        public Criteria andVciLossOccurredCountIn(List<Byte> values) {
            addCriterion("vci_loss_occurred_count in", values, "vciLossOccurredCount");
            return (Criteria) this;
        }

        public Criteria andVciLossOccurredCountNotIn(List<Byte> values) {
            addCriterion("vci_loss_occurred_count not in", values, "vciLossOccurredCount");
            return (Criteria) this;
        }

        public Criteria andVciLossOccurredCountBetween(Byte value1, Byte value2) {
            addCriterion("vci_loss_occurred_count between", value1, value2, "vciLossOccurredCount");
            return (Criteria) this;
        }

        public Criteria andVciLossOccurredCountNotBetween(Byte value1, Byte value2) {
            addCriterion("vci_loss_occurred_count not between", value1, value2, "vciLossOccurredCount");
            return (Criteria) this;
        }

        public Criteria andTciDiscountIsNull() {
            addCriterion("tci_discount is null");
            return (Criteria) this;
        }

        public Criteria andTciDiscountIsNotNull() {
            addCriterion("tci_discount is not null");
            return (Criteria) this;
        }

        public Criteria andTciDiscountEqualTo(Double value) {
            addCriterion("tci_discount =", value, "tciDiscount");
            return (Criteria) this;
        }

        public Criteria andTciDiscountNotEqualTo(Double value) {
            addCriterion("tci_discount <>", value, "tciDiscount");
            return (Criteria) this;
        }

        public Criteria andTciDiscountGreaterThan(Double value) {
            addCriterion("tci_discount >", value, "tciDiscount");
            return (Criteria) this;
        }

        public Criteria andTciDiscountGreaterThanOrEqualTo(Double value) {
            addCriterion("tci_discount >=", value, "tciDiscount");
            return (Criteria) this;
        }

        public Criteria andTciDiscountLessThan(Double value) {
            addCriterion("tci_discount <", value, "tciDiscount");
            return (Criteria) this;
        }

        public Criteria andTciDiscountLessThanOrEqualTo(Double value) {
            addCriterion("tci_discount <=", value, "tciDiscount");
            return (Criteria) this;
        }

        public Criteria andTciDiscountIn(List<Double> values) {
            addCriterion("tci_discount in", values, "tciDiscount");
            return (Criteria) this;
        }

        public Criteria andTciDiscountNotIn(List<Double> values) {
            addCriterion("tci_discount not in", values, "tciDiscount");
            return (Criteria) this;
        }

        public Criteria andTciDiscountBetween(Double value1, Double value2) {
            addCriterion("tci_discount between", value1, value2, "tciDiscount");
            return (Criteria) this;
        }

        public Criteria andTciDiscountNotBetween(Double value1, Double value2) {
            addCriterion("tci_discount not between", value1, value2, "tciDiscount");
            return (Criteria) this;
        }

        public Criteria andVciDiscountIsNull() {
            addCriterion("vci_discount is null");
            return (Criteria) this;
        }

        public Criteria andVciDiscountIsNotNull() {
            addCriterion("vci_discount is not null");
            return (Criteria) this;
        }

        public Criteria andVciDiscountEqualTo(Double value) {
            addCriterion("vci_discount =", value, "vciDiscount");
            return (Criteria) this;
        }

        public Criteria andVciDiscountNotEqualTo(Double value) {
            addCriterion("vci_discount <>", value, "vciDiscount");
            return (Criteria) this;
        }

        public Criteria andVciDiscountGreaterThan(Double value) {
            addCriterion("vci_discount >", value, "vciDiscount");
            return (Criteria) this;
        }

        public Criteria andVciDiscountGreaterThanOrEqualTo(Double value) {
            addCriterion("vci_discount >=", value, "vciDiscount");
            return (Criteria) this;
        }

        public Criteria andVciDiscountLessThan(Double value) {
            addCriterion("vci_discount <", value, "vciDiscount");
            return (Criteria) this;
        }

        public Criteria andVciDiscountLessThanOrEqualTo(Double value) {
            addCriterion("vci_discount <=", value, "vciDiscount");
            return (Criteria) this;
        }

        public Criteria andVciDiscountIn(List<Double> values) {
            addCriterion("vci_discount in", values, "vciDiscount");
            return (Criteria) this;
        }

        public Criteria andVciDiscountNotIn(List<Double> values) {
            addCriterion("vci_discount not in", values, "vciDiscount");
            return (Criteria) this;
        }

        public Criteria andVciDiscountBetween(Double value1, Double value2) {
            addCriterion("vci_discount between", value1, value2, "vciDiscount");
            return (Criteria) this;
        }

        public Criteria andVciDiscountNotBetween(Double value1, Double value2) {
            addCriterion("vci_discount not between", value1, value2, "vciDiscount");
            return (Criteria) this;
        }

        public Criteria andTciCommissionIsNull() {
            addCriterion("tci_commission is null");
            return (Criteria) this;
        }

        public Criteria andTciCommissionIsNotNull() {
            addCriterion("tci_commission is not null");
            return (Criteria) this;
        }

        public Criteria andTciCommissionEqualTo(Double value) {
            addCriterion("tci_commission =", value, "tciCommission");
            return (Criteria) this;
        }

        public Criteria andTciCommissionNotEqualTo(Double value) {
            addCriterion("tci_commission <>", value, "tciCommission");
            return (Criteria) this;
        }

        public Criteria andTciCommissionGreaterThan(Double value) {
            addCriterion("tci_commission >", value, "tciCommission");
            return (Criteria) this;
        }

        public Criteria andTciCommissionGreaterThanOrEqualTo(Double value) {
            addCriterion("tci_commission >=", value, "tciCommission");
            return (Criteria) this;
        }

        public Criteria andTciCommissionLessThan(Double value) {
            addCriterion("tci_commission <", value, "tciCommission");
            return (Criteria) this;
        }

        public Criteria andTciCommissionLessThanOrEqualTo(Double value) {
            addCriterion("tci_commission <=", value, "tciCommission");
            return (Criteria) this;
        }

        public Criteria andTciCommissionIn(List<Double> values) {
            addCriterion("tci_commission in", values, "tciCommission");
            return (Criteria) this;
        }

        public Criteria andTciCommissionNotIn(List<Double> values) {
            addCriterion("tci_commission not in", values, "tciCommission");
            return (Criteria) this;
        }

        public Criteria andTciCommissionBetween(Double value1, Double value2) {
            addCriterion("tci_commission between", value1, value2, "tciCommission");
            return (Criteria) this;
        }

        public Criteria andTciCommissionNotBetween(Double value1, Double value2) {
            addCriterion("tci_commission not between", value1, value2, "tciCommission");
            return (Criteria) this;
        }

        public Criteria andVciCommissionIsNull() {
            addCriterion("vci_commission is null");
            return (Criteria) this;
        }

        public Criteria andVciCommissionIsNotNull() {
            addCriterion("vci_commission is not null");
            return (Criteria) this;
        }

        public Criteria andVciCommissionEqualTo(Double value) {
            addCriterion("vci_commission =", value, "vciCommission");
            return (Criteria) this;
        }

        public Criteria andVciCommissionNotEqualTo(Double value) {
            addCriterion("vci_commission <>", value, "vciCommission");
            return (Criteria) this;
        }

        public Criteria andVciCommissionGreaterThan(Double value) {
            addCriterion("vci_commission >", value, "vciCommission");
            return (Criteria) this;
        }

        public Criteria andVciCommissionGreaterThanOrEqualTo(Double value) {
            addCriterion("vci_commission >=", value, "vciCommission");
            return (Criteria) this;
        }

        public Criteria andVciCommissionLessThan(Double value) {
            addCriterion("vci_commission <", value, "vciCommission");
            return (Criteria) this;
        }

        public Criteria andVciCommissionLessThanOrEqualTo(Double value) {
            addCriterion("vci_commission <=", value, "vciCommission");
            return (Criteria) this;
        }

        public Criteria andVciCommissionIn(List<Double> values) {
            addCriterion("vci_commission in", values, "vciCommission");
            return (Criteria) this;
        }

        public Criteria andVciCommissionNotIn(List<Double> values) {
            addCriterion("vci_commission not in", values, "vciCommission");
            return (Criteria) this;
        }

        public Criteria andVciCommissionBetween(Double value1, Double value2) {
            addCriterion("vci_commission between", value1, value2, "vciCommission");
            return (Criteria) this;
        }

        public Criteria andVciCommissionNotBetween(Double value1, Double value2) {
            addCriterion("vci_commission not between", value1, value2, "vciCommission");
            return (Criteria) this;
        }

        public Criteria andReceiveNameIsNull() {
            addCriterion("receive_name is null");
            return (Criteria) this;
        }

        public Criteria andReceiveNameIsNotNull() {
            addCriterion("receive_name is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveNameEqualTo(String value) {
            addCriterion("receive_name =", value, "receiveName");
            return (Criteria) this;
        }

        public Criteria andReceiveNameNotEqualTo(String value) {
            addCriterion("receive_name <>", value, "receiveName");
            return (Criteria) this;
        }

        public Criteria andReceiveNameGreaterThan(String value) {
            addCriterion("receive_name >", value, "receiveName");
            return (Criteria) this;
        }

        public Criteria andReceiveNameGreaterThanOrEqualTo(String value) {
            addCriterion("receive_name >=", value, "receiveName");
            return (Criteria) this;
        }

        public Criteria andReceiveNameLessThan(String value) {
            addCriterion("receive_name <", value, "receiveName");
            return (Criteria) this;
        }

        public Criteria andReceiveNameLessThanOrEqualTo(String value) {
            addCriterion("receive_name <=", value, "receiveName");
            return (Criteria) this;
        }

        public Criteria andReceiveNameLike(String value) {
            addCriterion("receive_name like", value, "receiveName");
            return (Criteria) this;
        }

        public Criteria andReceiveNameNotLike(String value) {
            addCriterion("receive_name not like", value, "receiveName");
            return (Criteria) this;
        }

        public Criteria andReceiveNameIn(List<String> values) {
            addCriterion("receive_name in", values, "receiveName");
            return (Criteria) this;
        }

        public Criteria andReceiveNameNotIn(List<String> values) {
            addCriterion("receive_name not in", values, "receiveName");
            return (Criteria) this;
        }

        public Criteria andReceiveNameBetween(String value1, String value2) {
            addCriterion("receive_name between", value1, value2, "receiveName");
            return (Criteria) this;
        }

        public Criteria andReceiveNameNotBetween(String value1, String value2) {
            addCriterion("receive_name not between", value1, value2, "receiveName");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressIsNull() {
            addCriterion("receive_address is null");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressIsNotNull() {
            addCriterion("receive_address is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressEqualTo(String value) {
            addCriterion("receive_address =", value, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressNotEqualTo(String value) {
            addCriterion("receive_address <>", value, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressGreaterThan(String value) {
            addCriterion("receive_address >", value, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressGreaterThanOrEqualTo(String value) {
            addCriterion("receive_address >=", value, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressLessThan(String value) {
            addCriterion("receive_address <", value, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressLessThanOrEqualTo(String value) {
            addCriterion("receive_address <=", value, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressLike(String value) {
            addCriterion("receive_address like", value, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressNotLike(String value) {
            addCriterion("receive_address not like", value, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressIn(List<String> values) {
            addCriterion("receive_address in", values, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressNotIn(List<String> values) {
            addCriterion("receive_address not in", values, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressBetween(String value1, String value2) {
            addCriterion("receive_address between", value1, value2, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressNotBetween(String value1, String value2) {
            addCriterion("receive_address not between", value1, value2, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceivePhoneIsNull() {
            addCriterion("receive_phone is null");
            return (Criteria) this;
        }

        public Criteria andReceivePhoneIsNotNull() {
            addCriterion("receive_phone is not null");
            return (Criteria) this;
        }

        public Criteria andReceivePhoneEqualTo(String value) {
            addCriterion("receive_phone =", value, "receivePhone");
            return (Criteria) this;
        }

        public Criteria andReceivePhoneNotEqualTo(String value) {
            addCriterion("receive_phone <>", value, "receivePhone");
            return (Criteria) this;
        }

        public Criteria andReceivePhoneGreaterThan(String value) {
            addCriterion("receive_phone >", value, "receivePhone");
            return (Criteria) this;
        }

        public Criteria andReceivePhoneGreaterThanOrEqualTo(String value) {
            addCriterion("receive_phone >=", value, "receivePhone");
            return (Criteria) this;
        }

        public Criteria andReceivePhoneLessThan(String value) {
            addCriterion("receive_phone <", value, "receivePhone");
            return (Criteria) this;
        }

        public Criteria andReceivePhoneLessThanOrEqualTo(String value) {
            addCriterion("receive_phone <=", value, "receivePhone");
            return (Criteria) this;
        }

        public Criteria andReceivePhoneLike(String value) {
            addCriterion("receive_phone like", value, "receivePhone");
            return (Criteria) this;
        }

        public Criteria andReceivePhoneNotLike(String value) {
            addCriterion("receive_phone not like", value, "receivePhone");
            return (Criteria) this;
        }

        public Criteria andReceivePhoneIn(List<String> values) {
            addCriterion("receive_phone in", values, "receivePhone");
            return (Criteria) this;
        }

        public Criteria andReceivePhoneNotIn(List<String> values) {
            addCriterion("receive_phone not in", values, "receivePhone");
            return (Criteria) this;
        }

        public Criteria andReceivePhoneBetween(String value1, String value2) {
            addCriterion("receive_phone between", value1, value2, "receivePhone");
            return (Criteria) this;
        }

        public Criteria andReceivePhoneNotBetween(String value1, String value2) {
            addCriterion("receive_phone not between", value1, value2, "receivePhone");
            return (Criteria) this;
        }

        public Criteria andProposalNoIsNull() {
            addCriterion("proposal_no is null");
            return (Criteria) this;
        }

        public Criteria andProposalNoIsNotNull() {
            addCriterion("proposal_no is not null");
            return (Criteria) this;
        }

        public Criteria andProposalNoEqualTo(String value) {
            addCriterion("proposal_no =", value, "proposalNo");
            return (Criteria) this;
        }

        public Criteria andProposalNoNotEqualTo(String value) {
            addCriterion("proposal_no <>", value, "proposalNo");
            return (Criteria) this;
        }

        public Criteria andProposalNoGreaterThan(String value) {
            addCriterion("proposal_no >", value, "proposalNo");
            return (Criteria) this;
        }

        public Criteria andProposalNoGreaterThanOrEqualTo(String value) {
            addCriterion("proposal_no >=", value, "proposalNo");
            return (Criteria) this;
        }

        public Criteria andProposalNoLessThan(String value) {
            addCriterion("proposal_no <", value, "proposalNo");
            return (Criteria) this;
        }

        public Criteria andProposalNoLessThanOrEqualTo(String value) {
            addCriterion("proposal_no <=", value, "proposalNo");
            return (Criteria) this;
        }

        public Criteria andProposalNoLike(String value) {
            addCriterion("proposal_no like", value, "proposalNo");
            return (Criteria) this;
        }

        public Criteria andProposalNoNotLike(String value) {
            addCriterion("proposal_no not like", value, "proposalNo");
            return (Criteria) this;
        }

        public Criteria andProposalNoIn(List<String> values) {
            addCriterion("proposal_no in", values, "proposalNo");
            return (Criteria) this;
        }

        public Criteria andProposalNoNotIn(List<String> values) {
            addCriterion("proposal_no not in", values, "proposalNo");
            return (Criteria) this;
        }

        public Criteria andProposalNoBetween(String value1, String value2) {
            addCriterion("proposal_no between", value1, value2, "proposalNo");
            return (Criteria) this;
        }

        public Criteria andProposalNoNotBetween(String value1, String value2) {
            addCriterion("proposal_no not between", value1, value2, "proposalNo");
            return (Criteria) this;
        }

        public Criteria andTciProposalNoIsNull() {
            addCriterion("tci_proposal_no is null");
            return (Criteria) this;
        }

        public Criteria andTciProposalNoIsNotNull() {
            addCriterion("tci_proposal_no is not null");
            return (Criteria) this;
        }

        public Criteria andTciProposalNoEqualTo(String value) {
            addCriterion("tci_proposal_no =", value, "tciProposalNo");
            return (Criteria) this;
        }

        public Criteria andTciProposalNoNotEqualTo(String value) {
            addCriterion("tci_proposal_no <>", value, "tciProposalNo");
            return (Criteria) this;
        }

        public Criteria andTciProposalNoGreaterThan(String value) {
            addCriterion("tci_proposal_no >", value, "tciProposalNo");
            return (Criteria) this;
        }

        public Criteria andTciProposalNoGreaterThanOrEqualTo(String value) {
            addCriterion("tci_proposal_no >=", value, "tciProposalNo");
            return (Criteria) this;
        }

        public Criteria andTciProposalNoLessThan(String value) {
            addCriterion("tci_proposal_no <", value, "tciProposalNo");
            return (Criteria) this;
        }

        public Criteria andTciProposalNoLessThanOrEqualTo(String value) {
            addCriterion("tci_proposal_no <=", value, "tciProposalNo");
            return (Criteria) this;
        }

        public Criteria andTciProposalNoLike(String value) {
            addCriterion("tci_proposal_no like", value, "tciProposalNo");
            return (Criteria) this;
        }

        public Criteria andTciProposalNoNotLike(String value) {
            addCriterion("tci_proposal_no not like", value, "tciProposalNo");
            return (Criteria) this;
        }

        public Criteria andTciProposalNoIn(List<String> values) {
            addCriterion("tci_proposal_no in", values, "tciProposalNo");
            return (Criteria) this;
        }

        public Criteria andTciProposalNoNotIn(List<String> values) {
            addCriterion("tci_proposal_no not in", values, "tciProposalNo");
            return (Criteria) this;
        }

        public Criteria andTciProposalNoBetween(String value1, String value2) {
            addCriterion("tci_proposal_no between", value1, value2, "tciProposalNo");
            return (Criteria) this;
        }

        public Criteria andTciProposalNoNotBetween(String value1, String value2) {
            addCriterion("tci_proposal_no not between", value1, value2, "tciProposalNo");
            return (Criteria) this;
        }

        public Criteria andVciProposalNoIsNull() {
            addCriterion("vci_proposal_no is null");
            return (Criteria) this;
        }

        public Criteria andVciProposalNoIsNotNull() {
            addCriterion("vci_proposal_no is not null");
            return (Criteria) this;
        }

        public Criteria andVciProposalNoEqualTo(String value) {
            addCriterion("vci_proposal_no =", value, "vciProposalNo");
            return (Criteria) this;
        }

        public Criteria andVciProposalNoNotEqualTo(String value) {
            addCriterion("vci_proposal_no <>", value, "vciProposalNo");
            return (Criteria) this;
        }

        public Criteria andVciProposalNoGreaterThan(String value) {
            addCriterion("vci_proposal_no >", value, "vciProposalNo");
            return (Criteria) this;
        }

        public Criteria andVciProposalNoGreaterThanOrEqualTo(String value) {
            addCriterion("vci_proposal_no >=", value, "vciProposalNo");
            return (Criteria) this;
        }

        public Criteria andVciProposalNoLessThan(String value) {
            addCriterion("vci_proposal_no <", value, "vciProposalNo");
            return (Criteria) this;
        }

        public Criteria andVciProposalNoLessThanOrEqualTo(String value) {
            addCriterion("vci_proposal_no <=", value, "vciProposalNo");
            return (Criteria) this;
        }

        public Criteria andVciProposalNoLike(String value) {
            addCriterion("vci_proposal_no like", value, "vciProposalNo");
            return (Criteria) this;
        }

        public Criteria andVciProposalNoNotLike(String value) {
            addCriterion("vci_proposal_no not like", value, "vciProposalNo");
            return (Criteria) this;
        }

        public Criteria andVciProposalNoIn(List<String> values) {
            addCriterion("vci_proposal_no in", values, "vciProposalNo");
            return (Criteria) this;
        }

        public Criteria andVciProposalNoNotIn(List<String> values) {
            addCriterion("vci_proposal_no not in", values, "vciProposalNo");
            return (Criteria) this;
        }

        public Criteria andVciProposalNoBetween(String value1, String value2) {
            addCriterion("vci_proposal_no between", value1, value2, "vciProposalNo");
            return (Criteria) this;
        }

        public Criteria andVciProposalNoNotBetween(String value1, String value2) {
            addCriterion("vci_proposal_no not between", value1, value2, "vciProposalNo");
            return (Criteria) this;
        }

        public Criteria andPayNoIsNull() {
            addCriterion("pay_no is null");
            return (Criteria) this;
        }

        public Criteria andPayNoIsNotNull() {
            addCriterion("pay_no is not null");
            return (Criteria) this;
        }

        public Criteria andPayNoEqualTo(String value) {
            addCriterion("pay_no =", value, "payNo");
            return (Criteria) this;
        }

        public Criteria andPayNoNotEqualTo(String value) {
            addCriterion("pay_no <>", value, "payNo");
            return (Criteria) this;
        }

        public Criteria andPayNoGreaterThan(String value) {
            addCriterion("pay_no >", value, "payNo");
            return (Criteria) this;
        }

        public Criteria andPayNoGreaterThanOrEqualTo(String value) {
            addCriterion("pay_no >=", value, "payNo");
            return (Criteria) this;
        }

        public Criteria andPayNoLessThan(String value) {
            addCriterion("pay_no <", value, "payNo");
            return (Criteria) this;
        }

        public Criteria andPayNoLessThanOrEqualTo(String value) {
            addCriterion("pay_no <=", value, "payNo");
            return (Criteria) this;
        }

        public Criteria andPayNoLike(String value) {
            addCriterion("pay_no like", value, "payNo");
            return (Criteria) this;
        }

        public Criteria andPayNoNotLike(String value) {
            addCriterion("pay_no not like", value, "payNo");
            return (Criteria) this;
        }

        public Criteria andPayNoIn(List<String> values) {
            addCriterion("pay_no in", values, "payNo");
            return (Criteria) this;
        }

        public Criteria andPayNoNotIn(List<String> values) {
            addCriterion("pay_no not in", values, "payNo");
            return (Criteria) this;
        }

        public Criteria andPayNoBetween(String value1, String value2) {
            addCriterion("pay_no between", value1, value2, "payNo");
            return (Criteria) this;
        }

        public Criteria andPayNoNotBetween(String value1, String value2) {
            addCriterion("pay_no not between", value1, value2, "payNo");
            return (Criteria) this;
        }

        public Criteria andPolicyNoIsNull() {
            addCriterion("policy_no is null");
            return (Criteria) this;
        }

        public Criteria andPolicyNoIsNotNull() {
            addCriterion("policy_no is not null");
            return (Criteria) this;
        }

        public Criteria andPolicyNoEqualTo(String value) {
            addCriterion("policy_no =", value, "policyNo");
            return (Criteria) this;
        }

        public Criteria andPolicyNoNotEqualTo(String value) {
            addCriterion("policy_no <>", value, "policyNo");
            return (Criteria) this;
        }

        public Criteria andPolicyNoGreaterThan(String value) {
            addCriterion("policy_no >", value, "policyNo");
            return (Criteria) this;
        }

        public Criteria andPolicyNoGreaterThanOrEqualTo(String value) {
            addCriterion("policy_no >=", value, "policyNo");
            return (Criteria) this;
        }

        public Criteria andPolicyNoLessThan(String value) {
            addCriterion("policy_no <", value, "policyNo");
            return (Criteria) this;
        }

        public Criteria andPolicyNoLessThanOrEqualTo(String value) {
            addCriterion("policy_no <=", value, "policyNo");
            return (Criteria) this;
        }

        public Criteria andPolicyNoLike(String value) {
            addCriterion("policy_no like", value, "policyNo");
            return (Criteria) this;
        }

        public Criteria andPolicyNoNotLike(String value) {
            addCriterion("policy_no not like", value, "policyNo");
            return (Criteria) this;
        }

        public Criteria andPolicyNoIn(List<String> values) {
            addCriterion("policy_no in", values, "policyNo");
            return (Criteria) this;
        }

        public Criteria andPolicyNoNotIn(List<String> values) {
            addCriterion("policy_no not in", values, "policyNo");
            return (Criteria) this;
        }

        public Criteria andPolicyNoBetween(String value1, String value2) {
            addCriterion("policy_no between", value1, value2, "policyNo");
            return (Criteria) this;
        }

        public Criteria andPolicyNoNotBetween(String value1, String value2) {
            addCriterion("policy_no not between", value1, value2, "policyNo");
            return (Criteria) this;
        }

        public Criteria andTciPolicyNoIsNull() {
            addCriterion("tci_policy_no is null");
            return (Criteria) this;
        }

        public Criteria andTciPolicyNoIsNotNull() {
            addCriterion("tci_policy_no is not null");
            return (Criteria) this;
        }

        public Criteria andTciPolicyNoEqualTo(String value) {
            addCriterion("tci_policy_no =", value, "tciPolicyNo");
            return (Criteria) this;
        }

        public Criteria andTciPolicyNoNotEqualTo(String value) {
            addCriterion("tci_policy_no <>", value, "tciPolicyNo");
            return (Criteria) this;
        }

        public Criteria andTciPolicyNoGreaterThan(String value) {
            addCriterion("tci_policy_no >", value, "tciPolicyNo");
            return (Criteria) this;
        }

        public Criteria andTciPolicyNoGreaterThanOrEqualTo(String value) {
            addCriterion("tci_policy_no >=", value, "tciPolicyNo");
            return (Criteria) this;
        }

        public Criteria andTciPolicyNoLessThan(String value) {
            addCriterion("tci_policy_no <", value, "tciPolicyNo");
            return (Criteria) this;
        }

        public Criteria andTciPolicyNoLessThanOrEqualTo(String value) {
            addCriterion("tci_policy_no <=", value, "tciPolicyNo");
            return (Criteria) this;
        }

        public Criteria andTciPolicyNoLike(String value) {
            addCriterion("tci_policy_no like", value, "tciPolicyNo");
            return (Criteria) this;
        }

        public Criteria andTciPolicyNoNotLike(String value) {
            addCriterion("tci_policy_no not like", value, "tciPolicyNo");
            return (Criteria) this;
        }

        public Criteria andTciPolicyNoIn(List<String> values) {
            addCriterion("tci_policy_no in", values, "tciPolicyNo");
            return (Criteria) this;
        }

        public Criteria andTciPolicyNoNotIn(List<String> values) {
            addCriterion("tci_policy_no not in", values, "tciPolicyNo");
            return (Criteria) this;
        }

        public Criteria andTciPolicyNoBetween(String value1, String value2) {
            addCriterion("tci_policy_no between", value1, value2, "tciPolicyNo");
            return (Criteria) this;
        }

        public Criteria andTciPolicyNoNotBetween(String value1, String value2) {
            addCriterion("tci_policy_no not between", value1, value2, "tciPolicyNo");
            return (Criteria) this;
        }

        public Criteria andVciPolicyNoIsNull() {
            addCriterion("vci_policy_no is null");
            return (Criteria) this;
        }

        public Criteria andVciPolicyNoIsNotNull() {
            addCriterion("vci_policy_no is not null");
            return (Criteria) this;
        }

        public Criteria andVciPolicyNoEqualTo(String value) {
            addCriterion("vci_policy_no =", value, "vciPolicyNo");
            return (Criteria) this;
        }

        public Criteria andVciPolicyNoNotEqualTo(String value) {
            addCriterion("vci_policy_no <>", value, "vciPolicyNo");
            return (Criteria) this;
        }

        public Criteria andVciPolicyNoGreaterThan(String value) {
            addCriterion("vci_policy_no >", value, "vciPolicyNo");
            return (Criteria) this;
        }

        public Criteria andVciPolicyNoGreaterThanOrEqualTo(String value) {
            addCriterion("vci_policy_no >=", value, "vciPolicyNo");
            return (Criteria) this;
        }

        public Criteria andVciPolicyNoLessThan(String value) {
            addCriterion("vci_policy_no <", value, "vciPolicyNo");
            return (Criteria) this;
        }

        public Criteria andVciPolicyNoLessThanOrEqualTo(String value) {
            addCriterion("vci_policy_no <=", value, "vciPolicyNo");
            return (Criteria) this;
        }

        public Criteria andVciPolicyNoLike(String value) {
            addCriterion("vci_policy_no like", value, "vciPolicyNo");
            return (Criteria) this;
        }

        public Criteria andVciPolicyNoNotLike(String value) {
            addCriterion("vci_policy_no not like", value, "vciPolicyNo");
            return (Criteria) this;
        }

        public Criteria andVciPolicyNoIn(List<String> values) {
            addCriterion("vci_policy_no in", values, "vciPolicyNo");
            return (Criteria) this;
        }

        public Criteria andVciPolicyNoNotIn(List<String> values) {
            addCriterion("vci_policy_no not in", values, "vciPolicyNo");
            return (Criteria) this;
        }

        public Criteria andVciPolicyNoBetween(String value1, String value2) {
            addCriterion("vci_policy_no between", value1, value2, "vciPolicyNo");
            return (Criteria) this;
        }

        public Criteria andVciPolicyNoNotBetween(String value1, String value2) {
            addCriterion("vci_policy_no not between", value1, value2, "vciPolicyNo");
            return (Criteria) this;
        }

        public Criteria andTciPolicyStatusIsNull() {
            addCriterion("tci_policy_status is null");
            return (Criteria) this;
        }

        public Criteria andTciPolicyStatusIsNotNull() {
            addCriterion("tci_policy_status is not null");
            return (Criteria) this;
        }

        public Criteria andTciPolicyStatusEqualTo(Byte value) {
            addCriterion("tci_policy_status =", value, "tciPolicyStatus");
            return (Criteria) this;
        }

        public Criteria andTciPolicyStatusNotEqualTo(Byte value) {
            addCriterion("tci_policy_status <>", value, "tciPolicyStatus");
            return (Criteria) this;
        }

        public Criteria andTciPolicyStatusGreaterThan(Byte value) {
            addCriterion("tci_policy_status >", value, "tciPolicyStatus");
            return (Criteria) this;
        }

        public Criteria andTciPolicyStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("tci_policy_status >=", value, "tciPolicyStatus");
            return (Criteria) this;
        }

        public Criteria andTciPolicyStatusLessThan(Byte value) {
            addCriterion("tci_policy_status <", value, "tciPolicyStatus");
            return (Criteria) this;
        }

        public Criteria andTciPolicyStatusLessThanOrEqualTo(Byte value) {
            addCriterion("tci_policy_status <=", value, "tciPolicyStatus");
            return (Criteria) this;
        }

        public Criteria andTciPolicyStatusIn(List<Byte> values) {
            addCriterion("tci_policy_status in", values, "tciPolicyStatus");
            return (Criteria) this;
        }

        public Criteria andTciPolicyStatusNotIn(List<Byte> values) {
            addCriterion("tci_policy_status not in", values, "tciPolicyStatus");
            return (Criteria) this;
        }

        public Criteria andTciPolicyStatusBetween(Byte value1, Byte value2) {
            addCriterion("tci_policy_status between", value1, value2, "tciPolicyStatus");
            return (Criteria) this;
        }

        public Criteria andTciPolicyStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("tci_policy_status not between", value1, value2, "tciPolicyStatus");
            return (Criteria) this;
        }

        public Criteria andTciStatusMessageIsNull() {
            addCriterion("tci_status_message is null");
            return (Criteria) this;
        }

        public Criteria andTciStatusMessageIsNotNull() {
            addCriterion("tci_status_message is not null");
            return (Criteria) this;
        }

        public Criteria andTciStatusMessageEqualTo(String value) {
            addCriterion("tci_status_message =", value, "tciStatusMessage");
            return (Criteria) this;
        }

        public Criteria andTciStatusMessageNotEqualTo(String value) {
            addCriterion("tci_status_message <>", value, "tciStatusMessage");
            return (Criteria) this;
        }

        public Criteria andTciStatusMessageGreaterThan(String value) {
            addCriterion("tci_status_message >", value, "tciStatusMessage");
            return (Criteria) this;
        }

        public Criteria andTciStatusMessageGreaterThanOrEqualTo(String value) {
            addCriterion("tci_status_message >=", value, "tciStatusMessage");
            return (Criteria) this;
        }

        public Criteria andTciStatusMessageLessThan(String value) {
            addCriterion("tci_status_message <", value, "tciStatusMessage");
            return (Criteria) this;
        }

        public Criteria andTciStatusMessageLessThanOrEqualTo(String value) {
            addCriterion("tci_status_message <=", value, "tciStatusMessage");
            return (Criteria) this;
        }

        public Criteria andTciStatusMessageLike(String value) {
            addCriterion("tci_status_message like", value, "tciStatusMessage");
            return (Criteria) this;
        }

        public Criteria andTciStatusMessageNotLike(String value) {
            addCriterion("tci_status_message not like", value, "tciStatusMessage");
            return (Criteria) this;
        }

        public Criteria andTciStatusMessageIn(List<String> values) {
            addCriterion("tci_status_message in", values, "tciStatusMessage");
            return (Criteria) this;
        }

        public Criteria andTciStatusMessageNotIn(List<String> values) {
            addCriterion("tci_status_message not in", values, "tciStatusMessage");
            return (Criteria) this;
        }

        public Criteria andTciStatusMessageBetween(String value1, String value2) {
            addCriterion("tci_status_message between", value1, value2, "tciStatusMessage");
            return (Criteria) this;
        }

        public Criteria andTciStatusMessageNotBetween(String value1, String value2) {
            addCriterion("tci_status_message not between", value1, value2, "tciStatusMessage");
            return (Criteria) this;
        }

        public Criteria andVciPolicyStatusIsNull() {
            addCriterion("vci_policy_status is null");
            return (Criteria) this;
        }

        public Criteria andVciPolicyStatusIsNotNull() {
            addCriterion("vci_policy_status is not null");
            return (Criteria) this;
        }

        public Criteria andVciPolicyStatusEqualTo(Byte value) {
            addCriterion("vci_policy_status =", value, "vciPolicyStatus");
            return (Criteria) this;
        }

        public Criteria andVciPolicyStatusNotEqualTo(Byte value) {
            addCriterion("vci_policy_status <>", value, "vciPolicyStatus");
            return (Criteria) this;
        }

        public Criteria andVciPolicyStatusGreaterThan(Byte value) {
            addCriterion("vci_policy_status >", value, "vciPolicyStatus");
            return (Criteria) this;
        }

        public Criteria andVciPolicyStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("vci_policy_status >=", value, "vciPolicyStatus");
            return (Criteria) this;
        }

        public Criteria andVciPolicyStatusLessThan(Byte value) {
            addCriterion("vci_policy_status <", value, "vciPolicyStatus");
            return (Criteria) this;
        }

        public Criteria andVciPolicyStatusLessThanOrEqualTo(Byte value) {
            addCriterion("vci_policy_status <=", value, "vciPolicyStatus");
            return (Criteria) this;
        }

        public Criteria andVciPolicyStatusIn(List<Byte> values) {
            addCriterion("vci_policy_status in", values, "vciPolicyStatus");
            return (Criteria) this;
        }

        public Criteria andVciPolicyStatusNotIn(List<Byte> values) {
            addCriterion("vci_policy_status not in", values, "vciPolicyStatus");
            return (Criteria) this;
        }

        public Criteria andVciPolicyStatusBetween(Byte value1, Byte value2) {
            addCriterion("vci_policy_status between", value1, value2, "vciPolicyStatus");
            return (Criteria) this;
        }

        public Criteria andVciPolicyStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("vci_policy_status not between", value1, value2, "vciPolicyStatus");
            return (Criteria) this;
        }

        public Criteria andVciStatusMessageIsNull() {
            addCriterion("vci_status_message is null");
            return (Criteria) this;
        }

        public Criteria andVciStatusMessageIsNotNull() {
            addCriterion("vci_status_message is not null");
            return (Criteria) this;
        }

        public Criteria andVciStatusMessageEqualTo(String value) {
            addCriterion("vci_status_message =", value, "vciStatusMessage");
            return (Criteria) this;
        }

        public Criteria andVciStatusMessageNotEqualTo(String value) {
            addCriterion("vci_status_message <>", value, "vciStatusMessage");
            return (Criteria) this;
        }

        public Criteria andVciStatusMessageGreaterThan(String value) {
            addCriterion("vci_status_message >", value, "vciStatusMessage");
            return (Criteria) this;
        }

        public Criteria andVciStatusMessageGreaterThanOrEqualTo(String value) {
            addCriterion("vci_status_message >=", value, "vciStatusMessage");
            return (Criteria) this;
        }

        public Criteria andVciStatusMessageLessThan(String value) {
            addCriterion("vci_status_message <", value, "vciStatusMessage");
            return (Criteria) this;
        }

        public Criteria andVciStatusMessageLessThanOrEqualTo(String value) {
            addCriterion("vci_status_message <=", value, "vciStatusMessage");
            return (Criteria) this;
        }

        public Criteria andVciStatusMessageLike(String value) {
            addCriterion("vci_status_message like", value, "vciStatusMessage");
            return (Criteria) this;
        }

        public Criteria andVciStatusMessageNotLike(String value) {
            addCriterion("vci_status_message not like", value, "vciStatusMessage");
            return (Criteria) this;
        }

        public Criteria andVciStatusMessageIn(List<String> values) {
            addCriterion("vci_status_message in", values, "vciStatusMessage");
            return (Criteria) this;
        }

        public Criteria andVciStatusMessageNotIn(List<String> values) {
            addCriterion("vci_status_message not in", values, "vciStatusMessage");
            return (Criteria) this;
        }

        public Criteria andVciStatusMessageBetween(String value1, String value2) {
            addCriterion("vci_status_message between", value1, value2, "vciStatusMessage");
            return (Criteria) this;
        }

        public Criteria andVciStatusMessageNotBetween(String value1, String value2) {
            addCriterion("vci_status_message not between", value1, value2, "vciStatusMessage");
            return (Criteria) this;
        }

        public Criteria andPolicyStatusIsNull() {
            addCriterion("policy_status is null");
            return (Criteria) this;
        }

        public Criteria andPolicyStatusIsNotNull() {
            addCriterion("policy_status is not null");
            return (Criteria) this;
        }

        public Criteria andPolicyStatusEqualTo(Byte value) {
            addCriterion("policy_status =", value, "policyStatus");
            return (Criteria) this;
        }

        public Criteria andPolicyStatusNotEqualTo(Byte value) {
            addCriterion("policy_status <>", value, "policyStatus");
            return (Criteria) this;
        }

        public Criteria andPolicyStatusGreaterThan(Byte value) {
            addCriterion("policy_status >", value, "policyStatus");
            return (Criteria) this;
        }

        public Criteria andPolicyStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("policy_status >=", value, "policyStatus");
            return (Criteria) this;
        }

        public Criteria andPolicyStatusLessThan(Byte value) {
            addCriterion("policy_status <", value, "policyStatus");
            return (Criteria) this;
        }

        public Criteria andPolicyStatusLessThanOrEqualTo(Byte value) {
            addCriterion("policy_status <=", value, "policyStatus");
            return (Criteria) this;
        }

        public Criteria andPolicyStatusIn(List<Byte> values) {
            addCriterion("policy_status in", values, "policyStatus");
            return (Criteria) this;
        }

        public Criteria andPolicyStatusNotIn(List<Byte> values) {
            addCriterion("policy_status not in", values, "policyStatus");
            return (Criteria) this;
        }

        public Criteria andPolicyStatusBetween(Byte value1, Byte value2) {
            addCriterion("policy_status between", value1, value2, "policyStatus");
            return (Criteria) this;
        }

        public Criteria andPolicyStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("policy_status not between", value1, value2, "policyStatus");
            return (Criteria) this;
        }

        public Criteria andProtocolCodeIsNull() {
            addCriterion("protocol_code is null");
            return (Criteria) this;
        }

        public Criteria andProtocolCodeIsNotNull() {
            addCriterion("protocol_code is not null");
            return (Criteria) this;
        }

        public Criteria andProtocolCodeEqualTo(String value) {
            addCriterion("protocol_code =", value, "protocolCode");
            return (Criteria) this;
        }

        public Criteria andProtocolCodeNotEqualTo(String value) {
            addCriterion("protocol_code <>", value, "protocolCode");
            return (Criteria) this;
        }

        public Criteria andProtocolCodeGreaterThan(String value) {
            addCriterion("protocol_code >", value, "protocolCode");
            return (Criteria) this;
        }

        public Criteria andProtocolCodeGreaterThanOrEqualTo(String value) {
            addCriterion("protocol_code >=", value, "protocolCode");
            return (Criteria) this;
        }

        public Criteria andProtocolCodeLessThan(String value) {
            addCriterion("protocol_code <", value, "protocolCode");
            return (Criteria) this;
        }

        public Criteria andProtocolCodeLessThanOrEqualTo(String value) {
            addCriterion("protocol_code <=", value, "protocolCode");
            return (Criteria) this;
        }

        public Criteria andProtocolCodeLike(String value) {
            addCriterion("protocol_code like", value, "protocolCode");
            return (Criteria) this;
        }

        public Criteria andProtocolCodeNotLike(String value) {
            addCriterion("protocol_code not like", value, "protocolCode");
            return (Criteria) this;
        }

        public Criteria andProtocolCodeIn(List<String> values) {
            addCriterion("protocol_code in", values, "protocolCode");
            return (Criteria) this;
        }

        public Criteria andProtocolCodeNotIn(List<String> values) {
            addCriterion("protocol_code not in", values, "protocolCode");
            return (Criteria) this;
        }

        public Criteria andProtocolCodeBetween(String value1, String value2) {
            addCriterion("protocol_code between", value1, value2, "protocolCode");
            return (Criteria) this;
        }

        public Criteria andProtocolCodeNotBetween(String value1, String value2) {
            addCriterion("protocol_code not between", value1, value2, "protocolCode");
            return (Criteria) this;
        }

        public Criteria andOperatorIdIsNull() {
            addCriterion("operator_id is null");
            return (Criteria) this;
        }

        public Criteria andOperatorIdIsNotNull() {
            addCriterion("operator_id is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorIdEqualTo(String value) {
            addCriterion("operator_id =", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdNotEqualTo(String value) {
            addCriterion("operator_id <>", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdGreaterThan(String value) {
            addCriterion("operator_id >", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdGreaterThanOrEqualTo(String value) {
            addCriterion("operator_id >=", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdLessThan(String value) {
            addCriterion("operator_id <", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdLessThanOrEqualTo(String value) {
            addCriterion("operator_id <=", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdLike(String value) {
            addCriterion("operator_id like", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdNotLike(String value) {
            addCriterion("operator_id not like", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdIn(List<String> values) {
            addCriterion("operator_id in", values, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdNotIn(List<String> values) {
            addCriterion("operator_id not in", values, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdBetween(String value1, String value2) {
            addCriterion("operator_id between", value1, value2, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdNotBetween(String value1, String value2) {
            addCriterion("operator_id not between", value1, value2, "operatorId");
            return (Criteria) this;
        }

        public Criteria andBusinessPropertyIsNull() {
            addCriterion("business_property is null");
            return (Criteria) this;
        }

        public Criteria andBusinessPropertyIsNotNull() {
            addCriterion("business_property is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessPropertyEqualTo(String value) {
            addCriterion("business_property =", value, "businessProperty");
            return (Criteria) this;
        }

        public Criteria andBusinessPropertyNotEqualTo(String value) {
            addCriterion("business_property <>", value, "businessProperty");
            return (Criteria) this;
        }

        public Criteria andBusinessPropertyGreaterThan(String value) {
            addCriterion("business_property >", value, "businessProperty");
            return (Criteria) this;
        }

        public Criteria andBusinessPropertyGreaterThanOrEqualTo(String value) {
            addCriterion("business_property >=", value, "businessProperty");
            return (Criteria) this;
        }

        public Criteria andBusinessPropertyLessThan(String value) {
            addCriterion("business_property <", value, "businessProperty");
            return (Criteria) this;
        }

        public Criteria andBusinessPropertyLessThanOrEqualTo(String value) {
            addCriterion("business_property <=", value, "businessProperty");
            return (Criteria) this;
        }

        public Criteria andBusinessPropertyLike(String value) {
            addCriterion("business_property like", value, "businessProperty");
            return (Criteria) this;
        }

        public Criteria andBusinessPropertyNotLike(String value) {
            addCriterion("business_property not like", value, "businessProperty");
            return (Criteria) this;
        }

        public Criteria andBusinessPropertyIn(List<String> values) {
            addCriterion("business_property in", values, "businessProperty");
            return (Criteria) this;
        }

        public Criteria andBusinessPropertyNotIn(List<String> values) {
            addCriterion("business_property not in", values, "businessProperty");
            return (Criteria) this;
        }

        public Criteria andBusinessPropertyBetween(String value1, String value2) {
            addCriterion("business_property between", value1, value2, "businessProperty");
            return (Criteria) this;
        }

        public Criteria andBusinessPropertyNotBetween(String value1, String value2) {
            addCriterion("business_property not between", value1, value2, "businessProperty");
            return (Criteria) this;
        }

        public Criteria andCompanyChannelIdIsNull() {
            addCriterion("company_channel_id is null");
            return (Criteria) this;
        }

        public Criteria andCompanyChannelIdIsNotNull() {
            addCriterion("company_channel_id is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyChannelIdEqualTo(String value) {
            addCriterion("company_channel_id =", value, "companyChannelId");
            return (Criteria) this;
        }

        public Criteria andCompanyChannelIdNotEqualTo(String value) {
            addCriterion("company_channel_id <>", value, "companyChannelId");
            return (Criteria) this;
        }

        public Criteria andCompanyChannelIdGreaterThan(String value) {
            addCriterion("company_channel_id >", value, "companyChannelId");
            return (Criteria) this;
        }

        public Criteria andCompanyChannelIdGreaterThanOrEqualTo(String value) {
            addCriterion("company_channel_id >=", value, "companyChannelId");
            return (Criteria) this;
        }

        public Criteria andCompanyChannelIdLessThan(String value) {
            addCriterion("company_channel_id <", value, "companyChannelId");
            return (Criteria) this;
        }

        public Criteria andCompanyChannelIdLessThanOrEqualTo(String value) {
            addCriterion("company_channel_id <=", value, "companyChannelId");
            return (Criteria) this;
        }

        public Criteria andCompanyChannelIdLike(String value) {
            addCriterion("company_channel_id like", value, "companyChannelId");
            return (Criteria) this;
        }

        public Criteria andCompanyChannelIdNotLike(String value) {
            addCriterion("company_channel_id not like", value, "companyChannelId");
            return (Criteria) this;
        }

        public Criteria andCompanyChannelIdIn(List<String> values) {
            addCriterion("company_channel_id in", values, "companyChannelId");
            return (Criteria) this;
        }

        public Criteria andCompanyChannelIdNotIn(List<String> values) {
            addCriterion("company_channel_id not in", values, "companyChannelId");
            return (Criteria) this;
        }

        public Criteria andCompanyChannelIdBetween(String value1, String value2) {
            addCriterion("company_channel_id between", value1, value2, "companyChannelId");
            return (Criteria) this;
        }

        public Criteria andCompanyChannelIdNotBetween(String value1, String value2) {
            addCriterion("company_channel_id not between", value1, value2, "companyChannelId");
            return (Criteria) this;
        }

        public Criteria andSyncStatusIsNull() {
            addCriterion("sync_status is null");
            return (Criteria) this;
        }

        public Criteria andSyncStatusIsNotNull() {
            addCriterion("sync_status is not null");
            return (Criteria) this;
        }

        public Criteria andSyncStatusEqualTo(Byte value) {
            addCriterion("sync_status =", value, "syncStatus");
            return (Criteria) this;
        }

        public Criteria andSyncStatusNotEqualTo(Byte value) {
            addCriterion("sync_status <>", value, "syncStatus");
            return (Criteria) this;
        }

        public Criteria andSyncStatusGreaterThan(Byte value) {
            addCriterion("sync_status >", value, "syncStatus");
            return (Criteria) this;
        }

        public Criteria andSyncStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("sync_status >=", value, "syncStatus");
            return (Criteria) this;
        }

        public Criteria andSyncStatusLessThan(Byte value) {
            addCriterion("sync_status <", value, "syncStatus");
            return (Criteria) this;
        }

        public Criteria andSyncStatusLessThanOrEqualTo(Byte value) {
            addCriterion("sync_status <=", value, "syncStatus");
            return (Criteria) this;
        }

        public Criteria andSyncStatusIn(List<Byte> values) {
            addCriterion("sync_status in", values, "syncStatus");
            return (Criteria) this;
        }

        public Criteria andSyncStatusNotIn(List<Byte> values) {
            addCriterion("sync_status not in", values, "syncStatus");
            return (Criteria) this;
        }

        public Criteria andSyncStatusBetween(Byte value1, Byte value2) {
            addCriterion("sync_status between", value1, value2, "syncStatus");
            return (Criteria) this;
        }

        public Criteria andSyncStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("sync_status not between", value1, value2, "syncStatus");
            return (Criteria) this;
        }

        public Criteria andReasonIsNull() {
            addCriterion("reason is null");
            return (Criteria) this;
        }

        public Criteria andReasonIsNotNull() {
            addCriterion("reason is not null");
            return (Criteria) this;
        }

        public Criteria andReasonEqualTo(String value) {
            addCriterion("reason =", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotEqualTo(String value) {
            addCriterion("reason <>", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThan(String value) {
            addCriterion("reason >", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThanOrEqualTo(String value) {
            addCriterion("reason >=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThan(String value) {
            addCriterion("reason <", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThanOrEqualTo(String value) {
            addCriterion("reason <=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLike(String value) {
            addCriterion("reason like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotLike(String value) {
            addCriterion("reason not like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonIn(List<String> values) {
            addCriterion("reason in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotIn(List<String> values) {
            addCriterion("reason not in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonBetween(String value1, String value2) {
            addCriterion("reason between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotBetween(String value1, String value2) {
            addCriterion("reason not between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andQuoteTimeIsNull() {
            addCriterion("quote_time is null");
            return (Criteria) this;
        }

        public Criteria andQuoteTimeIsNotNull() {
            addCriterion("quote_time is not null");
            return (Criteria) this;
        }

        public Criteria andQuoteTimeEqualTo(Long value) {
            addCriterion("quote_time =", value, "quoteTime");
            return (Criteria) this;
        }

        public Criteria andQuoteTimeNotEqualTo(Long value) {
            addCriterion("quote_time <>", value, "quoteTime");
            return (Criteria) this;
        }

        public Criteria andQuoteTimeGreaterThan(Long value) {
            addCriterion("quote_time >", value, "quoteTime");
            return (Criteria) this;
        }

        public Criteria andQuoteTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("quote_time >=", value, "quoteTime");
            return (Criteria) this;
        }

        public Criteria andQuoteTimeLessThan(Long value) {
            addCriterion("quote_time <", value, "quoteTime");
            return (Criteria) this;
        }

        public Criteria andQuoteTimeLessThanOrEqualTo(Long value) {
            addCriterion("quote_time <=", value, "quoteTime");
            return (Criteria) this;
        }

        public Criteria andQuoteTimeIn(List<Long> values) {
            addCriterion("quote_time in", values, "quoteTime");
            return (Criteria) this;
        }

        public Criteria andQuoteTimeNotIn(List<Long> values) {
            addCriterion("quote_time not in", values, "quoteTime");
            return (Criteria) this;
        }

        public Criteria andQuoteTimeBetween(Long value1, Long value2) {
            addCriterion("quote_time between", value1, value2, "quoteTime");
            return (Criteria) this;
        }

        public Criteria andQuoteTimeNotBetween(Long value1, Long value2) {
            addCriterion("quote_time not between", value1, value2, "quoteTime");
            return (Criteria) this;
        }

        public Criteria andInsureTimeIsNull() {
            addCriterion("insure_time is null");
            return (Criteria) this;
        }

        public Criteria andInsureTimeIsNotNull() {
            addCriterion("insure_time is not null");
            return (Criteria) this;
        }

        public Criteria andInsureTimeEqualTo(Long value) {
            addCriterion("insure_time =", value, "insureTime");
            return (Criteria) this;
        }

        public Criteria andInsureTimeNotEqualTo(Long value) {
            addCriterion("insure_time <>", value, "insureTime");
            return (Criteria) this;
        }

        public Criteria andInsureTimeGreaterThan(Long value) {
            addCriterion("insure_time >", value, "insureTime");
            return (Criteria) this;
        }

        public Criteria andInsureTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("insure_time >=", value, "insureTime");
            return (Criteria) this;
        }

        public Criteria andInsureTimeLessThan(Long value) {
            addCriterion("insure_time <", value, "insureTime");
            return (Criteria) this;
        }

        public Criteria andInsureTimeLessThanOrEqualTo(Long value) {
            addCriterion("insure_time <=", value, "insureTime");
            return (Criteria) this;
        }

        public Criteria andInsureTimeIn(List<Long> values) {
            addCriterion("insure_time in", values, "insureTime");
            return (Criteria) this;
        }

        public Criteria andInsureTimeNotIn(List<Long> values) {
            addCriterion("insure_time not in", values, "insureTime");
            return (Criteria) this;
        }

        public Criteria andInsureTimeBetween(Long value1, Long value2) {
            addCriterion("insure_time between", value1, value2, "insureTime");
            return (Criteria) this;
        }

        public Criteria andInsureTimeNotBetween(Long value1, Long value2) {
            addCriterion("insure_time not between", value1, value2, "insureTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeIsNull() {
            addCriterion("pay_time is null");
            return (Criteria) this;
        }

        public Criteria andPayTimeIsNotNull() {
            addCriterion("pay_time is not null");
            return (Criteria) this;
        }

        public Criteria andPayTimeEqualTo(Long value) {
            addCriterion("pay_time =", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotEqualTo(Long value) {
            addCriterion("pay_time <>", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThan(Long value) {
            addCriterion("pay_time >", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("pay_time >=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThan(Long value) {
            addCriterion("pay_time <", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThanOrEqualTo(Long value) {
            addCriterion("pay_time <=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeIn(List<Long> values) {
            addCriterion("pay_time in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotIn(List<Long> values) {
            addCriterion("pay_time not in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeBetween(Long value1, Long value2) {
            addCriterion("pay_time between", value1, value2, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotBetween(Long value1, Long value2) {
            addCriterion("pay_time not between", value1, value2, "payTime");
            return (Criteria) this;
        }

        public Criteria andPolicyTimeIsNull() {
            addCriterion("policy_time is null");
            return (Criteria) this;
        }

        public Criteria andPolicyTimeIsNotNull() {
            addCriterion("policy_time is not null");
            return (Criteria) this;
        }

        public Criteria andPolicyTimeEqualTo(Long value) {
            addCriterion("policy_time =", value, "policyTime");
            return (Criteria) this;
        }

        public Criteria andPolicyTimeNotEqualTo(Long value) {
            addCriterion("policy_time <>", value, "policyTime");
            return (Criteria) this;
        }

        public Criteria andPolicyTimeGreaterThan(Long value) {
            addCriterion("policy_time >", value, "policyTime");
            return (Criteria) this;
        }

        public Criteria andPolicyTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("policy_time >=", value, "policyTime");
            return (Criteria) this;
        }

        public Criteria andPolicyTimeLessThan(Long value) {
            addCriterion("policy_time <", value, "policyTime");
            return (Criteria) this;
        }

        public Criteria andPolicyTimeLessThanOrEqualTo(Long value) {
            addCriterion("policy_time <=", value, "policyTime");
            return (Criteria) this;
        }

        public Criteria andPolicyTimeIn(List<Long> values) {
            addCriterion("policy_time in", values, "policyTime");
            return (Criteria) this;
        }

        public Criteria andPolicyTimeNotIn(List<Long> values) {
            addCriterion("policy_time not in", values, "policyTime");
            return (Criteria) this;
        }

        public Criteria andPolicyTimeBetween(Long value1, Long value2) {
            addCriterion("policy_time between", value1, value2, "policyTime");
            return (Criteria) this;
        }

        public Criteria andPolicyTimeNotBetween(Long value1, Long value2) {
            addCriterion("policy_time not between", value1, value2, "policyTime");
            return (Criteria) this;
        }

        public Criteria andTciPolicyEndDateIsNull() {
            addCriterion("tci_policy_end_date is null");
            return (Criteria) this;
        }

        public Criteria andTciPolicyEndDateIsNotNull() {
            addCriterion("tci_policy_end_date is not null");
            return (Criteria) this;
        }

        public Criteria andTciPolicyEndDateEqualTo(Date value) {
            addCriterionForJDBCDate("tci_policy_end_date =", value, "tciPolicyEndDate");
            return (Criteria) this;
        }

        public Criteria andTciPolicyEndDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("tci_policy_end_date <>", value, "tciPolicyEndDate");
            return (Criteria) this;
        }

        public Criteria andTciPolicyEndDateGreaterThan(Date value) {
            addCriterionForJDBCDate("tci_policy_end_date >", value, "tciPolicyEndDate");
            return (Criteria) this;
        }

        public Criteria andTciPolicyEndDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("tci_policy_end_date >=", value, "tciPolicyEndDate");
            return (Criteria) this;
        }

        public Criteria andTciPolicyEndDateLessThan(Date value) {
            addCriterionForJDBCDate("tci_policy_end_date <", value, "tciPolicyEndDate");
            return (Criteria) this;
        }

        public Criteria andTciPolicyEndDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("tci_policy_end_date <=", value, "tciPolicyEndDate");
            return (Criteria) this;
        }

        public Criteria andTciPolicyEndDateIn(List<Date> values) {
            addCriterionForJDBCDate("tci_policy_end_date in", values, "tciPolicyEndDate");
            return (Criteria) this;
        }

        public Criteria andTciPolicyEndDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("tci_policy_end_date not in", values, "tciPolicyEndDate");
            return (Criteria) this;
        }

        public Criteria andTciPolicyEndDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("tci_policy_end_date between", value1, value2, "tciPolicyEndDate");
            return (Criteria) this;
        }

        public Criteria andTciPolicyEndDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("tci_policy_end_date not between", value1, value2, "tciPolicyEndDate");
            return (Criteria) this;
        }

        public Criteria andVciPolicyEndDateIsNull() {
            addCriterion("vci_policy_end_date is null");
            return (Criteria) this;
        }

        public Criteria andVciPolicyEndDateIsNotNull() {
            addCriterion("vci_policy_end_date is not null");
            return (Criteria) this;
        }

        public Criteria andVciPolicyEndDateEqualTo(Date value) {
            addCriterionForJDBCDate("vci_policy_end_date =", value, "vciPolicyEndDate");
            return (Criteria) this;
        }

        public Criteria andVciPolicyEndDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("vci_policy_end_date <>", value, "vciPolicyEndDate");
            return (Criteria) this;
        }

        public Criteria andVciPolicyEndDateGreaterThan(Date value) {
            addCriterionForJDBCDate("vci_policy_end_date >", value, "vciPolicyEndDate");
            return (Criteria) this;
        }

        public Criteria andVciPolicyEndDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("vci_policy_end_date >=", value, "vciPolicyEndDate");
            return (Criteria) this;
        }

        public Criteria andVciPolicyEndDateLessThan(Date value) {
            addCriterionForJDBCDate("vci_policy_end_date <", value, "vciPolicyEndDate");
            return (Criteria) this;
        }

        public Criteria andVciPolicyEndDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("vci_policy_end_date <=", value, "vciPolicyEndDate");
            return (Criteria) this;
        }

        public Criteria andVciPolicyEndDateIn(List<Date> values) {
            addCriterionForJDBCDate("vci_policy_end_date in", values, "vciPolicyEndDate");
            return (Criteria) this;
        }

        public Criteria andVciPolicyEndDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("vci_policy_end_date not in", values, "vciPolicyEndDate");
            return (Criteria) this;
        }

        public Criteria andVciPolicyEndDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("vci_policy_end_date between", value1, value2, "vciPolicyEndDate");
            return (Criteria) this;
        }

        public Criteria andVciPolicyEndDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("vci_policy_end_date not between", value1, value2, "vciPolicyEndDate");
            return (Criteria) this;
        }

        public Criteria andIsOfflineIsNull() {
            addCriterion("is_offline is null");
            return (Criteria) this;
        }

        public Criteria andIsOfflineIsNotNull() {
            addCriterion("is_offline is not null");
            return (Criteria) this;
        }

        public Criteria andIsOfflineEqualTo(Byte value) {
            addCriterion("is_offline =", value, "isOffline");
            return (Criteria) this;
        }

        public Criteria andIsOfflineNotEqualTo(Byte value) {
            addCriterion("is_offline <>", value, "isOffline");
            return (Criteria) this;
        }

        public Criteria andIsOfflineGreaterThan(Byte value) {
            addCriterion("is_offline >", value, "isOffline");
            return (Criteria) this;
        }

        public Criteria andIsOfflineGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_offline >=", value, "isOffline");
            return (Criteria) this;
        }

        public Criteria andIsOfflineLessThan(Byte value) {
            addCriterion("is_offline <", value, "isOffline");
            return (Criteria) this;
        }

        public Criteria andIsOfflineLessThanOrEqualTo(Byte value) {
            addCriterion("is_offline <=", value, "isOffline");
            return (Criteria) this;
        }

        public Criteria andIsOfflineIn(List<Byte> values) {
            addCriterion("is_offline in", values, "isOffline");
            return (Criteria) this;
        }

        public Criteria andIsOfflineNotIn(List<Byte> values) {
            addCriterion("is_offline not in", values, "isOffline");
            return (Criteria) this;
        }

        public Criteria andIsOfflineBetween(Byte value1, Byte value2) {
            addCriterion("is_offline between", value1, value2, "isOffline");
            return (Criteria) this;
        }

        public Criteria andIsOfflineNotBetween(Byte value1, Byte value2) {
            addCriterion("is_offline not between", value1, value2, "isOffline");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNull() {
            addCriterion("is_deleted is null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNotNull() {
            addCriterion("is_deleted is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedEqualTo(Byte value) {
            addCriterion("is_deleted =", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotEqualTo(Byte value) {
            addCriterion("is_deleted <>", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThan(Byte value) {
            addCriterion("is_deleted >", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_deleted >=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThan(Byte value) {
            addCriterion("is_deleted <", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThanOrEqualTo(Byte value) {
            addCriterion("is_deleted <=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIn(List<Byte> values) {
            addCriterion("is_deleted in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotIn(List<Byte> values) {
            addCriterion("is_deleted not in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedBetween(Byte value1, Byte value2) {
            addCriterion("is_deleted between", value1, value2, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotBetween(Byte value1, Byte value2) {
            addCriterion("is_deleted not between", value1, value2, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andChannel0IsNull() {
            addCriterion("channel0 is null");
            return (Criteria) this;
        }

        public Criteria andChannel0IsNotNull() {
            addCriterion("channel0 is not null");
            return (Criteria) this;
        }

        public Criteria andChannel0EqualTo(String value) {
            addCriterion("channel0 =", value, "channel0");
            return (Criteria) this;
        }

        public Criteria andChannel0NotEqualTo(String value) {
            addCriterion("channel0 <>", value, "channel0");
            return (Criteria) this;
        }

        public Criteria andChannel0GreaterThan(String value) {
            addCriterion("channel0 >", value, "channel0");
            return (Criteria) this;
        }

        public Criteria andChannel0GreaterThanOrEqualTo(String value) {
            addCriterion("channel0 >=", value, "channel0");
            return (Criteria) this;
        }

        public Criteria andChannel0LessThan(String value) {
            addCriterion("channel0 <", value, "channel0");
            return (Criteria) this;
        }

        public Criteria andChannel0LessThanOrEqualTo(String value) {
            addCriterion("channel0 <=", value, "channel0");
            return (Criteria) this;
        }

        public Criteria andChannel0Like(String value) {
            addCriterion("channel0 like", value, "channel0");
            return (Criteria) this;
        }

        public Criteria andChannel0NotLike(String value) {
            addCriterion("channel0 not like", value, "channel0");
            return (Criteria) this;
        }

        public Criteria andChannel0In(List<String> values) {
            addCriterion("channel0 in", values, "channel0");
            return (Criteria) this;
        }

        public Criteria andChannel0NotIn(List<String> values) {
            addCriterion("channel0 not in", values, "channel0");
            return (Criteria) this;
        }

        public Criteria andChannel0Between(String value1, String value2) {
            addCriterion("channel0 between", value1, value2, "channel0");
            return (Criteria) this;
        }

        public Criteria andChannel0NotBetween(String value1, String value2) {
            addCriterion("channel0 not between", value1, value2, "channel0");
            return (Criteria) this;
        }

        public Criteria andChannel1IsNull() {
            addCriterion("channel1 is null");
            return (Criteria) this;
        }

        public Criteria andChannel1IsNotNull() {
            addCriterion("channel1 is not null");
            return (Criteria) this;
        }

        public Criteria andChannel1EqualTo(String value) {
            addCriterion("channel1 =", value, "channel1");
            return (Criteria) this;
        }

        public Criteria andChannel1NotEqualTo(String value) {
            addCriterion("channel1 <>", value, "channel1");
            return (Criteria) this;
        }

        public Criteria andChannel1GreaterThan(String value) {
            addCriterion("channel1 >", value, "channel1");
            return (Criteria) this;
        }

        public Criteria andChannel1GreaterThanOrEqualTo(String value) {
            addCriterion("channel1 >=", value, "channel1");
            return (Criteria) this;
        }

        public Criteria andChannel1LessThan(String value) {
            addCriterion("channel1 <", value, "channel1");
            return (Criteria) this;
        }

        public Criteria andChannel1LessThanOrEqualTo(String value) {
            addCriterion("channel1 <=", value, "channel1");
            return (Criteria) this;
        }

        public Criteria andChannel1Like(String value) {
            addCriterion("channel1 like", value, "channel1");
            return (Criteria) this;
        }

        public Criteria andChannel1NotLike(String value) {
            addCriterion("channel1 not like", value, "channel1");
            return (Criteria) this;
        }

        public Criteria andChannel1In(List<String> values) {
            addCriterion("channel1 in", values, "channel1");
            return (Criteria) this;
        }

        public Criteria andChannel1NotIn(List<String> values) {
            addCriterion("channel1 not in", values, "channel1");
            return (Criteria) this;
        }

        public Criteria andChannel1Between(String value1, String value2) {
            addCriterion("channel1 between", value1, value2, "channel1");
            return (Criteria) this;
        }

        public Criteria andChannel1NotBetween(String value1, String value2) {
            addCriterion("channel1 not between", value1, value2, "channel1");
            return (Criteria) this;
        }

        public Criteria andChannel2IsNull() {
            addCriterion("channel2 is null");
            return (Criteria) this;
        }

        public Criteria andChannel2IsNotNull() {
            addCriterion("channel2 is not null");
            return (Criteria) this;
        }

        public Criteria andChannel2EqualTo(String value) {
            addCriterion("channel2 =", value, "channel2");
            return (Criteria) this;
        }

        public Criteria andChannel2NotEqualTo(String value) {
            addCriterion("channel2 <>", value, "channel2");
            return (Criteria) this;
        }

        public Criteria andChannel2GreaterThan(String value) {
            addCriterion("channel2 >", value, "channel2");
            return (Criteria) this;
        }

        public Criteria andChannel2GreaterThanOrEqualTo(String value) {
            addCriterion("channel2 >=", value, "channel2");
            return (Criteria) this;
        }

        public Criteria andChannel2LessThan(String value) {
            addCriterion("channel2 <", value, "channel2");
            return (Criteria) this;
        }

        public Criteria andChannel2LessThanOrEqualTo(String value) {
            addCriterion("channel2 <=", value, "channel2");
            return (Criteria) this;
        }

        public Criteria andChannel2Like(String value) {
            addCriterion("channel2 like", value, "channel2");
            return (Criteria) this;
        }

        public Criteria andChannel2NotLike(String value) {
            addCriterion("channel2 not like", value, "channel2");
            return (Criteria) this;
        }

        public Criteria andChannel2In(List<String> values) {
            addCriterion("channel2 in", values, "channel2");
            return (Criteria) this;
        }

        public Criteria andChannel2NotIn(List<String> values) {
            addCriterion("channel2 not in", values, "channel2");
            return (Criteria) this;
        }

        public Criteria andChannel2Between(String value1, String value2) {
            addCriterion("channel2 between", value1, value2, "channel2");
            return (Criteria) this;
        }

        public Criteria andChannel2NotBetween(String value1, String value2) {
            addCriterion("channel2 not between", value1, value2, "channel2");
            return (Criteria) this;
        }

        public Criteria andChannel3IsNull() {
            addCriterion("channel3 is null");
            return (Criteria) this;
        }

        public Criteria andChannel3IsNotNull() {
            addCriterion("channel3 is not null");
            return (Criteria) this;
        }

        public Criteria andChannel3EqualTo(String value) {
            addCriterion("channel3 =", value, "channel3");
            return (Criteria) this;
        }

        public Criteria andChannel3NotEqualTo(String value) {
            addCriterion("channel3 <>", value, "channel3");
            return (Criteria) this;
        }

        public Criteria andChannel3GreaterThan(String value) {
            addCriterion("channel3 >", value, "channel3");
            return (Criteria) this;
        }

        public Criteria andChannel3GreaterThanOrEqualTo(String value) {
            addCriterion("channel3 >=", value, "channel3");
            return (Criteria) this;
        }

        public Criteria andChannel3LessThan(String value) {
            addCriterion("channel3 <", value, "channel3");
            return (Criteria) this;
        }

        public Criteria andChannel3LessThanOrEqualTo(String value) {
            addCriterion("channel3 <=", value, "channel3");
            return (Criteria) this;
        }

        public Criteria andChannel3Like(String value) {
            addCriterion("channel3 like", value, "channel3");
            return (Criteria) this;
        }

        public Criteria andChannel3NotLike(String value) {
            addCriterion("channel3 not like", value, "channel3");
            return (Criteria) this;
        }

        public Criteria andChannel3In(List<String> values) {
            addCriterion("channel3 in", values, "channel3");
            return (Criteria) this;
        }

        public Criteria andChannel3NotIn(List<String> values) {
            addCriterion("channel3 not in", values, "channel3");
            return (Criteria) this;
        }

        public Criteria andChannel3Between(String value1, String value2) {
            addCriterion("channel3 between", value1, value2, "channel3");
            return (Criteria) this;
        }

        public Criteria andChannel3NotBetween(String value1, String value2) {
            addCriterion("channel3 not between", value1, value2, "channel3");
            return (Criteria) this;
        }

        public Criteria andChannel4IsNull() {
            addCriterion("channel4 is null");
            return (Criteria) this;
        }

        public Criteria andChannel4IsNotNull() {
            addCriterion("channel4 is not null");
            return (Criteria) this;
        }

        public Criteria andChannel4EqualTo(String value) {
            addCriterion("channel4 =", value, "channel4");
            return (Criteria) this;
        }

        public Criteria andChannel4NotEqualTo(String value) {
            addCriterion("channel4 <>", value, "channel4");
            return (Criteria) this;
        }

        public Criteria andChannel4GreaterThan(String value) {
            addCriterion("channel4 >", value, "channel4");
            return (Criteria) this;
        }

        public Criteria andChannel4GreaterThanOrEqualTo(String value) {
            addCriterion("channel4 >=", value, "channel4");
            return (Criteria) this;
        }

        public Criteria andChannel4LessThan(String value) {
            addCriterion("channel4 <", value, "channel4");
            return (Criteria) this;
        }

        public Criteria andChannel4LessThanOrEqualTo(String value) {
            addCriterion("channel4 <=", value, "channel4");
            return (Criteria) this;
        }

        public Criteria andChannel4Like(String value) {
            addCriterion("channel4 like", value, "channel4");
            return (Criteria) this;
        }

        public Criteria andChannel4NotLike(String value) {
            addCriterion("channel4 not like", value, "channel4");
            return (Criteria) this;
        }

        public Criteria andChannel4In(List<String> values) {
            addCriterion("channel4 in", values, "channel4");
            return (Criteria) this;
        }

        public Criteria andChannel4NotIn(List<String> values) {
            addCriterion("channel4 not in", values, "channel4");
            return (Criteria) this;
        }

        public Criteria andChannel4Between(String value1, String value2) {
            addCriterion("channel4 between", value1, value2, "channel4");
            return (Criteria) this;
        }

        public Criteria andChannel4NotBetween(String value1, String value2) {
            addCriterion("channel4 not between", value1, value2, "channel4");
            return (Criteria) this;
        }

        public Criteria andChannel5IsNull() {
            addCriterion("channel5 is null");
            return (Criteria) this;
        }

        public Criteria andChannel5IsNotNull() {
            addCriterion("channel5 is not null");
            return (Criteria) this;
        }

        public Criteria andChannel5EqualTo(String value) {
            addCriterion("channel5 =", value, "channel5");
            return (Criteria) this;
        }

        public Criteria andChannel5NotEqualTo(String value) {
            addCriterion("channel5 <>", value, "channel5");
            return (Criteria) this;
        }

        public Criteria andChannel5GreaterThan(String value) {
            addCriterion("channel5 >", value, "channel5");
            return (Criteria) this;
        }

        public Criteria andChannel5GreaterThanOrEqualTo(String value) {
            addCriterion("channel5 >=", value, "channel5");
            return (Criteria) this;
        }

        public Criteria andChannel5LessThan(String value) {
            addCriterion("channel5 <", value, "channel5");
            return (Criteria) this;
        }

        public Criteria andChannel5LessThanOrEqualTo(String value) {
            addCriterion("channel5 <=", value, "channel5");
            return (Criteria) this;
        }

        public Criteria andChannel5Like(String value) {
            addCriterion("channel5 like", value, "channel5");
            return (Criteria) this;
        }

        public Criteria andChannel5NotLike(String value) {
            addCriterion("channel5 not like", value, "channel5");
            return (Criteria) this;
        }

        public Criteria andChannel5In(List<String> values) {
            addCriterion("channel5 in", values, "channel5");
            return (Criteria) this;
        }

        public Criteria andChannel5NotIn(List<String> values) {
            addCriterion("channel5 not in", values, "channel5");
            return (Criteria) this;
        }

        public Criteria andChannel5Between(String value1, String value2) {
            addCriterion("channel5 between", value1, value2, "channel5");
            return (Criteria) this;
        }

        public Criteria andChannel5NotBetween(String value1, String value2) {
            addCriterion("channel5 not between", value1, value2, "channel5");
            return (Criteria) this;
        }

        public Criteria andChannel6IsNull() {
            addCriterion("channel6 is null");
            return (Criteria) this;
        }

        public Criteria andChannel6IsNotNull() {
            addCriterion("channel6 is not null");
            return (Criteria) this;
        }

        public Criteria andChannel6EqualTo(String value) {
            addCriterion("channel6 =", value, "channel6");
            return (Criteria) this;
        }

        public Criteria andChannel6NotEqualTo(String value) {
            addCriterion("channel6 <>", value, "channel6");
            return (Criteria) this;
        }

        public Criteria andChannel6GreaterThan(String value) {
            addCriterion("channel6 >", value, "channel6");
            return (Criteria) this;
        }

        public Criteria andChannel6GreaterThanOrEqualTo(String value) {
            addCriterion("channel6 >=", value, "channel6");
            return (Criteria) this;
        }

        public Criteria andChannel6LessThan(String value) {
            addCriterion("channel6 <", value, "channel6");
            return (Criteria) this;
        }

        public Criteria andChannel6LessThanOrEqualTo(String value) {
            addCriterion("channel6 <=", value, "channel6");
            return (Criteria) this;
        }

        public Criteria andChannel6Like(String value) {
            addCriterion("channel6 like", value, "channel6");
            return (Criteria) this;
        }

        public Criteria andChannel6NotLike(String value) {
            addCriterion("channel6 not like", value, "channel6");
            return (Criteria) this;
        }

        public Criteria andChannel6In(List<String> values) {
            addCriterion("channel6 in", values, "channel6");
            return (Criteria) this;
        }

        public Criteria andChannel6NotIn(List<String> values) {
            addCriterion("channel6 not in", values, "channel6");
            return (Criteria) this;
        }

        public Criteria andChannel6Between(String value1, String value2) {
            addCriterion("channel6 between", value1, value2, "channel6");
            return (Criteria) this;
        }

        public Criteria andChannel6NotBetween(String value1, String value2) {
            addCriterion("channel6 not between", value1, value2, "channel6");
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