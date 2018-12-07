package service;

import java.util.List;

import common.utils.Criteria;
import domain.ProductVO;

public interface ProductService {
	public abstract void insert(ProductVO productVO);
	public abstract int countAll();
	public abstract int countActive();
	public abstract List<ProductVO> listAll(Criteria criteria);
	public abstract List<ProductVO> listActive(Criteria criteria);
	public abstract ProductVO selectByNoTA(int no);	// To All
	public abstract ProductVO selectByNoFA(int no);	// For Admin
	public abstract int update(ProductVO productVO);
	public abstract int delete(String item);
}
