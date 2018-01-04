package com.lille1.ParcsJardinsLillios.Service.Imlementations;

import com.lille1.ParcsJardinsLillios.DAO.CommentaireRepository;
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

    @Override
    public Commentaire AjouterCommentaire(Commentaire commentaire) {
         return commentaireRepository.save(commentaire);


    }

    @Override
    public Commentaire ValiderCommentaire(Commentaire commentaire) {
        commentaire.setConfirmer(true);
        return commentaireRepository.save(commentaire);
    }

    @Override
    public void SupprimerCommentaire(Commentaire commentaire) {

        commentaireRepository.delete(commentaire);
    }


    @Override
    public List<Commentaire> ConsulterNouveauCommentaire(boolean confirm) {

        return commentaireRepository.findByConfirmer(false);
    }

    @Override
    public List<Commentaire> ListeCommentaireParPJ(ParcJardin PJ) {
        return null;
    }


}
