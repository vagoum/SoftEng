package gr.ece.ntua.bitsTeam.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("parent")
public class Parent extends User {

	
	@OneToOne(fetch = FetchType.EAGER)
	private Location location;

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
	
}
