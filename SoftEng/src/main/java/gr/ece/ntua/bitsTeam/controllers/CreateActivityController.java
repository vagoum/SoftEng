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
	CloudinaryConfig cld;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(activityValidator);
	}

	@GetMapping("/")
	public String activityIndex(Locale locale, Model model) {
		model.addAttribute("activityDetails", new ActivityDetails());
		return "activity_create";
	}

	/*
	 * Save user object
	 */
	@PostMapping("/activity_create")
	public String activityCreate(@ModelAttribute("activityDetails") @Validated ActivityDetails activityDetails,
			BindingResult result, @RequestParam("file") MultipartFile[] files, Model model) {

		if (result.hasErrors()) {
			return "activity_create";
		}

		if (activityDetails != null) {
			Activity activity = new Activity();

			activity.setActivityDetails(activityDetails);
			activity.setElapsed(false);

			activityRepository.save(activity);
		}

		if (files != null) {
			Watermark watermark = new Watermark();
			for (MultipartFile file : files) {
				Photo photo = new Photo();
				try {
					byte[] imageInByte;

					
					// add watermark to photo
					InputStream in = new ByteArrayInputStream(file.getBytes());
					BufferedImage bImageFromConvert = ImageIO.read(in);
					byte[] b = watermark.addTextWatermark("Kid A", bImageFromConvert);
					Map uploadResult = cld.upload(b, ObjectUtils.asMap(
							  "public_id", "sample_id",
							  "transformation", new Transformation().crop("limit").width(350).height(250)));
					
					
					java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
					photo.setCreatedAt(date);
					photo.setUrl((String) uploadResult.get("url"));
					photo.setName((String) uploadResult.get("original_filename"));
					photoRepository.save(photo);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		return "activity_create";
	}
}
