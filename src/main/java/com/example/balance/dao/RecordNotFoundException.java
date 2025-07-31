package com.example.balance.dao;



public class RecordNotFoundException extends RuntimeException {
    
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5099240562471715196L;

	public RecordNotFoundException(Long id) {
        super("Could not find record with ID: " + id);
    }
}
