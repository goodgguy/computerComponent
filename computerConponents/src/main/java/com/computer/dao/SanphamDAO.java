package com.computer.dao;

import java.util.ArrayList;
import java.util.List;

import com.computer.entity.Sanpham;

public interface SanphamDAO {
	public ArrayList<Sanpham> getListSanpham(int pageNumber,int pageSize);
	public ArrayList<Sanpham> getListSanphamtheoCate(int id,int pageNumber,int pageSize);
	public Sanpham getById(int id);
	public boolean truSoluong(Sanpham sp,int soluong);
	public boolean congSoluong(Sanpham sp,int soluong);
	public boolean addSp(Sanpham sanpham);
}
