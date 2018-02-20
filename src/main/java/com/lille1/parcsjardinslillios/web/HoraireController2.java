package com.lille1.parcsjardinslillios.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.lille1.parcsjardinslillios.entity.Horaire;
import com.lille1.parcsjardinslillios.entity.ParcJardin;
import com.lille1.parcsjardinslillios.repository.HoraireRepository;
import com.lille1.parcsjardinslillios.service.interfaces.HoraireInterface;
import com.lille1.parcsjardinslillios.service.interfaces.ParcJardinInterface;

import java.util.List;

@Controller
public class HoraireController2 {

	@Autowired
	HoraireInterface horaireInterfaceMetier;
	@Autowired
	HoraireRepository horaireRepository;
	@Autowired
	ParcJardinInterface parcJardinInterfaceMetier;
	private static String operationHoraire = "operationHoraire";

	/**
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/Operatiohoraire")
	public String getOperationHoraire(Model model) {
		return operationHoraire;
	}

	/**
	 * 
	 * @param model
	 * @param PJ
	 * @param PJNom
	 * @return
	 */
	@GetMapping(value = "/chercherHoraireParPJ")
	public String chercherHoraireParPJ(Model model, String pj, String pjNom) {
		ParcJardin foundPJ = parcJardinInterfaceMetier.chercherPJParNom(pjNom);
		List<Horaire> foundHoraire = horaireRepository.findByParcJardin(foundPJ);
		model.addAttribute("foundHoraires", foundHoraire);
		return operationHoraire;
	}

	/**
	 * 
	 * @param idH
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/ModifierHoraire")
	public String getModifierHoraire(Long idh, Model model) {
		Horaire tmphoraire = horaireRepository.findById(idh);
		model.addAttribute("horaireAmodifer", tmphoraire);
		return "modifierhoraire";
	}

	/**
	 * 
	 * @param model
	 * @param horaire
	 * @param idH
	 * @return
	 */
	@PostMapping(value = "/ModifierHoraire")
	public String postModifierHoraire(Model model, Horaire horaire, Long idh) {
		horaireInterfaceMetier.modifierHorairePJ(idh, horaire.getJournee(), horaire.getOuverture(),
				horaire.getFermeture());

		return operationHoraire;

	}

	/**
	 * 
	 * @param idH
	 * @return
	 */
	@PostMapping(value = "/nhoraire/delete")
	public String deteleHoraire(Long idH) {
		Horaire tmp = horaireRepository.findById(idH);
		horaireRepository.delete(tmp);
		return operationHoraire;
	}

}
