package com.computer.daoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.computer.dao.HoadonDAO;
import com.computer.entity.Hoadon;
import com.computer.utils.Common;

@Transactional
@Repository
public class HoadonDAOImpl implements HoadonDAO{
	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public void addHoadon(Hoadon hoadon) {
		entityManager.persist(hoadon);
		
		
	}

	@Override
	public Hoadon getNewestHoadon() {
		String jql ="Select f from Hoadon as f order by f.ngaymua desc";
		Query query = entityManager.createQuery (jql,Hoadon.class);
		Hoadon hd=(Hoadon) query.setMaxResults(1).getResultList().get(0);
		return hd;
	}

	@Override
	public List<Hoadon> getCtPending(Long iduser) {
		String jql="";
		if(iduser==-1)
		{
			jql="Select e from Hoadon e Where e.tinhtrang=0 ORDER BY e.ngaymua desc";
		}else
		{
			jql="Select e from Hoadon e Where e.tinhtrang=0 AND e.user.userId= "+iduser +" ORDER BY e.ngaymua desc";
		}
		Query query = entityManager.createQuery(jql);
		ArrayList<Hoadon> list=(ArrayList<Hoadon>) query.getResultList();
		return list;
	}

	@Override
	public List<Hoadon> getCtConfirmed(Long iduser) {
		String jql="";
		if(iduser==-1)
		{
			jql="Select e from Hoadon e Where e.tinhtrang=1 ORDER BY e.ngaymua desc";
		}else
		{
			jql="Select e from Hoadon e Where e.tinhtrang=1 AND e.user.userId= "+iduser +" ORDER BY e.ngaymua desc";
		}
		Query query = entityManager.createQuery(jql);
		ArrayList<Hoadon> list=(ArrayList<Hoadon>) query.getResultList();
		return list;
	}

	@Override
	public void setState(int idhd, int state) {
		String jql="UPDATE Hoadon e SET e.tinhtrang = "+state+" WHERE e.idhd= "+idhd;
		Query query = entityManager.createQuery(jql);
		query.executeUpdate();
	}

	@Override
	public List<Hoadon> getCtDeleted(Long iduser) {
		String jql="";
		if(iduser==-1)
		{
			jql="Select e from Hoadon e Where e.tinhtrang=2 ORDER BY e.ngaymua desc";
		}else
		{
			jql="Select e from Hoadon e Where e.tinhtrang=2 AND e.user.userId= "+iduser +" ORDER BY e.ngaymua desc";
		}
		Query query = entityManager.createQuery(jql);
		ArrayList<Hoadon> list=(ArrayList<Hoadon>) query.getResultList();
		return list;
	}

	@Override
	public Hoadon getById(int idhd) {
		Hoadon hd=entityManager.find(Hoadon.class, idhd);
		return hd;
	}
}
