package com.lille1.parcsjardinslillios.service.interfaces;

import java.util.List;
import com.lille1.parcsjardinslillios.entity.Commentaire;
import com.lille1.parcsjardinslillios.entity.ParcJardin;

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
