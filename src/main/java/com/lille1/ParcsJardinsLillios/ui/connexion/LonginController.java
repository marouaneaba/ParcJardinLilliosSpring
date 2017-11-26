package com.lille1.ParcsJardinsLillios.ui.connexion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lille1.ParcsJardinsLillios.Entity.Admin;
import com.lille1.ParcsJardinsLillios.Repository.AdminRepository;


@Controller
/* aprés ma recherche j'ai trouvé on 
 * peux faire un controller avec restcontroller 
 * */
@RequestMapping("/connexion")
public class LonginController {

	
	@Autowired
    private AdminRepository mAdminRepository;
	
	@RequestMapping(method = RequestMethod.GET)
    public String createView(Model model){
        model.addAttribute("status","validé");
        return "connexion";
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String connectUser(Model model, @RequestParam("name") String name,
            @RequestParam("password")String password){
        
        //on connecte l'utilisateur
        //Admin admin = mAdminRepository.findByNameAndPassword(name, password);
        /*if(admin != null){
            model.addAttribute("status","connecté : " + admin.getName());
        }else{
            model.addAttribute("status","erreur");
        }*/
        return "connexion";
    }
}
