package com.example.balance.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class OutputDetailRecord {
	
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long balance_id;
	
	private String card_acquirer;
	
	private String customer_name;
	
	private float transaction_amount;
	
	private String card_type;
	
	private String balance_amount;
	
	private String fictious_balance;
	
	private String receiver_name;

	
	public OutputDetailRecord() {
	}


	/**
	 * @return the balance_id
	 */
	public Long getBalance_id() {
		return balance_id;
	}


	/**
	 * @param balance_id the balance_id to set
	 */
	public void setBalance_id(Long balance_id) {
		this.balance_id = balance_id;
	}


	/**
	 * @return the card_acquirer
	 */
	public String getCard_acquirer() {
		return card_acquirer;
	}


	/**
	 * @param card_acquirer the card_acquirer to set
	 */
	public void setCard_acquirer(String card_acquirer) {
		this.card_acquirer = card_acquirer;
	}


	/**
	 * @return the customer_name
	 */
	public String getCustomer_name() {
		return customer_name;
	}


	/**
	 * @param customer_name the customer_name to set
	 */
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
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
	 * @return the card_type
	 */
	public String getCard_type() {
		return card_type;
	}


	/**
	 * @param card_type the card_type to set
	 */
	public void setCard_type(String card_type) {
		this.card_type = card_type;
	}


	/**
	 * @return the balance_amount
	 */
	public String getBalance_amount() {
		return balance_amount;
	}


	/**
	 * @param balance_amount the balance_amount to set
	 */
	public void setBalance_amount(String balance_amount) {
		this.balance_amount = balance_amount;
	}


	/**
	 * @return the fictious_balance
	 */
	public String getFictious_balance() {
		return fictious_balance;
	}


	/**
	 * @param fictious_balance the fictious_balance to set
	 */
	public void setFictious_balance(String fictious_balance) {
		this.fictious_balance = fictious_balance;
	}


	/**
	 * @return the receiver_name
	 */
	public String getReceiver_name() {
		return receiver_name;
	}


	/**
	 * @param receiver_name the receiver_name to set
	 */
	public void setReceiver_name(String receiver_name) {
		this.receiver_name = receiver_name;
	}
    
}