package br.com.instad.smartpush.model;

import java.util.List;

public class SmartpushRequest {

	private transient Push push;
	
	private String alias;
	private String devid;
	private String when;
	private byte prod;
	private List<SmartpushNotification> notifications;
	
	private SmartpushFilters filter;
	
	public SmartpushRequest() {
		
	}
	
	public SmartpushRequest(SmartpushFilters filter) {
		this.filter = filter;
	}
	
	public Push getPush() {
		return push;
	}

	public void setPush(Push push) {
		this.push = push;
		
		this.alias = push.getAlias();
		this.devid = push.getDevId();
		this.when = push.getWhen();
		this.prod = (byte)( ( push.isProd() ) ? 1 : 0 );
		notifications = push.getNotifications();
	}
	
	public SmartpushFilters getFilter() {
		return filter;
	}

	public void setFilter(SmartpushFilters filter) {
		this.filter = filter;
	}
	
	@Override
	public String toString() {
		return "SmartpushRequest [push=" + push + ", filter=" + filter + "]";
	}

}
