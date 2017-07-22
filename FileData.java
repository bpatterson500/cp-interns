package volunteering;
import java.io.IOException;
import java.util.Scanner;

public class FileData {
public static void main(String []args) throws IOException{
	Scanner reader = new Scanner(System.in);
	String file_name = "C:\\Users\\123cr\\Documents\\VolunteerList.txt";
	try {
		ReadFile file = new ReadFile(file_name);
		String[] aryLines = file.OpenFile();
		int i;
		for(i=0; i < aryLines.length; i++) {
			System.out.println(aryLines[i]);
		}
	}
	catch(IOException e) {
		System.out.println("Unknown Error");
	}
	System.out.print("Enter First Name: ");
	String FName = reader.nextLine();
	System.out.print("Enter Last Name: ");
	String LName = reader.nextLine();
	System.out.print("Enter Profession/Skills: ");
	String Profession = reader.nextLine();
	System.out.print("Enter Home Longitude: ");
	int Long = reader.nextInt();
	System.out.print("Enter Home Latitude: ");
	int Lat = reader.nextInt();
	
	User volunteer = new User(FName, LName, Profession, Long, Lat);
	
	Texttransfer data = new Texttransfer(file_name, true);
	data.writeToFile(volunteer);
	System.out.println("Text File Written To");
	
	}
}
