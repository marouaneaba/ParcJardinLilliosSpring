package com.lille1.ParcsJardinsLillios.Service.Interfaces;

import java.util.List;

import com.lille1.ParcsJardinsLillios.Entity.Commentaire;

public interface CommentaireInterface {

	public void AjouterCommentaire(Long idPJ);
	
	public List<Commentaire> ConsulterCommentaire(boolean confirm);
	
	public List<Commentaire> ConsulterCommentaireParPJ(Long PJ);
	
	
	
}
