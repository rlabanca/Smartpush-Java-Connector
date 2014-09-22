package br.com.instead.smartpush.model;

import java.util.List;


public class Push {

	private String devId;
	private String when;
	private List<SmartpushNotification> notification;
	
	public Push() {
		
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

	public List<SmartpushNotification> getNotification() {
		return notification;
	}

	public void setNotification(List<SmartpushNotification> notification) {
		this.notification = notification;
	}
	
	@Override
	public String toString() {
		return "Push [devId=" + devId + ", when=" + when + ", notification="
				+ notification + "]";
	}
	
	
}
