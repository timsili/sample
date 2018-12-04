package domain;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

@Alias("memberVO")
public class MemberVO {
	private int no;
	private String id; 
	private String pwd;
//	confirm password
	private String cpwd;
	private String salt;
	private String name;
	private String email;
//	telephone
	private String tel;
//	cell phone
	private String ceph;
//	post code
	private int poco;
	private String addr;
//	detail address
	private String daddr;
//	mileage
	private int poin;
//	sum of payment
	private int sum;
	private String rank;
//	registration date
	private Timestamp regd;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getCpwd() {
		return cpwd;
	}
	public void setCpwd(String cpwd) {
		this.cpwd = cpwd;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getCeph() {
		return ceph;
	}
	public void setCeph(String ceph) {
		this.ceph = ceph;
	}
	public int getPoco() {
		return poco;
	}
	public void setPoco(int poco) {
		this.poco = poco;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getDaddr() {
		return daddr;
	}
	public void setDaddr(String daddr) {
		this.daddr = daddr;
	}
	public int getPoin() {
		return poin;
	}
	public void setPoin(int poin) {
		this.poin = poin;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public Timestamp getRegd() {
		return regd;
	}
	public void setRegd(Timestamp regd) {
		this.regd = regd;
	}
}
