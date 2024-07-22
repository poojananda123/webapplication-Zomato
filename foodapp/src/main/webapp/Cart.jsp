<%@ page language="java" import="domain.Cartitem" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cart</title>

<style>
/* Basic CSS for layout and styling */
body {
  font-family: Arial, sans-serif;
  margin: 0;
  padding: 0;
  background-color: #f4f4f4;
}

.container {
  max-width: 800px;
  margin: 20px auto;
  background-color: #fff;
  padding: 20px;
  border-radius: 8px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.menu-item {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 10px;
}

.menu-item img {
  width: 100px;
  height: 100px;
  object-fit: cover;
  border-radius: 8px;
}

.item-details {
  flex: 1;
  margin-left: 10px;
}

.item-details h3 {
  margin: 0;
}

.item-details p {
  margin: 5px 0;
}

.quantity {
  display: inline-block;
  margin-right: 10px;
}

.quantity input {
  width: 40px;
  padding: 5px;
  text-align: center;
}

.btn {
  padding: 8px 16px;
  background-color: #007bff;
  color: #fff;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

.btn:hover {
  background-color: #0056b3;
}
</style>

  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
 
<!-- <div class="container">
  <div class="menu-item"> -->
    <div class="item-details container">
      <h3>Cart Items:</h3>
      <br/>
      <!-- Iterate over the list of cart items -->
      <table class="table table-striped">
     <tr>
     <th>Restaurant Name</th>
      <th>Item</th>
     <th>Price</th>
     <th>Quantity</th>
     
      <th>Total</th>
      <th></th>
      
     <th></th>
     

     </tr>
     <c:forEach items="${carItemList}" var="cartItem">

     <tr>
      <td>${cartItem.getRestaurantName()}</td>
     <td>${cartItem.getItemname()}</td>
      <td>${cartItem.getPrice()}</td>
       <td>${cartItem.getQuantity()}</td>
      <td>${cartItem.getPrice()*cartItem.getQuantity()}</td>
      
        <td><a href="#" class="text-success"><i class="fa fa-plus-circle fa-2x" aria-hidden="true"></i></a></td>
       <td><a href="#" class="text-danger"><i class="fa fa-minus-circle fa-2x" aria-hidden="true"></i></a></td>
     </tr>
     
       </c:forEach>
     </table>
    
     <!-- <div class="quantity">
        <label for="quantity1">Quantity:</label>
        <input type="number" id="quantity1" value="1" min="1">
      </div> 
      <br/><br/>
      <form action="menu" method="post">
        <button class="btn btn-update">Update</button>
      </form>
          <br/>
      <button class="btn btn-remove">Remove</button>
      <br/>
    </div>
  </div>
   -->

  <!-- Add more menu items similarly -->

  <div class="actions">
  
      
      <a href="menu?restaurantId=${restaurantId}">
      <button class="btn btn-warning text-white">Add More Items</button></a>
      <form id="checkout" action="checkout" method="get">
            <input type="hidden" name="totalPrice" id="totalPrice" value="${totalPrice}">
   <a href="checkout?userid=37? "> <button class="btn btn-success ms-3 text-white">Checkout</button></a>
</form>

  </div>
  <br>
   <h3>Total Price: ${totalPrice}</h3>
</div>
 
</body>
</html>
