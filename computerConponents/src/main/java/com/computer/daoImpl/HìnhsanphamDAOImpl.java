package com.computer.daoImpl;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.computer.dao.HinhsanphamDAO;
import com.computer.entity.Hinhsanpham;

@Transactional
@Repository
public class HìnhsanphamDAOImpl implements HinhsanphamDAO{
	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public boolean addHinh(Hinhsanpham hinhsp) {
		entityManager.persist(hinhsp);
		return false;
	}

	@Override
	public boolean deleteHinh(Hinhsanpham hinhsp) {
		entityManager.remove(entityManager.contains(hinhsp) ? hinhsp : entityManager.merge(hinhsp));
		return false;
	}

}
