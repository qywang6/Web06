package com.auto.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ToUpdateEmpServlet extends HttpServlet {
	public void service(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf8");
		//接收页面传递的部门编号条件，
		int empno = Integer.parseInt(request.getParameter("id"));
		// 依据该条件从数据库中查询到一个部门对象
		FindEmpDao empDao = new FindEmpDao();
		Emp emp= empDao.findEmpById(empno);
		request.setAttribute("emp", emp);
		request.getRequestDispatcher("updateEmp.jsp").forward(request, response);
}
}