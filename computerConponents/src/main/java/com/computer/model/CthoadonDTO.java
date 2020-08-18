package com.computer.model;

import com.computer.entity.Hoadon;
import com.computer.entity.Sanpham;

public class CthoadonDTO {
	private int id;
	private int soluong;
	private double tonggia;
	private Sanpham sanpham;
	private Hoadon hoadon;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public double getTonggia() {
		return tonggia;
	}
	public void setTonggia(double tonggia) {
		this.tonggia = tonggia;
	}
	public Sanpham getSanpham() {
		return sanpham;
	}
	public void setSanpham(Sanpham sanpham) {
		this.sanpham = sanpham;
	}
	public Hoadon getHoadon() {
		return hoadon;
	}
	public void setHoadon(Hoadon hoadon) {
		this.hoadon = hoadon;
	}
}
