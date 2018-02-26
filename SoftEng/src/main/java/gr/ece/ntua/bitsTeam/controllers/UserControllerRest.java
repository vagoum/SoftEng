package gr.ece.ntua.bitsTeam.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import gr.ece.ntua.bitsTeam.model.Organizer;
import gr.ece.ntua.bitsTeam.model.Parent;
import gr.ece.ntua.bitsTeam.service.UserService;

@RestController
public class UserControllerRest {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users/parent/registration", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public HttpStatus register(@RequestBody Parent parent)  {
    	
    	
    	System.out.println(parent);

    	
        if (userService.findByEmail(parent.getEmail()) != null) {
        }

        userService.save(parent, "ROLE_PARENT");
        
        return HttpStatus.OK;
    }
    
    @RequestMapping(value = "/users/organizer/registration", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public HttpStatus register(@RequestBody Organizer organizer)  {

        if (userService.findByEmail(organizer.getEmail()) != null) {
        }

        userService.save(organizer, "ROLE_ORGANIZER");
        return HttpStatus.OK;
    }
    
    
}