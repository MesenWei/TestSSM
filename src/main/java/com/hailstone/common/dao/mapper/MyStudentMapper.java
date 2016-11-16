package com.hailstone.common.dao.mapper;

import com.hailstone.common.dao.po.MyStudent;
import com.hailstone.common.dao.po.MyStudentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MyStudentMapper {
    int countByExample(MyStudentExample example);

    int deleteByExample(MyStudentExample example);

    int deleteByPrimaryKey(String id);

    int insert(MyStudent record);

    int insertSelective(MyStudent record);

    List<MyStudent> selectByExample(MyStudentExample example);

    MyStudent selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") MyStudent record, @Param("example") MyStudentExample example);

    int updateByExample(@Param("record") MyStudent record, @Param("example") MyStudentExample example);

    int updateByPrimaryKeySelective(MyStudent record);

    int updateByPrimaryKey(MyStudent record);
}