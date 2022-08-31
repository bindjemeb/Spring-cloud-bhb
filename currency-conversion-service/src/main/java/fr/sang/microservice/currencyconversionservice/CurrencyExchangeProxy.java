package fr.sang.microservice.currencyconversionservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import fr.sang.microservice.currencyconversionservice.controllers.dto.CurrencyConversion;

//info du service qu' on veut appeler 
//@FeignClient(name = "currency-exchange", url = "localhost:8081")
//le service  parlera à eureka pour connaitre  les  instances disponibles 
@FeignClient(name = "currency-exchange")
public interface CurrencyExchangeProxy {

	@GetMapping(path = "/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversion getExchangeValue(@PathVariable String from, @PathVariable String to);
}
