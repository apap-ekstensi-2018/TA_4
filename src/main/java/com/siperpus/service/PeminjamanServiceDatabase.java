package com.siperpus.service;
 
import org.springframework.stereotype.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.siperpus.model.LiteratureModel;
import com.siperpus.model.PeminjamanModel;
import com.siperpus.service.PeminjamanServiceDatabase;
import com.siperpus.dao.LiteraturMapper;
import com.siperpus.dao.PeminjamanMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PeminjamanServiceDatabase implements PeminjamanService {
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
	
	 

}
