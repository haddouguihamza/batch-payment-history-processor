package com.example.balance.job.config;

import java.util.Locale;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.balance.dao.InputDetailRecord;
import com.example.balance.dao.OutputDetailRecord;
import com.example.financial.utils.CurrencyFormatterService;



@Component
public class BalanceItemProcessor implements ItemProcessor<InputDetailRecord, OutputDetailRecord>{
	
	@Autowired
	private OutputDetailRecord output;
	
	@Autowired
	private CurrencyFormatterService currencyService;

	public BalanceItemProcessor() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public OutputDetailRecord process(InputDetailRecord item) throws Exception {
		this.output.setCard_acquirer(item.getCard_acquirer());
		this.output.setCustomer_name(item.getClient_fullname());
		this.output.setTransaction_amount(item.getTransaction_amount());
		this.output.setCard_type(formatCardType(item.getCard_type()));
		this.output.setBalance_amount(item.getBalance_amount());
		this.output.setFictious_balance(item.getFictious_balance());
		this.output.setReceiver_name(item.getConsumer_client());
		this.output.setOperations_total_number(item.getNumber_of_operations());
		return this.output;
	}
	
	
	String formatCardType(String type) {
		return type.toUpperCase();
	}
	
	
	String formatAmount(double amount) {
		Locale locale = Locale.forLanguageTag("en-US");    
	    String formattedAmount= this.currencyService.formatCurrency(amount, "USD", locale);
		return formattedAmount;
	}

}
