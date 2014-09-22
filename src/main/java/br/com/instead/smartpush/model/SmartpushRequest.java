package br.com.instead.smartpush.model;


public class SmartpushRequest {

	private Push push;
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
