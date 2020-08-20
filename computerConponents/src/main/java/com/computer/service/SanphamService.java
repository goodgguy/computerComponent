package com.computer.service;

import java.util.ArrayList;
import java.util.List;

import com.computer.entity.Sanpham;
import com.computer.model.SanphamDTO;

public interface SanphamService {
	public ArrayList<SanphamDTO> getListSanpham(int pageNumber,int pageSize);
	public SanphamDTO getById(int id);
	public ArrayList<SanphamDTO> getListSanphamtheoCate(int id,int pageNumber, int pageSize);
	public boolean truSoluong(SanphamDTO spdto,int soluong);
	public boolean congSoluong(SanphamDTO spdto,int soluong);
}
