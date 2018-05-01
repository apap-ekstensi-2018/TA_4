package com.siperpus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import com.siperpus.service.LiteratureService;
import com.siperpus.model.LiteratureModel;

@Controller
public class LiteratureController {
 
	
	@Autowired
    LiteratureService literatureDAO;
	
	  
	  
	  @RequestMapping("/literature/viewall")
	    public String view (Model model)
	    {
	        List<LiteratureModel> literature = literatureDAO.selectAllLiteratures ();
	        model.addAttribute ("literatures", literature);

	        return "viewall";
	    }
 
	 
}
