package cn.tedu.javaweb.vo;

import cn.tedu.javaweb.po.User;

public class UserVo {
	private User user;
	private String npwd;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getNpwd() {
		return npwd;
	}
	public void setNpwd(String npwd) {
		this.npwd = npwd;
	}
	
}
