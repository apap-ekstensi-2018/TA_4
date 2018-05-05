package com.siperpus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.siperpus.service.LiteratureService;
import com.siperpus.model.LiteratureModel;
import com.siperpus.model.MahasiswaModel;

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
	  
	  @RequestMapping("/literature/add")
	    public String add ()
	    {
	        return "form-add";
	    }
	  
	  @RequestMapping(value = "/literature/add/submit", method = RequestMethod.POST)
	    public String addSubmit (Model model,
	            @RequestParam(value = "judul", required = false) String judul,
	            @RequestParam(value = "penulis", required = false) String penulis,
	            @RequestParam(value = "penerbit", required = false) String penerbit,
	            @RequestParam(value = "jenis_literatur", required = false) String jenis_literatur,
	            @RequestParam(value = "jumlah", required = false) String jumlah)
	    {
	        LiteratureModel literature = new LiteratureModel ();
	        literature.setJudul(judul);
	        literature.setPenulis(penulis);
	        literature.setPenerbit(penerbit);
	        literature.setJenis_literatur(jenis_literatur);
	        literature.setJumlah(jumlah);
	        
	        literatureDAO.addLiterature (literature);

	        return "success-add";
	    }
	  
	  
	  	  @RequestMapping(value = "/literature/hapus/{id_literatur}", method = RequestMethod.POST)
	  public String delete(Model model, @PathVariable(value = "id_literatur") Integer id ) {
		  literatureDAO.deleteLiterature(id);
		  return "viewall";
	  }

	  
	  
 
	 
}
