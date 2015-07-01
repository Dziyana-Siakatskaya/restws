package com.epam.edu.student.dao.impl.mysql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.edu.student.dao.UpdateDataDAO;
import com.epam.edu.student.model.Alert;


@Component(value = "updateDataDAO")
public class UpdateDataDAOImpl implements UpdateDataDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void setAllertsStatePosted(List<Alert> list) {
		Session session = sessionFactory.getCurrentSession();
		for (Alert temp : list) {
			temp.setAlertPosted(1);
			session.saveOrUpdate(temp);
		}
	}

	@Override
	public void setAllAllertsStateNotPosted() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Alert> list = session.createCriteria(Alert.class)
				.list();
		for (Alert temp : list) {
			temp.setAlertPosted(0);
			session.saveOrUpdate(temp);
		}
	}

}
