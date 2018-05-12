package com.siperpus.controller;

<<<<<<< HEAD
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

=======
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
import com.siperpus.model.MahasiswaModel;

@Controller
public class PeminjamanController {
 
	
	@Autowired
    LiteratureService literatureDAO;
	
	  
	  
	  @RequestMapping("/peminjaman/viewall")
	    public String view (Model model)
	    {
	        List<LiteratureModel> literature = literatureDAO.selectAllLiteratures ();
	        model.addAttribute ("literatures", literature);

	        return "viewall";
	    }
	  
	  @RequestMapping("/peminjaman/add")
	    public String add ()
	    {
	        return "form-add";
	    }
	  
	  @RequestMapping(value = "/peminjaman/add/submit", method = RequestMethod.POST)
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
	  
	  @RequestMapping("/peminjaman/ubah/{id_literatur}")
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
>>>>>>> 23f695539d594836ba4a2900ec3e59525d761d94

	  
	  
 
	 
}
