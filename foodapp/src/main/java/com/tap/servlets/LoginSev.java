package com.tap.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DaoImplementation.UserImp;
import domain.Users;

@WebServlet("/log")

public class LoginSev extends HttpServlet {



	private String password;
	private int userId;




	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String uname=req.getParameter("username");
	String pass=req.getParameter("password");
	
System.out.println(uname);
	
UserImp u1 = new UserImp();

Users u = new Users(uname, pass);
String encryptedUsername = encryptString(uname);
String encryptedPassword = encryptString(pass);
u.setUsername(encryptedUsername);
u.setPassword(encryptedPassword);
System.out.println(encryptedUsername);
System.out.println(encryptedPassword);
//Users users = u1.getUsers(encryptedUsername, encryptedPassword);
//int userId2 = users.getUserId();
//System.out.println(userId2);
Users user = u1.getUser(39);
String password2 = user.getPassword();
String username = user.getUsername();
if(password2.equals(encryptedPassword) && username.equals(encryptedUsername))
{
	req.setAttribute("user", u);
	 Cookie c = new Cookie("userId", Integer.toString(user.getUserId())); 
  resp.addCookie(c);
	 RequestDispatcher d1 = req.getRequestDispatcher("/home");
	d1.forward(req, resp);
}
else
{
	 RequestDispatcher d1 = req.getRequestDispatcher("login.html");
 d1.forward(req, resp);
}




}



	

//
//	 Users user = u1.getUser(37);
////	String name = user.getUsername();
//	String password = user.getPassword();
////	user.setUsername(name);
//	user.setPassword(password);
//	System.out.println(password);

	
//		Users u = new Users(uname, pass);
//		String encryptedUsername = encryptString(uname);
//     String encryptedPassword = encryptString(pass);
//     u.setUsername(encryptedUsername);
//     u.setPassword(encryptedPassword);
//     System.out.println(encryptedUsername);
//     System.out.println(encryptedPassword);
//    
//     RequestDispatcher d = req.getRequestDispatcher("login.html");
//	d.forward(req, resp);
//	
//	if(user!=u)
//	 {
//		
//		 req.setAttribute("user", u);
//		 RequestDispatcher d1 = req.getRequestDispatcher("login.html");
//		 d1.forward(req, resp);
//	 }
//	 
//	 else
//	 {
//		 req.setAttribute("user", u);
//		 Cookie c = new Cookie("userId", Integer.toString(u.getUserId())); 
//         resp.addCookie(c); 
//		 RequestDispatcher d1 = req.getRequestDispatcher("/home");
//		 d1.forward(req, resp);
//	 }
//	
//	}
//     
//	

private String encryptString(String str) {
    StringBuilder encryptedStr = new StringBuilder();
    for (char c : str.toCharArray()) {
        // Add 1 to the Unicode value of each character
        char encryptedChar = (char) (c + 1);
        encryptedStr.append(encryptedChar);
    }
    return encryptedStr.toString();
}
		
	}
//	private String encryptString(String str) {
//         StringBuilder encryptedStr = new StringBuilder();
//         for (char c : str.toCharArray()) {
//             // Add 1 to the Unicode value of each character
//             char encryptedChar = (char) (c + 1);
//             encryptedStr.append(encryptedChar);
//         }
//         return encryptedStr.toString();
//     }
//	
	
	
	
	
