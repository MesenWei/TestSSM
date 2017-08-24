package com.ssm.bsms.dao.mapper;

import com.ssm.bsms.dao.po.MyCourse;
import com.ssm.bsms.dao.po.MyCourseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MyCourseMapper {
    int countByExample(MyCourseExample example);

    int deleteByExample(MyCourseExample example);

    int deleteByPrimaryKey(String id);

    int insert(MyCourse record);

    int insertSelective(MyCourse record);

    List<MyCourse> selectByExample(MyCourseExample example);

    MyCourse selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") MyCourse record, @Param("example") MyCourseExample example);

    int updateByExample(@Param("record") MyCourse record, @Param("example") MyCourseExample example);

    int updateByPrimaryKeySelective(MyCourse record);

    int updateByPrimaryKey(MyCourse record);
}