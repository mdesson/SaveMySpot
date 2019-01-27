import java.io.*;
import org.json.*;
import java.util.Scanner;

import java.io.FileReader; 
import java.util.Iterator; 
import java.util.Map; 

public class Driver {

	public static void main(String[] args) {
		Scanner inputStream = null;
		
		try {
			inputStream = new Scanner(new FileInputStream("../courses.json"));
			String text = (inputStream.nextLine());
			JSONArray json = new JSONArray(text);
			
			for (int i = 0; i < json.length(); i++) {
				  JSONObject obj = json.getJSONObject(i);
				  System.out.println(obj.get("subject"));
				  
				}
		}
		catch(FileNotFoundException e) {
			System.out.println("File not found!");
		}
		inputStream.close();
		
	}

}
