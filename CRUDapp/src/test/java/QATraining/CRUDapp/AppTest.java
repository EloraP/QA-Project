package QATraining.CRUDapp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * Unit test for simple App.
 */


public class AppTest 
{
	
	private CRUDqueries q = new CRUDqueries();
    

    
    @Test
    public void checkViewStrikes() throws Exception{
    	boolean check = true;
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
    	
    	
    	
    	s2.setId(2);
    	s2.setDateOfStrike("2023-01-16 19:00:00");
    	s2.setLocation("Fort William, Scotland");
    	s2.setTradeUnionID(2);
    	s2.setWorkArea("Catering");
    	s2.setCapacity(1000);
    	
    	list.add(s2);
    	list.add(s1);
    	testList = q.view(1);
    	
    	Strike n = (Strike) list.get(0);
    	Strike t = (Strike) testList.get(0);
    	
    	check = checkStrikes(n, t);
    	
    	n = (Strike) list.get(1);
    	t = (Strike) testList.get(1);
    	
    	check = checkStrikes(n, t);
    	
	    
	    assertTrue(check);
    	

    }
    
    @Test
    public void checkViewLeaders() {
    	boolean check = true;
    	Leaders l1 = new Leaders();
    	Leaders l2 = new Leaders();
    	ArrayList<Object> list = new ArrayList<Object>();
    	ArrayList<Object> testList = new ArrayList<Object>();
    	
    	l1.setId(1);
    	l1.setLeaderName("Harry Gairn");
    	l1.setAge(22);
    	l1.setYearsOfExperience(10);
    	l1.setTradeUnionId(2);
    	
    	l2.setId(2);
    	l2.setLeaderName("Ben O'Connor");
    	l2.setAge(24);
    	l2.setYearsOfExperience(5);
    	l2.setTradeUnionId(3);
    	
    	list.add(l2);
    	list.add(l1);
    	
    	testList = q.view(3);
    	
    	Leaders n = (Leaders) list.get(0);
    	Leaders t = (Leaders) testList.get(0);
    	
    	check = checkLeaders(n, t);
    	
    	n = (Leaders) list.get(1);
    	t = (Leaders) testList.get(1);
	    
	    assertTrue(check);
    	
    	
    }
    
    
    @Test
    public void checkViewTradeUnions() {
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
    	
    	testList = q.view(2);
    	
    	TradeUnions n = (TradeUnions) list.get(0);
    	TradeUnions t = (TradeUnions) testList.get(0);
    	
    	check = checkTradeUnions(n, t);
    	

	    
	    assertTrue(check);
    }
    
    @Test
    public void checkCreatesStrike() {
    	Strike s = new Strike();
    	
    	s.setDateOfStrike("2023-01-01 13:00:00");
    	s.setLocation("Southwold, Suffolk");
    	s.setTradeUnionID(1);
    	s.setWorkArea("IT Sector");
    	s.setCapacity(400);
    		
    	boolean check = true;
    	Strike test;
    	
    	try {
           	test = (Strike) q.create("s", s);
           	
           	//check if the object is != null
            assertNotNull(test); 
            
            check = checkStrikes(s, test);

        } catch(Exception e){
            // let the test fail, if your function throws an Exception.
            fail("got Exception, i want an Expression");
         }
    	
    	q.deleteWhere("Southwold, Suffolk", "location", "Strikes");
    	
    	assertTrue(check);
    
    }
   
    @Test
    public void checkCreateTradeUnion() {
    	TradeUnions t = new TradeUnions();
    	
    	t.setFullName("New Trade Union");
    	t.setName("NTU");
    	t.setNumberOfMembers(10000);
    	t.setYear(2022);
    	
    	boolean check = true;
    	
    	try {
    		TradeUnions test = (TradeUnions) q.create("t", t);
           	
           	//check if the object is != null
            assertNotNull(test); 
            
            check = checkTradeUnions(t, test);
            
        } catch(Exception e){
            // let the test fail, if your function throws an Exception.
            fail("got Exception, i want an Expression");
         }
    	
    	q.deleteWhere("New Trade Union", "fullName", "TradeUnions");
    	
    	assertTrue(check);
    	
    	
    
    }
    
    @Test
    public void checkCreateLeaders() {
    	Leaders l = new Leaders();
    
    	l.setLeaderName("Michael Lynch");
    	l.setTradeUnionId(1);
    	l.setYearsOfExperience(25);
    	
    	boolean check = true;
    	
    	try {
    		Leaders test = (Leaders) q.create("l", l);
           	
           	//check if the object is != null
            assertNotNull(test); 
            
            check = checkLeaders(l, test);
            
        } catch(Exception e){
            // let the test fail, if your function throws an Exception.
            fail("got Exception, i want an Expression");
         }
    	
    	q.deleteWhere("Michael Lynch", "leaderName", "Leaders");
    	assertTrue(check);
    	
    
    	
    }
    
    
    @Test
    public void checkUpdate() {
    	
    	String test = q.update(1, 1, "2023-05-09 15:00:00", "dateOfStrike");
    	
    	String expected = "Table: 1ID: 1Value: 2023-05-09 15:00:00";
    	
    	q.update(1, 1, "2022-08-20 12:00:00", "dateOfStrike");
    	assertEquals(test, expected);
    
    }
    
    @Test
    public void checkDelete() {
    	String test = q.delete(1,  1);
    	String exp = "Table: 1ID: 1";
    	
    	Strike s = new Strike();
    	
    	s.setId(1);
    	s.setDateOfStrike("2022-08-20 12:00:00");
    	s.setLocation("Greenwich, London");
    	s.setTradeUnionID(2);
    	s.setWorkArea("Transport");
    	s.setCapacity(300);
    	
    	q.createWithID("s", s);
    	
    	assertEquals(test, exp);
    }

    public void badDelete() {
    	String test = q.delete(500,  500);
    	String exp = "bad query";
    	
    	assertEquals(test, exp);
    	
    }
    
    public void deleteWhere() {
    	
    }
    
    
    public boolean checkStrikes(Strike s, Strike test) {
    	boolean check = true;
    	
    	
    	if(!s.getDateOfStrike().equals(test.getDateOfStrike())) {
        	check = false;
        }else if(!s.getLocation().equals(test.getLocation())) {
        	check = false;
        }else if(s.getTradeUnionID() != test.getTradeUnionID()) {
        	check = false;
        }else if(!s.getWorkArea().equals(test.getWorkArea())) {
        	check = false;
        }else if(s.getCapacity() != test.getCapacity()) {
        	check = false;
        }
    	
    	return check;
    }
    
    public boolean checkTradeUnions(TradeUnions t, TradeUnions test) {
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
    
    public boolean checkLeaders(Leaders l, Leaders test) {
    	boolean check = true;
    	
    	if(!l.getLeaderName().equals(test.getLeaderName())) {
        	check = false;
        }else if(l.getAge() != test.getAge()) {
        	check = false;
        }else if(l.getYearsOfExperience() != test.getYearsOfExperience()) {
        	check = false;
        }else if(l.getTradeUnionId() != test.getTradeUnionId()) {
        	check = false;
        }
    	
    	return check;
    }

}
