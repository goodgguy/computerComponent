package com.computer.model;

import java.util.Date;

import com.computer.entity.AppUser;
import com.computer.entity.Loaithanhtoan;

public class HoadonDTO {
	private int idhd;
	private int tinhtrang;
	private Date ngaymua;
	private Loaithanhtoan loaithanhtoan;
	private AppUser user;
	public int getIdhd() {
		return idhd;
	}
	public void setIdhd(int idhd) {
		this.idhd = idhd;
	}
	public int getTinhtrang() {
		return tinhtrang;
	}
	public void setTinhtrang(int tinhtrang) {
		this.tinhtrang = tinhtrang;
	}
	public Date getNgaymua() {
		return ngaymua;
	}
	public void setNgaymua(Date ngaymua) {
		this.ngaymua = ngaymua;
	}
	public Loaithanhtoan getLoaithanhtoan() {
		return loaithanhtoan;
	}
	public void setLoaithanhtoan(Loaithanhtoan loaithanhtoan) {
		this.loaithanhtoan = loaithanhtoan;
	}
	public AppUser getUser() {
		return user;
	}
	public void setUser(AppUser user) {
		this.user = user;
	}
	
}
