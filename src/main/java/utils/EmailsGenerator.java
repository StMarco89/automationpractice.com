package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class EmailsGenerator {
	
	private static final String FILE_PATH = "Email.txt";
	private static final String MAIL_PATTERN = "mapko@yahoo.com:";
	
	public static String getNextEmail() {
		int index = 0;
		String mail = null;
		
		try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
			String line = br.readLine();
			
			// mapko@yahoo.com:500
			
			String[] mailArr = line.split(":");
			mail = mailArr[0];
			index = Integer.parseInt(mailArr[1]);
			
			int atIndex = mail.indexOf("@");
			mail = mail.substring(0, atIndex) + ++index + mail.substring(atIndex); // mapko501@yahoo.com
		} catch (IOException e) {
			// logger
		}
		
		try (PrintWriter writer = new PrintWriter(FILE_PATH, "UTF-8")) {
		    writer.println(MAIL_PATTERN + index);
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			// logger
		}
		
		return mail;
	}
	
	public static String getCurrentEmail() {
		
		int index = 0;
		String email = null;
		
		try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
			
			String line = br.readLine();
			String[] mailArr = line.split(":");
			email = mailArr[0];
			index = Integer.parseInt(mailArr[1]);
			int atIndex = email.indexOf("@");
			email = email.substring(0, atIndex) + index + email.substring(atIndex);
			
		} catch (IOException e) {
			// logger
		}
		
		return email;
	}
}
