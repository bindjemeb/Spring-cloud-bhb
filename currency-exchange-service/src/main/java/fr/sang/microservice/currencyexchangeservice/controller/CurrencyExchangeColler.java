package fr.sang.microservice.currencyexchangeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import fr.sang.microservice.currencyexchangeservice.dto.CurrencyExchange;
import fr.sang.microservice.currencyexchangeservice.service.CurrencuExchageRepository;

@RestController
public class CurrencyExchangeColler {

	@Autowired
	private CurrencuExchageRepository repository;

	@Autowired
	private Environment environment;

	@GetMapping(path = "/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange getExchangeValue(@PathVariable String from, @PathVariable String to) {

		CurrencyExchange currencyExchange = repository.findByFromAndTo(from, to);
		currencyExchange.setEnvironment(environment.getProperty("local.server.port"));

		return currencyExchange;
	}

}
