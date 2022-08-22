package QATraining.CRUDapp;

import java.util.Scanner;

public class Choices {
	
	private static Scanner sc = new Scanner(System.in);
	
	public String getInput() {
		System.out.println("Enter CRUD choice: ");
		return sc.nextLine();
	}
	
	
	public void options() {
		
		CRUDqueries q = new CRUDqueries();
		
		String crud = getInput();
		
		try {
			do {
				switch(crud.toLowerCase()){
				
				case "create":
					
					System.out.println("Select table to add to:");
					System.out.println("1. Strikes");
					System.out.println("2. Trade Unions");
					System.out.println("3. Leaders");
					
					int choice = sc.nextInt();
					sc.nextLine();
					
					switch(choice) {
					
					case 1:
						Strike strike = new Strike();
						
						System.out.println("Enter Date and Time: (YYYY-MM-DD HH:MM:SS)");
						String strInput = sc.nextLine();
						strike.setDateOfStrike(strInput);
						
						System.out.println("Enter Location: ");
						strInput= sc.nextLine();
						strike.setLocation(strInput);
						
						System.out.println("Enter Leader ID: ");
						int intInput = sc.nextInt();
						sc.nextLine();	
						strike.setLeaderID(intInput);
	
						System.out.println("Enter Trade Union ID: ");
						intInput = sc.nextInt();
						sc.nextLine();
						strike.setTradeUnionID(intInput);
						
						System.out.println("Enter Work Area: ");
						strInput = sc.nextLine();
						strike.setWorkArea(strInput);
						
						System.out.println("Enter Capacity:");
						intInput = sc.nextInt();
						sc.nextLine();
						strike.setCapacity(intInput);
						
						String tableVal = "strikes(dateOfStrike, location, leaderID, tradeUnion, workArea, capacity)";
						
						q.create(tableVal, strike);
			
						break;
						
					case 2: 
						TradeUnions tradeUnion = new TradeUnions();
						
						System.out.println("Enter Full Name:/n");
						String name = sc.nextLine();
						tradeUnion.setFullName(name);
						
						System.out.println("Enter Abreviated Name:/n");
					
						System.out.println("Enter Number of Members:/n");
						
						System.out.println("Enter Year Established:/n");
						
						
						
						
						
						
					}
				
				case "read":
					System.out.println("Select table to add to");
					System.out.println("1. Strikes");
					System.out.println("2. Trade Unions");
					System.out.println("3. Leaders");
					int input = sc.nextInt();
					sc.nextLine();
					
					
					q.view(input);
					break;
				
				case "update":
					System.out.println("Enter id of record to update: ");
					
					int uid = sc.nextInt();
					sc.nextLine();
					
					System.out.println("Entre feature to update: (date, location, leader, tradeUnion, workArea, capacity)");
					String feature = sc.nextLine();
					
					System.out.println("Enter the new " + feature + " of the strike: ");
					String value = sc.nextLine();
					
					q.update(uid, value,  feature);
					
					break;
					
				case "delete":
					System.out.println("Enter id of record to delete: ");
					int id = sc.nextInt();
					sc.nextLine();
					
					q.delete(id);
					break;
					
				default: 
					System.out.println("Invalid CRUD choice");
				}
				
				System.out.println("Would you like to continue? (y/n)");
				String quit = sc.nextLine();
				if (quit.toLowerCase().equals("y")) {
					crud = getInput();
				} else if (quit.toLowerCase().equals("n")) {
					crud = "quit";
				} else {
					System.out.println("Please enter 'y' or 'n'");
				}
			} while (!crud.equals("quit"));
			
			System.out.println("Goodbye!");
		} 
		
		finally {
			q.close();
		}
	}
		
}


