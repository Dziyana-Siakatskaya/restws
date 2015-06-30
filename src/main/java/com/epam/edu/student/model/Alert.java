package com.epam.edu.student.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.json.JSONException;
import org.json.JSONObject;

@Entity
@Table(name = "alerts", catalog = "test")
public class Alert {

	public Alert(){
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	Integer id;
	
	
	
	@Column(name = "alertTypeId", unique = false, nullable = false)
	Integer alertTypeId;
	
	@Column(name = "alertMessage", unique = false, nullable = true, length = 100)
	String alertMessage;

	
	
	@Column(name = "alertPosted", unique = false, nullable = false)
	Integer alertPosted;



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public Integer getAlertTypeId() {
		return alertTypeId;
	}



	public void setAlertTypeId(Integer alertTypeId) {
		this.alertTypeId = alertTypeId;
	}



	public String getAlertMessage() {
		return alertMessage;
	}



	public void setAlertMessage(String alertMessage) {
		this.alertMessage = alertMessage;
	}



	public Integer getAlertPosted() {
		return alertPosted;
	}



	public void setAlertPosted(Integer alertPosted) {
		this.alertPosted = alertPosted;
	}
	
	public JSONObject getJSON() {
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.accumulate("id", id);
			jsonObject.accumulate("alertTypeId", alertTypeId);
			jsonObject.accumulate("alertMessage", alertMessage);
			jsonObject.accumulate("alertPosted", alertPosted);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonObject;
	}
	
}
