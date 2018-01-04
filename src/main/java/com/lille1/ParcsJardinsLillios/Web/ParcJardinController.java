package com.lille1.ParcsJardinsLillios.Web;


import com.lille1.ParcsJardinsLillios.Service.Interfaces.ParcJardinInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ParcJardinController {


    @Autowired
    private ParcJardinInterface parcJardinInterfaceMetier;

    @RequestMapping(value="/operationPJ")
    public String index(Model model){
        return "parcJardin";
    }



}
