
package com.lille1.ParcsJardinsLillios.ApiRest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.*;
import com.lille1.ParcsJardinsLillios.DAO.ParcJardinRepository;
import com.lille1.ParcsJardinsLillios.Entity.*;
import com.lille1.ParcsJardinsLillios.Service.Interfaces.CategorieInterface;
import com.lille1.ParcsJardinsLillios.Service.Interfaces.ParcJardinInterface;

@RestController
public class ParcJardinnLilliosRestController {

	@Autowired
	private ParcJardinInterface mParcJardinInterface;

	@Autowired
	private CategorieInterface mCategorieInterface;
	
	@Autowired
	private ParcJardinRepository mParcJardinRepository;

	/**
	 * Permet de récupérer tous les parc jardin Lillios enregistrer via une requête GET :
	 * http://localhost:8080/api/PJ
	 * 
	 */
	@GetMapping(value = "/api/PJ")
	public List<ParcJardin> GetParcJardinnLillios() {

		return mParcJardinInterface.ConsulterParcsJardin();
	}

	/**
	 * Permet de récupérer les parc jardinn Lillios à partir un MotCle de nom Parc/Jardin via une requête GET :
	 * http://localhost:8080/api/PJBysearch/{search}
	 *
	 * @param sSearch
	 *            le MotCle d'un Parc/Jardin Lillios
	 */
	@RequestMapping(value = "/api/PJBysearch/{search}", method = RequestMethod.GET)
	public List<ParcJardin> GetParcJardinnLilliosByMotCle(@PathVariable("search") String sSearch) {
		
		return mParcJardinRepository.findByNameContaining(sSearch);
	}

	/**
	 * Permet de récupérer les parc jardinn Lillios à partir un service via une requête GET :
	 * http://localhost:8080/api/PJByservice/{service}
	 *
	 * @param sService
	 *            le nom d'un service liée à un parc Jardin Lillios  via une requête GET
	 */
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

	/**
	 * Permet d'enregistrer un nouvelle Parc/Jardinns via une requête POST :
	 * http://localhost:8080/api/PJById/{idParcJardinnLillios}
	 *
	 * @param sId
	 *            le nom
	 */
	@GetMapping(value = "/api/PJById/{idParcJardinnLillios}")
	public ParcJardin GetParcJardinLilliosById(@PathVariable("idParcJardinnLillios") Long sId) {

		return mParcJardinInterface.ChercherPJParId(sId);

	}
	
	/**
	 * Permet d'enregistrer un nouvelle Parc/Jardinns via une requête POST :
	 * http://localhost:8080/api/PJByName/{NameParcJardinLillios}
	 *
	 * @param sId
	 *            le nom
	 */
	@GetMapping(value = "/api/PJByName/{NameParcJardinLillios}")
	public ParcJardin GetParcJardinLilliosByName(@PathVariable("NameParcJardinLillios") String name) {

		return mParcJardinInterface.chercherPJParNom(name);

	}

}
