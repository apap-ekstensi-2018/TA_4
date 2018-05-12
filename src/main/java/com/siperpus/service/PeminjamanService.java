package com.siperpus.service;

import java.util.List;
<<<<<<< HEAD
 
import com.siperpus.model.PeminjamanModel;

public interface PeminjamanService {
	 List<PeminjamanModel> selectAllPeminjaman();
	 
	 void addPeminjaman (PeminjamanModel peminjaman);
	 
	 PeminjamanModel selectPeminjaman (Integer id);
=======


import com.siperpus.model.PeminjamanModel;

import com.siperpus.model.LiteratureModel;


public interface PeminjamanService {
	 List<LiteratureModel> selectAllLiteratures ();
	 
	 void addLiterature (LiteratureModel literature);
	 PeminjamanModel selectPeminjaman (Integer id);
	 LiteratureModel selectLiterature (Integer id);
>>>>>>> f6c0cd2b75d131f70c7ec6c5069e37bdd41d857e
	 
	 void updatePeminjaman  (PeminjamanModel peminjaman);
	 
<<<<<<< HEAD
	 void deletePeminjaman (Integer id);
=======
	 void deleteLiterature (Integer id);

>>>>>>> f6c0cd2b75d131f70c7ec6c5069e37bdd41d857e
	 
}
