package com.computer.model;

public class DanhmucsanphamDTO {
	private int iddanhmucsp;
	private String tendanhmucsp;
	public DanhmucsanphamDTO() {
	}
	public DanhmucsanphamDTO(int iddanhmucsp, String tendanhmucsp) {
		super();
		this.iddanhmucsp = iddanhmucsp;
		this.tendanhmucsp = tendanhmucsp;
	}
	public int getIddanhmucsp() {
		return iddanhmucsp;
	}
	public void setIddanhmucsp(int iddanhmucsp) {
		this.iddanhmucsp = iddanhmucsp;
	}
	public String getTendanhmucsp() {
		return tendanhmucsp;
	}
	public void setTendanhmucsp(String tendanhmucsp) {
		this.tendanhmucsp = tendanhmucsp;
	}
	
	
}
