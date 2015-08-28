package br.com.instad.smartpush.util;

import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

import br.com.instad.smartpush.model.SmartpushFilters;

public class FilterBuilder {

	private SmartpushFilters filter = new SmartpushFilters();
	
	public FilterBuilder() {
		
	}
	
	public FilterBuilder tagEquals(String tag, String value) {
		
		filter.addTag(new String[]{tag, "EQ", value});
		
		return this;
	}
	
	/**
	 * tagIN
	 * 
	 * @param tag - tag name configured at GETMO INC.
	 * @param values - List of String, limited to 1000
	 * @return
	 */
	public FilterBuilder tagIN(String tag, List<String> values) {
		if ( values == null || values.size() > 1000 ) {
			throw new RuntimeException();
		}
		
		filter.addTag(new Object[]{tag, "IN", values});
		
		return this;
	}
	
	public SmartpushFilters build() {
		
		if (filter.getT() == null || filter.getT().size() == 0) {
			return null;
		}
		
		return filter;
		
	}
	
}
