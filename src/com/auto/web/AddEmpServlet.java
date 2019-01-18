package com.auto.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddEmpServlet extends HttpServlet {
	public void service(HttpServletRequest request,
			HttpServletResponse response) throws IOException{
		// ����������������Ĳ���ʹ��utf-8
		request.setCharacterEncoding("utf-8");
		// ���͵���������Ĳ���ʹ��utf-8
		response.setContentType("text/html;charset=utf8");
		//���ձ��ύ���������
		int empno = Integer.parseInt(request.getParameter("empno"));
		String ename = request.getParameter("ename");
		String job = request.getParameter("job");
		int mgr = 0;
		//�����ҳ���ȡ��ֱ���쵼��Ų�Ϊ�գ�����Խ���ǿ��ת��
		if(!request.getParameter("mgr").equals("")){
			 mgr = Integer.parseInt(request.getParameter("mgr"));
		}
		
		String hiredate = request.getParameter("hiredate");
		double sal = Double.parseDouble(request.getParameter("sal"));
		double comm = Double.parseDouble(request.getParameter("comm"));
		int deptno  =Integer.parseInt( request.getParameter("deptno"));
		Emp emp = new Emp();
		emp.setCommon(comm);
		emp.setDeptno(deptno);
		emp.setEmpno(empno);
		emp.setEname(ename);
		// ��ΪԱ��������hiredate������һ��Date(����)�������ݣ������Ǵӱ�
		// ���յ�hiredate��һ���ַ���������Ҫ�����ַ������ø�Emp���������
		// ���ԣ���Ҫ���ַ���ת��ΪDate�������� 
		SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd");
		Date hdate;
		try {
			hdate = sdf.parse(hiredate);
			emp.setHiredate(hdate);
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		emp.setJob(job);
		emp.setMgr(mgr);
		emp.setSal(sal);
		AddEmpDao empDao = new AddEmpDao();
		empDao.addEmp(emp);
		PrintWriter out = response.getWriter();
		// �ض��� �����·���һ������ ����������Ա��֮�󣬿�����ִ��һ�β�ѯ��
		// �����е�Ա����ѯ����
		response.sendRedirect("findAllEmp.do");
		
	}
}
