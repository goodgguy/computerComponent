package com.computer.daoImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.computer.dao.CtkhuyenmaiDAO;
import com.computer.entity.Ctkhuyenmai;

@Transactional
@Repository
public class CtkhuyenmaiDAOImpl implements CtkhuyenmaiDAO{
	
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public Ctkhuyenmai getSpDiscount(int idsp) {
//		return entityManager.createQuery("select e from CTKHUYENMAI e where e.sanpham= :sanpham",Ctkhuyenmai.class)
//		.setParameter("sanpham", idsp).getResultList();
		Ctkhuyenmai ctkm=null;
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	    Date date = new Date();  
	    System.out.print("DATE DATE DATE DATE"+formatter.format(date));
		Query q = entityManager.createQuery("select o from Ctkhuyenmai o where o.khuyenmai.tgbd < :today AND o.khuyenmai.tgkt > :today AND o.sanpham.idsp= :sanpham ",Ctkhuyenmai.class);
		q.setParameter("today",date);
		q.setParameter("sanpham",idsp);
		try{
			ctkm=(Ctkhuyenmai) q.getSingleResult();
		}
			catch (NoResultException nre){
				ctkm=new Ctkhuyenmai();
				ctkm.setGiagiam(0);
				return ctkm;
			}
		return ctkm;
		
	}
}
