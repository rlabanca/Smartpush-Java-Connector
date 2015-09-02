package br.com.instad.smartpush;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import br.com.instad.smartpush.client.SmartpushClient;
import br.com.instad.smartpush.model.Push;
import br.com.instad.smartpush.model.SmartpushFilters;
import br.com.instad.smartpush.model.SmartpushNotification;
import br.com.instad.smartpush.model.SmartpushRequest;
import br.com.instad.smartpush.model.SmartpushResponse;
import br.com.instad.smartpush.util.FilterBuilder;

public class Smartpush {
	
	private Push push = new Push();
	private SmartpushFilters filter;
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	
	public static Smartpush withDeveloperId(String developerId) {
		return new Smartpush(developerId);
	}
	
	private Smartpush(String devId) {
		this.push.setDevId(devId);
	}
	
	public Smartpush push(List<SmartpushNotification> notifications) {
		this.push.setNotifications(notifications);
		return this;
	}
	
	public Smartpush push(SmartpushNotification notification) {
		return push(Arrays.asList(notification));
	}
	
	public Smartpush setAlias(String alias) {
		this.push.setAlias(alias);
		return this;
	}
	
	public Smartpush setProd( boolean prod ) {
		this.push.setProd(prod);
		return this;
	}
	
	public Smartpush filteredBy(FilterBuilder filters) {
		if (filters != null) {
			this.filter = filters.build();
			
		}
		return this;
	}
	
	public SmartpushResponse now() {
		
		this.push.setWhen("now");
		
		SmartpushRequest request = new SmartpushRequest(this.filter);
		request.setPush(this.push);
		
		try {
			
			return SmartpushClient.getInstance().post(request);
			
		} catch (IOException e) {
			
			SmartpushResponse response = new SmartpushResponse();
			response.setCode(500);
			response.setMessage("Couldn't reach the server. Try again later.");
			return response;
		}
	}
}
