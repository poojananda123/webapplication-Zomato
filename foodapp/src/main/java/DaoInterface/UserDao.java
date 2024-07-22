package DaoInterface;

import java.util.List;

import domain.Users;



public interface UserDao {
	void save(Users user);
	void update(Users user);
	void delete(Users user);
	Users getUser(int user);
	List<Users> getAllUser();
}
