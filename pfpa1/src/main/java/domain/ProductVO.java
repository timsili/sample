package domain;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

@Alias("productVO")
public class ProductVO {
	private int no;
	private String item; 
//	category
	private String cate;
//	price
	private int pric;
//	options
	private String opti;
//	price of options
	private String proop;
//	description of product
	private String descr;
	private int stock;
//	active or inactive
	private int acti;
//	registration date
	private Timestamp regd;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getCate() {
		return cate;
	}
	public void setCate(String cate) {
		this.cate = cate;
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
	public String getProop() {
		return proop;
	}
	public void setProop(String proop) {
		this.proop = proop;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
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
	public int getActi() {
		return acti;
	}
	public void setActi(int acti) {
		this.acti = acti;
	}
}
