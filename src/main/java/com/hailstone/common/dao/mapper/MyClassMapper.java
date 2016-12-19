package com.hailstone.common.dao.mapper;

import com.hailstone.common.dao.po.MyClass;
import com.hailstone.common.dao.po.MyClassExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MyClassMapper {
    int countByExample(MyClassExample example);

    int deleteByExample(MyClassExample example);

    int deleteByPrimaryKey(String id);

    int insert(MyClass record);

    int insertSelective(MyClass record);

    List<MyClass> selectByExample(MyClassExample example);

    MyClass selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") MyClass record, @Param("example") MyClassExample example);

    int updateByExample(@Param("record") MyClass record, @Param("example") MyClassExample example);

    int updateByPrimaryKeySelective(MyClass record);

    int updateByPrimaryKey(MyClass record);
}