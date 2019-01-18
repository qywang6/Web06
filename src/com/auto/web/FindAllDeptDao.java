package com.auto.web;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class FindAllDeptDao {
	public List<Dept> findAllDept(){
		List<Dept> depts = new ArrayList<Dept>();
		try {
			String sql = "select * from dept";
			Connection conn = DBUtil.getConnection();
			PreparedStatement prep = conn.prepareStatement(sql);
			ResultSet res = prep.executeQuery();
			while(res.next()){
				Dept dept = new Dept();
				dept.setDeptno(res.getInt("deptno"));
				dept.setDname(res.getString("dname"));
				dept.setLoc(res.getString("loc"));
				depts.add(dept);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return depts;
		
	}

	public Dept findDeptById(int deptno) {
		// TODO Auto-generated method stub
		return null;
	}
}
