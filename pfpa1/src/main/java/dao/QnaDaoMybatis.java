package dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

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
}
