package gr.ece.ntua.bitsTeam.controllers;

import java.io.IOException;
import java.util.Calendar;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.utils.ObjectUtils;

import gr.ece.ntua.bitsTeam.cloudinary.CloudinaryConfig;
import gr.ece.ntua.bitsTeam.model.Activity;
import gr.ece.ntua.bitsTeam.model.ActivityDetails;
import gr.ece.ntua.bitsTeam.model.Photo;
import gr.ece.ntua.bitsTeam.model.jparepos.ActivityDetailsRepository;
import gr.ece.ntua.bitsTeam.model.jparepos.ActivityRepository;
import gr.ece.ntua.bitsTeam.model.jparepos.PhotoRepository;

@Controller
public class CreateActivityControllerBackup {

	@Autowired
	private ActivityDetailsRepository activityDetailsRepository;
	
	@Autowired
	private ActivityRepository activityRepository;
	
	@Autowired
	private PhotoRepository photoRepository;
	
	@Autowired
	CloudinaryConfig cld;
	
	@RequestMapping(value="/a", method = RequestMethod.GET)
	public String index() {
		return "activity_create";
	}
	
	@RequestMapping(value="/activity_create", method = RequestMethod.GET)
	public String activityForm(ActivityDetails activityDetails) {
		
		return "activity_create";
	}

	@PostMapping("/create_activity")
	public String createUser(@ModelAttribute ActivityDetails ad, @RequestParam("file") MultipartFile file, BindingResult bindingResult) throws IOException {
		if (ad != null) {
			Activity activity = new Activity();
			
			activity.setActivityDetails(ad);
			activity.setElapsed(false);
			

			activityRepository.save(activity);
		}
		if (file != null) {
			Photo photo = new Photo();
			Map uploadResult = cld.upload(file.getBytes(), ObjectUtils.emptyMap());
			java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
			photo.setCreatedAt(date);
			photo.setUrl((String) uploadResult.get("url"));
			photo.setName((String) uploadResult.get("original_filename"));
			photoRepository.save(photo);
			
		}
		return "activity_create";

	}

}