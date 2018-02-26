package gr.ece.ntua.bitsTeam;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import gr.ece.ntua.bitsTeam.controllers.UserController;


@SpringBootApplication
public class Application {
		
	public static void main(String[] args) throws IOException {
		SpringApplication.run(Application.class, args);
	}
}
