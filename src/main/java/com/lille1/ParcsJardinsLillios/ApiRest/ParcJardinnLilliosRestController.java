package com.lille1.ParcsJardinsLillios.ApiRest;


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

import com.lille1.ParcsJardinsLillios.DAO.CategorieRepository;
import com.lille1.ParcsJardinsLillios.DAO.ParcJardinRepository;
import com.lille1.ParcsJardinsLillios.Entity.*;
import com.lille1.ParcsJardinsLillios.Service.Imlementations.ParcJardinServiceImpelementation;
import com.lille1.ParcsJardinsLillios.Service.Interfaces.CategorieInterface;
import com.lille1.ParcsJardinsLillios.Service.Interfaces.CommentaireInterface;
import com.lille1.ParcsJardinsLillios.Service.Interfaces.ParcJardinInterface;


@RestController
public class ParcJardinnLilliosRestController {
	@Autowired
	private ParcJardinInterface parcJardinInterfaceMetier;
	@Autowired
	private CategorieInterface categorieInterfaceMetier;
	@Autowired
	private CommentaireInterface commentaireInterfaceMetier;
	@Autowired
	private ParcJardinRepository mParcJardinRepository;
	@Autowired
	private CategorieRepository mCategorieRepository;
	@Autowired
	private ParcJardinServiceImpelementation mParcJardinServiceImpelementation;
	/**
	 * Permet delister toutes les Parc/Jardinns Lillios via une requête GET
	 * http://localhost:8080/api/beers
	 *
	 * @return
	 */
	@RequestMapping(value = "/api/PJ", method = RequestMethod.GET)
	public List<ParcJardin> GetParcJardinnLillios() {
		//List<ParcJardin> parcJardinn = new ArrayList<>();
		
		//parcJardinn.add(new ParcJardin("AllnameParc", "AlldescriptionParc", "AlltypeParc", 1.0, 2.0, "AlladdresseParc"));
		return mParcJardinServiceImpelementation.ConsulterParcsJardin();
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
		mParcJardinServiceImpelementation.AjouterPJ(parcJardinn);
		//System.out.println("Post réussite contenus : " + parcJardinn);
	}
	
	@RequestMapping(value="/api/PJBysearch/{search}", method = RequestMethod.GET)
	public List<ParcJardin> getPJBySearch(@PathVariable("search") String search){
		
		return mParcJardinRepository.findByNameContaining(search);
	
	}
	
	@RequestMapping(value="/api/PJByservice/{service}", method = RequestMethod.GET)
	public List<ParcJardin> getPJByService(@PathVariable("service") String service){
		
		

		switch(service.toUpperCase()){
			case "PARC":
				return parcJardinInterfaceMetier.consulterPJByType("PARC");
			case "JARDIN":
				return parcJardinInterfaceMetier.consulterPJByType("JARDIN");
			default:
				Categorie catTmp= categorieInterfaceMetier.ConsulterCategorieParNom(service);
				return parcJardinInterfaceMetier.chercherPJParCategorie(catTmp);


		}

	}
	
	@RequestMapping(value="/api/PJBylocalisation/{Latitude}/{Longitude}", method = RequestMethod.GET)
	public ParcJardin getPJByLatitudeLongitude(@PathVariable("Latitude") double Latitude,@PathVariable("Longitude") double Longitude){
		
		return mParcJardinServiceImpelementation.chercherPJLG(Latitude, Longitude);
		
	}
	
	@RequestMapping(value="/api/categorieByPJ/{id}", method = RequestMethod.GET)
	public List<Categorie> getCategorieByPJ(@PathVariable("id") Long idParcJadin){
		

		return mCategorieRepository.findByParcJardinnId(idParcJadin);
	}
											 

	

}
