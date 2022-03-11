package com.te.mystore.service;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.mystore.customexception.BlankInputException;
import com.te.mystore.customexception.InvalidInputException;
import com.te.mystore.dao.MystoreDaoImpl;
import com.te.mystore.dto.Store;

@Service
public class MystoreServiceImpl implements MystoreService {

	@Autowired
	private MystoreDaoImpl dao;

	public List<Store> getAllByid(String id) throws IOException {

		if (dao.getAllByid(id).size() <= 0) {
			throw new InvalidInputException("Unable to find the store with the ID. Please try again with a valid store ID");
		}else if(id.isEmpty() || id.equalsIgnoreCase(null)){
			throw new BlankInputException("Store Id cannot be blank, Please provide a valid store id");
		}
		else 
			return dao.getAllByid(id);

	}

	public List<Store> getAll(String sortBy) throws IOException {
		List<Store> storeList = dao.getAll();
		if(sortBy.equalsIgnoreCase("city")) {
			Collections.sort(storeList, new CityComparator());
			return storeList;
		}else if(sortBy.equalsIgnoreCase("openeddate") || sortBy.equalsIgnoreCase("opened date")) {
			Collections.sort(storeList, new DateComparator());
			return storeList;
		}else if(sortBy.equalsIgnoreCase(null) || sortBy.isEmpty()) { 
			throw new BlankInputException("Please let us know would you want to sort your stores by openeddate or city.");
			}else 
				throw new InvalidInputException("We can only sort the stores by OpenedDate or City. Please let us how would you want us to sort");
		
	}

	
}
