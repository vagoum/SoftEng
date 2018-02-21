package gr.ece.ntua.bitsTeam.model.test;

import java.util.Map;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cloudinary.utils.ObjectUtils;

import gr.ece.ntua.bitsTeam.Application;
import gr.ece.ntua.bitsTeam.cloudinary.CloudinaryConfig;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class CloudinaryTest {

    @Autowired
    CloudinaryConfig cloudc;

    
    @org.junit.Test
	public void uploadTest() {

		cloudc.upload("mortyy.png", ObjectUtils.emptyMap());
		
		Map uploadResult = cloudc.upload("mortyy.png", ObjectUtils.emptyMap());
		System.out.println(uploadResult);
	}
}