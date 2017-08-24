package com.ssm.server.business;

import java.util.List;

import com.ssm.bsms.dao.po.MyStudent;


public interface DemoService {
	public List<MyStudent> findMyStudent(MyStudent myStudent);
	
	public MyStudent findUniqueMyStudent(MyStudent myStudent);
	
	public MyStudent findMyStudentById(String id) throws Exception;

	public MyStudent queryForList1(String id);

	public MyStudent queryForList2(String id);

	public MyStudent queryForList3(String id);

	public Integer saveMyStudent(MyStudent myStudent);
	
	public Integer updateMyStudent(MyStudent myStudent);
	
	public Integer updateMyStudentById(MyStudent myStudent);
	
	public Integer deleteMyStudent(MyStudent myStudent);
	
	public Integer deleteMyStudentById(String id);
	
}
