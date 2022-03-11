package com.te.mystore.firstcontroller;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.te.mystore.dto.StoreResponse;
import com.te.mystore.dto.Store;
import com.te.mystore.service.MystoreServiceImpl;

@RestController
public class Controller {

	@Autowired
	private MystoreServiceImpl service;

	@GetMapping("/getstore")
	public ResponseEntity<StoreResponse> getStore(@RequestParam String id) throws IOException {
		List<Store> shop = service.getAllByid(id);
		StoreResponse response = new StoreResponse(200, "Sucessfull", "Below are the details of the Store you enquired about:",shop);
		return new ResponseEntity<StoreResponse>(response,HttpStatus.OK);
		
	}

	@GetMapping("/getstores")
	public ResponseEntity<StoreResponse> getStores(@RequestParam String sortBy) throws IOException {
		List<Store> shop = service.getAll(sortBy);
		StoreResponse response = new StoreResponse(200, "Sucessfull", "Below are the details of the all the store sorted by "+sortBy,shop);
		return new ResponseEntity<StoreResponse>(response,HttpStatus.OK);
		}
	}
