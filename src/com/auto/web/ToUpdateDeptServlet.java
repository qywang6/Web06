package com.auto.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ToUpdateDeptServlet extends HttpServlet {
	public void service(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf8");
		//����ҳ�洫�ݵĲ��ű��������
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		// ���ݸ����������ݿ��в�ѯ��һ�����Ŷ���
		FindDeptDao deptDao = new FindDeptDao();
		Dept dept = deptDao.findDeptById(deptno);
		request.setAttribute("dept", dept);
		request.getRequestDispatcher("updateDept.jsp").forward(request, response);
	}
}
