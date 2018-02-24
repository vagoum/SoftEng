package gr.ece.ntua.bitsTeam.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gr.ece.ntua.bitsTeam.model.User;
import gr.ece.ntua.bitsTeam.service.UserService;

@RestController
public class UserControllerRest {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users/parents/registration", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> register(@RequestBody User user)  {
        if (userService.findByEmail(user.getEmail()) != null) {
        }

        userService.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}