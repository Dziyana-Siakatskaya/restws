package com.epam.edu.student.dao;

import java.util.List;

import com.epam.edu.student.model.Alert;

public interface GetDataDAO {
	List<Alert> getInstancesOnAllertTypeId(int alertTypeId, int alertCount);
}
