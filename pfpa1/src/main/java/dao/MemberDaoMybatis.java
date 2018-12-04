package dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

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
}
