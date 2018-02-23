package com.lille1.parcsjardinslillois.service.imlementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.lille1.parcsjardinslillois.entity.Commentaire;
import com.lille1.parcsjardinslillois.entity.ParcJardin;
import com.lille1.parcsjardinslillois.repository.CommentaireRepository;
import com.lille1.parcsjardinslillois.repository.ParcJardinRepository;
import com.lille1.parcsjardinslillois.service.interfaces.CommentaireInterface;

import java.util.List;

@Service
@Transactional
public class CommentaireServiceImplementation implements CommentaireInterface {

	@Autowired
	CommentaireRepository commentaireRepository;
	@Autowired
	ParcJardinRepository parcJardinRepository;

	@Override
	public Commentaire ajouterCommentaire(Commentaire commentaire) {
		return commentaireRepository.save(commentaire);

	}

	@Override
	public void validerCommentaire(Commentaire commentaire) {

		commentaire.setConfirmer(true);
		commentaireRepository.save(commentaire);

	}

	@Override
	public void supprimerCommentaire(Commentaire commentaire) {

		commentaireRepository.delete(commentaire);
	}

	@Override
	public List<Commentaire> consulternouveauCommentaires() {
		return commentaireRepository.findByConfirmer(false);
	}

	@Override
	public List<Commentaire> consulterCommentaireByPJ(ParcJardin pj) {
		return commentaireRepository.findByParcJardinn(pj);
	}

	@Override
	public List<Commentaire> listeCommentaireParPJ(ParcJardin pj) {
		return commentaireRepository.findByParcJardinn(pj);
	}

	@Override
	public Commentaire consulterCommentaireParId(Long id) {
		return commentaireRepository.findById(id);
	}

	@Override
	public List<Commentaire> consulterCommentaireNonValiderParPJ(ParcJardin pj) {

		return commentaireRepository.findByConfirmerAndParcJardinn(false, pj);
	}

	@Override
	public List<Commentaire> consulterCommentaireValiderParPJ(ParcJardin pj) {

		return commentaireRepository.findByConfirmerAndParcJardinn(true, pj);
	}

}
