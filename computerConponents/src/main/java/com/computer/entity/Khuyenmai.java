package com.computer.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the KHUYENMAI database table.
 * 
 */
@Entity
@Table(name="KHUYENMAI")
public class Khuyenmai implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="IDKM")
	private int idkm;

	@Column(name="MOTA")
	private String mota;

	@Column(name="TENKM")
	private String tenkm;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="TGBD")
	private Date tgbd;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="TGKT")
	private Date tgkt;

	public Khuyenmai() {
	}

	public int getIdkm() {
		return this.idkm;
	}

	public void setIdkm(int idkm) {
		this.idkm = idkm;
	}

	public String getMota() {
		return this.mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public String getTenkm() {
		return this.tenkm;
	}

	public void setTenkm(String tenkm) {
		this.tenkm = tenkm;
	}

	public Date getTgbd() {
		return this.tgbd;
	}

	public void setTgbd(Date tgbd) {
		this.tgbd = tgbd;
	}

	public Date getTgkt() {
		return this.tgkt;
	}

	public void setTgkt(Date tgkt) {
		this.tgkt = tgkt;
	}

}
