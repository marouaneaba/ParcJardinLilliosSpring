package com.lille1.parcsjardinslillios.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Ajoutimage {

	/**
	 * 
	 * @return
	 */
	@GetMapping(value = "/addImage")
	public String addimage() {
		return "addimage";
	}

}
