package com.siperpus.service;

import java.util.List; 
import com.siperpus.model.PeminjamanModel;
   
public interface PeminjamanService { 

	 List<PeminjamanModel> selectAllPeminjaman();
	 
	 void addPeminjaman (PeminjamanModel peminjaman);
	PeminjamanModel selectPeminjaman (Integer id); 
	 void updatePeminjaman  (PeminjamanModel peminjaman);
	  
	 void deletePeminjaman (Integer id);  
	 void updateStatusPeminjaman (PeminjamanModel peminjaman);
	 
}
