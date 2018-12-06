package service;

import org.springframework.stereotype.Service;

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
}
