package com.computer.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;


/**
 * The persistent class for the HANGSANXUAT database table.
 * 
 */
@Entity
@Table(name="HANGSANXUAT")
public class Hangsanxuat implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IDHSX")
	private int idhsx;

	@Column(name="TENHSX")
	private String tenhsx;
	
	@OneToMany(mappedBy = "idhsx", cascade = CascadeType.ALL)
    private Collection<Sanpham> sanpham;

	public Hangsanxuat() {
	}

	public int getIdhsx() {
		return this.idhsx;
	}

	public void setIdhsx(int idhsx) {
		this.idhsx = idhsx;
	}

	public String getTenhsx() {
		return this.tenhsx;
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
