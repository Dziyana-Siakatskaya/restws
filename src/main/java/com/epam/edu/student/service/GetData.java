package com.epam.edu.student.service;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface GetData {
	String getAlerts(int alertID, int alertCount);
}
