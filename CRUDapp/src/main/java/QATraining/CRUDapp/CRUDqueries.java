package QATraining.CRUDapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
//import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

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
	
	public Object create(String table, Object s) {
		String create = ""; 
		
		switch(table) {
			case "s":
				
				create = "INSERT INTO strikes(dateOfStrike, location, tradeUnionID, workArea, capacity) " 
						+ "VALUES ('" + ((Strike) s).getDateOfStrike() + "', '" + ((Strike) s).getLocation() + "', '" 
						+ ((Strike) s).getTradeUnionID() + "', '" + ((Strike) s).getWorkArea() + "', " 
						+ ((Strike) s).getCapacity() + ");";
				
				break;
				
			case "t":
				create = "INSERT INTO tradeUnions(fullName, TUName, numberOfMembers, established) " 
						+ "VALUES ('" + ((TradeUnions) s).getFullName() + "', '" + ((TradeUnions) s).getName()
						+ "', " + ((TradeUnions) s).getNumberOfMembers() + ", " + ((TradeUnions) s).getYear() + ");";
				break;
			
			case "l":
				create = "INSERT INTO leaders(leaderName, age, yearsOfExperience, tradeUnionID) " 
						+ "VALUES ('" + ((Leaders) s).getLeaderName() + "', " + ((Leaders) s).getAge() + ", "
						+ ((Leaders) s).getYearsOfExperience() + ", " + ((Leaders) s).getTradeUnionId() + ");";
				break;
				
		}
		
		try {
			stmt.executeUpdate(create);
			System.out.println("Create statement executed");
			return s;
		}
		catch (SQLException e) {
			
			try {
				
				if(table.equals("s")) {
					rs = stmt.executeQuery("SELECT * FROM tradeUnions WHERE id = " + ((Strike)s).getTradeUnionID() + ";");
					if(!rs.next()) {
						
						System.out.println("No Trade Union with id " + ((Strike)s).getTradeUnionID() + ". Create Trade Union? (Enter y or n)");
						Scanner sc = new Scanner(System.in);
						if(sc.nextLine().equals("y")) {
	
							Choices c = new Choices();
							TradeUnions tu = new TradeUnions();
							c.createWithId(2, ((Strike)s).getTradeUnionID(), tu);
							create(table, s);
						}
						else {
							System.out.println("Enter new id?");
							if(sc.nextLine().equals("y")) {
								System.out.println("Enter new id:");
								int newId = sc.nextInt();
								sc.nextLine();
								((Strike)s).setTradeUnionID(newId);
								create(table, s);
							}
						}
						
					}
					
					
				}else if(table.equals("l")) {
					
					rs = stmt.executeQuery("SELECT * FROM tradeUnions WHERE id = " + ((Leaders)s).getTradeUnionId() + ";");
					if(!rs.next()) {
						
						System.out.println("No Trade Union with id " + ((Leaders)s).getTradeUnionId() + ". Create Trade Union? (Enter y or n)");
						Scanner sc = new Scanner(System.in);
						if(sc.nextLine().equals("y")) {
	
							Choices c = new Choices();
							TradeUnions tu = new TradeUnions();
							c.createWithId(2, ((Leaders)s).getTradeUnionId(), tu);
							create(table, s);
						}
						else {
							System.out.println("Enter new id?");
							if(sc.nextLine().equals("y")) {
								System.out.println("Enter new id:");
								int newId = sc.nextInt();
								sc.nextLine();
								((Leaders)s).setTradeUnionId(newId);
								create(table, s);
							}
						}
						
					}
					
				}
				
				
				

			}
			
			catch (SQLException ev1) {
				System.out.println("Bad Query");
			}
		}
		
		return  null;
	}
	
	public Object createWithID(String table, Object s) {
		
		String create = ""; 
		
		switch(table) {
			case "s":
				create = "INSERT INTO strikes(id, dateOfStrike, location, tradeUnionID, workArea, capacity) " 
						+ "VALUES (" + ((Strike)s).getId() + ", '" + ((Strike) s).getDateOfStrike() + "', '" + ((Strike) s).getLocation() + "', '" 
						+ "', '" + ((Strike) s).getTradeUnionID() + "', '" + ((Strike) s).getWorkArea() + "', " 
						+ ((Strike) s).getCapacity() + ");";
				
				break;
				
			case "t":
				create = "INSERT INTO tradeUnions(id, fullName, TUName, numberOfMembers, established) " 
						+ "VALUES (" + ((TradeUnions) s).getId() + ", '" + ((TradeUnions) s).getFullName() + "', '" + ((TradeUnions) s).getName()
						+ "', " + ((TradeUnions) s).getNumberOfMembers() + ", " + ((TradeUnions) s).getYear() + ");";
				break;
			
			case "l":
				System.out.println(((Leaders)s).getTradeUnionId());
				create = "INSERT INTO leaders(id, leaderName, age, yearsOfExperience, tradeUnionID) " 
						+ "VALUES (" + ((Leaders) s).getId() + ", '" + ((Leaders) s).getLeaderName() + "', " + ((Leaders) s).getAge() + ", "
						+ ((Leaders) s).getYearsOfExperience() + ", " + ((Leaders) s).getTradeUnionId() + ");";
				break;
				
				
		}
		
		try {
			
			stmt.executeUpdate(create);
			
			System.out.println("Create statement executed");
			return s;
		} catch(SQLIntegrityConstraintViolationException e) {
			
			System.out.println(e);
			
		}
		catch (SQLException e) {
			System.out.println("Bad query");
			e.printStackTrace();
		}
		
		return  null;
	}
	
	public ArrayList<Object> view(int table) {
		ArrayList<Object> list = new ArrayList<Object>();
		
		String read;
		if(table == 1) {
			read = "SELECT * FROM strikes";
			Strike strike = new Strike();
			
			try {
				rs = stmt.executeQuery(read);
				while (rs.next()) {
					System.out.println("ID: " + rs.getInt("id"));
					strike.setId(rs.getInt("id"));
					System.out.println("Date: " + rs.getString("dateOfStrike"));
					strike.setDateOfStrike(rs.getString("dateOfStrike"));
					System.out.println("Location: " + rs.getString("location"));
					strike.setLocation(rs.getString("location"));
					System.out.println("Trade Union ID: " + rs.getInt("tradeUnionID"));
					strike.setTradeUnionID(rs.getInt("tradeUnionID"));
					System.out.println("Work Area: " + rs.getString("workArea"));
					strike.setWorkArea(rs.getString("workarea"));
					System.out.println("Capacity: " + rs.getInt("capacity"));
					strike.setCapacity(rs.getInt("capacity"));
					
					list.add(strike);
					
					System.out.println();
				}
				return list;

			} catch (SQLException e) {
				
				System.out.println("Bad query");
				e.printStackTrace();
			}
			
		}else if(table == 2) {
			read = "SELECT * FROM tradeUnions";
			TradeUnions tu = new TradeUnions();
			
			try {
				rs = stmt.executeQuery(read);
				while (rs.next()) {
					System.out.println("ID: " + rs.getInt("id"));
					tu.setId(rs.getInt("id"));
					System.out.println("Full Name: " + rs.getString("fullName"));
					tu.setFullName(rs.getString("fullName"));
					System.out.println("Abreviated Name: " + rs.getString("TUName"));
					tu.setName(rs.getString("TUName"));
					System.out.println("Number of Members: " + rs.getInt("numberOfMembers"));
					tu.setNumberOfMembers(rs.getInt("numberOfMembers"));
					System.out.println("Year: " + rs.getInt("established"));
					tu.setYear(rs.getInt("established"));
					
					list.add(tu);
					
					System.out.println();
				}
				return list;

			}
			catch (SQLException e) {
				
				System.out.println("Bad query");
				e.printStackTrace();
			} 
			
		}else if(table == 3) {
			
			read = "SELECT * FROM leaders";
			Leaders l = new Leaders();
			
			try {
				rs = stmt.executeQuery(read);
				while (rs.next()) {
					System.out.println("ID: " + rs.getInt("id"));
					l.setId(rs.getInt("id"));
					System.out.println("Leader Name: " + rs.getString("leaderName"));
					l.setLeaderName(rs.getString("leaderName"));
					System.out.println("Age: " + rs.getInt("age"));
					l.setAge(rs.getInt("age"));
					System.out.println("Years of Experience: " + rs.getInt("yearsOfExperience"));
					l.setYearsOfExperience(rs.getInt("yearsOfExperience"));
					System.out.println("Trade Union ID: " + rs.getInt("tradeUnionID"));
					l.setTradeUnionId(rs.getInt("tradeUnionID"));
					
					list.add(l);
					System.out.println();
				}
				return list;

			} catch (SQLException e) {
				System.out.println("Bad query");
				e.printStackTrace();
			}
			
		}
		
		
		return null;
		
	}
	
	public String update(int table, int id, String value, String feature) {
		String tableName = "";
		
		switch(table) {
		case 1:
			tableName = "strikes";
			break;
		case 2:
			tableName = "tradeUnions";
			break;
		case 3:
			tableName = "leaders";
			break;
		}
		
		String update = "UPDATE " + tableName + " SET " + feature + " = '" + value + "' WHERE id = " + id + ";";
		
		try {
			
			stmt.executeUpdate(update);
			System.out.println("Update statement executed");
			
		}catch (SQLException e) {
			try {
				rs = stmt.executeQuery("SELECT * FROM tradeUnions WHERE id = " + value + ";");
				
				if(!rs.next()) {
					
					System.out.println("No Trade Union with id " + value + ". Create Trade Union? (Enter y or n)");
					Scanner sc = new Scanner(System.in);
					if(sc.nextLine().equals("y")) {

						Choices c = new Choices();
						TradeUnions tu = new TradeUnions();
						int newInt = Integer.valueOf(value);

						c.createWithId(2, newInt, tu);
						update(table, id, value, feature);
					}
					else {
						System.out.println("Enter new id?");
						if(sc.nextLine().equals("y")) {
							System.out.println("Enter new id:");
							String newVal = sc.nextLine();
							
							update(table, id, newVal, feature);
						}
					}
					
				
				}
				
				
				
			} catch (SQLException e1) {
				System.out.println("Bad Query");
				e1.printStackTrace();
			}
			
		}
		
		return "Table: " + table + "ID: " + id + "Value: " + value;
	}
	
	public String delete(int id, int table) {
		String del = new String();
		
		switch(table){
		case 1:
			del = "DELETE FROM strikes WHERE id = " + id;
			break;
		case 2: 
			del = "DELETE FROM tradeUnions WHERE id = " + id;
			break;
		case 3:
			del = "DELETE FROM leaders WHERE id = " + id;
		}
		
		try {
			stmt.executeUpdate(del);
			System.out.println("Delete statement executed");
		} catch (SQLException e) {
			System.out.println("Bad query");
			e.printStackTrace();
		}
		
		return "Table: " + table + "ID: " + id;
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
