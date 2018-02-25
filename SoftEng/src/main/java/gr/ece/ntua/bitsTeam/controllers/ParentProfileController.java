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
import gr.ece.ntua.bitsTeam.model.ActivityDetails;
import gr.ece.ntua.bitsTeam.model.Booking;
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
			date1 = new SimpleDateFormat("yyyy-MM-dd").parse("2017-03-05");
			date2 = new SimpleDateFormat("yyyy-MM-dd").parse("2019-03-05");
			date3 = new SimpleDateFormat("yyyy-MM-dd").parse("2019-03-05");
			date4 = new SimpleDateFormat("yyyy-MM-dd").parse("2016-03-05");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		Parent parent = new Parent();
		parent.setBlocked(false);
		parent.setEmail("andrewhantzos@gmail.com");
		parent.setFirstName("Andreas");
		parent.setLastName("Chantzos");
		parent.setPhone("6940200292");
		parent.setResetPassword(false);
		parent.setPointBalance(200);
		
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
		ActivityDetails activityDetails1 = new ActivityDetails();
		activityDetails1.setActivityDescription("Qui diam libris ei, vidisse incorrupte at mel. His euismod salutandi dissentiunt eu. Habeo offendit ea mea. Nostro blandit sea");
		activityDetails1.setName("Play Football");
		activityDetails1.setDate(date1);
		activityDetails1.setThumbNail(photo);
		
		activity1.setActivityDetails(activityDetails1);
		activity1.getBookings().add(booking1);
		booking1.setActivity(activity1);

		Activity activity2 = new Activity();
		ActivityDetails activityDetails2 = new ActivityDetails();
		activityDetails2.setActivityDescription("Qui diam libris ei, vidisse incorrupte at mel. His euismod salutandi dissentiunt eu. Habeo offendit ea mea. Nostro blandit sea");
		activityDetails2.setName("Play Football");
		activityDetails2.setDate(date2);
		activity2.setActivityDetails(activityDetails2);
		activity2.getBookings().add(booking2);
		activityDetails2.setThumbNail(photo);
		booking2.setActivity(activity2);

		Activity activity3 = new Activity();
		ActivityDetails activityDetails3 = new ActivityDetails();
		activityDetails3.setActivityDescription("Qui diam libris ei, vidisse incorrupte at mel. His euismod salutandi dissentiunt eu. Habeo offendit ea mea. Nostro blandit sea");
		activityDetails3.setName("Play Football");
		activityDetails3.setDate(date3);
		activity3.setActivityDetails(activityDetails3);
		activity3.getBookings().add(booking3);
		activityDetails3.setThumbNail(photo);
		booking3.setActivity(activity3);

		Activity activity4 = new Activity();
		ActivityDetails activityDetails4 = new ActivityDetails();
		activityDetails4.setActivityDescription("Qui diam libris ei, vidisse incorrupte at mel. His euismod salutandi dissentiunt eu. Habeo offendit ea mea. Nostro blandit sea");
		activityDetails4.setName("Play Football");
		activityDetails4.setDate(date4);
		activity4.setActivityDetails(activityDetails4);
		activity4.getBookings().add(booking4);
		activityDetails4.setThumbNail(photo);
		booking4.setActivity(activity4);

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
		List<ActivityDetails> scheduledActivities = new ArrayList<>();
		List<ActivityDetails> completedActivities  = new ArrayList<>();
		for(Booking booking: bookings) {
			
			if (date.compareTo(booking.getActivity().getActivityDetails().getDate()) < 0) {
				scheduledActivities.add(booking.getActivity().getActivityDetails());
			}
			else {
				completedActivities.add(booking.getActivity().getActivityDetails());
			}
		}
        
        model.addAttribute("scheduledBookings", scheduledActivities);
        model.addAttribute("completedBookings", completedActivities);
	
		return "parent_profile";
	}

}
