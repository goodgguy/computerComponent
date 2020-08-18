package com.computer.model;

import java.util.Collection;

import com.computer.entity.Hoadon;

public class LoaithanhtoanDTO {
	private int idthanhtoan;
	private String tenloaithanhtoan;
	private Collection<Hoadon> hoadon;
	public int getIdthanhtoan() {
		return idthanhtoan;
	}
	public void setIdthanhtoan(int idthanhtoan) {
		this.idthanhtoan = idthanhtoan;
	}
	public String getTenloaithanhtoan() {
		return tenloaithanhtoan;
	}
	public void setTenloaithanhtoan(String tenloaithanhtoan) {
		this.tenloaithanhtoan = tenloaithanhtoan;
	}
	public Collection<Hoadon> getHoadon() {
		return hoadon;
	}
	public void setHoadon(Collection<Hoadon> hoadon) {
		this.hoadon = hoadon;
	}
	
}
