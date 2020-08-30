package com.computer.service;

import java.util.List;

import com.computer.model.AppUserDTO;

public interface AppUserService {
	public AppUserDTO getUser(String username);
	public AppUserDTO getUser(Long id);
	public boolean addUser(AppUserDTO dto);
	public List<AppUserDTO> getListUser();
	public boolean deactiveUser(Long idUser);
	public boolean activeUser(Long idUser);
}
