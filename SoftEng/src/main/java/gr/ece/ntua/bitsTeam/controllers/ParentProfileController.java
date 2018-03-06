package gr.ece.ntua.bitsTeam.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import gr.ece.ntua.bitsTeam.model.Activity;
import gr.ece.ntua.bitsTeam.model.Booking;
import gr.ece.ntua.bitsTeam.model.Location;
import gr.ece.ntua.bitsTeam.model.Parent;
import gr.ece.ntua.bitsTeam.model.Photo;
import gr.ece.ntua.bitsTeam.model.jparepos.ActivityRepository;
import gr.ece.ntua.bitsTeam.model.jparepos.ParentRepository;

@Controller
@RequestMapping("/parent")
public class ParentProfileController {

	@Autowired
	private ParentRepository parentRepository;

	@Autowired
	private ActivityRepository activityRepository;

	private Boolean flag = true;

	@RequestMapping()
	public String account(HttpServletRequest request, Model model) {
		// set test objects
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		String email = auth.getName();

		// Long organizerId = (Long)
		// request.getSession().getAttribute("parentId_");
		Parent parent = parentRepository.findByEmail(email);

		model.addAttribute("parent", parent);

		Set<Long> set = new HashSet<>();
		Date date = new Date();
		List<Booking> bookings = parent.getBookings();
		List<Activity> scheduledActivities = new ArrayList<>();
		List<Activity> completedActivities = new ArrayList<>();
		for (Booking booking : bookings) {
			if (!set.contains(booking.getActivity().getActivityId())) {
				set.add(booking.getActivity().getActivityId());
				if (date.compareTo(booking.getActivity().getDate()) < 0) {
					scheduledActivities.add(booking.getActivity());
				} else {
					completedActivities.add(booking.getActivity());
				}
			}
			else {
			}
		}

		model.addAttribute("scheduledBookings", scheduledActivities);
		model.addAttribute("completedBookings", completedActivities);

		return "parent_profile";
	}

}
