package com.ssmstudy.ssm.mapper;

import com.ssmstudy.ssm.pojo.User;
import com.ssmstudy.ssm.pojo.teacher.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    /**
     * 登录
     * @return
     */
    User login(@Param("username") String username, @Param("password") String password);

    /**
     * 根据用户id获取dept，1为超管，2为老师，3为学生，4为用户，详细见数据库
     * @param id
     * @return
     */
    Integer getDeptById(@Param("id") Integer id);

    /**
     * 根据用户id查找用户信息
     * @param id
     */
    User getUserById(@Param("id") int id);

    /**
     * 更新用户信息
     * @param ids
     * @param name
     * @param age
     * @param gender
     * @param email
     * @return
     */
    int updataForUser(@Param("ids")int ids, @Param("name")String name, @Param("age")Integer age, @Param("gender") String gender, @Param("email")String email);

    /**
     * 通过teacherid获取teacher相关的信息
     * @param teacherId
     * @return
     */
    User getTeacherInfo(@Param("teacherId") Integer teacherId);

    /**
     * 更新用户safe
     * @param id
     * @param safe
     * @return
     */
    int updataUserSafe(@Param("id") Integer id,@Param("safe") Integer safe);

    /**
     * 通过id获取密码
     * @param id
     * @return
     */
    String getPasswordById(@Param("id") Integer id);

    /**
     * 通过id修改密码
     * @param id
     * @param password
     * @return 为1就是成功
     */
    int updataUserPassword(@Param("id") Integer id,@Param("password") String password);
}
