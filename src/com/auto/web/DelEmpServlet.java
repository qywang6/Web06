package com.auto.web;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DelEmpServlet extends HttpServlet{
	public void service(HttpServletRequest request,
			HttpServletResponse response) throws IOException{
		// ����������������Ĳ���ʹ��utf-8
		request.setCharacterEncoding("utf-8");
		// ���͵���������Ĳ���ʹ��utf-8
		response.setContentType("text/html;charset=utf8");
		//��ȡ ɾ�������е��������id
		int empno = Integer.parseInt(request.getParameter("id"));
		// ����DeleteDeptDao���󣬵�����ɾ���ķ���
		DeleteEmpDao deleteDao = new DeleteEmpDao();
		deleteDao.deleteEmp(empno);
//		PrintWriter out = response.getWriter();
//		out.println("ɾ�����ųɹ�");
		// ɾ�����ųɹ�֮�������ٴβ�ѯ���ݿ��¼
		response.sendRedirect("findAllEmp.do");
	}
}
