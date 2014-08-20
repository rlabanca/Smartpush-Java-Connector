package br.com.instead.smartpush.model;

import java.util.List;

import br.com.instead.smartpush.util.FilterBuilder;


public class Push {

	private String devId;
	private String when;
	private List<Notification> notification;
	private String filter;
	
	public Push() {
		
	}
	
	public Push(FilterBuilder filterBuilder) {
		this.filter = filterBuilder.build();
	}

	public String getDevId() {
		return devId;
	}

	public void setDevId(String devId) {
		this.devId = devId;
	}

	public String getWhen() {
		return when;
	}

	public void setWhen(String when) {
		this.when = when;
	}

	public List<Notification> getNotification() {
		return notification;
	}

	public void setNotification(List<Notification> notification) {
		this.notification = notification;
	}

	public String getFilter() {
		return filter;
	}

	public void setFilter(String filter) {
		this.filter = filter;
	}

	@Override
	public String toString() {
		return "Push [devId=" + devId + ", when=" + when + ", notification="
				+ notification + ", filter=" + filter + "]";
	}
	
	
}
