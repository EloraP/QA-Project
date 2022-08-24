package QATraining.CRUDapp;


import java.util.ArrayList;

public class Runner {
	
	
    public static void main( String[] args )
    {	
    	CRUDqueries q = new CRUDqueries();
    	
    	boolean check = true;
    	TradeUnions t1 = new TradeUnions();
    	TradeUnions t2 = new TradeUnions();
    	TradeUnions t3 = new TradeUnions();
    	ArrayList<Object> list = new ArrayList<Object>();
    	ArrayList<Object> testList = new ArrayList<Object>();
    	
    	
    	t1.setId(1);
    	t1.setFullName("National Union of Rail, Maritime and Transport Workers");
    	t1.setName("RMT");
    	t1.setNumberOfMembers(80000);
    	t1.setYear(1990);
    	
    	t2.setId(2);
    	t2.setFullName("Unite the Union");
    	t2.setName("Unite");
    	t2.setNumberOfMembers(1291017);
    	t2.setYear(2007);
    	
    
    	
    	t3.setId(3);
    	t3.setFullName("Communication Workers Union");
    	t3.setName("CWU");
    	t3.setNumberOfMembers(201900);
    	t3.setYear(1995);
    	
    	list.add(t3);
    	list.add(t2);
    	list.add(t1);
    	testList = q.view(2);
    	
    	TradeUnions n = (TradeUnions) list.get(0);
    	TradeUnions t = (TradeUnions) testList.get(0);
    	
    
    	System.out.println(t.getYear());
    	
    	System.out.println();
    	
    	check = checkTradeUnions(n, t);
    
    	
    	n = (TradeUnions) list.get(1);
    	t = (TradeUnions) testList.get(1);
    	
    
    	System.out.println(t.getYear());
    	
    	System.out.println();
    	
    	check = checkTradeUnions(n, t);
    	
    	n = (TradeUnions) list.get(2);
    	t = (TradeUnions) testList.get(2);
    	

    	System.out.println(t.getYear());
    	
    	System.out.println();
    	
    	check = checkTradeUnions(n, t);
    	
    	System.out.println(check);
    	
    	
    	Choices start = new Choices();
    	start.options();
    	
    }
    
    

    public static boolean checkTradeUnions(TradeUnions t, TradeUnions test) {
    	boolean check = true;
    	
    	if(!t.getFullName().equals(test.getFullName())) {
    		
        	check = false;
        }else if(!t.getName().equals(t.getName())) {
        	
        	check = false;
        }else if(t.getNumberOfMembers() != test.getNumberOfMembers()) {
        
        	check = false;
        }else if(t.getYear() != test.getYear()) {
        
        	check = false;
        }
    	
    	return check;
    }
    

  
    
   
    
    
    
}
