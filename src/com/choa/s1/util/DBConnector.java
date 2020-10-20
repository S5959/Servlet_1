package com.choa.s1.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnector {
	
	public Connection getConnection() throws Exception {
		//1. DB 연결 정보
		String user = "hr";
		String password = "tiger";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		//2. driver를 메모리에 리딩
		Class.forName(driver);
		System.out.println("Driver Loading");
		
		//3. DB 로그인 Connection 객체 반환
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println(con);
		
		return con;		
	}
}
