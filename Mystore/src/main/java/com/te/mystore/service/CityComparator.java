package com.te.mystore.service;

import java.util.Comparator;

import com.te.mystore.dto.Store;

public class CityComparator implements Comparator<Store>{

	@Override
	public int compare(Store o1, Store o2) {
		
		return o1.getCity().compareTo(o2.getCity());
	}

}
