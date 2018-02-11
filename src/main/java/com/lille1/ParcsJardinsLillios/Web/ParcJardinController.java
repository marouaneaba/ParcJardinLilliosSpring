package com.lille1.ParcsJardinsLillios.Web;

import com.lille1.ParcsJardinsLillios.Entity.Categorie;
import com.lille1.ParcsJardinsLillios.Service.Interfaces.CategorieInterface;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import com.lille1.ParcsJardinsLillios.DAO.ParcJardinRepository;
import com.lille1.ParcsJardinsLillios.Entity.ParcJardin;
import com.lille1.ParcsJardinsLillios.Service.Interfaces.ParcJardinInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;


@Controller
public class ParcJardinController {
    private final Logger logger = LoggerFactory.getLogger(ParcJardinController.class);

    @Autowired
    private CategorieInterface categorieInterfaceMetier;
    @Autowired
    private ParcJardinRepository parcJardinRepository;
    @Autowired
    private ParcJardinInterface parcJardinInterfaceMetier;



    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        logger.debug("index()");
        return "redirect:/operationPJ";
    }


    @RequestMapping(value = "/operationPJ", method = RequestMethod.GET)
    public String showAllPJ(Model model) {
        List<ParcJardin> listPJ = parcJardinInterfaceMetier.ConsulterParcsJardin();
        model.addAttribute("allParcsJardins", new ArrayList<>(listPJ));
        return "parcJardin";
    }


    @RequestMapping(value = "/operationPJ/delete", method = RequestMethod.POST)
    public String supprimerPJ(Long id, final RedirectAttributes redirectAttributes) {
        ParcJardin PJ = parcJardinInterfaceMetier.ChercherPJParId(id);
        parcJardinInterfaceMetier.SupprimerPJ(PJ);


        redirectAttributes.addFlashAttribute("css", "success");
        redirectAttributes.addFlashAttribute("msg", "ParcJardin est supprimer");

        return "redirect:/operationPJ";
    }


    @RequestMapping(value = "/operationPJ/update", method = RequestMethod.PUT)
    public String modifierPJ(ParcJardin pj) {
        return "ModifierPJ";
    }

    // http://localhost:8080/images/imageApp/image1.jpg
    @PostMapping(value = "/AjouterPJ")
    public String ajouterPJ( ParcJardin nouveauPJ,
    		@RequestParam(value = "cats") List<Long> cats,
    		@ModelAttribute("uploadForm") List<MultipartFile> uploadForm, Model model
    		,@RequestParam("file1") MultipartFile file,@RequestParam("file2") MultipartFile file2,
    		@RequestParam("file3") MultipartFile file3,@RequestParam("file4") MultipartFile file4,
    		@RequestParam("file5") MultipartFile file5) {

    	List<MultipartFile> files = new ArrayList<>();
    	files.add(file);
    	files.add(file2);
    	files.add(file3);
    	files.add(file4);
    	files.add(file5);
    	
    	for(int i=0;i<files.size();i++){
    		if(!files.get(i).isEmpty()){
        		
        		try{
        			byte[] bytes = files.get(i).getBytes();
        			
        			
        			File dir = new File("./src/main/resources/static/images/"+nouveauPJ.getName() );
        			if (!dir.exists())
    					dir.mkdirs();

    				// Create the file on server
    				File serverFile = new File(dir.getAbsolutePath()+ File.separator + nouveauPJ.getName()+i+".jpg");
    				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
    				stream.write(bytes);
    				stream.close();


    				System.out.println("You successfully uploaded file");
        		}catch(Exception e){
        			System.out.println(e.getMessage());
        		}
        	}
    	}
    	
  
        if (cats != null) {
            for (int i = 0; i < cats.size(); i++) {
                //nouveauPJ.getCategorie().add(cats.get(i));

            }
        }
        List<Categorie> listCatTmp = new ArrayList<>();
        for(long idcat : cats){
    	     listCatTmp.add(categorieInterfaceMetier.ColsulterCategorieId(idcat));
        }

        for(Categorie tmpcat : listCatTmp){
    	    System.out.println("---------"+tmpcat.toString());
        }
      //  model.addAttribute("files", fileNames);
        ParcJardin tmp = parcJardinRepository.save(nouveauPJ);
        parcJardinInterfaceMetier.AjouterListCatToPJ(listCatTmp,tmp);


        return "redirect:/operationPJ";
    }
    
    @RequestMapping("/chercherPJParNom")
    public String ChercherPJParNom(Model model,@RequestParam(value = "PJNom") String PJNom){
        ParcJardin pj = parcJardinInterfaceMetier.chercherPJParNom(PJNom);
        model.addAttribute("allParcsJardins", pj);

        return "parcJardin";
    }


}


