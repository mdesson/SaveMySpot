import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage;
public class EmailSender {

	// Main Program
	
    public static void main(String args[]){
        
    	//Test Array
    	String[] inputs = {"COMP232", "1", "0", "seanheinrichs@gmail.com"};
    	
    	sendMail(inputs);
    		
    }
    
    // This method checks to see if there is any room on the wait list, if so, return true, otherwise false
    public static boolean checkWaitList(String[] inputs){
    	if (inputs[1].equals("0")){
    		return false;
    	}
    	else
    		return true;
    }
    
    public static void sendMail(String[] inputs){
    	
    	//Extract pertinent information from the Array
    	String courseCode = inputs[0];
    	String waitList = inputs[1];
    	String userEmail = inputs[3];
    	
    	// Returns true if there is room on the wait list
    	boolean roomOnWaitList = checkWaitList(inputs);
    	
    	try{
            String host ="smtp.gmail.com" ;
            String user = "savemyspotconcordia@gmail.com";
            String pass = "conuhacks2019";
            String to = userEmail;
            String from = "savemyspotconcordia@gmail.com";
            String waitListSubject = "[" + courseCode  + "] There is room on the waitlist! Head over to myConcorida to register right away!";
            String roomInClassSubject = "[" + courseCode  + "] There is room in your course! Head over to myConcordia to register right away!";
            String messageTextWaitList = courseCode + " has room has at least 1 spot open on the wait list! Head over to myConcordia to sign "
            		+ "up right away before it gets filled. Thanks for using Save My Spot!";
            String messageTextInClass = courseCode + " has room has at least 1 spot available in the course! Head over to myConcordia to sign "
            		+ "up right away before it gets filled. Thanks for using Save My Spot!";
            boolean sessionDebug = false;

            Properties props = System.getProperties();

            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.required", "true");

            Session mailSession = Session.getDefaultInstance(props, null);
            mailSession.setDebug(sessionDebug);
            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            if (roomOnWaitList){
            	msg.setSubject(waitListSubject); msg.setSentDate(new Date());
            	msg.setText(messageTextWaitList);
            }
            else {
            	msg.setSubject(roomInClassSubject); msg.setSentDate(new Date());
            	msg.setText(messageTextInClass);
            }
            
            

           Transport transport=mailSession.getTransport("smtp");
           transport.connect(host, user, pass);
           transport.sendMessage(msg, msg.getAllRecipients());
           transport.close();
           System.out.println("message send successfully");
        }catch(Exception ex)
        {
            System.out.println(ex);
        }

    }
}
