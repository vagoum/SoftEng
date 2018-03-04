package gr.ece.ntua.bitsTeam.model;

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

	public Booking(Activity activity, Parent parent, Integer ticketsBought) {
		super();
		this.activity = activity;
		this.parent = parent;
		this.ticketsBought = ticketsBought;
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
	
}
