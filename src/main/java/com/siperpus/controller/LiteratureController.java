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
<<<<<<< HEAD
	
	@Autowired
    LiteratureService literatureDAO;
	
	  @RequestMapping("/")
	    public String index ()
	    {
	        return "index";
	    }
	  
	  @RequestMapping("/literature/viewall")
	    public String view (Model model)
	    {
	        List<LiteratureModel> literature = literatureDAO.selectAllLiteratures ();
	        model.addAttribute ("literatures", literature);

	        return "viewall";
	    }
=======
	@RequestMapping("/literature")
	public String index () {
	 return "literature_index";
	}
>>>>>>> 4beacfac125cba4f45aaa4d61d5d58d235695ee6
}
