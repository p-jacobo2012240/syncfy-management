package com.syncfy.management;

import com.syncfy.management.infrastructure.services.IAuthService;
import com.syncfy.management.infrastructure.services.IResourceService;
import com.syncfy.management.infrastructure.services.impl.AuthServiceImpl;
import com.syncfy.management.infrastructure.services.impl.ResourceServiceImpl;
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

	/**
	 *
	 * @return [OAuth reference service]
	 * handle the OAuth reference by kafka features
	 */
	@Bean
	public IAuthService authService() {
		return new AuthServiceImpl();
	}

	/**
	 *
	 * @return [facade pattern for all resource methods]
	 * handle all resource services
	 */
	@Bean
	public IResourceService resourceService() {
		return new ResourceServiceImpl();
	}
}
