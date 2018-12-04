package service;

import org.springframework.stereotype.Service;

import dao.MemberDao;
import domain.MemberVO;

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
}
