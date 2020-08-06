package com.computer.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CHITIETKYTHUAT database table.
 * 
 */
@Entity
@Table(name="CHITIETKYTHUAT")
public class Chitietkythuat implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="IDCHITIETKT")
	private long idchitietkt;

	@Lob
	@Column(name="CHITIETKT")
	private String chitietkt;

	@Column(name="IDSP")
	private int idsp;

	@Lob
	@Column(name="TENKT")
	private String tenkt;
	
	@ManyToOne 
    @JoinColumn(name = "IDSP")
    private Sanpham chitietkythuatsp;

	public Chitietkythuat() {
	}

	public long getIdchitietkt() {
		return this.idchitietkt;
	}

	public void setIdchitietkt(long idchitietkt) {
		this.idchitietkt = idchitietkt;
	}

	public String getChitietkt() {
		return this.chitietkt;
	}

	public void setChitietkt(String chitietkt) {
		this.chitietkt = chitietkt;
	}

	public int getIdsp() {
		return this.idsp;
	}

	public void setIdsp(int idsp) {
		this.idsp = idsp;
	}

	public String getTenkt() {
		return this.tenkt;
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
