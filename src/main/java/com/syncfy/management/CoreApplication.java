package com.syncfy.management;

import com.syncfy.management.infrastructure.services.IAuthService;
import com.syncfy.management.infrastructure.services.IMetricService;
import com.syncfy.management.infrastructure.services.impl.AuthServiceImpl;
import com.syncfy.management.infrastructure.services.impl.MetricServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.syncfy.management.infrastructure.repositories")
public class CoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoreApplication.class, args);
	}

	@Bean
	public IAuthService authService() {
		return new AuthServiceImpl();
	}
	@Bean
	public IMetricService metricService() {
		return new MetricServiceImpl();
	}
}
