package com.siperpus.service;
 
import org.springframework.stereotype.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.siperpus.model.LiteratureModel;
<<<<<<< HEAD
import com.siperpus.model.PeminjamanModel;
import com.siperpus.service.PeminjamanServiceDatabase;
import com.siperpus.dao.LiteraturMapper;
import com.siperpus.dao.PeminjamanMapper;
=======
import com.siperpus.service.PeminjamanServiceDatabase;
import com.siperpus.dao.LiteraturMapper;
>>>>>>> 23f695539d594836ba4a2900ec3e59525d761d94

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PeminjamanServiceDatabase implements PeminjamanService {
<<<<<<< HEAD
	@Autowired
	PeminjamanMapper peminjamanMapper;
	
	@Override
	public List<PeminjamanModel> selectAllPeminjaman() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	 public PeminjamanModel selectPeminjaman (Integer id)
	 {
	       log.info ("select peminjaman with id: " + id);
	      return  peminjamanMapper.selectPeminjaman(id);
	 }
	
	 
=======
	
	 
	 @Autowired
	    private LiteraturMapper literaturMapper;
	 
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
>>>>>>> 23f695539d594836ba4a2900ec3e59525d761d94

}
