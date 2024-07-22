<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:useBean id="Additem" class="registrarbeans.Item" scope = "request" />
<jsp:useBean id="Cart" class="registrarbeans.ShoppingCart" scope ="session" />   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

   <%
    //
    // set the session's inactive interval
    //
     session.setMaxInactiveInterval(1800); // 30 minutes  
            
    //
    // now add the item to the cart
    //
    synchronized(session)  // lock the session
    { 
       Cart.add(item); // cart uses ArrayList which is not thread safe so we locked
       Cart.display(out); // tell the cart to send its contents to the browser
     }
    %> 
    </body>
</html>
</body>
</html>