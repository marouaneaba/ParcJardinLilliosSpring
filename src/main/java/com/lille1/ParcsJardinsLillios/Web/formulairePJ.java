package com.lille1.ParcsJardinsLillios.Web;

import com.lille1.ParcsJardinsLillios.DAO.ParcJardinRepository;
import com.lille1.ParcsJardinsLillios.Entity.ParcJardin;
import com.lille1.ParcsJardinsLillios.Service.Interfaces.ParcJardinInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class formulairePJ {

    @Autowired
    private ParcJardinInterface parcJardinInterfaceMetier;



    @GetMapping(value="/AjouterPJ")
    public String afficherFormulairePJ(Model model){
        model.addAttribute("nouveauPJ", new ParcJardin());
        return "AjouterPJ";
    }


}
