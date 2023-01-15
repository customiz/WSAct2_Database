package com.stou.lab2;

import java.sql.*;

public class Database {
	public static Connection getConnection() {
		Connection connect = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connect = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/smartwatch" + "?user=root&password=123456");
			if (connect != null) {
				System.out.println("Database Connected ");
			} else {
				System.out.println("Database Connect Failed.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error: " + e);
		}
		return connect;
	}

	public static void close(Connection con) {
		try {
			con.close();
		} catch (Exception ex) {

		}
	}

}
