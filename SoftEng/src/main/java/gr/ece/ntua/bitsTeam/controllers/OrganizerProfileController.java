package gr.ece.ntua.bitsTeam.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import gr.ece.ntua.bitsTeam.jsonClasses.StatisticsWrapper;
import gr.ece.ntua.bitsTeam.model.Activity;
import gr.ece.ntua.bitsTeam.model.Booking;
import gr.ece.ntua.bitsTeam.model.Organizer;
import gr.ece.ntua.bitsTeam.model.Photo;
import gr.ece.ntua.bitsTeam.model.jparepos.ActivityRepository;
import gr.ece.ntua.bitsTeam.model.jparepos.OrganizerRepository;

@Controller
@RequestMapping("/organizer")
public class OrganizerProfileController {

	@Autowired
	private OrganizerRepository organizerRepository;
	
	@Autowired
	private ActivityRepository activityRepository;
	
	private Boolean flag = true;
	
	@RequestMapping()
	public String account(HttpServletRequest request, Model model) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		String email = auth.getName();
		
		// Long organizerId = (Long) request.getSession().getAttribute("parentId_");
		Organizer organizer = organizerRepository.findByEmail(email);

        Date date = new Date();
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(Calendar.getInstance().getTime());
		String currMonth = timeStamp.split("-")[1];
		List<StatisticsWrapper> scheduledActivities = new ArrayList<>();
		List<StatisticsWrapper> completedActivities  = new ArrayList<>();
		int totalRevenue = 0;
		for(Activity activity: organizer.getActivities()) {
			
			StatisticsWrapper wrap = new StatisticsWrapper();
			wrap.setActivity(activity);
			
			String activityMonth = activity.getDate().toString().split("-")[1];
			if (activityMonth.compareTo(currMonth) >= 0) {
				int totalTickets = 0;
				for (Booking booking: activity.getBookings()) {
					String bookingMonth = booking.getTimestamp().toString().split("-")[1];
					if (bookingMonth.compareTo(currMonth) == 0) {
						totalTickets = totalTickets + booking.getTicketsBought();
					}
				}
				totalRevenue = totalRevenue + totalTickets*activity.getCost();
				wrap.setTotalTickets(totalTickets);
			}
						
			
			if (date.compareTo(activity.getDate()) < 0) {
				scheduledActivities.add(wrap);
				
			}
			else {
				completedActivities.add(wrap);
			}
		}
		
		
        model.addAttribute("organizer", organizer);
        model.addAttribute("totalrevenue",totalRevenue);
        model.addAttribute("scheduledActivities", scheduledActivities);
        model.addAttribute("completedActivities", completedActivities);
	
		return "organizer_profile";
	}

}