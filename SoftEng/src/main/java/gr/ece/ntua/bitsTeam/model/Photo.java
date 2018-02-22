package gr.ece.ntua.bitsTeam.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("photo")
public class Photo {

	 	@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;

	    @Basic
	    private String name;

	    @Basic
	    private String image = "";

	    @Basic
	    private Date createdAt = new Date();
	    
	    @Basic	    
	    private String url = "";
	    
	    @Basic
	    private Boolean isThumbnail;
	    
		@OneToOne
	    private ActivityDetails activityDetails;
	    
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getImage() {
			return image;
		}

		public void setImage(String image) {
			this.image = image;
		}

		public Date getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public Boolean getIsThumbnail() {
			return isThumbnail;
		}

		public void setIsThumbnail(Boolean isThumbnail) {
			this.isThumbnail = isThumbnail;
		}

		public ActivityDetails getActivityDetails() {
			return activityDetails;
		}

		public void setActivityDetails(ActivityDetails activityDetails) {
			this.activityDetails = activityDetails;
		}


		
}
