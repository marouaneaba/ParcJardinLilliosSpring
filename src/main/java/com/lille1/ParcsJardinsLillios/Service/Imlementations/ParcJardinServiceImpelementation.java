package com.lille1.ParcsJardinsLillios.Service.Imlementations;

import com.lille1.ParcsJardinsLillios.DAO.ParcJardinRepository;
import com.lille1.ParcsJardinsLillios.Entity.Categorie;
import com.lille1.ParcsJardinsLillios.Entity.Commentaire;
import com.lille1.ParcsJardinsLillios.Entity.Horaire;
import com.lille1.ParcsJardinsLillios.Entity.ParcJardin;
import com.lille1.ParcsJardinsLillios.Service.Interfaces.ParcJardinInterface;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class ParcJardinServiceImpelementation implements ParcJardinInterface {


    @Autowired
    ParcJardinRepository parcJardinRepository;

    @Override
    public List<ParcJardin> ConsulterParcsJardin() {
        return parcJardinRepository.findAll();
    }

    @Override
    public void JardinnSet(Long idPJ , String name, String description, double l, double g, String adresse) {

    }

    @Override
    public List<ParcJardin> ChercherPJParMotCle(String KeyWordJP) {
        return null;
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
        if(parcJardin != null)
            return true;
        else
            return false;
    }

    @Override
    public void SupprimerPJ(ParcJardin PJ) {
        try {
            parcJardinRepository.delete(PJ);
        }catch(Exception e){
            e.printStackTrace();
        }

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
    public List<Horaire> ConsulterHorairesPJ(Long idPJ) {
        ParcJardin PJ = parcJardinRepository.findById(idPJ);
        return PJ.getHoraire();
    }

    @Override
    public void ModifierHorairesPJ(ParcJardin PJ, List<Horaire> horaire) {

    }

    @Override
    public List<Commentaire> ConsulterCommentairesPJ(ParcJardin PJ) {
        return PJ.getCommentaire();
    }

    @Override
    public ParcJardin ajouterCommentaireToPJ(Commentaire commentaire, ParcJardin PJ) {
        Hibernate.initialize(PJ.getCommentaire());
        PJ.getCommentaire().add(commentaire);
        return parcJardinRepository.save(PJ);
    }

    @Override
    public ParcJardin supprimerCommetaireFromPJ(Commentaire commentire, ParcJardin PJ) {
        PJ.getCommentaire().remove(commentire);
        return parcJardinRepository.save(PJ);
    }

    @Override
    public List<Categorie> ConsulterCategoriesPJ(ParcJardin PJ) {
        return PJ.getCategorie();
    }

    @Override
    public ParcJardin ajouterCategorieToPJ(Categorie categorie, ParcJardin PJ) {
        Hibernate.initialize(PJ.getCategorie());
        PJ.getCategorie().add(categorie);
        return parcJardinRepository.save(PJ);
    }

    @Override
    public ParcJardin supprimerCategorieFromPJ(Categorie categorie, ParcJardin PJ) {
        PJ.getCategorie().remove(categorie);
        return parcJardinRepository.save(PJ);
    }


}
