package com.siperpus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.siperpus.service.PeminjamanService; 
import com.siperpus.model.PeminjamanModel;

@Controller
public class PeminjamanController {
 
	
	@Autowired
    PeminjamanService peminjamanDAO;
	
	  
	  
	  @RequestMapping("/peminjaman/viewall")
	    public String view (Model model)
	    {
	        List<PeminjamanModel> literature = peminjamanDAO.selectAllPeminjaman();
	        model.addAttribute ("literatures", literature);

	        return "viewall";
	    }
	  
	  @RequestMapping("/peminjaman/add")
	    public String add ()
	    {
	        return "form-add-peminjaman";
	    }
	  
	  @RequestMapping(value = "/peminjaman/add/submit", method = RequestMethod.POST)
	    public String addSubmit (Model model,
	            @RequestParam(value = "id_literatur", required = false) int id_literatur,
	            @RequestParam(value = "username_peminjam", required = false) String penulis,
	            @RequestParam(value = "penerbit", required = false) String penerbit,
	            @RequestParam(value = "jenis_literatur", required = false) String jenis_literatur,
	            @RequestParam(value = "jumlah", required = false) String jumlah)
	    {
	        

	        return "viewall"; 
	    }
	  
	  @RequestMapping("/peminjaman/ubah/{id_literatur}")
	    public String updatePath (Model model,
	            @PathVariable(value = "id_literatur") int id_literatur)
	    {
		//  LiteratureModel literature = literatureDAO.selectLiterature(id_literatur);

	      //  if (literature != null) { 
	        //    model.addAttribute ("literature", literature);
	            
	       //     return "form-update";
	       // } else {
	        //    model.addAttribute ("id", id_literatur);
	          return "not-found";
	       // }
	    }
	  
	   
	  
 
	 
}
