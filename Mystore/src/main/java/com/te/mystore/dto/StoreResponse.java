package com.te.mystore.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StoreResponse {

	private int statusCode;
	private String msg;
	private String description;
	private List<Store> shop;
	public StoreResponse(int statusCode, String msg, String description) {
		super();
		this.statusCode = statusCode;
		this.msg = msg;
		this.description = description;
	}
	
	

}
