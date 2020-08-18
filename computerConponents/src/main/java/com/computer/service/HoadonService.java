package com.computer.service;

import java.util.List;

import com.computer.entity.Hoadon;
import com.computer.model.HoadonDTO;

public interface HoadonService {
	public void addHoadon(HoadonDTO hoadon);
	public HoadonDTO getNewestHoadon();
	public List<HoadonDTO> getCtPending(Long iduser);
	public List<HoadonDTO> getCtConfirmed(Long iduser);
	public List<HoadonDTO> getCtDeleted(Long iduser);
	public void setState(int idhd,int state);
}
