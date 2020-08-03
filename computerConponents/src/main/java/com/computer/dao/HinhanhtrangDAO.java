package com.computer.dao;

import java.util.List;

import com.computer.entity.Hinhanhtrang;;;

public interface HinhanhtrangDAO {
	public List<Hinhanhtrang> getAllHinhanhtrang();
	public void addHinhanhtrang(Hinhanhtrang hinhanh);
	public void deleteHinhanhtrang(Hinhanhtrang hinhanh);
	public void updatehinhanhtrang(Hinhanhtrang hinhanh);
	public Hinhanhtrang getHinhanhtrang(int id);
}
