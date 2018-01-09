package com.lille1.ParcsJardinsLillios.Web;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import com.lille1.ParcsJardinsLillios.DAO.ParcJardinRepository;
import com.lille1.ParcsJardinsLillios.Entity.ParcJardin;
import com.lille1.ParcsJardinsLillios.Service.Interfaces.ParcJardinInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;


@Controller
public class ParcJardinController {
    private final Logger logger = LoggerFactory.getLogger(ParcJardinController.class);
    @Autowired
    private ParcJardinRepository parcJardinRepository;
    @Autowired
    private ParcJardinInterface parcJardinInterfaceMetier;


    @RequestMapping(value="/", method = RequestMethod.GET)
    public String index(Model model){
        logger.debug("index()");
        return "redirect:/operationPJ";
    }


    @RequestMapping(value="/operationPJ", method = RequestMethod.GET)
    public String showAllPJ(Model model){
        List<ParcJardin> listPJ = parcJardinInterfaceMetier.ConsulterParcsJardin();
        model.addAttribute("allParcsJardins" , new ArrayList<>(listPJ)  );
        return "parcJardin";
    }


   @RequestMapping(value="/operationPJ/delete", method = RequestMethod.POST)
    public String supprimerPJ(Long id, final RedirectAttributes redirectAttributes){
        ParcJardin PJ =parcJardinInterfaceMetier.ChercherPJParId(id);
        parcJardinInterfaceMetier.SupprimerPJ(PJ);


        redirectAttributes.addFlashAttribute("css" , "success");
        redirectAttributes.addFlashAttribute("msg", "ParcJardin est supprimer");

        return "redirect:/operationPJ";
   }


   @RequestMapping(value = "/operationPJ/update", method = RequestMethod.PUT )
   public String modifierPJ(ParcJardin pj){
        return "ModifierPJ";
   }

   @PostMapping(value="/AjouterPJ")
    public String ajouterPJ(ParcJardin nouveauPJ){
        parcJardinRepository.save(nouveauPJ);
        return "AjouterPJ";
   }



}
