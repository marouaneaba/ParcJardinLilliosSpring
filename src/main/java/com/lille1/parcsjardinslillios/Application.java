package com.lille1.parcsjardinslillios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import com.lille1.parcsjardinslillios.entity.User;
import com.lille1.parcsjardinslillios.repository.CategorieRepository;
import com.lille1.parcsjardinslillios.repository.UserRepository;
import com.lille1.parcsjardinslillios.storage.StorageService;
import javax.annotation.Resource;

@SpringBootApplication
@EnableJpaRepositories

public class Application implements CommandLineRunner {

	@Resource
	StorageService storageService;
	@Autowired
	private CategorieRepository mCategorieRepository;
	@Autowired
	private UserRepository userRepository;

	public static void main(java.lang.String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(java.lang.String... arg0) throws Exception {

		userRepository.save(new User("name", "password", "admin@admin.fr", "098998"));

	}
}
