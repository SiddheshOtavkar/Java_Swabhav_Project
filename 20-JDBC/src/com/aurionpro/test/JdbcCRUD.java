package com.aurionpro.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcCRUD {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		// register Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// create connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo", "root", "root123");
		
		System.out.println("Connected to database!!");
		
		// Insert operation
		// create statement
		String insertQuery = "insert into students(id, name) value(?, ?)";
		
//		PreparedStatement ps = connection.prepareStatement(insertQuery);
//		ps.setString(1, "33");
//		ps.setString(2, "Nilesh");
//		ps.execute();
//		
//		ps.setString(1, "23");
//		ps.setString(2, "Amit");
//		int rows = ps.executeUpdate();
//		System.out.println("Rows " + rows);
//		
//		System.out.println("Insertion Done");
		
		// Fetch (Display) data
//		String displayQuery = "select * from students";
//		
//		Statement st = connection.createStatement();
//		ResultSet rs = st.executeQuery(displayQuery);
//		
//		while(rs.next()) {
//			System.out.println(rs.getString("id") + "------>" + rs.getString("name"));
//		}
		
		// Update Data
//		String updateQuery = "update students set name = ? where id = ?";
//		
//		PreparedStatement ps2 = connection.prepareStatement(updateQuery);
//		ps2.setString(1, "Virat");
//		ps2.setLong(2, 23);
//		int updateRows = ps2.executeUpdate();
//		System.out.println("Updated Rows: " + updateRows);
		
		// Delete Data
		String deleteQuery = "delete from students where id = ?";
		
		PreparedStatement ps3 = connection.prepareStatement(deleteQuery);
		ps3.setLong(1, 33);
		ps3.execute();
		System.out.println("Deletion done successfully!!");
		
		connection.close();
	}
	
}
