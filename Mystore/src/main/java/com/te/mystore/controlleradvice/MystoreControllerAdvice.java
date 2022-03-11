package com.te.mystore.controlleradvice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.te.mystore.customexception.BlankInputException;
import com.te.mystore.customexception.InvalidInputException;
import com.te.mystore.dto.StoreResponse;

@RestControllerAdvice
public class MystoreControllerAdvice {
	
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(InvalidInputException.class)
	public ResponseEntity<StoreResponse> invalidInputException(InvalidInputException customException){
		StoreResponse response = new StoreResponse(404, "Unsucessfull",customException.getMessage());
		return new ResponseEntity<StoreResponse>(response,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	@ExceptionHandler(BlankInputException.class)
	public ResponseEntity<StoreResponse> blankInputException(BlankInputException customException){
		StoreResponse response = new StoreResponse(404, "Unsucessfull",customException.getMessage());
		return new ResponseEntity<StoreResponse>(response,HttpStatus.NOT_FOUND);
	}
	

}
