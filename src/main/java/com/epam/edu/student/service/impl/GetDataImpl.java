package com.epam.edu.student.service.impl;

import java.util.List;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.edu.student.dao.GetDataDAO;
import com.epam.edu.student.dao.UpdateDataDAO;
import com.epam.edu.student.model.Alert;
import com.epam.edu.student.service.GetData;
import com.epam.edu.student.service.Utils;


@Component(value = "getData")
public class GetDataImpl implements GetData {

	@Autowired
	private Utils utils;

	@Autowired
	private GetDataDAO getDataDAO;
	
	@Autowired
	private UpdateDataDAO updateDataDAO;
	
	@Override
	public JSONArray getAlerts(final int alertTypeId, final int alertCount) {
		JSONArray jsonArray = new JSONArray();
		List<Alert> list = getDataDAO.getInstancesOnAllertTypeId(alertTypeId, alertCount);
		
		for (Alert temp : list) {
			jsonArray.put(temp.getJSON());
		}
		updateDataDAO.setAllertsStatePosted(list);
		return jsonArray;
	}

}
