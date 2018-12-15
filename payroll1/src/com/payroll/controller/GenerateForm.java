package com.payroll.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GenerateForm
 */
@WebServlet("/GenerateForm")
public class GenerateForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GenerateForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out=	response.getWriter();
		
		
		String names[]=request.getParameterValues("name");
		String q[]=request.getParameterValues("quatity");
		
		int arr[]=new int[q.length];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i]=Integer.parseInt(q[i]);
		}

		Map<String ,Integer> map=new HashMap<>();
		map.put("idly", 10);
		map.put("dosa", 20);
		map.put("bhajji", 30);
		map.put("puri", 40);
		
		
		out.println(names);
		int sum=0;
		
for (int i = 0; i < q.length; i++) {
	out.println(names[i]+"-->"+q[i]);
	out.println(map.get(names[i])*arr[i]);
	
	out.println("The order is ");
	out.println("Item name="+names[i]+" Price Item ="+map.get(names[i])+" Qantity= "+arr[i]);
	sum=sum+=map.get(names[i])*arr[i];
	
	
}
		
out.println("The total bill is"+ sum);



	
	response.setContentType("text/html");
	out.write("<form name='fone'>" +
			"<input type='text' name='uname' class='textbox' placeholder='Enter name' > <br>"+
			"<input type='password' name='pass' class='textbox' placeholder='Enter password' ><br> "+
			"<input type='submit' class='btn' name='submit' value='Fone'>"+
			"</form>" +
			"<br>"
		);
		
	
	
	
	
	}

}
