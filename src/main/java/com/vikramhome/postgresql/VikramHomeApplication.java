package com.vikramhome.postgresql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class VikramHomeApplication {

	public static void main(String[] args) {
		SpringApplication.run(VikramHomeApplication.class, args);
	}

}
