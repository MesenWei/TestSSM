package com.ssm.bsms.dao.mapper;

import com.ssm.bsms.dao.po.MyStudent;
import com.ssm.bsms.dao.po.MyStudentExample;
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

    MyStudent queryForList1(@Param(value="id")String id);

    MyStudent queryForList2(@Param(value="id")String id);

    MyStudent queryForList3(@Param(value="id")String id);
}