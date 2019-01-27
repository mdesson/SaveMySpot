import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class Driver {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/savemyspotConcordia";
	    String user = "root";
	    String password = "";    
	    String query = "SELECT Email, Course_Catalog, Course_Code, Waitlist FROM StudentCourseList WHERE Email_sent='0'";
	    String[][] output = {{"error"}};
	    try {
        	// Connect to database and create Statement
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Successfully connected to database");
            Statement stmt = con.createStatement();
            
            // Get number of results for loop index
            ResultSet resultSize = stmt.executeQuery(query);
            resultSize.last();
            
            // Initialize array to get results
            output = new String[resultSize.getRow()][3];
            
            // Get results of query
            ResultSet result = stmt.executeQuery(query);
            
            // Create array 
            for (int i=0; i<output.length; i++) {
            	result.next();
            	output[i][0] = result.getString("Email");
            	output[i][1] = result.getString("Course_Catalog") + " " + result.getString("Course_Code");
            	output[i][2] = result.getString("Waitlist");
            }
                        
        } catch (Exception e) {
            e.printStackTrace();
        }
 
	    for (int i=0; i<output.length; i++) {
	    	String[] emailerData = Query.emailerData(output[i][1]);
	    	System.out.println(emailerData[0]);
	    	System.out.println(emailerData[1]);
	    	System.out.println(emailerData[2]);

	    	if (emailerData[1] == "1" || emailerData[2] == "1") {
	    		EmailSender.sendMail(output[i][1], emailerData[1], output[i][0]);
	    	}
	    	else System.out.println("Course full, waitlist full");
	    }
	}
}