package dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import common.utils.Criteria;
import domain.CartVO;
import domain.OrdersVO;

@Repository
public class OrderDaoMybatis implements OrderDao {
	private SqlSessionTemplate sqlSessionTemplate;
	public OrderDaoMybatis(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	@Override
	public void insertCart(CartVO cartVO) {
		sqlSessionTemplate.insert("orderDao.insertCart", cartVO);
	}
	@Override
	public List<CartVO> listCart(String id) {
		return sqlSessionTemplate.selectList("orderDao.listCart", id);
	}
	@Override
	public int searchDupl(CartVO cartVO) {
		return sqlSessionTemplate.selectOne("orderDao.searchDupl", cartVO);
	}
	@Override
	public int updateCart(CartVO cartVO) {
		return sqlSessionTemplate.update("orderDao.updateCart", cartVO);
	}
	@Override
	public int checkOrno(String id) {
		return sqlSessionTemplate.selectOne("orderDao.checkOrno", id);
	}
	@Override
	public int searchOrno(int orno) {
		return sqlSessionTemplate.selectOne("orderDao.searchOrno", orno);
	}
	@Override
	public int updateOrno(Map<String, Object> map) {
		return sqlSessionTemplate.update("orderDao.updateOrno", map);
	}
	@Override
	public int selectOrno(String id) {
		return sqlSessionTemplate.selectOne("orderDao.selectOrno", id);
	}
	@Override
	public void insertOrder(OrdersVO ordersVO) {
		sqlSessionTemplate.insert("orderDao.insertOrder", ordersVO);
	}
	@Override
	public void insertOrDe(CartVO cartVO) {
		sqlSessionTemplate.insert("orderDao.insertOrDe", cartVO);
	}
	@Override
	public int deleteCart(String id) {
		return sqlSessionTemplate.delete("orderDao.deleteCart", id);
	}
	@Override
	public List<OrdersVO> listOrders(String id) {
		return sqlSessionTemplate.selectList("orderDao.listOrders", id);
	}
	@Override
	public OrdersVO selectOrders(Map<String, Object> map) {
		OrdersVO ordersVO = (OrdersVO)sqlSessionTemplate.selectOne("orderDao.selectOrders", map);
		return ordersVO;
	}
	@Override
	public String selectLaIt(String id) {
		return sqlSessionTemplate.selectOne("orderDao.selectLaIt", id);
	}
	@Override
	public int countCart(Map<String, Object> map) {
		return sqlSessionTemplate.selectOne("orderDao.countCart", map);
	}
	@Override
	public List<CartVO> listOrde(Map<String, Object> map) {
		return sqlSessionTemplate.selectList("orderDao.listOrde", map);
	}
	@Override
	public int deleteOrders(Map<String, Object> map) {
		return sqlSessionTemplate.delete("orderDao.deleteOrders", map);
	}
	@Override
	public int deleteOrDe(Map<String, Object> map) {
		return sqlSessionTemplate.delete("orderDao.deleteOrDe", map);
	}
	@Override
	public int countOd() {
		return sqlSessionTemplate.selectOne("orderDao.countOd");
	}
	@Override
	public List<OrdersVO> listOd(Criteria criteria) {
		return sqlSessionTemplate.selectList("orderDao.listOd", criteria);
	}
	@Override
	public OrdersVO selectOd(int orno) {
		OrdersVO ordersVO = (OrdersVO)sqlSessionTemplate.selectOne("orderDao.selectOd", orno);
		return ordersVO;
	}
	@Override
	public List<CartVO> selectOdd(int orno) {
		return sqlSessionTemplate.selectList("orderDao.selectOdd", orno);
	}
	@Override
	public int updateProg(Map<String, Object> map) {
		return sqlSessionTemplate.update("orderDao.updateProg", map);
	}
	@Override
	public void insertPay(Map<String, Object> map) {
		sqlSessionTemplate.insert("orderDao.insertPay", map);
	}
}
