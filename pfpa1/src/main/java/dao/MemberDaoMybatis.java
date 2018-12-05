package dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import common.utils.Criteria;
import domain.MemberVO;

@Repository
public class MemberDaoMybatis implements MemberDao {
	private SqlSessionTemplate sqlSessionTemplate;
	public MemberDaoMybatis(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	@Override
	public void insert(MemberVO memberVO) {
		sqlSessionTemplate.insert("memberDao.insert", memberVO);
	}
	@Override
	public int countById(String id) {
		return sqlSessionTemplate.selectOne("memberDao.countById", id);
	}
	@Override
	public MemberVO selectById(String id) {
		MemberVO memberVO = (MemberVO)sqlSessionTemplate.selectOne("memberDao.selectById", id);
		return memberVO;
	}
	@Override
	public int count() {
		return sqlSessionTemplate.selectOne("memberDao.count");
	}
	@Override
	public List<MemberVO> list(Criteria criteria) {
		return sqlSessionTemplate.selectList("memberDao.list", criteria);
	}
	@Override
	public int update(MemberVO memberVO) {
		return sqlSessionTemplate.update("memberDao.update", memberVO);
	}
}
