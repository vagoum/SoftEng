package gr.ece.ntua.bitsTeam.controllers;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Transformation;
import com.cloudinary.utils.ObjectUtils;

import gr.ece.ntua.bitsTeam.cloudinary.CloudinaryConfig;
import gr.ece.ntua.bitsTeam.model.Activity;
import gr.ece.ntua.bitsTeam.model.Organizer;
import gr.ece.ntua.bitsTeam.model.Photo;
import gr.ece.ntua.bitsTeam.model.jparepos.ActivityRepository;
import gr.ece.ntua.bitsTeam.model.jparepos.OrganizerRepository;


// binary dependency
import gr.ece.ntua.bitsTeam.watermark.Watermark;


@RestController
public class CreateActivityControllerRest {
	
    @Autowired
    private ActivityRepository activityRepository;

	@Autowired
	private CloudinaryConfig cld;
    
	@Autowired
	private OrganizerRepository organizerRepository;
	
	
    @RequestMapping(value = "/activity/create", method = RequestMethod.POST, consumes = {"multipart/form-data"})
    public String register(@RequestPart("activityData") Activity activity , @RequestParam ArrayList<MultipartFile> files)  {
    	    	
    	System.out.println(activity);
    	System.out.println(files.size());

		activity.setElapsed(false);
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		String email = auth.getName();
		
		// Long organizerId = (Long) request.getSession().getAttribute("parentId_");
		Organizer organizer = organizerRepository.findByEmail(email);
		
		boolean flag = true;
		for (MultipartFile file : files) {
			
			Photo photo = uploadFile(file);
			if (photo.getName() != null)  {
				if (flag) {
					activity.setThumbNail(photo);
					flag = !flag;
				}
				else
					activity.getPhotos().add(photo);
			}
		}
		
		activity.setOrganizer(organizer);
		activityRepository.save(activity);

        return activity.getActivityId().toString();
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