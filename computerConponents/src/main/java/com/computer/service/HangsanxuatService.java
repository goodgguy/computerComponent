package com.computer.service;

import java.util.List;

import com.computer.entity.Hangsanxuat;
import com.computer.model.HangsanxuatDTO;

public interface HangsanxuatService {
	public List<HangsanxuatDTO> getAll();
	public boolean addHangsanxuat(String tenhsx);
}
