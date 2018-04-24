package com.siperpus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LiteratureController {
	  @RequestMapping("/")
	    public String index ()
	    {
	        return "index";
	    }
}
