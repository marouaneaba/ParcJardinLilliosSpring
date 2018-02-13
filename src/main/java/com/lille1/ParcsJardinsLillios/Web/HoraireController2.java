package com.lille1.ParcsJardinsLillios.Web;

import com.lille1.ParcsJardinsLillios.Entity.Horaire;
import com.lille1.ParcsJardinsLillios.Service.Interfaces.HoraireInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HoraireController2 {
    @Autowired
    HoraireInterface horaireInterfaceMetier;

    @GetMapping(value="/ModifierHoraire")
    public String GetModifierHoraire(){
        return "modifierHoraire";
    }


    @PostMapping(value="/ModifierHoraire")
    public String PostModifierHoraire(Model model, Horaire horaire, Long id){

        return null;

    }
}
