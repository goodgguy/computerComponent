package com.computer.service;

import com.computer.model.AppUserDTO;

public interface AppUserService {
	public AppUserDTO getUser(String username);
	public boolean addUser(AppUserDTO dto);
}
