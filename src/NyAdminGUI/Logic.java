package NyAdminGUI;

import java.util.Calendar;
import java.sql.*;

import jdk.nashorn.internal.runtime.ECMAException;
import databaseMethods.SwitchMethods;

public class Logic {
	
	private static String pswd = "admin123";
	static boolean adminSignedIn = false;
	
	public static boolean authenticateAdmin(String password){
		
		if (password.equals(pswd)){ 
			return true;
		}else{
			return false;
		}
		
	}
	
	public static boolean createUser(String username, String password, String passwordRepeat){
	
		if(password.equals(passwordRepeat)){
		
		SwitchMethods SW = new SwitchMethods();
		try{
		if(SW.createuser(username, password))
		{
			errorMessage userCreated = new errorMessage("The user " + username + " has been created succesfully");
			userCreated.setVisible(true);
			return true;
			
		}
		
		}catch (Exception e){
			e.printStackTrace();
			return false;
		}
		return false;
		}else{
			errorMessage passwordnotmatch = new errorMessage("The two passwords does not match!");
			return false;
		}
	}

	public static void removeEvent(String removeEventID){
		
		//Event should be removed here
		
	}
	

	public static boolean changeAdminPassword(String currentPassword, String newPassword,
			String passwordRepeat) {
		
		if(newPassword.equals(passwordRepeat)){
		
			if(currentPassword.equals(pswd)){
			pswd = newPassword;
			errorMessage passwordchanged = new errorMessage("The administrator password is changed successfully!");
			passwordchanged.setVisible(true);
			return true;
			}else{
			errorMessage wrongpassword = new errorMessage("The existing password does not match");	
			wrongpassword.setVisible(true);
			return false;	
			}
		}else{
			errorMessage passwordnotmatch = new errorMessage("Make sure that the passwords match!");
			passwordnotmatch.setVisible(true);
			return false;
			}

	}
	
	public static void removeUser(String username){
		//Method for removing user goes here <==
	}
	
	 
	
}