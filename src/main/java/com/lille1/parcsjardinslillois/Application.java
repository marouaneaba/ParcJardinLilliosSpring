package com.lille1.parcsjardinslillois;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import com.lille1.parcsjardinslillois.entity.User;
import com.lille1.parcsjardinslillois.repository.UserRepository;


@SpringBootApplication
@EnableJpaRepositories

public class Application implements CommandLineRunner {


	@Autowired
	private UserRepository userRepository;

	public static void main(java.lang.String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(java.lang.String... arg0) {

		userRepository.save(new User("name", "password", "admin@admin.fr", "098998"));


	}
}
