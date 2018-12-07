package service;

import java.util.List;

import org.springframework.stereotype.Service;

import common.utils.Criteria;
import dao.ProductDao;
import domain.ProductVO;

@Service
public class ProductServiceImpl implements ProductService {
	private ProductDao productDao;
	public ProductDao getProductDao() {
		return productDao;
	}
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	@Override
	public void insert(ProductVO productVO) {
		productDao.insert(productVO);
	}
	@Override
	public int countAll() {
		return productDao.countAll();
	}
	@Override
	public int countActive() {
		return productDao.countActive();
	}
	@Override
	public List<ProductVO> listAll(Criteria criteria) {
		return productDao.listAll(criteria);
	}
	@Override
	public List<ProductVO> listActive(Criteria criteria) {
		return productDao.listActive(criteria);
	}
	@Override
	public ProductVO selectByNoTA(int no) {
		return productDao.selectByNoTA(no);
	}
	@Override
	public ProductVO selectByNoFA(int no) {
		return productDao.selectByNoFA(no);
	}
}
