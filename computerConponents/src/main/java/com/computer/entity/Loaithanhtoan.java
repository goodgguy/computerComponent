package com.computer.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the LOAITHANHTOAN database table.
 * 
 */
@Entity
@Table(name="LOAITHANHTOAN")
public class Loaithanhtoan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="IDTHANHTOAN")
	private int idthanhtoan;

	@Column(name="LOAITHANHTOAN")
	private String loaithanhtoan;

	public Loaithanhtoan() {
	}

	public int getIdthanhtoan() {
		return this.idthanhtoan;
	}

	public void setIdthanhtoan(int idthanhtoan) {
		this.idthanhtoan = idthanhtoan;
	}

	public String getLoaithanhtoan() {
		return this.loaithanhtoan;
	}

	public void setLoaithanhtoan(String loaithanhtoan) {
		this.loaithanhtoan = loaithanhtoan;
	}

}
