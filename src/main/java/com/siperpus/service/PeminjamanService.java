package com.siperpus.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.siperpus.model.PeminjamanModel;
import com.siperpus.model.SuratModel;
   
public interface PeminjamanService { 

	 List<PeminjamanModel> selectAllPeminjaman();
	 List<PeminjamanModel> selectPeminjamanByIdLiteratur(int id_literatur);
	 
	 
	 void addPeminjaman (PeminjamanModel peminjaman);
	PeminjamanModel selectPeminjaman (Integer id_literatur); 
	 void updatePeminjaman  (PeminjamanModel peminjaman);
	  
	 void deletePeminjaman (Integer id);  
	 void updateStatusPeminjaman (PeminjamanModel peminjaman);
	 
	 boolean isPeminjamanOverdue(String user_account);
	 
	 SuratModel selectSurat(int no_surat);
	 List<PeminjamanModel> selectPeminjamanByUserPeminjam (String username_peminjam);  
}
