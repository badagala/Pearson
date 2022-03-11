package com.te.mystore.service;

import java.io.IOException;
import java.util.List;

import com.te.mystore.dto.Store;

public interface MystoreService {
	
	
	public List<Store> getAllByid(String id) throws IOException;
	
	public List<Store> getAll(String sortBy) throws IOException;

}
