package gr.ece.ntua.bitsTeam.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import gr.ece.ntua.bitsTeam.model.ActivityDetails;

@Controller
public class IndexController {
	@RequestMapping("/")
	public String index(Map<String, Object> model) {
		return "index";
	}
	
	


}