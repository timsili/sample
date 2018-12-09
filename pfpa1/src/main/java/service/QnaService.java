package service;

import java.util.List;

import common.utils.Criteria;
import domain.QnaVO;
import domain.ReQnaVO;

public interface QnaService {
	public abstract void insert(QnaVO qnaVO);
	public abstract int getRef();
	public abstract int count();
	public abstract List<QnaVO> list(Criteria criteria);
	public abstract QnaVO selectByNo(int no);
	public abstract void insertRe(ReQnaVO reqnaVO);
	public abstract List<ReQnaVO> listRe(int no);
}
