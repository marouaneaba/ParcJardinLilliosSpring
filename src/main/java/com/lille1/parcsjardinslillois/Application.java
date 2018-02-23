package com.lille1.parcsjardinslillois;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
<<<<<<< HEAD:src/main/java/com/lille1/parcsjardinslillios/Application.java

import com.lille1.parcsjardinslillios.entity.ParcJardin;
import com.lille1.parcsjardinslillios.entity.User;
import com.lille1.parcsjardinslillios.repository.ParcJardinRepository;
import com.lille1.parcsjardinslillios.repository.UserRepository;
import com.lille1.parcsjardinslillios.storage.StorageService;
import javax.annotation.Resource;
=======
import com.lille1.parcsjardinslillois.entity.User;
import com.lille1.parcsjardinslillois.repository.UserRepository;

>>>>>>> cd2febb34229df6e1801646827269d2798d7e13b:src/main/java/com/lille1/parcsjardinslillois/Application.java

@SpringBootApplication
@EnableJpaRepositories

public class Application implements CommandLineRunner {


	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ParcJardinRepository mParcJardinRepository;
	
	
	public static void main(java.lang.String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(java.lang.String... arg0) {

		userRepository.save(new User("name", "password", "admin@admin.fr", "098998"));

<<<<<<< HEAD:src/main/java/com/lille1/parcsjardinslillios/Application.java
		ParcJardin pj = new ParcJardin("Parc Heron", "le Parc Heron Description","PARC","0.0" , "0.0",
				"avenue Paul Langevin Ville neuve d'asq") ;
		
		mParcJardinRepository.save(pj);
=======

>>>>>>> cd2febb34229df6e1801646827269d2798d7e13b:src/main/java/com/lille1/parcsjardinslillois/Application.java
	}
}
