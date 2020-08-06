package com.computer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "CTKHUYENMAI", //
        uniqueConstraints = { //
                @UniqueConstraint(name = "KHUYENMAI_SANPHAM_UK", columnNames = { "IDSP", "IDKM" }) })
public class Ctkhuyenmai {
	@Id
    @GeneratedValue
    @Column(name = "IDCTKHUYENMAI", nullable = false)
    private int id;
	
	@Column(name="GIAGIAM")
	private int giagiam;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDSP", nullable = false)
    private Sanpham sanpham;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDKM", nullable = false)
    private Khuyenmai khuyenmai;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getGiagiam() {
		return giagiam;
	}

	public void setGiagiam(int giagiam) {
		this.giagiam = giagiam;
	}

	public Sanpham getSanpham() {
		return sanpham;
	}

	public void setSanpham(Sanpham sanpham) {
		this.sanpham = sanpham;
	}

	public Khuyenmai getKhuyenmai() {
		return khuyenmai;
	}

	public void setKhuyenmai(Khuyenmai khuyenmai) {
		this.khuyenmai = khuyenmai;
	}
	
	
	
}
