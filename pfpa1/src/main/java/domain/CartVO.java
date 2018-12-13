package domain;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

@Alias("cartVO")
public class CartVO {
	private int no;
	private String id;
	private String cate;
	private String item;
	private int pric;
	private String opti;
	private int proop;
	private int stock;
	private Timestamp regd;
	private int orno;
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
	public String getCate() {
		return cate;
	}
	public void setCate(String cate) {
		this.cate = cate;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public int getPric() {
		return pric;
	}
	public void setPric(int pric) {
		this.pric = pric;
	}
	public String getOpti() {
		return opti;
	}
	public void setOpti(String opti) {
		this.opti = opti;
	}
	public int getProop() {
		return proop;
	}
	public void setProop(int proop) {
		this.proop = proop;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public Timestamp getRegd() {
		return regd;
	}
	public void setRegd(Timestamp regd) {
		this.regd = regd;
	}
	public int getOrno() {
		return orno;
	}
	public void setOrno(int orno) {
		this.orno = orno;
	}
}
