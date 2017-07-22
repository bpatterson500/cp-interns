package volunteering;

import java.util.ArrayList;

public class User {
	public static ArrayList<User> users = new ArrayList<User>();
	
	public String firstName, lastName, profession;
	public int coordsX, coordsY;
	
	public User(String firstName, String lastName, String profession, int coordsX, int coordsY){
		this.firstName = firstName;
		this.lastName = lastName;
		this.profession = profession;
		this.coordsX = coordsX;
		this.coordsY = coordsY;
	}
	
	public String toString(){
		return (firstName + " " + lastName + ": " + profession + ", Longitude: " + coordsX + ", Latitude: " + coordsY);
	}
}
