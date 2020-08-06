package com.computer.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;


/**
 * The persistent class for the DANHMUCSANPHAM database table.
 * 
 */
@Entity
@Table(name="DANHMUCSANPHAM")
public class Danhmucsanpham implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="IDDANHMUCSP")
	private int iddanhmucsp;

	@Column(name="TENDANHMUCSP")
	private String tendanhmucsp;
	
	@OneToMany(mappedBy = "danhmucsp", cascade = CascadeType.ALL)
    private Collection<Sanpham> sanpham;

	public Danhmucsanpham() {
	}

	public int getIddanhmucsp() {
		return this.iddanhmucsp;
	}

	public void setIddanhmucsp(int iddanhmucsp) {
		this.iddanhmucsp = iddanhmucsp;
	}

	public String getTendanhmucsp() {
		return this.tendanhmucsp;
	}

	public void setTendanhmucsp(String tendanhmucsp) {
		this.tendanhmucsp = tendanhmucsp;
	}

	public Collection<Sanpham> getSanpham() {
		return sanpham;
	}

	public void setSanpham(Collection<Sanpham> sanpham) {
		this.sanpham = sanpham;
	}
	

}
