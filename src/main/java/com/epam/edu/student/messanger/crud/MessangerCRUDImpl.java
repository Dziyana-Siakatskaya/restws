package com.epam.edu.student.messanger.crud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.epam.edu.student.messanger.dao.MessangerDAO;
import com.epam.edu.student.messanger.model.Messanger;

@Component(value = "messangerCRUD")
public class MessangerCRUDImpl implements MessangerCRUD {

	@Autowired
	MessangerDAO messangerDAO;

	@Transactional
	public Integer save(Messanger messanger) {
		return messangerDAO.save(messanger);

	}

	@Transactional
	public void update(Messanger messanger) {
		messangerDAO.update(messanger);
	}

	@Transactional
	public void delete(Messanger messanger) {
		messangerDAO.delete(messanger);
	}

	@Transactional
	public Messanger getMessangerOnId(int id) {
		return messangerDAO.getMessangerOnId(id);
	}

	@Transactional
	public List<Messanger> getAllInstances() {
		return messangerDAO.getAllInstances();
	}

}
