package gr.ece.ntua.bitsTeam.jsonClasses;

import gr.ece.ntua.bitsTeam.model.Activity;

public class StatisticsWrapper {

	private Activity activity;
	private Integer totalTickets;
	
	public Activity getActivity() {
		return activity;
	}
	
	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public Integer getTotalTickets() {
		return totalTickets;
	}

	public void setTotalTickets(Integer totalTickets) {
		this.totalTickets = totalTickets;
	}

	
}
