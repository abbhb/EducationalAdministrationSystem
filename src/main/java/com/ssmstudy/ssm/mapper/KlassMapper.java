package com.ssmstudy.ssm.mapper;

import com.ssmstudy.ssm.pojo.Klass;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface KlassMapper {

    /**
     * 通过id获取Klass
     * @param id
     * @return
     */
    Klass getKlassById(@Param("id") Integer id);

    /**
     * 通过professionalId获取Klass
     * @param professionalId
     * @return
     */
    List<Klass> getKlassByProfessionalId(@Param("professionalId") Integer professionalId);
}
