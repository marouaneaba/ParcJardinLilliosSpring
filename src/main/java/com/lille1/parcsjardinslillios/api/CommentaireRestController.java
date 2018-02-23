package com.lille1.parcsjardinslillios.api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.lille1.parcsjardinslillios.entity.Commentaire;
import com.lille1.parcsjardinslillios.service.interfaces.CommentaireInterface;
import com.lille1.parcsjardinslillios.service.interfaces.ParcJardinInterface;

@RestController
public class CommentaireRestController {

	@Autowired
	private CommentaireInterface mCommentaireInterface;

	@Autowired
	private ParcJardinInterface mParcJardinInterface;



	/**
	 * 
	 * @param sIdparcJardin
	 * @return
	 */
	@GetMapping(value = "/api/CommentaireByPJ/{ParcJardin}")
	public List<Commentaire> getCommentaireByPJ(@PathVariable("ParcJardin") Long sIdparcJardin) {

		return mCommentaireInterface
				.consulterCommentaireValiderParPJ(mParcJardinInterface.chercherPJParId(sIdparcJardin));
	}

	/**
	 * 
	 * @param sId
	 * @param sName
	 * @param sNbrEtoile
	 * @param sCommentaire
	 * @return
	 */
	@GetMapping(value = "/api/PostCommentaire/{idPJ}/{name}/{nbrEtoile}/{commentaire}")
	public Commentaire postCommentaire(@PathVariable("idPJ") Long sId, @PathVariable("name") String sName,
			@PathVariable("nbrEtoile") int sNbrEtoile, @PathVariable("commentaire") String sCommentaire) {

		Commentaire commentaire = new Commentaire(sCommentaire, sNbrEtoile, sName, false,
				mParcJardinInterface.chercherPJParId(sId));
		return mCommentaireInterface.ajouterCommentaire(commentaire);

	}

}
