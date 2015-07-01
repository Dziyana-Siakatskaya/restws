package com.epam.edu.student.service;

import org.json.JSONArray;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface GetData {
	JSONArray getAlerts(int alertID, int alertCount);
}
