package com.computer.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the HINHSANPHAM database table.
 * 
 */
@Entity
@Table(name="HINHSANPHAM")
@NamedQuery(name="Hinhsanpham.findAll", query="SELECT h FROM Hinhsanpham h")
public class Hinhsanpham implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="IDHINHSP")
	private int idhinhsp;

	@Lob
	@Column(name="URL_HINHSP")
	private String urlHinhsp;
	
	@ManyToOne 
    @JoinColumn(name = "IDSP")
    private Sanpham hinhsp;

	public Hinhsanpham() {
	}

	public int getIdhinhsp() {
		return this.idhinhsp;
	}

	public void setIdhinhsp(int idhinhsp) {
		this.idhinhsp = idhinhsp;
	}

	public String getUrlHinhsp() {
		return this.urlHinhsp;
	}

	public void setUrlHinhsp(String urlHinhsp) {
		this.urlHinhsp = urlHinhsp;
	}

	public Sanpham getHinhsp() {
		return hinhsp;
	}

	public void setHinhsp(Sanpham hinhsp) {
		this.hinhsp = hinhsp;
	}
	
}
