package gr.ece.ntua.bitsTeam.cloudinary;


import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Watermark {
	
	private static final int IMG_WIDTH = 350;
	private static final int IMG_HEIGHT = 250;

	
	public byte[] addTextWatermark(String text, BufferedImage sourceImageFile) {
		byte[] imageInByte = null;
		try {
			BufferedImage resizedImage = resizeImage(sourceImageFile);
			Graphics2D g2d = (Graphics2D) resizedImage.getGraphics();

			// initializes necessary graphic properties
			AlphaComposite alphaChannel = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.2f);
			g2d.setComposite(alphaChannel);
			g2d.setColor(Color.BLUE);
			g2d.setFont(new Font("Arial", Font.BOLD, resizedImage.getWidth()/6));
			FontMetrics fontMetrics = g2d.getFontMetrics();
			Rectangle2D rect = fontMetrics.getStringBounds(text, g2d);

			// calculates the coordinate where the String is painted
			int centerX = (resizedImage.getWidth() - (int) rect.getWidth())/6;
			int centerY = resizedImage.getHeight()-IMG_HEIGHT/6;
			//g2d.rotate(-Math.PI/6, centerX, centerY);

			// paints the textual watermark
			g2d.drawString(text, centerX, centerY);

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(resizedImage, "png", baos);
			imageInByte = baos.toByteArray();
			baos.flush();
			baos.close();
			g2d.dispose();

			System.out.println("The tex watermark is added to the image.");

		} catch (IOException ex) {
			System.err.println(ex);
		}
		return imageInByte;
	}

	public BufferedImage resizeImage(BufferedImage originalImage) {
		BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, originalImage.getType());
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
		g.dispose();
		return resizedImage;
	}
	
}
