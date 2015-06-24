package com.epam.edu.student.service;

import javax.servlet.http.HttpServletResponse;

public interface PostData {
	void sendJSONResponse(HttpServletResponse response, String responceBody);
}
