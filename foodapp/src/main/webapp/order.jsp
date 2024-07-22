<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order Details</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 80%;
            margin: 20px auto;
            background-color: #FEFFD2;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 5px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            border: 1px solid #B51B75;
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #E1AFD1;
            font-weight: bold;
        }
        td {
            background-color: #ffffff;
        }
        h2 {
            text-align: center;
            margin-bottom: 20px;
            color: #333333;
        }
        
        .co button {
            background-color: #4CAF50; /* Green background */
            color: white; /* White text */
            padding: 10px 20px; /* Padding around text */
            border: none; /* Remove default border */
            cursor: pointer; /* Pointer cursor on hover */
            border-radius: 5px; /* Rounded corners */
            font-size: 16px; /* Font size */
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Order Details</h2>
        
        <table>
            <tr>
                <th>Order ID</th>
                <th>User ID</th>
                <th>Order Date</th>
                <th>Total Price</th>
                <th>Status</th>
            </tr>
            
            <%-- Retrieve and display each attribute using JSP tags --%>
            <tr>
                <td><%= request.getAttribute("oid") %></td>
                <td><%= request.getAttribute("uid") %></td>
                <td><%= request.getAttribute("orderDate2") %></td>
                <td>$ <%= request.getAttribute("totalPrice") %></td>
                <td><%= request.getAttribute("status") %></td>
            </tr>
        </table>
    </div>
    <div align="center"  class="co">
    <a href="home">
    <button >Home</button>
    </a>
    </div>

</body>
</html>
