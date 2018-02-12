package com.lille1.ParcsJardinsLillios.Service.Interfaces;

import java.util.List;

import com.lille1.ParcsJardinsLillios.Entity.Commentaire;
import com.lille1.ParcsJardinsLillios.Entity.ParcJardin;

public interface CommentaireInterface {

	public Commentaire AjouterCommentaire(Commentaire commentaire);

	public void ValiderCommentaire(Commentaire commentaire) throws Exception;
	
	public void SupprimerCommentaire(Commentaire commentaire);

	public List<Commentaire> ConsulternouveauCommentaires();
	public List<Commentaire> ConsulterCommentaireByPJ(ParcJardin PJ);

	public List<Commentaire> ListeCommentaireParPJ(ParcJardin PJ);

	public Commentaire ConsulterCommentaireParId(Long id);

	public List<Commentaire> ConsulterCommentaireNonValiderParPJ(ParcJardin PJ);
	public List<Commentaire> ConsulterCommentaireValiderParPJ(ParcJardin PJ);



	
	
}
