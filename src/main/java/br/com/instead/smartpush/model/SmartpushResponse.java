package br.com.instead.smartpush.model;

public class SmartpushResponse {

	private int statusCode;
	private String statusMessage;
	private PushResponse response;

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	
	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	
	public PushResponse getResponse() {
		return response;
	}

	public void setResponse(PushResponse response) {
		this.response = response;
	}

	public boolean isOk() {
		return this.statusCode % 100 == 2;
	}

	@Override
	public String toString() {
		return "SmartpushResponse [statusCode=" + statusCode
				+ ", statusMessage=" + statusMessage + ", response=" + response
				+ "]";
	}
	
}
