package com.lille1.ParcsJardinnsLilios.JardinnParc.Controller;

import org.springframework.web.bind.annotation.*;

@RestController

public class Request {

	
	@RequestMapping("/jardinn")
	public String getJardinn(){
		return new String("hello World");
	}
	
}
