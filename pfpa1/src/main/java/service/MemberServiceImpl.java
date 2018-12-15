package service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import common.utils.Criteria;
import dao.MemberDao;
import domain.MemberVO;
import oracle.net.aso.p;

@Service
public class MemberServiceImpl implements MemberService {
	private MemberDao memberDao;
	public MemberDao getMemberDao() {
		return memberDao;
	}
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	@Override
	public void insert(MemberVO memberVO) {
		memberDao.insert(memberVO);
	}
	@Override
	public int countById(String id) {
		return memberDao.countById(id);
	}
	@Override
	public MemberVO selectById(String id) {
		return memberDao.selectById(id);
	}
	@Override
	public int count() {
		return memberDao.count();
	}
	@Override
	public List<MemberVO> list(Criteria criteria) {
		return memberDao.list(criteria);
	}
	@Override
	public int update(MemberVO memberVO) {
		return memberDao.update(memberVO);
	}
	@Override
	public int delete(String id) {
		return memberDao.delete(id);
	}
	@Override
	public String getSalt(String id) {
		return memberDao.getSalt(id);
	}
	@Override
	public int updateGrade(Map<String, Object> map) {
		return memberDao.updateGrade(map);
	}
}
