package com.computer.model;

import com.computer.entity.Sanpham;

public class ChitietkythuatDTO {
	private long idchitietkt;
	private String chitietkt;
	private String tenkt;
	private Sanpham chitietkythuatsp;
	public long getIdchitietkt() {
		return idchitietkt;
	}
	public void setIdchitietkt(long idchitietkt) {
		this.idchitietkt = idchitietkt;
	}
	public String getChitietkt() {
		return chitietkt;
	}
	public void setChitietkt(String chitietkt) {
		this.chitietkt = chitietkt;
	}
	public String getTenkt() {
		return tenkt;
	}
	public void setTenkt(String tenkt) {
		this.tenkt = tenkt;
	}
	public Sanpham getChitietkythuatsp() {
		return chitietkythuatsp;
	}
	public void setChitietkythuatsp(Sanpham chitietkythuatsp) {
		this.chitietkythuatsp = chitietkythuatsp;
	}
	
}
