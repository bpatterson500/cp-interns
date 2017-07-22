import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class Main implements KeyListener{
	//SETTINGS
	public static int screenX = 1800;
	public static int screenY = 1000;
	
	//SYSTEM VARIABLES DO NOT TOUCH
	public static JFrame frame;
	public static RenderPanel panel;//, panel2;
	public static Main main;
	public static User ourUser = new User();
	public static String[] info = new String[12];
	public static boolean[] professions = {false, false, false, false, false, false};
	public static boolean writtenToFile = false;
	
	/*
	 * States:
	 * 	1 - first name
	 *  2 - last name
	 *  3 - email
	 *  4 - phone
	 *  5 - address
	 *  6 - city
	 *  7 - state/province
	 *  8 - country
	 *  9 - skills
	 * 
	 */
	public static int state = 1;
	
	//MAIN
	public static void main(String[] args) throws IOException{
		Scanner reader = new Scanner(System.in);
		main = new Main();
		file_name = "C:\\Users\\Anh Ngo\\Desktop\\VolunteerDB.txt";
		
		//create JFrame
		frame = new JFrame("Volunteer1NG");
		frame.setSize(screenX, screenY);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);	
		
		//create JPanel
		panel = new RenderPanel();

		
		frame.add(panel);
		frame.addKeyListener(main);
		frame.addMouseListener(new MouseCoordListener());
		frame.repaint();
		
		panel.initButtons();
		
	}
	public static String file_name;
	public static void write() throws IOException{
		try {
			ReadFile file = new ReadFile(file_name);
			String[] aryLines = file.OpenFile();
			int i;
			for(i=0; i < aryLines.length; i++){
				System.out.println(aryLines[0]);
			}
		} catch(IOException e) {
			System.out.println("Unknown Error");
		}
		Texttransfer data = new Texttransfer(file_name, true);
		data.writeToFile(ourUser);
		System.out.println("Database updated");
		System.out.println(ourUser);
		
		writtenToFile = true;
	}
	
	
	
	
	//KEY EVENT STUFF DONT TOUCH
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER){
			if(state!=9)
				info[state] = RenderPanel.curInput;
			//RenderPanel.input = RenderPanel.curInput;
			RenderPanel.curInput = "";
			state++;
		}else if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE){
			RenderPanel.curInput = RenderPanel.curInput.substring(0, RenderPanel.curInput.length() - 1);
		}else{
			if(e.getKeyCode() == KeyEvent.VK_COMMA){
				RenderPanel.curInput += "@";
			}else{
				RenderPanel.curInput += (char)e.getKeyCode();
			}
		}
		panel.repaint();
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
