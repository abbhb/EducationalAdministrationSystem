package com.ssmstudy.ssm.mapper;

import com.ssmstudy.ssm.pojo.Professional;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProfessionalMapper {

    /**
     * 通过id获取学院信息
     * @param id
     * @return
     */
    Professional getProfessionalById(@Param("id") Integer id);

    /**
     * 获取所有的学院信息
     * @return
     */
    List<Professional> getAllProfessional();

}
