package com.lille1.parcsjardinslillios.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.lille1.parcsjardinslillios.entity.Horaire;
import com.lille1.parcsjardinslillios.entity.ParcJardin;
import com.lille1.parcsjardinslillios.repository.HoraireRepository;
import com.lille1.parcsjardinslillios.repository.ParcJardinRepository;

@Controller
public class HoraireController {

	@Autowired
	HoraireRepository horaireRepository;
	@Autowired
	ParcJardinRepository parcJardinRepository;

	/**
	 * 
	 * @param model
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/AjouterHoraire")
	public String getAjoutHoraire(Model model, long id) {
		System.out.println("id de pj " + id);
		model.addAttribute("id", id);
		return "horaire";
	}

	/**
	 * 
	 * @param journee
	 * @param ouverture
	 * @param fermeture
	 * @param id
	 * @return
	 */
	@PostMapping(value = "/toto")
	public String addHoraireToPJ(String journee, String ouverture, String fermeture, long id) {

		System.out.println("id de pj apres valider" + journee);
		ParcJardin tmp = parcJardinRepository.findById(id);
		horaireRepository.save(new Horaire(ouverture, fermeture, journee, tmp));
		return "redirect:/operationPJ";
	}

}
