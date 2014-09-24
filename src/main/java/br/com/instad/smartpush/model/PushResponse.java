package br.com.instad.smartpush.model;

public class PushResponse {

	private String pushid;

	public String getPushid() {
		return pushid;
	}

	public void setPushid(String pushid) {
		this.pushid = pushid;
	}

	@Override
	public String toString() {
		return "PushResponse [pushid=" + pushid + "]";
	}
	
}
