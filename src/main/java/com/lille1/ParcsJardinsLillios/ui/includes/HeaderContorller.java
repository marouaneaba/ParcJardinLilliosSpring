package com.lille1.ParcsJardinsLillios.ui.includes;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HeaderContorller {
	
	
	
	@RequestMapping("/header")
    public String createView(Model model){
        
        return "header";
    }
    
}
