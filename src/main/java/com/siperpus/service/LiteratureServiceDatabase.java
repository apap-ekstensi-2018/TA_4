package com.siperpus.service;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;
import org.springframework.stereotype.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.siperpus.model.LiteratureModel;
import com.siperpus.service.LiteratureServiceDatabase;
import com.siperpus.dao.MahasiswaMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class LiteratureServiceDatabase implements LiteratureService {
	
	public LiteratureServiceDatabase() {}
	
	public LiteratureServiceDatabase(MahasiswaMapper mahasiswaMapper) {
		this.mahasiswaMapper = mahasiswaMapper;
	}
	
	 @Autowired
	    private MahasiswaMapper mahasiswaMapper;
	 
	 @Override
	    public List<LiteratureModel> selectAllLiteratures()
	    {
	        log.info ("select all Literatures");
	        return mahasiswaMapper.selectAllLiteratures();
	    }
	 
	 @Override
	 public void selectLiterature (Integer id)
	 {
	       log.info ("select literature with id: " + id);
	       mahasiswaMapper.selectLiterature(id);
	 }

	 @Override
	 public void addLiterature (LiteratureModel literature)
	 {
		 log.info ("Literature with id " + literature.getId ()
	     + "successfully added.");
	     mahasiswaMapper.addLiterature (literature);
	 }

	 @Override
	 public void updateLiterature (Integer id)
	 {
		 log.info ("Literature with id " + id
	     + "successfully update.");
		 mahasiswaMapper.updateLiterature (id);
	 }

	@Override
	public void deleteLiterature(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
