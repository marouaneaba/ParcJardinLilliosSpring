package com.lille1.ParcsJardinsLillios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.lille1.ParcsJardinsLillios.Repository.*;
import com.lille1.ParcsJardinsLillios.UI.Enum.EnumTypePJ;
import com.lille1.ParcsJardinsLillios.Entity.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@SpringBootApplication
@EnableJpaRepositories

public class Application implements CommandLineRunner{

	@Autowired
	private ParcJardinRepository parcJardinRepository;
	@Autowired
	private CommentaireRepository commentaireRepository;
	@Autowired
	private CategorieRepository categorieRepository;
	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private HoraireRepository horaireRepository;
	

	
	
	
	private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

	@Override
	public void run(String... arg0) throws Exception {
		ParcJardin PJ1= parcJardinRepository.save(new ParcJardin("heron","desc smdlfjklsjgkl",EnumTypePJ.Parc,125.0,2121.0,null,null,null));
		ParcJardin PJ2= parcJardinRepository.save(new ParcJardin("valentiu","desc pas mal",EnumTypePJ.Jardin,122.0,211.0,null,null,null));
		parcJardinRepository.findAll().forEach(c->{
			System.out.println(c.getName());
		});
		
		Admin a = new Admin("mouss", "123", "toto", "25448");
		adminRepository.save(a);
		
		
		adminRepository.findAll().forEach(c->{
			System.out.println(c.getName());
		});
		
		
	}
}
