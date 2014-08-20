package br.com.instead.smartpush.model;

public class SmartpushRequest {

	private Push push;

	public Push getPush() {
		return push;
	}

	public void setPush(Push push) {
		this.push = push;
	}

	@Override
	public String toString() {
		return "SmartpushRequest [push=" + push + "]";
	}
	
}
