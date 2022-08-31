package fr.sang.microservice.currencyexchangeservice.service;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.sang.microservice.currencyexchangeservice.dto.CurrencyExchange;

public interface CurrencuExchageRepository extends JpaRepository<CurrencyExchange, Long> {

	CurrencyExchange findByFromAndTo(String from, String to);

}
