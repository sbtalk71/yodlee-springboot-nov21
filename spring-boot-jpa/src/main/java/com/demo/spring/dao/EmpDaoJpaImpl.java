package com.demo.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.spring.entity.Emp;

@Repository
public class EmpDaoJpaImpl implements EmpDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Emp findEmpById(Integer id) {
		Emp e = em.find(Emp.class, id);
		return e;
	}

	@Override
	@Transactional
	public String save(Emp e) {
		String message = "";

		Emp emp = findEmpById(e.getEmpId());
		if (emp != null) {
			message = "Emp already exists";
		} else {
			em.persist(e);
			message = "saved successfully";

		}
		return message;
	}

	@Override
	public String update(Emp e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Emp> listAll() {
		
		Query query=em.createQuery("select e from Emp as e");
		return query.getResultList();
	}

}
