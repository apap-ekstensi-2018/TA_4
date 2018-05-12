package com.siperpus.controller;

<<<<<<< HEAD
=======

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




>>>>>>> f6c0cd2b75d131f70c7ec6c5069e37bdd41d857e
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

<<<<<<< HEAD
import com.siperpus.service.PeminjamanService; 
import com.siperpus.model.PeminjamanModel;
=======
import com.siperpus.service.LiteratureService;
import com.siperpus.model.LiteratureModel;

>>>>>>> f6c0cd2b75d131f70c7ec6c5069e37bdd41d857e

@Controller
public class PeminjamanController {
 
	
	@Autowired
    PeminjamanService peminjamanDAO;
	
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
	  
<<<<<<< HEAD
	   
=======
	  @PostMapping(value = "/peminjaman/ubah/submit")
	    public String updateSubmit(@ModelAttribute LiteratureModel literatur, Model model)
	    {
	    	 	 if (literatur != null)
	    		{
	    	 		literatureDAO.updateLiterature(literatur); 
	    	 		 model.addAttribute("title", "Konfirmasi Update Student");
	    	         return "success-update";
	    		}
	    	 	 else	
	    	 	 {
	    	 		model.addAttribute("title", "Konfirmasi Update Student");
	    	         return "failed-update";
	    	 	 }
	    		
	           
	    }
	  
	  	  @RequestMapping(value = "/peminjaman/hapus/{id_literatur}", method = RequestMethod.GET)
	  public String delete(Model model, @PathVariable(value = "id_literatur") Integer id ) {
		  literatureDAO.deleteLiterature(id);
		  
		  List<LiteratureModel> literature = literatureDAO.selectAllLiteratures ();
	        model.addAttribute ("literatures", literature);

	        return "viewall"; 
	  }

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
	  
>>>>>>> f6c0cd2b75d131f70c7ec6c5069e37bdd41d857e
	  
 
	 
}}
