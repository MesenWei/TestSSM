package com.ssm.server.business;

import java.util.List;

import com.ssm.bsms.dao.po.MyStudent;


public interface DemoService {
	List<MyStudent> findMyStudent(MyStudent myStudent) throws Exception;
	
	MyStudent findUniqueMyStudent(MyStudent myStudent) throws Exception;
	
	MyStudent findMyStudentById(String id) throws Exception;

	MyStudent queryForList1(String id) throws Exception;

	MyStudent queryForList2(String id) throws Exception;

	MyStudent queryForList3(String id) throws Exception;

	Integer saveMyStudent(MyStudent myStudent) throws Exception;
	
	Integer updateMyStudent(MyStudent myStudent) throws Exception;
	
	Integer updateMyStudentById(MyStudent myStudent) throws Exception;
	
	Integer deleteMyStudent(MyStudent myStudent) throws Exception;
	
	Integer deleteMyStudentById(String id) throws Exception;
	
}
