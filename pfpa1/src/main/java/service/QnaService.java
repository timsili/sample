package service;

import java.util.List;
import java.util.Map;

import domain.QnaVO;
import domain.ReQnaVO;

public interface QnaService {
	public abstract void insert(QnaVO qnaVO);
	public abstract int count(String id);
	public abstract List<QnaVO> list(Map<String, Object> map);
	public abstract QnaVO selectByNo(int no);
	public abstract void insertRe(ReQnaVO reqnaVO);
	public abstract List<ReQnaVO> listRe(int no);
	public abstract int delete(int no);
	public abstract int deleteRe(int no);
	public abstract int updateUs(int no);
	public abstract int updateAd(int no);
}
