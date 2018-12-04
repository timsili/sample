package dao;

import domain.MemberVO;

public interface MemberDao {
	public abstract void insert(MemberVO memberVO);
	public abstract int countById(String id);
	public abstract MemberVO selectById(String id);
}
