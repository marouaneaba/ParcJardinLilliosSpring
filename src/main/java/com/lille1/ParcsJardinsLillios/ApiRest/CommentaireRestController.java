
package com.lille1.ParcsJardinsLillios.ApiRest;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.lille1.ParcsJardinsLillios.Entity.Commentaire;
import com.lille1.ParcsJardinsLillios.Service.Interfaces.CommentaireInterface;
import com.lille1.ParcsJardinsLillios.Service.Interfaces.ParcJardinInterface;


@RestController
public class CommentaireRestController {

	@Autowired
	private CommentaireInterface mCommentaireInterface;

	@Autowired
	private ParcJardinInterface mParcJardinInterface;

	/**
	 * Permet delister toutes les commentaires d'un Parc/Jardinn Lillios via une POST :
	 * requête GET http://localhost:8080/api/commentaire
	 *
	 * @return
	 */

	@PostMapping(value = "/api/Commentaire")
	public Commentaire POSTCommentaire(@RequestParam("name") String sName, @RequestParam("nbrEtoile") int sNbrEtoile,
			@RequestParam("commentaire") String sCommentaire, @RequestParam("idParcJardinLillios") Long sId) {

		return mCommentaireInterface.AjouterCommentaire(
				new Commentaire(sCommentaire, sNbrEtoile, sName, false, mParcJardinInterface.ChercherPJParId(sId)));

	}

	@GetMapping(value = "/api/CommentaireByPJ/{ParcJardin}")
	public List<Commentaire> getCommentaireByPJ(@PathVariable("ParcJardin") Long sIdparcJardin) {
		
		//return mCommentaireInterface.ConsulterCommentaireByPJ(mParcJardinInterface.ChercherPJParId(sIdparcJardin));
		return mCommentaireInterface.ConsulterCommentaireValiderParPJ(mParcJardinInterface.ChercherPJParId(sIdparcJardin));
	}

	@GetMapping(value = "/api/PostCommentaire/{idPJ}/{name}/{nbrEtoile}/{commentaire}")
	public Commentaire PostCommentaire( @PathVariable("idPJ") Long sId,@PathVariable("name") String sName,
			@PathVariable("nbrEtoile") int sNbrEtoile,
			@PathVariable("commentaire") String sCommentaire) {
		
		Commentaire commentaire = new Commentaire(sCommentaire, sNbrEtoile,sName , false, mParcJardinInterface.ChercherPJParId(sId));
		return mCommentaireInterface.AjouterCommentaire(commentaire);

	}

}
