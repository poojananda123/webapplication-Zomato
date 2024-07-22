package DaoImplementation;

import java.util.List;

import DaoInterface.OrderDao;
import domain.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderImp implements OrderDao {




	    // Database connection details
	    private final String url = "jdbc:mysql://localhost:3306/jdbc";
	    private final String username = "root";
	    private final String password = "root";

	    // SQL queries
	    private final String INSERT_ORDER_QUERY = "INSERT INTO orders (userid, restaurantid, orderdate, totalamount, status, paymentmode) VALUES (?, ?, ?, ?, ?, ?)";
	    private final String UPDATE_ORDER_QUERY = "UPDATE orders SET userid=?, restaurantid=?, orderdate=?, totalamount=?, status=?, paymentmode=? WHERE orderid=?";
	    private final String DELETE_ORDER_QUERY = "DELETE FROM orders WHERE orderid=?";
	    private final String SELECT_ORDER_BY_ID_QUERY = "SELECT * FROM orders WHERE orderid=?";
	    private final String SELECT_ALL_ORDERS_QUERY = "SELECT * FROM orders";

	    // Establishing database connection
	    private Connection getConnection() throws SQLException {
	        return DriverManager.getConnection(url, username, password);
	    }

	    // Save an order to the database
	    @Override
	    public void save(Order order) {
	        try (Connection conn = getConnection();
	             PreparedStatement stmt = conn.prepareStatement(INSERT_ORDER_QUERY, Statement.RETURN_GENERATED_KEYS)) {
	            stmt.setInt(1, order.getUserId());
	            stmt.setInt(2, order.getRestaurantId());
	            stmt.setDate(3, order.getOrderDate());
	            stmt.setInt(4, order.getTotalAmount());
	            stmt.setString(5, order.getStatus());
	            stmt.setString(6, order.getPaymentmode());

	            stmt.executeUpdate();
	            ResultSet generatedKeys = stmt.getGeneratedKeys();
	            if (generatedKeys.next()) {
	                order.setOrderId(generatedKeys.getInt(1));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    // Update an existing order in the database
	    @Override
	    public void update(Order order) {
	        try (Connection conn = getConnection();
	             PreparedStatement stmt = conn.prepareStatement(UPDATE_ORDER_QUERY)) {
	            stmt.setInt(1, order.getUserId());
	            stmt.setInt(2, order.getRestaurantId());
	            stmt.setDate(3, order.getOrderDate());
	            stmt.setDouble(4, order.getTotalAmount());
	            stmt.setString(5, order.getStatus());
	            stmt.setString(6, order.getPaymentmode());
	            stmt.setInt(7, order.getOrderId());

	            stmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    // Delete an order from the database
	    @Override
	    public void delete(Order order) {
	        try (Connection conn = getConnection();
	             PreparedStatement stmt = conn.prepareStatement(DELETE_ORDER_QUERY)) {
	            stmt.setInt(1, order.getOrderId());
	            stmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    // Get an order by its ID from the database
	    @Override
	    public Order getUser(int orderId) {
	        Order order = null;
	        try (Connection conn = getConnection();
	             PreparedStatement stmt = conn.prepareStatement(SELECT_ORDER_BY_ID_QUERY)) {
	            stmt.setInt(1, orderId);
	            try (ResultSet rs = stmt.executeQuery()) {
	                if (rs.next()) {
	                  int orderid= rs.getInt(1);
	                  int userid= rs.getInt(2);
	                  int restaurantid= rs.getInt(3);
	                  Date orderdate= rs.getDate(4);
	                  int amount= rs.getInt(5);
	                  Boolean status= rs.getBoolean(6);
	                 String paymentmode= rs.getString(7);
	                 order=new Order(orderid, userid, restaurantid, orderdate, amount, paymentmode, paymentmode);
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return order;
	    }

	    // Get all orders from the database
	    @Override
	    public List<Order> getAllUser() {
	        List<Order> orders = new ArrayList<>();
	        try (Connection conn = getConnection();
	             Statement stmt = conn.createStatement();
	             ResultSet rs = stmt.executeQuery(SELECT_ALL_ORDERS_QUERY)) {
	            while (rs.next()) {
	               
	                		 int orderid= rs.getInt(1);
	   	                  int userid= rs.getInt(2);
	   	                  int restaurantid= rs.getInt(3);
	   	                  Date orderdate= rs.getDate(4);
	   	                  int amount= rs.getInt(5);
	   	                  Boolean status= rs.getBoolean(6);
	   	                 String paymentmode= rs.getString(7);
	   	                 Order order=new Order(orderid, userid, restaurantid, orderdate, amount, paymentmode, paymentmode);
	                orders.add(order);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return orders;
	    }
	}



