package com.lille1.parcsjardinslillios.service.imlementations;

import com.lille1.parcsjardinslillios.repository.CategorieRepository;
import com.lille1.parcsjardinslillios.repository.CommentaireRepository;
import com.lille1.parcsjardinslillios.repository.HoraireRepository;
import com.lille1.parcsjardinslillios.repository.ParcJardinRepository;
import com.lille1.parcsjardinslillios.entity.Categorie;
import com.lille1.parcsjardinslillios.entity.Commentaire;
import com.lille1.parcsjardinslillios.entity.Horaire;
import com.lille1.parcsjardinslillios.entity.ParcJardin;
import com.lille1.parcsjardinslillios.service.interfaces.ParcJardinInterface;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class ParcJardinServiceImpelementation implements ParcJardinInterface {
	@Autowired
	CommentaireRepository commentaireRepository;
	@Autowired
	HoraireRepository horaireRepository;
	@Autowired
	ParcJardinRepository parcJardinRepository;
	@Autowired
	CategorieRepository categorieRepository;
	@Autowired
	ParcJardinInterface parcJardinInterface;

	@Override
	public List<ParcJardin> ConsulterParcsJardin() {
		return parcJardinRepository.findAll();
	}

	@Override
	public ParcJardin AjouterListCatToPJ(List<Categorie> lcat, ParcJardin pj) {
		for (Categorie cat : lcat) {
			Categorie tmp = categorieRepository.findById(cat.getId());
			pj.setCategories(tmp);
		}
		return parcJardinRepository.save(pj);
	}

	@Override
	public ParcJardin ChercherPJParId(Long id) {
		ParcJardin pj = parcJardinRepository.findById(id);
		Hibernate.initialize(pj);
		return pj;
	}

	@Override
	public ParcJardin chercherPJParNom(String nomPj) {
		return parcJardinRepository.findByName(nomPj);
	}

	@Override
	public List<ParcJardin> chercherPJParCategorie(Categorie categorie) {
		return parcJardinRepository.findByCategories(categorie);
	}

	@Override
	public boolean AjouterPJ(ParcJardin pj) {
		ParcJardin parcJardin = parcJardinRepository.save(pj);
		return parcJardin != null ? true : false;
	}

	@Override
	public void SupprimerPJ(ParcJardin pj) {

		List<Categorie> listTmp1Cat = pj.getCategories();
		listTmp1Cat.clear();
		parcJardinRepository.save(pj);

		List<Commentaire> listTmpCom = commentaireRepository.findByParcJardinn(pj);
		for (Commentaire cm : listTmpCom) {
			commentaireRepository.delete(cm);
		}

		List<Horaire> listTmpH = horaireRepository.findByParcJardin(pj);
		for (Horaire h : listTmpH) {
			horaireRepository.delete(h);
		}
		parcJardinRepository.delete(pj);
	}

	@Override
	public ParcJardin ModifierDescriptionPJ(Long idPJ, String desc) {

		ParcJardin pj = parcJardinRepository.findById(idPJ);
		pj.setDescription(desc);
		return parcJardinRepository.save(pj);

	}

	@Override
	public ParcJardin ModifierNomPJ(Long idPJ, String nom) {
		ParcJardin pj = parcJardinRepository.findById(idPJ);
		pj.setName(nom);
		return parcJardinRepository.save(pj);

	}

	@Override
	public List<Categorie> ConsulterCategoriesPJ(Long idPJ) {
		ParcJardin parcJardin = parcJardinRepository.findById(idPJ);
		return parcJardin.getCategories();

	}

	@Override
	public ParcJardin ajouterCategorieToPJ(Categorie categorie, ParcJardin pj) {

		pj.setCategories(categorie);
		return parcJardinRepository.save(pj);

	}

	@Override
	public ParcJardin chercherPJLG(String l, String g) {
		return parcJardinRepository.trouverPJparLG(l, g);
	}

	@Override
	public List<ParcJardin> consulterPJByType(String type) {
		return parcJardinRepository.findByType(type);

	}

	@Override
	public void supprimercatFromPJ(Long idPJ) {

		ParcJardin pj = parcJardinRepository.findById(idPJ);

		List<Categorie> listTmp = pj.getCategories();
		listTmp.clear();

	}

	@Override
	public ParcJardin modifierPJ(ParcJardin pj, String name, String description, String adresse, String l, String g,
			String type, List<Categorie> cats) {

		pj.setName(name);
		pj.setDescription(description);
		pj.setAdresse(adresse);
		pj.setLatitude(l);
		pj.setLongitude(g);
		pj.setType(type);
		pj.setCategories(cats);

		return parcJardinRepository.save(pj);
	}

}
