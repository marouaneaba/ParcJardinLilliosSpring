package com.lille1.ParcsJardinsLillios.Web;

import java.util.ArrayList;
import java.util.List;

import com.lille1.ParcsJardinsLillios.DAO.AdminRepository;
import com.lille1.ParcsJardinsLillios.Entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.lille1.ParcsJardinsLillios.Entity.Categorie;
import com.lille1.ParcsJardinsLillios.Entity.ParcJardin;
import com.lille1.ParcsJardinsLillios.Service.Interfaces.CategorieInterface;
import com.lille1.ParcsJardinsLillios.Service.Interfaces.ParcJardinInterface;




@Controller
public class CommentaireEditController {

	@Autowired
	private AdminRepository adminRepository;
	@Autowired
    private ParcJardinInterface parcJardinInterfaceMetier;
    @Autowired
    private CategorieInterface categorieInterfaceMetier;
	
	
	@GetMapping(value="/modificationParcJardin")
	public String ModificationParcJardinnLillios(Long id,Model model){
		
		model.addAttribute("Allcategories",categorieInterfaceMetier.consulterCategories());


        model.addAttribute("nouveauPJ", parcJardinInterfaceMetier.ChercherPJParId(id) );
        return "modificationparcjardin";
	}
	
	
	@PostMapping(value="/modifierParcJardinLillios")
	public RedirectView PostModificationParcJardinLillios(ParcJardin nouveauPJ,@RequestParam(value = "cats") List<Long> cats){
		
		
		List<Categorie> listCatTmp = new ArrayList<>();
        for(long idcat : cats){
    	     listCatTmp.add(categorieInterfaceMetier.ColsulterCategorieId(idcat));
        }

        for(Categorie tmpcat : listCatTmp){
    	    System.out.println("---------"+tmpcat.toString());
        }
        // TODO
        
      //  model.addAttribute("files", fileNames);
        //ParcJardin tmp = parcJardinRepository.save(nouveauPJ);
        //parcJardinInterfaceMetier.AjouterListCatToPJ(listCatTmp,tmp);
        return new RedirectView("/operationPJ");
	}
	
	@GetMapping(value="/ajouteAdmin")
	public String GETajoutAdmin(){
		
		return "ajoutadmin";
	}
	
	
	@PostMapping(value="/ajouteAdmin")
	public RedirectView PostajoutAdmin(@RequestParam("name") String name,@RequestParam("password") String password,
			@RequestParam("email_address") String email_address,@RequestParam("Tel") String Tel){
		
		//TODO
		adminRepository.save(new Admin(name,password,email_address,Tel));
		System.out.println(name+" , "+password+" , "+email_address);
		return new RedirectView("/operationPJ");
	}
	
	
	
	
	
	
	
	
	
	
}
