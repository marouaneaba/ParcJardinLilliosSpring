package com.lille1.parcsjardinslillios.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.lille1.parcsjardinslillios.entity.Horaire;
import com.lille1.parcsjardinslillios.entity.ParcJardin;
import com.lille1.parcsjardinslillios.repository.HoraireRepository;
import com.lille1.parcsjardinslillios.service.interfaces.ParcJardinInterface;

import java.util.List;

@RestController
public class HoraireApiController {

	@Autowired
	private HoraireRepository horaireRepository;

	@Autowired
	private ParcJardinInterface mParcJardinInterface;

	/**
	 * 
	 * @param idParcJardin
	 * @return
	 */
	@GetMapping(value = "/api/horaire/{idParcJardin}")
	public List<Horaire> gethoraire(@PathVariable("idParcJardin") Long idParcJardin) {
		ParcJardin tmp = mParcJardinInterface.ChercherPJParId(idParcJardin);
		return horaireRepository.findByParcJardin(tmp);
	}
}
