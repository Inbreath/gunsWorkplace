package com.ums.mbr.service.core.example;

import java.util.ArrayList;
import java.util.List;

public class HisOrderInfExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table umsmember..t_hisorderinf
     *
     * @mbg.generated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table umsmember..t_hisorderinf
     *
     * @mbg.generated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table umsmember..t_hisorderinf
     *
     * @mbg.generated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table umsmember..t_hisorderinf
     *
     * @mbg.generated
     */
    public HisOrderInfExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table umsmember..t_hisorderinf
     *
     * @mbg.generated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table umsmember..t_hisorderinf
     *
     * @mbg.generated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table umsmember..t_hisorderinf
     *
     * @mbg.generated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table umsmember..t_hisorderinf
     *
     * @mbg.generated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table umsmember..t_hisorderinf
     *
     * @mbg.generated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table umsmember..t_hisorderinf
     *
     * @mbg.generated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table umsmember..t_hisorderinf
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
     * This method corresponds to the database table umsmember..t_hisorderinf
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
     * This method corresponds to the database table umsmember..t_hisorderinf
     *
     * @mbg.generated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table umsmember..t_hisorderinf
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
     * This class corresponds to the database table umsmember..t_hisorderinf
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

        public Criteria andRetserialIsNull() {
            addCriterion("RETSERIAL is null");
            return (Criteria) this;
        }

        public Criteria andRetserialIsNotNull() {
            addCriterion("RETSERIAL is not null");
            return (Criteria) this;
        }

        public Criteria andRetserialEqualTo(String value) {
            addCriterion("RETSERIAL =", value, "retserial");
            return (Criteria) this;
        }

        public Criteria andRetserialNotEqualTo(String value) {
            addCriterion("RETSERIAL <>", value, "retserial");
            return (Criteria) this;
        }

        public Criteria andRetserialGreaterThan(String value) {
            addCriterion("RETSERIAL >", value, "retserial");
            return (Criteria) this;
        }

        public Criteria andRetserialGreaterThanOrEqualTo(String value) {
            addCriterion("RETSERIAL >=", value, "retserial");
            return (Criteria) this;
        }

        public Criteria andRetserialLessThan(String value) {
            addCriterion("RETSERIAL <", value, "retserial");
            return (Criteria) this;
        }

        public Criteria andRetserialLessThanOrEqualTo(String value) {
            addCriterion("RETSERIAL <=", value, "retserial");
            return (Criteria) this;
        }

        public Criteria andRetserialLike(String value) {
            addCriterion("RETSERIAL like", value, "retserial");
            return (Criteria) this;
        }

        public Criteria andRetserialNotLike(String value) {
            addCriterion("RETSERIAL not like", value, "retserial");
            return (Criteria) this;
        }

        public Criteria andRetserialIn(List<String> values) {
            addCriterion("RETSERIAL in", values, "retserial");
            return (Criteria) this;
        }

        public Criteria andRetserialNotIn(List<String> values) {
            addCriterion("RETSERIAL not in", values, "retserial");
            return (Criteria) this;
        }

        public Criteria andRetserialBetween(String value1, String value2) {
            addCriterion("RETSERIAL between", value1, value2, "retserial");
            return (Criteria) this;
        }

        public Criteria andRetserialNotBetween(String value1, String value2) {
            addCriterion("RETSERIAL not between", value1, value2, "retserial");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNull() {
            addCriterion("ORDER_NO is null");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNotNull() {
            addCriterion("ORDER_NO is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNoEqualTo(String value) {
            addCriterion("ORDER_NO =", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotEqualTo(String value) {
            addCriterion("ORDER_NO <>", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThan(String value) {
            addCriterion("ORDER_NO >", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("ORDER_NO >=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThan(String value) {
            addCriterion("ORDER_NO <", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThanOrEqualTo(String value) {
            addCriterion("ORDER_NO <=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLike(String value) {
            addCriterion("ORDER_NO like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotLike(String value) {
            addCriterion("ORDER_NO not like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoIn(List<String> values) {
            addCriterion("ORDER_NO in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotIn(List<String> values) {
            addCriterion("ORDER_NO not in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoBetween(String value1, String value2) {
            addCriterion("ORDER_NO between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotBetween(String value1, String value2) {
            addCriterion("ORDER_NO not between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andMchtnoIsNull() {
            addCriterion("MCHTNO is null");
            return (Criteria) this;
        }

        public Criteria andMchtnoIsNotNull() {
            addCriterion("MCHTNO is not null");
            return (Criteria) this;
        }

        public Criteria andMchtnoEqualTo(String value) {
            addCriterion("MCHTNO =", value, "mchtno");
            return (Criteria) this;
        }

        public Criteria andMchtnoNotEqualTo(String value) {
            addCriterion("MCHTNO <>", value, "mchtno");
            return (Criteria) this;
        }

        public Criteria andMchtnoGreaterThan(String value) {
            addCriterion("MCHTNO >", value, "mchtno");
            return (Criteria) this;
        }

        public Criteria andMchtnoGreaterThanOrEqualTo(String value) {
            addCriterion("MCHTNO >=", value, "mchtno");
            return (Criteria) this;
        }

        public Criteria andMchtnoLessThan(String value) {
            addCriterion("MCHTNO <", value, "mchtno");
            return (Criteria) this;
        }

        public Criteria andMchtnoLessThanOrEqualTo(String value) {
            addCriterion("MCHTNO <=", value, "mchtno");
            return (Criteria) this;
        }

        public Criteria andMchtnoLike(String value) {
            addCriterion("MCHTNO like", value, "mchtno");
            return (Criteria) this;
        }

        public Criteria andMchtnoNotLike(String value) {
            addCriterion("MCHTNO not like", value, "mchtno");
            return (Criteria) this;
        }

        public Criteria andMchtnoIn(List<String> values) {
            addCriterion("MCHTNO in", values, "mchtno");
            return (Criteria) this;
        }

        public Criteria andMchtnoNotIn(List<String> values) {
            addCriterion("MCHTNO not in", values, "mchtno");
            return (Criteria) this;
        }

        public Criteria andMchtnoBetween(String value1, String value2) {
            addCriterion("MCHTNO between", value1, value2, "mchtno");
            return (Criteria) this;
        }

        public Criteria andMchtnoNotBetween(String value1, String value2) {
            addCriterion("MCHTNO not between", value1, value2, "mchtno");
            return (Criteria) this;
        }

        public Criteria andTermnoIsNull() {
            addCriterion("TERMNO is null");
            return (Criteria) this;
        }

        public Criteria andTermnoIsNotNull() {
            addCriterion("TERMNO is not null");
            return (Criteria) this;
        }

        public Criteria andTermnoEqualTo(String value) {
            addCriterion("TERMNO =", value, "termno");
            return (Criteria) this;
        }

        public Criteria andTermnoNotEqualTo(String value) {
            addCriterion("TERMNO <>", value, "termno");
            return (Criteria) this;
        }

        public Criteria andTermnoGreaterThan(String value) {
            addCriterion("TERMNO >", value, "termno");
            return (Criteria) this;
        }

        public Criteria andTermnoGreaterThanOrEqualTo(String value) {
            addCriterion("TERMNO >=", value, "termno");
            return (Criteria) this;
        }

        public Criteria andTermnoLessThan(String value) {
            addCriterion("TERMNO <", value, "termno");
            return (Criteria) this;
        }

        public Criteria andTermnoLessThanOrEqualTo(String value) {
            addCriterion("TERMNO <=", value, "termno");
            return (Criteria) this;
        }

        public Criteria andTermnoLike(String value) {
            addCriterion("TERMNO like", value, "termno");
            return (Criteria) this;
        }

        public Criteria andTermnoNotLike(String value) {
            addCriterion("TERMNO not like", value, "termno");
            return (Criteria) this;
        }

        public Criteria andTermnoIn(List<String> values) {
            addCriterion("TERMNO in", values, "termno");
            return (Criteria) this;
        }

        public Criteria andTermnoNotIn(List<String> values) {
            addCriterion("TERMNO not in", values, "termno");
            return (Criteria) this;
        }

        public Criteria andTermnoBetween(String value1, String value2) {
            addCriterion("TERMNO between", value1, value2, "termno");
            return (Criteria) this;
        }

        public Criteria andTermnoNotBetween(String value1, String value2) {
            addCriterion("TERMNO not between", value1, value2, "termno");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("STATE is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("STATE is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("STATE =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("STATE <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("STATE >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("STATE >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("STATE <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("STATE <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("STATE like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("STATE not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("STATE in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("STATE not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("STATE between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("STATE not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andNoteIsNull() {
            addCriterion("NOTE is null");
            return (Criteria) this;
        }

        public Criteria andNoteIsNotNull() {
            addCriterion("NOTE is not null");
            return (Criteria) this;
        }

        public Criteria andNoteEqualTo(String value) {
            addCriterion("NOTE =", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotEqualTo(String value) {
            addCriterion("NOTE <>", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThan(String value) {
            addCriterion("NOTE >", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThanOrEqualTo(String value) {
            addCriterion("NOTE >=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThan(String value) {
            addCriterion("NOTE <", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThanOrEqualTo(String value) {
            addCriterion("NOTE <=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLike(String value) {
            addCriterion("NOTE like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotLike(String value) {
            addCriterion("NOTE not like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteIn(List<String> values) {
            addCriterion("NOTE in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotIn(List<String> values) {
            addCriterion("NOTE not in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteBetween(String value1, String value2) {
            addCriterion("NOTE between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotBetween(String value1, String value2) {
            addCriterion("NOTE not between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(String value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(String value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(String value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(String value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(String value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLike(String value) {
            addCriterion("CREATE_TIME like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotLike(String value) {
            addCriterion("CREATE_TIME not like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<String> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<String> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(String value1, String value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(String value1, String value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andRefreshTimeIsNull() {
            addCriterion("REFRESH_TIME is null");
            return (Criteria) this;
        }

        public Criteria andRefreshTimeIsNotNull() {
            addCriterion("REFRESH_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andRefreshTimeEqualTo(String value) {
            addCriterion("REFRESH_TIME =", value, "refreshTime");
            return (Criteria) this;
        }

        public Criteria andRefreshTimeNotEqualTo(String value) {
            addCriterion("REFRESH_TIME <>", value, "refreshTime");
            return (Criteria) this;
        }

        public Criteria andRefreshTimeGreaterThan(String value) {
            addCriterion("REFRESH_TIME >", value, "refreshTime");
            return (Criteria) this;
        }

        public Criteria andRefreshTimeGreaterThanOrEqualTo(String value) {
            addCriterion("REFRESH_TIME >=", value, "refreshTime");
            return (Criteria) this;
        }

        public Criteria andRefreshTimeLessThan(String value) {
            addCriterion("REFRESH_TIME <", value, "refreshTime");
            return (Criteria) this;
        }

        public Criteria andRefreshTimeLessThanOrEqualTo(String value) {
            addCriterion("REFRESH_TIME <=", value, "refreshTime");
            return (Criteria) this;
        }

        public Criteria andRefreshTimeLike(String value) {
            addCriterion("REFRESH_TIME like", value, "refreshTime");
            return (Criteria) this;
        }

        public Criteria andRefreshTimeNotLike(String value) {
            addCriterion("REFRESH_TIME not like", value, "refreshTime");
            return (Criteria) this;
        }

        public Criteria andRefreshTimeIn(List<String> values) {
            addCriterion("REFRESH_TIME in", values, "refreshTime");
            return (Criteria) this;
        }

        public Criteria andRefreshTimeNotIn(List<String> values) {
            addCriterion("REFRESH_TIME not in", values, "refreshTime");
            return (Criteria) this;
        }

        public Criteria andRefreshTimeBetween(String value1, String value2) {
            addCriterion("REFRESH_TIME between", value1, value2, "refreshTime");
            return (Criteria) this;
        }

        public Criteria andRefreshTimeNotBetween(String value1, String value2) {
            addCriterion("REFRESH_TIME not between", value1, value2, "refreshTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeIsNull() {
            addCriterion("EFFECTIVE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeIsNotNull() {
            addCriterion("EFFECTIVE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeEqualTo(String value) {
            addCriterion("EFFECTIVE_TIME =", value, "effectiveTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeNotEqualTo(String value) {
            addCriterion("EFFECTIVE_TIME <>", value, "effectiveTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeGreaterThan(String value) {
            addCriterion("EFFECTIVE_TIME >", value, "effectiveTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeGreaterThanOrEqualTo(String value) {
            addCriterion("EFFECTIVE_TIME >=", value, "effectiveTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeLessThan(String value) {
            addCriterion("EFFECTIVE_TIME <", value, "effectiveTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeLessThanOrEqualTo(String value) {
            addCriterion("EFFECTIVE_TIME <=", value, "effectiveTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeLike(String value) {
            addCriterion("EFFECTIVE_TIME like", value, "effectiveTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeNotLike(String value) {
            addCriterion("EFFECTIVE_TIME not like", value, "effectiveTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeIn(List<String> values) {
            addCriterion("EFFECTIVE_TIME in", values, "effectiveTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeNotIn(List<String> values) {
            addCriterion("EFFECTIVE_TIME not in", values, "effectiveTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeBetween(String value1, String value2) {
            addCriterion("EFFECTIVE_TIME between", value1, value2, "effectiveTime");
            return (Criteria) this;
        }

        public Criteria andEffectiveTimeNotBetween(String value1, String value2) {
            addCriterion("EFFECTIVE_TIME not between", value1, value2, "effectiveTime");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table umsmember..t_hisorderinf
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
     * This class corresponds to the database table umsmember..t_hisorderinf
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