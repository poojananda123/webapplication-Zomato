package DaoImplementation;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DaoInterface.MenuDao;
import domain.Cartitem;
import domain.Menu;

public class MenuImp1 implements MenuDao {


	  private final String url = "jdbc:mysql://localhost:3306/jdbc";
	    private final String uname = "root";
	    private final String password = "root";
		private Connection connection;
		private Menu getAllMenu;

	    	public MenuImp1() {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection(url, uname, password);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

	   

	    @Override
	    public void save(Menu menu) {
	        String query = "INSERT INTO Menu (restaurantid, itemname, description, price, ratings, isavailable, imagepath) VALUES (?, ?, ?, ?, ?, ?, ?)";
	        try (PreparedStatement statement = connection.prepareStatement(query)) {
	            statement.setInt(1, menu.getRestaurantId());
	            statement.setString(2, menu.getItemname());
	            statement.setString(3, menu.getDescription());
	            statement.setDouble(4, menu.getPrice());
	            statement.setDouble(5, menu.getRatings());
	            statement.setBoolean(6, menu.getIsAvailable());
	            statement.setString(7, menu.getImagepath());
	            statement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            // Handle exception appropriately (e.g., log, throw custom exception)
	        }
	    }

	    @Override
	    public void update(Menu menu) {
	        String query = "UPDATE Menu SET restaurantid=?, itemname=?, description=?, price=?, ratings=?, isavailable=?, imagepath=? WHERE menuid=?";
	        try (PreparedStatement statement = connection.prepareStatement(query)) {
	            statement.setInt(1, menu.getRestaurantId());
	            statement.setString(2, menu.getItemname());
	            statement.setString(3, menu.getDescription());
	            statement.setDouble(4, menu.getPrice());
	            statement.setDouble(5, menu.getRatings());
	            statement.setBoolean(6, menu.getIsAvailable());
	            statement.setString(7, menu.getImagepath());
	            statement.setInt(8, menu.getMenuId());
	            statement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            // Handle exception appropriately (e.g., log, throw custom exception)
	        }
	    }

	    @Override
	    public void delete(Menu menu) {
	        String query = "DELETE FROM Menu WHERE menuid=?";
	        try (PreparedStatement statement = connection.prepareStatement(query)) {
	            statement.setInt(1, menu.getMenuId());
	            statement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            // Handle exception appropriately (e.g., log, throw custom exception)
	        }
	    }

	    @Override
	    public Menu getMenu(int menuId) {
	        String query = "SELECT * FROM Menu WHERE menuid=?";
	        Menu menu = null;
	        try (PreparedStatement statement = connection.prepareStatement(query)) {
	            statement.setInt(1, menuId);
	            try (ResultSet resultSet = statement.executeQuery()) {
	                if (resultSet.next()) {
	                   int menuid= resultSet.getInt(1);
	                   int restaurantid= resultSet.getInt(2);
	                   String itemname= resultSet.getString(3);
	                   String description= resultSet.getString(4);
	                   int price= resultSet.getInt(5);
	                   int rating= resultSet.getInt(6);
	                   Boolean isavailable= resultSet.getBoolean(7);
	                   String imgpath= resultSet.getString(8);
	                   menu=new Menu(menuid, restaurantid, itemname, description, price, rating, false, imgpath);
	                  
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            // Handle exception appropriately (e.g., log, throw custom exception)
	        }
	        return menu;
	    }

	    @Override
	    public List<Menu> getAllMenu() {
	        List<Menu> menuList = new ArrayList<>();
	        String query = "SELECT * FROM Menu";
	        try (PreparedStatement statement = connection.prepareStatement(query);
	             ResultSet resultSet = statement.executeQuery()) {
	            while (resultSet.next()) {
	                Menu menu = new Menu();
	                int menuid= resultSet.getInt(1);
	                   int restaurantid= resultSet.getInt(2);
	                   String itemname= resultSet.getString(3);
	                   String description= resultSet.getString(4);
	                   int price= resultSet.getInt(5);
	                   int rating= resultSet.getInt(6);
	                   Boolean isavailable= resultSet.getBoolean(7);
	                   String imgpath= resultSet.getString(8);
	                   menu=new Menu(menuid, restaurantid, itemname, description, price, rating, false, imgpath);
	                  
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            // Handle exception appropriately (e.g., log, throw custom exception)
	        }
	        return menuList;
	    }

	   
		@Override
	    public List<Menu> getAllMenu(int restaurantId) {
	        List<Menu> menuList = new ArrayList<>();
	        String query = "SELECT * FROM menu WHERE restaurantid=?";
	        try (PreparedStatement statement = connection.prepareStatement(query)) {
	            statement.setInt(1, restaurantId);
	            try (ResultSet resultSet = statement.executeQuery()) {
	                while (resultSet.next()) {
	                    int menuid = resultSet.getInt(1);
	                    int restaurantid = resultSet.getInt(2);
	                    String itemname = resultSet.getString(3);
	                    String description = resultSet.getString(4);
	                    int price = resultSet.getInt(5);
	                    int rating = resultSet.getInt(6);
	                    boolean isavailable = resultSet.getBoolean(7);
	                    String imgpath = resultSet.getString(8);
	                    Menu menu = new Menu(menuid, restaurantid, itemname, description, price, rating, isavailable, imgpath);
	                    menuList.add(menu);
	                    System.out.println("executed"+menu.toString());
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            // Handle exception appropriately (e.g., log, throw custom exception)
	        }
	        return menuList;
	    }

	   public List<Cartitem> getcart(ArrayList<Cartitem> cartList){
		   	List<Cartitem> p=new ArrayList<Cartitem>();
		   	try {
		   		if(cartList.size()>0)
		   		{
		   			for(Cartitem item:cartList) {
		   				String query = "select * from menu where id=?";
		   				PreparedStatement pst = this.connection.prepareStatement(query);
		   				pst.setInt(1,item.getItemid());
		   				ResultSet rs= pst.executeQuery();
		   				while(rs.next()) {
		   					Cartitem r=new Cartitem();
		   					r.setItemid(rs.getInt("menuid"));
		   					r.setItemname(rs.getString("itemname"));
		   					r.setPrice(rs.getInt("price"));
		   					r.setQuantity(rs.getInt("quantity"));
		   					p.add(r);
		   				}
		   			}}
		   	}
		   	catch(Exception e) {
		   		e.printStackTrace();
		   				
		   			}
		   		
		   	
		return cartList;
		   
	   }



	@Override
	public Menu getMenuById(int id) {
		  Menu menuList = null;
	        String query = "SELECT * FROM menu WHERE menuId=?";
	        try (PreparedStatement statement = connection.prepareStatement(query)) {
	            statement.setInt(1, id);
	            try (ResultSet resultSet = statement.executeQuery()) {
	                while (resultSet.next()) {
	                    int menuid = resultSet.getInt(1);
	                    int restaurantid = resultSet.getInt(2);
	                    String itemname = resultSet.getString(3);
	                    String description = resultSet.getString(4);
	                    int price = resultSet.getInt(5);
	                    int rating = resultSet.getInt(6);
	                    boolean isavailable = resultSet.getBoolean(7);
	                    String imgpath = resultSet.getString(8);
	                    menuList = new Menu(menuid, restaurantid, itemname, description, price, rating, isavailable, imgpath);
	                   
	                    System.out.println("executed"+menuList.toString());
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            // Handle exception appropriately (e.g., log, throw custom exception)
	        }
	        return menuList;
	        
	}
}




	

