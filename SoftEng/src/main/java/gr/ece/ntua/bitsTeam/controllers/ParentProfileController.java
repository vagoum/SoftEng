package gr.ece.ntua.bitsTeam.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	private void createTestParent() {
		
		Date date1 = null;
		Date date2 = null;
		Date date3 = null;
		Date date4 = null;

		try {
			date1 = new SimpleDateFormat("MM/dd/yyyy").parse("05/03/2017");
			date2 = new SimpleDateFormat("MM/dd/yyyy").parse("05/03/2019");
			date3 = new SimpleDateFormat("MM/dd/yyyy").parse("05/03/2017");
			date4 = new SimpleDateFormat("MM/dd/yyyy").parse("05/03/2019");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Location location = new Location();
		location.setAddress("Syntagma Square");
		location.setLatitude(37.975543);
		location.setLongtitude(23.734851);
		Parent parent = new Parent();
		parent.setBlocked(false);
		parent.setEmail("andrewhantzos@gmail.com");
		parent.setFirstName("Andreas");
		parent.setLastName("Chantzos");
		parent.setPhone("6940200292");
		parent.setResetPassword(false);
		parent.setBalance(200);
		
		parentRepository.save(parent);

		
		Booking booking1 = new Booking();
		booking1.setParent(parent);
		Booking booking2 = new Booking();
		booking2.setParent(parent);

		Booking booking3 = new Booking();
		booking3.setParent(parent);

		Booking booking4 = new Booking();
		booking4.setParent(parent);

		Photo photo = new Photo();
		photo.setUrl("http://res.cloudinary.com/dtsqo5emw/image/upload/v1519560140/vfmfkjvwdfo4hb2vfqzh.png");
		
		Activity activity1 = new Activity();
		activity1.setActivityDescription("Qui diam libris ei, vidisse incorrupte at mel. His euismod salutandi dissentiunt eu. Habeo offendit ea mea. Nostro blandit sea");
		activity1.setName("Play Football");
		activity1.setDate(date1);
		activity1.setThumbNail(photo);
		activity1.setTime("15:00 AM");
		activity1.setLocation(location);
		activity1.getBookings().add(booking1);
		booking1.setActivity(activity1);
		activity1.setElapsed(true);
		
		Activity activity2 = new Activity();
		activity2.setActivityDescription("Qui diam libris ei, vidisse incorrupte at mel. His euismod salutandi dissentiunt eu. Habeo offendit ea mea. Nostro blandit sea");
		activity2.setName("Play Football");
		activity2.setDate(date2);
		activity2.getBookings().add(booking2);
		activity2.setThumbNail(photo);
		booking2.setActivity(activity2);
		activity2.setLocation(location);
		activity2.setTime("15:00 AM");
		activity2.setElapsed(false);

		Activity activity3 = new Activity();
		activity3.setActivityDescription("Qui diam libris ei, vidisse incorrupte at mel. His euismod salutandi dissentiunt eu. Habeo offendit ea mea. Nostro blandit sea");
		activity3.setName("Play Football");
		activity3.setDate(date3);
		activity3.getBookings().add(booking3);
		activity3.setThumbNail(photo);
		booking3.setActivity(activity3);
		activity3.setLocation(location);
		activity3.setTime("15:00 AM");
		activity3.setElapsed(true);

		Activity activity4 = new Activity();
		activity4.setActivityDescription("Qui diam libris ei, vidisse incorrupte at mel. His euismod salutandi dissentiunt eu. Habeo offendit ea mea. Nostro blandit sea");
		activity4.setName("Play Football");
		activity4.setDate(date4);
		activity4.getBookings().add(booking4);
		activity4.setThumbNail(photo);
		booking4.setActivity(activity4);
		activity4.setLocation(location);
		activity4.setTime("15:00 AM");
		activity4.setElapsed(false);

		activityRepository.save(activity1);
		activityRepository.save(activity3);
		activityRepository.save(activity4);
		activityRepository.save(activity2);

	}
	
	private Boolean flag = true;
	
	@RequestMapping()
	public String account(HttpServletRequest request, Model model) {
		// set test objects
		if (flag) {
			flag = false;
			createTestParent();
		}
		
		// Long parentId = (Long) request.getSession().getAttribute("parentId_");
		Parent parent = parentRepository.findOne((long) 1);
		
        model.addAttribute("parent", parent);

		
        Date date = new Date();
		List<Booking> bookings = parent.getBookings();
		List<Activity> scheduledActivities = new ArrayList<>();
		List<Activity> completedActivities  = new ArrayList<>();
		for(Booking booking: bookings) {
			
			if (booking.getActivity().getElapsed()) {
				completedActivities.add(booking.getActivity());
			}
			else {
				scheduledActivities.add(booking.getActivity());
			}
		}
        
        model.addAttribute("scheduledBookings", scheduledActivities);
        model.addAttribute("completedBookings", completedActivities);
	
		return "parent_profile";
	}

}
