package gr.ece.ntua.bitsTeam.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import gr.ece.ntua.bitsTeam.model.Activity;
import gr.ece.ntua.bitsTeam.model.Categories;
import gr.ece.ntua.bitsTeam.model.Location;
import gr.ece.ntua.bitsTeam.model.Organizer;
import gr.ece.ntua.bitsTeam.model.Photo;
import gr.ece.ntua.bitsTeam.model.jparepos.ActivityRepository;
import gr.ece.ntua.bitsTeam.model.jparepos.OrganizerRepository;

@Controller
public class ActivityController {

	@Autowired
	private ActivityRepository activityRepository;

	@Autowired
	private OrganizerRepository organizerRepository;

	public void createTestActivity() {

		Activity activity = new Activity();
		Photo photo = new Photo();
		photo.setUrl("http://res.cloudinary.com/dtsqo5emw/image/upload/v1519560140/vfmfkjvwdfo4hb2vfqzh.png");

		activity.setThumbNail(photo);
		activity.getPhotos().add(photo);
		activity.getPhotos().add(photo);

		activity.setName("Football");
		activity.setCost(200);
		activity.setTime("15:00 AM");
		activity.setActivityDescription("lorem ipsum kai ta muala sta kagkela");
		activity.setDate(new Date());
		activity.setCategory("Football");
		Location location = new Location();
		location.setAddress("Syntagma Square");
		location.setLatitude(37.975543);
		location.setLongtitude(23.734851);
		activity.setLocation(location);
		Organizer organizer = new Organizer();
		organizer.setBlocked(false);
		organizer.setEmail("andrewhantzos@gmail.com");
		organizer.setFirstName("Andreas");
		organizer.setLastName("Chantzos");
		organizer.setPhone("6940200292");
		organizer.setResetPassword(false);
		organizer.getActivities().add(activity);
		activity.setOrganizer(organizer);

		organizerRepository.save(organizer);

		activityRepository.save(activity);

	}

	@RequestMapping("/activity_view")
	public String viewActivity(@RequestParam(value = "id", required = true) Long activityId, Model model,
			HttpServletRequest request) throws IOException {
		// set test objects

		Activity activity = activityRepository.findOne(activityId);

		Date date = activity.getDate();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int month = cal.get(Calendar.MONTH);
		int year = cal.get(Calendar.YEAR);
		int day = cal.get(Calendar.DAY_OF_MONTH);

		Location loc = activity.getLocation();
		model.addAttribute("activity", activity);
		model.addAttribute("day", day);
		model.addAttribute("month", month);
		model.addAttribute("year", year);
		model.addAttribute("location", loc);

		model.addAttribute("thumbnail", activity.getThumbNail());
		model.addAttribute("photos", activity.getPhotos());
		model.addAttribute("organizer", activity.getOrganizer());
		return "activity_view";
	}

	@PostMapping("/book_activity")
	public String bookActivity(@RequestParam(value = "activityId", required = true) Long activityId, Model model,
			HttpServletRequest request) throws IOException {

		return "index";
	}
	
	@RequestMapping("/organizer_verification_failure")
	public String verificationFailure(Model model,
			HttpServletRequest request) throws IOException {

		return "organizer_verification_failure";
	}

	@GetMapping("/activity_create")
	public String activityIndex(Locale locale, Model model) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		String email = auth.getName();

		// Long organizerId = (Long)
		// request.getSession().getAttribute("parentId_");
		Organizer organizer = organizerRepository.findByEmail(email);
		if (organizer.getVerified()) {
			
			model.addAttribute("categories", new Categories().getCategories());
			return "activity_create";
		}
		return "organizer_verification_failure";
	}
}
