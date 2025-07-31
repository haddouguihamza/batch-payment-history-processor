package com.example.financial.utils;

import org.springframework.stereotype.Service;
import java.text.NumberFormat;
import java.util.Locale;



@Service
public class CurrencyFormatterService {

    public String formatCurrency(double amount, String currencyCode, Locale locale) {
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
        return currencyFormatter.format(amount); // Locale automatically applies
    }
}