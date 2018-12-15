package com.payroll.app;

import com.payroll.exceptions.PayrollException;
import com.payroll.model.LoginDetails;
import com.payroll.model.LoginDetailsValidate;

public class Main2 {

	public Main2() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		
		
		LoginDetails details=new LoginDetails("", "");
		LoginDetailsValidate validate=new LoginDetailsValidate();
  try {
	validate.validateLoginDetails(details);
} catch (PayrollException e) {
	// TODO Auto-generated catch block
	System.out.println(e.getMessage());
}		
		
  
  

	}

}
