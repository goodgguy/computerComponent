package com.computer.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the HINHANHTRANG database table.
 * 
 */
@Entity
@Table(name="HINHANHTRANG")
public class Hinhanhtrang implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IDHINH")
	private int idhinh;

	@Lob
	@Column(name="HINHFOOTER1")
	private String hinhfooter1;

	@Lob
	@Column(name="HINHFOOTER2")
	private String hinhfooter2;

	@Lob
	@Column(name="HINHFOOTER3")
	private String hinhfooter3;

	@Lob
	@Column(name="HINHHEADER1")
	private String hinhheader1;

	@Lob
	@Column(name="HINHHEADER2")
	private String hinhheader2;

	@Lob
	@Column(name="HINHSLIDESHOW1")
	private String hinhslideshow1;

	@Lob
	@Column(name="HINHSLIDESHOW2")
	private String hinhslideshow2;

	@Lob
	@Column(name="HINHSLIDESHOW3")
	private String hinhslideshow3;

	@Lob
	@Column(name="HINHSLIDESHOW4")
	private String hinhslideshow4;

	public Hinhanhtrang() {
	}

	public int getIdhinh() {
		return this.idhinh;
	}

	public void setIdhinh(int idhinh) {
		this.idhinh = idhinh;
	}

	public String getHinhfooter1() {
		return this.hinhfooter1;
	}

	public void setHinhfooter1(String hinhfooter1) {
		this.hinhfooter1 = hinhfooter1;
	}

	public String getHinhfooter2() {
		return this.hinhfooter2;
	}

	public void setHinhfooter2(String hinhfooter2) {
		this.hinhfooter2 = hinhfooter2;
	}

	public String getHinhfooter3() {
		return this.hinhfooter3;
	}

	public void setHinhfooter3(String hinhfooter3) {
		this.hinhfooter3 = hinhfooter3;
	}

	public String getHinhheader1() {
		return this.hinhheader1;
	}

	public void setHinhheader1(String hinhheader1) {
		this.hinhheader1 = hinhheader1;
	}

	public String getHinhheader2() {
		return this.hinhheader2;
	}

	public void setHinhheader2(String hinhheader2) {
		this.hinhheader2 = hinhheader2;
	}

	public String getHinhslideshow1() {
		return this.hinhslideshow1;
	}

	public void setHinhslideshow1(String hinhslideshow1) {
		this.hinhslideshow1 = hinhslideshow1;
	}

	public String getHinhslideshow2() {
		return this.hinhslideshow2;
	}

	public void setHinhslideshow2(String hinhslideshow2) {
		this.hinhslideshow2 = hinhslideshow2;
	}

	public String getHinhslideshow3() {
		return this.hinhslideshow3;
	}

	public void setHinhslideshow3(String hinhslideshow3) {
		this.hinhslideshow3 = hinhslideshow3;
	}

	public String getHinhslideshow4() {
		return this.hinhslideshow4;
	}

	public void setHinhslideshow4(String hinhslideshow4) {
		this.hinhslideshow4 = hinhslideshow4;
	}

}
