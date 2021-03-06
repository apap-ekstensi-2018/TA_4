package com.siperpus.controller;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.siperpus.service.PeminjamanService;
import com.siperpus.service.UserAccountService;

import lombok.extern.slf4j.Slf4j;
import com.siperpus.model.PeminjamanModel;
import com.siperpus.model.SuratModel;
import com.siperpus.model.UserAccountModel;

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
	  
	@Autowired
    LiteratureService literatureDAO;
	
	@Autowired
	UserAccountService userAccountSvc;
	
	  @RequestMapping("/peminjaman/viewall")
	    public String view (Model model)
	    {
		  // check role user login
		  Authentication auth = SecurityContextHolder.getContext().getAuthentication();

	        String userName = auth.getName();
	        UserAccountModel userModel = userAccountSvc.selectUserAccount(userName);
	        
	        // if staff, show all
	        if (userModel != null) {
	        	if (userModel.getRole().equals("ROLE_STAF")) {
	        		// show all
	        		List<PeminjamanModel> peminjaman = peminjamanDAO.selectAllPeminjaman();
	       	        model.addAttribute ("peminjaman", peminjaman);
	        	}
	        	else {
	        		// show by login user
	        		List<PeminjamanModel> peminjaman = peminjamanDAO.selectPeminjamanByUserPeminjam(userName);
	       	        model.addAttribute ("peminjaman", peminjaman);
	        	}
	        }
	     

	        return "viewall-peminjaman";
	    }
	  
	  @RequestMapping("/peminjaman/tambah")
	    public String add (Model model)
	    {
		  List<LiteratureModel> literature = literatureDAO.selectAllLiteratures ();
	        model.addAttribute ("literatures", literature);
	        return "form-add-peminjaman";
	    }
	  
	  @RequestMapping(value = "/peminjaman/tambah/submit", method = RequestMethod.POST)
	    public String addSubmit (Model model,
	            @RequestParam(value = "id_literatur", required = true) int id_literatur,
	            @RequestParam(value = "tanggal_peminjaman", required = true) String tanggal_peminjaman,
	            @RequestParam(value = "tanggal_pengembalian", required = true) String tanggal_pengembalian,
	            @RequestParam(value = "id_surat", required = false) int id_surat)
	    {
	        PeminjamanModel modelNew = new PeminjamanModel();
	        
	        // check availability if type skripsi/tesis/disertasi
	        LiteratureModel modelLiteratur = literatureDAO.selectLiterature(id_literatur);
	        
	        if (modelLiteratur!=null) {
	        	// check available jumlah
	        	List<PeminjamanModel> listPeminjaman = peminjamanDAO.selectPeminjamanByIdLiteratur(modelLiteratur.getId());
	        	
	        	int totalAvailable = Integer.parseInt(modelLiteratur.getJumlah()) - listPeminjaman.size();
	        	
	        	if (totalAvailable > 0) {
	        		// valid to request
	        		// check literature type
		        	if (modelLiteratur.getJenis_literatur().equals("Skripsi")||modelLiteratur.getJenis_literatur().equals("Tesis")
		        			||modelLiteratur.getJenis_literatur().equals("Disertasi")) {
		        		// validate id surat
		        		SuratModel suratModel = peminjamanDAO.selectSurat(id_surat);
		        		
		        		if (!suratModel.getStatus_surat().equals("Selesai")) {
		        			model.addAttribute("error", "Status surat belum disetujui");
			        		
		        			return "failed-peminjaman";
		        		}
		        	}
		        	 
		        	  modelNew.setId_literatur(id_literatur);
		  	        modelNew.setTanggal_peminjaman(tanggal_peminjaman);
		  	        modelNew.setTanggal_pengembalian(tanggal_pengembalian);
		  	        modelNew.setStatus_peminjaman("Belum Diproses");
		  	        modelNew.setId_surat(id_surat);
		  	        
		  	        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		  	        String userName = auth.getName();
		  	        modelNew.setUsername_peminjam(userName);
		  	         System.out.println("Model peminjaman" + modelNew);
		  	         
		  	        peminjamanDAO.addPeminjaman(modelNew);
		  	        
		  	        return "success-add-peminjaman"; 
	        	}
	        	else {
	        		model.addAttribute("error", "Literatur sudah tidak available");
	        		
	        		return "success-add-peminjaman"; 
	        	}
	        	
	        }
	        else {
	        	model.addAttribute("error", "Literatur tidak ditemukan");
        		
	        	return "failed-peminjaman";
	        }
	      
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
	            @RequestParam(value = "id_literatur", required = false) int id_literatur)
	    {
	        PeminjamanModel peminjaman = peminjamanDAO.selectPeminjaman(id_literatur);

	        if (peminjaman != null) {
	            model.addAttribute ("peminjaman",peminjaman);
	            return "view";
	        } else {
	            model.addAttribute ("id_literatur",id_literatur);
	            return "not-found";
	        }
	    }


	    @RequestMapping("/peminjaman/view/{id_literatur}")
	    public String viewPath (Model model,
	            @PathVariable(value = "id_literatur") int id_literatur)
	    {
	    	
	        PeminjamanModel peminjaman = peminjamanDAO.selectPeminjaman(id_literatur);
	        List<PeminjamanModel> peminjamanlist = peminjamanDAO.selectPeminjamanByIdLiteratur(id_literatur);
	        
	        if (peminjaman != null) {
	            model.addAttribute ("peminjaman", peminjaman);
	            model.addAttribute ("peminjamanlist", peminjamanlist);
	            return "view";
	        } else {
	            model.addAttribute ("id_literatur", id_literatur);
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
