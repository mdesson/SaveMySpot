import java.sql.Connection;
import java.sql.DriverManager;
import org.json.JSONArray;
import org.json.JSONObject;

class SqlQuery {
 
    private static final String url = "jdbc:mysql://localhost:3306/savemyspotConcordia";
 
    private static final String user = "";
 
    private static final String password = "";
 
    public static void main(String args[]) {
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Success");
            
 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}