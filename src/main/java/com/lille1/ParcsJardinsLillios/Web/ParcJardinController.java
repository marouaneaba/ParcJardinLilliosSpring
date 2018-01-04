package com.lille1.ParcsJardinsLillios.Web;


import com.lille1.ParcsJardinsLillios.DAO.ParcJardinRepository;
import com.lille1.ParcsJardinsLillios.Entity.ParcJardin;
import com.lille1.ParcsJardinsLillios.Service.Interfaces.ParcJardinInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ParcJardinController {

    @Autowired
    private ParcJardinRepository parcJardinRepository;
    @Autowired
    private ParcJardinInterface parcJardinInterfaceMetier;

    @RequestMapping(value="/operationPJ", method = RequestMethod.GET)
    public String index(Model model){
        List<ParcJardin> listPJ = parcJardinInterfaceMetier.ConsulterParcsJardin();
        model.addAttribute("allParcsJardins" , new ArrayList<>(parcJardinRepository.findAll())  );
        return "parcJardin";
    }







   @RequestMapping(value="/supprimerPJ")
    public String supprimerPJ(Model model, ParcJardin PJ){
return "parcJardin";
   }




}
