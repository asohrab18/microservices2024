package com.microservices.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.entity.ExchangeCurrency;

public interface ExchangeCurrencyRepository extends JpaRepository<ExchangeCurrency, Long> {

	Optional<ExchangeCurrency> findByCurrencyFromAndCurrencyTo(String currencyFrom, String currencyTo);
}
