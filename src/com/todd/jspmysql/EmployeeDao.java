package com.todd.jspmysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.todd.jspmysql.Employee;

public class EmployeeDao {
	
	private Employee employee;

	public Employee getEmployee() throws ClassNotFoundException { //int /Employee employee
		//ResultSet rs = null;
		
		String GET_USERS_SQL = "SELECT first_name, last_name, username, address, contact FROM employee;";
		
		Class.forName("com.mysql.jdbc.Driver");
		
        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/mysql_database?useSSL=false", "root", "6114tts!");
        		//PreparedStatement preparedStatement = connection.prepareStatement(GET_USERS_SQL)) 
        		Statement statement = connection.createStatement()){
        	
        	ResultSet rs = statement.executeQuery(GET_USERS_SQL);
        	
    		/*
    		 * for (Employee emp : EmployeeDao.getAllEmployee()) {
    		 * System.out.println("Employee: [Id : "
    		 * +emp.getId()+", Name : "+emp.getName()+" ]");
    		 */
        			
			  while (rs.next()) {// Employee employee = new Employee(rs.getString("first_name"),
			  //rs.getString("last_name"), rs.getString("username"), rs.getString("address"),
			 // rs.getString("contact"));
			  employee = new Employee();
			  employee.setFirstName(rs.getString("first_name"));
			  employee.setLastName(rs.getString("last_name"));
			  employee.setUsername(rs.getString("username"));
			  employee.setAddress(rs.getString("address"));
			  employee.setContact(rs.getString("contact"));
			  
			  List <Employee> employeeList = new ArrayList<Employee>();
			  employeeList.add(employee);
			  for (Employee result : employeeList) {
				  System.out.println("Result list: " + result); //same as EMPLOYEE
			  }
			  			   
			  System.out.println("EMPLOYEE: " + employee); //same as result list
			  System.out.println("EMPLOYEE LIST: " + employeeList); an array of arrays
			  //return rs; 
			  //return employee; employeeList;
			  }
			  //else { System.out.println("Failed to make connection!"); }
			 
	        
	    } catch (SQLException e) {
	        System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
                 		
		return employee;
	} 

    public int registerEmployee(Employee employee) throws ClassNotFoundException {
    	
        String INSERT_USERS_SQL = "INSERT INTO employee" +
            "  (first_name, last_name, username, password, address, contact) VALUES " +
            " (?, ?, ?, ?,?,?);";
        
        int result = 0;

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/mysql_database?useSSL=false", "root", "6114tts!");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            //preparedStatement.setInt(1, 1); //sets id to 1
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setString(3, employee.getUsername());
            preparedStatement.setString(4, employee.getPassword());
            preparedStatement.setString(5, employee.getAddress());
            preparedStatement.setString(6, employee.getContact());

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return result;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

}