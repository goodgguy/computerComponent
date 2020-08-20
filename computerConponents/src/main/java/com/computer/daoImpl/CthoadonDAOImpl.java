package com.computer.daoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.computer.dao.CthoadonDAO;
import com.computer.entity.Cthoadon;
import com.computer.entity.Hoadon;

@Transactional
@Repository
public class CthoadonDAOImpl implements CthoadonDAO{
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public void addCt(ArrayList<Cthoadon> listhoadon) {
		for(int i=0;i<listhoadon.size();i++)
		{
			entityManager.persist(listhoadon.get(i));
		}
		
	}

	@Override
	public List<Cthoadon> getCtPending() {
		Query query = entityManager.createQuery("Select e from Cthoadon e Where e.hoadon.tinhtrang=0");
		ArrayList<Cthoadon> list=(ArrayList<Cthoadon>) query.getResultList();
		return list;
	}

	@Override
	public List<Cthoadon> getCtConfirmed() {
		Query query = entityManager.createQuery("Select e from Cthoadon e Where e.hoadon.tinhtrang=1");
		ArrayList<Cthoadon> list=(ArrayList<Cthoadon>) query.getResultList();
		return list;
	}

	@Override
	public List<Cthoadon> getCtbyIdHoadon(int idhd) {
		Query query = entityManager.createQuery("Select e from Cthoadon e Where e.hoadon.idhd= "+idhd);
		ArrayList<Cthoadon> list=(ArrayList<Cthoadon>) query.getResultList();
		return list;
	}
	@Override
	public boolean checkQuantity(int idsp,int soluong)
	{
		String jql="Select e from Cthoadon e Where e.sanpham.soluongsp";
	}
}
