package com.lille1.parcsjardinslillois.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.lille1.parcsjardinslillois.entity.Horaire;
import com.lille1.parcsjardinslillois.entity.ParcJardin;
import com.lille1.parcsjardinslillois.repository.HoraireRepository;
import com.lille1.parcsjardinslillois.repository.ParcJardinRepository;

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

		ParcJardin tmp = parcJardinRepository.findById(id);
		horaireRepository.save(new Horaire(ouverture, fermeture, journee, tmp));
		return "redirect:/operationPJ";
	}

}
