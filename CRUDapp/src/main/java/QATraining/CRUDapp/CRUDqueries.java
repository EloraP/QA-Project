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
		String create = "INSERT INTO strikes(dateOfStrike, location, leader, tradeUnion, workArea, capacity) "
				+ "VALUES ('" + s.getDateOfStrike() + "', '" + s.getLocation() + "', '" 
				+ s.getLeader() + "', '" + s.getTradeUnion() + "', '" + s.getWorkArea() + "', " 
				+ s.getCapacity() + ");";
		
		try {
			stmt.executeUpdate(create);
			System.out.println("Create statement executed");
		} catch (SQLException e) {
			System.out.println("Bad query");
			e.printStackTrace();
		}
	}
	
	public void view() {
		String read = "SELECT * FROM strikes";
		
		try {
			rs = stmt.executeQuery(read);
			while (rs.next()) {
				System.out.println("ID: " + rs.getInt("id"));
				System.out.println("Date: " + rs.getString("dateOfStrike"));
				System.out.println("Location: " + rs.getString("location"));
				System.out.println("Leader: " + rs.getString("leader"));
				System.out.println("Trade Union: " + rs.getString("tradeUnion"));
				System.out.println("Work Area: " + rs.getString("workArea"));
				System.out.println("Capacity: " + rs.getInt("capacity"));
				System.out.println();
			}

		} catch (SQLException e) {
			System.out.println("Bad query");
			e.printStackTrace();
		}
	}
	
	public void update(int id, String value, String feature) {
		String update = "UPDATE strikes SET " + feature + " = '" + value + "' WHERE id = " + id + ";";
		
		try {
			stmt.executeUpdate(update);
			System.out.println("Update statement executed");
			
		}catch (SQLException e) {
			System.out.println("Bad query");
			e.printStackTrace();
		}
	}
	
	public void delete(int id) {
		String del = "DELETE FROM strikes WHERE id = " + id;
		
		try {
			stmt.executeUpdate(del);
			System.out.println("Delete statement executed");
		} catch (SQLException e) {
			System.out.println("Bad query");
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			conn.close();
			System.out.println("Closed!");
		} catch (SQLException e) {
			System.out.println("Closing connection...");
			e.printStackTrace();
		}
	}

}
