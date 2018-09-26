package io.duru.projects.sterling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class SterlingHealthConceptApplication {

	public static void main(String[] args) {
		SpringApplication.run(SterlingHealthConceptApplication.class, args);
	}

}
