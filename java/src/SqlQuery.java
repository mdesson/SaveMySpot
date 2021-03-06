import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

class SqlQuery {
	
	// Database parameters
    private static final String url = "jdbc:mysql://localhost:3306/savemyspotConcordia";
    private static final String user = "root";
    private static final String password = "";
    
    // Database queries
    private static String query = "SELECT Email, Course_Catalog, Course_Code, Waitlist FROM StudentCourseList WHERE Email_sent='0'";
//    private static String querySize = "SELECT COUNT(*) FROM StudentCourseList WHERE Email_sent='0'";
//    private static String update = "UPDATE `StudentCourseList` SET `Email_sent`='1' WHERE Email = ";
    
//    public static void updateEmailed(String emailAddress, String course) {
//    	String[] courseData = course.split(" ");
//    	
//    	try {
//        	// Connect to database and create Statement
//            Connection con = DriverManager.getConnection(url, user, password);
//            System.out.println("Successfully connected to database");
//            Statement stmt = stmt = con.createStatement();
//            
//            // Get number of results for loop index
//            ResultSet update = stmt.executeQuery(query + emailAddress + " AND " + " Course_Catalog = " + courseData[0]  + " AND " + " Course_Code = " + courseData[1]);
//
//            // Get results of query
//            ResultSet result = stmt.executeQuery(query);
//
//            
//                        
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
// 
//    }
//    
//    
    // Query database for email addresses and course names
    
    
    public static String[][] queryDatabase() {
        String[][] output = {{"error"}};

    	try {
        	// Connect to database and create Statement
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Successfully connected to database");
            Statement stmt = stmt = con.createStatement();
            
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
        
        return output;
    }
}