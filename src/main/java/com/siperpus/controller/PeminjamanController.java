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
 
import com.siperpus.service.LiteratureService;
import com.siperpus.model.LiteratureModel; 
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
	    
	    @RequestMapping("/peminjaman/ubahstatus/{id}")
	    public String viewPath (Model model,
	            @PathVariable(value = "id") String id)
	    {
	        PeminjamanModel peminjaman= peminjamanDAO.selectPeminjaman(Integer.valueOf(id));

	        if (peminjaman != null) {
	            model.addAttribute ("peminjaman", peminjaman);
	            return "form-update-status";
	        } else {
	            model.addAttribute ("id", id);
	            return "not-found";
	        }
	    }

	    @RequestMapping("/peminjaman/ubahstatus/submit")
	    public String submitUbahStatus (@ModelAttribute PeminjamanModel pm, Model model)
	    {
	        //PeminjamanModel peminjaman= peminjamanDao.selectPeminjaman(Integer.valueOf(id));
	    	
	        if (pm != null) {
	            peminjamanDAO.updateStatusPeminjaman(pm);
	        	//model.addAttribute ("peminjaman", pm);
	            return "form-update-status";
	        } else {
	            //model.addAttribute ("id", id);
	            return "not-found";
	        }
	    }
	    }
