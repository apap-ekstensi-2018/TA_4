package com.siperpus.service;
 
import org.springframework.stereotype.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.siperpus.model.LiteratureModel;
import com.siperpus.service.LiteratureServiceDatabase;
import com.siperpus.dao.LiteraturMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class LiteratureServiceDatabase implements LiteratureService {
	
	 
	 @Autowired
	    private LiteraturMapper literaturMapper;
	 
	 @Override
	    public List<LiteratureModel> selectAllLiteratures()
	    {
	        log.info ("select all Literatures");
	        return literaturMapper.selectAllLiteratures();
	    }
	 
	 @Override
	 public void selectLiterature (Integer id)
	 {
	       log.info ("select literature with id: " + id);
	       literaturMapper.selectLiterature(id);
	 }

	 @Override
	 public void addLiterature (LiteratureModel literature)
	 {
		 log.info ("Literature with id " + literature.getId ()
	     + "successfully added.");
		 literaturMapper.addLiterature (literature);
	 }

	 @Override
	 public void updateLiterature (Integer id)
	 {
		 log.info ("Literature with id " + id
	     + "successfully update.");
		 literaturMapper.updateLiterature (id);
	 }

	@Override
	public void deleteLiterature(Integer id) {
		log.info ("Literature with id" + id 
				+ "succesfully deleted.");
		literaturMapper.deleteLiterature(id);
		
	}

}
