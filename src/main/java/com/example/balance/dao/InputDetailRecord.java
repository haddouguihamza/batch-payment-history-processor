package com.example.balance.dao;

/**
 * 
 */

public class InputDetailRecord {
	
	private String card_acquirer;
	
	private String client_fullname;
	
	private float transaction_amount;
	
	private String card_type;
	
	private float balance_amount;
	
	private float fictious_balance;
	
	private String consumer_client;
	
	private int number_of_operations;

	public InputDetailRecord() {
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * @return the card_acquirer
	 */
	public String getCard_acquirer() {
		return card_acquirer;
	}

	/**
	 * @return the client_fullname
	 */
	public String getClient_fullname() {
		return client_fullname;
	}

	/**
	 * @return the transaction_amount
	 */
	public float getTransaction_amount() {
		return transaction_amount;
	}

	/**
	 * @return the card_type
	 */
	public String getCard_type() {
		return card_type;
	}

	/**
	 * @return the balance_amount
	 */
	public float getBalance_amount() {
		return balance_amount;
	}

	/**
	 * @return the fictious_balance
	 */
	public float getFictious_balance() {
		return fictious_balance;
	}

	/**
	 * @return the consumer_client
	 */
	public String getConsumer_client() {
		return consumer_client;
	}

	/**
	 * @return the number_of_operations
	 */
	public int getNumber_of_operations() {
		return number_of_operations;
	}

	
	
	/**
	 * @param card_acquirer the card_acquirer to set
	 */
	public void setCard_acquirer(String card_acquirer) {
		this.card_acquirer = card_acquirer;
	}

	/**
	 * @param client_fullname the client_fullname to set
	 */
	public void setClient_fullname(String client_fullname) {
		this.client_fullname = client_fullname;
	}

	/**
	 * @param transaction_amount the transaction_amount to set
	 */
	public void setTransaction_amount(float transaction_amount) {
		this.transaction_amount = transaction_amount;
	}

	/**
	 * @param card_type the card_type to set
	 */
	public void setCard_type(String card_type) {
		this.card_type = card_type;
	}

	/**
	 * @param balance_amount the balance_amount to set
	 */
	public void setBalance_amount(float balance_amount) {
		this.balance_amount = balance_amount;
	}

	/**
	 * @param fictious_balance the fictious_balance to set
	 */
	public void setFictious_balance(float fictious_balance) {
		this.fictious_balance = fictious_balance;
	}

	/**
	 * @param consumer_client the consumer_client to set
	 */
	public void setConsumer_client(String consumer_client) {
		this.consumer_client = consumer_client;
	}

	/**
	 * @param number_of_operations the number_of_operations to set
	 */
	public void setNumber_of_operations(int number_of_operations) {
		this.number_of_operations = number_of_operations;
	}
	
	
}
