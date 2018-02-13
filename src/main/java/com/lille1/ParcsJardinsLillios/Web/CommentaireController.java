package com.lille1.ParcsJardinsLillios.Web;


import com.lille1.ParcsJardinsLillios.Entity.Commentaire;
import com.lille1.ParcsJardinsLillios.Entity.ParcJardin;
import com.lille1.ParcsJardinsLillios.Service.Interfaces.CommentaireInterface;
import com.lille1.ParcsJardinsLillios.Service.Interfaces.ParcJardinInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CommentaireController {
    @Autowired
    CommentaireInterface commentaireInterfaceMetier;
    @Autowired
    ParcJardinInterface parcJardinInterfaceMetier;

    
    /**
     * 
     * @param model
     * @return
     */
    @GetMapping(value="/NouveauCommentaire")
    public String afficherNouveauCommentaire(Model model){
        //model.addAttribute("CommentairesByPJ", commentaireInterfaceMetier.);
        model.addAttribute("AllCommentaire", commentaireInterfaceMetier.ConsulternouveauCommentaires());
        return "Commentaire";
    }

    /**
     * 
     * @param id
     * @return
     */
    @PostMapping(value="/NouveauCommentaire/delete")
    public String supprimerCommentaire(Long id){
        Commentaire tmp = commentaireInterfaceMetier.ConsulterCommentaireParId(id);
        commentaireInterfaceMetier.SupprimerCommentaire(tmp);
        return "redirect:/NouveauCommentaire";
    }

    /**
     * 
     * @param id
     * @return
     * @throws Exception
     */
    @PostMapping(value="/NouveauCommentaire/confirmer")
    public String confirmerCommentaire(Long id) throws Exception {
        Commentaire tmp = commentaireInterfaceMetier.ConsulterCommentaireParId(id);
        commentaireInterfaceMetier.ValiderCommentaire(tmp);
        return "redirect:/NouveauCommentaire";
    }


    /**
     * 
     * @param model
     * @param PJNom
     * @return
     */
    @RequestMapping("/chercherCommentaireParNomPJ")
    public String  ChercherCommentaireParNomPJ(Model model, @RequestParam(value="PJNom") String PJNom){
    	
    	if(PJNom.equals("")){
    		model.addAttribute("AllCommentaire",commentaireInterfaceMetier.ConsulternouveauCommentaires());
    	}else{
    		ParcJardin tmp =parcJardinInterfaceMetier.chercherPJParNom(PJNom);
            List<Commentaire> listtmpCom =commentaireInterfaceMetier.ConsulterCommentaireNonValiderParPJ(tmp);
            model.addAttribute("AllCommentaire",listtmpCom);
    	}
        
        return "Commentaire";
    }


}
