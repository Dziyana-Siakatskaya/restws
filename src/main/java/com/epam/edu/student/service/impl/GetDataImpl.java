package com.epam.edu.student.service.impl;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
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
	public String getAlerts(final int alertTypeId, final int alertCount) {
		JSONArray jsonArray = new JSONArray();
		List<Alert> list = getDataDAO.getInstancesOnAllertTypeId(alertTypeId, alertCount);
		
		JSONObject jsonObject;
		try {
			for (Alert temp : list) {
				jsonObject = new JSONObject();
				jsonObject.accumulate("message", temp.getAlertTypeId() + " " + temp.getAlertMessage() + " " + temp.getAlertPosted());
				jsonArray.put(jsonObject);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		updateDataDAO.setAllertsStatePosted(list);
		return jsonArray.toString();
	}

}
