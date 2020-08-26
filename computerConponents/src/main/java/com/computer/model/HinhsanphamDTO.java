package com.computer.model;

import com.computer.entity.Sanpham;

public class HinhsanphamDTO {
	private int idhinhsp;
	private String urlHinhsp;
	private Sanpham hinhsp;
	public int getIdhinhsp() {
		return idhinhsp;
	}
	public void setIdhinhsp(int idhinhsp) {
		this.idhinhsp = idhinhsp;
	}
	public String getUrlHinhsp() {
		return urlHinhsp;
	}
	public void setUrlHinhsp(String urlHinhsp) {
		this.urlHinhsp = urlHinhsp;
	}
	public Sanpham getHinhsp() {
		return hinhsp;
	}
	public void setHinhsp(Sanpham hinhsp) {
		this.hinhsp = hinhsp;
	}
	
}
