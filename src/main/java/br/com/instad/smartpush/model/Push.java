package br.com.instad.smartpush.model;

import java.util.List;


public class Push {

	private String alias;
	private String devId;
	private String when;
	private boolean prod;
	private List<SmartpushNotification> notifications;
	
	public Push() {
		
	}
	
	public void setAlias( String alias ) {
		this.alias = alias;
	}
	
	public String getAlias() {
		return this.alias;
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

	public List<SmartpushNotification> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<SmartpushNotification> notifications) {
		this.notifications = notifications;
	}
	
	public boolean isProd() {
		return prod;
	}

	public void setProd(boolean prod) {
		this.prod = prod;
	}

	@Override
	public String toString() {
		return "Push [devId=" + devId + ", when=" + when + ", prod=" + prod
				+ ", notification=" + notifications + "]";
	}	
}
