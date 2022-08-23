package QATraining.CRUDapp;

import java.util.Scanner;

public class Choices {
	
	private static Scanner sc = new Scanner(System.in);
	private CRUDqueries q = new CRUDqueries();
	
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
					
					create(choice);
				
					break;
				
				case "read":
					System.out.println("Select table to read from:");
					System.out.println("1. Strikes");
					System.out.println("2. Trade Unions");
					System.out.println("3. Leaders");
					int input = sc.nextInt();
					sc.nextLine();
					
					
					q.view(input);
					break;
				
				case "update":
					System.out.println("Enter table to update: ");
					System.out.println("1. Strikes");
					System.out.println("2. Trade Unions");
					System.out.println("3. Leaders");
					int table = sc.nextInt();
					
					System.out.println("Enter id of record to update: ");
					
					int uid = sc.nextInt();
					sc.nextLine();
					int featureID = 0;
					String feature = "", value = "";
					
					switch(table) {
					
					case 1:
						System.out.println("Enter feature to update:");
						System.out.println("1. Date");
						System.out.println("2. Location");
						System.out.println("3. Trade Union");
						System.out.println("4. Work Area");
						System.out.println("5. Capacity");
						
						featureID = sc.nextInt();
						sc.nextLine();
						switch(featureID) {
						case 1: 
							feature = "date";
							break;
						case 2:
							feature = "location";
							break;
						case 3:
							feature = "tradeUnionID";
							break;
						case 4: 
							feature = "workArea";
							break;
						case 5: 
							feature = "capacity";
							break;
						}
						
						
						System.out.println("Enter the new value: ");
						value = sc.nextLine();
						break;
					case 2:
						System.out.println("Enter feature to update:");
						System.out.println("1. Full Name");
						System.out.println("2. Abreviated Name");
						System.out.println("3. Number of Members");
						System.out.println("4. Year Established");
						System.out.println("5. Capacity");
						
						featureID = sc.nextInt();
						sc.nextLine();
						sc.nextLine();
						switch(featureID) {
						case 1: 
							feature = "fullName";
							break;
						case 2:
							feature = "TUName";
							break;
						case 3:
							feature = "numbersOfMembers";
							break;
						case 4: 
							feature = "established";
							break;
						}
						
						System.out.println("Enter the new value:");
						value = sc.nextLine();
						
						break;
					case 3:
						System.out.println("Enter feature to update:");
						System.out.println("1. Leader's Name");
						System.out.println("2. Age");
						System.out.println("3. Years of Experience");
						System.out.println("4. Trade Union ID");
						
						featureID = sc.nextInt();
						sc.nextLine();
						switch(featureID) {
						case 1: 
							feature = "leaderName";
							break;
						case 2:
							feature = "age";
							break;
						case 3:
							feature = "yearsOfExperience";
							break;
						case 4: 
							feature = "tradeUnionID";
							break;
						}
						System.out.println(feature);
						System.out.println("Enter the new value:");
						value = sc.nextLine();
						break;
					}
//					System.out.println(table);
//					System.out.println(uid);
//					System.out.println(value);
					System.out.println(feature);
					
					q.update(table, uid, value,  feature);
					
					break;
					
				case "delete":
					System.out.println("Enter table to delete from: ");
					System.out.println("1. Strikes");
					System.out.println("2. Trade Unions");
					System.out.println("3. Leaders");
					table = sc.nextInt();
					sc.nextLine();
					System.out.println("Enter id of record to delete: ");
					int id = sc.nextInt();
					sc.nextLine();
					
					q.delete(id, table);
					break;
					
				default: 
					System.out.println("Invalid CRUD choice");
				}
				
				System.out.println("Would you like to continue? (y/n)");				
				crud = endConn(sc.nextLine());
			} while (!crud.equals("quit"));
			
			System.out.println("Goodbye!");
		} 
		
		finally {
			q.close();
		}
		
		
	}
	
	public String endConn(String input){
		
		if (input.toLowerCase().equals("y")) {
			System.out.println("Enter CRUD choice:");
			return sc.nextLine();
		} else if (input.toLowerCase().equals("n")) {
			return "quit";
		} else {
			System.out.println("Please enter 'y' or 'n'");
			return endConn(sc.nextLine());
		}
	}
	
	public Object create(int choice) {
		
		switch(choice) {
		
		case 1:
			Strike strike = new Strike();
			
			System.out.println("Enter Date and Time: (YYYY-MM-DD HH:MM:SS)");
			String strInput = sc.nextLine();
			strike.setDateOfStrike(strInput);
			
			System.out.println("Enter Location: ");
			strInput= sc.nextLine();
			strike.setLocation(strInput);

			System.out.println("Enter Trade Union ID: ");
			System.out.println("(Enter view to view Trade Unions)");
			strInput = sc.nextLine();
			int intInput;
			if(strInput.equals("view")) {
				q.view(2);
				intInput = sc.nextInt();
				sc.nextLine();
				strike.setTradeUnionID(intInput);
			}else{
				intInput = Integer.valueOf(strInput);
			}
			
			strike.setTradeUnionID(intInput);
			
			System.out.println("Enter Work Area: ");
			strInput = sc.nextLine();
			strike.setWorkArea(strInput);
			
			System.out.println("Enter Capacity:");
			intInput = sc.nextInt();
			sc.nextLine();
			strike.setCapacity(intInput);
			
			q.create("s", strike);

			return strike;
			
		case 2: 
			TradeUnions tradeUnion = new TradeUnions();
			
			System.out.println("Enter Full Name:");
			strInput = sc.nextLine();
			tradeUnion.setFullName(strInput);
			
			System.out.println("Enter Abreviated Name:");
			strInput = sc.nextLine();
			tradeUnion.setName(strInput);
		
			System.out.println("Enter Number of Members:");
			intInput = sc.nextInt();
			sc.nextLine();
			tradeUnion.setNumberOfMembers(intInput);
			
			
			System.out.println("Enter Year Established:");
			intInput = sc.nextInt();
			sc.nextLine();
			tradeUnion.setYear(intInput);
			
			q.create("t", tradeUnion);
			
			return tradeUnion;
			
		case 3: 
			Leaders leader = new Leaders();
			
			System.out.println("Enter Leader Name: ");
			strInput = sc.nextLine();
			leader.setLeaderName(strInput);
			
			System.out.println("Enter Leader Age: ");
			intInput = sc.nextInt();
			sc.nextLine();
			leader.setAge(intInput);
			
			System.out.println("Enter Leader's Year of Experience: ");
			intInput = sc.nextInt();
			sc.nextLine();
			leader.setYearsOfExperience(intInput);
			
			System.out.println("Enter Trade Union ID: ");
			System.out.println("(Enter view to view Trade Unions)");
			strInput = sc.nextLine();
			if(strInput.equals("view")) {
				q.view(2);
				intInput = sc.nextInt();
				sc.nextLine();
				leader.setTradeUnionId(intInput);
			}else{
				intInput = Integer.valueOf(intInput);
				leader.setTradeUnionId(intInput);
				
			}
			
			q.create("l", leader);
			return leader;
		
		}
		
		System.out.println("Invalid Choice");
		return null;
		
	}
	
public Object createWithId(int choice, int nid, Object o) {
	//Scanner sc = new Scanner(System.in);
	
	System.out.println("here");
		
		switch(choice) {
		
		case 1:
			Strike strike = ((Strike)o);
			strike.setId(nid);
			
			System.out.println("Enter Date and Time: (YYYY-MM-DD HH:MM:SS)");
			String strInput = sc.nextLine();
			strike.setDateOfStrike(strInput);
			
			System.out.println("Enter Location: ");
			strInput= sc.nextLine();
			strike.setLocation(strInput);
			


			System.out.println("Enter Trade Union ID: ");
			System.out.println("(Enter view to view Trade Unions)");
			strInput = sc.nextLine();
			int intInput;
			if(strInput.equals("view")) {
				q.view(2);
				intInput = sc.nextInt();
				sc.nextLine();
				strike.setTradeUnionID(intInput);
			}else{
				intInput = Integer.valueOf(strInput);
			}
			
			strike.setTradeUnionID(intInput);
			
			System.out.println("Enter Work Area: ");
			strInput = sc.nextLine();
			strike.setWorkArea(strInput);
			
			System.out.println("Enter Capacity:");
			intInput = sc.nextInt();
			sc.nextLine();
			strike.setCapacity(intInput);
			
			
			q.createWithID("s", strike);

			return strike;
			
		case 2: 
			TradeUnions tradeUnion = ((TradeUnions)o);
			tradeUnion.setId(nid);
			
			System.out.println("Enter Full Name:");
			strInput = sc.nextLine();
			tradeUnion.setFullName(strInput);
			
			System.out.println("Enter Abreviated Name:");
			strInput = sc.nextLine();
			tradeUnion.setName(strInput);
		
			System.out.println("Enter Number of Members:");
			intInput = sc.nextInt();
			sc.nextLine();
			tradeUnion.setNumberOfMembers(intInput);
			
			
			System.out.println("Enter Year Established:");
			intInput = sc.nextInt();
			sc.nextLine();
			tradeUnion.setYear(intInput);
			
			q.createWithID("t", tradeUnion);
			
			return tradeUnion;
			
		case 3: 
			
			Leaders leader = ((Leaders)o);
			leader.setId(nid);
			
			System.out.println("Enter Leader Name: ");
			strInput = sc.nextLine();
			leader.setLeaderName(strInput);
			
			System.out.println("Enter Leader Age: ");
			intInput = sc.nextInt();
			sc.nextLine();
			leader.setAge(intInput);
			
			System.out.println("Enter Leader's Year of Experience: ");
			intInput = sc.nextInt();
			sc.nextLine();
			leader.setYearsOfExperience(intInput);
			
			System.out.println("Enter Trade Union ID: ");
			System.out.println("(Enter view to view Trade Unions)");
			strInput = sc.nextLine();
			if(strInput.equals("view")) {
				q.view(2);
				intInput = sc.nextInt();
				sc.nextLine();
				leader.setTradeUnionId(intInput);
			}else{
				intInput = Integer.valueOf(intInput);
				leader.setTradeUnionId(intInput);
				
			}
			
			
			
			q.createWithID("l", leader);
			return leader;
		
		}
		
		System.out.println("Invalid Choice");
		return null;
		
	}
		
}


