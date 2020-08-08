package com.computer.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.computer.entity.Chitietkythuat;
import com.computer.entity.Danhmucsanpham;
import com.computer.entity.Hangsanxuat;
import com.computer.entity.Hinhsanpham;

public class SanphamDTO {
	private int idsp;
	private String tensp;
	private double giasp;
	private String motasp;
	private int soluongsp;
	private String anhchinh;
	private Hangsanxuat idhsx;
	private Danhmucsanpham danhmucsp;
	private List<Chitietkythuat> chitietkythuat;
	private List<Hinhsanpham> hinhsanpham;
	public int getIdsp() {
		return idsp;
	}
	public void setIdsp(int idsp) {
		this.idsp = idsp;
	}
	public String getTensp() {
		return tensp;
	}
	public void setTensp(String tensp) {
		this.tensp = tensp;
	}
	public double getGiasp() {
		return giasp;
	}
	public void setGiasp(double giasp) {
		this.giasp = giasp;
	}
	public String getMotasp() {
		return motasp;
	}
	public void setMotasp(String motasp) {
		this.motasp = motasp;
	}
	public int getSoluongsp() {
		return soluongsp;
	}
	public void setSoluongsp(int soluongsp) {
		this.soluongsp = soluongsp;
	}
	public String getAnhchinh() {
		return anhchinh;
	}
	public void setAnhchinh(String anhchinh) {
		this.anhchinh = anhchinh;
	}
	public Hangsanxuat getIdhsx() {
		return idhsx;
	}
	public void setIdhsx(Hangsanxuat idhsx) {
		this.idhsx = idhsx;
	}
	public Danhmucsanpham getDanhmucsp() {
		return danhmucsp;
	}
	public void setDanhmucsp(Danhmucsanpham danhmucsp) {
		this.danhmucsp = danhmucsp;
	}
	public List<Chitietkythuat> getChitietkythuat() {
		return chitietkythuat;
	}
	public void setChitietkythuat(List<Chitietkythuat> chitietkythuat) {
		this.chitietkythuat = chitietkythuat;
	}
	public List<Hinhsanpham> getHinhsanpham() {
		return hinhsanpham;
	}
	public void setHinhsanpham(List<Hinhsanpham> hinhsanpham) {
		this.hinhsanpham = hinhsanpham;
	}
	
	
}
