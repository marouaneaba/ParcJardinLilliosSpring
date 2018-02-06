package com.lille1.ParcsJardinsLillios.Web;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class ajoutimage {

	
	
	
	@GetMapping(value="/addImage")
	public String addimage(){
		System.out.println("GET");
		return "addimage";
	}
	
	
	@PostMapping(value = "/addImagee")
    public void ajouterPJ( Model model,@RequestParam("file") MultipartFile file) {
    	System.out.println("arrivé");
    	if(!file.isEmpty()){
    		
    		try{
    			byte[] bytes = file.getBytes();
    			
    			
    			File dir = new File("./src/main/resources/static/images/imageApp" );
    			if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath()+ File.separator + "hello.jpg");
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();


				System.out.println("You successfully uploaded file");
    		}catch(Exception e){
    			System.out.println(e.getMessage());
    		}
    	} else {
			
		}
    }
}
