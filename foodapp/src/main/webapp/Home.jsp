<%@ page import="domain.Restaurant" import="java.util.*" language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Restaurant Cards</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
    <style>
        .card {
            display: inline-block; /* Display each card inline */
            width: 18rem; /* Set a fixed width for each card */
            margin-right: 20px; /* Add some right margin to separate each card */
            gap:30px;
             margin-bottom: 30px;
             cursor: pointer
        }
        .nav{
    background-color: whitesmoke;
  display: flex;
  height: 50px;
  align-items: center;
  float: right;

}

.nav-items a{
    font-weight: 500;
    color: black;
    padding: 10px;
    font-weight: bolder;
    text-decoration: none;
}
    </style>
</head>
<body>
<div>
 <div class="nav">
<c:if test="${user==null}">
<div class="nav-items">
    <a href="Register.html">Register</a>
</div>

<div class="nav-items">
    <a href="login1.jsp">Login</a>
</div>
 </c:if>
  <c:if test="${user!=null}">
<div class="nav-items">
    <a href="login1.jsp">Logout</a>
</div>
<div class="nav-items">
    <a href="/cart">Cart</a>
</div>
<div class="nav-items">
    <a href="#">OrderHistory</a>
</div>
 </c:if>
   </div> 
   </div>
</br>
</br></br>

    <div class="container">
        <c:forEach var="restaurant" items="${allRestaurant}">
            <div class="card" >
            
            <a href="menu?restaurantId=<c:out value='${restaurant.restaurantId}'/>">

                <img class="card-img-top" src="${pageContext.request.contextPath}/foodappimg/${restaurant.imagepath}" alt="Card image cap" height="200px" width="200px">
                <div class="card-body">
                    <h5 class="card-title">Name:<c:out value="${restaurant.name}" /></h5>
                    <p class="card-text">
                      Address:  <c:out value="${restaurant.address}" /><br>
                        Rating: <c:out value="${restaurant.rating}" />
                       
                        
                    </p>
                </div>
                </a>
            </div>
        </c:forEach>
    </div>
</body>
</html>
