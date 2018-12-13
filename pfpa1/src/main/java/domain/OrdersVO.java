package domain;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

@Alias("ordersVO")
public class OrdersVO {
	private int no;
//	order number
	private int orno;
	private String id;
	private String name;
//	post code
	private int poco;
	private String addr;
	private String daddr;
	private String tel;
	private String ceph;
//	demand
	private String dema;
//	progress
	private String prog;
	private Timestamp regd;
//	payment method
	private String pame;
//	payment detail
	private String pade;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getOrno() {
		return orno;
	}
	public void setOrno(int orno) {
		this.orno = orno;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getDema() {
		return dema;
	}
	public void setDema(String dema) {
		this.dema = dema;
	}
	public String getProg() {
		return prog;
	}
	public void setProg(String prog) {
		this.prog = prog;
	}
	public Timestamp getRegd() {
		return regd;
	}
	public void setRegd(Timestamp regd) {
		this.regd = regd;
	}
	public String getPame() {
		return pame;
	}
	public void setPame(String pame) {
		this.pame = pame;
	}
	public String getPade() {
		return pade;
	}
	public void setPade(String pade) {
		this.pade = pade;
	}
}
