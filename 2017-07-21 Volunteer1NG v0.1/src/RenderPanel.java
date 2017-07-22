import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JPanel;

public class RenderPanel extends JPanel{

	//COLORS
	public static Color textColor = Color.WHITE;
	public static Color buttonUnpressed = Color.decode("#303F9F");
	public static Color buttonPressed = Color.decode("#00BCD4");
	public static Color headerColor = Color.decode("#303F9F");
	public static Color bodyColor = Color.decode("#3F51B5");
	
	//system variables
	public static ArrayList<Button> buttons; 
	public static String curInput = "";
	public static String input = "";
	
	public static String prompt = "";
	
	public static void enter(Graphics g){
		
	}
	
	private String[] separate (String s){
		String[] re = new String[2];
		for(int k=0; k<s.length(); k++){
			if(s.charAt(k)==' '){
				re[0] = s.substring(0, k+1);
				re[1] = s.substring(k);
				break;
			}
		}
		return re;
	}
	
	//paints everything
	public void paintComponent(Graphics g){
		//paints background
		g.setColor(headerColor);
		g.fillRect(0, 0, Main.screenX, (int)Main.screenY/4);
		//body color
		g.setColor(bodyColor);
		g.fillRect(0, (int)Main.screenY/4, Main.screenX, Main.screenY);
		g.setColor(textColor);
		g.setFont(new Font("Century Gothic", Font.PLAIN, 80));
		g.drawString("Welcome to Volunteer1NG", 350, 200);
		
		
//		//replace # with @
//		for(int i = 0; i < curInput.length() - 1; i++){
//			if(curInput.substring(i,  i+1).equals("#")){
//				curInput = curInput.substring(0,i) + "@" + curInput.substring(i+1);
//			}
//		}
		
		switch(Main.state){
			case(1): prompt = "First Name";
			break;
			case(2): prompt = "Last Name";
			break;
			case(3): prompt = "Email";
			break;
			case(4): prompt = "Phone";
			break;
			case(5): prompt = "Street Address";
			break;
			case(6): prompt = "City";
			break;
			case(7): prompt = "State/Province";
			break;
			case(8): prompt = "Country";
			break;
			case(9): prompt = "Skills";
			break;
			case(10): prompt = "Info Recorded";
				Main.ourUser.init();
				Main.ourUser.loadProfessions();

			break;
			
		}
		
		//if on the final screen
		if(Main.state >= 10){
			g.setColor(textColor);
			User user = Main.ourUser;
			g.drawString("Name: " + user.firstName + " " + user.lastName, 100, 500);
			g.drawString("Email: " + user.email, 100, 600);
			g.drawString("Phone Number: " + user.phone, 100, 700);
			g.drawString("Address: ", 100, 800);
			g.setFont(new Font("Century Gothic", Font.PLAIN, 60));
			g.drawString(user.address + ", " + user.city + ", " + user.state + " (" + user.country + ")", 450, 800);
			g.setFont(new Font("Century Gothic", Font.PLAIN, 80));
			g.drawString("Skills: ", 100, 900);
			g.setFont(new Font("Century Gothic", Font.PLAIN, 50));
			g.drawString(user.profession, 300, 900);
			
			

		}
		g.setFont(new Font("Century Gothic", Font.PLAIN, 80));
		
		//variables for buttons
		String str="", firstStr="", secondStr="";
		int strLen=0;
		boolean isLong = false;
		//if on the "skills" screen
//		if(Main.state == 9){
		if (prompt == "Skills") {
			
			for(Button b: buttons){
				str = b.info;
				strLen = str.length();
				if(strLen>13){isLong=true;}
				if(!b.pressed){
					g.setColor(b.color);
				}else{
					g.setColor(b.colorPressed);
				}
				g.fillRect((int)b.getX(), (int)b.getY(), (int)b.getWidth(), (int)b.getHeight());
				g.setColor(textColor);
				g.setFont(new Font("Century Gothic", Font.PLAIN, 50));
				if(isLong){
					String[] result = separate(str);
					firstStr = result[0];
					secondStr = result[1];
					if(firstStr.equals("Computer ")||firstStr.equals("Mental ")){
						if(firstStr.equals("Computer ")){
							g.setFont(new Font("Century Gothic", Font.PLAIN, 30));
							g.drawString("Computer Networking", (int)b.getX(), (int)b.getY()+(int)b.getHeight()/2-15);
							g.drawString("Systems Administration", (int)b.getX(), (int)b.getY()+(int)b.getHeight()-15);
							isLong=false;
						}
						else{
							g.setFont(new Font("Century Gothic", Font.PLAIN, 40));
							g.drawString("Mental Health", (int)b.getX(), (int)b.getY()+(int)b.getHeight()/2-15);
							g.drawString("Professional", (int)b.getX(), (int)b.getY()+(int)b.getHeight()-15);
							isLong=false;
						}
					}
					else if(firstStr!=null&&secondStr!=null){
						g.drawString(firstStr, (int)b.getX(), (int)b.getY()+(int)b.getHeight()/2-15);
						g.drawString(secondStr, (int)b.getX()-10, (int)b.getY()+(int)b.getHeight()-15);
						isLong=false;
					}
					else{g.drawString(b.info, (int)b.getX(), (int)b.getY()+(int)b.getHeight()/2+15);isLong=false;}
				}
				else
					g.drawString(b.info, (int)b.getX(), (int)b.getY()+(int)b.getHeight()/2+15);
			}
		}
		
		g.setColor(Color.WHITE);
		g.setFont(new Font("Century Gothic", Font.PLAIN, 80));
		//prints out text in center of screen
		g.drawString(prompt, (int)(Main.screenX / 2) - prompt.length() * 20, 400);
		g.drawString(curInput, (int)(Main.screenX / 2) - curInput.length() * 25, 600);
		
		if(Main.state >= 10 ){
			try {
				if(!Main.writtenToFile){
					Main.write();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void initButtons(){
		
		buttons = new ArrayList<Button>();
		buttons.add(new Button(100, 450, 300, 150, "Medical"));
		buttons.add(new Button(500, 450, 300, 150, "Computer Networking / Systems Administration"));
		buttons.add(new Button(900, 450, 300, 150, "Construction"));
		buttons.add(new Button(1300, 450, 300, 150, "Food Services"));
		buttons.add(new Button(100, 725, 300, 150, "First Responder"));
		buttons.add(new Button(500, 725, 300, 150, "Legal Services"));
		buttons.add(new Button(900, 725, 300, 150, "Mental Health Professional"));
		buttons.add(new Button(1300, 725, 300, 150, "Pilot"));
		
	}
}

//create buttons
//map colors
