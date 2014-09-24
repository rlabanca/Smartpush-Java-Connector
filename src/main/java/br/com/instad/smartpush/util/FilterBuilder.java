package br.com.instad.smartpush.util;

import br.com.instad.smartpush.model.SmartpushFilters;

public class FilterBuilder {

	private SmartpushFilters filter = new SmartpushFilters();
	
	public FilterBuilder() {
		
	}
	
	public FilterBuilder tagEquals(String tag, String value) {
		
		filter.addTag(new String[]{tag, "EQ", value});
		
		return this;
	}
	
	public SmartpushFilters build() {
		
		if (filter.getT() == null || filter.getT().size() == 0) {
			return null;
		}
		
		return filter;
		
	}
	
}
