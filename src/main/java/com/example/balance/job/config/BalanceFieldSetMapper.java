/**
 * 
 */
package com.example.balance.job.config;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;
import com.example.balance.dao.InputDetailRecord;

/**
 * 
 */
public class BalanceFieldSetMapper implements FieldSetMapper<InputDetailRecord>{

	/**
	 * 
	 */
	public BalanceFieldSetMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public InputDetailRecord mapFieldSet(FieldSet fieldSet) throws BindException {
		InputDetailRecord detail= new InputDetailRecord();
		
		detail.setCard_acquirer(fieldSet.readString(0));
		detail.setClient_fullname(fieldSet.readString(1));
		detail.setTransaction_amount(fieldSet.readFloat(3));
		detail.setCard_type(fieldSet.readString(4));
		detail.setBalance_amount(fieldSet.readFloat(5));
		detail.setFictious_balance(fieldSet.readFloat(6));
		detail.setNumber_of_operations(fieldSet.readInt(7));
		
		return detail;
	}

}
