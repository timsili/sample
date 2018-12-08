package dao;

import java.util.List;

import common.utils.Criteria;
import domain.ProductVO;
import domain.QnaVO;

public interface QnaDao {
	public abstract void insert(QnaVO qnaVO);
	public abstract int getRef();
	public abstract int count();
	public abstract List<ProductVO> list(Criteria criteria);
	public abstract QnaVO selectByNo(int no);
}
