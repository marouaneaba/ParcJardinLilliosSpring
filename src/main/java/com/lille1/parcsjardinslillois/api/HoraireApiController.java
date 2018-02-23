package com.lille1.parcsjardinslillois.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.lille1.parcsjardinslillois.entity.Horaire;
import com.lille1.parcsjardinslillois.entity.ParcJardin;
import com.lille1.parcsjardinslillois.repository.HoraireRepository;
import com.lille1.parcsjardinslillois.service.interfaces.ParcJardinInterface;

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
		ParcJardin tmp = mParcJardinInterface.chercherPJParId(idParcJardin);
		return horaireRepository.findByParcJardin(tmp);
	}
}
