package com.todd.jspmysql;

import java.io.IOException;
import java.sql.SQLException;

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
		
		Employee employee = new Employee();
		
		String message = "";
		String url = "";
		//Employee emp; //
		java.sql.ResultSet emp;
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String contact = request.getParameter("contact");
		
		if (firstName == "") {
			message = "You must enter a first name";				
			url = "/employeeregister.jsp";				
		}
		else if (lastName == "") {
			message = "You must enter a last name";				
			url = "/employeeregister.jsp";				
		}
		else if (username == "") {
			message = "You must enter a user name";				
			url = "/employeeregister.jsp";				
		}
		else if (password == "") {
			message = "You must enter a password";				
			url = "/employeeregister.jsp";				
		}
		else if (contact == "") {
			message = "You must enter a contact";				
			url = "/employeeregister.jsp";				
		}
		else
		{		
			employee.setFirstName(firstName);
			employee.setLastName(lastName);
			employee.setUsername(username);
			employee.setPassword(password);
			employee.setAddress(address);
			employee.setContact(contact);
		
			EmployeeDao employeeDao = new EmployeeDao();
			
			int status = 0;
	
			try {
				status = employeeDao.registerEmployee(employee);
			} 
			catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}				
			if (status > 0) 
			{
				System.out.println("You are successfully registered");
				message = "You have successfully registered!";	
				
				try 
				{
					
					emp = employeeDao.getEmployee();//(employee) /.getAllEmployee()
					//System.out.println("Servlet EMPloyee: " + emp.toString()); //first column in DB
					//System.out.println("Servlet EMPLOYEE: " + employee.toString()); //Last entry in DB
					//System.out.println("-----------");
					/*
					 * emp.getString("first_name"); emp.getString("last_name");
					 * emp.getString("username"); emp.getString("address");
					 * emp.getString("contact");
					 */
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
			else 
			{
				message = "You were NOT registered. Please try again.";
			}
						
			url = "/employeedetail.jsp";
			
		}
		request.setAttribute("firstName", firstName);
		request.setAttribute("lastName", lastName);
		request.setAttribute("username", username);
		request.setAttribute("address", address);
		request.setAttribute("contact", contact);
		
		request.setAttribute("firstName", firstName);
		request.setAttribute("message", message);
		
		getServletContext()
		.getRequestDispatcher(url)
		.forward(request, response);
	}

}
