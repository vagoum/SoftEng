package gr.ece.ntua.bitsTeam.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	

	@ManyToOne
	private Activity activity;
	
	@ManyToOne
    @JoinColumn(name = "parentUserId")
	private Parent parent;
	
	private Integer ticketsBought;

	private Date timestamp;

	public Booking(Activity activity, Parent parent, Integer ticketsBought, Date timestamp) {
		super();
		this.activity = activity;
		this.parent = parent;
		this.ticketsBought = ticketsBought;
		this.setTimestamp(timestamp);
	}
	
	public Booking() {
		super();
	}

	
	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public Parent getParent() {
		return parent;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}

	public Integer getTicketsBought() {
		return ticketsBought;
	}

	public void setTicketsBought(Integer ticketsBought) {
		this.ticketsBought = ticketsBought;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
}
