package com.hailstone.common.dao.mapper;

/**
 * 为了更方便的使用mybatis，增加BaseMapper.java接口，对应的也增加BaserMapper.xml
 * 此接口不做操作，BaseMapper.xml中存储所有的关联查询
 *
 * 目的是：
 *  这样将所有的关联查询写在BaseMapper.xml中，当数据库字段改变的时候，可以不用改变
 *  BaseMapper.xml中的内容
 *
 *  为了能更好的使用BaseMapper.xml，应当注意命名规范和使用技巧：
 *      命名规范
 *          1.
 * Created by Administrator on 2016/12/20.
 */
public interface BaseMapper {

}
