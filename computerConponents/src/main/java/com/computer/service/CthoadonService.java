package com.computer.service;

import java.util.ArrayList;
import java.util.List;

import com.computer.entity.Cthoadon;
import com.computer.model.CthoadonDTO;
import com.computer.model.HoadonDTO;
public interface CthoadonService {
	public void addCt(HoadonDTO dto,ArrayList<CthoadonDTO>listcthoadondto);
	public List<CthoadonDTO> getCtPending();
	public List<CthoadonDTO> getCtConfirmed();
	public List<CthoadonDTO> getCtbyIdHoadon(int idhd);
	public boolean checkQuantity(int idsp,int soluong);
}
