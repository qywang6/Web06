<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="com.auto.web.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	Emp emp = (Emp) request.getAttribute("emp");
	%>
	<form action="">
		员工编号:<input name="empno" value="<%=emp.getEmpno()%>" readonly="readonly"/><br/>
		员工姓名:<input name="ename" value="<%=emp.getEname()%>" /><br/>
		员工职位:<input name="job" value="<%=emp.getJob()%>" /><br/>
		直属领导:<input name="mgr" value="<%=emp.getMgr()%>" /><br/>
		入职日期:<input name="hiredate" value="<%=emp.getHiredate()%>"/><br/>
		员工工资:<input name="sal" value="<%=emp.getSal()%>" /><br/>
		员工奖金:<input name="common" value="<%=emp.getCommon()%>" /><br/>
		部门编号:<input name="deptno" value="<%=emp.getDeptno()%>" /><br/>
		<input type="submit" value="增加员工">
	</form>
</body>
</html>