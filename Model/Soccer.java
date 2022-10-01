package Model;
public class Soccer {
	private String uuid;
	private String name;
	private String nationality; 
	private int yellowCard = 0;
	private int redCard = 0;
	private int points =  0;
	
	//Getters e Setters
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getNationality() {
		return nationality;
	}
	
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public int getRedCard() {
		return redCard;
	}
	
	public void setRedCard(int redCard) {
		this.redCard = redCard;
	}
	
	public int getYellowCard() {
		return yellowCard;
	}
	
	public void setYellowCard(int yellowCard) {
		this.yellowCard = yellowCard;
	}
	
	public int getPoints() {
		return points;
	}
	
	public void setPoints(int points) {
		this.points = points;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}	
	
	

}