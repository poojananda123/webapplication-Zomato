
    <%@ page import="domain.Restaurant" import="java.util.*" language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu</title>
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
  <style>
        .card {
            display: inline-block; /* Display each card inline */
            width: 18rem; /* Set a fixed width for each card */
            margin-right: 20px; /* Add some right margin to separate each card */
            gap:20px;
             margin-bottom: 30px;
            
             align:center;
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
         <div class="container">
      <c:forEach var="menu" items="${allMenu}">
            <div class="card" >
         

           

               <img  src="${pageContext.request.contextPath}/foodappimg/${menu.imagepath}" alt="Card image cap" height="200px" width="200px">
                <div class="card-body">
                    <h2 class="card-title"><c:out value="${menu.itemname}" /></h2>
               <a href="cart?itemname=<c:out value='${menu.itemname}'/>&price=<c:out value='${menu.price}'/>&restaurantId=<c:out value='${restaurantId}'/>&menuId=<c:out value='${menu.menuId}'/>"" class="btn btn-primary">Add to Cart</a>
                       
                        
                    
                </div>
               
            </div>
        </c:forEach>
    </div>
    </div>
</body>
</html>