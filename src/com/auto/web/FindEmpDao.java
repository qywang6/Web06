package com.auto.web;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FindEmpDao {
	public Emp findEmpById(int empno){
		Emp emp = null;
		try {
			String sql = "select * from emp where empno=?";
			Connection conn=DBUtil.getConnection();
			PreparedStatement prep = conn.prepareStatement(sql);
			prep.setInt(1, empno);
			ResultSet res = prep.executeQuery();
			if(res.next()){
				emp = new Emp();
				emp.setEmpno(res.getInt("empno"));
				emp.setEname(res.getString("ename"));
				emp.setJob(res.getString("job"));
				emp.setMgr(res.getInt("mrg"));
				emp.setHiredate(res.getDate("hiredate"));
				emp.setSal(res.getDouble("sal"));
				emp.setCommon(res.getDouble("comm"));
				emp.setDeptno(res.getInt("deptno"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emp;
	}
	}
