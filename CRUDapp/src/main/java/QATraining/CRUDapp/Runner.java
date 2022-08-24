package QATraining.CRUDapp;

import java.util.ArrayList;

public class Runner {
	
	
    public static void main( String[] args )
    {
    	CRUDqueries q = new CRUDqueries();
    	
      	Strike s1 = new Strike();
    	Strike s2 = new Strike();
    	ArrayList<Object> list = new ArrayList<Object>();
    	ArrayList<Object> testList = new ArrayList<Object>();
    	
    	s1.setId(1);
    	s1.setDateOfStrike("2022-08-20 12:00:00");
    	s1.setLocation("Greenwich, London");
    	s1.setTradeUnionID(2);
    	s1.setWorkArea("Transport");
    	s1.setCapacity(300);
    	
    	list.add(s1);
    	
    	s2.setId(2);
    	s2.setDateOfStrike("2023-01-16 19:00:00");
    	s2.setLocation("Fort William, Scotland");
    	s2.setTradeUnionID(2);
    	s2.setWorkArea("Catering");
    	s2.setCapacity(1000);
    	
    	list.add(s2);
    	testList = q.view(1);
    	
    	Strike n = (Strike) list.get(0);
    	Strike t = (Strike) testList.get(0);
    	System.out.println(list.get(0));
    	System.out.println(testList.get(0));
    	
//    	Choices start = new Choices();
//        start.options();
    	
    }
    
    
    
    
}
