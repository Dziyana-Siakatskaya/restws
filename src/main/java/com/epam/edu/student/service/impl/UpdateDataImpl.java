package com.epam.edu.student.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.edu.student.dao.UpdateDataDAO;
import com.epam.edu.student.model.Alert;
import com.epam.edu.student.service.UpdateData;


@Component(value = "updateData")
public class UpdateDataImpl implements UpdateData {
	
	@Autowired
	private UpdateDataDAO updateDataDAO;

	@Override
	public void setAllertsStatePosted(List<Alert> list) {
		updateDataDAO.setAllertsStatePosted(list);
	}

	@Override
	public void setAllAllertsStateNotPosted() {
		updateDataDAO.setAllAllertsStateNotPosted();
		
	}
	


}
