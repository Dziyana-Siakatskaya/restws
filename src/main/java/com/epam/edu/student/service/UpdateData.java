package com.epam.edu.student.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.epam.edu.student.model.Alert;

@Transactional
public interface UpdateData {
	void setAllertsStatePosted(List<Alert> list);
	void setAllAllertsStateNotPosted();
}
