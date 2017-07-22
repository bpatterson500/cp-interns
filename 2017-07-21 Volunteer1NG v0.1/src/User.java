import java.util.ArrayList;

public class User {
	public static ArrayList<User> users = new ArrayList<User>();
	
	public String firstName, lastName, email, phone, address, city, state, country, profession="";
	public ArrayList<String> skills = new ArrayList<String>();
	public int coordsX, coordsY;
	
	public User(){
		
	}
	
	public String toString(){
		return (firstName + " " + lastName + ": Email: " + email + ", Phone #: " + phone + ", Address: " + address + ", City: "
				+ city + ", State: " + state + ", Country: " + country + ", Professions/Skills: " + profession + ", Longitude: "
				+ coordsX + ", Latitude; " + coordsY);
	}
	
	public void init(){
		String[] info = Main.info;
		info[0] = null;
		firstName = info[1];
		lastName = info[2];
		email = info[3];
		phone = info[4];
		address = info[5];
		city = info[6];
		state = info[7];
		country = info[8];
		profession = "";
	}
	
	
	public void loadProfessions(){
		for(int i=0; i< RenderPanel.buttons.size(); i++){
			if(RenderPanel.buttons.get(i).pressed){
				if(i==RenderPanel.buttons.size()-1)
					profession += RenderPanel.buttons.get(i).info + " ";
				else
					profession += RenderPanel.buttons.get(i).info + ", ";
			}
		}
	}
}
