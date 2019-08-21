package com.chillax.controller;


import java.sql.DriverManager;
import java.sql.SQLException;

import javax.resource.cci.Connection;

public class test {
	public static void main(String[] args) {
		System.out.println("test.main() start 1");
		try {
									//jdbc:oracle:thin:@//192.168.20.1:1521/orcl    jdbc:oracle:thin:@10.188.24.140:1521:orcl
			Connection con = (Connection) DriverManager.getConnection("jdbc:oracle:thin:@10.188.24.140:1521:orcl",
					"jtcxm0", "jtcxm0");
			if (con != null) {
				System.out.println("connecte succ.");
			} else {
				System.out.println("fail.");
			}
			System.out.println("test.main() start 2");
		} catch (SQLException se) {
			System.out.println("数据库连接失败！");
			se.printStackTrace();
		}
	}
}
