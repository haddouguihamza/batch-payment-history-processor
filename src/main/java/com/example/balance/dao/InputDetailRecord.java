package com.example.balance.dao;

/**
 * 
 */

public class InputDetailRecord {
	
	private String description;
	
	private String acquirer;
	
	private String client;
	
	private float transaction_amount;
	
	private String type;
	
	private float balance;
	
	private float fictious_balance;
	
	private String receiver;

	public InputDetailRecord() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the acquirer
	 */
	public String getAcquirer() {
		return acquirer;
	}

	/**
	 * @param acquirer the acquirer to set
	 */
	public void setAcquirer(String acquirer) {
		this.acquirer = acquirer;
	}

	/**
	 * @return the client
	 */
	public String getClient() {
		return client;
	}

	/**
	 * @param client the client to set
	 */
	public void setClient(String client) {
		this.client = client;
	}

	/**
	 * @return the transaction_amount
	 */
	public float getTransaction_amount() {
		return transaction_amount;
	}

	/**
	 * @param transaction_amount the transaction_amount to set
	 */
	public void setTransaction_amount(float transaction_amount) {
		this.transaction_amount = transaction_amount;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the balance
	 */
	public float getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(float balance) {
		this.balance = balance;
	}

	/**
	 * @return the fictious_balance
	 */
	public float getFictious_balance() {
		return fictious_balance;
	}

	/**
	 * @param fictious_balance the fictious_balance to set
	 */
	public void setFictious_balance(float fictious_balance) {
		this.fictious_balance = fictious_balance;
	}

	/**
	 * @return the receiver
	 */
	public String getReceiver() {
		return receiver;
	}

	/**
	 * @param receiver the receiver to set
	 */
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	
	
}
