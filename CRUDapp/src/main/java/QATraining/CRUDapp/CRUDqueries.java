package QATraining.CRUDapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CRUDqueries {
	
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	
	public CRUDqueries() {
		try {
			conn = DriverManager.getConnection(DBConfig.URL, DBConfig.USER, DBConfig.PASS);
			stmt = conn.createStatement();// create a statement object to execute sql queries
			System.out.println("Connection Successful!");
		} catch (SQLException e) {
			System.out.println("Incorrect credentials");
			e.printStackTrace();
		}
	}
	
	public void create(Strike s) {
		System.out.println("create strike");
	}
	
	public void view() {
		System.out.println("view all database");
	}
	
	public void update(int id, String value, String feature) {
		System.out.println("update " + id);
	}
	
	public void delete(int id) {
		System.out.println("delete " + id);
	}
	
	public void close() {
		System.out.println("close connection");
	}

}
