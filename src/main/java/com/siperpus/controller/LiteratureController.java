package com.siperpus.controller;

import java.util.List;
import java.util.Optional;

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
import com.siperpus.service.PeminjamanService;
import com.siperpus.model.LiteratureModel;
import com.siperpus.model.PeminjamanModel;


@Controller
public class LiteratureController {
 
	
	@Autowired
    LiteratureService literatureDAO;
	
	@Autowired
	PeminjamanService peminjamanDAO;
	  
	  
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

	        List<LiteratureModel> literatureList = literatureDAO.selectAllLiteratures ();
	        model.addAttribute ("literatures", literatureList);

	        return "viewall"; 
	    }
	  
	  @RequestMapping("/literatur/ubah/{id_literatur}")
	    public String updatePath (Model model,
	            @PathVariable(value = "id_literatur") int id_literatur)
	    {
		  LiteratureModel literature = literatureDAO.selectLiterature(id_literatur);

	        if (literature != null) { 
	            model.addAttribute ("literature", literature);
	            
	            return "form-update";
	        } else {
	            model.addAttribute ("id", id_literatur);
	            return "not-found";
	        }
	    }
	  
	  @PostMapping(value = "/literatur/ubah/submit")
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
	  
	  @RequestMapping(value = "/literature/hapus/{id_literatur}", method = RequestMethod.GET)
	  public String delete(Model model, @PathVariable(value = "id_literatur") Integer id ) {
		  literatureDAO.deleteLiterature(id);
		  
		  List<LiteratureModel> literature = literatureDAO.selectAllLiteratures ();
	        model.addAttribute ("literatures", literature);

	        return "viewall"; 
	  }
	  
	  @RequestMapping (value ="/literatur/view/{id}")
	  public String detailLiterature(Model model, @PathVariable Optional <Integer> id) {
		  if(id.isPresent()) {
			LiteratureModel literature=literatureDAO.selectLiterature(id.get());   
			if(id==null) {
				model.addAttribute("id",id.get());
				return "not-found";	
			}else {
				List<PeminjamanModel> listPeminjaman = peminjamanDAO.selectPeminjamanByIdLiteratur(literature.getId());
	        	
	        	int totalAvailable = Integer.parseInt(literature.getJumlah()) - listPeminjaman.size();
	        	String jmlString = Integer.toString(totalAvailable);
	        	literature.setJumlah(jmlString);
				model.addAttribute ("literature", literature);
				return "view-literatur";
			}
		  }else {
			  model.addAttribute("id","");
			  return "not-found";
		  }
	  }

	  
	  
 
	 
}
