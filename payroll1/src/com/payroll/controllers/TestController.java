package com.payroll.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.servlet.ModelAndView;

import com.payroll.exceptions.PayrollException;
import com.payroll.model.Address;
import com.payroll.model.Department;
import com.payroll.model.Employee;
import com.payroll.model.LoginDetails;
import com.payroll.model.Skills;
import com.payroll.services.AddressService;
import com.payroll.services.DepartmentService;
import com.payroll.services.EmployeeService;
import com.payroll.services.LoginService;
import com.payroll.services.SkillService;


@ComponentScan({"com.payroll"})
@SessionAttributes("loginDetails")
@Controller
public class TestController {

	public TestController() {
		// TODO Auto-generated constructor stub
	}

	private EmployeeService employeeService;
	private DepartmentService departmentService;
	private SkillService skillService;
    private LoginService loginService;
    
    
    @Autowired
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

    @Autowired
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

    @Autowired
	public void setSkillService(SkillService skillService) {
		this.skillService = skillService;
	}

    @Autowired
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	@GetMapping("/home")
	public String home(HttpServletRequest request){
		System.out.println("Home");
		request.getSession(true).invalidate();
		
		String path="login";
		System.out.println();
		if(request.getSession().getAttribute("loginDetails")==null){
			
		}else{
			path="success";
		}
		
		
		
		
		return path;
		
	}
	
	//UpdateServlet
	@PostMapping("/update")
	public ModelAndView updateEmp(ModelAndView modelAndView,Employee employee,String [] skills){
		
		//String path="success";
	try {
		String message=	employeeService.updateWholeEmp(employee, skills);
		modelAndView.setViewName("success");
		modelAndView.addObject("list",employeeService.fetchAllData(null));
		modelAndView.addObject("message", message);
		
	
	
	} catch (PayrollException e) {
		// TODO Auto-generated catch block
		
		modelAndView.setViewName("error");
		modelAndView.addObject("error", e.getMessage());
	
	}
	return modelAndView;
		
	}
	
	
	//GetEmpServlet?empId=..
	// which displays showemp.jsp
	@GetMapping("/getemp")
	public ModelAndView getEmp(@RequestParam int empId,ModelAndView modelAndView){

		String path="error";
		
	try {
		Employee employee=	employeeService.fetchEmployeeById(empId);
		modelAndView.setViewName("showemp");
		modelAndView.addObject("employee", employee);
	     modelAndView.addObject("deptList", departmentService.fetchAllDepartments());
	     modelAndView.addObject("skillList", skillService.fetchAllSkills());
		
		
	} catch (PayrollException e) {
		// TODO Auto-generated catch block
		modelAndView.setViewName(path);
		modelAndView.addObject("error", e.getMessage());
		
		e.printStackTrace();
	
	
	}
		
		
	//modelAndView.setViewName("showemp");
	return modelAndView;
	
		
	}
	
	//LoginServlet

	@PostMapping("/LoginController")
	public ModelAndView login( LoginDetails loginDetails){
		
		System.out.println(loginDetails);
		System.out.println(loginService);
		
		String view="success";
		ModelAndView mav=null;
		
		try {
		boolean ch=	loginService.loginCheck(loginDetails);
		
		if(ch){
			 mav=new ModelAndView(view);
			
			mav.addObject("list",  employeeService.fetchAllData(null));
			 
			 
		}else{
			view="login";
			 mav=new ModelAndView(view);
			 mav.addObject("error", "username password is wrong");
		}
		
		} catch (PayrollException e) {
			// TODO Auto-generated catch block
			view="login";
			 mav=new ModelAndView(view);
			mav.addObject("error", e.getMessage());
			 e.printStackTrace();
		}
		
		return mav;
		
		
		
	}
	
	// to calll registration.jsp
	@GetMapping("/register")
	
	public String register(@ModelAttribute Employee employee){
		System.out.println(employee);
		return "registration";
	}
	
	//RegistrationServlet
	@PostMapping("/reg")
	public ModelAndView reg(ModelAndView modelAndView, Employee employee , String[] skills){

		
		String message="";
		try {
		 message=	employeeService.saveWholeEmp(employee, skills);
			modelAndView.setViewName("success");
			modelAndView.addObject("message", message);
			
		} catch (PayrollException e) {
			// TODO Auto-generated catch block
			modelAndView.setViewName("registration");
			modelAndView.addObject("error", e.getMessage());
			
			e.printStackTrace();
			
		}
		return modelAndView;
		
		
		
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request){
		request.getSession(true).invalidate();
		
		return "login";
		
	}
	
	@GetMapping("/success")
	public String success(){
		
		return "success";
	}
	
	
	

}
