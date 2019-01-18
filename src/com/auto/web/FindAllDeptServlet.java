package com.auto.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FindAllDeptServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// 接收浏览器传递中文参数使用utf-8
		request.setCharacterEncoding("utf-8");
		// 发送到浏览器中文参数使用utf-8
		response.setContentType("text/html;charset=utf8");
		// 从部门表中将所有的部门查询出来返回一个部门集合到该java类中。
		FindAllDeptDao deptDao = new FindAllDeptDao();
		List<Dept> depts = deptDao.findAllDept();
		//将部门集合绑定到request请求对象中
		request.setAttribute("depts", depts);
		//将部门集合通过request转发到deptList.jsp页面
		request.getRequestDispatcher("deptList.jsp").forward(request, response);
	
	}
}
