package br.com.instead.smartpush.model;

import java.util.HashMap;
import java.util.Map;

public class Notification {

	private String appId;
	private String platform;
	private Map<String, Object> msgParams = new HashMap<String, Object>();
	
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
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
