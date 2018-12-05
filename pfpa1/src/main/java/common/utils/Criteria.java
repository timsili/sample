package common.utils;

public class Criteria {
	private int page;
	private int article;
	public Criteria() {
		this.page = 1;
		this.article = 10;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		if(page <= 0) {
			this.page = 1;
		}else {
			this.page = page;
		}
	}
	public int getArticle() {
		return article;
	}
	public void setArticle(int article) {
		if(article <= 0 || article > 100) {
			this.article = 10;
		}else {
			this.article = article;
		}
	}
	public int getStart() {
		int start = (this.page - 1) * article + 1;
		return start;
	}
	public int getEnd() {
		int end = this.page * article;
		return end;
	}
}
