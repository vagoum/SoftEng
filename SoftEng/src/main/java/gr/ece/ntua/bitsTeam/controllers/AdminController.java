package gr.ece.ntua.bitsTeam.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import gr.ece.ntua.bitsTeam.model.jparepos.OrganizerRepository;
import gr.ece.ntua.bitsTeam.model.jparepos.ParentRepository;

@RestController
public class AdminController {

	@Autowired
	private OrganizerRepository organizerRepository;
	
	@Autowired
	private ParentRepository parentRepository;
	
	@PostMapping("/admin/manageUsers")
	public String manageUsers(HttpEntity<String> httpEntity) {
		String json = httpEntity.getBody();
		System.out.println(json);
		
		return "";
	}
}
