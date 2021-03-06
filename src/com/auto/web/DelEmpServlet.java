package com.auto.web;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DelEmpServlet extends HttpServlet{
	public void service(HttpServletRequest request,
			HttpServletResponse response) throws IOException{
		// 接收浏览器传递中文参数使用utf-8
		request.setCharacterEncoding("utf-8");
		// 发送到浏览器中文参数使用utf-8
		response.setContentType("text/html;charset=utf8");
		//获取 删除链接中的请求参数id
		int empno = Integer.parseInt(request.getParameter("id"));
		// 创建DeleteDeptDao对象，调用其删除的方法
		DeleteEmpDao deleteDao = new DeleteEmpDao();
		deleteDao.deleteEmp(empno);
//		PrintWriter out = response.getWriter();
//		out.println("删除部门成功");
		// 删除部门成功之后，重新再次查询数据库记录
		response.sendRedirect("findAllEmp.do");
	}
}
