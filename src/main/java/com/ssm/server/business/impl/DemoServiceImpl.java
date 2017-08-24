package com.ssm.server.business.impl;

import java.util.List;
import java.util.UUID;

import com.ssm.bsms.dao.mapper.MyStudentMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.bsms.dao.po.MyStudent;
import com.ssm.bsms.dao.po.MyStudentExample;
import com.ssm.bsms.dao.po.MyStudentExample.Criteria;
import com.ssm.server.business.DemoService;

@Service
public class DemoServiceImpl implements DemoService{
	Logger logger = LogManager.getLogger(getClass());

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
	public MyStudent findMyStudentById(String id) throws Exception {
		logger.info("id is " + id);
		if(StringUtils.isBlank(id))
			throw new Exception("");

		return myStudentMapper.selectByPrimaryKey(id);
	}

	@Override
	public MyStudent queryForList1(String id) {
		return myStudentMapper.queryForList1(id);
	}

	@Override
	public MyStudent queryForList2(String id) {
		return myStudentMapper.queryForList2(id);
	}

	@Override
	public MyStudent queryForList3(String id) {
		return myStudentMapper.queryForList3(id);
	}


	@Override
	public Integer saveMyStudent(MyStudent myStudent) {
		Integer i = 0;
		if(null == myStudent)
			return i;
		
		if(null == myStudent.getId()){
			myStudent.setId(UUID.randomUUID().toString());
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
