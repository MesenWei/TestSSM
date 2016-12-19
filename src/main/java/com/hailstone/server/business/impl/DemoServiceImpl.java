package com.hailstone.server.business.impl;

import java.util.List;

import com.hailstone.common.dao.mapper.MyStudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hailstone.common.dao.po.MyStudent;
import com.hailstone.common.dao.po.MyStudentExample;
import com.hailstone.common.dao.po.MyStudentExample.Criteria;
import com.hailstone.server.business.DemoService;

@Service
public class DemoServiceImpl implements DemoService{

	@Autowired
	private MyStudentMapper myStudentMapper;
	
	@Override
	public List<MyStudent> findMyStudent(MyStudent myStudent) {
		
		List<MyStudent> myStudentList = myStudentMapper.selectByExample(addWhere(myStudent));
		return myStudentList;
	}

	@Override
	public MyStudent findUniqueMyStudent(MyStudent myStudent) {
		// TODO Auto-generated method stub
		List<MyStudent> myStudentList = myStudentMapper.selectByExample(addWhere(myStudent));
		
		MyStudent ms = null;
		if(null != myStudentList)
			ms = myStudentList.get(0);
		
		return ms;
	}

	@Override
	public MyStudent findMyStudentById(String id) {
		return myStudentMapper.selectByPrimaryKey(id);
	}


	@Override
	public Integer saveMyStudent(MyStudent myStudent) {
		Integer i = 0;
		if(null == myStudent)
			return i;
		
		if(null == myStudent.getId()){
			myStudent.setId("");
			i = myStudentMapper.insertSelective(myStudent);
		}else{
			i = myStudentMapper.updateByPrimaryKey(myStudent);
		}
		
		return i;
	}


	@Override
	public Integer updateMyStudent(MyStudent myStudent) {
		return myStudentMapper.updateByExample(myStudent, addWhere(myStudent));
	}

	@Override
	public Integer updateMyStudentById(MyStudent myStudent){
		Integer i = 0;
		if(null == myStudent || null == myStudent.getId())
			return i;
		else
			i = myStudentMapper.updateByPrimaryKey(myStudent);
		
		return i;
	}

	@Override
	public Integer deleteMyStudent(MyStudent myStudent) {
		return myStudentMapper.deleteByExample(addWhere(myStudent));
	}

	@Override
	public Integer deleteMyStudentById(String id) {
		return myStudentMapper.deleteByPrimaryKey(id);
	}

	public MyStudentExample addWhere(MyStudent myStudent){
		MyStudentExample example = new MyStudentExample();
		
		if(null == myStudent)
			return example;
		
		Criteria criteria = example.createCriteria();
		
		if(null != myStudent.getId())
			criteria.andIdEqualTo(myStudent.getId());
		
		return example;
	}



}
