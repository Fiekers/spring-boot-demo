package com.ex.demo.mapper;

import com.ex.demo.bean.UserLog;
import com.ex.demo.bean.UserLogExample;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserLogMapper {
    int countByExample(UserLogExample example);

    int deleteByExample(UserLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserLog record);

    int insertSelective(UserLog record);

    List<UserLog> selectByExample(UserLogExample example);

    UserLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserLog record, @Param("example") UserLogExample example);

    int updateByExample(@Param("record") UserLog record, @Param("example") UserLogExample example);

    int updateByPrimaryKeySelective(UserLog record);

    int updateByPrimaryKey(UserLog record);
}