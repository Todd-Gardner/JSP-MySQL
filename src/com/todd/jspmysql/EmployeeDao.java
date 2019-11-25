package com.todd.jspmysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.todd.jspmysql.Employee;

public class EmployeeDao {
	
	public ResultSet getEmployee() throws ClassNotFoundException { //int /Employee employee
		ResultSet rs = null;
		//Employee emp = new Employee();
		
		String GET_USERS_SQL = "SELECT first_name, last_name, username, address, contact FROM employee;";
		
		Class.forName("com.mysql.jdbc.Driver");
		
        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/mysql_database?useSSL=false", "root", "6114tts!");
        		//PreparedStatement preparedStatement = connection.prepareStatement(GET_USERS_SQL)) 
        		Statement statement = connection.createStatement()){
        	
        	rs = statement.executeQuery(GET_USERS_SQL);
        	
			
			  while (rs.next()) { 
				  rs.getString("first_name"); 
				  rs.getString("last_name"); 
				  rs.getString("username");
				  rs.getString("address");
				  rs.getString("contact");
			  }
			  System.out.println(rs);
				  
			/*
			 * // Employee employee = new Employee(rs.getString("first_name"),
			 * rs.getString("last_name"), rs.getString("username"), rs.getString("address"),
			 * rs.getString("contact")); }
			 */
        	
        	//ResultSet rs = preparedStatement.executeQuery();
        	
    		/*
    		 * for (Employee emp : EmployeeDao.getAllEmployee()) {
    		 * System.out.println("Employee: [Id : "
    		 * +emp.getId()+", Name : "+emp.getName()+" ]");
    		 */
        	
			/*
			 * if (rs.next()) { Employee employee = new Employee(rs.getString("first_name"),
			 * rs.getString("last_name"), rs.getString("username"), rs.getString("address"),
			 * rs.getString("contact"));
			 * 
			 * emp.setFirstName(rs.getString("first_name"));
			 * emp.setLastName(rs.getString("last_name"));
			 * emp.setUsername(rs.getString("username"));
			 * emp.setAddress(rs.getString("address"));
			 * emp.setContact(rs.getString("contact"));
			 * 
			 * 
			 * System.out.println("Prepared statement: " + statement);
			 * System.out.println("Result set: " + rs); System.out.println("EMPloyee: " +
			 * emp.toString()); System.out.println("EMPLOYEE: " + employee); return rs; }
			 * else { System.out.println("Failed to make connection!"); }
			 */
	        
	    } catch (SQLException e) {
	        System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
                 		
		return rs;
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


	/*
	 * public Object getAllEmployee() throws ClassNotFoundException { Employee emp =
	 * new Employee();
	 * 
	 * String GET_USERS_SQL = "SELECT" + " VALUES (?, ?, ?, ?, ?)" +
	 * "(first_name, last_name, username, address, contact)" + "FROM employee;";
	 * 
	 * //int result = 0;
	 * 
	 * Class.forName("com.mysql.jdbc.Driver");
	 * 
	 * try (Connection connection = DriverManager
	 * .getConnection("jdbc:mysql://localhost:3306/mysql_database?useSSL=false",
	 * "root", "6114tts!"); PreparedStatement preparedStatement =
	 * connection.prepareStatement(GET_USERS_SQL)) {
	 * 
	 * ResultSet rs = preparedStatement.executeQuery(); if (rs.next()) {
	 * emp.setFirstName(rs.getString("first_name"));
	 * emp.setLastName(rs.getString("last_name"));
	 * emp.setUsername(rs.getString("username"));
	 * emp.setAddress(rs.getString("address"));
	 * emp.setContact(rs.getString("contact"));
	 * 
	 * 
	 * System.out.println("Prepared statement: " + preparedStatement);
	 * System.out.println("Result set: " + rs);
	 * //System.out.println("Employee list: " + employeeList); } else {
	 * System.out.println("Failed to make connection!"); }
	 * 
	 * } catch (SQLException e) { System.err.format("SQL State: %s\n%s",
	 * e.getSQLState(), e.getMessage()); } catch (Exception e) {
	 * e.printStackTrace(); } return null; }
	 */
}