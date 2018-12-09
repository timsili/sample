package domain;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

@Alias("reqnaVO")
public class ReQnaVO {
	private int no;
	private String writ;
	private String cont;
	private Timestamp regd;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getWrit() {
		return writ;
	}
	public void setWrit(String writ) {
		this.writ = writ;
	}
	public String getCont() {
		return cont;
	}
	public void setCont(String cont) {
		this.cont = cont;
	}
	public Timestamp getRegd() {
		return regd;
	}
	public void setRegd(Timestamp regd) {
		this.regd = regd;
	}
}
