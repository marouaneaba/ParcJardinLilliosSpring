package com.lille1.ParcsJardinsLillios.ApiRest;


import com.lille1.ParcsJardinsLillios.DAO.HoraireRepository;
import com.lille1.ParcsJardinsLillios.Entity.Horaire;
import com.lille1.ParcsJardinsLillios.Entity.ParcJardin;
import com.lille1.ParcsJardinsLillios.Service.Interfaces.ParcJardinInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping(value="/api/horaire/{idParcJardin}")
    public List<Horaire> gethoraire(@PathVariable("idParcJardin") Long idParcJardin){
        ParcJardin tmp = mParcJardinInterface.ChercherPJParId(idParcJardin);
        return horaireRepository.findByParcJardin(tmp);
    }
}
