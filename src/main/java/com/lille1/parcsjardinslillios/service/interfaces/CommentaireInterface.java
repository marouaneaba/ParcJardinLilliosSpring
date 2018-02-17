package com.lille1.parcsjardinslillios.service.interfaces;

import java.util.List;
import com.lille1.parcsjardinslillios.entity.Commentaire;
import com.lille1.parcsjardinslillios.entity.ParcJardin;

public interface CommentaireInterface {

	public Commentaire ajouterCommentaire(Commentaire commentaire);

	public void validerCommentaire(Commentaire commentaire);

	public void supprimerCommentaire(Commentaire commentaire);

	public List<Commentaire> consulternouveauCommentaires();

	public List<Commentaire> consulterCommentaireByPJ(ParcJardin pj);

	public List<Commentaire> listeCommentaireParPJ(ParcJardin pj);

	public Commentaire consulterCommentaireParId(Long id);

	public List<Commentaire> consulterCommentaireNonValiderParPJ(ParcJardin pj);

	public List<Commentaire> consulterCommentaireValiderParPJ(ParcJardin pj);

}
