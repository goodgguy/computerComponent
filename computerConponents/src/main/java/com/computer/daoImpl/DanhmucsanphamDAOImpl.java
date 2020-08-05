package com.computer.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.computer.dao.DanhmucsanphamDAO;
import com.computer.entity.Danhmucsanpham;

@Transactional
@Repository
public class DanhmucsanphamDAOImpl implements DanhmucsanphamDAO{
	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public List<Danhmucsanpham> getAllDanhmucsanpham() {
		String jql="SELECT e FROM Danhmucsanpham e";
		return entityManager.createQuery(jql,Danhmucsanpham.class).getResultList();
	}

}
