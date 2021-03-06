package dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import common.utils.Criteria;
import domain.ProductVO;

@Repository
public class ProductDaoMybatis implements ProductDao {
	private SqlSessionTemplate sqlSessionTemplate;
	public ProductDaoMybatis(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	@Override
	public void insert(ProductVO productVO) {
		sqlSessionTemplate.insert("productDao.insert", productVO);
	}
	@Override
	public int countAll() {
		return sqlSessionTemplate.selectOne("productDao.countAll");
	}
	@Override
	public int countActive() {
		return sqlSessionTemplate.selectOne("productDao.countActive");
	}
	@Override
	public List<ProductVO> listAll(Criteria criteria) {
		return sqlSessionTemplate.selectList("productDao.listAll", criteria);
	}
	@Override
	public List<ProductVO> listActive(Criteria criteria) {
		return sqlSessionTemplate.selectList("productDao.listActive", criteria);
	}
	@Override
	public ProductVO selectByNoTA(int no) {
		ProductVO productVO = (ProductVO)sqlSessionTemplate.selectOne("productDao.selectByNoTA", no);
		return productVO;
	}
	@Override
	public ProductVO selectByNoFA(int no) {
		ProductVO productVO = (ProductVO)sqlSessionTemplate.selectOne("productDao.selectByNoFA", no);
		return productVO;
	}
	@Override
	public int update(ProductVO productVO) {
		return sqlSessionTemplate.update("productDao.update", productVO);
	}
	@Override
	public int delete(String item) {
		return sqlSessionTemplate.delete("productDao.delete", item);
	}
}
