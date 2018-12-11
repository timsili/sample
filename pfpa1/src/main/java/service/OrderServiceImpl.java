package service;

import java.util.List;

import org.springframework.stereotype.Service;

import dao.OrderDao;
import domain.CartVO;

@Service
public class OrderServiceImpl implements OrderService {
	private OrderDao orderDao;
	public OrderDao getOrderDao() {
		return orderDao;
	}
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
	@Override
	public void insertCart(CartVO cartVO) {
		orderDao.insertCart(cartVO);
	}
	@Override
	public List<CartVO> listCart(String id) {
		return orderDao.listCart(id);
	}
	@Override
	public int searchDupl(CartVO cartVO) {
		return orderDao.searchDupl(cartVO);
	}
	@Override
	public int updateCart(CartVO cartVO) {
		return orderDao.updateCart(cartVO);
	}
}
