<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.*,com.auto.web.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <table>
  	<tr>
  		<td>部门编号</td>
  		<td>部门地址</td>
  		<td>部门名称</td>
  		<td>操作</td>
  			
  	</tr>
  	<!-- 在jsp页面接收转发过来的集合，使用java代码片段完成 -->
  	<%
  		// 这个方法返回值是一个Object
  		
  		List<Dept> depts = (List<Dept> )request.getAttribute("depts");
  		for(int i=0;i<depts.size();i++){
  			//循环获得每一个部门对象
  			Dept d = depts.get(i);
  			//在java代码片段中不能出现html标签，所以我们将标签定义在java
  			// 代码片段之外  <%=d.getDeptno() % > 代码输出语句
  			// http://localhost:8080/web02/findAllEmp.do
  	%>		
  	
	  		<tr>
	  			
	  	  		<td><%=d.getDeptno() %></td>
	  	  		<td><%=d.getLoc() %></td>
	  	  		<td><%=d.getDname() %></td>
	  	  		<!-- 删除写一个Servlet请求，接收删除的编号，依据编号
	  	  		将数据库中该记录删除
	  	  		 -->
	  	  		 <td><a href="delDept.do?id=<%=d.getDeptno() %>">删除</a>&nbsp;&nbsp;
	  	  		<!-- 跳转到修改页面时，需要绑定当前要修改的对象信息。 
	  	  		    此时需要通过绑定一个跳转到修改页面的请求，先从数据库中
	  	  		    将要修改的数据查询出来，转发到修改页面即可
	  	  		  -->
	  	  		<a href="toUpdateDept.do?deptno=<%=d.getDeptno()%>">修改</a>  
	  	  	
	  	  	</tr>
	 <% 	  	
  		}
  	%>
    </table>
    <a  href="addDept.jsp">增加</a>
</body>
</html>