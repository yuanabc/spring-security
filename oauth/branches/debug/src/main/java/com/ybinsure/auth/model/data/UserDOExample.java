package com.ybinsure.auth.model.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserDOExample() {
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

        public Criteria andCodeIsNull() {
            addCriterion("code is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("code is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(Long value) {
            addCriterion("code =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(Long value) {
            addCriterion("code <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(Long value) {
            addCriterion("code >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(Long value) {
            addCriterion("code >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(Long value) {
            addCriterion("code <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(Long value) {
            addCriterion("code <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<Long> values) {
            addCriterion("code in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<Long> values) {
            addCriterion("code not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(Long value1, Long value2) {
            addCriterion("code between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(Long value1, Long value2) {
            addCriterion("code not between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andOldIdIsNull() {
            addCriterion("old_id is null");
            return (Criteria) this;
        }

        public Criteria andOldIdIsNotNull() {
            addCriterion("old_id is not null");
            return (Criteria) this;
        }

        public Criteria andOldIdEqualTo(Integer value) {
            addCriterion("old_id =", value, "oldId");
            return (Criteria) this;
        }

        public Criteria andOldIdNotEqualTo(Integer value) {
            addCriterion("old_id <>", value, "oldId");
            return (Criteria) this;
        }

        public Criteria andOldIdGreaterThan(Integer value) {
            addCriterion("old_id >", value, "oldId");
            return (Criteria) this;
        }

        public Criteria andOldIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("old_id >=", value, "oldId");
            return (Criteria) this;
        }

        public Criteria andOldIdLessThan(Integer value) {
            addCriterion("old_id <", value, "oldId");
            return (Criteria) this;
        }

        public Criteria andOldIdLessThanOrEqualTo(Integer value) {
            addCriterion("old_id <=", value, "oldId");
            return (Criteria) this;
        }

        public Criteria andOldIdIn(List<Integer> values) {
            addCriterion("old_id in", values, "oldId");
            return (Criteria) this;
        }

        public Criteria andOldIdNotIn(List<Integer> values) {
            addCriterion("old_id not in", values, "oldId");
            return (Criteria) this;
        }

        public Criteria andOldIdBetween(Integer value1, Integer value2) {
            addCriterion("old_id between", value1, value2, "oldId");
            return (Criteria) this;
        }

        public Criteria andOldIdNotBetween(Integer value1, Integer value2) {
            addCriterion("old_id not between", value1, value2, "oldId");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andNickNameIsNull() {
            addCriterion("nick_name is null");
            return (Criteria) this;
        }

        public Criteria andNickNameIsNotNull() {
            addCriterion("nick_name is not null");
            return (Criteria) this;
        }

        public Criteria andNickNameEqualTo(String value) {
            addCriterion("nick_name =", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotEqualTo(String value) {
            addCriterion("nick_name <>", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameGreaterThan(String value) {
            addCriterion("nick_name >", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameGreaterThanOrEqualTo(String value) {
            addCriterion("nick_name >=", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLessThan(String value) {
            addCriterion("nick_name <", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLessThanOrEqualTo(String value) {
            addCriterion("nick_name <=", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLike(String value) {
            addCriterion("nick_name like", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotLike(String value) {
            addCriterion("nick_name not like", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameIn(List<String> values) {
            addCriterion("nick_name in", values, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotIn(List<String> values) {
            addCriterion("nick_name not in", values, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameBetween(String value1, String value2) {
            addCriterion("nick_name between", value1, value2, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotBetween(String value1, String value2) {
            addCriterion("nick_name not between", value1, value2, "nickName");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("sex like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("sex not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andIdNameIsNull() {
            addCriterion("id_name is null");
            return (Criteria) this;
        }

        public Criteria andIdNameIsNotNull() {
            addCriterion("id_name is not null");
            return (Criteria) this;
        }

        public Criteria andIdNameEqualTo(String value) {
            addCriterion("id_name =", value, "idName");
            return (Criteria) this;
        }

        public Criteria andIdNameNotEqualTo(String value) {
            addCriterion("id_name <>", value, "idName");
            return (Criteria) this;
        }

        public Criteria andIdNameGreaterThan(String value) {
            addCriterion("id_name >", value, "idName");
            return (Criteria) this;
        }

        public Criteria andIdNameGreaterThanOrEqualTo(String value) {
            addCriterion("id_name >=", value, "idName");
            return (Criteria) this;
        }

        public Criteria andIdNameLessThan(String value) {
            addCriterion("id_name <", value, "idName");
            return (Criteria) this;
        }

        public Criteria andIdNameLessThanOrEqualTo(String value) {
            addCriterion("id_name <=", value, "idName");
            return (Criteria) this;
        }

        public Criteria andIdNameLike(String value) {
            addCriterion("id_name like", value, "idName");
            return (Criteria) this;
        }

        public Criteria andIdNameNotLike(String value) {
            addCriterion("id_name not like", value, "idName");
            return (Criteria) this;
        }

        public Criteria andIdNameIn(List<String> values) {
            addCriterion("id_name in", values, "idName");
            return (Criteria) this;
        }

        public Criteria andIdNameNotIn(List<String> values) {
            addCriterion("id_name not in", values, "idName");
            return (Criteria) this;
        }

        public Criteria andIdNameBetween(String value1, String value2) {
            addCriterion("id_name between", value1, value2, "idName");
            return (Criteria) this;
        }

        public Criteria andIdNameNotBetween(String value1, String value2) {
            addCriterion("id_name not between", value1, value2, "idName");
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

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andIdNoIsNull() {
            addCriterion("id_no is null");
            return (Criteria) this;
        }

        public Criteria andIdNoIsNotNull() {
            addCriterion("id_no is not null");
            return (Criteria) this;
        }

        public Criteria andIdNoEqualTo(String value) {
            addCriterion("id_no =", value, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoNotEqualTo(String value) {
            addCriterion("id_no <>", value, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoGreaterThan(String value) {
            addCriterion("id_no >", value, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoGreaterThanOrEqualTo(String value) {
            addCriterion("id_no >=", value, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoLessThan(String value) {
            addCriterion("id_no <", value, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoLessThanOrEqualTo(String value) {
            addCriterion("id_no <=", value, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoLike(String value) {
            addCriterion("id_no like", value, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoNotLike(String value) {
            addCriterion("id_no not like", value, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoIn(List<String> values) {
            addCriterion("id_no in", values, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoNotIn(List<String> values) {
            addCriterion("id_no not in", values, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoBetween(String value1, String value2) {
            addCriterion("id_no between", value1, value2, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoNotBetween(String value1, String value2) {
            addCriterion("id_no not between", value1, value2, "idNo");
            return (Criteria) this;
        }

        public Criteria andAgentCodeIsNull() {
            addCriterion("agent_code is null");
            return (Criteria) this;
        }

        public Criteria andAgentCodeIsNotNull() {
            addCriterion("agent_code is not null");
            return (Criteria) this;
        }

        public Criteria andAgentCodeEqualTo(String value) {
            addCriterion("agent_code =", value, "agentCode");
            return (Criteria) this;
        }

        public Criteria andAgentCodeNotEqualTo(String value) {
            addCriterion("agent_code <>", value, "agentCode");
            return (Criteria) this;
        }

        public Criteria andAgentCodeGreaterThan(String value) {
            addCriterion("agent_code >", value, "agentCode");
            return (Criteria) this;
        }

        public Criteria andAgentCodeGreaterThanOrEqualTo(String value) {
            addCriterion("agent_code >=", value, "agentCode");
            return (Criteria) this;
        }

        public Criteria andAgentCodeLessThan(String value) {
            addCriterion("agent_code <", value, "agentCode");
            return (Criteria) this;
        }

        public Criteria andAgentCodeLessThanOrEqualTo(String value) {
            addCriterion("agent_code <=", value, "agentCode");
            return (Criteria) this;
        }

        public Criteria andAgentCodeLike(String value) {
            addCriterion("agent_code like", value, "agentCode");
            return (Criteria) this;
        }

        public Criteria andAgentCodeNotLike(String value) {
            addCriterion("agent_code not like", value, "agentCode");
            return (Criteria) this;
        }

        public Criteria andAgentCodeIn(List<String> values) {
            addCriterion("agent_code in", values, "agentCode");
            return (Criteria) this;
        }

        public Criteria andAgentCodeNotIn(List<String> values) {
            addCriterion("agent_code not in", values, "agentCode");
            return (Criteria) this;
        }

        public Criteria andAgentCodeBetween(String value1, String value2) {
            addCriterion("agent_code between", value1, value2, "agentCode");
            return (Criteria) this;
        }

        public Criteria andAgentCodeNotBetween(String value1, String value2) {
            addCriterion("agent_code not between", value1, value2, "agentCode");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNull() {
            addCriterion("user_type is null");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNotNull() {
            addCriterion("user_type is not null");
            return (Criteria) this;
        }

        public Criteria andUserTypeEqualTo(String value) {
            addCriterion("user_type =", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotEqualTo(String value) {
            addCriterion("user_type <>", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThan(String value) {
            addCriterion("user_type >", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThanOrEqualTo(String value) {
            addCriterion("user_type >=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThan(String value) {
            addCriterion("user_type <", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThanOrEqualTo(String value) {
            addCriterion("user_type <=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLike(String value) {
            addCriterion("user_type like", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotLike(String value) {
            addCriterion("user_type not like", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeIn(List<String> values) {
            addCriterion("user_type in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotIn(List<String> values) {
            addCriterion("user_type not in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeBetween(String value1, String value2) {
            addCriterion("user_type between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotBetween(String value1, String value2) {
            addCriterion("user_type not between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andSalesTypeIsNull() {
            addCriterion("sales_type is null");
            return (Criteria) this;
        }

        public Criteria andSalesTypeIsNotNull() {
            addCriterion("sales_type is not null");
            return (Criteria) this;
        }

        public Criteria andSalesTypeEqualTo(String value) {
            addCriterion("sales_type =", value, "salesType");
            return (Criteria) this;
        }

        public Criteria andSalesTypeNotEqualTo(String value) {
            addCriterion("sales_type <>", value, "salesType");
            return (Criteria) this;
        }

        public Criteria andSalesTypeGreaterThan(String value) {
            addCriterion("sales_type >", value, "salesType");
            return (Criteria) this;
        }

        public Criteria andSalesTypeGreaterThanOrEqualTo(String value) {
            addCriterion("sales_type >=", value, "salesType");
            return (Criteria) this;
        }

        public Criteria andSalesTypeLessThan(String value) {
            addCriterion("sales_type <", value, "salesType");
            return (Criteria) this;
        }

        public Criteria andSalesTypeLessThanOrEqualTo(String value) {
            addCriterion("sales_type <=", value, "salesType");
            return (Criteria) this;
        }

        public Criteria andSalesTypeLike(String value) {
            addCriterion("sales_type like", value, "salesType");
            return (Criteria) this;
        }

        public Criteria andSalesTypeNotLike(String value) {
            addCriterion("sales_type not like", value, "salesType");
            return (Criteria) this;
        }

        public Criteria andSalesTypeIn(List<String> values) {
            addCriterion("sales_type in", values, "salesType");
            return (Criteria) this;
        }

        public Criteria andSalesTypeNotIn(List<String> values) {
            addCriterion("sales_type not in", values, "salesType");
            return (Criteria) this;
        }

        public Criteria andSalesTypeBetween(String value1, String value2) {
            addCriterion("sales_type between", value1, value2, "salesType");
            return (Criteria) this;
        }

        public Criteria andSalesTypeNotBetween(String value1, String value2) {
            addCriterion("sales_type not between", value1, value2, "salesType");
            return (Criteria) this;
        }

        public Criteria andDefaultManagerCompanyIsNull() {
            addCriterion("default_manager_company is null");
            return (Criteria) this;
        }

        public Criteria andDefaultManagerCompanyIsNotNull() {
            addCriterion("default_manager_company is not null");
            return (Criteria) this;
        }

        public Criteria andDefaultManagerCompanyEqualTo(Byte value) {
            addCriterion("default_manager_company =", value, "defaultManagerCompany");
            return (Criteria) this;
        }

        public Criteria andDefaultManagerCompanyNotEqualTo(Byte value) {
            addCriterion("default_manager_company <>", value, "defaultManagerCompany");
            return (Criteria) this;
        }

        public Criteria andDefaultManagerCompanyGreaterThan(Byte value) {
            addCriterion("default_manager_company >", value, "defaultManagerCompany");
            return (Criteria) this;
        }

        public Criteria andDefaultManagerCompanyGreaterThanOrEqualTo(Byte value) {
            addCriterion("default_manager_company >=", value, "defaultManagerCompany");
            return (Criteria) this;
        }

        public Criteria andDefaultManagerCompanyLessThan(Byte value) {
            addCriterion("default_manager_company <", value, "defaultManagerCompany");
            return (Criteria) this;
        }

        public Criteria andDefaultManagerCompanyLessThanOrEqualTo(Byte value) {
            addCriterion("default_manager_company <=", value, "defaultManagerCompany");
            return (Criteria) this;
        }

        public Criteria andDefaultManagerCompanyIn(List<Byte> values) {
            addCriterion("default_manager_company in", values, "defaultManagerCompany");
            return (Criteria) this;
        }

        public Criteria andDefaultManagerCompanyNotIn(List<Byte> values) {
            addCriterion("default_manager_company not in", values, "defaultManagerCompany");
            return (Criteria) this;
        }

        public Criteria andDefaultManagerCompanyBetween(Byte value1, Byte value2) {
            addCriterion("default_manager_company between", value1, value2, "defaultManagerCompany");
            return (Criteria) this;
        }

        public Criteria andDefaultManagerCompanyNotBetween(Byte value1, Byte value2) {
            addCriterion("default_manager_company not between", value1, value2, "defaultManagerCompany");
            return (Criteria) this;
        }

        public Criteria andBankIsNull() {
            addCriterion("bank is null");
            return (Criteria) this;
        }

        public Criteria andBankIsNotNull() {
            addCriterion("bank is not null");
            return (Criteria) this;
        }

        public Criteria andBankEqualTo(String value) {
            addCriterion("bank =", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankNotEqualTo(String value) {
            addCriterion("bank <>", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankGreaterThan(String value) {
            addCriterion("bank >", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankGreaterThanOrEqualTo(String value) {
            addCriterion("bank >=", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankLessThan(String value) {
            addCriterion("bank <", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankLessThanOrEqualTo(String value) {
            addCriterion("bank <=", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankLike(String value) {
            addCriterion("bank like", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankNotLike(String value) {
            addCriterion("bank not like", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankIn(List<String> values) {
            addCriterion("bank in", values, "bank");
            return (Criteria) this;
        }

        public Criteria andBankNotIn(List<String> values) {
            addCriterion("bank not in", values, "bank");
            return (Criteria) this;
        }

        public Criteria andBankBetween(String value1, String value2) {
            addCriterion("bank between", value1, value2, "bank");
            return (Criteria) this;
        }

        public Criteria andBankNotBetween(String value1, String value2) {
            addCriterion("bank not between", value1, value2, "bank");
            return (Criteria) this;
        }

        public Criteria andAccountHolderIsNull() {
            addCriterion("account_holder is null");
            return (Criteria) this;
        }

        public Criteria andAccountHolderIsNotNull() {
            addCriterion("account_holder is not null");
            return (Criteria) this;
        }

        public Criteria andAccountHolderEqualTo(String value) {
            addCriterion("account_holder =", value, "accountHolder");
            return (Criteria) this;
        }

        public Criteria andAccountHolderNotEqualTo(String value) {
            addCriterion("account_holder <>", value, "accountHolder");
            return (Criteria) this;
        }

        public Criteria andAccountHolderGreaterThan(String value) {
            addCriterion("account_holder >", value, "accountHolder");
            return (Criteria) this;
        }

        public Criteria andAccountHolderGreaterThanOrEqualTo(String value) {
            addCriterion("account_holder >=", value, "accountHolder");
            return (Criteria) this;
        }

        public Criteria andAccountHolderLessThan(String value) {
            addCriterion("account_holder <", value, "accountHolder");
            return (Criteria) this;
        }

        public Criteria andAccountHolderLessThanOrEqualTo(String value) {
            addCriterion("account_holder <=", value, "accountHolder");
            return (Criteria) this;
        }

        public Criteria andAccountHolderLike(String value) {
            addCriterion("account_holder like", value, "accountHolder");
            return (Criteria) this;
        }

        public Criteria andAccountHolderNotLike(String value) {
            addCriterion("account_holder not like", value, "accountHolder");
            return (Criteria) this;
        }

        public Criteria andAccountHolderIn(List<String> values) {
            addCriterion("account_holder in", values, "accountHolder");
            return (Criteria) this;
        }

        public Criteria andAccountHolderNotIn(List<String> values) {
            addCriterion("account_holder not in", values, "accountHolder");
            return (Criteria) this;
        }

        public Criteria andAccountHolderBetween(String value1, String value2) {
            addCriterion("account_holder between", value1, value2, "accountHolder");
            return (Criteria) this;
        }

        public Criteria andAccountHolderNotBetween(String value1, String value2) {
            addCriterion("account_holder not between", value1, value2, "accountHolder");
            return (Criteria) this;
        }

        public Criteria andBankPhoneIsNull() {
            addCriterion("bank_phone is null");
            return (Criteria) this;
        }

        public Criteria andBankPhoneIsNotNull() {
            addCriterion("bank_phone is not null");
            return (Criteria) this;
        }

        public Criteria andBankPhoneEqualTo(String value) {
            addCriterion("bank_phone =", value, "bankPhone");
            return (Criteria) this;
        }

        public Criteria andBankPhoneNotEqualTo(String value) {
            addCriterion("bank_phone <>", value, "bankPhone");
            return (Criteria) this;
        }

        public Criteria andBankPhoneGreaterThan(String value) {
            addCriterion("bank_phone >", value, "bankPhone");
            return (Criteria) this;
        }

        public Criteria andBankPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("bank_phone >=", value, "bankPhone");
            return (Criteria) this;
        }

        public Criteria andBankPhoneLessThan(String value) {
            addCriterion("bank_phone <", value, "bankPhone");
            return (Criteria) this;
        }

        public Criteria andBankPhoneLessThanOrEqualTo(String value) {
            addCriterion("bank_phone <=", value, "bankPhone");
            return (Criteria) this;
        }

        public Criteria andBankPhoneLike(String value) {
            addCriterion("bank_phone like", value, "bankPhone");
            return (Criteria) this;
        }

        public Criteria andBankPhoneNotLike(String value) {
            addCriterion("bank_phone not like", value, "bankPhone");
            return (Criteria) this;
        }

        public Criteria andBankPhoneIn(List<String> values) {
            addCriterion("bank_phone in", values, "bankPhone");
            return (Criteria) this;
        }

        public Criteria andBankPhoneNotIn(List<String> values) {
            addCriterion("bank_phone not in", values, "bankPhone");
            return (Criteria) this;
        }

        public Criteria andBankPhoneBetween(String value1, String value2) {
            addCriterion("bank_phone between", value1, value2, "bankPhone");
            return (Criteria) this;
        }

        public Criteria andBankPhoneNotBetween(String value1, String value2) {
            addCriterion("bank_phone not between", value1, value2, "bankPhone");
            return (Criteria) this;
        }

        public Criteria andBankNoIsNull() {
            addCriterion("bank_no is null");
            return (Criteria) this;
        }

        public Criteria andBankNoIsNotNull() {
            addCriterion("bank_no is not null");
            return (Criteria) this;
        }

        public Criteria andBankNoEqualTo(String value) {
            addCriterion("bank_no =", value, "bankNo");
            return (Criteria) this;
        }

        public Criteria andBankNoNotEqualTo(String value) {
            addCriterion("bank_no <>", value, "bankNo");
            return (Criteria) this;
        }

        public Criteria andBankNoGreaterThan(String value) {
            addCriterion("bank_no >", value, "bankNo");
            return (Criteria) this;
        }

        public Criteria andBankNoGreaterThanOrEqualTo(String value) {
            addCriterion("bank_no >=", value, "bankNo");
            return (Criteria) this;
        }

        public Criteria andBankNoLessThan(String value) {
            addCriterion("bank_no <", value, "bankNo");
            return (Criteria) this;
        }

        public Criteria andBankNoLessThanOrEqualTo(String value) {
            addCriterion("bank_no <=", value, "bankNo");
            return (Criteria) this;
        }

        public Criteria andBankNoLike(String value) {
            addCriterion("bank_no like", value, "bankNo");
            return (Criteria) this;
        }

        public Criteria andBankNoNotLike(String value) {
            addCriterion("bank_no not like", value, "bankNo");
            return (Criteria) this;
        }

        public Criteria andBankNoIn(List<String> values) {
            addCriterion("bank_no in", values, "bankNo");
            return (Criteria) this;
        }

        public Criteria andBankNoNotIn(List<String> values) {
            addCriterion("bank_no not in", values, "bankNo");
            return (Criteria) this;
        }

        public Criteria andBankNoBetween(String value1, String value2) {
            addCriterion("bank_no between", value1, value2, "bankNo");
            return (Criteria) this;
        }

        public Criteria andBankNoNotBetween(String value1, String value2) {
            addCriterion("bank_no not between", value1, value2, "bankNo");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andChannelStatusIsNull() {
            addCriterion("channel_status is null");
            return (Criteria) this;
        }

        public Criteria andChannelStatusIsNotNull() {
            addCriterion("channel_status is not null");
            return (Criteria) this;
        }

        public Criteria andChannelStatusEqualTo(Byte value) {
            addCriterion("channel_status =", value, "channelStatus");
            return (Criteria) this;
        }

        public Criteria andChannelStatusNotEqualTo(Byte value) {
            addCriterion("channel_status <>", value, "channelStatus");
            return (Criteria) this;
        }

        public Criteria andChannelStatusGreaterThan(Byte value) {
            addCriterion("channel_status >", value, "channelStatus");
            return (Criteria) this;
        }

        public Criteria andChannelStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("channel_status >=", value, "channelStatus");
            return (Criteria) this;
        }

        public Criteria andChannelStatusLessThan(Byte value) {
            addCriterion("channel_status <", value, "channelStatus");
            return (Criteria) this;
        }

        public Criteria andChannelStatusLessThanOrEqualTo(Byte value) {
            addCriterion("channel_status <=", value, "channelStatus");
            return (Criteria) this;
        }

        public Criteria andChannelStatusIn(List<Byte> values) {
            addCriterion("channel_status in", values, "channelStatus");
            return (Criteria) this;
        }

        public Criteria andChannelStatusNotIn(List<Byte> values) {
            addCriterion("channel_status not in", values, "channelStatus");
            return (Criteria) this;
        }

        public Criteria andChannelStatusBetween(Byte value1, Byte value2) {
            addCriterion("channel_status between", value1, value2, "channelStatus");
            return (Criteria) this;
        }

        public Criteria andChannelStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("channel_status not between", value1, value2, "channelStatus");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNull() {
            addCriterion("deleted is null");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNotNull() {
            addCriterion("deleted is not null");
            return (Criteria) this;
        }

        public Criteria andDeletedEqualTo(Byte value) {
            addCriterion("deleted =", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotEqualTo(Byte value) {
            addCriterion("deleted <>", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThan(Byte value) {
            addCriterion("deleted >", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThanOrEqualTo(Byte value) {
            addCriterion("deleted >=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThan(Byte value) {
            addCriterion("deleted <", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThanOrEqualTo(Byte value) {
            addCriterion("deleted <=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedIn(List<Byte> values) {
            addCriterion("deleted in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotIn(List<Byte> values) {
            addCriterion("deleted not in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedBetween(Byte value1, Byte value2) {
            addCriterion("deleted between", value1, value2, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotBetween(Byte value1, Byte value2) {
            addCriterion("deleted not between", value1, value2, "deleted");
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

        public Criteria andChannelCodeIsNull() {
            addCriterion("channel_code is null");
            return (Criteria) this;
        }

        public Criteria andChannelCodeIsNotNull() {
            addCriterion("channel_code is not null");
            return (Criteria) this;
        }

        public Criteria andChannelCodeEqualTo(String value) {
            addCriterion("channel_code =", value, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeNotEqualTo(String value) {
            addCriterion("channel_code <>", value, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeGreaterThan(String value) {
            addCriterion("channel_code >", value, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeGreaterThanOrEqualTo(String value) {
            addCriterion("channel_code >=", value, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeLessThan(String value) {
            addCriterion("channel_code <", value, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeLessThanOrEqualTo(String value) {
            addCriterion("channel_code <=", value, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeLike(String value) {
            addCriterion("channel_code like", value, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeNotLike(String value) {
            addCriterion("channel_code not like", value, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeIn(List<String> values) {
            addCriterion("channel_code in", values, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeNotIn(List<String> values) {
            addCriterion("channel_code not in", values, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeBetween(String value1, String value2) {
            addCriterion("channel_code between", value1, value2, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeNotBetween(String value1, String value2) {
            addCriterion("channel_code not between", value1, value2, "channelCode");
            return (Criteria) this;
        }

        public Criteria andPowerIsNull() {
            addCriterion("power is null");
            return (Criteria) this;
        }

        public Criteria andPowerIsNotNull() {
            addCriterion("power is not null");
            return (Criteria) this;
        }

        public Criteria andPowerEqualTo(Byte value) {
            addCriterion("power =", value, "power");
            return (Criteria) this;
        }

        public Criteria andPowerNotEqualTo(Byte value) {
            addCriterion("power <>", value, "power");
            return (Criteria) this;
        }

        public Criteria andPowerGreaterThan(Byte value) {
            addCriterion("power >", value, "power");
            return (Criteria) this;
        }

        public Criteria andPowerGreaterThanOrEqualTo(Byte value) {
            addCriterion("power >=", value, "power");
            return (Criteria) this;
        }

        public Criteria andPowerLessThan(Byte value) {
            addCriterion("power <", value, "power");
            return (Criteria) this;
        }

        public Criteria andPowerLessThanOrEqualTo(Byte value) {
            addCriterion("power <=", value, "power");
            return (Criteria) this;
        }

        public Criteria andPowerIn(List<Byte> values) {
            addCriterion("power in", values, "power");
            return (Criteria) this;
        }

        public Criteria andPowerNotIn(List<Byte> values) {
            addCriterion("power not in", values, "power");
            return (Criteria) this;
        }

        public Criteria andPowerBetween(Byte value1, Byte value2) {
            addCriterion("power between", value1, value2, "power");
            return (Criteria) this;
        }

        public Criteria andPowerNotBetween(Byte value1, Byte value2) {
            addCriterion("power not between", value1, value2, "power");
            return (Criteria) this;
        }

        public Criteria andCardTypeIsNull() {
            addCriterion("card_type is null");
            return (Criteria) this;
        }

        public Criteria andCardTypeIsNotNull() {
            addCriterion("card_type is not null");
            return (Criteria) this;
        }

        public Criteria andCardTypeEqualTo(Byte value) {
            addCriterion("card_type =", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeNotEqualTo(Byte value) {
            addCriterion("card_type <>", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeGreaterThan(Byte value) {
            addCriterion("card_type >", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("card_type >=", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeLessThan(Byte value) {
            addCriterion("card_type <", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeLessThanOrEqualTo(Byte value) {
            addCriterion("card_type <=", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeIn(List<Byte> values) {
            addCriterion("card_type in", values, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeNotIn(List<Byte> values) {
            addCriterion("card_type not in", values, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeBetween(Byte value1, Byte value2) {
            addCriterion("card_type between", value1, value2, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("card_type not between", value1, value2, "cardType");
            return (Criteria) this;
        }

        public Criteria andWalletIsNull() {
            addCriterion("wallet is null");
            return (Criteria) this;
        }

        public Criteria andWalletIsNotNull() {
            addCriterion("wallet is not null");
            return (Criteria) this;
        }

        public Criteria andWalletEqualTo(Double value) {
            addCriterion("wallet =", value, "wallet");
            return (Criteria) this;
        }

        public Criteria andWalletNotEqualTo(Double value) {
            addCriterion("wallet <>", value, "wallet");
            return (Criteria) this;
        }

        public Criteria andWalletGreaterThan(Double value) {
            addCriterion("wallet >", value, "wallet");
            return (Criteria) this;
        }

        public Criteria andWalletGreaterThanOrEqualTo(Double value) {
            addCriterion("wallet >=", value, "wallet");
            return (Criteria) this;
        }

        public Criteria andWalletLessThan(Double value) {
            addCriterion("wallet <", value, "wallet");
            return (Criteria) this;
        }

        public Criteria andWalletLessThanOrEqualTo(Double value) {
            addCriterion("wallet <=", value, "wallet");
            return (Criteria) this;
        }

        public Criteria andWalletIn(List<Double> values) {
            addCriterion("wallet in", values, "wallet");
            return (Criteria) this;
        }

        public Criteria andWalletNotIn(List<Double> values) {
            addCriterion("wallet not in", values, "wallet");
            return (Criteria) this;
        }

        public Criteria andWalletBetween(Double value1, Double value2) {
            addCriterion("wallet between", value1, value2, "wallet");
            return (Criteria) this;
        }

        public Criteria andWalletNotBetween(Double value1, Double value2) {
            addCriterion("wallet not between", value1, value2, "wallet");
            return (Criteria) this;
        }

        public Criteria andWithDrawPwdIsNull() {
            addCriterion("with_draw_pwd is null");
            return (Criteria) this;
        }

        public Criteria andWithDrawPwdIsNotNull() {
            addCriterion("with_draw_pwd is not null");
            return (Criteria) this;
        }

        public Criteria andWithDrawPwdEqualTo(String value) {
            addCriterion("with_draw_pwd =", value, "withDrawPwd");
            return (Criteria) this;
        }

        public Criteria andWithDrawPwdNotEqualTo(String value) {
            addCriterion("with_draw_pwd <>", value, "withDrawPwd");
            return (Criteria) this;
        }

        public Criteria andWithDrawPwdGreaterThan(String value) {
            addCriterion("with_draw_pwd >", value, "withDrawPwd");
            return (Criteria) this;
        }

        public Criteria andWithDrawPwdGreaterThanOrEqualTo(String value) {
            addCriterion("with_draw_pwd >=", value, "withDrawPwd");
            return (Criteria) this;
        }

        public Criteria andWithDrawPwdLessThan(String value) {
            addCriterion("with_draw_pwd <", value, "withDrawPwd");
            return (Criteria) this;
        }

        public Criteria andWithDrawPwdLessThanOrEqualTo(String value) {
            addCriterion("with_draw_pwd <=", value, "withDrawPwd");
            return (Criteria) this;
        }

        public Criteria andWithDrawPwdLike(String value) {
            addCriterion("with_draw_pwd like", value, "withDrawPwd");
            return (Criteria) this;
        }

        public Criteria andWithDrawPwdNotLike(String value) {
            addCriterion("with_draw_pwd not like", value, "withDrawPwd");
            return (Criteria) this;
        }

        public Criteria andWithDrawPwdIn(List<String> values) {
            addCriterion("with_draw_pwd in", values, "withDrawPwd");
            return (Criteria) this;
        }

        public Criteria andWithDrawPwdNotIn(List<String> values) {
            addCriterion("with_draw_pwd not in", values, "withDrawPwd");
            return (Criteria) this;
        }

        public Criteria andWithDrawPwdBetween(String value1, String value2) {
            addCriterion("with_draw_pwd between", value1, value2, "withDrawPwd");
            return (Criteria) this;
        }

        public Criteria andWithDrawPwdNotBetween(String value1, String value2) {
            addCriterion("with_draw_pwd not between", value1, value2, "withDrawPwd");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Byte value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Byte value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Byte value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Byte value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Byte value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Byte> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Byte> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Byte value1, Byte value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andSaleNoIsNull() {
            addCriterion("sale_no is null");
            return (Criteria) this;
        }

        public Criteria andSaleNoIsNotNull() {
            addCriterion("sale_no is not null");
            return (Criteria) this;
        }

        public Criteria andSaleNoEqualTo(String value) {
            addCriterion("sale_no =", value, "saleNo");
            return (Criteria) this;
        }

        public Criteria andSaleNoNotEqualTo(String value) {
            addCriterion("sale_no <>", value, "saleNo");
            return (Criteria) this;
        }

        public Criteria andSaleNoGreaterThan(String value) {
            addCriterion("sale_no >", value, "saleNo");
            return (Criteria) this;
        }

        public Criteria andSaleNoGreaterThanOrEqualTo(String value) {
            addCriterion("sale_no >=", value, "saleNo");
            return (Criteria) this;
        }

        public Criteria andSaleNoLessThan(String value) {
            addCriterion("sale_no <", value, "saleNo");
            return (Criteria) this;
        }

        public Criteria andSaleNoLessThanOrEqualTo(String value) {
            addCriterion("sale_no <=", value, "saleNo");
            return (Criteria) this;
        }

        public Criteria andSaleNoLike(String value) {
            addCriterion("sale_no like", value, "saleNo");
            return (Criteria) this;
        }

        public Criteria andSaleNoNotLike(String value) {
            addCriterion("sale_no not like", value, "saleNo");
            return (Criteria) this;
        }

        public Criteria andSaleNoIn(List<String> values) {
            addCriterion("sale_no in", values, "saleNo");
            return (Criteria) this;
        }

        public Criteria andSaleNoNotIn(List<String> values) {
            addCriterion("sale_no not in", values, "saleNo");
            return (Criteria) this;
        }

        public Criteria andSaleNoBetween(String value1, String value2) {
            addCriterion("sale_no between", value1, value2, "saleNo");
            return (Criteria) this;
        }

        public Criteria andSaleNoNotBetween(String value1, String value2) {
            addCriterion("sale_no not between", value1, value2, "saleNo");
            return (Criteria) this;
        }

        public Criteria andEnNoIsNull() {
            addCriterion("en_no is null");
            return (Criteria) this;
        }

        public Criteria andEnNoIsNotNull() {
            addCriterion("en_no is not null");
            return (Criteria) this;
        }

        public Criteria andEnNoEqualTo(String value) {
            addCriterion("en_no =", value, "enNo");
            return (Criteria) this;
        }

        public Criteria andEnNoNotEqualTo(String value) {
            addCriterion("en_no <>", value, "enNo");
            return (Criteria) this;
        }

        public Criteria andEnNoGreaterThan(String value) {
            addCriterion("en_no >", value, "enNo");
            return (Criteria) this;
        }

        public Criteria andEnNoGreaterThanOrEqualTo(String value) {
            addCriterion("en_no >=", value, "enNo");
            return (Criteria) this;
        }

        public Criteria andEnNoLessThan(String value) {
            addCriterion("en_no <", value, "enNo");
            return (Criteria) this;
        }

        public Criteria andEnNoLessThanOrEqualTo(String value) {
            addCriterion("en_no <=", value, "enNo");
            return (Criteria) this;
        }

        public Criteria andEnNoLike(String value) {
            addCriterion("en_no like", value, "enNo");
            return (Criteria) this;
        }

        public Criteria andEnNoNotLike(String value) {
            addCriterion("en_no not like", value, "enNo");
            return (Criteria) this;
        }

        public Criteria andEnNoIn(List<String> values) {
            addCriterion("en_no in", values, "enNo");
            return (Criteria) this;
        }

        public Criteria andEnNoNotIn(List<String> values) {
            addCriterion("en_no not in", values, "enNo");
            return (Criteria) this;
        }

        public Criteria andEnNoBetween(String value1, String value2) {
            addCriterion("en_no between", value1, value2, "enNo");
            return (Criteria) this;
        }

        public Criteria andEnNoNotBetween(String value1, String value2) {
            addCriterion("en_no not between", value1, value2, "enNo");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Long value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Long value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Long value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Long value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Long value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Long> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Long> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Long value1, Long value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Long value1, Long value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Long value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Long value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Long value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Long value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Long value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Long> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Long> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Long value1, Long value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Long value1, Long value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andSbtAppNameIsNull() {
            addCriterion("sbt_app_name is null");
            return (Criteria) this;
        }

        public Criteria andSbtAppNameIsNotNull() {
            addCriterion("sbt_app_name is not null");
            return (Criteria) this;
        }

        public Criteria andSbtAppNameEqualTo(String value) {
            addCriterion("sbt_app_name =", value, "sbtAppName");
            return (Criteria) this;
        }

        public Criteria andSbtAppNameNotEqualTo(String value) {
            addCriterion("sbt_app_name <>", value, "sbtAppName");
            return (Criteria) this;
        }

        public Criteria andSbtAppNameGreaterThan(String value) {
            addCriterion("sbt_app_name >", value, "sbtAppName");
            return (Criteria) this;
        }

        public Criteria andSbtAppNameGreaterThanOrEqualTo(String value) {
            addCriterion("sbt_app_name >=", value, "sbtAppName");
            return (Criteria) this;
        }

        public Criteria andSbtAppNameLessThan(String value) {
            addCriterion("sbt_app_name <", value, "sbtAppName");
            return (Criteria) this;
        }

        public Criteria andSbtAppNameLessThanOrEqualTo(String value) {
            addCriterion("sbt_app_name <=", value, "sbtAppName");
            return (Criteria) this;
        }

        public Criteria andSbtAppNameLike(String value) {
            addCriterion("sbt_app_name like", value, "sbtAppName");
            return (Criteria) this;
        }

        public Criteria andSbtAppNameNotLike(String value) {
            addCriterion("sbt_app_name not like", value, "sbtAppName");
            return (Criteria) this;
        }

        public Criteria andSbtAppNameIn(List<String> values) {
            addCriterion("sbt_app_name in", values, "sbtAppName");
            return (Criteria) this;
        }

        public Criteria andSbtAppNameNotIn(List<String> values) {
            addCriterion("sbt_app_name not in", values, "sbtAppName");
            return (Criteria) this;
        }

        public Criteria andSbtAppNameBetween(String value1, String value2) {
            addCriterion("sbt_app_name between", value1, value2, "sbtAppName");
            return (Criteria) this;
        }

        public Criteria andSbtAppNameNotBetween(String value1, String value2) {
            addCriterion("sbt_app_name not between", value1, value2, "sbtAppName");
            return (Criteria) this;
        }

        public Criteria andSbtPasswordIsNull() {
            addCriterion("sbt_password is null");
            return (Criteria) this;
        }

        public Criteria andSbtPasswordIsNotNull() {
            addCriterion("sbt_password is not null");
            return (Criteria) this;
        }

        public Criteria andSbtPasswordEqualTo(String value) {
            addCriterion("sbt_password =", value, "sbtPassword");
            return (Criteria) this;
        }

        public Criteria andSbtPasswordNotEqualTo(String value) {
            addCriterion("sbt_password <>", value, "sbtPassword");
            return (Criteria) this;
        }

        public Criteria andSbtPasswordGreaterThan(String value) {
            addCriterion("sbt_password >", value, "sbtPassword");
            return (Criteria) this;
        }

        public Criteria andSbtPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("sbt_password >=", value, "sbtPassword");
            return (Criteria) this;
        }

        public Criteria andSbtPasswordLessThan(String value) {
            addCriterion("sbt_password <", value, "sbtPassword");
            return (Criteria) this;
        }

        public Criteria andSbtPasswordLessThanOrEqualTo(String value) {
            addCriterion("sbt_password <=", value, "sbtPassword");
            return (Criteria) this;
        }

        public Criteria andSbtPasswordLike(String value) {
            addCriterion("sbt_password like", value, "sbtPassword");
            return (Criteria) this;
        }

        public Criteria andSbtPasswordNotLike(String value) {
            addCriterion("sbt_password not like", value, "sbtPassword");
            return (Criteria) this;
        }

        public Criteria andSbtPasswordIn(List<String> values) {
            addCriterion("sbt_password in", values, "sbtPassword");
            return (Criteria) this;
        }

        public Criteria andSbtPasswordNotIn(List<String> values) {
            addCriterion("sbt_password not in", values, "sbtPassword");
            return (Criteria) this;
        }

        public Criteria andSbtPasswordBetween(String value1, String value2) {
            addCriterion("sbt_password between", value1, value2, "sbtPassword");
            return (Criteria) this;
        }

        public Criteria andSbtPasswordNotBetween(String value1, String value2) {
            addCriterion("sbt_password not between", value1, value2, "sbtPassword");
            return (Criteria) this;
        }

        public Criteria andSbtAppIdNoIsNull() {
            addCriterion("sbt_app_id_no is null");
            return (Criteria) this;
        }

        public Criteria andSbtAppIdNoIsNotNull() {
            addCriterion("sbt_app_id_no is not null");
            return (Criteria) this;
        }

        public Criteria andSbtAppIdNoEqualTo(String value) {
            addCriterion("sbt_app_id_no =", value, "sbtAppIdNo");
            return (Criteria) this;
        }

        public Criteria andSbtAppIdNoNotEqualTo(String value) {
            addCriterion("sbt_app_id_no <>", value, "sbtAppIdNo");
            return (Criteria) this;
        }

        public Criteria andSbtAppIdNoGreaterThan(String value) {
            addCriterion("sbt_app_id_no >", value, "sbtAppIdNo");
            return (Criteria) this;
        }

        public Criteria andSbtAppIdNoGreaterThanOrEqualTo(String value) {
            addCriterion("sbt_app_id_no >=", value, "sbtAppIdNo");
            return (Criteria) this;
        }

        public Criteria andSbtAppIdNoLessThan(String value) {
            addCriterion("sbt_app_id_no <", value, "sbtAppIdNo");
            return (Criteria) this;
        }

        public Criteria andSbtAppIdNoLessThanOrEqualTo(String value) {
            addCriterion("sbt_app_id_no <=", value, "sbtAppIdNo");
            return (Criteria) this;
        }

        public Criteria andSbtAppIdNoLike(String value) {
            addCriterion("sbt_app_id_no like", value, "sbtAppIdNo");
            return (Criteria) this;
        }

        public Criteria andSbtAppIdNoNotLike(String value) {
            addCriterion("sbt_app_id_no not like", value, "sbtAppIdNo");
            return (Criteria) this;
        }

        public Criteria andSbtAppIdNoIn(List<String> values) {
            addCriterion("sbt_app_id_no in", values, "sbtAppIdNo");
            return (Criteria) this;
        }

        public Criteria andSbtAppIdNoNotIn(List<String> values) {
            addCriterion("sbt_app_id_no not in", values, "sbtAppIdNo");
            return (Criteria) this;
        }

        public Criteria andSbtAppIdNoBetween(String value1, String value2) {
            addCriterion("sbt_app_id_no between", value1, value2, "sbtAppIdNo");
            return (Criteria) this;
        }

        public Criteria andSbtAppIdNoNotBetween(String value1, String value2) {
            addCriterion("sbt_app_id_no not between", value1, value2, "sbtAppIdNo");
            return (Criteria) this;
        }

        public Criteria andLastTokenExpireTimeIsNull() {
            addCriterion("last_token_expire_time is null");
            return (Criteria) this;
        }

        public Criteria andLastTokenExpireTimeIsNotNull() {
            addCriterion("last_token_expire_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastTokenExpireTimeEqualTo(Date value) {
            addCriterion("last_token_expire_time =", value, "lastTokenExpireTime");
            return (Criteria) this;
        }

        public Criteria andLastTokenExpireTimeNotEqualTo(Date value) {
            addCriterion("last_token_expire_time <>", value, "lastTokenExpireTime");
            return (Criteria) this;
        }

        public Criteria andLastTokenExpireTimeGreaterThan(Date value) {
            addCriterion("last_token_expire_time >", value, "lastTokenExpireTime");
            return (Criteria) this;
        }

        public Criteria andLastTokenExpireTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_token_expire_time >=", value, "lastTokenExpireTime");
            return (Criteria) this;
        }

        public Criteria andLastTokenExpireTimeLessThan(Date value) {
            addCriterion("last_token_expire_time <", value, "lastTokenExpireTime");
            return (Criteria) this;
        }

        public Criteria andLastTokenExpireTimeLessThanOrEqualTo(Date value) {
            addCriterion("last_token_expire_time <=", value, "lastTokenExpireTime");
            return (Criteria) this;
        }

        public Criteria andLastTokenExpireTimeIn(List<Date> values) {
            addCriterion("last_token_expire_time in", values, "lastTokenExpireTime");
            return (Criteria) this;
        }

        public Criteria andLastTokenExpireTimeNotIn(List<Date> values) {
            addCriterion("last_token_expire_time not in", values, "lastTokenExpireTime");
            return (Criteria) this;
        }

        public Criteria andLastTokenExpireTimeBetween(Date value1, Date value2) {
            addCriterion("last_token_expire_time between", value1, value2, "lastTokenExpireTime");
            return (Criteria) this;
        }

        public Criteria andLastTokenExpireTimeNotBetween(Date value1, Date value2) {
            addCriterion("last_token_expire_time not between", value1, value2, "lastTokenExpireTime");
            return (Criteria) this;
        }

        public Criteria andLastTokenIsNull() {
            addCriterion("last_token is null");
            return (Criteria) this;
        }

        public Criteria andLastTokenIsNotNull() {
            addCriterion("last_token is not null");
            return (Criteria) this;
        }

        public Criteria andLastTokenEqualTo(String value) {
            addCriterion("last_token =", value, "lastToken");
            return (Criteria) this;
        }

        public Criteria andLastTokenNotEqualTo(String value) {
            addCriterion("last_token <>", value, "lastToken");
            return (Criteria) this;
        }

        public Criteria andLastTokenGreaterThan(String value) {
            addCriterion("last_token >", value, "lastToken");
            return (Criteria) this;
        }

        public Criteria andLastTokenGreaterThanOrEqualTo(String value) {
            addCriterion("last_token >=", value, "lastToken");
            return (Criteria) this;
        }

        public Criteria andLastTokenLessThan(String value) {
            addCriterion("last_token <", value, "lastToken");
            return (Criteria) this;
        }

        public Criteria andLastTokenLessThanOrEqualTo(String value) {
            addCriterion("last_token <=", value, "lastToken");
            return (Criteria) this;
        }

        public Criteria andLastTokenLike(String value) {
            addCriterion("last_token like", value, "lastToken");
            return (Criteria) this;
        }

        public Criteria andLastTokenNotLike(String value) {
            addCriterion("last_token not like", value, "lastToken");
            return (Criteria) this;
        }

        public Criteria andLastTokenIn(List<String> values) {
            addCriterion("last_token in", values, "lastToken");
            return (Criteria) this;
        }

        public Criteria andLastTokenNotIn(List<String> values) {
            addCriterion("last_token not in", values, "lastToken");
            return (Criteria) this;
        }

        public Criteria andLastTokenBetween(String value1, String value2) {
            addCriterion("last_token between", value1, value2, "lastToken");
            return (Criteria) this;
        }

        public Criteria andLastTokenNotBetween(String value1, String value2) {
            addCriterion("last_token not between", value1, value2, "lastToken");
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