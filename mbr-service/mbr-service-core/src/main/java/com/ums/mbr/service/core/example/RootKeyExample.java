package com.ums.mbr.service.core.example;

import java.util.ArrayList;
import java.util.List;

public class RootKeyExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_rootkey
     *
     * @mbg.generated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_rootkey
     *
     * @mbg.generated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_rootkey
     *
     * @mbg.generated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_rootkey
     *
     * @mbg.generated
     */
    public RootKeyExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_rootkey
     *
     * @mbg.generated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_rootkey
     *
     * @mbg.generated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_rootkey
     *
     * @mbg.generated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_rootkey
     *
     * @mbg.generated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_rootkey
     *
     * @mbg.generated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_rootkey
     *
     * @mbg.generated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_rootkey
     *
     * @mbg.generated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_rootkey
     *
     * @mbg.generated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_rootkey
     *
     * @mbg.generated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_rootkey
     *
     * @mbg.generated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_rootkey
     *
     * @mbg.generated
     */
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

        public Criteria andIdxIsNull() {
            addCriterion("IDX is null");
            return (Criteria) this;
        }

        public Criteria andIdxIsNotNull() {
            addCriterion("IDX is not null");
            return (Criteria) this;
        }

        public Criteria andIdxEqualTo(Short value) {
            addCriterion("IDX =", value, "idx");
            return (Criteria) this;
        }

        public Criteria andIdxNotEqualTo(Short value) {
            addCriterion("IDX <>", value, "idx");
            return (Criteria) this;
        }

        public Criteria andIdxGreaterThan(Short value) {
            addCriterion("IDX >", value, "idx");
            return (Criteria) this;
        }

        public Criteria andIdxGreaterThanOrEqualTo(Short value) {
            addCriterion("IDX >=", value, "idx");
            return (Criteria) this;
        }

        public Criteria andIdxLessThan(Short value) {
            addCriterion("IDX <", value, "idx");
            return (Criteria) this;
        }

        public Criteria andIdxLessThanOrEqualTo(Short value) {
            addCriterion("IDX <=", value, "idx");
            return (Criteria) this;
        }

        public Criteria andIdxIn(List<Short> values) {
            addCriterion("IDX in", values, "idx");
            return (Criteria) this;
        }

        public Criteria andIdxNotIn(List<Short> values) {
            addCriterion("IDX not in", values, "idx");
            return (Criteria) this;
        }

        public Criteria andIdxBetween(Short value1, Short value2) {
            addCriterion("IDX between", value1, value2, "idx");
            return (Criteria) this;
        }

        public Criteria andIdxNotBetween(Short value1, Short value2) {
            addCriterion("IDX not between", value1, value2, "idx");
            return (Criteria) this;
        }

        public Criteria andDbkeyIsNull() {
            addCriterion("DBKEY is null");
            return (Criteria) this;
        }

        public Criteria andDbkeyIsNotNull() {
            addCriterion("DBKEY is not null");
            return (Criteria) this;
        }

        public Criteria andDbkeyEqualTo(String value) {
            addCriterion("DBKEY =", value, "dbkey");
            return (Criteria) this;
        }

        public Criteria andDbkeyNotEqualTo(String value) {
            addCriterion("DBKEY <>", value, "dbkey");
            return (Criteria) this;
        }

        public Criteria andDbkeyGreaterThan(String value) {
            addCriterion("DBKEY >", value, "dbkey");
            return (Criteria) this;
        }

        public Criteria andDbkeyGreaterThanOrEqualTo(String value) {
            addCriterion("DBKEY >=", value, "dbkey");
            return (Criteria) this;
        }

        public Criteria andDbkeyLessThan(String value) {
            addCriterion("DBKEY <", value, "dbkey");
            return (Criteria) this;
        }

        public Criteria andDbkeyLessThanOrEqualTo(String value) {
            addCriterion("DBKEY <=", value, "dbkey");
            return (Criteria) this;
        }

        public Criteria andDbkeyLike(String value) {
            addCriterion("DBKEY like", value, "dbkey");
            return (Criteria) this;
        }

        public Criteria andDbkeyNotLike(String value) {
            addCriterion("DBKEY not like", value, "dbkey");
            return (Criteria) this;
        }

        public Criteria andDbkeyIn(List<String> values) {
            addCriterion("DBKEY in", values, "dbkey");
            return (Criteria) this;
        }

        public Criteria andDbkeyNotIn(List<String> values) {
            addCriterion("DBKEY not in", values, "dbkey");
            return (Criteria) this;
        }

        public Criteria andDbkeyBetween(String value1, String value2) {
            addCriterion("DBKEY between", value1, value2, "dbkey");
            return (Criteria) this;
        }

        public Criteria andDbkeyNotBetween(String value1, String value2) {
            addCriterion("DBKEY not between", value1, value2, "dbkey");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_rootkey
     *
     * @mbg.generated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_rootkey
     *
     * @mbg.generated
     */
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