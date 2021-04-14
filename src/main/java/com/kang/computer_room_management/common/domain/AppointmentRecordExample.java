package com.kang.computer_room_management.common.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AppointmentRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AppointmentRecordExample() {
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

        public Criteria andReqdateIsNull() {
            addCriterion("reqdate is null");
            return (Criteria) this;
        }

        public Criteria andReqdateIsNotNull() {
            addCriterion("reqdate is not null");
            return (Criteria) this;
        }

        public Criteria andReqdateEqualTo(Date value) {
            addCriterion("reqdate =", value, "reqdate");
            return (Criteria) this;
        }

        public Criteria andReqdateNotEqualTo(Date value) {
            addCriterion("reqdate <>", value, "reqdate");
            return (Criteria) this;
        }

        public Criteria andReqdateGreaterThan(Date value) {
            addCriterion("reqdate >", value, "reqdate");
            return (Criteria) this;
        }

        public Criteria andReqdateGreaterThanOrEqualTo(Date value) {
            addCriterion("reqdate >=", value, "reqdate");
            return (Criteria) this;
        }

        public Criteria andReqdateLessThan(Date value) {
            addCriterion("reqdate <", value, "reqdate");
            return (Criteria) this;
        }

        public Criteria andReqdateLessThanOrEqualTo(Date value) {
            addCriterion("reqdate <=", value, "reqdate");
            return (Criteria) this;
        }

        public Criteria andReqdateIn(List<Date> values) {
            addCriterion("reqdate in", values, "reqdate");
            return (Criteria) this;
        }

        public Criteria andReqdateNotIn(List<Date> values) {
            addCriterion("reqdate not in", values, "reqdate");
            return (Criteria) this;
        }

        public Criteria andReqdateBetween(Date value1, Date value2) {
            addCriterion("reqdate between", value1, value2, "reqdate");
            return (Criteria) this;
        }

        public Criteria andReqdateNotBetween(Date value1, Date value2) {
            addCriterion("reqdate not between", value1, value2, "reqdate");
            return (Criteria) this;
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

        public Criteria andRidIsNull() {
            addCriterion("rid is null");
            return (Criteria) this;
        }

        public Criteria andRidIsNotNull() {
            addCriterion("rid is not null");
            return (Criteria) this;
        }

        public Criteria andRidEqualTo(Integer value) {
            addCriterion("rid =", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidNotEqualTo(Integer value) {
            addCriterion("rid <>", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidGreaterThan(Integer value) {
            addCriterion("rid >", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidGreaterThanOrEqualTo(Integer value) {
            addCriterion("rid >=", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidLessThan(Integer value) {
            addCriterion("rid <", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidLessThanOrEqualTo(Integer value) {
            addCriterion("rid <=", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidIn(List<Integer> values) {
            addCriterion("rid in", values, "rid");
            return (Criteria) this;
        }

        public Criteria andRidNotIn(List<Integer> values) {
            addCriterion("rid not in", values, "rid");
            return (Criteria) this;
        }

        public Criteria andRidBetween(Integer value1, Integer value2) {
            addCriterion("rid between", value1, value2, "rid");
            return (Criteria) this;
        }

        public Criteria andRidNotBetween(Integer value1, Integer value2) {
            addCriterion("rid not between", value1, value2, "rid");
            return (Criteria) this;
        }

        public Criteria andArstatusIsNull() {
            addCriterion("arstatus is null");
            return (Criteria) this;
        }

        public Criteria andArstatusIsNotNull() {
            addCriterion("arstatus is not null");
            return (Criteria) this;
        }

        public Criteria andArstatusEqualTo(Integer value) {
            addCriterion("arstatus =", value, "arstatus");
            return (Criteria) this;
        }

        public Criteria andArstatusNotEqualTo(Integer value) {
            addCriterion("arstatus <>", value, "arstatus");
            return (Criteria) this;
        }

        public Criteria andArstatusGreaterThan(Integer value) {
            addCriterion("arstatus >", value, "arstatus");
            return (Criteria) this;
        }

        public Criteria andArstatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("arstatus >=", value, "arstatus");
            return (Criteria) this;
        }

        public Criteria andArstatusLessThan(Integer value) {
            addCriterion("arstatus <", value, "arstatus");
            return (Criteria) this;
        }

        public Criteria andArstatusLessThanOrEqualTo(Integer value) {
            addCriterion("arstatus <=", value, "arstatus");
            return (Criteria) this;
        }

        public Criteria andArstatusIn(List<Integer> values) {
            addCriterion("arstatus in", values, "arstatus");
            return (Criteria) this;
        }

        public Criteria andArstatusNotIn(List<Integer> values) {
            addCriterion("arstatus not in", values, "arstatus");
            return (Criteria) this;
        }

        public Criteria andArstatusBetween(Integer value1, Integer value2) {
            addCriterion("arstatus between", value1, value2, "arstatus");
            return (Criteria) this;
        }

        public Criteria andArstatusNotBetween(Integer value1, Integer value2) {
            addCriterion("arstatus not between", value1, value2, "arstatus");
            return (Criteria) this;
        }

        public Criteria andDealdateIsNull() {
            addCriterion("dealdate is null");
            return (Criteria) this;
        }

        public Criteria andDealdateIsNotNull() {
            addCriterion("dealdate is not null");
            return (Criteria) this;
        }

        public Criteria andDealdateEqualTo(Date value) {
            addCriterion("dealdate =", value, "dealdate");
            return (Criteria) this;
        }

        public Criteria andDealdateNotEqualTo(Date value) {
            addCriterion("dealdate <>", value, "dealdate");
            return (Criteria) this;
        }

        public Criteria andDealdateGreaterThan(Date value) {
            addCriterion("dealdate >", value, "dealdate");
            return (Criteria) this;
        }

        public Criteria andDealdateGreaterThanOrEqualTo(Date value) {
            addCriterion("dealdate >=", value, "dealdate");
            return (Criteria) this;
        }

        public Criteria andDealdateLessThan(Date value) {
            addCriterion("dealdate <", value, "dealdate");
            return (Criteria) this;
        }

        public Criteria andDealdateLessThanOrEqualTo(Date value) {
            addCriterion("dealdate <=", value, "dealdate");
            return (Criteria) this;
        }

        public Criteria andDealdateIn(List<Date> values) {
            addCriterion("dealdate in", values, "dealdate");
            return (Criteria) this;
        }

        public Criteria andDealdateNotIn(List<Date> values) {
            addCriterion("dealdate not in", values, "dealdate");
            return (Criteria) this;
        }

        public Criteria andDealdateBetween(Date value1, Date value2) {
            addCriterion("dealdate between", value1, value2, "dealdate");
            return (Criteria) this;
        }

        public Criteria andDealdateNotBetween(Date value1, Date value2) {
            addCriterion("dealdate not between", value1, value2, "dealdate");
            return (Criteria) this;
        }

        public Criteria andArtypeIsNull() {
            addCriterion("artype is null");
            return (Criteria) this;
        }

        public Criteria andArtypeIsNotNull() {
            addCriterion("artype is not null");
            return (Criteria) this;
        }

        public Criteria andArtypeEqualTo(Integer value) {
            addCriterion("artype =", value, "artype");
            return (Criteria) this;
        }

        public Criteria andArtypeNotEqualTo(Integer value) {
            addCriterion("artype <>", value, "artype");
            return (Criteria) this;
        }

        public Criteria andArtypeGreaterThan(Integer value) {
            addCriterion("artype >", value, "artype");
            return (Criteria) this;
        }

        public Criteria andArtypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("artype >=", value, "artype");
            return (Criteria) this;
        }

        public Criteria andArtypeLessThan(Integer value) {
            addCriterion("artype <", value, "artype");
            return (Criteria) this;
        }

        public Criteria andArtypeLessThanOrEqualTo(Integer value) {
            addCriterion("artype <=", value, "artype");
            return (Criteria) this;
        }

        public Criteria andArtypeIn(List<Integer> values) {
            addCriterion("artype in", values, "artype");
            return (Criteria) this;
        }

        public Criteria andArtypeNotIn(List<Integer> values) {
            addCriterion("artype not in", values, "artype");
            return (Criteria) this;
        }

        public Criteria andArtypeBetween(Integer value1, Integer value2) {
            addCriterion("artype between", value1, value2, "artype");
            return (Criteria) this;
        }

        public Criteria andArtypeNotBetween(Integer value1, Integer value2) {
            addCriterion("artype not between", value1, value2, "artype");
            return (Criteria) this;
        }

        public Criteria andCidIsNull() {
            addCriterion("cid is null");
            return (Criteria) this;
        }

        public Criteria andCidIsNotNull() {
            addCriterion("cid is not null");
            return (Criteria) this;
        }

        public Criteria andCidEqualTo(Integer value) {
            addCriterion("cid =", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotEqualTo(Integer value) {
            addCriterion("cid <>", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThan(Integer value) {
            addCriterion("cid >", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThanOrEqualTo(Integer value) {
            addCriterion("cid >=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThan(Integer value) {
            addCriterion("cid <", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThanOrEqualTo(Integer value) {
            addCriterion("cid <=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidIn(List<Integer> values) {
            addCriterion("cid in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotIn(List<Integer> values) {
            addCriterion("cid not in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidBetween(Integer value1, Integer value2) {
            addCriterion("cid between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotBetween(Integer value1, Integer value2) {
            addCriterion("cid not between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andInfoIsNull() {
            addCriterion("info is null");
            return (Criteria) this;
        }

        public Criteria andInfoIsNotNull() {
            addCriterion("info is not null");
            return (Criteria) this;
        }

        public Criteria andInfoEqualTo(String value) {
            addCriterion("info =", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoNotEqualTo(String value) {
            addCriterion("info <>", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoGreaterThan(String value) {
            addCriterion("info >", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoGreaterThanOrEqualTo(String value) {
            addCriterion("info >=", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoLessThan(String value) {
            addCriterion("info <", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoLessThanOrEqualTo(String value) {
            addCriterion("info <=", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoLike(String value) {
            addCriterion("info like", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoNotLike(String value) {
            addCriterion("info not like", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoIn(List<String> values) {
            addCriterion("info in", values, "info");
            return (Criteria) this;
        }

        public Criteria andInfoNotIn(List<String> values) {
            addCriterion("info not in", values, "info");
            return (Criteria) this;
        }

        public Criteria andInfoBetween(String value1, String value2) {
            addCriterion("info between", value1, value2, "info");
            return (Criteria) this;
        }

        public Criteria andInfoNotBetween(String value1, String value2) {
            addCriterion("info not between", value1, value2, "info");
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