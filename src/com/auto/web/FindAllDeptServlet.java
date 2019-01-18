package com.auto.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FindAllDeptServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// ����������������Ĳ���ʹ��utf-8
		request.setCharacterEncoding("utf-8");
		// ���͵���������Ĳ���ʹ��utf-8
		response.setContentType("text/html;charset=utf8");
		// �Ӳ��ű��н����еĲ��Ų�ѯ��������һ�����ż��ϵ���java���С�
		FindAllDeptDao deptDao = new FindAllDeptDao();
		List<Dept> depts = deptDao.findAllDept();
		//�����ż��ϰ󶨵�request���������
		request.setAttribute("depts", depts);
		//�����ż���ͨ��requestת����deptList.jspҳ��
		request.getRequestDispatcher("deptList.jsp").forward(request, response);
	
	}
}
