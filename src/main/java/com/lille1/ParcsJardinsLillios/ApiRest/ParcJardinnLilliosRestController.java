
package com.lille1.ParcsJardinsLillios.ApiRest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	private ParcJardinInterface mParcJardinInterface;

	@Autowired
	private CategorieInterface mCategorieInterface;

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
	@GetMapping(value = "/api/PJ")
	public List<ParcJardin> GetParcJardinnLillios() {

		return mParcJardinInterface.ConsulterParcsJardin();
	}

	@RequestMapping(value = "/api/PJBysearch/{search}", method = RequestMethod.GET)
	public List<ParcJardin> GetParcJardinnLilliosByMotCle(@PathVariable("search") String sSearch) {

		return mParcJardinInterface.ChercherPJParMotCle(sSearch);
	}

	@GetMapping(value = "/api/PJByservice/{service}")
	public List<ParcJardin> GetParcJardinnLilliosByService(@PathVariable("service") String sService) {
		switch (sService.toUpperCase()) {
		case "PARC":
			return mParcJardinInterface.consulterPJByType("PARC");
		case "JARDIN":
			return mParcJardinInterface.consulterPJByType("JARDIN");
		default:
			return mParcJardinInterface.chercherPJParCategorie(mCategorieInterface.ConsulterCategorieParNom(sService));
		}
	}

	// @PostMapping(value="")
	@GetMapping(value = "/api/PJById/{idParcJardinnLillios}")
	public ParcJardin GetParcJardinLilliosById(@PathVariable("idParcJardinnLillios") Long sId) {

		return mParcJardinInterface.ChercherPJParId(sId);

	}

	@GetMapping(value = "/api/categorieByPJ/{name}")
	public List<ParcJardin> GetCategorieByName(@PathVariable("name") String sNameCategorie) {
		return mParcJardinInterface.chercherPJParCategorie(mCategorieInterface.ConsulterCategorieParNom(sNameCategorie));
	}

}
