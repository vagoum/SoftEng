package gr.ece.ntua.bitsTeam.model;

import java.util.Arrays;
import java.util.List;

public class Categories {

	private List<String> categories = Arrays.asList("Football", "Basketball", "Swimming", "Ballet", "Music",
			"Painting");

	public List<String> getCategories() {
		return categories;
	}

	public void setCategories(List<String> categories) {
		this.categories = categories;
	}
}
