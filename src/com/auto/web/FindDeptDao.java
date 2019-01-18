package com.auto.web;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FindDeptDao {
	// ��servlet�н��յ��Ĳ��ű����Ϊ������ȥ���ݿ��ѯ
	// ����������Ĳ�����Ϣ��������
	public Dept findDeptById(int deptno){
		Dept dept = null;
		try {
			String sql = "select * from dept where deptno=?";
			Connection conn = DBUtil.getConnection();
			PreparedStatement prep = conn.prepareStatement(sql);
			prep.setInt(1, deptno);
			// �ý������ֻ��һ������ 
			ResultSet res = prep.executeQuery();
			// ���ݱ��ֶ�����ȡ���ֶ�ֵ����Ϊ���Ŷ�����������
			if(res.next()){
				dept = new Dept();
				dept.setDeptno(res.getInt("deptno"));
				dept.setDname(res.getString("dname"));
				dept.setLoc(res.getString("loc"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dept;
	}
}
