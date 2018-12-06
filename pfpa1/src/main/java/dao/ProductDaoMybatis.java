package dao;

import org.mybatis.spring.SqlSessionTemplate;

import domain.ProductVO;

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
}
