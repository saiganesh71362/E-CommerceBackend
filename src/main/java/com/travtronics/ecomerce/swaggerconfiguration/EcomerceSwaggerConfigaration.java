package com.travtronics.ecomerce.swaggerconfiguration;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EcomerceSwaggerConfigaration {

	@Bean
	public GroupedOpenApi controllerApi() {
		return GroupedOpenApi.builder().group("FitnessSlotBookingSystem")
				.packagesToScan("com.travtronics.ecomerce.controller") // Specify the package to scan
				.build();
	}

}
