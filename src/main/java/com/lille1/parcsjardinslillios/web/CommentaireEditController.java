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
	public String ModificationParcJardinnLillios(long id, Model model) {

		model.addAttribute("Allcategories", categorieInterfaceMetier.consulterCategories());

		System.out.println("avant modifi pj " + id);
		model.addAttribute("nouveauPJ", parcJardinInterfaceMetier.ChercherPJParId(id));
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
	public RedirectView PostModificationParcJardinLillios(long id, ParcJardin nouveauPJ,
			@RequestParam(value = "cats") List<Long> cats) {

		ParcJardin tmp = parcJardinInterfaceMetier.ChercherPJParId(id);
		List<Categorie> listCatTmp = new ArrayList<>();
		for (long idcat : cats) {
			listCatTmp.add(categorieInterfaceMetier.ColsulterCategorieId(idcat));
		}

		for (Categorie tmpcat : listCatTmp) {
			System.out.println("---------" + tmpcat.toString());
		}

		System.out.println("id pj a modifier " + id);

		parcJardinInterfaceMetier.modifierPJ(tmp, nouveauPJ.getName(), nouveauPJ.getDescription(),
				nouveauPJ.getAdresse(), nouveauPJ.getL(), nouveauPJ.getG(), nouveauPJ.getType(), listCatTmp);
		parcJardinRepository.save(tmp);

		// model.addAttribute("files", fileNames);
		// ParcJardin tmp = parcJardinRepository.save(nouveauPJ);
		// parcJardinInterfaceMetier.AjouterListCatToPJ(listCatTmp,tmp);
		return new RedirectView("/operationPJ");
	}

	/**
	 * 
	 * @return
	 */
	@GetMapping(value = "/ajouteAdmin")
	public String GETajoutAdmin() {

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
	public RedirectView PostajoutAdmin(@RequestParam("name") String name, @RequestParam("password") String password,
			@RequestParam("email_address") String email_address, @RequestParam("Tel") String Tel) {

		// TODO
		userRepository.save(new User(name, password, email_address, Tel));
		System.out.println(name + " , " + password + " , " + email_address);
		return new RedirectView("/operationPJ");
	}

}
