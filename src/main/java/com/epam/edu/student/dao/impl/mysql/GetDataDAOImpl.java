package com.epam.edu.student.dao.impl.mysql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.edu.student.dao.GetDataDAO;
import com.epam.edu.student.model.Alert;

@Component(value = "getDataDAO")
public class GetDataDAOImpl implements GetDataDAO {
	
	@Autowired
	private SessionFactory sessionFactory;


	@SuppressWarnings("unchecked")
	@Override
	public List<Alert> getInstancesOnAllertTypeId(int alertTypeId, int alertCount) {
		Session session = sessionFactory.getCurrentSession();
	
		return session.createCriteria(Alert.class)
				.add(Restrictions.eq("alertTypeId", alertTypeId))
				.add(Restrictions.eq("alertPosted", 0))
				.setMaxResults(alertCount)
				.list();	
		
	}

}
