package com.lille1.ParcsJardinsLillios.Service.Imlementations;

import com.lille1.ParcsJardinsLillios.DAO.CommentaireRepository;
import com.lille1.ParcsJardinsLillios.DAO.ParcJardinRepository;
import com.lille1.ParcsJardinsLillios.Entity.Commentaire;
import com.lille1.ParcsJardinsLillios.Entity.ParcJardin;
import com.lille1.ParcsJardinsLillios.Service.Interfaces.CommentaireInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.ArrayList;
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


        commentaire.setConfirmer(true);
        commentaireRepository.save(commentaire);

    }

    @Override
    public void SupprimerCommentaire(Commentaire commentaire) {

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




    @Override
    public List<Commentaire> ListeCommentaireParPJ(ParcJardin PJ) {
        return commentaireRepository.findByParcJardinn(PJ);
    }

    @Override
    public Commentaire ConsulterCommentaireParId(Long id) {
        return commentaireRepository.findById(id);
    }

    @Override
    public List<Commentaire> ConsulterCommentaireNonValiderParPJ(ParcJardin PJ) {

        return commentaireRepository.findByConfirmerAndParcJardinn(false,PJ);
    }
    
    @Override
    public List<Commentaire> ConsulterCommentaireValiderParPJ(ParcJardin PJ) {

        return commentaireRepository.findByConfirmerAndParcJardinn(true,PJ);
    }


}
