package com.ybinsure.icar.user.model.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class PolicyApplicantDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PolicyApplicantDOExample() {
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

        public Criteria andOwnerNameIsNull() {
            addCriterion("owner_name is null");
            return (Criteria) this;
        }

        public Criteria andOwnerNameIsNotNull() {
            addCriterion("owner_name is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerNameEqualTo(String value) {
            addCriterion("owner_name =", value, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameNotEqualTo(String value) {
            addCriterion("owner_name <>", value, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameGreaterThan(String value) {
            addCriterion("owner_name >", value, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameGreaterThanOrEqualTo(String value) {
            addCriterion("owner_name >=", value, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameLessThan(String value) {
            addCriterion("owner_name <", value, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameLessThanOrEqualTo(String value) {
            addCriterion("owner_name <=", value, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameLike(String value) {
            addCriterion("owner_name like", value, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameNotLike(String value) {
            addCriterion("owner_name not like", value, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameIn(List<String> values) {
            addCriterion("owner_name in", values, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameNotIn(List<String> values) {
            addCriterion("owner_name not in", values, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameBetween(String value1, String value2) {
            addCriterion("owner_name between", value1, value2, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameNotBetween(String value1, String value2) {
            addCriterion("owner_name not between", value1, value2, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerPhoneIsNull() {
            addCriterion("owner_phone is null");
            return (Criteria) this;
        }

        public Criteria andOwnerPhoneIsNotNull() {
            addCriterion("owner_phone is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerPhoneEqualTo(String value) {
            addCriterion("owner_phone =", value, "ownerPhone");
            return (Criteria) this;
        }

        public Criteria andOwnerPhoneNotEqualTo(String value) {
            addCriterion("owner_phone <>", value, "ownerPhone");
            return (Criteria) this;
        }

        public Criteria andOwnerPhoneGreaterThan(String value) {
            addCriterion("owner_phone >", value, "ownerPhone");
            return (Criteria) this;
        }

        public Criteria andOwnerPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("owner_phone >=", value, "ownerPhone");
            return (Criteria) this;
        }

        public Criteria andOwnerPhoneLessThan(String value) {
            addCriterion("owner_phone <", value, "ownerPhone");
            return (Criteria) this;
        }

        public Criteria andOwnerPhoneLessThanOrEqualTo(String value) {
            addCriterion("owner_phone <=", value, "ownerPhone");
            return (Criteria) this;
        }

        public Criteria andOwnerPhoneLike(String value) {
            addCriterion("owner_phone like", value, "ownerPhone");
            return (Criteria) this;
        }

        public Criteria andOwnerPhoneNotLike(String value) {
            addCriterion("owner_phone not like", value, "ownerPhone");
            return (Criteria) this;
        }

        public Criteria andOwnerPhoneIn(List<String> values) {
            addCriterion("owner_phone in", values, "ownerPhone");
            return (Criteria) this;
        }

        public Criteria andOwnerPhoneNotIn(List<String> values) {
            addCriterion("owner_phone not in", values, "ownerPhone");
            return (Criteria) this;
        }

        public Criteria andOwnerPhoneBetween(String value1, String value2) {
            addCriterion("owner_phone between", value1, value2, "ownerPhone");
            return (Criteria) this;
        }

        public Criteria andOwnerPhoneNotBetween(String value1, String value2) {
            addCriterion("owner_phone not between", value1, value2, "ownerPhone");
            return (Criteria) this;
        }

        public Criteria andOwnerIdTypeIsNull() {
            addCriterion("owner_id_type is null");
            return (Criteria) this;
        }

        public Criteria andOwnerIdTypeIsNotNull() {
            addCriterion("owner_id_type is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerIdTypeEqualTo(String value) {
            addCriterion("owner_id_type =", value, "ownerIdType");
            return (Criteria) this;
        }

        public Criteria andOwnerIdTypeNotEqualTo(String value) {
            addCriterion("owner_id_type <>", value, "ownerIdType");
            return (Criteria) this;
        }

        public Criteria andOwnerIdTypeGreaterThan(String value) {
            addCriterion("owner_id_type >", value, "ownerIdType");
            return (Criteria) this;
        }

        public Criteria andOwnerIdTypeGreaterThanOrEqualTo(String value) {
            addCriterion("owner_id_type >=", value, "ownerIdType");
            return (Criteria) this;
        }

        public Criteria andOwnerIdTypeLessThan(String value) {
            addCriterion("owner_id_type <", value, "ownerIdType");
            return (Criteria) this;
        }

        public Criteria andOwnerIdTypeLessThanOrEqualTo(String value) {
            addCriterion("owner_id_type <=", value, "ownerIdType");
            return (Criteria) this;
        }

        public Criteria andOwnerIdTypeLike(String value) {
            addCriterion("owner_id_type like", value, "ownerIdType");
            return (Criteria) this;
        }

        public Criteria andOwnerIdTypeNotLike(String value) {
            addCriterion("owner_id_type not like", value, "ownerIdType");
            return (Criteria) this;
        }

        public Criteria andOwnerIdTypeIn(List<String> values) {
            addCriterion("owner_id_type in", values, "ownerIdType");
            return (Criteria) this;
        }

        public Criteria andOwnerIdTypeNotIn(List<String> values) {
            addCriterion("owner_id_type not in", values, "ownerIdType");
            return (Criteria) this;
        }

        public Criteria andOwnerIdTypeBetween(String value1, String value2) {
            addCriterion("owner_id_type between", value1, value2, "ownerIdType");
            return (Criteria) this;
        }

        public Criteria andOwnerIdTypeNotBetween(String value1, String value2) {
            addCriterion("owner_id_type not between", value1, value2, "ownerIdType");
            return (Criteria) this;
        }

        public Criteria andOwnerIdNoIsNull() {
            addCriterion("owner_id_no is null");
            return (Criteria) this;
        }

        public Criteria andOwnerIdNoIsNotNull() {
            addCriterion("owner_id_no is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerIdNoEqualTo(String value) {
            addCriterion("owner_id_no =", value, "ownerIdNo");
            return (Criteria) this;
        }

        public Criteria andOwnerIdNoNotEqualTo(String value) {
            addCriterion("owner_id_no <>", value, "ownerIdNo");
            return (Criteria) this;
        }

        public Criteria andOwnerIdNoGreaterThan(String value) {
            addCriterion("owner_id_no >", value, "ownerIdNo");
            return (Criteria) this;
        }

        public Criteria andOwnerIdNoGreaterThanOrEqualTo(String value) {
            addCriterion("owner_id_no >=", value, "ownerIdNo");
            return (Criteria) this;
        }

        public Criteria andOwnerIdNoLessThan(String value) {
            addCriterion("owner_id_no <", value, "ownerIdNo");
            return (Criteria) this;
        }

        public Criteria andOwnerIdNoLessThanOrEqualTo(String value) {
            addCriterion("owner_id_no <=", value, "ownerIdNo");
            return (Criteria) this;
        }

        public Criteria andOwnerIdNoLike(String value) {
            addCriterion("owner_id_no like", value, "ownerIdNo");
            return (Criteria) this;
        }

        public Criteria andOwnerIdNoNotLike(String value) {
            addCriterion("owner_id_no not like", value, "ownerIdNo");
            return (Criteria) this;
        }

        public Criteria andOwnerIdNoIn(List<String> values) {
            addCriterion("owner_id_no in", values, "ownerIdNo");
            return (Criteria) this;
        }

        public Criteria andOwnerIdNoNotIn(List<String> values) {
            addCriterion("owner_id_no not in", values, "ownerIdNo");
            return (Criteria) this;
        }

        public Criteria andOwnerIdNoBetween(String value1, String value2) {
            addCriterion("owner_id_no between", value1, value2, "ownerIdNo");
            return (Criteria) this;
        }

        public Criteria andOwnerIdNoNotBetween(String value1, String value2) {
            addCriterion("owner_id_no not between", value1, value2, "ownerIdNo");
            return (Criteria) this;
        }

        public Criteria andOwnerAddrIsNull() {
            addCriterion("owner_addr is null");
            return (Criteria) this;
        }

        public Criteria andOwnerAddrIsNotNull() {
            addCriterion("owner_addr is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerAddrEqualTo(String value) {
            addCriterion("owner_addr =", value, "ownerAddr");
            return (Criteria) this;
        }

        public Criteria andOwnerAddrNotEqualTo(String value) {
            addCriterion("owner_addr <>", value, "ownerAddr");
            return (Criteria) this;
        }

        public Criteria andOwnerAddrGreaterThan(String value) {
            addCriterion("owner_addr >", value, "ownerAddr");
            return (Criteria) this;
        }

        public Criteria andOwnerAddrGreaterThanOrEqualTo(String value) {
            addCriterion("owner_addr >=", value, "ownerAddr");
            return (Criteria) this;
        }

        public Criteria andOwnerAddrLessThan(String value) {
            addCriterion("owner_addr <", value, "ownerAddr");
            return (Criteria) this;
        }

        public Criteria andOwnerAddrLessThanOrEqualTo(String value) {
            addCriterion("owner_addr <=", value, "ownerAddr");
            return (Criteria) this;
        }

        public Criteria andOwnerAddrLike(String value) {
            addCriterion("owner_addr like", value, "ownerAddr");
            return (Criteria) this;
        }

        public Criteria andOwnerAddrNotLike(String value) {
            addCriterion("owner_addr not like", value, "ownerAddr");
            return (Criteria) this;
        }

        public Criteria andOwnerAddrIn(List<String> values) {
            addCriterion("owner_addr in", values, "ownerAddr");
            return (Criteria) this;
        }

        public Criteria andOwnerAddrNotIn(List<String> values) {
            addCriterion("owner_addr not in", values, "ownerAddr");
            return (Criteria) this;
        }

        public Criteria andOwnerAddrBetween(String value1, String value2) {
            addCriterion("owner_addr between", value1, value2, "ownerAddr");
            return (Criteria) this;
        }

        public Criteria andOwnerAddrNotBetween(String value1, String value2) {
            addCriterion("owner_addr not between", value1, value2, "ownerAddr");
            return (Criteria) this;
        }

        public Criteria andOwnerBirthdayIsNull() {
            addCriterion("owner_birthday is null");
            return (Criteria) this;
        }

        public Criteria andOwnerBirthdayIsNotNull() {
            addCriterion("owner_birthday is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerBirthdayEqualTo(Date value) {
            addCriterionForJDBCDate("owner_birthday =", value, "ownerBirthday");
            return (Criteria) this;
        }

        public Criteria andOwnerBirthdayNotEqualTo(Date value) {
            addCriterionForJDBCDate("owner_birthday <>", value, "ownerBirthday");
            return (Criteria) this;
        }

        public Criteria andOwnerBirthdayGreaterThan(Date value) {
            addCriterionForJDBCDate("owner_birthday >", value, "ownerBirthday");
            return (Criteria) this;
        }

        public Criteria andOwnerBirthdayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("owner_birthday >=", value, "ownerBirthday");
            return (Criteria) this;
        }

        public Criteria andOwnerBirthdayLessThan(Date value) {
            addCriterionForJDBCDate("owner_birthday <", value, "ownerBirthday");
            return (Criteria) this;
        }

        public Criteria andOwnerBirthdayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("owner_birthday <=", value, "ownerBirthday");
            return (Criteria) this;
        }

        public Criteria andOwnerBirthdayIn(List<Date> values) {
            addCriterionForJDBCDate("owner_birthday in", values, "ownerBirthday");
            return (Criteria) this;
        }

        public Criteria andOwnerBirthdayNotIn(List<Date> values) {
            addCriterionForJDBCDate("owner_birthday not in", values, "ownerBirthday");
            return (Criteria) this;
        }

        public Criteria andOwnerBirthdayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("owner_birthday between", value1, value2, "ownerBirthday");
            return (Criteria) this;
        }

        public Criteria andOwnerBirthdayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("owner_birthday not between", value1, value2, "ownerBirthday");
            return (Criteria) this;
        }

        public Criteria andOwnerSexIsNull() {
            addCriterion("owner_sex is null");
            return (Criteria) this;
        }

        public Criteria andOwnerSexIsNotNull() {
            addCriterion("owner_sex is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerSexEqualTo(Byte value) {
            addCriterion("owner_sex =", value, "ownerSex");
            return (Criteria) this;
        }

        public Criteria andOwnerSexNotEqualTo(Byte value) {
            addCriterion("owner_sex <>", value, "ownerSex");
            return (Criteria) this;
        }

        public Criteria andOwnerSexGreaterThan(Byte value) {
            addCriterion("owner_sex >", value, "ownerSex");
            return (Criteria) this;
        }

        public Criteria andOwnerSexGreaterThanOrEqualTo(Byte value) {
            addCriterion("owner_sex >=", value, "ownerSex");
            return (Criteria) this;
        }

        public Criteria andOwnerSexLessThan(Byte value) {
            addCriterion("owner_sex <", value, "ownerSex");
            return (Criteria) this;
        }

        public Criteria andOwnerSexLessThanOrEqualTo(Byte value) {
            addCriterion("owner_sex <=", value, "ownerSex");
            return (Criteria) this;
        }

        public Criteria andOwnerSexIn(List<Byte> values) {
            addCriterion("owner_sex in", values, "ownerSex");
            return (Criteria) this;
        }

        public Criteria andOwnerSexNotIn(List<Byte> values) {
            addCriterion("owner_sex not in", values, "ownerSex");
            return (Criteria) this;
        }

        public Criteria andOwnerSexBetween(Byte value1, Byte value2) {
            addCriterion("owner_sex between", value1, value2, "ownerSex");
            return (Criteria) this;
        }

        public Criteria andOwnerSexNotBetween(Byte value1, Byte value2) {
            addCriterion("owner_sex not between", value1, value2, "ownerSex");
            return (Criteria) this;
        }

        public Criteria andOwnerEmailIsNull() {
            addCriterion("owner_email is null");
            return (Criteria) this;
        }

        public Criteria andOwnerEmailIsNotNull() {
            addCriterion("owner_email is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerEmailEqualTo(String value) {
            addCriterion("owner_email =", value, "ownerEmail");
            return (Criteria) this;
        }

        public Criteria andOwnerEmailNotEqualTo(String value) {
            addCriterion("owner_email <>", value, "ownerEmail");
            return (Criteria) this;
        }

        public Criteria andOwnerEmailGreaterThan(String value) {
            addCriterion("owner_email >", value, "ownerEmail");
            return (Criteria) this;
        }

        public Criteria andOwnerEmailGreaterThanOrEqualTo(String value) {
            addCriterion("owner_email >=", value, "ownerEmail");
            return (Criteria) this;
        }

        public Criteria andOwnerEmailLessThan(String value) {
            addCriterion("owner_email <", value, "ownerEmail");
            return (Criteria) this;
        }

        public Criteria andOwnerEmailLessThanOrEqualTo(String value) {
            addCriterion("owner_email <=", value, "ownerEmail");
            return (Criteria) this;
        }

        public Criteria andOwnerEmailLike(String value) {
            addCriterion("owner_email like", value, "ownerEmail");
            return (Criteria) this;
        }

        public Criteria andOwnerEmailNotLike(String value) {
            addCriterion("owner_email not like", value, "ownerEmail");
            return (Criteria) this;
        }

        public Criteria andOwnerEmailIn(List<String> values) {
            addCriterion("owner_email in", values, "ownerEmail");
            return (Criteria) this;
        }

        public Criteria andOwnerEmailNotIn(List<String> values) {
            addCriterion("owner_email not in", values, "ownerEmail");
            return (Criteria) this;
        }

        public Criteria andOwnerEmailBetween(String value1, String value2) {
            addCriterion("owner_email between", value1, value2, "ownerEmail");
            return (Criteria) this;
        }

        public Criteria andOwnerEmailNotBetween(String value1, String value2) {
            addCriterion("owner_email not between", value1, value2, "ownerEmail");
            return (Criteria) this;
        }

        public Criteria andHolderNameIsNull() {
            addCriterion("holder_name is null");
            return (Criteria) this;
        }

        public Criteria andHolderNameIsNotNull() {
            addCriterion("holder_name is not null");
            return (Criteria) this;
        }

        public Criteria andHolderNameEqualTo(String value) {
            addCriterion("holder_name =", value, "holderName");
            return (Criteria) this;
        }

        public Criteria andHolderNameNotEqualTo(String value) {
            addCriterion("holder_name <>", value, "holderName");
            return (Criteria) this;
        }

        public Criteria andHolderNameGreaterThan(String value) {
            addCriterion("holder_name >", value, "holderName");
            return (Criteria) this;
        }

        public Criteria andHolderNameGreaterThanOrEqualTo(String value) {
            addCriterion("holder_name >=", value, "holderName");
            return (Criteria) this;
        }

        public Criteria andHolderNameLessThan(String value) {
            addCriterion("holder_name <", value, "holderName");
            return (Criteria) this;
        }

        public Criteria andHolderNameLessThanOrEqualTo(String value) {
            addCriterion("holder_name <=", value, "holderName");
            return (Criteria) this;
        }

        public Criteria andHolderNameLike(String value) {
            addCriterion("holder_name like", value, "holderName");
            return (Criteria) this;
        }

        public Criteria andHolderNameNotLike(String value) {
            addCriterion("holder_name not like", value, "holderName");
            return (Criteria) this;
        }

        public Criteria andHolderNameIn(List<String> values) {
            addCriterion("holder_name in", values, "holderName");
            return (Criteria) this;
        }

        public Criteria andHolderNameNotIn(List<String> values) {
            addCriterion("holder_name not in", values, "holderName");
            return (Criteria) this;
        }

        public Criteria andHolderNameBetween(String value1, String value2) {
            addCriterion("holder_name between", value1, value2, "holderName");
            return (Criteria) this;
        }

        public Criteria andHolderNameNotBetween(String value1, String value2) {
            addCriterion("holder_name not between", value1, value2, "holderName");
            return (Criteria) this;
        }

        public Criteria andHolderPhoneIsNull() {
            addCriterion("holder_phone is null");
            return (Criteria) this;
        }

        public Criteria andHolderPhoneIsNotNull() {
            addCriterion("holder_phone is not null");
            return (Criteria) this;
        }

        public Criteria andHolderPhoneEqualTo(String value) {
            addCriterion("holder_phone =", value, "holderPhone");
            return (Criteria) this;
        }

        public Criteria andHolderPhoneNotEqualTo(String value) {
            addCriterion("holder_phone <>", value, "holderPhone");
            return (Criteria) this;
        }

        public Criteria andHolderPhoneGreaterThan(String value) {
            addCriterion("holder_phone >", value, "holderPhone");
            return (Criteria) this;
        }

        public Criteria andHolderPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("holder_phone >=", value, "holderPhone");
            return (Criteria) this;
        }

        public Criteria andHolderPhoneLessThan(String value) {
            addCriterion("holder_phone <", value, "holderPhone");
            return (Criteria) this;
        }

        public Criteria andHolderPhoneLessThanOrEqualTo(String value) {
            addCriterion("holder_phone <=", value, "holderPhone");
            return (Criteria) this;
        }

        public Criteria andHolderPhoneLike(String value) {
            addCriterion("holder_phone like", value, "holderPhone");
            return (Criteria) this;
        }

        public Criteria andHolderPhoneNotLike(String value) {
            addCriterion("holder_phone not like", value, "holderPhone");
            return (Criteria) this;
        }

        public Criteria andHolderPhoneIn(List<String> values) {
            addCriterion("holder_phone in", values, "holderPhone");
            return (Criteria) this;
        }

        public Criteria andHolderPhoneNotIn(List<String> values) {
            addCriterion("holder_phone not in", values, "holderPhone");
            return (Criteria) this;
        }

        public Criteria andHolderPhoneBetween(String value1, String value2) {
            addCriterion("holder_phone between", value1, value2, "holderPhone");
            return (Criteria) this;
        }

        public Criteria andHolderPhoneNotBetween(String value1, String value2) {
            addCriterion("holder_phone not between", value1, value2, "holderPhone");
            return (Criteria) this;
        }

        public Criteria andHolderIdTypeIsNull() {
            addCriterion("holder_id_type is null");
            return (Criteria) this;
        }

        public Criteria andHolderIdTypeIsNotNull() {
            addCriterion("holder_id_type is not null");
            return (Criteria) this;
        }

        public Criteria andHolderIdTypeEqualTo(String value) {
            addCriterion("holder_id_type =", value, "holderIdType");
            return (Criteria) this;
        }

        public Criteria andHolderIdTypeNotEqualTo(String value) {
            addCriterion("holder_id_type <>", value, "holderIdType");
            return (Criteria) this;
        }

        public Criteria andHolderIdTypeGreaterThan(String value) {
            addCriterion("holder_id_type >", value, "holderIdType");
            return (Criteria) this;
        }

        public Criteria andHolderIdTypeGreaterThanOrEqualTo(String value) {
            addCriterion("holder_id_type >=", value, "holderIdType");
            return (Criteria) this;
        }

        public Criteria andHolderIdTypeLessThan(String value) {
            addCriterion("holder_id_type <", value, "holderIdType");
            return (Criteria) this;
        }

        public Criteria andHolderIdTypeLessThanOrEqualTo(String value) {
            addCriterion("holder_id_type <=", value, "holderIdType");
            return (Criteria) this;
        }

        public Criteria andHolderIdTypeLike(String value) {
            addCriterion("holder_id_type like", value, "holderIdType");
            return (Criteria) this;
        }

        public Criteria andHolderIdTypeNotLike(String value) {
            addCriterion("holder_id_type not like", value, "holderIdType");
            return (Criteria) this;
        }

        public Criteria andHolderIdTypeIn(List<String> values) {
            addCriterion("holder_id_type in", values, "holderIdType");
            return (Criteria) this;
        }

        public Criteria andHolderIdTypeNotIn(List<String> values) {
            addCriterion("holder_id_type not in", values, "holderIdType");
            return (Criteria) this;
        }

        public Criteria andHolderIdTypeBetween(String value1, String value2) {
            addCriterion("holder_id_type between", value1, value2, "holderIdType");
            return (Criteria) this;
        }

        public Criteria andHolderIdTypeNotBetween(String value1, String value2) {
            addCriterion("holder_id_type not between", value1, value2, "holderIdType");
            return (Criteria) this;
        }

        public Criteria andHolderIdNoIsNull() {
            addCriterion("holder_id_no is null");
            return (Criteria) this;
        }

        public Criteria andHolderIdNoIsNotNull() {
            addCriterion("holder_id_no is not null");
            return (Criteria) this;
        }

        public Criteria andHolderIdNoEqualTo(String value) {
            addCriterion("holder_id_no =", value, "holderIdNo");
            return (Criteria) this;
        }

        public Criteria andHolderIdNoNotEqualTo(String value) {
            addCriterion("holder_id_no <>", value, "holderIdNo");
            return (Criteria) this;
        }

        public Criteria andHolderIdNoGreaterThan(String value) {
            addCriterion("holder_id_no >", value, "holderIdNo");
            return (Criteria) this;
        }

        public Criteria andHolderIdNoGreaterThanOrEqualTo(String value) {
            addCriterion("holder_id_no >=", value, "holderIdNo");
            return (Criteria) this;
        }

        public Criteria andHolderIdNoLessThan(String value) {
            addCriterion("holder_id_no <", value, "holderIdNo");
            return (Criteria) this;
        }

        public Criteria andHolderIdNoLessThanOrEqualTo(String value) {
            addCriterion("holder_id_no <=", value, "holderIdNo");
            return (Criteria) this;
        }

        public Criteria andHolderIdNoLike(String value) {
            addCriterion("holder_id_no like", value, "holderIdNo");
            return (Criteria) this;
        }

        public Criteria andHolderIdNoNotLike(String value) {
            addCriterion("holder_id_no not like", value, "holderIdNo");
            return (Criteria) this;
        }

        public Criteria andHolderIdNoIn(List<String> values) {
            addCriterion("holder_id_no in", values, "holderIdNo");
            return (Criteria) this;
        }

        public Criteria andHolderIdNoNotIn(List<String> values) {
            addCriterion("holder_id_no not in", values, "holderIdNo");
            return (Criteria) this;
        }

        public Criteria andHolderIdNoBetween(String value1, String value2) {
            addCriterion("holder_id_no between", value1, value2, "holderIdNo");
            return (Criteria) this;
        }

        public Criteria andHolderIdNoNotBetween(String value1, String value2) {
            addCriterion("holder_id_no not between", value1, value2, "holderIdNo");
            return (Criteria) this;
        }

        public Criteria andHolderAddrIsNull() {
            addCriterion("holder_addr is null");
            return (Criteria) this;
        }

        public Criteria andHolderAddrIsNotNull() {
            addCriterion("holder_addr is not null");
            return (Criteria) this;
        }

        public Criteria andHolderAddrEqualTo(String value) {
            addCriterion("holder_addr =", value, "holderAddr");
            return (Criteria) this;
        }

        public Criteria andHolderAddrNotEqualTo(String value) {
            addCriterion("holder_addr <>", value, "holderAddr");
            return (Criteria) this;
        }

        public Criteria andHolderAddrGreaterThan(String value) {
            addCriterion("holder_addr >", value, "holderAddr");
            return (Criteria) this;
        }

        public Criteria andHolderAddrGreaterThanOrEqualTo(String value) {
            addCriterion("holder_addr >=", value, "holderAddr");
            return (Criteria) this;
        }

        public Criteria andHolderAddrLessThan(String value) {
            addCriterion("holder_addr <", value, "holderAddr");
            return (Criteria) this;
        }

        public Criteria andHolderAddrLessThanOrEqualTo(String value) {
            addCriterion("holder_addr <=", value, "holderAddr");
            return (Criteria) this;
        }

        public Criteria andHolderAddrLike(String value) {
            addCriterion("holder_addr like", value, "holderAddr");
            return (Criteria) this;
        }

        public Criteria andHolderAddrNotLike(String value) {
            addCriterion("holder_addr not like", value, "holderAddr");
            return (Criteria) this;
        }

        public Criteria andHolderAddrIn(List<String> values) {
            addCriterion("holder_addr in", values, "holderAddr");
            return (Criteria) this;
        }

        public Criteria andHolderAddrNotIn(List<String> values) {
            addCriterion("holder_addr not in", values, "holderAddr");
            return (Criteria) this;
        }

        public Criteria andHolderAddrBetween(String value1, String value2) {
            addCriterion("holder_addr between", value1, value2, "holderAddr");
            return (Criteria) this;
        }

        public Criteria andHolderAddrNotBetween(String value1, String value2) {
            addCriterion("holder_addr not between", value1, value2, "holderAddr");
            return (Criteria) this;
        }

        public Criteria andHolderBirthdayIsNull() {
            addCriterion("holder_birthday is null");
            return (Criteria) this;
        }

        public Criteria andHolderBirthdayIsNotNull() {
            addCriterion("holder_birthday is not null");
            return (Criteria) this;
        }

        public Criteria andHolderBirthdayEqualTo(Date value) {
            addCriterionForJDBCDate("holder_birthday =", value, "holderBirthday");
            return (Criteria) this;
        }

        public Criteria andHolderBirthdayNotEqualTo(Date value) {
            addCriterionForJDBCDate("holder_birthday <>", value, "holderBirthday");
            return (Criteria) this;
        }

        public Criteria andHolderBirthdayGreaterThan(Date value) {
            addCriterionForJDBCDate("holder_birthday >", value, "holderBirthday");
            return (Criteria) this;
        }

        public Criteria andHolderBirthdayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("holder_birthday >=", value, "holderBirthday");
            return (Criteria) this;
        }

        public Criteria andHolderBirthdayLessThan(Date value) {
            addCriterionForJDBCDate("holder_birthday <", value, "holderBirthday");
            return (Criteria) this;
        }

        public Criteria andHolderBirthdayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("holder_birthday <=", value, "holderBirthday");
            return (Criteria) this;
        }

        public Criteria andHolderBirthdayIn(List<Date> values) {
            addCriterionForJDBCDate("holder_birthday in", values, "holderBirthday");
            return (Criteria) this;
        }

        public Criteria andHolderBirthdayNotIn(List<Date> values) {
            addCriterionForJDBCDate("holder_birthday not in", values, "holderBirthday");
            return (Criteria) this;
        }

        public Criteria andHolderBirthdayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("holder_birthday between", value1, value2, "holderBirthday");
            return (Criteria) this;
        }

        public Criteria andHolderBirthdayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("holder_birthday not between", value1, value2, "holderBirthday");
            return (Criteria) this;
        }

        public Criteria andHolderSexIsNull() {
            addCriterion("holder_sex is null");
            return (Criteria) this;
        }

        public Criteria andHolderSexIsNotNull() {
            addCriterion("holder_sex is not null");
            return (Criteria) this;
        }

        public Criteria andHolderSexEqualTo(Byte value) {
            addCriterion("holder_sex =", value, "holderSex");
            return (Criteria) this;
        }

        public Criteria andHolderSexNotEqualTo(Byte value) {
            addCriterion("holder_sex <>", value, "holderSex");
            return (Criteria) this;
        }

        public Criteria andHolderSexGreaterThan(Byte value) {
            addCriterion("holder_sex >", value, "holderSex");
            return (Criteria) this;
        }

        public Criteria andHolderSexGreaterThanOrEqualTo(Byte value) {
            addCriterion("holder_sex >=", value, "holderSex");
            return (Criteria) this;
        }

        public Criteria andHolderSexLessThan(Byte value) {
            addCriterion("holder_sex <", value, "holderSex");
            return (Criteria) this;
        }

        public Criteria andHolderSexLessThanOrEqualTo(Byte value) {
            addCriterion("holder_sex <=", value, "holderSex");
            return (Criteria) this;
        }

        public Criteria andHolderSexIn(List<Byte> values) {
            addCriterion("holder_sex in", values, "holderSex");
            return (Criteria) this;
        }

        public Criteria andHolderSexNotIn(List<Byte> values) {
            addCriterion("holder_sex not in", values, "holderSex");
            return (Criteria) this;
        }

        public Criteria andHolderSexBetween(Byte value1, Byte value2) {
            addCriterion("holder_sex between", value1, value2, "holderSex");
            return (Criteria) this;
        }

        public Criteria andHolderSexNotBetween(Byte value1, Byte value2) {
            addCriterion("holder_sex not between", value1, value2, "holderSex");
            return (Criteria) this;
        }

        public Criteria andInsuredNameIsNull() {
            addCriterion("insured_name is null");
            return (Criteria) this;
        }

        public Criteria andInsuredNameIsNotNull() {
            addCriterion("insured_name is not null");
            return (Criteria) this;
        }

        public Criteria andInsuredNameEqualTo(String value) {
            addCriterion("insured_name =", value, "insuredName");
            return (Criteria) this;
        }

        public Criteria andInsuredNameNotEqualTo(String value) {
            addCriterion("insured_name <>", value, "insuredName");
            return (Criteria) this;
        }

        public Criteria andInsuredNameGreaterThan(String value) {
            addCriterion("insured_name >", value, "insuredName");
            return (Criteria) this;
        }

        public Criteria andInsuredNameGreaterThanOrEqualTo(String value) {
            addCriterion("insured_name >=", value, "insuredName");
            return (Criteria) this;
        }

        public Criteria andInsuredNameLessThan(String value) {
            addCriterion("insured_name <", value, "insuredName");
            return (Criteria) this;
        }

        public Criteria andInsuredNameLessThanOrEqualTo(String value) {
            addCriterion("insured_name <=", value, "insuredName");
            return (Criteria) this;
        }

        public Criteria andInsuredNameLike(String value) {
            addCriterion("insured_name like", value, "insuredName");
            return (Criteria) this;
        }

        public Criteria andInsuredNameNotLike(String value) {
            addCriterion("insured_name not like", value, "insuredName");
            return (Criteria) this;
        }

        public Criteria andInsuredNameIn(List<String> values) {
            addCriterion("insured_name in", values, "insuredName");
            return (Criteria) this;
        }

        public Criteria andInsuredNameNotIn(List<String> values) {
            addCriterion("insured_name not in", values, "insuredName");
            return (Criteria) this;
        }

        public Criteria andInsuredNameBetween(String value1, String value2) {
            addCriterion("insured_name between", value1, value2, "insuredName");
            return (Criteria) this;
        }

        public Criteria andInsuredNameNotBetween(String value1, String value2) {
            addCriterion("insured_name not between", value1, value2, "insuredName");
            return (Criteria) this;
        }

        public Criteria andInsuredPhoneIsNull() {
            addCriterion("insured_phone is null");
            return (Criteria) this;
        }

        public Criteria andInsuredPhoneIsNotNull() {
            addCriterion("insured_phone is not null");
            return (Criteria) this;
        }

        public Criteria andInsuredPhoneEqualTo(String value) {
            addCriterion("insured_phone =", value, "insuredPhone");
            return (Criteria) this;
        }

        public Criteria andInsuredPhoneNotEqualTo(String value) {
            addCriterion("insured_phone <>", value, "insuredPhone");
            return (Criteria) this;
        }

        public Criteria andInsuredPhoneGreaterThan(String value) {
            addCriterion("insured_phone >", value, "insuredPhone");
            return (Criteria) this;
        }

        public Criteria andInsuredPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("insured_phone >=", value, "insuredPhone");
            return (Criteria) this;
        }

        public Criteria andInsuredPhoneLessThan(String value) {
            addCriterion("insured_phone <", value, "insuredPhone");
            return (Criteria) this;
        }

        public Criteria andInsuredPhoneLessThanOrEqualTo(String value) {
            addCriterion("insured_phone <=", value, "insuredPhone");
            return (Criteria) this;
        }

        public Criteria andInsuredPhoneLike(String value) {
            addCriterion("insured_phone like", value, "insuredPhone");
            return (Criteria) this;
        }

        public Criteria andInsuredPhoneNotLike(String value) {
            addCriterion("insured_phone not like", value, "insuredPhone");
            return (Criteria) this;
        }

        public Criteria andInsuredPhoneIn(List<String> values) {
            addCriterion("insured_phone in", values, "insuredPhone");
            return (Criteria) this;
        }

        public Criteria andInsuredPhoneNotIn(List<String> values) {
            addCriterion("insured_phone not in", values, "insuredPhone");
            return (Criteria) this;
        }

        public Criteria andInsuredPhoneBetween(String value1, String value2) {
            addCriterion("insured_phone between", value1, value2, "insuredPhone");
            return (Criteria) this;
        }

        public Criteria andInsuredPhoneNotBetween(String value1, String value2) {
            addCriterion("insured_phone not between", value1, value2, "insuredPhone");
            return (Criteria) this;
        }

        public Criteria andInsuredIdTypeIsNull() {
            addCriterion("insured_id_type is null");
            return (Criteria) this;
        }

        public Criteria andInsuredIdTypeIsNotNull() {
            addCriterion("insured_id_type is not null");
            return (Criteria) this;
        }

        public Criteria andInsuredIdTypeEqualTo(String value) {
            addCriterion("insured_id_type =", value, "insuredIdType");
            return (Criteria) this;
        }

        public Criteria andInsuredIdTypeNotEqualTo(String value) {
            addCriterion("insured_id_type <>", value, "insuredIdType");
            return (Criteria) this;
        }

        public Criteria andInsuredIdTypeGreaterThan(String value) {
            addCriterion("insured_id_type >", value, "insuredIdType");
            return (Criteria) this;
        }

        public Criteria andInsuredIdTypeGreaterThanOrEqualTo(String value) {
            addCriterion("insured_id_type >=", value, "insuredIdType");
            return (Criteria) this;
        }

        public Criteria andInsuredIdTypeLessThan(String value) {
            addCriterion("insured_id_type <", value, "insuredIdType");
            return (Criteria) this;
        }

        public Criteria andInsuredIdTypeLessThanOrEqualTo(String value) {
            addCriterion("insured_id_type <=", value, "insuredIdType");
            return (Criteria) this;
        }

        public Criteria andInsuredIdTypeLike(String value) {
            addCriterion("insured_id_type like", value, "insuredIdType");
            return (Criteria) this;
        }

        public Criteria andInsuredIdTypeNotLike(String value) {
            addCriterion("insured_id_type not like", value, "insuredIdType");
            return (Criteria) this;
        }

        public Criteria andInsuredIdTypeIn(List<String> values) {
            addCriterion("insured_id_type in", values, "insuredIdType");
            return (Criteria) this;
        }

        public Criteria andInsuredIdTypeNotIn(List<String> values) {
            addCriterion("insured_id_type not in", values, "insuredIdType");
            return (Criteria) this;
        }

        public Criteria andInsuredIdTypeBetween(String value1, String value2) {
            addCriterion("insured_id_type between", value1, value2, "insuredIdType");
            return (Criteria) this;
        }

        public Criteria andInsuredIdTypeNotBetween(String value1, String value2) {
            addCriterion("insured_id_type not between", value1, value2, "insuredIdType");
            return (Criteria) this;
        }

        public Criteria andInsuredIdNoIsNull() {
            addCriterion("insured_id_no is null");
            return (Criteria) this;
        }

        public Criteria andInsuredIdNoIsNotNull() {
            addCriterion("insured_id_no is not null");
            return (Criteria) this;
        }

        public Criteria andInsuredIdNoEqualTo(String value) {
            addCriterion("insured_id_no =", value, "insuredIdNo");
            return (Criteria) this;
        }

        public Criteria andInsuredIdNoNotEqualTo(String value) {
            addCriterion("insured_id_no <>", value, "insuredIdNo");
            return (Criteria) this;
        }

        public Criteria andInsuredIdNoGreaterThan(String value) {
            addCriterion("insured_id_no >", value, "insuredIdNo");
            return (Criteria) this;
        }

        public Criteria andInsuredIdNoGreaterThanOrEqualTo(String value) {
            addCriterion("insured_id_no >=", value, "insuredIdNo");
            return (Criteria) this;
        }

        public Criteria andInsuredIdNoLessThan(String value) {
            addCriterion("insured_id_no <", value, "insuredIdNo");
            return (Criteria) this;
        }

        public Criteria andInsuredIdNoLessThanOrEqualTo(String value) {
            addCriterion("insured_id_no <=", value, "insuredIdNo");
            return (Criteria) this;
        }

        public Criteria andInsuredIdNoLike(String value) {
            addCriterion("insured_id_no like", value, "insuredIdNo");
            return (Criteria) this;
        }

        public Criteria andInsuredIdNoNotLike(String value) {
            addCriterion("insured_id_no not like", value, "insuredIdNo");
            return (Criteria) this;
        }

        public Criteria andInsuredIdNoIn(List<String> values) {
            addCriterion("insured_id_no in", values, "insuredIdNo");
            return (Criteria) this;
        }

        public Criteria andInsuredIdNoNotIn(List<String> values) {
            addCriterion("insured_id_no not in", values, "insuredIdNo");
            return (Criteria) this;
        }

        public Criteria andInsuredIdNoBetween(String value1, String value2) {
            addCriterion("insured_id_no between", value1, value2, "insuredIdNo");
            return (Criteria) this;
        }

        public Criteria andInsuredIdNoNotBetween(String value1, String value2) {
            addCriterion("insured_id_no not between", value1, value2, "insuredIdNo");
            return (Criteria) this;
        }

        public Criteria andInsuredAddrIsNull() {
            addCriterion("insured_addr is null");
            return (Criteria) this;
        }

        public Criteria andInsuredAddrIsNotNull() {
            addCriterion("insured_addr is not null");
            return (Criteria) this;
        }

        public Criteria andInsuredAddrEqualTo(String value) {
            addCriterion("insured_addr =", value, "insuredAddr");
            return (Criteria) this;
        }

        public Criteria andInsuredAddrNotEqualTo(String value) {
            addCriterion("insured_addr <>", value, "insuredAddr");
            return (Criteria) this;
        }

        public Criteria andInsuredAddrGreaterThan(String value) {
            addCriterion("insured_addr >", value, "insuredAddr");
            return (Criteria) this;
        }

        public Criteria andInsuredAddrGreaterThanOrEqualTo(String value) {
            addCriterion("insured_addr >=", value, "insuredAddr");
            return (Criteria) this;
        }

        public Criteria andInsuredAddrLessThan(String value) {
            addCriterion("insured_addr <", value, "insuredAddr");
            return (Criteria) this;
        }

        public Criteria andInsuredAddrLessThanOrEqualTo(String value) {
            addCriterion("insured_addr <=", value, "insuredAddr");
            return (Criteria) this;
        }

        public Criteria andInsuredAddrLike(String value) {
            addCriterion("insured_addr like", value, "insuredAddr");
            return (Criteria) this;
        }

        public Criteria andInsuredAddrNotLike(String value) {
            addCriterion("insured_addr not like", value, "insuredAddr");
            return (Criteria) this;
        }

        public Criteria andInsuredAddrIn(List<String> values) {
            addCriterion("insured_addr in", values, "insuredAddr");
            return (Criteria) this;
        }

        public Criteria andInsuredAddrNotIn(List<String> values) {
            addCriterion("insured_addr not in", values, "insuredAddr");
            return (Criteria) this;
        }

        public Criteria andInsuredAddrBetween(String value1, String value2) {
            addCriterion("insured_addr between", value1, value2, "insuredAddr");
            return (Criteria) this;
        }

        public Criteria andInsuredAddrNotBetween(String value1, String value2) {
            addCriterion("insured_addr not between", value1, value2, "insuredAddr");
            return (Criteria) this;
        }

        public Criteria andInsuredBirthdayIsNull() {
            addCriterion("insured_birthday is null");
            return (Criteria) this;
        }

        public Criteria andInsuredBirthdayIsNotNull() {
            addCriterion("insured_birthday is not null");
            return (Criteria) this;
        }

        public Criteria andInsuredBirthdayEqualTo(Date value) {
            addCriterionForJDBCDate("insured_birthday =", value, "insuredBirthday");
            return (Criteria) this;
        }

        public Criteria andInsuredBirthdayNotEqualTo(Date value) {
            addCriterionForJDBCDate("insured_birthday <>", value, "insuredBirthday");
            return (Criteria) this;
        }

        public Criteria andInsuredBirthdayGreaterThan(Date value) {
            addCriterionForJDBCDate("insured_birthday >", value, "insuredBirthday");
            return (Criteria) this;
        }

        public Criteria andInsuredBirthdayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("insured_birthday >=", value, "insuredBirthday");
            return (Criteria) this;
        }

        public Criteria andInsuredBirthdayLessThan(Date value) {
            addCriterionForJDBCDate("insured_birthday <", value, "insuredBirthday");
            return (Criteria) this;
        }

        public Criteria andInsuredBirthdayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("insured_birthday <=", value, "insuredBirthday");
            return (Criteria) this;
        }

        public Criteria andInsuredBirthdayIn(List<Date> values) {
            addCriterionForJDBCDate("insured_birthday in", values, "insuredBirthday");
            return (Criteria) this;
        }

        public Criteria andInsuredBirthdayNotIn(List<Date> values) {
            addCriterionForJDBCDate("insured_birthday not in", values, "insuredBirthday");
            return (Criteria) this;
        }

        public Criteria andInsuredBirthdayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("insured_birthday between", value1, value2, "insuredBirthday");
            return (Criteria) this;
        }

        public Criteria andInsuredBirthdayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("insured_birthday not between", value1, value2, "insuredBirthday");
            return (Criteria) this;
        }

        public Criteria andInsuredSexIsNull() {
            addCriterion("insured_sex is null");
            return (Criteria) this;
        }

        public Criteria andInsuredSexIsNotNull() {
            addCriterion("insured_sex is not null");
            return (Criteria) this;
        }

        public Criteria andInsuredSexEqualTo(Byte value) {
            addCriterion("insured_sex =", value, "insuredSex");
            return (Criteria) this;
        }

        public Criteria andInsuredSexNotEqualTo(Byte value) {
            addCriterion("insured_sex <>", value, "insuredSex");
            return (Criteria) this;
        }

        public Criteria andInsuredSexGreaterThan(Byte value) {
            addCriterion("insured_sex >", value, "insuredSex");
            return (Criteria) this;
        }

        public Criteria andInsuredSexGreaterThanOrEqualTo(Byte value) {
            addCriterion("insured_sex >=", value, "insuredSex");
            return (Criteria) this;
        }

        public Criteria andInsuredSexLessThan(Byte value) {
            addCriterion("insured_sex <", value, "insuredSex");
            return (Criteria) this;
        }

        public Criteria andInsuredSexLessThanOrEqualTo(Byte value) {
            addCriterion("insured_sex <=", value, "insuredSex");
            return (Criteria) this;
        }

        public Criteria andInsuredSexIn(List<Byte> values) {
            addCriterion("insured_sex in", values, "insuredSex");
            return (Criteria) this;
        }

        public Criteria andInsuredSexNotIn(List<Byte> values) {
            addCriterion("insured_sex not in", values, "insuredSex");
            return (Criteria) this;
        }

        public Criteria andInsuredSexBetween(Byte value1, Byte value2) {
            addCriterion("insured_sex between", value1, value2, "insuredSex");
            return (Criteria) this;
        }

        public Criteria andInsuredSexNotBetween(Byte value1, Byte value2) {
            addCriterion("insured_sex not between", value1, value2, "insuredSex");
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