package com.siperpus.service;

import java.util.List; 
import com.siperpus.model.PeminjamanModel;
   
public interface PeminjamanService { 

	 List<PeminjamanModel> selectAllPeminjaman();
	 
	 void addPeminjaman (PeminjamanModel peminjaman);
	PeminjamanModel selectPeminjaman (Integer id_literatur); 
	 void updatePeminjaman  (PeminjamanModel peminjaman);
	  
	 void deletePeminjaman (Integer id);  
	 void updateStatusPeminjaman (PeminjamanModel peminjaman);
	 
	 boolean isPeminjamanOverdue(String user_account);
}
