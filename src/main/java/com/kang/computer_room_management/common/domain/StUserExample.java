package com.kang.computer_room_management.common.domain;

import java.util.ArrayList;
import java.util.List;

public class StUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StUserExample() {
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

        public Criteria andUidIsNull() {
            addCriterion("uid is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("uid is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(Integer value) {
            addCriterion("uid =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(Integer value) {
            addCriterion("uid <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(Integer value) {
            addCriterion("uid >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("uid >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(Integer value) {
            addCriterion("uid <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(Integer value) {
            addCriterion("uid <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<Integer> values) {
            addCriterion("uid in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<Integer> values) {
            addCriterion("uid not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(Integer value1, Integer value2) {
            addCriterion("uid between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(Integer value1, Integer value2) {
            addCriterion("uid not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUnameIsNull() {
            addCriterion("uname is null");
            return (Criteria) this;
        }

        public Criteria andUnameIsNotNull() {
            addCriterion("uname is not null");
            return (Criteria) this;
        }

        public Criteria andUnameEqualTo(String value) {
            addCriterion("uname =", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameNotEqualTo(String value) {
            addCriterion("uname <>", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameGreaterThan(String value) {
            addCriterion("uname >", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameGreaterThanOrEqualTo(String value) {
            addCriterion("uname >=", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameLessThan(String value) {
            addCriterion("uname <", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameLessThanOrEqualTo(String value) {
            addCriterion("uname <=", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameLike(String value) {
            addCriterion("uname like", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameNotLike(String value) {
            addCriterion("uname not like", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameIn(List<String> values) {
            addCriterion("uname in", values, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameNotIn(List<String> values) {
            addCriterion("uname not in", values, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameBetween(String value1, String value2) {
            addCriterion("uname between", value1, value2, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameNotBetween(String value1, String value2) {
            addCriterion("uname not between", value1, value2, "uname");
            return (Criteria) this;
        }

        public Criteria andUpsswdIsNull() {
            addCriterion("upsswd is null");
            return (Criteria) this;
        }

        public Criteria andUpsswdIsNotNull() {
            addCriterion("upsswd is not null");
            return (Criteria) this;
        }

        public Criteria andUpsswdEqualTo(String value) {
            addCriterion("upsswd =", value, "upsswd");
            return (Criteria) this;
        }

        public Criteria andUpsswdNotEqualTo(String value) {
            addCriterion("upsswd <>", value, "upsswd");
            return (Criteria) this;
        }

        public Criteria andUpsswdGreaterThan(String value) {
            addCriterion("upsswd >", value, "upsswd");
            return (Criteria) this;
        }

        public Criteria andUpsswdGreaterThanOrEqualTo(String value) {
            addCriterion("upsswd >=", value, "upsswd");
            return (Criteria) this;
        }

        public Criteria andUpsswdLessThan(String value) {
            addCriterion("upsswd <", value, "upsswd");
            return (Criteria) this;
        }

        public Criteria andUpsswdLessThanOrEqualTo(String value) {
            addCriterion("upsswd <=", value, "upsswd");
            return (Criteria) this;
        }

        public Criteria andUpsswdLike(String value) {
            addCriterion("upsswd like", value, "upsswd");
            return (Criteria) this;
        }

        public Criteria andUpsswdNotLike(String value) {
            addCriterion("upsswd not like", value, "upsswd");
            return (Criteria) this;
        }

        public Criteria andUpsswdIn(List<String> values) {
            addCriterion("upsswd in", values, "upsswd");
            return (Criteria) this;
        }

        public Criteria andUpsswdNotIn(List<String> values) {
            addCriterion("upsswd not in", values, "upsswd");
            return (Criteria) this;
        }

        public Criteria andUpsswdBetween(String value1, String value2) {
            addCriterion("upsswd between", value1, value2, "upsswd");
            return (Criteria) this;
        }

        public Criteria andUpsswdNotBetween(String value1, String value2) {
            addCriterion("upsswd not between", value1, value2, "upsswd");
            return (Criteria) this;
        }

        public Criteria andUprofileIsNull() {
            addCriterion("uprofile is null");
            return (Criteria) this;
        }

        public Criteria andUprofileIsNotNull() {
            addCriterion("uprofile is not null");
            return (Criteria) this;
        }

        public Criteria andUprofileEqualTo(String value) {
            addCriterion("uprofile =", value, "uprofile");
            return (Criteria) this;
        }

        public Criteria andUprofileNotEqualTo(String value) {
            addCriterion("uprofile <>", value, "uprofile");
            return (Criteria) this;
        }

        public Criteria andUprofileGreaterThan(String value) {
            addCriterion("uprofile >", value, "uprofile");
            return (Criteria) this;
        }

        public Criteria andUprofileGreaterThanOrEqualTo(String value) {
            addCriterion("uprofile >=", value, "uprofile");
            return (Criteria) this;
        }

        public Criteria andUprofileLessThan(String value) {
            addCriterion("uprofile <", value, "uprofile");
            return (Criteria) this;
        }

        public Criteria andUprofileLessThanOrEqualTo(String value) {
            addCriterion("uprofile <=", value, "uprofile");
            return (Criteria) this;
        }

        public Criteria andUprofileLike(String value) {
            addCriterion("uprofile like", value, "uprofile");
            return (Criteria) this;
        }

        public Criteria andUprofileNotLike(String value) {
            addCriterion("uprofile not like", value, "uprofile");
            return (Criteria) this;
        }

        public Criteria andUprofileIn(List<String> values) {
            addCriterion("uprofile in", values, "uprofile");
            return (Criteria) this;
        }

        public Criteria andUprofileNotIn(List<String> values) {
            addCriterion("uprofile not in", values, "uprofile");
            return (Criteria) this;
        }

        public Criteria andUprofileBetween(String value1, String value2) {
            addCriterion("uprofile between", value1, value2, "uprofile");
            return (Criteria) this;
        }

        public Criteria andUprofileNotBetween(String value1, String value2) {
            addCriterion("uprofile not between", value1, value2, "uprofile");
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