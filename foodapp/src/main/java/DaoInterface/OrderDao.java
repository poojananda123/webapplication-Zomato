package DaoInterface;

import java.util.List;

import domain.Order;
import domain.Users;

public interface OrderDao {
	void save(Order order);
	void update(Order order);
	void delete(Order order);
	Order getUser(int order);
	List<Order> getAllUser();
}
