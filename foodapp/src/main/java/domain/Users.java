package domain;

import java.util.Date;

public class Users {
	private int userId;
	private String name;
	private String username;
	private String password;
	private String email;
	private String address;
	private String role;
	private Date createdDate;
	private Date loginDate;
	private Long phone;
	
	public Users() {
		// TODO Auto-generated constructor stub
	}
	public Users(String username,String password)
	{
		this.username=username;
		this.password=password;
	}
	
	public Users( String name,String username, String password, String email, String address, String role, Long phone) {
		super();
		this.name=name;
		this.username = username;
		this.password = password;
		this.email = email;
		this.address = address;
		this.role = role;
		this.phone = phone;
	}


	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public Users(Long phone) {
		super();
		this.phone = phone;
	}

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getLoginDate() {
		return loginDate;
	}
	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}
	public Users(int userId, String name, String username, String password, String email, String address, String role,
			Date createdDate, Date loginDate,Long phone) {
		super();
		this.userId = userId;
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;
		this.address = address;
		this.role = role;
		this.createdDate = createdDate;
		this.loginDate = loginDate;
		this.phone=phone;
	}


	public Users(String uname, int password2) {
		// TODO Auto-generated constructor stub
		super();
		this.username = username;
		this.password = password;
	}
	public Users(int userId) {
		super();
		this.userId = userId;	
	}
		
	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", username=" + username + ", password=" + password
				+ ", email=" + email + ", address=" + address + ", role=" + role + ", createdDate=" + createdDate
				+ ", loginDate=" + loginDate + ", phone=" + phone + "]";
	}

	}

	


