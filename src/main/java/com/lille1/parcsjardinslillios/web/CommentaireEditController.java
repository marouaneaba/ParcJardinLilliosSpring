package com.lille1.parcsjardinslillios.web;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;
import com.lille1.parcsjardinslillios.entity.Categorie;
import com.lille1.parcsjardinslillios.entity.ParcJardin;
import com.lille1.parcsjardinslillios.entity.User;
import com.lille1.parcsjardinslillios.repository.ParcJardinRepository;
import com.lille1.parcsjardinslillios.repository.UserRepository;
import com.lille1.parcsjardinslillios.service.interfaces.CategorieInterface;
import com.lille1.parcsjardinslillios.service.interfaces.ParcJardinInterface;

@Controller
public class CommentaireEditController {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ParcJardinInterface parcJardinInterfaceMetier;
	@Autowired
	private CategorieInterface categorieInterfaceMetier;
	@Autowired
	private ParcJardinRepository parcJardinRepository;

	/**
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/modificationParcJardin")
	public String modificationParcJardinnLillios(long id, Model model) {

		model.addAttribute("Allcategories", categorieInterfaceMetier.consulterCategories());
		model.addAttribute("nouveauPJ", parcJardinInterfaceMetier.chercherPJParId(id));
		return "modificationparcjardin";
	}

	/**
	 * 
	 * @param id
	 * @param nouveauPJ
	 * @param cats
	 * @return
	 */
	@PostMapping(value = "/modifierParcJardinLillios")
	public RedirectView postModificationParcJardinLillios(long id, ParcJardin nouveauPJ,
			@RequestParam(value = "cats") List<Long> cats) {

		ParcJardin tmp = parcJardinInterfaceMetier.chercherPJParId(id);
		List<Categorie> listCatTmp = new ArrayList<>();
		for (long idcat : cats) {
			listCatTmp.add(categorieInterfaceMetier.colsulterCategorieId(idcat));
		}

		parcJardinInterfaceMetier.modifierPJ(tmp, nouveauPJ.getName(), nouveauPJ.getDescription(),
				nouveauPJ.getAdresse(), nouveauPJ.getLatitude(), nouveauPJ.getLongitude(), nouveauPJ.getType(),
				listCatTmp);
		parcJardinRepository.save(tmp);
		return new RedirectView("/operationPJ");
	}

	/**
	 * 
	 * @return
	 */
	@GetMapping(value = "/ajouteAdmin")
	public String getAjoutAdmin() {

		return "ajoutadmin";
	}

	/**
	 * 
	 * @param name
	 * @param password
	 * @param email_address
	 * @param Tel
	 * @return
	 */
	@PostMapping(value = "/ajouteAdmin")
	public RedirectView postAjoutAdmin(@RequestParam("name") String name, @RequestParam("password") String password,
			@RequestParam("email_address") String emailAddress, @RequestParam("Tel") String tel) {

		userRepository.save(new User(name, password, emailAddress, tel));
		return new RedirectView("/operationPJ");
	}

}
