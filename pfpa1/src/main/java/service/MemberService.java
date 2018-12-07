package service;

import java.util.List;

import common.utils.Criteria;
import domain.MemberVO;

public interface MemberService {
	public abstract void insert(MemberVO memberVO);
	public abstract int countById(String id);
	public abstract MemberVO selectById(String id);
	public abstract int count();
	public abstract List<MemberVO> list(Criteria criteria);
	public abstract int update(MemberVO memberVO);
	public abstract int delete(String id);
	public abstract String getSalt(String id);
}
