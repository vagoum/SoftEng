package gr.ece.ntua.bitsTeam.jsonClasses;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "text", "latitude", "longtitude", "proximity", "age_min", "age_max", "cost_min", "cost_max",
		"category", "sortBy" })
public class SearchFiltersWrapper {

	@JsonProperty("text")
	private String text;
	@JsonProperty("latitude")
	private String latitude;
	@JsonProperty("longtitude")
	private String longtitude;
	@JsonProperty("proximity")
	private String proximity;
	@JsonProperty("age_min")
	private String ageMin;
	@JsonProperty("age_max")
	private String ageMax;
	@JsonProperty("cost_min")
	private String costMin;
	@JsonProperty("cost_max")
	private String costMax;
	@JsonProperty("category")
	private String category;
	@JsonProperty("sortBy")
	private String sortBy;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public SearchFiltersWrapper() {
	}

	/**
	 * 
	 * @param proximity
	 * @param ageMin
	 * @param category
	 * @param text
	 * @param sortBy
	 * @param costMax
	 * @param costMin
	 * @param ageMax
	 * @param longtitude
	 * @param latitude
	 */
	public SearchFiltersWrapper(String text, String latitude, String longtitude, String proximity, String ageMin,
			String ageMax, String costMin, String costMax, String category, String sortBy) {
		super();
		this.text = text;
		this.latitude = latitude;
		this.longtitude = longtitude;
		this.proximity = proximity;
		this.ageMin = ageMin;
		this.ageMax = ageMax;
		this.costMin = costMin;
		this.costMax = costMax;
		this.category = category;
		this.sortBy = sortBy;
	}

	@JsonProperty("text")
	public String getText() {
		return text;
	}

	@JsonProperty("text")
	public void setText(String text) {
		this.text = text;
	}

	@JsonProperty("latitude")
	public String getLatitude() {
		return latitude;
	}

	@JsonProperty("latitude")
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	@JsonProperty("longtitude")
	public String getLongtitude() {
		return longtitude;
	}

	@JsonProperty("longtitude")
	public void setLongtitude(String longtitude) {
		this.longtitude = longtitude;
	}

	@JsonProperty("proximity")
	public String getProximity() {
		return proximity;
	}

	@JsonProperty("proximity")
	public void setProximity(String proximity) {
		this.proximity = proximity;
	}

	@JsonProperty("age_min")
	public String getAgeMin() {
		return ageMin;
	}

	@JsonProperty("age_min")
	public void setAgeMin(String ageMin) {
		this.ageMin = ageMin;
	}

	@JsonProperty("age_max")
	public String getAgeMax() {
		return ageMax;
	}

	@JsonProperty("age_max")
	public void setAgeMax(String ageMax) {
		this.ageMax = ageMax;
	}

	@JsonProperty("cost_min")
	public String getCostMin() {
		return costMin;
	}

	@JsonProperty("cost_min")
	public void setCostMin(String costMin) {
		this.costMin = costMin;
	}

	@JsonProperty("cost_max")
	public String getCostMax() {
		return costMax;
	}

	@JsonProperty("cost_max")
	public void setCostMax(String costMax) {
		this.costMax = costMax;
	}

	@JsonProperty("category")
	public String getCategory() {
		return category;
	}

	@JsonProperty("category")
	public void setCategory(String category) {
		this.category = category;
	}

	@JsonProperty("sortBy")
	public String getSortBy() {
		return sortBy;
	}

	@JsonProperty("sortBy")
	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("text", text).append("latitude", latitude)
				.append("longtitude", longtitude).append("proximity", proximity).append("ageMin", ageMin)
				.append("ageMax", ageMax).append("costMin", costMin).append("costMax", costMax)
				.append("category", category).append("sortBy", sortBy)
				.append("additionalProperties", additionalProperties).toString();
	}

}