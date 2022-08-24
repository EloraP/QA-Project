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
    	
    	list.add(s1);
    	
    	s2.setId(2);
    	s2.setDateOfStrike("2023-01-16 19:00:00");
    	s2.setLocation("Fort William, Scotland");
    	s2.setTradeUnionID(2);
    	s2.setWorkArea("Catering");
    	s2.setCapacity(1000);
    	
    	list.add(s2);
    	testList = q.view(1);
    	
    	
   

    	
	    check = checkStrikes((Strike) list.get(0), (Strike) testList.get(0));
	    check = checkStrikes((Strike) list.get(1), (Strike) testList.get(1));
	    
	    assertTrue(check);
    	
    	
    	
    }
    
    @Test
    public void checkViewTradeUnions() {}
    
    @Test
    public void checkViewLeaders() {}
    
    
    @Test
    public void checkCreatesStrike() {
    	Strike s = new Strike();
    	s.setId(10);
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
    	
    	assertTrue(check);
    }
   
    @Test
    public void checkCreateTradeUnion() {
    	TradeUnions t = new TradeUnions();
    	t.setId(12);
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
    	
    	assertTrue(check);
    
    }
    
    @Test
    public void checkCreateLeaders() {
    	Leaders l = new Leaders();
    	l.setId(60);
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
    	
    	assertTrue(check);
    
    	
    }
    
    
    @Test
    public void checkUpdate() {
    	
    }
    
    @Test
    public void checkDelete() {}
    
    
    
    public boolean checkStrikes(Strike s, Strike test) {
    	boolean check = true;
    	
    	
    	if(s.getId() != test.getId()) {
        	check = false;
        }else if(!s.getDateOfStrike().equals(test.getDateOfStrike())) {
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
    	
    	if(t.getId() != test.getId()) {
        	check = false;
        }else if(!t.getFullName().equals(test.getClass())) {
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
    	
    	if(l.getId() != test.getId()) {
        	check = false;
        }else if(!l.getLeaderName().equals(test.getLeaderName())) {
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
