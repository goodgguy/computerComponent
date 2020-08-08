package com.computer.service;

import java.util.ArrayList;
import java.util.List;

import com.computer.model.SanphamDTO;

public interface SanphamService {
	public ArrayList<SanphamDTO> getListSanpham(int pageNumber,int pageSize);
	public SanphamDTO getById(int id);
}
