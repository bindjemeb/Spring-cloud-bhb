package fr.sang.microservice.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGateWayConfiguration {

	@Bean
	public RouteLocator getewayRouter(RouteLocatorBuilder builder) {

		return builder.routes().route(p -> p.path("/get").uri("http://httpbin.org:80"))
				.route(p -> p.path("/currency-exchange/**").uri("lb://currency-exchange"))
				.route(p -> p.path("/currency-conversion-feign/**").uri("lb://currency-conversion")).route(
						p -> p.path("/currency-conversion-test/**")
								.filters(f -> f.rewritePath("/currency-conversion-test/(?<segment>.*)",
										"/currency-conversion-feign/${segment}"))
								.uri("lb://currency-conversion"))
				.build(); // lb pour
		// load
		// balance
		// ,
	}// currency-conversion-feign

}
