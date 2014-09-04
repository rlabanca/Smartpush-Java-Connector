package br.com.instead.smartpush.model;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class SmartpushFilters {

	@SerializedName("T")
	private List<Object> T;

	public List<Object> getT() {
		return T;
	}

	public void setT(List<Object> t) {
		T = t;
	}
	
	public void addTag(Object tag) {
		if (T == null) {
			T = new ArrayList<Object>();
		}
		T.add(tag);
	}
	
}