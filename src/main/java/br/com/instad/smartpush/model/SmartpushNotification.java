package br.com.instad.smartpush.model;

import java.util.HashMap;
import java.util.Map;

public class SmartpushNotification {

	private String appid;
	private SmartpushPlatform platform;
	private Map<String, Object> params = new HashMap<String, Object>();
	private transient boolean silent;
	
	public SmartpushNotification() {
	}
	
	public SmartpushNotification(SmartpushPlatform platform, boolean silent) {
		this.platform = platform;
		this.silent = silent;
		
		if (this.platform == SmartpushPlatform.IOS) {
			params.put("aps", new HashMap<String, Object>());
		}
	}
	
	public String getAppId() {
		return appid;
	}
	public void setAppId(String appId) {
		this.appid = appId;
	}
	
	public void setPlatform(SmartpushPlatform platform) {
		this.platform = platform;
	}
	
	public SmartpushPlatform getPlatform() {
		return platform;
	}

	public void setPlataform(SmartpushPlatform platform) {
		this.platform = platform;
	}

	public boolean isSilent() {
		return silent;
	}

	public void setSilent(boolean silent) {
		this.silent = silent;
	}

	public void setMessage(String message) {
		
		if (this.platform == SmartpushPlatform.IOS) {
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
		return (HashMap<String, Object>) params.get("aps");
	}
	
	public Map<String, Object> getMsgParams() {
		return params;
	}
	public void setMsgParams(Map<String, Object> msgParams) {
		this.params = msgParams;
	}
	
	public void addMsgParam(String key, Object value) {
		this.params.put(key, value);
	}
	
	@Override
	public String toString() {
		return "Notification [appId=" + appid + ", platform=" + platform
				+ ", msgParams=" + params + "]";
	}
	
}
