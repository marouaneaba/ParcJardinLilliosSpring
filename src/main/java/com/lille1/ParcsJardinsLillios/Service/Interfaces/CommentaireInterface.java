package com.lille1.ParcsJardinsLillios.Service.Interfaces;

import java.util.List;

import com.lille1.ParcsJardinsLillios.Entity.Commentaire;
import com.lille1.ParcsJardinsLillios.Entity.ParcJardin;

public interface CommentaireInterface {

	public Commentaire AjouterCommentaire(Commentaire commentaire);

	public ParcJardin ValiderCommentaire(Commentaire commentaire) throws Exception;
	
	public void SupprimerCommentaire(Commentaire commentaire);



	public List<Commentaire> ListeCommentaireParPJ(ParcJardin PJ);

	public Commentaire ConsulterCommentaireParId(Long id);



	
	
}
