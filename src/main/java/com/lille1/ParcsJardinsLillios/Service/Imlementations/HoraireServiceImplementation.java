package com.lille1.ParcsJardinsLillios.Service.Imlementations;

import com.lille1.ParcsJardinsLillios.DAO.HoraireRepository;
import com.lille1.ParcsJardinsLillios.Entity.Horaire;
import com.lille1.ParcsJardinsLillios.Entity.ParcJardin;
import com.lille1.ParcsJardinsLillios.Service.Interfaces.HoraireInterface;
import com.lille1.ParcsJardinsLillios.Service.Interfaces.ParcJardinInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class HoraireServiceImplementation implements HoraireInterface{

    @Autowired
    ParcJardinInterface parcJardinInterface;
    @Autowired
    HoraireRepository horaireRepository;
    @Override
    public void ModifierHorairePJ(Long idH, String journee, String ouverture, String fermeture) {

        Horaire tmph = horaireRepository.findById(idH);
        tmph.setJournee(journee);
        tmph.setOuverture(ouverture);
        tmph.setFermeture(fermeture);

        horaireRepository.save(tmph);
    }
}
