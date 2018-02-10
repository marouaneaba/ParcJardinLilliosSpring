package com.lille1.ParcsJardinsLillios.Service.Imlementations;

import com.lille1.ParcsJardinsLillios.DAO.CommentaireRepository;
import com.lille1.ParcsJardinsLillios.DAO.ParcJardinRepository;
import com.lille1.ParcsJardinsLillios.Entity.Commentaire;
import com.lille1.ParcsJardinsLillios.Entity.ParcJardin;
import com.lille1.ParcsJardinsLillios.Service.Interfaces.CommentaireInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


@Service
@Transactional
public class CommentaireServiceImplementation implements CommentaireInterface{

    @Autowired
    CommentaireRepository commentaireRepository;
    @Autowired
    ParcJardinRepository parcJardinRepository;

    @Override
    public Commentaire AjouterCommentaire(Commentaire commentaire) {
         return commentaireRepository.save(commentaire);


    }

    @Override
    public void ValiderCommentaire(Commentaire commentaire) throws Exception {
/*
        ParcJardin tmpPJ = null;

        *//*Commentaire Tmp =commentaireRepository.findById(commentaire.getId());
        Tmp.setConfirmer(true);*//*
        for (ParcJardin pj : parcJardinRepository.findAll()){
            for(Commentaire com : pj.getCommentaires()){
                if(com.getId().equals(commentaire.getId())) {
                    tmpPJ = pj;
                    pj.getCommentaires().get(pj.getCommentaires().indexOf(com)).setConfirmer(true);
                    System.out.println("afficher le parc qui contien le com"+pj.toString());
                }
            }
        }

        if(tmpPJ==null)
            throw new Exception("commentaire a valider non trouve");

        return parcJardinRepository.save(tmpPJ);*/


        commentaire.setConfirmer(true);
        commentaireRepository.save(commentaire);

    }

    @Override
    public void SupprimerCommentaire(Commentaire commentaire) {
       /* ParcJardin tmpPJ = null;
        for (ParcJardin pj : parcJardinRepository.findAll()){
            for(Commentaire com : pj.getCommentaires()){
                if(com.getId().equals( commentaire.getId())) {
                    tmpPJ = pj;
                    pj.getCommentaires().remove(com);

                }
            }
        }

        parcJardinRepository.save(tmpPJ);
        commentaireRepository.delete(commentaire);
*/
        commentaireRepository.delete(commentaire);
    }

    @Override
    public List<Commentaire> ConsulternouveauCommentaires() {
        return commentaireRepository.findByConfirmer(false);
    }

    @Override
    public List<Commentaire> ConsulterCommentaireByPJ(ParcJardin PJ) {
        return commentaireRepository.findByParcJardinn(PJ);
    }


    /*@Override
    public List<Commentaire> ConsulterNouveauCommentaire(boolean confirm) {

        return commentaireRepository.findByConfirmer(false);
    }*/

    @Override
    public List<Commentaire> ListeCommentaireParPJ(ParcJardin PJ) {
        return commentaireRepository.findByParcJardinn(PJ);
    }

    @Override
    public Commentaire ConsulterCommentaireParId(Long id) {
        return commentaireRepository.findById(id);
    }


}
