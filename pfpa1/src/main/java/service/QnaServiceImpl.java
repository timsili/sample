package service;

import java.util.List;

import org.springframework.stereotype.Service;

import common.utils.Criteria;
import dao.QnaDao;
import domain.ProductVO;
import domain.QnaVO;

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
	public List<ProductVO> list(Criteria criteria) {
		return qnaDao.list(criteria);
	}
}
