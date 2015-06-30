package com.epam.edu.student.service;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

public interface PostData {
	void sendJSONResponse(HttpServletResponse response, JSONArray responceBody);
}
