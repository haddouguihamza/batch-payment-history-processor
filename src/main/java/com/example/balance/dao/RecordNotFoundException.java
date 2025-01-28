package com.example.balance.dao;



public class RecordNotFoundException extends RuntimeException {
    
	
	public RecordNotFoundException(Long id) {
        super("Could not find record with ID: " + id);
    }
}
