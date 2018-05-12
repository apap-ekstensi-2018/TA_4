package com.siperpus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.siperpus.service.PeminjamanService;

import lombok.extern.slf4j.Slf4j;
import com.siperpus.model.PeminjamanModel;

@Controller
public class PeminjamanController {

	  
	@Autowired
	PeminjamanService peminjamanDAO;
	
	
	@RequestMapping("/peminjaman/view")
    public String view (Model model,
            @RequestParam(value = "id", required = false) Integer id)
    {
        PeminjamanModel peminjaman = peminjamanDAO.selectPeminjaman(id);

        if (peminjaman != null) {
            model.addAttribute ("peminjaman",peminjaman);
            return "view";
        } else {
            model.addAttribute ("id",id);
            return "not-found";
        }
    }


    @RequestMapping("/peminjaman/view/{id}")
    public String viewPath (Model model,
            @PathVariable(value = "id") Integer id)
    {
        PeminjamanModel peminjaman = peminjamanDAO.selectPeminjaman(id);

        if (peminjaman != null) {
            model.addAttribute ("peminjaman", peminjaman);
            return "view";
        } else {
            model.addAttribute ("id", id);
            return "not-found";
        }
    }


	  
	  
 
	 
}
