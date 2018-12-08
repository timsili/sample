package domain;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;

@Alias("productVO")
public class ProductVO {
	private int no;
	private String item; 
//	category
	private String cate;
//	original name of thumb nail
	private String ontn;
//	changed name of thumb nail
	private String cntn;
//	price
	private int pric;
//	options
	private String opti;
//	price of options
	private String proop;
//	product description
	private List<MultipartFile> descr;
//	original name of product description files
	private String ondes;
//	changed name of product description files
	private String cndes;
	private int stock;
//	active or inactive
	private String acti;
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
	public String getOntn() {
		return ontn;
	}
	public void setOntn(String ontn) {
		this.ontn = ontn;
	}
	public String getCntn() {
		return cntn;
	}
	public void setCntn(String cntn) {
		this.cntn = cntn;
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
	public List<MultipartFile> getDescr() {
		return descr;
	}
	public void setDescr(List<MultipartFile> descr) {
		this.descr = descr;
	}
	public String getOndes() {
		return ondes;
	}
	public void setOndes(String ondes) {
		this.ondes = ondes;
	}
	public String getCndes() {
		return cndes;
	}
	public void setCndes(String cndes) {
		this.cndes = cndes;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getActi() {
		return acti;
	}
	public void setActi(String acti) {
		this.acti = acti;
	}
	public Timestamp getRegd() {
		return regd;
	}
	public void setRegd(Timestamp regd) {
		this.regd = regd;
	}
}
