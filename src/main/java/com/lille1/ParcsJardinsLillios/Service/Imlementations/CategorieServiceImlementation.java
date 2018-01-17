package com.lille1.ParcsJardinsLillios.Service.Imlementations;

import com.lille1.ParcsJardinsLillios.DAO.CategorieRepository;
import com.lille1.ParcsJardinsLillios.Entity.Categorie;
import com.lille1.ParcsJardinsLillios.Entity.ParcJardin;
import com.lille1.ParcsJardinsLillios.Service.Interfaces.CategorieInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class CategorieServiceImlementation implements CategorieInterface{
    @Autowired
    CategorieRepository categorieRepository;

    @Override
    public Categorie ColsulterCategorieId(Long id) {

        return categorieRepository.findById(id);
    }


    @Override
    public boolean AjouterCategoriePJ(Categorie categorie) {
        Categorie cat =categorieRepository.save(categorie);
        if(cat != null)
            return true;
        else
            return false;
    }


    @Override
    public void SupprimerCategorie(Long id) {
        try {
            categorieRepository.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public boolean ModifierCategorie(Categorie categorie, Long idCat) {
        Categorie cat = categorieRepository.findById(idCat);
        cat.setNomcategorie(categorie.getNomCategorie());

        categorieRepository.save(cat);

        return false;
    }

    @Override
    public List<Categorie> consulterCategories() {
        return categorieRepository.findAll();
    }

    @Override
    public List<ParcJardin> ConsulterParcJardinParCategorie(Categorie categorie) {
        return categorie.getParcJardinn();
    }



}
