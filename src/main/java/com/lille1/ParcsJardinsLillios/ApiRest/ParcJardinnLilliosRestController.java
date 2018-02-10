
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
		
		return mParcJardinRepository.findByNameContaining(sSearch);
	}

	@GetMapping(value = "/api/PJByservice/{service}")
	public List<ParcJardin> GetParcJardinnLilliosByService(@PathVariable("service") String sService) {
		switch (sService.toUpperCase()) {
		case "PARC":
			return mParcJardinInterface.consulterPJByType("PARC");
		case "JARDIN":
			return mParcJardinInterface.consulterPJByType("JARDIN");
		default:
			return mParcJardinInterface.chercherPJParCategorie(mCategorieInterface.ConsulterCategorieParNom(sService).get(0));
		}
	}

	@GetMapping(value = "/api/PJById/{idParcJardinnLillios}")
	public ParcJardin GetParcJardinLilliosById(@PathVariable("idParcJardinnLillios") Long sId) {

		return mParcJardinInterface.ChercherPJParId(sId);

	}

}
