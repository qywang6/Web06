package com.auto.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddDeptServlet extends HttpServlet{
	public void service(HttpServletRequest request,
			HttpServletResponse response) throws IOException{
		// ����������������Ĳ���ʹ��utf-8
		request.setCharacterEncoding("utf-8");
		// ���͵���������Ĳ���ʹ��utf-8
		response.setContentType("text/html;charset=utf8");
		PrintWriter out = response.getWriter();
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		String dname = request.getParameter("dname");
		String loc = request.getParameter("loc");
		// ����AddDeptDao���󣬵�����addDept����������addDept.jspҳ����
		// ����Ĳ�����Ϣ���뵽���ݿ���
		Dept dept = new Dept();
		dept.setDeptno(deptno);
		dept.setDname(dname);
		dept.setLoc(loc);
		AddDeptDao addDeptDao = new AddDeptDao();
		addDeptDao.addDept(dept);
		
		out.println("��Ӳ��ųɹ�");
		
	}
}
