package dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import common.utils.Criteria;
import domain.ProductVO;
import domain.QnaVO;

@Repository
public class QnaDaoMybatis implements QnaDao {
	private SqlSessionTemplate sqlSessionTemplate;
	public QnaDaoMybatis(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	@Override
	public void insert(QnaVO qnaVO) {
		sqlSessionTemplate.insert("qnaDao.insert", qnaVO);
	}
	@Override
	public int getRef() {
		return sqlSessionTemplate.selectOne("qnaDao.getRef");
	}
	@Override
	public int count() {
		return sqlSessionTemplate.selectOne("qnaDao.count");
	}
	@Override
	public List<ProductVO> list(Criteria criteria) {
		return sqlSessionTemplate.selectList("qnaDao.list", criteria);
	}
	@Override
	public QnaVO selectByNo(int no) {
		QnaVO qnaVO = (QnaVO)sqlSessionTemplate.selectOne("qnaDao.selectByNo", no);
		return qnaVO;
	}
}
