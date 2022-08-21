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
					System.out.println("create file");
					break;
				
				case "read":
					System.out.println("read file");
					break;
				
				case "update":
					System.out.println("update file");
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


