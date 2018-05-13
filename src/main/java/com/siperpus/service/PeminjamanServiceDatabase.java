package com.siperpus.service;
 
import org.springframework.stereotype.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
 
import com.siperpus.model.PeminjamanModel;
import com.siperpus.model.SuratModel;
import com.siperpus.service.PeminjamanServiceDatabase; 
import com.siperpus.dao.PeminjamanMapper;
import com.siperpus.dao.SuratDAO;
import com.siperpus.service.PeminjamanServiceDatabase; 
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PeminjamanServiceDatabase implements PeminjamanService {
 
	@Autowired
	PeminjamanMapper peminjamanMapper;
	
	@Autowired
	SuratDAO suratDao;

	@Override
	 public PeminjamanModel selectPeminjaman (Integer id_literatur)
	 {
	       log.info ("select peminjaman with id_literatur: " + id_literatur);
	      return  peminjamanMapper.selectPeminjaman(id_literatur);
	 }  
	 @Override
	    public List<PeminjamanModel> selectAllPeminjaman()
	    {
	        log.info ("select all peminjaman");
	        return peminjamanMapper.selectAllPeminjaman();
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
	
	@Override
	 public void updateStatusPeminjaman (PeminjamanModel peminjaman)
	 {
		 log.info ("Peminjaman with id " + peminjaman.getId()
	     + "successfully update.");
		 peminjamanMapper.updateStatusPeminjaman(peminjaman);
	 }

	@Override	
	public   boolean isPeminjamanOverdue(String user_account) {
		List<PeminjamanModel> listPeminjamanOverdue = peminjamanMapper.selectPeminjamanByUserAccountAndStatus(user_account, "Overdue");
		
		if (listPeminjamanOverdue.size() > 0)
		{
			return true;
		}
		else {
			return false;
		} 
	}
	
	@Override
	public 	 SuratModel selectSurat(int no_surat) {
		return suratDao.selectSurat(no_surat);
		
	}
	
	@Override
	public 	 List<PeminjamanModel> selectPeminjamanByIdLiteratur(int id_literatur){
	return peminjamanMapper.selectPeminjamanByIdLiteraturList(id_literatur);
	
	}
	
}
