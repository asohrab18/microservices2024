package com.microservices.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ExchangeCurrency {

	@Id
	private Long id;

	private String currencyFrom;
	private String currencyTo;
	private BigDecimal conversionMultiple;
	private String environmentPort;

	public ExchangeCurrency() {
	}

	public ExchangeCurrency(Long id, String currencyFrom, String currencyTo, BigDecimal conversionMultiple,
			String environmentPort) {
		super();
		this.id = id;
		this.currencyFrom = currencyFrom;
		this.currencyTo = currencyTo;
		this.conversionMultiple = conversionMultiple;
		this.environmentPort = environmentPort;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCurrencyFrom() {
		return currencyFrom;
	}

	public void setCurrencyFrom(String currencyFrom) {
		this.currencyFrom = currencyFrom;
	}

	public String getCurrencyTo() {
		return currencyTo;
	}

	public void setCurrencyTo(String currencyTo) {
		this.currencyTo = currencyTo;
	}

	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}

	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}

	public String getEnvironmentPort() {
		return environmentPort;
	}

	public void setEnvironmentPort(String environmentPort) {
		this.environmentPort = environmentPort;
	}

}
