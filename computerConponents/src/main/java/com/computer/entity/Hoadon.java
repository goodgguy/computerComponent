package com.computer.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="HOADON")
public class Hoadon {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IDHD")
	private int idhd;
	
	@Column(name="TINHTRANG")
	private int tinhtrang;
	
	@Column(name="NGAYMUA")
	@Temporal(TemporalType.DATE)
	private Date ngaymua;
	
	@ManyToOne 
    @JoinColumn(name = "IDTHANHTOAN")
    private Loaithanhtoan loaithanhtoan;
	
	
	@ManyToOne 
    @JoinColumn(name = "USER_ID")
    private AppUser user;

	public int getIdhd() {
		return idhd;
	}

	public void setIdhd(int idhd) {
		this.idhd = idhd;
	}
	
	public int getTinhtrang() {
		return tinhtrang;
	}

	public void setTinhtrang(int tinhtrang) {
		this.tinhtrang = tinhtrang;
	}

	public Date getNgaymua() {
		return ngaymua;
	}

	public void setNgaymua(Date ngaymua) {
		this.ngaymua = ngaymua;
	}

	public Loaithanhtoan getLoaithanhtoan() {
		return loaithanhtoan;
	}

	public void setLoaithanhtoan(Loaithanhtoan loaithanhtoan) {
		this.loaithanhtoan = loaithanhtoan;
	}

	public AppUser getUser() {
		return user;
	}

	public void setUser(AppUser user) {
		this.user = user;
	}
	
}
