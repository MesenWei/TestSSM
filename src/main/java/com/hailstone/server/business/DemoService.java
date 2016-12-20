package com.hailstone.server.business;

import java.util.List;

import com.hailstone.common.dao.po.MyStudent;


public interface DemoService {
	public List<MyStudent> findMyStudent(MyStudent myStudent);
	
	public MyStudent findUniqueMyStudent(MyStudent myStudent);
	
	public MyStudent findMyStudentById(String id);

	public MyStudent queryForList(String id);

	public Integer saveMyStudent(MyStudent myStudent);
	
	public Integer updateMyStudent(MyStudent myStudent);
	
	public Integer updateMyStudentById(MyStudent myStudent);
	
	public Integer deleteMyStudent(MyStudent myStudent);
	
	public Integer deleteMyStudentById(String id);
	
}
