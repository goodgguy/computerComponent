package com.computer.service;

import java.util.List;

import com.computer.model.HinhanhtrangDTO;



public interface HinhanhtrangService {
	public List<HinhanhtrangDTO> getAllHinhanhtrang();
	public void addHinhanhtrang(HinhanhtrangDTO hinhanh);
	public void deleteHinhanhtrang(int id);
	public void updateHinhanhtrang(HinhanhtrangDTO hinhanh);
}
