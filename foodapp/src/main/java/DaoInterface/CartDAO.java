package DaoInterface;

import java.util.List;

import domain.Cartitem;

public interface CartDAO {
void saveCartItem(Cartitem cartitem);
Cartitem getCartItemByMenuId(int menuId);
void updateCartItem(Cartitem cartitem);
List<Cartitem> getCartItemsByUserId(int id);

}
