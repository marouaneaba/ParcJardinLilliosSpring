package com.lille1.ParcsJardinsLillios;
import com.lille1.ParcsJardinsLillios.Service.Interfaces.CategorieInterface;
import com.lille1.ParcsJardinsLillios.Service.Interfaces.CommentaireInterface;
import com.lille1.ParcsJardinsLillios.Service.Interfaces.ParcJardinInterface;
import com.lille1.ParcsJardinsLillios.Storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.lille1.ParcsJardinsLillios.DAO.*;

import com.lille1.ParcsJardinsLillios.Entity.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.List;


@SpringBootApplication
@EnableJpaRepositories

public class Application implements CommandLineRunner{

	
	@Resource
	StorageService storageService;
	@Autowired
	private CommentaireRepository mCommentaireRepository;
	@Autowired
	private CategorieRepository mCategorieRepository;
	@Autowired
	private ParcJardinRepository mParcJardinRepository;
	@Autowired
	private HoraireRepository mHoraireRepository;
	@Autowired
	private ParcJardinRepository parcJardinRepository;
	@Autowired
	private CommentaireRepository commentaireRepository;
	@Autowired
	private CategorieRepository categorieRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private HoraireRepository horaireRepository;
	
	@Autowired
	private CategorieInterface categorieInterfaceMetier;
	@Autowired
	private ParcJardinInterface parcJardinInterfaceMetier;
	@Autowired
    private CommentaireInterface commentaireInterfaceMetier;


	
	
	
	private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(java.lang.String[] args) {
        SpringApplication.run(Application.class, args);
    }

	@Override
	public void run(java.lang.String... arg0) throws Exception {

		ParcJardin PJ2= new ParcJardin("jardin1","descJardin1", "JARDIN","30.0","3.16","adressJardin1");
		ParcJardin PJ3= new ParcJardin("jardin2","descJardin2", "PARC","21.0","2.0","adressJardin2");
		ParcJardin PJ4= new ParcJardin("jardin4","descJardin2", "PARC","24.0","2.4","adressJardin2");




		Commentaire cm1 = new Commentaire("com1",3,"pers1",false, PJ2);
		Commentaire cm2 = new Commentaire("com2",5,"pers2",false,PJ2);
		Commentaire cm3 = new Commentaire("com3",5,"pers3",false,PJ3);
		Commentaire cm5 = new Commentaire("com5",5,"pers3",false,PJ4);

		Commentaire commentaire1 = mCommentaireRepository.save(cm1);
		Commentaire commentaire2 = mCommentaireRepository.save(cm2);
		Commentaire commentaire3 = mCommentaireRepository.save(cm3);

		ParcJardin parcjardin1 = mParcJardinRepository.save(PJ2);
		ParcJardin parcjardin2 = mParcJardinRepository.save(PJ3);
		ParcJardin parcjardin3 = mParcJardinRepository.save(PJ4);





		Categorie cat2 = new Categorie("ETUDE");
		Categorie cat3 = new Categorie("SPORT");
		Categorie cat4 = new Categorie("RESTAURATION");
		Categorie cat5 = new Categorie("PROMENER");
		Categorie cat6 = new Categorie("ECOUTER");
		Categorie cat7 = new Categorie("OBSERVER");

        Categorie catsave2 = mCategorieRepository.save(cat2);
		Categorie catsave3 = mCategorieRepository.save(cat3);
		Categorie catsave4 = mCategorieRepository.save(cat4);
		Categorie catsave5 = mCategorieRepository.save(cat5);
		Categorie catsave6 = mCategorieRepository.save(cat6);
		Categorie catsave7 = mCategorieRepository.save(cat7);

		List<Categorie> ltmpcat = parcJardinInterfaceMetier.ConsulterCategoriesPJ(parcjardin1.getId());
		parcJardinInterfaceMetier.AjouterListCatToPJ(ltmpcat,PJ3);



		Horaire h1 = new Horaire("8:00","18:00", "lundi",parcjardin1);
		mHoraireRepository.save(h1);

		List<ParcJardin> listPJByCat = parcJardinInterfaceMetier.chercherPJParCategorie(cat2);

		for(ParcJardin pj : listPJByCat){
			System.out.println("PJ avec Cat 2"+pj.toString());
		}



		List<Categorie> listCat= parcJardinInterfaceMetier.ConsulterCategoriesPJ(parcjardin1.getId());

		for(Categorie cat : listCat){
			System.out.println("cat de PJ1"+cat.toString());
		}





		ParcJardin PJLG = parcJardinInterfaceMetier.chercherPJLG("30.0","3.16");
		System.out.println("PJLGGGG"+PJLG.toString());
		

		commentaireInterfaceMetier.ValiderCommentaire(commentaire1);
		commentaireInterfaceMetier.SupprimerCommentaire(commentaire3);



		//test suppression parc

		ParcJardin nvPJ = parcJardinRepository.save(new ParcJardin("jardin3","descJardin3", "JARDIN","37.6","3.10","adressJardin1"));
		commentaireRepository.save( new Commentaire("com4",5,"pers4",false,nvPJ));

		Categorie catPJSup = categorieRepository.save(new Categorie("test supp cat"));
		parcJardinInterfaceMetier.ajouterCategorieToPJ(catPJSup, nvPJ);


		List<ParcJardin> listPl= parcJardinInterfaceMetier.ConsulterParcsJardin();
		for(ParcJardin pj : listPl){
			System.out.println(pj.toString());
		}



		List<ParcJardin> listPJ= parcJardinInterfaceMetier.ConsulterParcsJardin();
		for(ParcJardin pj : listPJ){
			System.out.println(pj.toString());
		}
        


		List<Commentaire> listCom = commentaireRepository.findByConfirmerAndParcJardinn(false,nvPJ);
		for(Commentaire com : listCom){
			System.out.println(com.toString());
		}

		parcJardinInterfaceMetier.supprimercatFromPJ(parcjardin2.getId());

		userRepository.save(new User("name","password","admin@admin.fr","098998"));


	}
}
