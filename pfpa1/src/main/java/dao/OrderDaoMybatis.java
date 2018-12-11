package dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import domain.CartVO;

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
}
