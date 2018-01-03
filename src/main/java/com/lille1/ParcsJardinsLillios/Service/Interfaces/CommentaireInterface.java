package com.lille1.ParcsJardinsLillios.Service.Interfaces;

import java.util.List;

import com.lille1.ParcsJardinsLillios.Entity.Commentaire;

public interface CommentaireInterface {

	public Commentaire AjouterCommentaire(Commentaire commentaire);

	public Commentaire ValiderCommentaire(Commentaire commentaire);
	
	public void SupprimerCommentaire(Commentaire commentaire);

	public List<Commentaire> ConsulterNouveauCommentaire(boolean confirm);



	
	
}
