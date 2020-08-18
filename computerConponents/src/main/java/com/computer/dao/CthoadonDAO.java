package com.computer.dao;

import java.util.ArrayList;
import java.util.List;

import com.computer.entity.Cthoadon;


public interface CthoadonDAO {
	public void addCt(ArrayList<Cthoadon> listhoadon);
	public List<Cthoadon> getCtPending();
	public List<Cthoadon> getCtConfirmed();
	public List<Cthoadon> getCtbyIdHoadon(int idhd);
}
