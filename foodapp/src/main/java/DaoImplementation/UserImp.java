package DaoImplementation;

import DaoInterface.UserDao;
import domain.Users;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserImp implements UserDao {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/zomato";
    private static final String JDBC_USERNAME = "root";
    private static final String JDBC_PASSWORD = "root";
	private int userId;
	private Users user;
	private Users user2;
	
	public UserImp() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

    @Override
    public void save(Users user) {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD)) {
        	System.out.println("save data");
            String sql = "INSERT INTO users (name,username, email, password, address, role,phone) VALUES (?, ?, ?, ?, ?,?,?)";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
            	statement.setString(1, user.getName());
                statement.setString(2, user.getUsername());
                statement.setString(3, user.getEmail());
                statement.setString(4, user.getPassword());
                statement.setString(5, user.getAddress());
                statement.setString(6, user.getRole());
              statement.setLong(7, user.getPhone());
                statement.executeUpdate();
                System.out.println("executed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Users user) {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD)) {
            String sql = "UPDATE user SET username=?, email=?, password=?, address=?, role=? WHERE user_id=?";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setString(1, user.getUsername());
                statement.setString(2, user.getEmail());
                statement.setString(3, user.getPassword());
                statement.setString(4, user.getAddress());
                statement.setString(5, user.getRole());
                statement.setInt(6, user.getUserId());
                System.out.println("executed");
                statement.executeUpdate();
                System.out.println("executed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Users user) {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD)) {
            String sql = "DELETE FROM user WHERE user_id=?";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setInt(1, user.getUserId());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Users getUser(int userId) {
        Users user = null;
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD)) {
            String sql = "SELECT * FROM users WHERE userid=?";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setInt(1, userId);
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    int id = resultSet.getInt("userid");
                    String name = resultSet.getString("name");
                    String uname = resultSet.getString("username");
                    String password = resultSet.getString("password"); // Assuming password is stored as String
                    String email = resultSet.getString("email");
                    String role = resultSet.getString("role");
                    Date createdate = resultSet.getDate("createdDate");
                    Date lastlogin = resultSet.getDate("LastLoginDate");
                    long phone = resultSet.getLong("phone"); // Assuming phone is stored as long
                    user = new Users(userId, name, uname, password, email, email, role, createdate, lastlogin, null);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    @Override
    public List<Users> getAllUser() {
        List<Users> userList = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD)) {
            String sql = "SELECT * FROM users";
            try (Statement statement = conn.createStatement()) {
                ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                	 int id=  resultSet.getInt(1);
                     String name=  resultSet.getString(2);
                     String uname=  resultSet.getString(3);
                     int password=  resultSet.getInt(4);
                     System.out.print(password);
                     String email=  resultSet.getString(5);
                     String role=  resultSet.getString(6);
                     Date createdate=  resultSet.getDate(7);
                     Date lastlogin=  resultSet.getDate(8);
                     Long phone=  resultSet.getLong(9);
                     user=new Users(userId, uname, name, uname, email, email, role, createdate, lastlogin, phone);
                    userList.add(user);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }
    
  

	public Users getUsers(String uname, String pass) {
		 Users user = null;
	
		   try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD)) {
	            String sql = "SELECT * FROM users where username=? and password=? ";
	            try (PreparedStatement statement = conn.prepareStatement(sql)) {
	            	statement.setString(3, uname);
	                statement.setString(4, pass);
	                ResultSet resultSet = statement.executeQuery();
	                if (resultSet.next()) {
	                    int id = resultSet.getInt("userid");
	                    user = new Users(userId); 
	                }
	            }
		   } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user2;
	}
}
