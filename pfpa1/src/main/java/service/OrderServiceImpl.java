package service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import common.utils.Criteria;
import dao.OrderDao;
import domain.CartVO;
import domain.OrdersVO;

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
	@Override
	public int checkOrno(String id) {
		return orderDao.checkOrno(id);
	}
	@Override
	public int searchOrno(int orno) {
		return orderDao.searchOrno(orno);
	}
	@Override
	public int updateOrno(Map<String, Object> map) {
		return orderDao.updateOrno(map);
	}
	@Override
	public int selectOrno(String id) {
		return orderDao.selectOrno(id);
	}
	@Override
	public void insertOrder(OrdersVO ordersVO) {
		orderDao.insertOrder(ordersVO);
	}
	@Override
	public void insertOrDe(CartVO cartVO) {
		orderDao.insertOrDe(cartVO);
	}
	@Override
	public int deleteCart(String id) {
		return orderDao.deleteCart(id);
	}
	@Override
	public List<OrdersVO> listOrders(String id) {
		return orderDao.listOrders(id);
	}
	@Override
	public OrdersVO selectOrders(Map<String, Object> map) {
		return orderDao.selectOrders(map);
	}
	@Override
	public String selectLaIt(String id) {
		return orderDao.selectLaIt(id);
	}
	@Override
	public int countCart(Map<String, Object> map) {
		return orderDao.countCart(map);
	}
	@Override
	public List<CartVO> listOrde(Map<String, Object> map) {
		return orderDao.listOrde(map);
	}
	@Override
	public int deleteOrders(Map<String, Object> map) {
		return orderDao.deleteOrders(map);
	}
	@Override
	public int deleteOrDe(Map<String, Object> map) {
		return orderDao.deleteOrDe(map);
	}
	@Override
	public int countOd() {
		return orderDao.countOd();
	}
	@Override
	public List<OrdersVO> listOd(Criteria criteria) {
		return orderDao.listOd(criteria);
	}
	@Override
	public OrdersVO selectOd(int orno) {
		return orderDao.selectOd(orno);
	}
	@Override
	public List<CartVO> selectOdd(int orno) {
		return orderDao.selectOdd(orno);
	}
	@Override
	public int updateProg(Map<String, Object> map) {
		return orderDao.updateProg(map);
	}
	@Override
	public void insertPay(Map<String, Object> map) {
		orderDao.insertPay(map);
	}
}
