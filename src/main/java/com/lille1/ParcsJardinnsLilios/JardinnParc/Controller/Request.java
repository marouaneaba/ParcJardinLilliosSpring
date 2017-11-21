package com.lille1.ParcsJardinnsLilios.JardinnParc.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lille1.ParcsJardinnsLilios.JardinnParc.Entity.ParcJardinn;
import com.lille1.ParcsJardinnsLilios.JardinnParc.Repository.ParcJardinnRepostory;

@RestController
@RequestMapping("/jardinn")
public class Request {

	@Autowired
	ParcJardinnRepostory mParcJardinnRepostory;
	
	@RequestMapping(method = RequestMethod.GET)
	 public Iterable<ParcJardinn> JardinnGet() {
		return mParcJardinnRepostory.findAll();
	 }
	
	
	@RequestMapping(method = RequestMethod.POST)
	 public void JardinnSet(@RequestParam("name")String name,
				@RequestParam("description")String description) {
		mParcJardinnRepostory.save(new ParcJardinn(name,description));
	 }
	
}
