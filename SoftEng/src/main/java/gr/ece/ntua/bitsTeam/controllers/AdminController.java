package gr.ece.ntua.bitsTeam.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import gr.ece.ntua.bitsTeam.model.Organizer;
import gr.ece.ntua.bitsTeam.model.Parent;
import gr.ece.ntua.bitsTeam.model.jparepos.OrganizerRepository;
import gr.ece.ntua.bitsTeam.model.jparepos.ParentRepository;

@Controller
public class AdminController {

	@Autowired
	private ParentRepository parents;

	@Autowired
	private OrganizerRepository organizers;

	@GetMapping("/admin_panel")
	public String admin_get(Model model, HttpServletRequest request) {

		String param = request.getParameter("manage");
		if (param == null || param.equals("parents")) {
			ArrayList<Parent> parentList = (ArrayList<Parent>) parents.findAll();
			model.addAttribute("userList", parentList);
			model.addAttribute("user_class", 0);
		} else if (param.equals("organizers")) {
			ArrayList<Organizer> organizerList = (ArrayList<Organizer>) organizers.findAll();
			model.addAttribute("userList", organizerList);
			model.addAttribute("user_class", 1);
		}
		return "admin_panel";
	}
}