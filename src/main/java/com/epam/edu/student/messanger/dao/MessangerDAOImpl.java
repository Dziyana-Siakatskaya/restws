package com.epam.edu.student.messanger.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.edu.student.messanger.model.Messanger;

@Component(value = "messangerDAO")
public class MessangerDAOImpl implements MessangerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	
	public Integer save(Messanger messanger) {
		Session session = sessionFactory.getCurrentSession();
		Integer rowId = (Integer) session.save(messanger);
		return rowId;
	}

	public void update(Messanger messanger) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(messanger);
	}

	public void delete(Messanger messanger) {
		Session session = sessionFactory.getCurrentSession();
		Messanger temp = (Messanger) session.load(Messanger.class, messanger.getId());
		session.delete(temp);
	}
	
	public Messanger getMessangerOnId(int id) {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Messanger> list = session.createCriteria(Messanger.class)
				.add(Restrictions.eq("id", id)).list();	
		
		return list.isEmpty() ? null : ((Messanger) list.get(0));
	}

	public List<Messanger> getAllInstances() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Messanger.class);
		@SuppressWarnings("unchecked")
		List<Messanger> list = criteria.list();		
		return list;
	}

}
