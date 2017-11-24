package com.lille1.ParcsJardinsLillios.ui.includes;

import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FooterController {

	
	@RequestMapping("/footer")
    public String createView(Model model){
        
        return "footer";
    }
}
