package com.tap.servlets;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DaoImplementation.OrderHistoryImp;
import domain.Cartitem;
import domain.Order;
import domain.OrderHistory;
@WebServlet("/order")

public class Orderh extends HttpServlet {


@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//	  OrderHistoryImp oh = new OrderHistoryImp();
//
//	  
//	System.out.print("order");
//	 String totalPrice = req.getParameter("parameter");
//	// int parseInt = Integer.parseInt(totalPrice);
//	 System.out.println("1");
//	 int Price=0;
//	 Price = Integer.parseInt(totalPrice);
//		OrderHistory ohh=new OrderHistory(1, 37, 1, null, Price, "pending");
//		oh.save(ohh);
//		System.out.println("saved");
//	 
//System.out.println(totalPrice);
//    req.setAttribute("totalPrice", totalPrice);
//   
//
//    
//
//    
//    
//    
//	RequestDispatcher re = req.getRequestDispatcher("order.jsp");
//	re.forward(req, resp);
//}
	
	
	
	
	  OrderHistoryImp oh = new OrderHistoryImp();

      System.out.print("order");
      
      // Get the total price parameter from the request
      String totalPriceStr = req.getParameter("parameter");
      
      System.out.println("1");

      int price = 0;

      try {
          // Trim the input string to remove any leading or trailing whitespace
          totalPriceStr = totalPriceStr.trim();
          
          // Parse the string as a double and cast to int
          double totalPriceDouble = Double.parseDouble(totalPriceStr);
          price = (int) totalPriceDouble;
      } catch (NumberFormatException e) {
          System.out.println("Invalid total price: " + totalPriceStr);
          // Handle the error appropriately, e.g., set an error message or return an error response
          req.setAttribute("error", "Invalid total price");
          RequestDispatcher re = req.getRequestDispatcher("error.jsp");
          re.forward(req, resp);
          return;
      }
      Timestamp orderDate = new Timestamp(System.currentTimeMillis());
      // Create a new OrderHistory object
      OrderHistory ohh = new OrderHistory(2, 37, 1, orderDate, price, "pending");

      // Save the OrderHistory object
      oh.save(ohh);
      System.out.println("saved");

      // Print the total price for debugging purposes
      System.out.println(totalPriceStr);
Timestamp orderDate2 = ohh.getOrderDate();


int orderhistoryId = ohh.getOrderhistoryId();
int userId = ohh.getUserId();
int orderId = ohh.getOrderId();
String status = ohh.getStatus();
System.out.println(orderDate2);
      // Set the total price as a request attribute
      req.setAttribute("totalPrice", totalPriceStr);
req.setAttribute("orderDate2", orderDate2);
req.setAttribute("status", status);
req.setAttribute("oid", orderhistoryId);
req.setAttribute("uid", userId);
req.setAttribute("oid", orderId);
      // Forward the request to order.jsp
      RequestDispatcher re = req.getRequestDispatcher("order.jsp");
      re.forward(req, resp);
  }

@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
