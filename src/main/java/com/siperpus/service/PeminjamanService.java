package com.siperpus.service;

import java.util.List;

import com.siperpus.model.PeminjamanModel;

public interface PeminjamanService {
	 
	List<PeminjamanModel> selectAllPeminjaman ();
	
	PeminjamanModel selectPeminjaman (Integer id);

	
	 
}
