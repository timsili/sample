package service;

import org.springframework.stereotype.Service;

import dao.QnaDao;
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
}
