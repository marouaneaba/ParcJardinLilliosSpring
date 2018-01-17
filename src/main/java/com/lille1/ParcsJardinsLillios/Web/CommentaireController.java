package com.lille1.ParcsJardinsLillios.Web;


import com.lille1.ParcsJardinsLillios.Entity.Commentaire;
import com.lille1.ParcsJardinsLillios.Service.Interfaces.CommentaireInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CommentaireController {
    @Autowired
    CommentaireInterface commentaireInterfaceMetier;


    @GetMapping(value="/NouveauCommentaire")
    public String afficherNouveauCommentaire(Model model){
        //model.addAttribute("CommentairesByPJ", commentaireInterfaceMetier.);
        model.addAttribute("AllCommentaire", commentaireInterfaceMetier.ConsulterNouveauCommentaire(false));
        return "Commentaire";
    }

    @PostMapping(value="/NouveauCommentaire/delete")
    public String supprimerCommentaire(Long id){
        Commentaire tmp = commentaireInterfaceMetier.ConsulterCommentaireParId(id);
        commentaireInterfaceMetier.ValiderCommentaire(tmp);
        return "redirect:/NouveauCommentaire";
    }

    @PostMapping(value="/NouveauCommentaire/confirmer")
    public String confirmerCommentaire(Long id){
        Commentaire tmp = commentaireInterfaceMetier.ConsulterCommentaireParId(id);
        commentaireInterfaceMetier.SupprimerCommentaire(tmp);
        return "redirect:/NouveauCommentaire";
    }



}
