package gr.ece.ntua.bitsTeam.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import gr.ece.ntua.bitsTeam.model.Organizer;
import gr.ece.ntua.bitsTeam.model.Parent;
import gr.ece.ntua.bitsTeam.model.jparepos.OrganizerRepository;
import gr.ece.ntua.bitsTeam.model.jparepos.ParentRepository;

@RestController
public class AdminController {

	@Autowired
	private OrganizerRepository organizerRepository;
	
	@Autowired
	private ParentRepository parentRepository;
	
	@GetMapping("/admin/admin_panel")
	public String returnParentsOrganizers(Locale locale, Model model) throws JsonProcessingException {
		
		List<Parent> parents = parentRepository.findAll();
		List<Organizer> organizers = organizerRepository.findAll();

		Map mp = new HashMap();
		
		mp.put("parents", parents);
		mp.put("organizers", organizers);
		

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(mp);
		return json;
	}
}
