package com.te.mystore.service;

import java.util.Comparator;

import com.te.mystore.dto.Store;

public class DateComparator implements Comparator<Store>{

	@Override
	public int compare(Store o1, Store o2) {
		
		return o2.getNumberofdays().compareTo(o1.getNumberofdays());
	}

}
