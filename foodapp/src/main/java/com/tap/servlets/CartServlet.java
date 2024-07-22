package com.tap.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest;

import DaoImplementation.CartImp;
import DaoImplementation.MenuImp1;
import DaoImplementation.RestaurantImp;
import DaoInterface.MenuDao;
import domain.Cartitem;
import domain.Menu;
import domain.Restaurant;


@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	/**
//	 * 
//	 */
	private static final long serialVersionUID = 3700394551585395116L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("cart");
	
	String itemname = req.getParameter("itemname");
	String priceParam = req.getParameter("price");
	String restaurantId = req.getParameter("restaurantId");
	String menuId = req.getParameter("menuId");
	MenuImp1 imp1=new MenuImp1();
	Menu menu =new Menu();
	Restaurant restaurant=new Restaurant();
	List<Cartitem> carItemList=new ArrayList<Cartitem>();
//	double totalPrice = 0.0;
//	if (carItemList != null) {
//	    for (Cartitem item : carItemList) {
//	        totalPrice += item.getPrice() * item.getQuantity();
//	    }
//	}
	RestaurantImp imp=new RestaurantImp();
	restaurant=imp.getRestaurant(Integer.parseInt(restaurantId));
	menu=imp1.getMenuById(Integer.parseInt(menuId) );
	CartImp cartImp=new CartImp();
	if(cartImp.getCartItemByMenuId(menu.getMenuId()) == null) {
	Cartitem cartitem=new Cartitem(0,menu.getItemname(),1,menu.getPrice(),37,
		
			menu.getMenuId(), restaurant.getRestaurantId(),restaurant.getName());
	//double totalPrice = 0.0;
    
			
	cartImp.saveCartItem(cartitem);
	}else {
		Cartitem cartitem= cartImp.getCartItemByMenuId(menu.getMenuId());	
		cartitem.setQuantity(cartitem.getQuantity()+1);
	    System.out.println("&&&&&&&&&&&"+cartitem.toString());
		cartImp.updateCartItem(cartitem);
	
	}
//	menuList.add(menu);
	int price = 0; // Default value if parameter is null
	if (priceParam != null && !priceParam.isEmpty()) {
	    price = Integer.parseInt(priceParam);
	}
	int r = Integer.parseInt(req.getParameter("restaurantId"));
	
	
System.out.println(itemname );

carItemList= cartImp.getCartItemsByUserId(37);
req.setAttribute("itemname", itemname);
req.setAttribute("price",price );
req.setAttribute("carItemList",carItemList);
System.out.println("***********"+carItemList.toString());
req.setAttribute("restaurantId", restaurantId);
System.out.println(price);
double totalPrice = 0.0;
if (carItemList != null) {
    for (Cartitem item : carItemList) {
        totalPrice += item.getPrice() * item.getQuantity();
    }
}
req.setAttribute("totalPrice", totalPrice);
RequestDispatcher d = req.getRequestDispatcher("Cart.jsp");
d.forward(req, resp);
	
}
//	  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	        // Get cart items from session
//	        HttpSession session = request.getSession(false); // Get existing session (don't create new)
//	        if (session != null) {
//	            List<Cartitem> cartItems = (List<Cartitem>) session.getAttribute("cartItems");
//	            if (cartItems != null) {
//	                // Set cart items as request attribute
//	                request.setAttribute("cartItems", cartItems);
//	            }
//	        }
//	        // Forward to cart JSP
//	        request.getRequestDispatcher("cart.jsp").forward(request, response);
//	    }
	}
	


