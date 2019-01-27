import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage;
public class EmailSender {


    // This method checks to see if there is any room on the wait list, if so, return true, otherwise false
    public static boolean checkWaitList(String wait){
    	if (wait.equals("0")){
    		return false;
    	}
    	else
    		return true;
    }
    
    public static void sendMail(String code, String wait, String email){
    	
    	//Extract pertinent information from the Array
    	String courseCode = code;
    	String waitList = wait;
    	String userEmail = email;
    	
    	// Returns true if there is room on the wait list
    	boolean roomOnWaitList = checkWaitList(wait);
    	
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
