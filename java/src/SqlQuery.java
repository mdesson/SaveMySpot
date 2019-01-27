import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

class SqlQuery {

    private static final String url = "jdbc:mysql://localhost:3306/savemyspotConcordia";
    private static final String user = "root";
    private static final String password = "";
    
    private static String query = "SELECT Email, Course_Catalog, Course_Code FROM StudentCourseList WHERE Waitlist='1'";
    private static String querySize = "SELECT COUNT(*) FROM StudentCourseList WHERE Waitlist='1'";
    
    public static String[][] queryDatabase() {
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Successfully connected to database");
            
            Statement stmt = stmt = con.createStatement();
            
            // Get number of results
            ResultSet resultSize = stmt.executeQuery(query);
            resultSize.last();
            
            // Initialize array to get results
            String[][] output = new String[resultSize.getRow()][2];
            
            ResultSet result = stmt.executeQuery(query);
            
            for (int i=0; i<output.length; i++) {
            	result.next();
            	output[i][0] = result.getString("Email");
            	output[i][1] = result.getString("Course_Catalog") + " " + result.getString("Course_Code");
            	
                return output;
            }
                        
        } catch (Exception e) {
            e.printStackTrace();
            String[][] output = {{"Error"}};
        }
        
        return new String[][] {{"Error"}};
        
    }
}