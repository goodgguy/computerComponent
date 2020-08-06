package com.computer.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="SANPHAM")
public class Sanpham {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="IDSP")
	private int idsp;
	
	@Column(name="TENSP")
	private String tensp;
	
	@Column(name="GIASP")
	private double giasp;
	
	@Column(name="MOTASP")
	private String motasp;
	
	@Column(name="SOLUONGSP")
	private int soluongsp;
	
	@Column(name="ANHCHINH")
	private String anhchinh;
	
	@ManyToOne 
    @JoinColumn(name = "IDHSX") 
    private Hangsanxuat idhsx;
	
	@ManyToOne 
    @JoinColumn(name = "IDDANHMUCSP") 
    private Danhmucsanpham danhmucsp;
	
	@OneToMany(mappedBy = "chitietkythuatsp", cascade = CascadeType.ALL)
    private Collection<Chitietkythuat> chitietkythuat;

	@OneToMany(mappedBy = "hinhsp", cascade = CascadeType.ALL)
    private Collection<Hinhsanpham> hinhsanpham;
	
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

	public Collection<Chitietkythuat> getChitietkythuat() {
		return chitietkythuat;
	}

	public void setChitietkythuat(Collection<Chitietkythuat> chitietkythuat) {
		this.chitietkythuat = chitietkythuat;
	}

	public Collection<Hinhsanpham> getHinhsanpham() {
		return hinhsanpham;
	}

	public void setHinhsanpham(Collection<Hinhsanpham> hinhsanpham) {
		this.hinhsanpham = hinhsanpham;
	}
	
	
	
	
}
