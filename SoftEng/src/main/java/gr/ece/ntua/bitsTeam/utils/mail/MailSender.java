package gr.ece.ntua.bitsTeam.utils.mail;
import java.io.IOException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.lowagie.text.DocumentException;

import gr.ece.ntua.bitsTeam.model.Booking;
import gr.ece.ntua.bitsTeam.model.Parent;
import gr.ece.ntua.bitsTeam.model.ActivityDetails;

public class MailSender {

	private final String serverEmail = "kidA.comp@gmail.com";
	private final String password = "Dimale1Dimale1";
	private Properties props;
	PdfCreator pdfGen;
	
	public MailSender() {
		props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		pdfGen = new PdfCreator();
	}
	
	public void sendBookingConfirmation(Booking booking) {
		ActivityDetails details = booking.getActivity().getActivityDetails();
		
		Parent receiver = booking.getParent();
		String receiverEmail = receiver.getEmail();
		String receiverName = receiver.getFirstName();
		Integer bookingId = booking.getId();
		
		

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(serverEmail, password);
			}
		  });
		
		
		try {

			try {
				pdfGen.createPdf(PdfCreator.RESULT, booking);
			} catch (DocumentException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(serverEmail));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(receiverEmail));
			
			// Message Subject
			message.setSubject("Electronic Ticket from KidA - Booking ID: " + bookingId);
 
	        BodyPart messageBodyPart = new MimeBodyPart();

	        // Message Body
	        messageBodyPart.setText("Dear, " + receiverName +
	        						"\nThis is your Electronic Ticket and Receipt for your activity" +
	        						"\nThank you for choosing us!" + 
	        						"\n\nBest regards,\nKidA" +
	        						"\n\nThis is a system generated e-mail and not possible to respond.\n");
	         
	        Multipart multipart = new MimeMultipart();
	        multipart.addBodyPart(messageBodyPart);

	        // PDF attachment
	        messageBodyPart = new MimeBodyPart();
	        String filename = "/home/dimlek/Downloads/ticket-sample.pdf";
	        DataSource source = new FileDataSource(PdfCreator.RESULT);
	        messageBodyPart.setDataHandler(new DataHandler(source));
	        messageBodyPart.setFileName(PdfCreator.RESULT);
	        multipart.addBodyPart(messageBodyPart);

	        // Send generated message
	        message.setContent(multipart);
			Transport.send(message);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}