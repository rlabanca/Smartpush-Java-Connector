package br.com.instead.smartpush.model;

import java.util.HashMap;
import java.util.Map;

public class SmartpushNotification {

	private String appId;
	private SmartpushPlatform platform;
	private Map<String, Object> msgParams = new HashMap<String, Object>();
	
	public SmartpushNotification() {
	}
	
	public SmartpushNotification(SmartpushPlatform platform) {
		this.platform = platform;
		
		if (this.platform == SmartpushPlatform.IOS) {
			
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
		return platform;
	}
	public void setPlatform(SmartpushPlatform platform) {
		this.platform = platform;
	}
	
	public void setMessage(String message) {
		
		if (this.platform == SmartpushPlatform.IOS) {
			getAps().put("alert", message);
		}
		
		getMsgParams().put("message", message);
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
	
	@Override
	public String toString() {
		return "Notification [appId=" + appId + ", platform=" + platform
				+ ", msgParams=" + msgParams + "]";
	}
	
}
