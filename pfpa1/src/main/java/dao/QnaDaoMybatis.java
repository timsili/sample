package dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import domain.QnaVO;
import domain.ReQnaVO;

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
	public int count(String id) {
		return sqlSessionTemplate.selectOne("qnaDao.count", id);
	}
	@Override
	public List<QnaVO> list(Map<String, Object> map) {
		return sqlSessionTemplate.selectList("qnaDao.list", map);
	}
	@Override
	public QnaVO selectByNo(int no) {
		QnaVO qnaVO = (QnaVO)sqlSessionTemplate.selectOne("qnaDao.selectByNo", no);
		return qnaVO;
	}
	@Override
	public void insertRe(ReQnaVO reqnaVO) {
		sqlSessionTemplate.insert("qnaDao.insertRe", reqnaVO);
	}
	@Override
	public List<ReQnaVO> listRe(int no) {
		return sqlSessionTemplate.selectList("qnaDao.listRe", no);
	}
	@Override
	public int delete(int no) {
		return sqlSessionTemplate.delete("qnaDao.delete", no);
	}
	@Override
	public int deleteRe(int no) {
		return sqlSessionTemplate.delete("qnaDao.deleteRe", no);
	}
	@Override
	public int updateUs(int no) {
		return sqlSessionTemplate.update("qnaDao.updateUs", no);
	}
	@Override
	public int updateAd(int no) {
		return sqlSessionTemplate.update("qnaDao.updateAd", no);
	}
}
