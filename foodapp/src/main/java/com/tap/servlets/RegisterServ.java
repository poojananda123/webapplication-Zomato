package com.tap.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DaoImplementation.UserImp;
import domain.Users;

@WebServlet("/serv")
public class RegisterServ extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String uname = req.getParameter("username");
		String email = req.getParameter("email");
		String address = req.getParameter("address");
		Long phone =Long.parseLong(req.getParameter("phone"));
		String password = req.getParameter("password");

		
		UserImp u1 = new UserImp();
		Users u = new Users(name,uname, password, email, address, "Customer", phone);
		String encryptedUsername = encryptString(u.getUsername());
        String encryptedPassword = encryptString(u.getPassword());
        u.setUsername(encryptedUsername);
        u.setPassword(encryptedPassword);
        System.out.println(encryptedUsername);
        System.out.println(encryptedPassword);
        u1.save(u);
        RequestDispatcher d = req.getRequestDispatcher("login.html");
	d.forward(req, resp);
        
	}

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
		  
//		u1.save(u);
//		RequestDispatcher d = req.getRequestDispatcher("login.html");
//		d.forward(req, resp);


