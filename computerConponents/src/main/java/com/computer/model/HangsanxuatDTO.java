package com.computer.model;

import java.util.Collection;

import com.computer.entity.Sanpham;

public class HangsanxuatDTO {
	private int idhsx;
	private String tenhsx;
	private Collection<Sanpham> sanpham;
	public int getIdhsx() {
		return idhsx;
	}
	public void setIdhsx(int idhsx) {
		this.idhsx = idhsx;
	}
	public String getTenhsx() {
		return tenhsx;
	}
	public void setTenhsx(String tenhsx) {
		this.tenhsx = tenhsx;
	}
	public Collection<Sanpham> getSanpham() {
		return sanpham;
	}
	public void setSanpham(Collection<Sanpham> sanpham) {
		this.sanpham = sanpham;
	}
	
}
