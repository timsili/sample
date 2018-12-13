package dao;

import java.util.List;
import java.util.Map;

import domain.CartVO;
import domain.OrdersVO;

public interface OrderDao {
	public abstract void insertCart(CartVO cartVO);
	public abstract List<CartVO> listCart(String id);
	public abstract int searchDupl(CartVO cartVO);
	public abstract int updateCart(CartVO cartVO);
	public abstract int checkOrno(String id);
	public abstract int searchOrno(int orno);
	public abstract int updateOrno(Map<String, Object> map);
	public abstract int selectOrno(String id);
	public abstract void insertOrder(OrdersVO ordersVO);
}
