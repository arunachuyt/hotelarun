/**
 * 
 */
package com.payroll.model;

/**
 * @author t-Ahmed1
 *
 */
public class LoginDetails implements Comparable<LoginDetails> {

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoginDetails other = (LoginDetails) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	private String username;
	private String password;

	@Override
	public String toString() {
		return "LoginDetails [username=" + username + ", password=" + password + "]";
	}

	public LoginDetails(String username, String password) {
		super();
		this.username = username;
		this.password = password;
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

	/**
	 * 
	 */
	public LoginDetails() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compareTo(LoginDetails o) {
		// TODO Auto-generated method stub
	int flag=	this.getUsername().compareTo(o.getUsername());
		return flag;
	}
	
	

}
