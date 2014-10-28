package br.com.instad.smartpush.model;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class SmartpushFilters {

	@SerializedName("T")
	private List<Object> T;
	
	private boolean unique;

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

	public boolean isUnique() {
		return unique;
	}

	public void setUnique(boolean unique) {
		this.unique = unique;
	}
	
	
}
