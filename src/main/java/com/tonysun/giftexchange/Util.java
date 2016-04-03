package com.tonysun.giftexchange;

import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.tonysun.giftexchange.Person;

public class Util {
	
	public static String filename;
	public static String user;
	public static String pwd;
	
	public static int generateRandomNumber(int max){
		Random rn = new Random();
		return rn.nextInt(max);
	}
	
	public static void sendEmail(Person p1, Person p2){

		String to = p2.getEmail();
		String from = user.contains("@")?user:user+"@gmail.com";
		
		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.host", "smtp.gmail.com");
		properties.setProperty("mail.smtp.port", "587");
		properties.setProperty("mail.smtp.auth", "true");
		properties.setProperty("mail.smtp.starttls.enable", "true");
		Session session = Session.getDefaultInstance(properties,  new javax.mail.Authenticator(){  
			    protected PasswordAuthentication getPasswordAuthentication() {  
			    	return new PasswordAuthentication(user, pwd);  
			    }
		});  
		
		try{
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("where is your gift");
			
			//set the actual message
			StringBuilder content = new StringBuilder();
			content.append("Dear "+p1.getFirstName()+",<p/>");
			content.append("Your gift will be sent to "+p2.getFirstName()+" "+p2.getLastName()+". Thanks for participanting!<p/><p/><p/>");
			content.append("Event Organizer");
			message.setContent(content.toString(), "text/html");
			
			//send message
			Transport.send(message);
		}catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}
}
