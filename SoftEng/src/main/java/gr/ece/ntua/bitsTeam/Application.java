package gr.ece.ntua.bitsTeam;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cloudinary.Cloudinary;
import com.cloudinary.Singleton;
import com.cloudinary.utils.ObjectUtils;

@SpringBootApplication
public class Application {
	
	
	
	public static void main(String[] args) throws IOException {
		SpringApplication.run(Application.class, args);
		

	}
}
