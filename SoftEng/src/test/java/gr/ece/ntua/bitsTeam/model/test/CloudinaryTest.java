package gr.ece.ntua.bitsTeam.model.test;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import javax.imageio.ImageIO;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cloudinary.Transformation;
import com.cloudinary.utils.ObjectUtils;

import gr.ece.ntua.bitsTeam.Application;
import gr.ece.ntua.bitsTeam.cloudinary.CloudinaryConfig;
import gr.ece.ntua.bitsTeam.cloudinary.Watermark;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class CloudinaryTest {

	@Autowired
	CloudinaryConfig cloudc;

	@org.junit.Test
	public void uploadTest() throws IOException {

		Watermark w = new Watermark();

		InputStream is = new BufferedInputStream(new FileInputStream("WatermarkedImage.jpg"));
		
	    BufferedImage image = ImageIO.read(is);
		
		byte[] b = w.addTextWatermark("Kid A", image);
		
		cloudc.upload(b, ObjectUtils.asMap(
				  "public_id", "sample_id",
				  "transformation", new Transformation().crop("limit").width(350).height(250)));
	}
}