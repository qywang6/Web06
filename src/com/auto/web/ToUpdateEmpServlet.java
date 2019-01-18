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
		//����ҳ�洫�ݵĲ��ű��������
		int empno = Integer.parseInt(request.getParameter("id"));
		// ���ݸ����������ݿ��в�ѯ��һ�����Ŷ���
		FindEmpDao empDao = new FindEmpDao();
		Emp emp= empDao.findEmpById(empno);
		request.setAttribute("emp", emp);
		request.getRequestDispatcher("updateEmp.jsp").forward(request, response);
}
}