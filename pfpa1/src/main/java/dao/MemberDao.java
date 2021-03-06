package dao;

import java.util.List;
import java.util.Map;

import common.utils.Criteria;
import domain.MemberVO;

public interface MemberDao {
	public abstract void insert(MemberVO memberVO);
	public abstract int countById(String id);
	public abstract MemberVO selectById(String id);
	public abstract int count();
	public abstract List<MemberVO> list(Criteria criteria);
	public abstract int update(MemberVO memberVO);
	public abstract int delete(String id);
	public abstract String getSalt(String id);
	public abstract int updateGrade(Map<String, Object> map);
}
