package service;

import java.util.List;
import java.util.Map;

import domain.CartVO;
import domain.OrdersVO;

public interface OrderService {
	public abstract void insertCart(CartVO cartVO);
	public abstract List<CartVO> listCart(String id);
	public abstract int searchDupl(CartVO cartVO);
	public abstract int updateCart(CartVO cartVO);
	public abstract int checkOrno(String id);
	public abstract int searchOrno(int orno);
	public abstract int updateOrno(Map<String, Object> map);
	public abstract int selectOrno(String id);
	public abstract void insertOrder(OrdersVO ordersVO);
	public abstract void insertOrDe(CartVO cartVO);
	public abstract int deleteCart(String id);
	public abstract List<OrdersVO> listOrders(String id);
	public abstract OrdersVO selectOrders(Map<String, Object> map);
	public abstract String selectLaIt(String id);
	public abstract int countCart(Map<String, Object> map);
	public abstract List<CartVO> listOrde(Map<String, Object> map);
	public abstract int deleteOrders(Map<String, Object> map);
	public abstract int deleteOrDe(Map<String, Object> map);
}
