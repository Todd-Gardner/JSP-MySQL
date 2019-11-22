package com.todd.jspmysql;

import java.io.Serializable;

/**
 * JavaBean class used in jsp action tags.
 * @author Todd Gardner
 */
public class Employee implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String address;
    private String contact;
    
    public Employee() { //needed?
		setFirstName("");
		setLastName("");
		setUsername("");
		setPassword("");
		setAddress("");
		setContact("");
    }
    
    public Employee (String first_name, String last_name, String username, String password, String address, String contact) {
		setFirstName(first_name);
		setLastName(last_name);
		setUsername(username);
		setPassword(password);
		setAddress(address);
		setContact(contact);
    }
    
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

	public String getContact() {
        return contact;
    }
    public void setContact(String contact) {
        this.contact = contact;
    }
    @Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", username=" + username + ", password="
				+ password + ", address=" + address + ", contact=" + contact + "]";
	}
}