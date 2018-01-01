package com.lille1.ParcsJardinsLillios.UI.connexion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lille1.ParcsJardinsLillios.Entity.Admin;
import com.lille1.ParcsJardinsLillios.DAO.AdminRepository;


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
    public String connectUser(Model model, @RequestParam("username") String name,
            @RequestParam("password")String password){
        
    	Admin find = mAdminRepository.findByNameAndPassword(name, password); 
    	System.out.println("find : "+find.getName()+" , "+find.getPassword());
    	if(find != null ){
    		return "admin";
    	}
        return "erreur";
    }
}
// REST controller , jpa , method repository
