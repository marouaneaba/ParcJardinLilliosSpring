package com.lille1.ParcsJardinsLillios.Controller.Interface;

import java.util.List;

import com.lille1.ParcsJardinsLillios.Entity.Commentaire;

public interface InterfaceCommentaire {

	public void AjouterCommentaire(Long idPJ);
	
	public List<Commentaire> ConsulterCommentaire(boolean confirm);
	
	public List<Commentaire> ConsulterCommentaireParPJ(Long PJ);
	
	
	
}
