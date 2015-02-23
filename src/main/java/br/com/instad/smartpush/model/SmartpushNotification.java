package br.com.instad.smartpush.model;

import java.util.HashMap;
import java.util.Map;

public class SmartpushNotification {

	private String appId;
	private SmartpushPlatform plataform;
	private Map<String, Object> msgParams = new HashMap<String, Object>();
	private boolean prod;
	private boolean silent;
	private boolean unique;
	
	public SmartpushNotification() {
	}
	
	public SmartpushNotification(SmartpushPlatform platform, boolean silent) {
		this.plataform = platform;
		this.silent = silent;
		
		if (this.plataform == SmartpushPlatform.IOS) {
			
			msgParams.put("aps", new HashMap<String, Object>());
			
		}
		
		
	}
	
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public SmartpushPlatform getPlatform() {
		return plataform;
	}
	public void setPlatform(SmartpushPlatform platform) {
		this.plataform = platform;
	}
	
	public SmartpushPlatform getPlataform() {
		return plataform;
	}

	public void setPlataform(SmartpushPlatform plataform) {
		this.plataform = plataform;
	}

	public boolean isSilent() {
		return silent;
	}

	public void setSilent(boolean silent) {
		this.silent = silent;
	}

	public boolean isUnique() {
		return unique;
	}

	public void setUnique(boolean unique) {
		this.unique = unique;
	}

	public void setMessage(String message) {
		
		if (this.plataform == SmartpushPlatform.IOS) {
			getAps().put("alert", message);
			if ( ! silent ) {
				getAps().put("sound", "default");
			}
		} else {
			getMsgParams().put("message", message);
		}
		
	}
	
	
	@SuppressWarnings("unchecked")
	private HashMap<String, Object> getAps() {
		return (HashMap<String, Object>) msgParams.get("aps");
	}
	
	public Map<String, Object> getMsgParams() {
		return msgParams;
	}
	public void setMsgParams(Map<String, Object> msgParams) {
		this.msgParams = msgParams;
	}
	
	public void addMsgParam(String key, Object value) {
		this.msgParams.put(key, value);
	}
	
	public boolean isProd() {
		return prod;
	}

	public void setProd(boolean prod) {
		this.prod = prod;
	}

	@Override
	public String toString() {
		return "Notification [appId=" + appId + ", platform=" + plataform
				+ ", msgParams=" + msgParams + "]";
	}
	
}
