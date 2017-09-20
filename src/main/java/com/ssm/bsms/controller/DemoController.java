package com.ssm.bsms.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.bsms.common.global.Status;
import com.ssm.bsms.common.pages.PagesObject;
import com.ssm.bsms.common.pages.ViewObject;
import com.ssm.bsms.common.pages.PageConverter;
import com.ssm.bsms.dao.po.MyStudent;
import com.ssm.server.business.DemoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * controller只分发请求和校验参数，其余的任何逻辑都放在service层。
 * 因为
 * 1.在spring中，controller是单例的，存在线程安全问题，但是springmvc默认设置service不是单例模式，是线程安全的。
 * 2.同时也能体现分层的思想。
 *
 * @author maosheng
 * @date 创建时间：2016年12月19日 下午4:13:32
 */

@Controller
@RequestMapping("/demo")
public class DemoController {
    @Autowired
    private DemoService demoService;

    /**
     * 测试jsp
     *
     * @param request
     * @param id
     * @return
     */
    @RequestMapping("/returnPagePath")
    public String returnPagePath(HttpServletRequest request, String id) {
        MyStudent ms = null;
        try {
            ms = demoService.findMyStudentById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("ms", ms);

        return "demo";
    }

    /**
     * 测试返回json。
     * 测试异常处理。
     *
     * @param id
     * @return
     */
    @RequestMapping("/returnJSON")
    @ResponseBody
    public ViewObject<MyStudent> returnJSON(String id) {
        ViewObject vo = new ViewObject();
        try {
            MyStudent ms = demoService.findMyStudentById(id);

            if (null == ms) {
                vo.setCode(Status.FAIL);
                vo.setMsg(getMsg(Status.FAIL));
                return vo;
            }

            vo.setCode(Status.SUCC);
            vo.setMsg(getMsg(Status.SUCC));
            vo.setData(ms);
        } catch (Exception e) {
            vo.setCode(Status.FAIL);
            vo.setMsg(getMsg(Status.FAIL));
            e.printStackTrace();
        }
        return vo;
    }

    /**
     * 分页测试
     *
     * @param myStudent
     * @param pagesObject
     * @return
     */
    @RequestMapping("/pages")
    @ResponseBody
    public ViewObject<PagesObject<MyStudent>> pages(MyStudent myStudent, PagesObject pagesObject) {
        ViewObject<PagesObject<MyStudent>> vo = new ViewObject();
        try {
            if (StringUtils.isNotBlank(pagesObject.getSort())) {
                PageHelper.startPage(pagesObject.getPageNum(), pagesObject.getPageSize());
            } else {
                // 默认时按时间倒序
                PageHelper.startPage(pagesObject.getPageNum(), pagesObject.getPageSize());
            }

            List<MyStudent> list = demoService.findMyStudent(myStudent);


            if (null != list) {
                PageInfo<MyStudent> pageInfo = new PageInfo<>(list);

                PageConverter pageConverter = new PageConverter();
                PagesObject<MyStudent> po = pageConverter.converter(pageInfo);

                vo.setMsg("操作成功");
                vo.setCode(Status.SUCC);
                vo.setData(po);
            } else {
                vo.setMsg("系统异常，请联系管理员");
                vo.setCode(Status.FAIL);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return vo;
    }

    @RequestMapping("/association")
    @ResponseBody
    public ViewObject<MyStudent> association(String id) {
        ViewObject vo = new ViewObject();
        try {
            MyStudent myStudent1 = demoService.queryForList1(id);
            MyStudent myStudent2 = demoService.queryForList2(id);
            MyStudent myStudent3 = demoService.queryForList3(id);
            vo.setMsg("操作成功");
            vo.setCode(Status.SUCC);
            vo.setData(myStudent1);
        } catch (Exception e) {
            e.printStackTrace();
        }


        return vo;
    }

    /**
     * 应该是springmvc在装配参数的时候，自动检测session是否存在，
     * 如果不存在，则自动创建了一个session，肯定也自动放到了cookie中。
     *
     * @param request
     * @param session
     * @return
     */
    @RequestMapping("/getSion")
    @ResponseBody
    public ViewObject<String> getSion(HttpServletRequest request, HttpSession session) {
        ViewObject vo = new ViewObject();

        vo.setMsg("操作成功");
        vo.setCode(Status.SUCC);
        vo.setData(session.getId());

        return vo;
    }

    public String getMsg(Integer status) {
        String msg = "操作成功";
        switch (status) {
            case 0:
                break;
            case -1:
                msg = "系统异常，请联系管理员";
                break;
        }

        return msg;
    }

}
