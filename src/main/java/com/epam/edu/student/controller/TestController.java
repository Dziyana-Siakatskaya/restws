package com.epam.edu.student.controller;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.epam.edu.student.messanger.crud.MessangerCRUD;
import com.epam.edu.student.messanger.model.Messanger;
import com.epam.edu.student.service.GetData;
import com.epam.edu.student.service.PostData;
import com.epam.edu.student.service.UpdateData;
import com.epam.edu.student.service.Utils;

@Controller
public class TestController {
	private static final Logger LOG = Logger.getLogger(TestController.class);
	
	@Autowired
	private Utils utils;
	
	@Autowired
	private MessangerCRUD messangerCRUD;
	
	@Autowired
	private GetData getData;
	
	@Autowired
	private PostData postData;
	
	@Autowired
	private UpdateData updateData;
	

	//private final static String RESPONSE_BODY = "(" + "%s" + ")";

	@RequestMapping(value = "/*", method = RequestMethod.GET)
	public String index() {
		/*LOG.debug("MESSAGE LIST1 ");
		List<Messanger> list = messangerCRUD.getAllInstances();
		for (Messanger tempM : list){
			LOG.debug(tempM.toString());
		}
		
		LOG.debug("MESSAGE LIST1 ");
		Messanger temp = messangerCRUD.getMessangerOnId(1);
		LOG.debug(temp.toString());
		Messanger newTemp = new Messanger();
		newTemp.setMessage("Hello!");
		Integer rowId = messangerCRUD.save(newTemp);
		LOG.debug(rowId);
		temp.setMessage("NEW MESSAGE");
		messangerCRUD.update(temp);
		temp = messangerCRUD.getMessangerOnId(1);
		LOG.debug("AFTER UPDATE " + temp.toString());
		messangerCRUD.delete(newTemp);
		
		LOG.debug("MESSAGE LIST2 ");
		List<Messanger> list2 = messangerCRUD.getAllInstances();
		for (Messanger tempM : list2){
			LOG.debug(tempM.toString());
		}*/
		
		return "testpage";
	}

	@RequestMapping(value = "/testjson*", method = RequestMethod.GET)
	public @ResponseBody Messanger getJSON() {
		Messanger message = new Messanger();
		message.setMessage("Hello!");
		return message;
	}

	/*@RequestMapping(value = "/json2/callback.json", method = RequestMethod.GET)
	public void jsonpCallback(@RequestParam("callback") String callback,
			HttpServletResponse response) {
		System.out.println(callback);
		Messanger messanger = new Messanger();
		messanger.setMessage(String.valueOf(utils.getRandom()));
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.print(callback
					+ String.format(RESPONSE_BODY, messanger.getJSON()));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
	}*/

	@RequestMapping(value = "/getAlert", method = RequestMethod.POST)
	public void getAlert(@RequestParam("alertTypeId") int alertTypeId,@RequestParam("alertCount") int alertCount,
			HttpServletResponse response) {
		postData.sendJSONResponse(response, getData.getAlerts(alertTypeId, alertCount));
		
	}
	
	@RequestMapping(value = "/triggerAlert")
	public String triggerAlert() {
		updateData.setAllAllertsStateNotPosted();
		return "triggerAlert";
	}
}
