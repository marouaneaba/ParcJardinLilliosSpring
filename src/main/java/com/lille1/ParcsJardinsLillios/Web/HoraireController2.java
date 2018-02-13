package com.lille1.ParcsJardinsLillios.Web;

import com.lille1.ParcsJardinsLillios.DAO.HoraireRepository;
import com.lille1.ParcsJardinsLillios.Entity.Horaire;
import com.lille1.ParcsJardinsLillios.Entity.ParcJardin;
import com.lille1.ParcsJardinsLillios.Service.Interfaces.HoraireInterface;
import com.lille1.ParcsJardinsLillios.Service.Interfaces.ParcJardinInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HoraireController2 {
    @Autowired
    HoraireInterface horaireInterfaceMetier;
    @Autowired
    HoraireRepository horaireRepository;
    @Autowired
    ParcJardinInterface parcJardinInterfaceMetier;


    @GetMapping(value="/Operatiohoraire")
    public String GetOperationHoraire(Model model){
    return "operationHoraire";
    }


    @GetMapping(value="/chercherHoraireParPJ")
    public String ChercherHoraireParPJ(Model model , String PJ, String PJNom){
        ParcJardin foundPJ = parcJardinInterfaceMetier.chercherPJParNom(PJNom);
        List<Horaire> foundHoraire = horaireRepository.findByParcJardin(foundPJ);
        model.addAttribute("foundHoraires", foundHoraire);
        return "operationHoraire";
    }


    @GetMapping(value="/ModifierHoraire")
    public String GetModifierHoraire(Long idH,Model model){
        Horaire tmphoraire = horaireRepository.findById(idH);
        model.addAttribute("horaireAmodifer", tmphoraire);
        return "modifierhoraire";
    }


    @PostMapping(value="/ModifierHoraire")
    public String PostModifierHoraire(Model model, Horaire horaire, Long idH){
horaireInterfaceMetier.ModifierHorairePJ(idH,horaire.getJournee(),horaire.getOuverture(), horaire.getFermeture());

        return "operationHoraire";

    }

    @PostMapping(value="/nhoraire/delete")
    public String deteleHoraire(Long idH){
        Horaire tmp =horaireRepository.findById(idH);
        horaireRepository.delete(tmp);
        return "operationHoraire";
    }


}
