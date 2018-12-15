package com.payroll.model;

import com.payroll.exceptions.PayrollException;

public class LoginDetailsValidate {

	public LoginDetailsValidate() {
		// TODO Auto-generated constructor stub
	}
public 	boolean validateLoginDetails(LoginDetails details) throws PayrollException{
		boolean flag=false;
		
		if(details.getUsername() == "" || details.getPassword()== "")
		{
			throw new PayrollException("Username and password should be filled");
		}else{
			
			return true;
		}
		/*String regex="[0-9]{4}";
		String regex2="[0-9]{4}[a-z]{4}";

		//var regex2=/^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})/


		

		if(details.getUsername().matches(regex) && details.getPassword().matches(regex2)){
			//System.out.println("If from validte class"+flag);
			//System.out.println(details);
			flag=true;
		}else{
			//System.out.println("else from validte class"+flag);
			throw new PayrollException("User name 4-digits and password is 4-digits 4-chars");
				
		}*/
	
		
	}

}
