package com.computer.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computer.dao.CtkhuyenmaiDAO;
import com.computer.entity.Ctkhuyenmai;
import com.computer.service.CtkhuyenmaiService;

@Service
@org.springframework.transaction.annotation.Transactional
public class CtkhuyenmaiServiceImpl implements CtkhuyenmaiService{
	@Autowired
	CtkhuyenmaiDAO chitietkhuyenmaiDAO;

	@Override
	public int getDiscountProduct(int idsp) {
		Ctkhuyenmai ctkm=chitietkhuyenmaiDAO.getSpDiscount(idsp);
		return ctkm.getGiagiam();
	}
}
