package service;

import domain.MemberVO;

public interface MemberService {
	public abstract void insert(MemberVO memberVO);
	public abstract int countById(String id);
	public abstract MemberVO selectById(String id);
}
