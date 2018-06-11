package com.ums.mbr.service.core.mapper;

import com.ums.mbr.service.domain.ErrCode;
import com.ums.mbr.service.core.example.ErrCodeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErrCodeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table umsmember..t_err_code
     *
     * @mbg.generated
     */
    long countByExample(ErrCodeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table umsmember..t_err_code
     *
     * @mbg.generated
     */
    int deleteByExample(ErrCodeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table umsmember..t_err_code
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table umsmember..t_err_code
     *
     * @mbg.generated
     */
    int insert(ErrCode record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table umsmember..t_err_code
     *
     * @mbg.generated
     */
    int insertSelective(ErrCode record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table umsmember..t_err_code
     *
     * @mbg.generated
     */
    List<ErrCode> selectByExample(ErrCodeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table umsmember..t_err_code
     *
     * @mbg.generated
     */
    ErrCode selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table umsmember..t_err_code
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") ErrCode record, @Param("example") ErrCodeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table umsmember..t_err_code
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") ErrCode record, @Param("example") ErrCodeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table umsmember..t_err_code
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(ErrCode record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table umsmember..t_err_code
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(ErrCode record);
}