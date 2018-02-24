package gr.ece.ntua.bitsTeam.utils.mail;
import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfWriter;

import gr.ece.ntua.bitsTeam.model.ActivityDetails;
import gr.ece.ntua.bitsTeam.model.Booking;
import gr.ece.ntua.bitsTeam.model.Parent;
 
/**
 * First iText example: Hello World.
 */
public class PdfCreator {
 
    /** Path to the resulting PDF file. */
    public static final String RESULT = "/home/dimlek/test.pdf";
    
    /** Path to the resources. */
    public static final String RESOURCE = "/home/dimlek/Desktop/ticket_pic.png";   

    public PdfCreator() {
    	super();
    }
    
    /**
     * Creates a PDF document.
     * @param filename the path to the new PDF document
     * @throws    DocumentException
     * @throws    IOException
     */
    public void createPdf(String filename, Booking booking)
    throws DocumentException, IOException {
       
    	NumberFormat priceFormat = NumberFormat.getCurrencyInstance(Locale.GERMANY);
    	
    	ActivityDetails details = booking.getActivity().getActivityDetails();
		Parent receiver = booking.getParent();
    	
        Rectangle page = new Rectangle(PageSize.POSTCARD);
        page.setBorder(Rectangle.BOX);
        page.setBorderWidth(5);
        page.setBorderColor(Color.BLACK);
        page.setBackgroundColor(new Color(255, 255, 224));
       
        Document document = new Document(page);
       
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filename));
        //writer.setViewerPreferences(PdfWriter.PageModeUseOC);
        writer.setPdfVersion(PdfWriter.VERSION_1_7);
        //add elements to document
        document.open();
        Font f1=new Font(Font.TIMES_ROMAN,22.0f,Font.BOLDITALIC,Color.BLACK);
        Font f2=new Font(Font.TIMES_ROMAN,10.0f,Font.BOLD,Color.BLACK);
        Font f3=new Font(Font.TIMES_ROMAN,8.0f,Font.NORMAL,Color.BLACK);
        Font f5=new Font(Font.TIMES_ROMAN,12.5f,Font.ITALIC,Color.BLACK);        
        Paragraph text = new Paragraph("Activity Ticket",f1);
        text.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(text);
       
        Image imp = Image.getInstance(RESOURCE);
        imp.scaleToFit(PageSize.POSTCARD.getWidth()/2, PageSize.POSTCARD.getHeight()/2);  
        imp.setAlignment(Image.ALIGN_CENTER);
        document.add(imp);
       
        text = new Paragraph("Booking Details",f5);
        text.setAlignment(Paragraph.ALIGN_LEFT);
        text.setSpacingAfter(10);
        document.add(text);
          
        text = new Paragraph();
        text.setAlignment(Paragraph.ALIGN_LEFT);
        text.add(new Chunk("Booking ID: ",f2));
        text.add(new Chunk(booking.getId().toString(), f3));
        document.add(text);
        
        text = new Paragraph();
        text.setAlignment(Paragraph.ALIGN_LEFT);
        text.add(new Chunk("Activity: ",f2));
        text.add(new Chunk(details.getName(),f3));
        document.add(text);
        
        text = new Paragraph();
        text.setAlignment(Paragraph.ALIGN_LEFT);
        text.add(new Chunk("Location: ",f2));
        String location = details.getLocation().getCity() + ", " + details.getLocation().getAddress() + 
        				", " + details.getLocation().getPostalCode();
        text.add(new Chunk(location ,f3));
        document.add(text);

       
        text = new Paragraph();
        text.setAlignment(Paragraph.ALIGN_LEFT);
        text.add(new Chunk("Firstname:" ,f2));
        text.add(new Chunk(receiver.getFirstName(),f3));
        document.add(text);
        
        text = new Paragraph();
        text.setAlignment(Paragraph.ALIGN_LEFT);
        text.add(new Chunk("Lastname:" ,f2));
        text.add(new Chunk(receiver.getLastName(),f3));
        document.add(text);
       
        text = new Paragraph();
        text.setAlignment(Paragraph.ALIGN_LEFT);
        text.add(new Chunk("No. of Tickets: ",f2));
        text.add(new Chunk(booking.getTicketsBought().toString(),f3));
        document.add(text);
        
        text = new Paragraph();
        text.setAlignment(Paragraph.ALIGN_LEFT);
        text.add(new Chunk("Total cost: ",f2));
        int cost = details.getCost()*booking.getTicketsBought();
        text.add(new Chunk(priceFormat.format(cost) ,f3));
        document.add(text);
       
        document.close();
    }
}