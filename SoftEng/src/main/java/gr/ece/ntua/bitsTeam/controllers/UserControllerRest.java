package gr.ece.ntua.bitsTeam.controllers;

import org.ece.ntua.bitsTeam.jsonWrappers.ParentWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gr.ece.ntua.bitsTeam.model.Location;
import gr.ece.ntua.bitsTeam.model.Organizer;
import gr.ece.ntua.bitsTeam.model.Parent;
import gr.ece.ntua.bitsTeam.service.UserService;

@RestController
public class UserControllerRest {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users/parents/registration", method = RequestMethod.POST,consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public HttpStatus register(ParentWrapper parentWrapper)  {
    	
    	
    	System.out.println(parentWrapper);

    	/*
    	System.out.println("test");
        if (userService.findByEmail(parent.getEmail()) != null) {
        }

        userService.save(parent, "ROLE_PARENT");
        */
        return HttpStatus.OK;
    }
    
    @RequestMapping(value = "/users/organizer/registration", method = RequestMethod.POST,consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public HttpStatus register(Organizer user)  {
    	System.out.println("test");
        if (userService.findByEmail(user.getEmail()) != null) {
        }

        userService.save(user, "ROLE_ORGANIZER");
        return HttpStatus.OK;
    }
    
    
    private Parent wrapperToParent(ParentWrapper parentWrapper) {
    	Parent parent = new Parent();
    	parent.setEmail(parentWrapper.getEmail());
    	parent.setFirstName(parentWrapper.getFirstName());
    	parent.setLastName(parentWrapper.getLastName());
    	parent.setPassword(parentWrapper.getPassword());
    	parent.setPhone(parentWrapper.getPhone());
    	Location location = new Location();
    	// location.setAddress(parentWrapper.getLocation().get("address"));
    	// location.setLongtitude(Double.parseDouble(parentWrapper.getLocation().get("longtitude")));
    	// location.setLatitude(Double.parseDouble(parentWrapper.getLocation().get("latitude")));
    	parent.setLocation(location);
    	return parent;
    }
}