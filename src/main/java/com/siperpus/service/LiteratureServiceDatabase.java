package com.siperpus.service;
 
import org.springframework.stereotype.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.siperpus.model.LiteratureModel;
import com.siperpus.model.PengadaanLiteraturModel;
import com.siperpus.service.LiteratureServiceDatabase;
import com.siperpus.dao.LiteraturMapper;
import com.siperpus.dao.PengadaanLiteraturMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class LiteratureServiceDatabase implements LiteratureService {
	
	 
	 @Autowired
	    private LiteraturMapper literaturMapper;
	 
	 @Autowired
	 private PengadaanLiteraturMapper pengadaanMapper;
	 
	 @Override
	    public List<LiteratureModel> selectAllLiteratures()
	    {
	        log.info ("select all Literatures");
	        return literaturMapper.selectAllLiteratures();
	    }
	 
	 @Override
	 public LiteratureModel selectLiterature (Integer id)
	 {
	       log.info ("select literature with id: " + id);
	      return  literaturMapper.selectLiterature(id);
	 }

	 @Override
	 public void addLiterature (LiteratureModel literature)
	 {
		 log.info ("Literature with id " + literature.getId ()
	     + "successfully added.");
		 literaturMapper.addLiterature (literature);
	 }

	 @Override
	 public void updateLiterature (LiteratureModel literature)
	 {
		 log.info ("Literature with id " + literature.getId()
	     + "successfully update.");
		 literaturMapper.updateLiterature (literature);
	 }

	@Override
	public void deleteLiterature(Integer id) {
		log.info ("Literature with id" + id 
				+ "succesfully deleted.");
		literaturMapper.deleteLiterature(id);
		
	}
	
	@Override
	public List<LiteratureModel> selectAllLiteraturesBySearchJenis(LiteratureModel literature){
		return literaturMapper.selectAllLiteraturesBySearchJenis(literature);
	}
	
	@Override
	public List<LiteratureModel> selectAllLiteraturesBySearch(LiteratureModel literature){
		return literaturMapper.selectAllLiteraturesBySearch(literature);
	}

	@Override
	public void addPengadaanLiterature (PengadaanLiteraturModel pengadaanLiteratur) {
		pengadaanMapper.addLiterature(pengadaanLiteratur);
		
	}
}
