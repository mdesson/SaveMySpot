import java.io.*;
import org.json.*;
import java.util.Scanner;

import java.io.FileReader; 
import java.util.Iterator; 
import java.util.Map; 

// "enrollmentCapacity": "30", "currentEnrollment": "24", "waitlistCapacity": "0", "currentWaitlistTotal": "0",
// [subject + " " + catalog, boolean(waitlist), boolean(full)]
public class Query {

	public static void main(String[] args) {
		Scanner inputStream = null;
		
		try {
			inputStream = new Scanner(new FileInputStream("../courses.json"));
			String text = (inputStream.nextLine());
			JSONArray json = new JSONArray(text);
			String[][] output = new String[json.length()][3];
			
			for (int i=0; i < json.length(); i++) {
				  JSONObject obj = json.getJSONObject(i);

				  int WaitCap = Integer.parseInt(obj.getString("waitlistCapacity"));
				  int WaitCurrent = Integer.parseInt(obj.getString("currentWaitlistTotal"));
				  int EnrolCap = Integer.parseInt(obj.getString("enrollmentCapacity"));
				  int EnrolCurrent = Integer.parseInt(obj.getString("currentEnrollment"));

				  output[i][0] = obj.getString("subject");
				  output[i][1] = ((WaitCap - WaitCurrent) > 0) ? "1" : "0";
				  output[i][2] = ((EnrolCap - EnrolCurrent) > 0) ? "1" : "0";
				}
		}
		catch(FileNotFoundException e) {
			System.out.println("File not found!");
		}
		inputStream.close();
		
	}

}
