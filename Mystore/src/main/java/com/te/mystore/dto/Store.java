package com.te.mystore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Store {
		
		private String storeId;
		private String postcode;
		private String city;
		private String Address;
		private String openedDate;
		private Long numberofdays;
		
		
	

}
