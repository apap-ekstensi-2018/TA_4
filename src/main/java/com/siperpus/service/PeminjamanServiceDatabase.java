package com.siperpus.service;
 
import org.springframework.stereotype.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.siperpus.model.LiteratureModel;
<<<<<<< HEAD
=======

>>>>>>> f6c0cd2b75d131f70c7ec6c5069e37bdd41d857e
import com.siperpus.model.PeminjamanModel;
import com.siperpus.service.PeminjamanServiceDatabase;
import com.siperpus.dao.LiteraturMapper;
import com.siperpus.dao.PeminjamanMapper;
<<<<<<< HEAD
=======

import com.siperpus.service.PeminjamanServiceDatabase;
import com.siperpus.dao.LiteraturMapper;

>>>>>>> f6c0cd2b75d131f70c7ec6c5069e37bdd41d857e

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PeminjamanServiceDatabase implements PeminjamanService {
<<<<<<< HEAD
=======

	@Autowired
	PeminjamanMapper peminjamanMapper;
	
	

	@Override
	 public PeminjamanModel selectPeminjaman (Integer id)
	 {
	       log.info ("select peminjaman with id: " + id);
	      return  peminjamanMapper.selectPeminjaman(id);
	 }
	
	 

>>>>>>> f6c0cd2b75d131f70c7ec6c5069e37bdd41d857e
	
	 
	 @Autowired
	    private PeminjamanMapper peminjamanMapper;
	 
	 @Override
	    public List<PeminjamanModel> selectAllPeminjaman()
	    {
	        log.info ("select all peminjaman");
	        return peminjamanMapper.selectAllPeminjaman();
	    }
	 
	 @Override
	 public PeminjamanModel selectPeminjaman (Integer id)
	 {
	       log.info ("select literature with id: " + id);
	      return  peminjamanMapper.selectPeminjaman(id);
	 }

	 @Override
	 public void addPeminjaman (PeminjamanModel peminjaman)
	 {
		 log.info ("peminjaman with id " + peminjaman.getId ()
	     + "successfully added.");
		 peminjamanMapper.addPeminjaman(peminjaman);
	 }

	 @Override
	 public void updatePeminjaman (PeminjamanModel peminjaman)
	 {
		 log.info ("peminjaman with id " + peminjaman.getId()
	     + "successfully update.");
		 peminjamanMapper.updatePeminjaman(peminjaman);
	 }

	@Override
	public void deletePeminjaman(Integer id) {
		log.info ("Peminjaman with id" + id 
				+ "succesfully deleted.");
		peminjamanMapper.deletePeminjaman(id);
		
	}
<<<<<<< HEAD
=======

>>>>>>> f6c0cd2b75d131f70c7ec6c5069e37bdd41d857e

}
