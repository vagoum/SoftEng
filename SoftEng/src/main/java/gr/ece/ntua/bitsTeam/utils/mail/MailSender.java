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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.EnvironmentEndpoint;
import org.springframework.boot.actuate.info.EnvironmentInfoContributor;
import org.springframework.core.env.Environment;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailParseException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.lowagie.text.DocumentException;

import gr.ece.ntua.bitsTeam.model.Activity;
import gr.ece.ntua.bitsTeam.model.Booking;
import gr.ece.ntua.bitsTeam.model.Parent;
import gr.ece.ntua.bitsTeam.model.User;

public class MailSender {

	@Autowired
	private JavaMailSender mailSender = new JavaMailSenderImpl();

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

	public void sendBookingEmail(Booking booking) {
		Activity details = booking.getActivity();

		Parent receiver = booking.getParent();
		String receiverEmail = receiver.getEmail();
		String receiverName = receiver.getFirstName();
		Integer bookingId = booking.getId();

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
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
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receiverEmail));

			// Message Subject
			message.setSubject("Electronic Ticket from KidA - Booking ID: " + bookingId);

			BodyPart messageBodyPart = new MimeBodyPart();

			// Message Body
			messageBodyPart
					.setText("Dear, " + receiverName + "\nThis is your Electronic Ticket and Receipt for your activity"
							+ "\nThank you for choosing us!" + "\n\nBest regards,\nKidA"
							+ "\n\nThis is a system generated e-mail and not possible to respond.\n");

			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);

			// PDF attachment
			messageBodyPart = new MimeBodyPart();
			String filename = PdfCreator.RESULT;
			DataSource source = new FileDataSource(filename);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(filename);
			multipart.addBodyPart(messageBodyPart);

			// Send generated message
			message.setContent(multipart);
			Transport.send(message);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	/*
	 * public void sendBookingEmail(Booking booking) { Activity details =
	 * booking.getActivity(); Parent receiver = booking.getParent(); String
	 * receiverEmail = receiver.getEmail(); String receiverName =
	 * receiver.getFirstName(); Integer bookingId = booking.getId(); String
	 * ticketFile = "";
	 * 
	 * try { pdfGen = new PdfCreator(); ticketFile =
	 * pdfGen.createPdf(PdfCreator.RESULT, booking); } catch (DocumentException
	 * e1) { e1.printStackTrace(); } catch (IOException e1) {
	 * e1.printStackTrace(); }
	 * 
	 * String subject = "Electronic Ticket from KidA - Booking ID: " +
	 * bookingId; String body = "Dear, " + receiverName +
	 * "\nThis is your Electronic Ticket and booking confirmation for your activity"
	 * + "\nThank you for choosing us!" + "\n\nBest regards,\nKidA" +
	 * "\n\nThis is a system generated e-mail and not possible to respond.\n";
	 * 
	 * MimeMessage message = mailSender.createMimeMessage();
	 * 
	 * 
	 * try{ MimeMessageHelper email = new MimeMessageHelper(message, true);
	 * 
	 * email.setSubject(subject); email.setText(body);
	 * email.setTo(receiverEmail); email.setFrom("kidA.comp@gmail.com");
	 * 
	 * FileSystemResource file = new FileSystemResource(ticketFile);
	 * email.addAttachment(file.getFilename(), file); } catch
	 * (MessagingException e) { throw new MailParseException(e); }
	 * mailSender.send(message);
	 * 
	 * }
	 */
}