package gr.ece.ntua.bitsTeam.controllers;

import java.util.ArrayList;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChangePasswordController {

    @GetMapping("/change_password")
    public String index(Locale locale, Model model) {
    	
        return "change_password";
    }
}
