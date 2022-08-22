package QATraining.CRUDapp;

public class Strike {
	
	private String dateOfStrike;
	private String location;
	private int leaderID;
	private String tradeUnion;
	private String workArea;
	private int capacity;
	
	public String getDateOfStrike() {
		return dateOfStrike;
	}
	
	public void setDateOfStrike(String dateOfStrike) {
		this.dateOfStrike = dateOfStrike;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public int getLeader() {
		return leaderID;
	}
	public void setLeaderID(int leaderID) {
		this.leaderID = leaderID;
	}
	
	public String getTradeUnion() {
		return tradeUnion;
	}
	
	public void setTradeUnion(String tradeUnion) {
		this.tradeUnion = tradeUnion;
	}
	
	public String getWorkArea() {
		return workArea;
	}
	
	public void setWorkArea(String workArea) {
		this.workArea = workArea;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

}
