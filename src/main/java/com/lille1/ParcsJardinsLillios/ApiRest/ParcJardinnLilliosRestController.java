package com.lille1.ParcsJardinsLillios.ApiRest;

import com.lille1.ParcsJardinsLillios.Service.Interfaces.CategorieInterface;
import com.lille1.ParcsJardinsLillios.Service.Interfaces.CommentaireInterface;
import com.lille1.ParcsJardinsLillios.Service.Interfaces.ParcJardinInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import javax.imageio.ImageIO;

import com.lille1.ParcsJardinsLillios.Entity.*;


@RestController
public class ParcJardinnLilliosRestController {
	@Autowired
	private ParcJardinInterface parcJardinInterfaceMetier;
	@Autowired
	private CategorieInterface categorieInterfaceMetier;
	@Autowired
	private CommentaireInterface commentaireInterfaceMetier;

	/**
	 * Permet delister toutes les Parc/Jardinns Lillios via une requête GET
	 * http://localhost:8080/api/beers
	 *
	 * @return
	 */
	@RequestMapping(value = "/api/PJ", method = RequestMethod.GET)
	public List<ParcJardin> GetParcJardinnLillios() {
		List<ParcJardin> parcJardinn = new ArrayList<>();
		parcJardinn.add(new ParcJardin("AllnameParc", "AlldescriptionParc", "AlltypeParc", 1.0, 2.0, "AlladdresseParc"));
		return parcJardinn;
	}

	/**
	 * Permet d'enregistrer un nouvelle Parc/Jardinns via une requête POST :
	 * http://localhost:8080/api/beers
	 *
	 * @param sName
	 *            le nom
	 * @param sDescription
	 *            la description
	 * @param sType
	 *            le type Jardinn Où Parc (blonde, brune, ruby, etc ...)
	 * @param sLatitude
	 *            latitude de Parc/Jardinn
	 * @param sLongitude
	 *            longitude Parc/Jardinn
	 * @param sAdderesse
	 *            l'address , localisation de Parc/Jardinn
	 */
	@RequestMapping(value = "/api/PJ", method = RequestMethod.POST)
	public void POSTParcJardinnLillios(@RequestParam("name") String sName, @RequestParam("desc") String sDescription,
			@RequestParam("type") String sType, @RequestParam("l") double sLatitude,
			@RequestParam("g") double sLongitude, @RequestParam("addresse") String sAdderesse) {

		ParcJardin parcJardinn = new ParcJardin(sName, sDescription, sType, sLatitude, sLongitude, sAdderesse);
		System.out.println("Post réussite contenus : " + parcJardinn);
	}
	
	@RequestMapping(value="/api/PJBysearch/{search}", method = RequestMethod.GET)
	public List<ParcJardin> getPJBySearch(@PathVariable("search") String search){
		
		List<ParcJardin> parcJardinn = new ArrayList<>();
		parcJardinn.add(new ParcJardin(search+"Name", search+"descriptionParc", search+"typeParc", 50.612156, 3.139263, search+"addresseParc"));
		return parcJardinn;
	}
	
	@RequestMapping(value="/api/PJByservice/{service}", method = RequestMethod.GET)
	public List<ParcJardin> getPJByService(@PathVariable("service") String service){
		
		String serviceGet = service.toUpperCase();
		List<ParcJardin> parcJardinn = new ArrayList<>();
		/*switch(serviceGet){
			case "PARC":
				parcJardinn.add(new ParcJardin(service+"Name", service+"descriptionParc", service+"typeParc",50.611881, 3.141374, service+"addresseParc"));
				break;
			case "JARDIN":
				parcJardinn.add(new ParcJardin(service+"Name", service+"descriptionParc", service+"typeParc",50.621881, 3.131374, service+"addresseParc"));
				break;
			case "FOOTING":
				parcJardinn.add(new ParcJardin(service+"Name", service+"descriptionParc", service+"typeParc",50.601881, 3.151374, service+"addresseParc"));
				break;
			case "ETUDE":
				parcJardinn.add(new ParcJardin(service+"Name", service+"descriptionParc", service+"typeParc",50.621881, 3.151374, service+"addresseParc"));
				break;
			case "RESTAURATION":
				parcJardinn.add(new ParcJardin(service+"Name", service+"descriptionParc", service+"typeParc",50.601881, 3.131374, service+"addresseParc"));
				break;
			case "PROMONER":
				parcJardinn.add(new ParcJardin(service+"Name", service+"descriptionParc", service+"typeParc",50.611081, 3.141074, service+"addresseParc"));
				break;
			case "ECOUTER":
				parcJardinn.add(new ParcJardin(service+"Name", service+"descriptionParc", service+"typeParc",50.613081, 3.141704, service+"addresseParc"));
				break;
			case "TOUT":
				parcJardinn.add(new ParcJardin(service+"Name", service+"descriptionParc", service+"typeParc",50.611881, 3.141374, service+"addresseParc"));
				parcJardinn.add(new ParcJardin(service+"Name", service+"descriptionParc", service+"typeParc",50.621881, 3.131374, service+"addresseParc"));
				parcJardinn.add(new ParcJardin(service+"Name", service+"descriptionParc", service+"typeParc",50.601881, 3.151374, service+"addresseParc"));
				parcJardinn.add(new ParcJardin(service+"Name", service+"descriptionParc", service+"typeParc",50.621881, 3.151374, service+"addresseParc"));
				parcJardinn.add(new ParcJardin(service+"Name", service+"descriptionParc", service+"typeParc",50.601881, 3.131374, service+"addresseParc"));
				parcJardinn.add(new ParcJardin(service+"Name", service+"descriptionParc", service+"typeParc",50.611081, 3.141074, service+"addresseParc"));
				parcJardinn.add(new ParcJardin(service+"Name", service+"descriptionParc", service+"typeParc",50.613081, 3.141704, service+"addresseParc"));
				
				break;
				
				
		}
		*/

		switch(service.toUpperCase()){
			case "PARC":
				return parcJardinInterfaceMetier.consulterPJByType("parc");
			case "JARDIN":
				return parcJardinInterfaceMetier.consulterPJByType("jardin");
			default:
				Categorie catTmp= categorieInterfaceMetier.ConsulterCategorieParNom(service);
				return parcJardinInterfaceMetier.chercherPJParCategorie(catTmp);


		}

	}
	
	@RequestMapping(value="/api/PJBylocalisation/{Latitude}/{Longitude}", method = RequestMethod.GET)
	public ParcJardin getPJByLatitudeLongitude(@PathVariable("Latitude") String Latitude,@PathVariable("Longitude") String Longitude){
		
		
		ParcJardin parcJardinn = new ParcJardin(Latitude+"/"+Longitude+"Parc Héron", Latitude+"/"+Longitude+"Parc héron un parc localiser à lille", Latitude+"/"+Longitude+"Parc", 50.612054, 3.139113, Latitude+"/"+Longitude+"Cité scientifuqe Ville neuve d'asq");
		return parcJardinn;
	}
	
	@RequestMapping(value="/api/categorieByPJ/{parcJardinn}", method = RequestMethod.GET)
	public List<Categorie> getCategorieByPJ(@PathVariable("parcJardinn") String parcJardinn){
		
		List<Categorie> categorie = new ArrayList<>();
		categorie.add(new Categorie("Etude"));
		categorie.add(new Categorie("Parc"));
		categorie.add(new Categorie("Restauration"));
		categorie.add(new Categorie("Ecouter"));
		return categorie;
	}
											 

	

}
