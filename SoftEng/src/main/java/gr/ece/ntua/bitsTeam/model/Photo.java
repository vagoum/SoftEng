package gr.ece.ntua.bitsTeam.model;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@DiscriminatorValue("photo")
public class Photo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long imageId;

	private String name = "";

	private String image = "";

	private Date createdAt = new Date();

	private String url = "";

	private Boolean isThumbnail;



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



}
