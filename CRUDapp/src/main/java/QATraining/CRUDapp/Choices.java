package QATraining.CRUDapp;

import java.util.Scanner;

public class Choices {
	
	private static Scanner sc = new Scanner(System.in);
	
	public String getInput() {
		System.out.println("Enter CRUD choice: ");
		return sc.nextLine();
	}
	
	
	public void options() {
		
		String crud = getInput();
		
		try {
			do {
				switch(crud.toLowerCase()){
				
				case "create":
					
					Strike strike = new Strike();
					
					System.out.println("Enter Date and Time: (YYYY-MM-DD HH:MM:SS)");
					String date = sc.nextLine();
					strike.setDateOfStrike(date);
					
					System.out.println("Enter Location: ");
					String location = sc.nextLine();
					strike.setLocation(location);
					
					System.out.println("Enter Leader: ");
					String leader = sc.nextLine();
					strike.setLeader(leader);

					System.out.println("Enter Trade Union: ");
					String tradeUnion = sc.nextLine();
					strike.setTradeUnion(tradeUnion);
					
					System.out.println("Enter Work Area: ");
					String workArea = sc.nextLine();
					strike.setWorkArea(workArea);
					
					System.out.println("Enter Capacity:");
					int capacity = sc.nextInt();
					sc.nextLine();
					strike.setCapacity(capacity);
					
					System.out.println(strike.getDateOfStrike());
					System.out.println(strike.getCapacity());
					System.out.println(strike.getLeader());
					System.out.println(strike.getLocation());
					System.out.println(strike.getTradeUnion());
					System.out.println(strike.getWorkArea());
					
					break;
				
				case "read":
					System.out.println("read file");
					break;
				
				case "update":
					System.out.println("Enter id of record to update: ");
					
					int uid = sc.nextInt();
					sc.nextLine();
					
					System.out.println("Entre feature to update: (date, location, leader, tradeUnion, workArea, capacity)");
					String feature = sc.nextLine();
					
					System.out.println("Enter the new " + feature + " of the strike: ");
					String value = sc.nextLine();
					
					System.out.println(feature);
					System.out.println(value);
					
					break;
					
				case "delete":
					System.out.println("delete file");
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
			System.out.println("end connection");
		}
	}
		
}


