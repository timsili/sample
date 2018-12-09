package domain;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

@Alias("qnaVO")
public class QnaVO {
	private int no;
//	writer
	private String writ;
	private String title;
//	content
	private String cont;
//	reply
	private String rep;
//	registration date
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCont() {
		return cont;
	}
	public void setCont(String cont) {
		this.cont = cont;
	}
	public String getRep() {
		return rep;
	}
	public void setRep(String rep) {
		this.rep = rep;
	}
	public Timestamp getRegd() {
		return regd;
	}
	public void setRegd(Timestamp regd) {
		this.regd = regd;
	}
}
