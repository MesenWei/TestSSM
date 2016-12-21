package com.hailstone.common.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hailstone.bsms.golbal.Status;
import com.hailstone.bsms.model.PagesObject;
import com.hailstone.bsms.model.ViewObject;
import com.hailstone.bsms.pages.PageConverter;
import com.hailstone.common.dao.po.MyStudent;
import com.hailstone.server.business.DemoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author  maosheng
 * @date 创建时间：2016年12月19日 下午4:13:32
 */

@Controller
@RequestMapping("/demo")
public class DemoController {
	
	@Autowired
	private DemoService demoService;

	/**
	 * 测试jsp
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping("/returnPagePath")
	public String returnPagePath(HttpServletRequest request,String id){
		MyStudent ms = demoService.findMyStudentById(id);
		request.setAttribute("ms", ms);
		
		return "demo";
	}

	/**
	 * 测试返回json
	 * @param id
	 * @return
	 */
	@RequestMapping("/returnJSON")
	@ResponseBody
	public ViewObject<MyStudent> returnJSON(String id){
		ViewObject vo = new ViewObject();

		MyStudent ms = demoService.findMyStudentById(id);

		if(null == ms){
			vo.setStatus(Status.FAIL);
			vo.setMsg(getMsg(Status.FAIL));
			return vo;
		}

		vo.setStatus(Status.SUCC);
		vo.setMsg(getMsg(Status.SUCC));
		vo.setData(ms);

		return vo;
	}

	/**
	 * 分页测试
	 * @param myStudent
	 * @param pagesObject
	 * @return
	 */
	@RequestMapping("/pages")
	@ResponseBody
	public ViewObject<PagesObject<MyStudent>> pages(MyStudent myStudent,PagesObject pagesObject){
		ViewObject<PagesObject<MyStudent>> vo = new ViewObject();

		if(StringUtils.isNotBlank(pagesObject.getSort())) {
			PageHelper.startPage(pagesObject.getPageNum(), pagesObject.getPageSize());
		}else{
			// 默认时按时间倒序
			PageHelper.startPage(pagesObject.getPageNum(),pagesObject.getPageSize());
		}

		List<MyStudent> list = demoService.findMyStudent(myStudent);

		if(null != list){
			PageInfo<MyStudent> pageInfo = new PageInfo<>(list);

			PageConverter pageConverter = new PageConverter();
			PagesObject<MyStudent> po = pageConverter.converter(pageInfo);

			vo.setMsg("操作成功");
			vo.setStatus(Status.SUCC);
			vo.setData(po);
		}else {
			vo.setMsg("系统异常，请联系管理员");
			vo.setStatus(Status.FAIL);
		}

		return vo;
	}

	@RequestMapping("/association")
	@ResponseBody
	public ViewObject<MyStudent> association(String id){
		ViewObject vo = new ViewObject();

		MyStudent myStudent1 = demoService.queryForList1(id);
		MyStudent myStudent2 = demoService.queryForList2(id);
		MyStudent myStudent3 = demoService.queryForList3(id);

		vo.setMsg("操作成功");
		vo.setStatus(Status.SUCC);
		vo.setData(myStudent1);

		return vo;
	}

	public String getMsg(Integer status){
		String msg = "操作成功";
		switch (status){
			case 0 :
				break;
			case 1 :
				msg = "系统异常，请联系管理员";
				break;
		}

		return msg;
	}
	
}
