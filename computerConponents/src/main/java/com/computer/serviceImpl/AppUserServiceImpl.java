package com.computer.serviceImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computer.daoImpl.AppUserDAO;
import com.computer.entity.AppUser;
import com.computer.entity.UserRole;
import com.computer.model.AppUserDTO;
import com.computer.service.AppUserService;

@Service
@org.springframework.transaction.annotation.Transactional
public class AppUserServiceImpl implements AppUserService{
	@Autowired
	private AppUserDAO appuserDAO;
	@Override
	public AppUserDTO getUser(String username) {
		AppUser user=appuserDAO.getUser(username);
		AppUserDTO dto=new AppUserDTO();
		dto.setUserId(user.getUserId());
		dto.setUserName(user.getUserName());
		dto.setEncrytedPassword(user.getEncrytedPassword());
		dto.setEnabled(user.isEnabled());
		dto.setSdt_user(user.getSdt_user());
		dto.setCmnd_user(user.getCmnd_user());
		dto.setDiachi(user.getDiachi());
		dto.setHoadon(user.getHoadon());
		return dto;
	}
	@Override
	public boolean addUser(AppUserDTO dto) {
		AppUser user=new AppUser();
		user.setUserId(dto.getUserId());
		user.setUserName(dto.getUserName());
		user.setEncrytedPassword(dto.getEncrytedPassword());
		user.setEnabled(dto.isEnabled());
		user.setSdt_user(dto.getSdt_user());
		user.setCmnd_user(dto.getCmnd_user());
		user.setDiachi(dto.getDiachi());
		user.setHoadon(dto.getHoadon());
		appuserDAO.addUser(user);
		return true;
	}
	@Override
	public List<AppUserDTO> getListUser() {
		List<AppUser> listappuser=appuserDAO.getlistUser();
		List<AppUserDTO> dtos=new ArrayList<AppUserDTO>();
		for(AppUser user:listappuser)
		{
			AppUserDTO dto=new AppUserDTO();
			dto.setUserId(user.getUserId());
			dto.setUserName(user.getUserName());
			dto.setEncrytedPassword(user.getEncrytedPassword());
			dto.setEnabled(user.isEnabled());
			dto.setSdt_user(user.getSdt_user());
			dto.setCmnd_user(user.getCmnd_user());
			dto.setDiachi(user.getDiachi());
			dto.setHoadon(user.getHoadon());
			Collection<UserRole> user_role=user.getUser_role();
			if(user_role.size()>=2)
			{
				dto.setCheckRole(2);
			}
			dtos.add(dto);
		}
		return dtos;
	}
	@Override
	public boolean deactiveUser(Long idUser) {
		appuserDAO.deactiveUser(idUser);
		return false;
	}
	@Override
	public boolean activeUser(Long idUser) {
		appuserDAO.activeUser(idUser);
		return false;
	}
	@Override
	public AppUserDTO getUser(Long id) {
		AppUser user=appuserDAO.getUser(id);
		AppUserDTO dto=new AppUserDTO();
		dto.setUserId(user.getUserId());
		dto.setUserName(user.getUserName());
		dto.setEncrytedPassword(user.getEncrytedPassword());
		dto.setEnabled(user.isEnabled());
		dto.setSdt_user(user.getSdt_user());
		dto.setCmnd_user(user.getCmnd_user());
		dto.setDiachi(user.getDiachi());
		dto.setHoadon(user.getHoadon());
		return dto;
	}
	@Override
	public List<AppUserDTO> getListTopUser() {
		List<Long> listidUser=appuserDAO.listBestUser();
		List<AppUser> listappuser=new ArrayList<AppUser>();
		for(Long id:listidUser)
		{
			AppUser appUser=appuserDAO.getUser(id);
			listappuser.add(appUser);
		}
		List<AppUserDTO> dtos=new ArrayList<AppUserDTO>();
		for(AppUser user:listappuser)
		{
			AppUserDTO dto=new AppUserDTO();
			dto.setUserId(user.getUserId());
			dto.setUserName(user.getUserName());
			dto.setEncrytedPassword(user.getEncrytedPassword());
			dto.setEnabled(user.isEnabled());
			dto.setSdt_user(user.getSdt_user());
			dto.setCmnd_user(user.getCmnd_user());
			dto.setDiachi(user.getDiachi());
			dto.setHoadon(user.getHoadon());
			Collection<UserRole> user_role=user.getUser_role();
			if(user_role.size()>=2)
			{
				dto.setCheckRole(2);
			}
			dtos.add(dto);
		}
		return dtos;
	}
	

}
