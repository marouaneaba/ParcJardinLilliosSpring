package com.lille1.ParcsJardinsLillios.ApiRest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lille1.ParcsJardinsLillios.Entity.Commentaire;


@RestController
public class CommentaireRestController {
	
	List<Commentaire> commentaires = new ArrayList<Commentaire>();

	/**
	 * Permet delister toutes les commentaires d'un Parc/Jardinn Lillios via une
	 * requête GET http://localhost:8080/api/commentaire
	 *
	 * @return
	 */
	/*@RequestMapping(value = "/api/Commentaire", method = RequestMethod.GET)
	public List<Commentaire> GetCommentaire() {
		List<Commentaire> commentaire = new ArrayList<>();
		commentaire.add(new Commentaire("commentaire 1 ", true));
		return commentaire;
	}*/

	/**
	 * Permet d'enregistrer un nouvelle Parc/Jardinns via une requête POST :
	 * http://localhost:8080/api/beers
	 *
	 * @param sId
	 *            le Id de commentaire
	 * @param sCommentaire
	 *            la description de comentaire
	 * @param sConfirmer
	 *            true : le commentaire est confirmer par l'administrateur Où Non.
	 */
	@RequestMapping(value = "/api/Commentaire", method = RequestMethod.POST)
	public String POSTCommentaire(@RequestParam("name") String name,@RequestParam("nbrEtoile") int nbrEtoile,
			@RequestParam("commentaire") String sCommentaire,@RequestParam("id")Long id) {

		Commentaire commentaire = new Commentaire(name,nbrEtoile,sCommentaire, false);
		System.out.println("Post réussite contenus : " + commentaire);
		
		if(sCommentaire.isEmpty() )
			return "failed";
		
		return "suuccees : Id : "+id+" , Name : "+name+" , nbrEtoile : "+nbrEtoile+" , commentaire = "+sCommentaire;
	}
	
	
	@RequestMapping(value = "/api/CommentaireByPJ/{ParcJardin}", method = RequestMethod.GET)
	public List<Commentaire> getCommentaireByPJ(@PathVariable("ParcJardin")String parcJardin) {

		Commentaire commentaire1 = new Commentaire("anonymous",3,"marouane : mon nom anonymous, "
				+ "je trouve il faut détailler les arbre , souvent quand je passe me matin me rendre "
				+ "triste", false);
		System.out.println("Post réussite contenus : " + commentaire1);
		
		Commentaire commentaire2 = new Commentaire("toto",5,"marouane : une trés belle vous , heureux d'avoir "
				+ "des parc comme celle si dans notre ville , merci infinitivement ;)", false);
		System.out.println("Post réussite contenus : " + commentaire2);
		
		List<Commentaire> commentaires = new ArrayList<Commentaire>();
		commentaires.add(commentaire1);
		commentaires.add(commentaire2);
		
		return commentaires;
	}
	
	@RequestMapping(value = "/api/PostCommentaire/{name}/{nbrEtoile}/{commentaire}", method = RequestMethod.GET)
	public Commentaire PostCommentaire(@PathVariable("name")String sName,@PathVariable("nbrEtoile")int snbrEtoile,
			@PathVariable("commentaire")String sCommentaire){
		
		Commentaire commentaire = new Commentaire(sName,snbrEtoile,sCommentaire,false);
		commentaires.add(commentaire);
		if(commentaire != null)
			return commentaire;
		
		return null;
	}
	
	@RequestMapping(value = "/api/CommentaireNonConfirmer", method = RequestMethod.GET)
	public List<Commentaire> CommentaireNonConfirmer(@PathVariable("name")String sName,@PathVariable("nbrEtoile")int snbrEtoile,
			@PathVariable("commentaire")String sCommentaire){
		
		List<Commentaire> commentairesConfirmer = new ArrayList<Commentaire>();
		
		for(int i=0;i<commentaires.size();i++){
			if(commentaires.get(i).isConfirmer())
				commentairesConfirmer.add(commentaires.get(i));
		}
		
		return commentairesConfirmer;
	}

}
