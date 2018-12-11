package dao;

import java.util.List;

import domain.CartVO;

public interface OrderDao {
	public abstract void insertCart(CartVO cartVO);
	public abstract List<CartVO> listCart(String id);
	public abstract int searchDupl(CartVO cartVO);
	public abstract int updateCart(CartVO cartVO);
}
