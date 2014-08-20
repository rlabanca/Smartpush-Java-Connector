package br.com.instead.smartpush.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilterBuilder {

	private List<Object> filters = new ArrayList<Object>();
	
	public FilterBuilder() {
		
	}
	
	public FilterBuilder in(String tag, String... filters) {
		
		List<Object> filter = new ArrayList<Object>();
		filter.add(tag);
		filter.add("IN");
		filter.add(Arrays.deepToString(filters));
		
		this.filters.add(filter);
		
		return this;
	}
	
	public String build() {
		
		if (this.filters.size() == 0) {
			return null;
			
		}
		
		Object[] filtersArray = this.filters.toArray();
		
		String filterString = Arrays.deepToString(filtersArray);
		
		return filterString;
		
	}
	
}
