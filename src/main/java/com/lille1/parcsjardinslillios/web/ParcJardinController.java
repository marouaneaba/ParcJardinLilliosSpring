package com.lille1.parcsjardinslillios.web;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.lille1.parcsjardinslillios.entity.Categorie;
import com.lille1.parcsjardinslillios.entity.Horaire;
import com.lille1.parcsjardinslillios.entity.ParcJardin;
import com.lille1.parcsjardinslillios.repository.HoraireRepository;
import com.lille1.parcsjardinslillios.repository.ParcJardinRepository;
import com.lille1.parcsjardinslillios.service.interfaces.CategorieInterface;
import com.lille1.parcsjardinslillios.service.interfaces.ParcJardinInterface;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ParcJardinController {
	private final Logger logger = LoggerFactory.getLogger(ParcJardinController.class);

	private static final String ALLPARCSJARDINS = "allParcsJardins";
	private static final String REDIRECTOPERATIONPJ = "redirect:/operationPJ";
	
	@Autowired
	private CategorieInterface categorieInterfaceMetier;
	@Autowired
	private ParcJardinRepository parcJardinRepository;
	@Autowired
	private ParcJardinInterface parcJardinInterfaceMetier;
	@Autowired
	private HoraireRepository horaireRepository;

	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		
		return REDIRECTOPERATIONPJ;
	}

	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/operationPJ", method = RequestMethod.GET)
	public String showAllPJ(Model model) {
		List<ParcJardin> listPJ = parcJardinInterfaceMetier.consulterParcsJardin();
		model.addAttribute(ALLPARCSJARDINS, new ArrayList<>(listPJ));
		
		return "parcJardin";
	}

	/**
	 * 
	 * @param id
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value = "/operationPJ/delete", method = RequestMethod.POST)
	public String supprimerPJ(Long id, final RedirectAttributes redirectAttributes) {
		ParcJardin parcJardin = parcJardinInterfaceMetier.chercherPJParId(id);
		parcJardinInterfaceMetier.supprimerPJ(parcJardin);

		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("msg", "ParcJardin est supprimer");

		return REDIRECTOPERATIONPJ;
	}

	/**
	 * 
	 * @param pj
	 * @return
	 */
	@RequestMapping(value = "/operationPJ/update", method = RequestMethod.PUT)
	public String modifierPJ(ParcJardin pj) {
		return "ModifierPJ";
	}

	// http://localhost:8080/images/imageApp/image1.jpg

	/**
	 * 
	 * @param nouveauPJ
	 * @param hlundi
	 * @param hmardi
	 * @param hmercredi
	 * @param hjeudi
	 * @param hvendredi
	 * @param hsamedi
	 * @param hdimanche
	 * @param cats
	 * @param uploadForm
	 * @param model
	 * @param file
	 * @param file2
	 * @param file3
	 * @param file4
	 * @param file5
	 * @return
	 */
	@PostMapping(value = "/AjouterPJ")
	public String ajouterPJ(ParcJardin nouveauPJ, Horaire hlundi, Horaire hmardi, Horaire hmercredi, Horaire hjeudi,
			Horaire hvendredi, Horaire hsamedi, Horaire hdimanche, @RequestParam(value = "cats") List<Long> cats,
			@ModelAttribute("uploadForm") List<MultipartFile> uploadForm, Model model,
			@RequestParam("file1") MultipartFile file, @RequestParam("file2") MultipartFile file2,
			@RequestParam("file3") MultipartFile file3, @RequestParam("file4") MultipartFile file4,
			@RequestParam("file5") MultipartFile file5) {

		List<MultipartFile> files = new ArrayList<>();
		files.add(file);
		files.add(file2);
		files.add(file3);
		files.add(file4);
		files.add(file5);
		
		
		
		for (int i = 0; i < files.size(); i++) {
			if (!files.get(i).isEmpty()) {

				BufferedOutputStream stream = null;
				try {
					byte[] bytes = files.get(i).getBytes();

					String namePrcJardin = nouveauPJ.getName();
					File dir = new File("./src/main/resources/static/images/" + namePrcJardin.replaceAll(" ", "_"));
					if (!dir.exists())
						dir.mkdirs();

					File serverFile = new File(
							dir.getAbsolutePath() + File.separator + namePrcJardin.replaceAll(" ", "_") + i + ".jpg");
					stream = new BufferedOutputStream(new FileOutputStream(serverFile));
					stream.write(bytes);
					

				} catch (Exception e) {
					logger.info(e.getMessage());
				}finally {
					try {
						stream.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}

		List<Categorie> listCatTmp = new ArrayList<>();
		for (long idcat : cats) {
			listCatTmp.add(categorieInterfaceMetier.colsulterCategorieId(idcat));
		}

		ParcJardin tmp = parcJardinRepository.save(nouveauPJ);
		parcJardinInterfaceMetier.ajouterListCatToPJ(listCatTmp, tmp);


		hlundi.setParcJardin(tmp);
		horaireRepository.save(hlundi);


		hmardi.setParcJardin(tmp);
		horaireRepository.save(hmardi);

		hmercredi.setParcJardin(tmp);
		horaireRepository.save(hmercredi);

		hjeudi.setParcJardin(tmp);
		horaireRepository.save(hjeudi);

		hvendredi.setParcJardin(tmp);
		horaireRepository.save(hvendredi);

		hsamedi.setParcJardin(tmp);
		horaireRepository.save(hsamedi);

		hdimanche.setParcJardin(tmp);
		horaireRepository.save(hdimanche);

		return REDIRECTOPERATIONPJ;
	}

	/**
	 * 
	 * @param model
	 * @param PJNom
	 * @return
	 */
	@RequestMapping("/chercherPJParNom")
	public String chercherParcJardinParNom(Model model, @RequestParam(value = "PJNom") String parcJardinNom) {

		if (parcJardinNom.equals("")) {
			model.addAttribute(ALLPARCSJARDINS, parcJardinInterfaceMetier.consulterParcsJardin());
		} else {
			ParcJardin pj = parcJardinInterfaceMetier.chercherPJParNom(parcJardinNom);
			model.addAttribute(ALLPARCSJARDINS, pj);
		}

		return "parcJardin";
	}

}
