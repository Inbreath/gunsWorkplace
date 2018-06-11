package com.ums.mbr.service.core.mapper;

import com.ums.mbr.service.domain.Mall;
import com.ums.mbr.service.core.example.MallExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MallMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table umsmember..t_mall
     *
     * @mbg.generated
     */
    long countByExample(MallExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table umsmember..t_mall
     *
     * @mbg.generated
     */
    int deleteByExample(MallExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table umsmember..t_mall
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table umsmember..t_mall
     *
     * @mbg.generated
     */
    int insert(Mall record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table umsmember..t_mall
     *
     * @mbg.generated
     */
    int insertSelective(Mall record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table umsmember..t_mall
     *
     * @mbg.generated
     */
    List<Mall> selectByExample(MallExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table umsmember..t_mall
     *
     * @mbg.generated
     */
    Mall selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table umsmember..t_mall
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Mall record, @Param("example") MallExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table umsmember..t_mall
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") Mall record, @Param("example") MallExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table umsmember..t_mall
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Mall record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table umsmember..t_mall
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Mall record);
}