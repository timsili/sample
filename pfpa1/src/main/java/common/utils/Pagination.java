package common.utils;

public class Pagination {
	private int count;
	private int start;
	private int end;
	private boolean prev;
	private boolean next;
	private int num = 10;
	private Criteria criteria;
	private void calculate() {
		end = (int)(Math.ceil(criteria.getPage() / (double)num) * num);
		start = (end - num) + 1;
		int tmpEnd = (int)(Math.ceil(count / (double)criteria.getArticle()));
		if(end > tmpEnd) {
			end = tmpEnd;
		}
		prev = (start == 1) ? false : true;
		next = (end * criteria.getArticle() >= count) ? false : true;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
		calculate();
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public Criteria getCriteria() {
		return criteria;
	}
	public void setCriteria(Criteria criteria) {
		this.criteria = criteria;
	}
}
