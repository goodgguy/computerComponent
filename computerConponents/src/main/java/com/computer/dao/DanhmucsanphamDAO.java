package com.computer.dao;

import java.util.List;

import com.computer.entity.Danhmucsanpham;
public interface DanhmucsanphamDAO {
	public List<Danhmucsanpham> getAllDanhmucsanpham();
	public boolean addDanhmuc(Danhmucsanpham dmsp);
}
