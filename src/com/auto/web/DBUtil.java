package com.auto.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ���ӷ������ݿ�Ĺ�����
 * */
public class DBUtil {
	static String url ="jdbc:mysql://localhost:3306/xinhua?useUnicode=true&characterEncoding=utf8";
	// �������ݿ������������
	static String driver="com.mysql.jdbc.Driver";
	// �������ݿ���û���
	static String username="root" ;
	// �������ݿ������
	static String password="root" ;
	
	//��̬���� ������������ֱ�ӵ���
	public static Connection getConnection(){
		// try�������������ִ��ʱ�����õĴ����
		// catch�д����ǵ������쳣ʱ��ִ�еĴ����
		try {
			// ��������
			Class.forName(driver);
			//��ȡ���ݿ����Ӷ���Connection
			Connection conn = DriverManager.getConnection(url, username, password);
			return conn;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}
