package com.lille1.parcsjardinslillios.service.interfaces;

import java.util.List;
import com.lille1.parcsjardinslillios.entity.Commentaire;
import com.lille1.parcsjardinslillios.entity.ParcJardin;

public interface CommentaireInterface {

	public Commentaire AjouterCommentaire(Commentaire commentaire);

	public void ValiderCommentaire(Commentaire commentaire) throws Exception;

	public void SupprimerCommentaire(Commentaire commentaire);

	public List<Commentaire> ConsulternouveauCommentaires();

	public List<Commentaire> ConsulterCommentaireByPJ(ParcJardin pj);

	public List<Commentaire> ListeCommentaireParPJ(ParcJardin pj);

	public Commentaire ConsulterCommentaireParId(Long id);

	public List<Commentaire> ConsulterCommentaireNonValiderParPJ(ParcJardin pj);

	public List<Commentaire> ConsulterCommentaireValiderParPJ(ParcJardin pj);

}
