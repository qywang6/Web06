package com.auto.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FindAllEmpServlet  extends HttpServlet{
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// ����������������Ĳ���ʹ��utf-8
		request.setCharacterEncoding("utf-8");
		// ���͵���������Ĳ���ʹ��utf-8
		response.setContentType("text/html;charset=utf8");
		// ͨ��FindAllEmpDao ��ѯ����һ��Ա������ļ���
		FindAllEmpDao findAllEmp = new FindAllEmpDao();
		
		List<Emp> emps = findAllEmp.findAll();
		// ��emps����ͨ��request��
		request.setAttribute("emps", emps);
		//�� ����ת����Ա����ѯҳ��
		request.getRequestDispatcher("empList.jsp").forward(request, response);
	}
}
