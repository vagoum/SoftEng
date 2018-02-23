package gr.ece.ntua.bitsTeam.controllers;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Locale;
import java.util.Map;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Transformation;
import com.cloudinary.utils.ObjectUtils;

import gr.ece.ntua.bitsTeam.cloudinary.CloudinaryConfig;
import gr.ece.ntua.bitsTeam.cloudinary.Watermark;
import gr.ece.ntua.bitsTeam.formValidators.ActivityValidator;
import gr.ece.ntua.bitsTeam.model.Activity;
import gr.ece.ntua.bitsTeam.model.ActivityDetails;
import gr.ece.ntua.bitsTeam.model.Photo;
import gr.ece.ntua.bitsTeam.model.jparepos.ActivityDetailsRepository;
import gr.ece.ntua.bitsTeam.model.jparepos.ActivityRepository;
import gr.ece.ntua.bitsTeam.model.jparepos.PhotoRepository;

@Controller
public class CreateActivityController {

	@Autowired
	private ActivityValidator activityValidator;

	@Autowired
	private ActivityDetailsRepository activityDetailsRepository;

	@Autowired
	private ActivityRepository activityRepository;

	@Autowired
	private PhotoRepository photoRepository;

	@Autowired
	private CloudinaryConfig cld;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(activityValidator);
	}

	@GetMapping("/activity_create")
	public String activityIndex(Locale locale, Model model) {
		model.addAttribute("activityDetails", new ActivityDetails());
		return "activity_create";
	}

	/*
	 * Save user object
	 */
	@PostMapping("/activity_create")
	public String activityCreate(@ModelAttribute("activityDetails") @Validated ActivityDetails activityDetails,
			BindingResult result, @RequestParam("file") MultipartFile[] images, BindingResult  fileUploadingResult, Model model) {

		if (result.hasErrors()) {
			return "activity_create";
		}

		
		if (activityDetails != null && images != null) {
			Activity activity = new Activity();

			activity.setActivityDetails(activityDetails);
			activity.setElapsed(false);

			
			for (MultipartFile file : images) {
				
				Photo photo = uploadFile(file);
				if (photo.getName() != null)  {
					if (activityDetails.getPhotos().size() == 0) {
						activityDetails.setThumbNail(photo);
					}
					activityDetails.getPhotos().add(photo);
				}
				else {
					return "activity_create";
				}
			}
			
			activityRepository.save(activity);
	
		}
		

		return "activity_create";
	}
	

	@Async
	private Photo uploadFile(MultipartFile file) {

		Photo photo = new Photo();
		try {

			Map uploadResult = cld.upload(addWaterMark(file), ObjectUtils.asMap(
					  "transformation", new Transformation().crop("limit").width(350).height(250)));
			
			System.out.println(uploadResult);
			java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
			photo.setCreatedAt(date);
			photo.setUrl((String) uploadResult.get("url"));
			photo.setName((String) uploadResult.get("original_filename"));
			return photo;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	private byte[] addWaterMark(MultipartFile file) throws IOException {
		Watermark watermark = new Watermark();
		InputStream in = new ByteArrayInputStream(file.getBytes());
		BufferedImage bImageFromConvert = ImageIO.read(in);
		byte[] b = watermark.addTextWatermark("Kid A", bImageFromConvert);
		return b;
	}
}
