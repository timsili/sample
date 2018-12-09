package service;

import java.util.List;

import org.springframework.stereotype.Service;

import common.utils.Criteria;
import dao.QnaDao;
import domain.QnaVO;
import domain.ReQnaVO;

@Service
public class QnaServiceImpl implements QnaService {
	private QnaDao qnaDao;
	public QnaDao getQnaDao() {
		return qnaDao;
	}
	public void setQnaDao(QnaDao qnaDao) {
		this.qnaDao = qnaDao;
	}
	@Override
	public void insert(QnaVO qnaVO) {
		qnaDao.insert(qnaVO);
	}
	@Override
	public int getRef() {
		return qnaDao.getRef();
	}
	@Override
	public int count() {
		return qnaDao.count();
	}
	@Override
	public List<QnaVO> list(Criteria criteria) {
		return qnaDao.list(criteria);
	}
	@Override
	public QnaVO selectByNo(int no) {
		return qnaDao.selectByNo(no);
	}
	@Override
	public void insertRe(ReQnaVO reqnaVO) {
		qnaDao.insertRe(reqnaVO);
	}
	@Override
	public List<ReQnaVO> listRe(int no) {
		return qnaDao.listRe(no);
	}
	@Override
	public int delete(int no) {
		return qnaDao.delete(no);
	}
	@Override
	public int deleteRe(int no) {
		return qnaDao.deleteRe(no);
	}
}
