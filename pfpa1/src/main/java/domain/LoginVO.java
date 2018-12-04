package domain;

import org.apache.ibatis.type.Alias;

@Alias("loginVO")
public class LoginVO {
	private String id;
	private String pwd;
	private boolean reme;
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
	public boolean isReme() {
		return reme;
	}
	public void setReme(boolean reme) {
		this.reme = reme;
	}
}
