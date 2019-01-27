import java.io.*;
import org.json.*;
import java.util.Scanner;


public class Query {

	public static String[] emailerData(String code) throws JSONException {
		Scanner inputStream = null;
		String[] courseArray = code.split(" ");
		
		try {
			inputStream = new Scanner(new FileInputStream("../courses.json"));
			String text = (inputStream.nextLine());
			inputStream.close();
			
			JSONArray json = new JSONArray(text);
			String[] output = new String[3];
			
			for (int i=0; i < json.length(); i++) {
				  JSONObject obj = json.getJSONObject(i);
				  if (courseArray[0] == obj.getString("subject") && courseArray[1] == obj.getString("catalog")) {
					  int WaitCap = Integer.parseInt(obj.getString("waitlistCapacity"));
					  int WaitCurrent = Integer.parseInt(obj.getString("currentWaitlistTotal"));
					  int EnrolCap = Integer.parseInt(obj.getString("enrollmentCapacity"));
					  int EnrolCurrent = Integer.parseInt(obj.getString("currentEnrollment"));					  
					  
					  output[0] = obj.getString("subject") + " " + obj.getString("catalog");
					  output[1] = ((WaitCap - WaitCurrent) > 0) ? "1" : "0";
					  output[2] = ((EnrolCap - EnrolCurrent) > 0) ? "1" : "0";
					  return output;
				  }
				} 
		}
		catch(FileNotFoundException e) {
			System.out.println("File not found!");
		}
		
		catch(JSONException e) {
			System.out.println("JSON Exception");
		}
		return new String[] {"Error"};
		
	}

}
