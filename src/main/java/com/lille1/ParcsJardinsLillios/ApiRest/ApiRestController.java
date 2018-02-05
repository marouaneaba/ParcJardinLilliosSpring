
package com.lille1.ParcsJardinsLillios.ApiRest;


import com.lille1.ParcsJardinsLillios.Entity.Categorie;
import com.lille1.ParcsJardinsLillios.Entity.Commentaire;
import com.lille1.ParcsJardinsLillios.Entity.ParcJardin;
import com.lille1.ParcsJardinsLillios.Service.Interfaces.CategorieInterface;
import com.lille1.ParcsJardinsLillios.Service.Interfaces.CommentaireInterface;
import com.lille1.ParcsJardinsLillios.Service.Interfaces.ParcJardinInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiRestController {
    @Autowired
    private ParcJardinInterface parcJardinInterfaceMetier;
    @Autowired
    private CategorieInterface categorieInterfaceMetier;
    @Autowired
    private CommentaireInterface commentaireInterfaceMetier;


    //confirmer
    //retourn tt les categories
    @GetMapping(value="/api/Categorie")
        public List<Categorie> consulterCategorie(){
        return categorieInterfaceMetier.consulterCategories();
    }

    //confirmer
    //retourn tt les parc et jardin
    @GetMapping(value="/api/PJ")
    public List<ParcJardin> consulterPJAll(){
        return parcJardinInterfaceMetier.ConsulterParcsJardin();
    }



//chercher PJ par mot cle
   /* @GetMapping(value="/api/PJBysearch/{search}")
    public List<ParcJardin> chercherPJmc(String mc){

    }*/



    //confirmer
    //chercher les parc par une categorie
    @GetMapping(value="/api/PJByservice/{service}")
    public List<ParcJardin> chercherPJservice(@PathVariable String service){
        Categorie catTmp= categorieInterfaceMetier.ConsulterCategorieParNom(service);
        return parcJardinInterfaceMetier.chercherPJParCategorie(catTmp);
    }


    //confirmer
    //chercher pj par L et G
    @GetMapping(value="/api/PJBylocalisation/{Latitude}/{Longitude}")
    public ParcJardin chercherPJLG(@PathVariable Long Latitude,@PathVariable Long Longitude){
        return parcJardinInterfaceMetier.chercherPJLG(Latitude,Longitude);
    }


    //confirmer mais a discuter
    @GetMapping(value="/api/categorieByPJ/{IdPJ}")
    public List<Categorie> consulterCatPJ(@PathVariable long IdPJ){
        ParcJardin pj= parcJardinInterfaceMetier.ChercherPJParId(IdPJ);
        return parcJardinInterfaceMetier.ConsulterCategoriesPJ(pj);
    }



    //Commentaire par par id de pj
     @GetMapping(value="/api/CommentairesByParcJardinn/{idPJ}")
    public List<Commentaire> consulterComPJ(@PathVariable long idPJ){
        ParcJardin pjtmp=parcJardinInterfaceMetier.ChercherPJParId(idPJ);
        return commentaireInterfaceMetier.ListeCommentaireParPJ(pjtmp);

    }


    @PostMapping(value="/api/commentaireAjouter/{idPJ}")
    public void ajouterCommentaire(@PathVariable Long idPJ, Commentaire com){
        ParcJardin pj=parcJardinInterfaceMetier.ChercherPJParId(idPJ);
        parcJardinInterfaceMetier.ajouterCommentaireToPJ(com,pj);
    }










}

