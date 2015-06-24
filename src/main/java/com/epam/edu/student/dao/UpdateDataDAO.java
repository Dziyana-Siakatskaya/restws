package com.epam.edu.student.dao;

import java.util.List;

import com.epam.edu.student.model.Alert;

public interface UpdateDataDAO {
	void setAllertsStatePosted(List<Alert> list);
	void setAllAllertsStateNotPosted();
}
