package com.te.mystore.dao;

import java.io.IOException;
import java.util.List;

import com.te.mystore.dto.Store;

public interface MystoreDao {
	
	public List<Store> getAllByid(String id) throws IOException;
	public List<Store> getAll() throws IOException;
//	public List<Store> getAllByCity(String city,String dates) throws IOException;
//	public List<Store> getAllByDate(String date) throws IOException;

}
