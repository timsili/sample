package dao;

import domain.QnaVO;

public interface QnaDao {
	public abstract void insert(QnaVO qnaVO);
	public abstract int getRef();
}
