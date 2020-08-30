package com.computer.daoImpl;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.computer.dao.SanphamDAO;
import com.computer.entity.Sanpham;

@Transactional
@Repository
public class SanphamDAOImpl implements SanphamDAO{
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public ArrayList<Sanpham> getListSanpham(int pageNumber,int pageSize) {
		
		Query query = entityManager.createQuery("From Sanpham");
		query.setFirstResult((pageNumber-1) * pageSize); 
		query.setMaxResults(pageSize);
		ArrayList <Sanpham> listSanpham = (ArrayList<Sanpham>) query.getResultList();
		return listSanpham;

	}

	@Override
	public Sanpham getById(int id) {
		return entityManager.find(Sanpham.class, id);
	}

	@Override
	public ArrayList<Sanpham> getListSanphamtheoCate(int id,int pageNumber, int pageSize) {
		Query query = entityManager.createQuery("Select e from Sanpham e Where e.danhmucsp.iddanhmucsp="+id);
		query.setFirstResult((pageNumber-1) * pageSize); 
		query.setMaxResults(pageSize);
		ArrayList <Sanpham> listSanpham = (ArrayList<Sanpham>) query.getResultList();
		return listSanpham;
	}

	@Override
	public boolean truSoluong(Sanpham sp, int soluong) {
		int soluonglucsau=sp.getSoluongsp()-soluong;
		String jql="UPDATE Sanpham e SET e.soluongsp= "+soluonglucsau +" Where e.idsp= "+sp.getIdsp();
		Query query=entityManager.createQuery(jql);
		int rowUpdated=query.executeUpdate();
		return true;
	}

	@Override
	public boolean congSoluong(Sanpham sp, int soluong) {
		int soluonglucsau=sp.getSoluongsp()+soluong;
		String jql="UPDATE Sanpham e SET e.soluongsp= "+soluonglucsau +" Where e.idsp= "+sp.getIdsp();
		System.out.print("TEST TEST  "+jql);
		Query query=entityManager.createQuery(jql);
		int rowUpdated=query.executeUpdate();
		return true;
	}

	@Override
	public boolean addSp(Sanpham sanpham) {
		entityManager.persist(sanpham);
		return true;
	}

	@Override
	public boolean deleteSp(Sanpham sanpham) {
		entityManager.remove(entityManager.contains(sanpham) ? sanpham : entityManager.merge(sanpham));
		return false;
	}

}
