package com.hailstone.common.dao.po;

import java.util.ArrayList;
import java.util.List;

public class MyStudentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MyStudentExample() {
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

        public Criteria andClassidIsNull() {
            addCriterion("classid is null");
            return (Criteria) this;
        }

        public Criteria andClassidIsNotNull() {
            addCriterion("classid is not null");
            return (Criteria) this;
        }

        public Criteria andClassidEqualTo(String value) {
            addCriterion("classid =", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidNotEqualTo(String value) {
            addCriterion("classid <>", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidGreaterThan(String value) {
            addCriterion("classid >", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidGreaterThanOrEqualTo(String value) {
            addCriterion("classid >=", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidLessThan(String value) {
            addCriterion("classid <", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidLessThanOrEqualTo(String value) {
            addCriterion("classid <=", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidLike(String value) {
            addCriterion("classid like", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidNotLike(String value) {
            addCriterion("classid not like", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidIn(List<String> values) {
            addCriterion("classid in", values, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidNotIn(List<String> values) {
            addCriterion("classid not in", values, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidBetween(String value1, String value2) {
            addCriterion("classid between", value1, value2, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidNotBetween(String value1, String value2) {
            addCriterion("classid not between", value1, value2, "classid");
            return (Criteria) this;
        }

        public Criteria andYuwenIsNull() {
            addCriterion("yuwen is null");
            return (Criteria) this;
        }

        public Criteria andYuwenIsNotNull() {
            addCriterion("yuwen is not null");
            return (Criteria) this;
        }

        public Criteria andYuwenEqualTo(String value) {
            addCriterion("yuwen =", value, "yuwen");
            return (Criteria) this;
        }

        public Criteria andYuwenNotEqualTo(String value) {
            addCriterion("yuwen <>", value, "yuwen");
            return (Criteria) this;
        }

        public Criteria andYuwenGreaterThan(String value) {
            addCriterion("yuwen >", value, "yuwen");
            return (Criteria) this;
        }

        public Criteria andYuwenGreaterThanOrEqualTo(String value) {
            addCriterion("yuwen >=", value, "yuwen");
            return (Criteria) this;
        }

        public Criteria andYuwenLessThan(String value) {
            addCriterion("yuwen <", value, "yuwen");
            return (Criteria) this;
        }

        public Criteria andYuwenLessThanOrEqualTo(String value) {
            addCriterion("yuwen <=", value, "yuwen");
            return (Criteria) this;
        }

        public Criteria andYuwenLike(String value) {
            addCriterion("yuwen like", value, "yuwen");
            return (Criteria) this;
        }

        public Criteria andYuwenNotLike(String value) {
            addCriterion("yuwen not like", value, "yuwen");
            return (Criteria) this;
        }

        public Criteria andYuwenIn(List<String> values) {
            addCriterion("yuwen in", values, "yuwen");
            return (Criteria) this;
        }

        public Criteria andYuwenNotIn(List<String> values) {
            addCriterion("yuwen not in", values, "yuwen");
            return (Criteria) this;
        }

        public Criteria andYuwenBetween(String value1, String value2) {
            addCriterion("yuwen between", value1, value2, "yuwen");
            return (Criteria) this;
        }

        public Criteria andYuwenNotBetween(String value1, String value2) {
            addCriterion("yuwen not between", value1, value2, "yuwen");
            return (Criteria) this;
        }

        public Criteria andShuxueIsNull() {
            addCriterion("shuxue is null");
            return (Criteria) this;
        }

        public Criteria andShuxueIsNotNull() {
            addCriterion("shuxue is not null");
            return (Criteria) this;
        }

        public Criteria andShuxueEqualTo(String value) {
            addCriterion("shuxue =", value, "shuxue");
            return (Criteria) this;
        }

        public Criteria andShuxueNotEqualTo(String value) {
            addCriterion("shuxue <>", value, "shuxue");
            return (Criteria) this;
        }

        public Criteria andShuxueGreaterThan(String value) {
            addCriterion("shuxue >", value, "shuxue");
            return (Criteria) this;
        }

        public Criteria andShuxueGreaterThanOrEqualTo(String value) {
            addCriterion("shuxue >=", value, "shuxue");
            return (Criteria) this;
        }

        public Criteria andShuxueLessThan(String value) {
            addCriterion("shuxue <", value, "shuxue");
            return (Criteria) this;
        }

        public Criteria andShuxueLessThanOrEqualTo(String value) {
            addCriterion("shuxue <=", value, "shuxue");
            return (Criteria) this;
        }

        public Criteria andShuxueLike(String value) {
            addCriterion("shuxue like", value, "shuxue");
            return (Criteria) this;
        }

        public Criteria andShuxueNotLike(String value) {
            addCriterion("shuxue not like", value, "shuxue");
            return (Criteria) this;
        }

        public Criteria andShuxueIn(List<String> values) {
            addCriterion("shuxue in", values, "shuxue");
            return (Criteria) this;
        }

        public Criteria andShuxueNotIn(List<String> values) {
            addCriterion("shuxue not in", values, "shuxue");
            return (Criteria) this;
        }

        public Criteria andShuxueBetween(String value1, String value2) {
            addCriterion("shuxue between", value1, value2, "shuxue");
            return (Criteria) this;
        }

        public Criteria andShuxueNotBetween(String value1, String value2) {
            addCriterion("shuxue not between", value1, value2, "shuxue");
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