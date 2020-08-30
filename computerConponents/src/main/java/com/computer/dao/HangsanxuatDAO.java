package com.computer.dao;

import java.util.List;

import com.computer.entity.Hangsanxuat;

public interface HangsanxuatDAO {
	public List<Hangsanxuat> getAll();
	public boolean addHangsanxuat(Hangsanxuat hsx);
}
