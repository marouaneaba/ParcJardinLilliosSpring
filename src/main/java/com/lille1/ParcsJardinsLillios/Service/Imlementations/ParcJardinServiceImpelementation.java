package com.lille1.ParcsJardinsLillios.Service.Imlementations;

import com.lille1.ParcsJardinsLillios.DAO.CategorieRepository;
import com.lille1.ParcsJardinsLillios.DAO.CommentaireRepository;
import com.lille1.ParcsJardinsLillios.DAO.HoraireRepository;
import com.lille1.ParcsJardinsLillios.DAO.ParcJardinRepository;
import com.lille1.ParcsJardinsLillios.Entity.Categorie;
import com.lille1.ParcsJardinsLillios.Entity.Commentaire;
import com.lille1.ParcsJardinsLillios.Entity.Horaire;
import com.lille1.ParcsJardinsLillios.Entity.ParcJardin;
import com.lille1.ParcsJardinsLillios.Service.Interfaces.CategorieInterface;
import com.lille1.ParcsJardinsLillios.Service.Interfaces.ParcJardinInterface;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class ParcJardinServiceImpelementation implements ParcJardinInterface {
    @Autowired
    CommentaireRepository commentaireRepository;
    @Autowired
    HoraireRepository horaireRepository;
    @Autowired
    ParcJardinRepository parcJardinRepository;
    @Autowired
    CategorieRepository categorieRepository;
    @Autowired
    ParcJardinInterface parcJardinInterface;
    @Override
    public List<ParcJardin> ConsulterParcsJardin() {
        return parcJardinRepository.findAll();
    }

    @Override
    public ParcJardin JardinSet(ParcJardin pj ) {

    	return null;
    }

    @Override
    public List<ParcJardin> ChercherPJParMotCle(String KeyWordJP) {
        return null;
    }

    @Override
    public ParcJardin AjouterListCatToPJ(List<Categorie> lcat, ParcJardin PJ) {
        for (Categorie cat : lcat) {
            Categorie tmp = categorieRepository.findById(cat.getId());
            PJ.setCategories(tmp);
        }
        return parcJardinRepository.save(PJ);
    }

    @Override
    public ParcJardin ChercherPJParId(Long id) {
        ParcJardin PJ = parcJardinRepository.findById(id);
        Hibernate.initialize(PJ);
        return PJ;
    }

    @Override
    public ParcJardin chercherPJParNom(String nomPj) {
        return parcJardinRepository.findByName(nomPj);
    }

    @Override
    public List<ParcJardin> chercherPJParCategorie(Categorie categorie) {
        return parcJardinRepository.findByCategories(categorie);
    }

    @Override
    public boolean AjouterPJ(ParcJardin PJ) {
        ParcJardin parcJardin = parcJardinRepository.save(PJ);
        System.out.println("parc jardin ****** id : "+parcJardin.getId());
        if(parcJardin != null)
            return true;
        else
            return false;
    }

    @Override
    public void SupprimerPJ(ParcJardin PJ) {


        List<Categorie> listTmp1Cat =PJ.getCategories();
        listTmp1Cat.clear();
        parcJardinRepository.save(PJ);

        List<Commentaire> listTmpCom = commentaireRepository.findByParcJardinn(PJ);
        for (Commentaire cm : listTmpCom){
            commentaireRepository.delete(cm);
        }

        List<Horaire> listTmpH = horaireRepository.findByParcJardin(PJ);
        for (Horaire h : listTmpH){
            horaireRepository.delete(h);
        }
        parcJardinRepository.delete(PJ);
    }

    @Override
    public ParcJardin ModifierDescriptionPJ(Long idPJ, String desc) {

        ParcJardin PJ = parcJardinRepository.findById(idPJ);
        PJ.setDescription(desc);
        return parcJardinRepository.save(PJ);

    }

    @Override
    public ParcJardin ModifierNomPJ(Long idPJ, String nom) {
        ParcJardin PJ = parcJardinRepository.findById(idPJ);
        PJ.setName(nom);
        return parcJardinRepository.save(PJ);

    }



    @Override
    public void ModifierHorairesPJ(ParcJardin PJ, List<Horaire> horaire) {

    }



    @Override
    public List<Categorie> ConsulterCategoriesPJ(Long idPJ) {
        ParcJardin parcJardin = parcJardinRepository.findById(idPJ);
        return parcJardin.getCategories();

    }

    @Override
    public ParcJardin ajouterCategorieToPJ(Categorie categorie, ParcJardin PJ) {

        PJ.setCategories(categorie);
        return parcJardinRepository.save(PJ);

    }

    @Override
    public ParcJardin supprimerCategorieFromPJ(Categorie categorie, ParcJardin PJ) {

    	return null;
    }

    @Override
    public ParcJardin chercherPJLG(String l, String g) {
        return parcJardinRepository.trouverPJparLG(l, g);
    }

    @Override
    public List<ParcJardin> consulterPJByType(String type){
        return parcJardinRepository.findByType(type);

    }

    @Override
    public void supprimercatFromPJ(Long idPJ) {

        ParcJardin PJ = parcJardinRepository.findById(idPJ);

        List<Categorie> listTmp =PJ.getCategories();
        listTmp.clear();

    }

    @Override
    public ParcJardin modifierPJ(ParcJardin pj,String name,String description,String adresse, String l, String g, String type, List<Categorie> cats) {

        pj.setName(name);
        pj.setDescription(description);
        pj.setAdresse(adresse);
        pj.setL(l);
        pj.setG(g);
        pj.setType(type);
        pj.setCat(cats);


        return parcJardinRepository.save(pj);
    }




}
