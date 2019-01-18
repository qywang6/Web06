package com.auto.web;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class AddDeptDao {
	public void addDept(Dept dept){
		
		try {
			String sql = "insert into dept  values(?,?,?)";
			Connection conn = DBUtil.getConnection();
			PreparedStatement prep = conn.prepareStatement(sql);
			prep.setInt(1, dept.getDeptno());
			prep.setString(2, dept.getDname());
			prep.setString(3, dept.getLoc());
			prep.executeUpdate();
			int result = prep.executeUpdate();
			if(result>0){
					System.out.println("新增部门成功");
			}else{
				System.out.println("新增部门工失败");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}
