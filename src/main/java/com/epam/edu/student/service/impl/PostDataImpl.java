package com.epam.edu.student.service.impl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.springframework.stereotype.Component;

import com.epam.edu.student.service.PostData;

@Component(value = "postData")
public class PostDataImpl implements PostData {
	private final static String RESPONSE_BODY = "(" + "%s" + ")";

	@Override
	public void sendJSONResponse(HttpServletResponse response, JSONArray responceBody) {
		response.setContentType("application/json; charset=UTF-8");

		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.print(responceBody);
			//out.print(String.format(RESPONSE_BODY, responceBody));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
	}

}
