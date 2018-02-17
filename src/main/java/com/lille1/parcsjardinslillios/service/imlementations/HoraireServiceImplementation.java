package com.lille1.parcsjardinslillios.service.imlementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lille1.parcsjardinslillios.entity.Horaire;
import com.lille1.parcsjardinslillios.repository.HoraireRepository;
import com.lille1.parcsjardinslillios.service.interfaces.HoraireInterface;
import com.lille1.parcsjardinslillios.service.interfaces.ParcJardinInterface;

import javax.transaction.Transactional;

@Service
@Transactional
public class HoraireServiceImplementation implements HoraireInterface {

	@Autowired
	ParcJardinInterface parcJardinInterface;
	@Autowired
	HoraireRepository horaireRepository;

	@Override
	public void modifierHorairePJ(Long idH, String journee, String ouverture, String fermeture) {

		Horaire tmph = horaireRepository.findById(idH);
		tmph.setJournee(journee);
		tmph.setOuverture(ouverture);
		tmph.setFermeture(fermeture);

		horaireRepository.save(tmph);
	}
}
