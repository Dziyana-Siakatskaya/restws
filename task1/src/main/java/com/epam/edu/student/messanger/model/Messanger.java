package com.epam.edu.student.messanger.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.json.JSONException;
import org.json.JSONObject;

@Entity
@Table(name = "messanger", catalog = "test")
public class Messanger {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	Integer id;
	
	@Column(name = "message", unique = false, nullable = false, length = 45)
	String message;

	
	public Messanger() {

	}

	
	
	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getJSON() {
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.accumulate("message", message);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonObject.toString();
	}



	@Override
	public String toString() {
		return "Messanger [id=" + id + ", message=" + message + "]";
	}
	
	

}
