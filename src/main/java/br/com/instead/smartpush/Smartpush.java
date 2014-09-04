package br.com.instead.smartpush;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import br.com.instead.smartpush.client.SmartpushClient;
import br.com.instead.smartpush.model.SmartpushNotification;
import br.com.instead.smartpush.model.Push;
import br.com.instead.smartpush.model.SmartpushRequest;
import br.com.instead.smartpush.model.SmartpushResponse;
import br.com.instead.smartpush.util.FilterBuilder;

public class Smartpush {
	
	private Push push = new Push();
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	
	public static Smartpush withDeveloperId(String developerId) {
		return new Smartpush(developerId);
	}
	
	private Smartpush(String devId) {
		this.push.setDevId(devId);
	}
	
	public Smartpush push(List<SmartpushNotification> notifications) {
		this.push.setNotification(notifications);
		return this;
	}
	
	public Smartpush filteredBy(FilterBuilder filters) {
		if (filters != null) {
			this.push.setFilter(filters.build());
			
		}
		return this;
	}
	
	public SmartpushResponse now() {
		
		this.push.setWhen("now");
		
		SmartpushRequest request = new SmartpushRequest();
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
	
	public SmartpushResponse at(Date when) {
		this.push.setWhen(this.dateFormat.format(when));
		return null;
	}
	
}
