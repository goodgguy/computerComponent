package com.computer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "CTHOADON", //
        uniqueConstraints = { //
                @UniqueConstraint(name = "HOADON_SANPHAM_UK", columnNames = { "IDSP", "IDHD" }) })
public class Cthoadon {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "IDCTHOADON", nullable = false)
    private int id;
	
	@Column(name="SOLUONG")
	private int soluong;
	
	@Column(name="TONGGIA")
	private double tonggia;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDSP", nullable = false)
    private Sanpham sanpham;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDHD", nullable = false)
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
