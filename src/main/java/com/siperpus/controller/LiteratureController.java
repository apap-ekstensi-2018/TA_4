package com.siperpus.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.siperpus.service.LiteratureService;
import com.siperpus.service.PeminjamanService;
import com.siperpus.model.LiteratureModel;
import com.siperpus.model.PeminjamanModel;
import com.siperpus.model.PengadaanLiteraturModel;


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

	  
	  @RequestMapping("/literatur/cari")
	    public String cari ()
	    {
	        return "form-cari-literatur";
	    }
 
	  @RequestMapping(value = "/literatur/cari/submit", method = RequestMethod.POST)
	    public String cariSubmit (Model model,
	            @RequestParam(value = "judul", required = false) String judul,
	            @RequestParam(value = "penulis", required = false) String penulis,
	            @RequestParam(value = "penerbit", required = false) String penerbit,
	            @RequestParam(value = "jenis_literatur", required = false) String jenis_literatur)
	    {
	        LiteratureModel literature = new LiteratureModel ();
	        literature.setJudul("%"+judul+"%");
	        literature.setPenulis("%"+penulis+"%");
	        literature.setPenerbit("%"+penerbit+"%");
	        literature.setJenis_literatur(jenis_literatur);
	         
	        if (jenis_literatur.isEmpty()) {
	        	List<LiteratureModel> literatureList = literatureDAO.selectAllLiteraturesBySearch(literature);
		        model.addAttribute ("literatures", literatureList);
	        }
	        else {
	        	List<LiteratureModel> literatureList = literatureDAO.selectAllLiteraturesBySearchJenis(literature);
		        model.addAttribute ("literatures", literatureList);
	        }
	        //literatureDAO.addLiterature (literature);

	        

	        return "viewall"; 
	    }
	  
	  @RequestMapping("/literatur/upload")
	    public String upload()
	    {
	        return "form-upload";
	    }
	  
	//Save the uploaded file to this folder
	    private static String UPLOADED_FOLDER = "\\META-INF.resources\\upload\\"; //"F://temp//";
	    
	  @RequestMapping(value = "/literatur/upload/submit", method = RequestMethod.POST)
	    public String uploadSubmit (Model model,
	            @RequestParam(value = "judul", required = false) String judul,
	            @RequestParam(value = "penulis", required = false) String penulis,
	            @RequestParam(value = "penerbit", required = false) String penerbit,
	            @RequestParam("file") MultipartFile file)
	    {
		  	if (file.isEmpty()) {
	            //redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
	            return "failed-upload";
	        }
		  	
		  	 try {

		            // Get the file and save it somewhere
		            byte[] bytes = file.getBytes();
		            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
		            System.out.println(path);
		            Files.write(path, bytes);

		            PengadaanLiteraturModel literature = new PengadaanLiteraturModel ();
			        literature.setJudul(judul);
			        literature.setPenulis(penulis);
			        literature.setPenerbit(penerbit);
			        literature.setFilename(file.getOriginalFilename());
			        literature.setStatus("Request");
			        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

			        String userName = auth.getName();
			        literature.setUsername_requester(userName);
			        
			        literatureDAO.addPengadaanLiterature(literature);
			        
		            return "success-upload"; 

		        } catch (IOException e) {
		            e.printStackTrace();
		        }

	       
	        
	         
	        
	        

	        return "success-upload"; 
	    }
}
