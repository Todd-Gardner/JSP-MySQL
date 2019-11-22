package com.todd.jspmysql;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/employeeServlet")

public class employeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String firstName = (request.getParameter("firstName"));
		Employee employee = new Employee();
		
		employee.setFirstName(request.getParameter("firstName"));
		employee.setLastName(request.getParameter("lastName"));
		employee.setUsername(request.getParameter("username"));
		employee.setPassword(request.getParameter("password"));
		employee.setAddress(request.getParameter("address"));
		employee.setContact(request.getParameter("contact"));
	
		EmployeeDao employeeDao = new EmployeeDao();
		String message;
		int status = 0;

		try {
			status = employeeDao.registerEmployee(employee);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		if (status > 0) {
			System.out.println("You are successfully registered");
			message = "You have successfully registered!";

		}else {
			message = "You were NOT registered. Please try again.";
		}
		
		request.setAttribute("firstName", firstName);
		request.setAttribute("message", message);
		
		String url = "/employeedetail.jsp";
		getServletContext()
		.getRequestDispatcher(url)
		.forward(request, response);
	}

}
