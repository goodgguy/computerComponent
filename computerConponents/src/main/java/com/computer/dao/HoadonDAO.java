package com.computer.dao;

import java.util.List;

import com.computer.entity.Hoadon;

public interface HoadonDAO {
	public void addHoadon(Hoadon hoadon);
	public Hoadon getNewestHoadon();
	public List<Hoadon> getCtPending(Long iduser);
	public List<Hoadon> getCtConfirmed(Long iduser);
	public List<Hoadon> getCtDeleted(Long iduser);
	public void setState(int idhd,int state);	
	public Hoadon getById(int idhd);
}
