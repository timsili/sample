package service;

import domain.QnaVO;

public interface QnaService {
	public abstract void insert(QnaVO qnaVO);
	public abstract int getRef();
}
