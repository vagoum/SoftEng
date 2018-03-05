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
	
	private void createTestOrganizer() {
		
		Date date1 = null;
		Date date2 = null;
		Date date3 = null;
		Date date4 = null;

		try {
			date1 = new SimpleDateFormat("yyyy-MM-dd").parse("2017-03-05");
			date2 = new SimpleDateFormat("yyyy-MM-dd").parse("2019-03-05");
			date3 = new SimpleDateFormat("yyyy-MM-dd").parse("2019-03-05");
			date4 = new SimpleDateFormat("yyyy-MM-dd").parse("2016-03-05");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		Organizer organizer = new Organizer();
		organizer.setBlocked(false);
		organizer.setEmail("andrewhantzos@gmail.com");
		organizer.setFirstName("Andreas");
		organizer.setLastName("Chantzos");
		organizer.setPhone("6940200292");
		organizer.setResetPassword(false);
		

		Photo photo = new Photo();
		photo.setUrl("http://res.cloudinary.com/dtsqo5emw/image/upload/v1519560140/vfmfkjvwdfo4hb2vfqzh.png");
		
		Activity activity1 = new Activity();
		activity1.setActivityDescription("Qui diam libris ei, vidisse incorrupte at mel. His euismod salutandi dissentiunt eu. Habeo offendit ea mea. Nostro blandit sea");
		activity1.setName("Play Football");
		activity1.setDate(date1);
		activity1.setThumbNail(photo);
		activity1.setOrganizer(organizer);

		Activity activity2 = new Activity();
		activity2.setActivityDescription("Qui diam libris ei, vidisse incorrupte at mel. His euismod salutandi dissentiunt eu. Habeo offendit ea mea. Nostro blandit sea");
		activity2.setName("Play Football");
		activity2.setDate(date2);
		activity2.setThumbNail(photo);
		activity2.setOrganizer(organizer);

		Activity activity3 = new Activity();
		activity3.setActivityDescription("Qui diam libris ei, vidisse incorrupte at mel. His euismod salutandi dissentiunt eu. Habeo offendit ea mea. Nostro blandit sea");
		activity3.setName("Play Football");
		activity3.setDate(date3);
		activity3.setThumbNail(photo);
		activity3.setOrganizer(organizer);

		Activity activity4 = new Activity();
		activity4.setActivityDescription("Qui diam libris ei, vidisse incorrupte at mel. His euismod salutandi dissentiunt eu. Habeo offendit ea mea. Nostro blandit sea");
		activity4.setName("Play Football");
		activity4.setDate(date4);
		activity4.setThumbNail(photo);
		activity4.setOrganizer(organizer);

		organizer.getActivities().add(activity4);
		organizer.getActivities().add(activity3);
		organizer.getActivities().add(activity2);
		organizer.getActivities().add(activity1);
	
		organizerRepository.save(organizer);

		activityRepository.save(activity1);
		activityRepository.save(activity3);
		activityRepository.save(activity4);
		activityRepository.save(activity2);

	}
	
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