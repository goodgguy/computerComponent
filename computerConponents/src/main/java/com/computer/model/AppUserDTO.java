package com.computer.model;

import java.util.Collection;

import com.computer.entity.Hoadon;

public class AppUserDTO {
	private Long userId;
	private String userName;
	private String encrytedPassword;
	private boolean enabled;
	 private String sdt_user;
	 private String cmnd_user;
	 private String diachi;
	 private Collection<Hoadon> hoadon;
	 private int checkRole;
	 
	public int getCheckRole() {
		return checkRole;
	}
	public void setCheckRole(int checkRole) {
		this.checkRole = checkRole;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEncrytedPassword() {
		return encrytedPassword;
	}
	public void setEncrytedPassword(String encrytedPassword) {
		this.encrytedPassword = encrytedPassword;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public String getSdt_user() {
		return sdt_user;
	}
	public void setSdt_user(String sdt_user) {
		this.sdt_user = sdt_user;
	}
	public String getCmnd_user() {
		return cmnd_user;
	}
	public void setCmnd_user(String cmnd_user) {
		this.cmnd_user = cmnd_user;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public Collection<Hoadon> getHoadon() {
		return hoadon;
	}
	public void setHoadon(Collection<Hoadon> hoadon) {
		this.hoadon = hoadon;
	}
	 

}
