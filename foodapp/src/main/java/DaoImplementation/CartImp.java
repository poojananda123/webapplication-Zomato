package DaoImplementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DaoInterface.CartDAO;
import domain.Cartitem;
import domain.Menu;

public class CartImp implements CartDAO {


		  private final String url = "jdbc:mysql://localhost:3306/jdbc";
		    private final String uname = "root";
		    private final String password = "root";
			private Connection connection;
			private Menu getAllMenu;

		    	public CartImp() {
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
					connection = DriverManager.getConnection(url, uname, password);
					} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
	}

				@Override
				public void saveCartItem(Cartitem cartitem) {
					 String query = "INSERT INTO Cartitem (itemid, itemname, quantity, price, userId, menuId, restaurantId,restaurantName) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
				        try (PreparedStatement statement = connection.prepareStatement(query)) {
				            statement.setInt(1, cartitem.getItemid());
				            statement.setString(2,cartitem.getItemname());
				            statement.setInt(3, cartitem.getQuantity());
				            statement.setInt(4, cartitem.getPrice());
				            statement.setInt(5, cartitem.getUserId());
				            statement.setInt(6, cartitem.getMenuId());
				            statement.setInt(7, cartitem.getRestaurantId());
				            statement.setString(8,cartitem.getRestaurantName());
				            statement.executeUpdate();
				        } catch (SQLException e) {
				            e.printStackTrace();
				            // Handle exception appropriately (e.g., log, throw custom exception)
				        }
					
				}

				@Override
				public Cartitem getCartItemByMenuId(int id) {
					 Cartitem cartitem = null;
				        String query = "SELECT * FROM cartitem WHERE menuId=?";
				        try (PreparedStatement statement = connection.prepareStatement(query)) {
				            statement.setInt(1, id);
				            try (ResultSet resultSet = statement.executeQuery()) {
				                while (resultSet.next()) {
				                    int itemid = resultSet.getInt(1);
				                    String itemname = resultSet.getString(2);
				                    int quantity = resultSet.getInt(3);
				                    int price = resultSet.getInt(4);
				                    int userId = resultSet.getInt(5);
				                    int menuId = resultSet.getInt(6);
				                    int restaurantId = resultSet.getInt(7);
				                    String restaurantName = resultSet.getString(8);
				                    cartitem= new Cartitem(itemid, itemname, quantity, price, userId, menuId, restaurantId,restaurantName);
				                   
				                    System.out.println("executed"+cartitem.toString());
				                }
				            }
				        } catch (SQLException e) {
				            e.printStackTrace();
				            // Handle exception appropriately (e.g., log, throw custom exception)
				        }
				        return cartitem;
				        
				}

				@Override
				public void updateCartItem(Cartitem cartitem) {
					 String query = "UPDATE cartitem SET itemname=?, quantity=?, price=?, userId=?, menuId=?, restaurantId=?,restaurantName=? WHERE itemid=?";
				        try (PreparedStatement statement = connection.prepareStatement(query)) {
//				        	  statement.setInt(1, cartitem.getItemid());
				        	
					            statement.setString(1,cartitem.getItemname());
					            statement.setInt(2, cartitem.getQuantity());
					            statement.setInt(3, cartitem.getPrice());
					            statement.setInt(4, cartitem.getUserId());
					            statement.setInt(5, cartitem.getMenuId());
					            statement.setInt(6, cartitem.getRestaurantId());
					            statement.setString(7,cartitem.getRestaurantName());
					            statement.setInt(8, cartitem.getItemid());
				            statement.executeUpdate();
				        } catch (SQLException e) {
				            e.printStackTrace();
				            // Handle exception appropriately (e.g., log, throw custom exception)
				        }
					
				}

				@Override
				public List<Cartitem> getCartItemsByUserId(int id) {
					 Cartitem cartitem = null;
					 ArrayList<Cartitem> cartItemList=new ArrayList<Cartitem>();
				        String query = "SELECT * FROM cartitem WHERE userId=?";
				        try (PreparedStatement statement = connection.prepareStatement(query)) {
				            statement.setInt(1, id);
				            try (ResultSet resultSet = statement.executeQuery()) {
				                while (resultSet.next()) {
				                    int itemid = resultSet.getInt(1);
				                    String itemname = resultSet.getString(2);
				                    int quantity = resultSet.getInt(3);
				                    int price = resultSet.getInt(4);
				                    int userId = resultSet.getInt(5);
				                    int menuId = resultSet.getInt(6);
				                    int restaurantId = resultSet.getInt(7);
				                    String restaurantName = resultSet.getString(8);
				                    cartitem= new Cartitem(itemid, itemname, quantity, price, userId, menuId, restaurantId,restaurantName);
				                    cartItemList.add(cartitem);
				                    System.out.println("executed"+cartitem.toString());
				                }
				            }
				        } catch (SQLException e) {
				            e.printStackTrace();
				            // Handle exception appropriately (e.g., log, throw custom exception)
				        }
				        return cartItemList;
				}
				

}
