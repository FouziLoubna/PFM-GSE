package com.pfm.gse;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.pfm.gse.security.models.User;
import com.pfm.gse.security.repositories.UserDao;

@SpringBootApplication
public class GseApplication {

	public static void main(String[] args) {
		SpringApplication.run(GseApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(UserDao userDao) {
		return args -> {
			User user = new User("admin", "admin", "ADMIN");
			user.setId(Long.valueOf(1));
			userDao.save(user);

		};

	}
}
